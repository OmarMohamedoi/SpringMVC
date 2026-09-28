package org.example.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class TaskRepository {

    private final Map<Long, Task> store = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong();

    public TaskRepository(){

        save(new Task(null, "Buy milk", "LOW", false));
        save(new Task(null, "Finish slides", "HIGH", false));
        save(new Task(null, "Review PR", "MEDIUM", true));
    }

    public List<Task> findAll(){
        return new ArrayList<>(store.values());
    }

    public List<Task> findByPriority(String priority){
    return store.values().stream().filter(task -> task.getPriority()
            .equalsIgnoreCase(priority))
            .toList();

    }

    public Optional<Task> findById(Long id){

                Optional<Task> task = Optional.ofNullable(store.getOrDefault(id, null));
                return task;
    }

    public Task save(Task task){
        if(task.getId()==null){
            task.setId(sequence.incrementAndGet());
        }
        store.put(task.getId(), task);
        return task;
    }
}
