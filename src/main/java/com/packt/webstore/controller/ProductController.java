package com.packt.webstore.controller;
import java.io.File;


import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.packt.webstore.domain.Product;
import com.packt.webstore.exception.NoProductsFoundUnderCategoryException;
import com.packt.webstore.exception.ProductNotFoundException;
import com.packt.webstore.services.ProductService;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@RequestMapping("/market")
public class ProductController {

	@Autowired
	private ProductService productService;

	@InitBinder 
	public void initialiseBinder(WebDataBinder binder){ 
		binder.setAllowedFields("productId",
				"name", 
				"unitPrice", 
				"description", 
				"manufacturer", 
				"category", 
				"unitsInStock", 
				"condition",
				"productImage",
				"userManual"
				);

	}

	@RequestMapping("/products") 
	public String list(Model model) {  

		model.addAttribute("products", productService.getAllProducts()); 

		return "products";
	}

	@RequestMapping("/products/{category}") 
	public String listByCategorty(Model model, @PathVariable("category") String productCategory) {  

		List<Product> productsList=productService.getProductsByCategory(productCategory);
//		if (productsList == null || productsList.isEmpty()) {
//
//			System.out.println("test:categorty doesnot exists");
//			throw new NoProductsFoundUnderCategoryException();
//
//		}

		model.addAttribute("products",productsList ); 

		return "products";
	}

	@RequestMapping("/update/stock")
	public String updateStock(Model model) {

		productService.updateAllStocks();
		return "redirect:/market/products";
	}

	@RequestMapping("/products/filter/{params}") 
	public String getProductsByFilter(@MatrixVariable(pathVar="params") Map<String,List<String>> filterParams, Model model) {

		model.addAttribute("products",

				productService.getProductsByFilter(filterParams));

		return "products"; 

	}

	@RequestMapping("/product") 
	public String getProductById(@RequestParam("id") String productId, Model model) {

		model.addAttribute("product",productService.getProductById(productId)); 

		return "product";

	}

	@RequestMapping(value = "/products/add", method = RequestMethod.GET) 
	public String getAddNewProductForm(@ModelAttribute("newProduct") Product product) {


		return "addProduct"; 

	} 

	@RequestMapping(value = "/products/add", method =RequestMethod.POST) 
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product product ,BindingResult result, HttpServletRequest request) {
		String[] suppressedFields = result.getSuppressedFields(); 
		if (suppressedFields.length > 0){ 
			throw new RuntimeException("Attempting to bind disallowed fields: " 
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}

		MultipartFile productImage = product.getProductImage();
		MultipartFile userManual=product.getUserManual();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");

		if (productImage!=null && !productImage.isEmpty()) {

			try { 
				productImage.transferTo(new File(rootDirectory+"/resources/images/"+ product.getProductId() + ".jpg"));
			} catch (Exception e) {

				throw new RuntimeException("Product Image saving failed", e);

			}
		}

		if (userManual!=null && !userManual.isEmpty()) {

			try { 
				userManual.transferTo(new File(rootDirectory+"/resources/pdf/"+ product.getProductId() + ".pdf"));
			} catch (Exception e) {

				throw new RuntimeException("User Manual saving failed", e);

			}
		}
		productService.addProduct(product);

		return "redirect:/market/products"; 
	}

//	@ExceptionHandler(ProductNotFoundException.class) 
//	public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException exception) {
//
//		ModelAndView mav = new ModelAndView(); 
//		
//		mav.addObject("invalidProductId", exception.getProductId()); 
//		
//		mav.addObject("exception", exception); 
//		
//		mav.addObject("url", req.getRequestURL()+"?"+req.getQueryString()); 
//		
//		mav.setViewName("productNotFound"); 
//		
//		return mav;
//
//	}
	
	@ExceptionHandler(ProductNotFoundException.class) 
	public String  handleError(HttpServletRequest req, ProductNotFoundException exception,Model model) {

		 
		
		model.addAttribute("invalidProductId", exception.getProductId()); 
		
		model.addAttribute("exception", exception); 
		
		model.addAttribute("url", req.getRequestURL()+"?"+req.getQueryString()); 
		
		return"productNotFound"; 
		

	}
	
	
}
