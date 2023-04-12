/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.chris.week6ca;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author chris
 */
public class TaskTest {
    
     @Test
     public void hello() {
         System.out.println("HELLO!!!!");
         Task task = new Task("Owner", "Some description", LocalDate.now());
         System.out.println("Description is: " + task.getDescription());
         
         Assertions.assertEquals("Owner", task.getOwner());
     }
     
     @Test //validating deadline in construtor
     public void deadlineValidate() {
         Task task = new Task("Owner", "Some description", LocalDate.now());
         if (LocalDate.now().compareTo(task.getDeadline()) >= 0) {
             System.out.println("This deadline has expired");
         }
     }
}
