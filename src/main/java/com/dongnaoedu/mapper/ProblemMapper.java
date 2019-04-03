package com.dongnaoedu.mapper;

import java.util.List;

import com.dongnaoedu.vo.ProblemDBVo;

public interface ProblemMapper {
	
	/**
	 * 插入题目
	 * @param ProblemDBVo
	 */
	boolean insert(ProblemDBVo problemDBVo);
	
	/**
	 * 插入题目
	 * @param ProblemDBVo
	 */
	boolean insertBatch(List<ProblemDBVo> problemDBVoList);
	
	/**
	 * 删除题目
	 * @param ProblemDBVo
	 */
	boolean delete(Integer id);
	
	/**
	 * 删除题目
	 * @param ProblemDBVo
	 */
	boolean deleteAll();
	
	/**
	 * 更新题目
	 * @param problemDBVo
	 * @return
	 */
	boolean update(ProblemDBVo problemDBVo);
	
	
	/**
	 * 根据ID查询题目
	 * @param id
	 * @return
	 */
	ProblemDBVo queryById(Integer id);
	

}
