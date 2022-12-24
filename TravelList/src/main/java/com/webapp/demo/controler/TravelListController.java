package com.webapp.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.demo.dao.TravelDao;
import com.webapp.demo.travellist.TravelList;



@RestController
public class TravelListController {
	@Autowired
	TravelDao dao;
	@RequestMapping("/addTravel")
	@ResponseBody
	public void addTravel(@RequestParam int id,String name,String desc,TravelList obj) {
		
		obj.setId(id);
		obj.setName(name);
		obj.setDescription(desc);
		dao.save(obj);
		
	}
	
	@RequestMapping("/getAll")
	@ResponseBody
	public List<TravelList> getAll() {
		
		return dao.findAll();
	}
	
	@RequestMapping("/listById")
	@ResponseBody
	public List<TravelList> ById(@RequestParam int id) {
		System.out.println("list by id");
		return dao.listById(id);
		
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public void updateTravel(@RequestParam int id,@RequestParam String desc) {
		
		System.out.println("travel desc updated");
		dao.update(id,desc);
		
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public void deleteList(@RequestParam int id) {
		
		System.out.println("series deleted");
		dao.deleteById(id);
		
	}

	

}
