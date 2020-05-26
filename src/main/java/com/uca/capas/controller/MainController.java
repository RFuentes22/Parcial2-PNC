package com.uca.capas.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Categoria;

import com.uca.capas.domain.Libro;
import com.uca.capas.service.CategoriaService;
import com.uca.capas.service.LibroService;

@Controller
public class MainController {

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private LibroService libroService;

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("index");
		return mav;
	}

	@RequestMapping("/addCategory")
	public ModelAndView insert(@Valid @ModelAttribute Categoria categoria, BindingResult result) throws ParseException {
		ModelAndView mav = new ModelAndView();
	

		if (result.hasErrors()) {
			mav.addObject("categoria", categoria);
			mav.setViewName("addCategoria");
		} else {
			categoriaService.save(categoria);
			mav.addObject("resultado", 1);
			mav.setViewName("index");
		}

		return mav;

	}

	@RequestMapping("/addLibro")
	public ModelAndView insert(@Valid @ModelAttribute Libro libro, BindingResult result) throws ParseException {
		ModelAndView mav = new ModelAndView();
		//date
		long millis=System.currentTimeMillis();  
		Timestamp sdate=new java.sql.Timestamp(millis);  
				

		mav.addObject("categorias", listCategorias());
		
		if (result.hasErrors()) {
			mav.addObject("libro", libro);
			mav.setViewName("addLibro");
		} else {
			libro.setFingreso(sdate);
			libroService.save(libro);
			mav.addObject("resultado", 2);
			mav.setViewName("index");
		}

		
		return mav;

	}
	
	// Show list
	@RequestMapping(value = "/listado")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		List<Libro> listLibro = libroService.findAll();
		
		try {
			listLibro = libroService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("libros", listLibro);
		mav.setViewName("lista");

		return mav;

	}

	public List<Categoria> listCategorias() {

		Categoria categoria = new Categoria();
		List<Categoria> listCategorias = null;

		try {
			listCategorias = categoriaService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listCategorias;
	}

}
