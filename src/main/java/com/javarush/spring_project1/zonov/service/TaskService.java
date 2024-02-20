package com.javarush.spring_project1.zonov.service;

import com.javarush.spring_project1.zonov.dao.TaskDAO;
import com.javarush.spring_project1.zonov.domain.Status;
import com.javarush.spring_project1.zonov.domain.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class TaskService {
    private final TaskDAO taskDAO;

    public TaskService(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    public List<Task> getAll(int offset, int limit) {
        return taskDAO.getAll(offset, limit);
    }
    public int getAllCount() {
        return taskDAO.getAllCount();
    }

    public Task getById(int id) {
        return taskDAO.getById(id);
    }

    @Transactional
    public Task edit(int id, String description, Status status) {
        Task task = taskDAO.getById(id);

        if(isNull(task)) {
            throw new RuntimeException("Task with id " + id + " is not found");
        }

        task.setDescription(description);
        task.setStatus(status);

        taskDAO.saveOrUpdate(task);
        return task;
    }

    public Task create(String description, Status status) {
        Task task = new Task();
        task.setStatus(status);
        task.setDescription(description);

        taskDAO.saveOrUpdate(task);

        return task;
    }

    @Transactional
    public void delete (Integer id) {
        Task task = taskDAO.getById(id);;

        if(isNull(task)) {
            throw new RuntimeException("Task with id " + id + " doesn't exist");
        }

        taskDAO.delete(task);
    }
}
