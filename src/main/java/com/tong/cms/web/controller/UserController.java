/**
 * 
 */
package com.tong.cms.web.controller;

import com.tong.cms.bean.Article;
import com.tong.cms.bean.Category;
import com.tong.cms.service.ChannelCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月10日 下午2:40:38
 */
@Controller
@RequestMapping("/my")
public class UserController {

	@Resource
	private ChannelCategoryService ccService;

	@RequestMapping({"/", "/index", "/home"})
	public String home(){
		return "user-space/home";
	}
	
	@RequestMapping({"/profile"})
	public String profile(){
		return "user-space/profile";
	}

	@RequestMapping("article/save")
	public String saveArticle(@Valid Article article, BindingResult br, MultipartFile file) {
		return "redirect:/my/home";
	}

	@RequestMapping("article/edit")
	public String articleEdit(Model model) {
		model.addAttribute("article", new Article());
		// 查询所有栏目
		model.addAttribute("channels",ccService.getChannels());
		return "user-space/article_edit";
	}

	/**
	 * 根据栏目编号查询分类
	 */
	@RequestMapping(value = "queryCategoriesById", method = RequestMethod.POST)
	@ResponseBody
	public List<Category> queryCategoryById(Integer id) {
		System.out.println("+++++++++++++++++++++++++++++++++" + id);
		return ccService.getCategories(id);
	}

}
