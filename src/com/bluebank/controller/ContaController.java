package com.bluebank.controller;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.bluebank.jdbc.ConnectionFactory;

@ManagedBean(name = "contaController")
@ViewScoped
public class ContaController implements Serializable {
	private static final long serialVersionUID = 1;
	private Conta conta = new Conta();

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public void confirmarOperacao() throws SQLException {
		int ret_cod = 0;
		Connection conn = null;
		CallableStatement psmt = null;
        
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			conn = ConnectionFactory.getConnection();
			psmt = conn.prepareCall("{call sp_tranf_cc(?,?,?,?,?,?,?,?)}");

			psmt.setFloat("p_num_ag_org", conta.getNumeroAgenciaOrigem());
			psmt.setFloat("p_num_cc_org", conta.getNumeroContaOrigem());
			psmt.setFloat("p_num_ag_dest", conta.getNumeroAgenciaDestino());
			psmt.setFloat("p_num_cc_dest", conta.getNumeroContaDestino());
			psmt.setFloat("p_valor", conta.getValor());


			psmt.registerOutParameter("p_ok", Types.VARCHAR);
			psmt.registerOutParameter("p_retorno", Types.VARCHAR);

			psmt.executeUpdate();
			conn.commit();

			if (psmt.getString("p_ok") == "N"){
				context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, psmt.getString("p_retorno"),"detail..."));
			}
			
			psmt.close();
			conn.close();
			
		} catch (SQLException e) {
			ret_cod = e.getErrorCode();

			System.err.println(ret_cod + e.getMessage());
			conn.close();
		}
	}
}
