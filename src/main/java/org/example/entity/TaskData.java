package org.example.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }
    public Set<Task> getTasks(String taskName){
        switch (taskName){
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                Set<Task> allTasks = new HashSet<>();
                allTasks.addAll(annsTasks);
                allTasks.addAll(bobsTasks);
                allTasks.addAll(carolsTasks);
                return allTasks;
        }
        return null;
    }
    public Set<Task> getUnion(Set<Task>... taskLists){
        Set<Task> allT = new HashSet<>();
        for(Set<Task> x : taskLists){
            allT.addAll(x);
        }
        return allT;
    }
    public Set<Task> getIntersection(Set<Task> task1,Set<Task> task2){
        Set<Task> intersect = new HashSet<>(task1);
        intersect.retainAll(task2);
        return intersect;
    }
    public Set<Task> getDifferences(Set<Task> task1,Set<Task> task2){
        Set<Task> diff = new HashSet<>(task1);
        diff.removeAll(task2);
        return diff;
    }
}
