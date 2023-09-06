package com.lwx.service;

import com.lwx.pojo.Score;
import com.lwx.untils.PageBean;

public interface ScoreService {
	
	public Score queryScoreById(Score score);

	public PageBean<Score> findByPage(int currentPage,String id);

	public int addScoreInfo(Score score);

	public int updateScoreInfo(Score score);

	public int deleteScoreInfoById(String id);

}
