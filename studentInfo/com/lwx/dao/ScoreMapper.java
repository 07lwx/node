package com.lwx.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.lwx.pojo.Score;

public interface ScoreMapper {
	
	// ��ȡҪ���³ɼ�����Ϣ
		public Score queryScoreById(Score score);

		// ��ѯ�ɼ�
		List<Score> findByPage(HashMap<String,Object> map);

		// ��ӳɼ�
		public int addScoreInfo(Score score);

		// ���³ɼ�
		public int updateScoreInfo(Score score);

		// ɾ���ɼ�
		public int deleteScoreInfoById(String id);
		
		//��ȡ������
		public int selectCount(@Param("id")String id);

	}
