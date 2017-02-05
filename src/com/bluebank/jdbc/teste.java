package com.bluebank.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class teste {
	public static void main(String[] args) throws SQLException {
		  
          Connection conn = ConnectionFactory.getConnection();
          System.err.println("Conectou");
          
          
          CallableStatement psmt = conn.prepareCall("{call sp_tranf_cc(?,?,?,?,?,?,?,?)}");
          psmt.setFloat("p_num_ag_org", 234);
          psmt.setFloat("p_num_cc_org", 564);
          psmt.setFloat("p_num_ag_dest", 456);
          psmt.setFloat("p_num_cc_dest", 349);
          psmt.setFloat("p_valor", 400);
          psmt.setString("p_tipo", "D");
          
          psmt.registerOutParameter("p_ok", Types.VARCHAR);
          psmt.registerOutParameter("p_retorno", Types.VARCHAR);
          
          psmt.executeUpdate();
          conn.commit();
          
          System.err.println("Retorno" + psmt.getString("p_retorno"));
          System.err.println("v_ok" + psmt.getString("p_ok"));
          
          conn.close();
	}
}
