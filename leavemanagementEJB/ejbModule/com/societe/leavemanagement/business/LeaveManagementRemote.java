package com.societe.leavemanagement.business;

import java.util.List;

import javax.ejb.Remote;

import com.societe.leavemanagement.metier.entities.Conge;

@Remote
public interface LeaveManagementRemote {

	public List<Conge> getListCongesCollaborateur(String userName);
}
