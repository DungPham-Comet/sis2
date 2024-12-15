package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.model.Siyo;
import main.util.DatabaseConnection;

public class SiyoDAO {
	
	public List<Siyo> getAllSiyo(){
		String SELECT_QUERY = "SELECT * FROM iv_siyo";
		List<Siyo> siyos = new ArrayList<>();
		Connection conn;
		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(SELECT_QUERY);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Siyo siyo = new Siyo(rs.getInt("SIYO_ID"), rs.getString("KOUJI_NUM"), rs.getString("SHOHIN_CD"));
				siyos.add(siyo);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return siyos;
	}
	
	public List<Siyo> getSiyoByShohinCode(String shohinCode){
		String SELECT_QUERY = "SELECT * FROM iv_siyo WHERE SHOHIN_CD = ?";
        List<Siyo> siyos = new ArrayList<>();
        Connection conn;
        try {
            conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_QUERY);
            ps.setString(1, shohinCode);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Siyo siyo = new Siyo(rs.getInt("SIYO_ID"), rs.getString("KOUJI_NUM"), rs.getString("SHOHIN_CD"));
                siyos.add(siyo);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return siyos;
	}
	
	public Map<Integer, Integer> finalResult(List<Integer> siyo_ids, List<String> juto_codes){
      String SELECT_QUERY = """
      SELECT SIYO_ID, SUM(WEIGHTING) AS POINT
      FROM iv_sych JOIN iv_juto_weight ON iv_sych.JUTO_CD = iv_juto_weight.JUTO_CD
      WHERE iv_sych.SIYO_ID IN (?) AND iv_sych.JUTO_CD IN (?)
      GROUP BY SIYO_ID;
      """;
      Map<Integer, Integer> results = new HashMap<>();
      Connection conn;
      
      String siyo_ids_str = "";
      for (int siyo_id : siyo_ids) {
    	  siyo_ids_str += siyo_id + ",";
      }
      siyo_ids_str = siyo_ids_str.substring(0, siyo_ids_str.length() - 1);
      
      try {
    	  conn = DatabaseConnection.getConnection();
    	  PreparedStatement ps = conn.prepareStatement(SELECT_QUERY);
    	  ps.setString(1, siyo_ids_str);
    	  ps.setString(2, String.join(",", juto_codes));
    	  ResultSet rs = ps.executeQuery();
    	  while (rs.next()) {
    		  results.put(rs.getInt("SIYO_ID"), rs.getInt("POINT"));
			}
    	  conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
      
      return results;
	}
	
}
