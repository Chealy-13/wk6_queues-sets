/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chris.week6ca;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author chris
 */
public class Task implements Comparable<Task>{

    private String owner;
    private String description;
    private java.time.LocalDate deadline;

    public Task(String owner, String description, LocalDate deadline) {
        this.owner = owner;
        this.description = description;
        if (LocalDate.now().compareTo(deadline) >= 0) {
            throw new RuntimeException("Invalid deadline date");
        } else {
            this.deadline = deadline;
        }
    }

    public String getOwner() {
        return owner;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDeadline() {
            return deadline;
        }

    public void setOwner(String owner) {
        this.owner = owner;
        }
    

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(LocalDate deadline) {
        if (LocalDate.now().compareTo(deadline) >= 0) {
            throw new RuntimeException("Invalid deadline date");
        } else {
        this.deadline = deadline;
    }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.owner);
        hash = 47 * hash + Objects.hashCode(this.description);
        hash = 47 * hash + Objects.hashCode(this.deadline);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Task other = (Task) obj;
        if (!Objects.equals(this.owner, other.owner)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return Objects.equals(this.deadline, other.deadline);
    }

    @Override
    public String toString() {
        return "Task{" + "owner=" + owner + ", description=" + description + ", deadline=" + deadline + '}';
    }

    @Override
    public int compareTo(Task otherTask) {
        return this.deadline.compareTo(otherTask.deadline);
    }

    

}
