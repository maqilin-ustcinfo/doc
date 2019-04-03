package com.dongnaoedu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongnaoedu.aim.EncryptTools;
import com.dongnaoedu.aim.MakeSrcDoc;
import com.dongnaoedu.aim.ProblemBank;
import com.dongnaoedu.mapper.ProblemMapper;
import com.dongnaoedu.vo.PendingDocVo;
import com.dongnaoedu.vo.ProblemDBVo;

@Controller
public class DocController {
	
	@Autowired
	ProblemMapper mapper;
	
	/**
	 * 生成离线文档
	 * @return
	 */
	@RequestMapping("/execute/{num}")
	@ResponseBody
	public String execute(@PathVariable("num") int num) {
		if(num<1) {return "文档数不对";}
		List<PendingDocVo> pendingDocVoList = MakeSrcDoc.makeDoc(num);
		for(PendingDocVo pend : pendingDocVoList) {
			// 文档下载到本地
			// we
		}
		Random r = new Random();
		int id = r.nextInt(2000);
		String content = ProblemBank.getRandomString(700);
		ProblemDBVo vo = new ProblemDBVo(id,content,EncryptTools.EncryptBySHA1(content));
		mapper.insert(vo);
		return "insert成功";
	}
	

	@RequestMapping("/queryProblemById/{id}")
	@ResponseBody
	public ProblemDBVo queryProblemById(@PathVariable("id") Integer id) {
		System.out.println("id="+id);
		return mapper.queryById(id);
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert() {
		Random r = new Random();
		int id = r.nextInt(2000);
		String content = ProblemBank.getRandomString(700);
		ProblemDBVo vo = new ProblemDBVo(id,content,EncryptTools.EncryptBySHA1(content));
		mapper.insert(vo);
		return "insert成功";
	}
	
	@RequestMapping("/insertBath/{number}")
	@ResponseBody
	public String insertBath(@PathVariable("number") int number) {
		long t1 = System.currentTimeMillis();
		if(number > 0) {
			for(int i=0;i<number;i++) {
				String content = ProblemBank.getRandomString(700);
				ProblemDBVo vo = new ProblemDBVo(i,content,EncryptTools.EncryptBySHA1(content));
				mapper.insert(vo);
			}
		}
		return "insertBath插入"+number+"条数据成功,耗时："+(System.currentTimeMillis()-t1)+"ms";
	}
	
	@RequestMapping("/insertBathNew/{number}")
	@ResponseBody
	public String insertBathNew(@PathVariable("number") int number) {
		long t1 = System.currentTimeMillis();
		List<ProblemDBVo> list = new ArrayList<ProblemDBVo>();
		if(number > 0) {
			// 分割每次插入500条
			int allowSize = 1000;
			// 批量插入的次数
			// int count = number%allowSize==0?number/allowSize:number/allowSize+1;
			// 计数器
			int index = 0;
			for(int i=0;i<number;i++) {
				if(index == allowSize) {
					mapper.insertBatch(list);
					index = 0;
					list.clear();
				}
				String content = ProblemBank.getRandomString(700);
				ProblemDBVo vo = new ProblemDBVo(i,content,EncryptTools.EncryptBySHA1(content));
				index ++;
				list.add(vo);
			}
			mapper.insertBatch(list);
		}
		return "insertBathNew插入"+number+"条数据成功,耗时："+(System.currentTimeMillis()-t1)+"ms";
	}
	
	
	@RequestMapping("/update/{id}")
	@ResponseBody
	public String update(@PathVariable("id") Integer id) {
		String content = ProblemBank.getRandomString(700);
		ProblemDBVo vo = new ProblemDBVo(id,content,EncryptTools.EncryptBySHA1(content));
		mapper.update(vo);
		return id+"：update成功";
	}
	
	

	@RequestMapping("/deleteById/{id}")
	@ResponseBody
	public String deleteById(@PathVariable("id") Integer id) {
		mapper.delete(id);
		return "删除成功:"+id;
	}
	
	@RequestMapping("/deleteAll")
	@ResponseBody
	public String deleteAll() {
		mapper.deleteAll();
		return "删除成功";
	}
	
	
}
