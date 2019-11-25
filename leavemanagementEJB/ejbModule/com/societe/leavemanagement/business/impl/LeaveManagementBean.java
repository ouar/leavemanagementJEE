package com.societe.leavemanagement.business.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.societe.leavemanagement.business.LeaveManagementRemote;
import com.societe.leavemanagement.exception.CustomException;
import com.societe.leavemanagement.metier.entities.Collaborateur;
import com.societe.leavemanagement.metier.entities.Conge;

/**
 * Session Bean implementation class LeaveManagementBean
 */
@Stateless
public class LeaveManagementBean implements LeaveManagementRemote {

	@PersistenceContext(unitName = "leaveManagementEJB")
	private EntityManager entityManager;

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<Conge> getListCongesCollaborateur(String userName) {
		try {

			Query query = entityManager.createQuery("SELECT c from Collaborateur c JOIN FETCH c.conges listconges WHERE c.utilisateur.userName=:USR_NAME", Collaborateur.class);
			query.setParameter("USR_NAME", userName);
			List<Collaborateur> listCollaborateur = query.getResultList();
			return (listCollaborateur != null && !listCollaborateur.isEmpty()) ? listCollaborateur.get(0).getConges() : null;

		} catch (CustomException e) {
			throw e;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), 500);
		}

	}

}
