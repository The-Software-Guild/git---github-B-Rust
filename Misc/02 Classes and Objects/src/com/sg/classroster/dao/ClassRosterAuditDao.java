package com.sg.classroster.dao;

import com.sg.classroster.service.ClassRosterPersistenceException;

public interface ClassRosterAuditDao {
	public void writeAuditEntry(String entry) throws ClassRosterPersistenceException;	
	
}
