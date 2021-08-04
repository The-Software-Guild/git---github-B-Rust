package com.sg.classroster.dao;

import java.io.*;
import java.util.List;
import java.util.Scanner;

import com.sg.classroster.dto.Student;

public class ClassRosterDaoException extends Exception{
    
    public ClassRosterDaoException(String message) {
        super(message);
    }
    
    public ClassRosterDaoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
