package com.example.consumer.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.consumer.entity.Teacher;
import com.example.consumer.service.DemoService;
@CrossOrigin
@RestController
public class DemoController {
	@Autowired
	DemoService demoService;

	@RequestMapping(value = "/consumer")
	public String hi(@RequestParam String name) {
		return demoService.consuService(name);
	}
	/*
	 * @RequestMapping(path="/list") public String list(Model model) {
	 * List<Teacher> teachers=(List<Teacher>) demoService.teacherService();
	 * model.addAttribute("teachers", teachers); return "list";
	 * 
	 * }
	 */

	@RequestMapping(value = "/list")
	public ModelAndView test(ModelAndView mv) {
		List<Teacher> teachers = (List<Teacher>) demoService.teacherService();
		mv.setViewName("/list");
		mv.addObject("teachers", teachers);
		return mv;
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void testDownload(HttpServletResponse res, String fileName) {
		// String fileName = "upload.jpg";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		//String path = "D:/Users/YanHan/workspace-ee/consumer/src/main/resources/templates/" ;
		String path = "C:/Program Files/Tomcat/apache-tomcat-8.0.45/webapps/consumer-1/WEB-INF/classes/templates/";
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File(path + fileName)));
			int i = bis.read(buff);
			while (i != -1) {
				os.write(buff, 0, buff.length);
				os.flush();
				i = bis.read(buff);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("success");
	}

}
