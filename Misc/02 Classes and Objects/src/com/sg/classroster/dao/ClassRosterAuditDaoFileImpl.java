package com.sg.classroster.dao;

import com.sg.classroster.service.ClassRosterPersistenceException;
import java.io.*;
import java.time.LocalDateTime;

public class ClassRosterAuditDaoFileImpl implements ClassRosterAuditDao {

    public static final String AUDIT_FILE = "audit.txt";
    
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException {
        PrintWriter out;
       
        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new ClassRosterPersistenceException("Could not persist audit information.", e);
        }
 
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
        out.close();
    }

}
