/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.chris.week6ca;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author chris
 */
public class TaskTest {
    
     @Test
     public void constructorValid() {
         String owner = "Owner";
         String description = "Some description";
         LocalDate date = LocalDate.now().plusDays(1);
         Task task = new Task(owner, description, date);
         
         assertEquals(owner, task.getOwner());
         assertEquals(description, task.getDescription());
         assertEquals(date, task.getDeadline());
     }
     
     @Test
     public void constructorInvalid() {
         String owner = "Owner";
         String description = "Some description";
         //forcing deadline to be in past
         LocalDate date = LocalDate.now().minusDays(1);
         
         assertThrows(RuntimeException.class, () -> {
            new Task(owner, description, date);
        });
     }
     
     @Test
     public void settersValid() {
         Task task = new Task("", "", LocalDate.now().plusDays(1));
         String owner = "Owner";
         String description = "Some description";
         LocalDate date = LocalDate.now().plusDays(1);
         task.setOwner(owner);
         task.setDescription(description);
         task.setDeadline(date);
         
         
         assertEquals(owner, task.getOwner());
         assertEquals(description, task.getDescription());
         assertEquals(date, task.getDeadline());
     }
     
     @Test
     public void setDeadlineInvalid() {
         Task task = new Task("", "", LocalDate.now().plusDays(1));
         //forcing deadline to be in past

         assertThrows(RuntimeException.class, () -> {
            task.setDeadline(LocalDate.now().minusDays(1));
        });
     }
}

