package com.pragmantic.managerapi.controller;

import com.pragmantic.managerapi.entity.Project;
import com.pragmantic.managerapi.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    // get all projects
    @GetMapping
    public List<Project> getAllProjects() {
        return this.projectRepository.findAll();
    }

    // get project by id
    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable(value = "id") Integer projectId) {
        return this.projectRepository.findById(projectId)
                .orElseThrow();
    }

    // create project
    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return this.projectRepository.save(project);
    }

    // update project
    @PutMapping("/{id}")
    public Project updateProject(@RequestBody Project project, @PathVariable ("id") Integer projectId) {
        Project existingProject = this.projectRepository.findById(projectId)
                .orElseThrow();
        existingProject.setName(project.getName());
        return this.projectRepository.save(existingProject);
    }

    // delete project by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Project> deleteProject(@PathVariable ("id") Integer projectId){
        Project existingProject = this.projectRepository.findById(projectId)
                .orElseThrow();
        this.projectRepository.delete(existingProject);
        return ResponseEntity.ok().build();
    }
}
