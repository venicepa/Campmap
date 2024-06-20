package com.campmap.controller;



import com.campmap.database.SampleEntity;
import com.campmap.database.SampleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

  @Autowired
  private SampleRepository sampleRepository;

  @GetMapping("/queryAll")
  public List<SampleEntity> queryAll() {
    return sampleRepository.findAll();
  }

  @PostMapping("/insert")
  public SampleEntity createSample(@RequestBody SampleEntity sampleEntity) {
    return sampleRepository.save(sampleEntity);
  }

  @GetMapping("/{id}")
  public SampleEntity getSampleById(@PathVariable String id) {
    Optional<SampleEntity> sampleEntity = sampleRepository.findById(id);
    if (sampleEntity.isPresent()) {
      return sampleEntity.get();
    } else {
      throw new RuntimeException("Not Exists id, id:" + id);
    }
  }

  @DeleteMapping("/{id}")
  public void deleteSampleById(@PathVariable String id) {
    if (sampleRepository.existsById(id)) {
      sampleRepository.deleteById(id);
    } else {
      throw new RuntimeException("Not Exists id, id:" + id);
    }
  }

  @PutMapping("/{id}")
  public SampleEntity updateSample(@PathVariable String id, @RequestBody SampleEntity updatedSample) {
    return sampleRepository.findById(id).map(sample -> {
      sample.setName(updatedSample.getName());
      sample.setAge(updatedSample.getAge());
      return sampleRepository.save(sample);
    }).orElseThrow(() -> new RuntimeException("Not Exists id, id:" + id));
  }
}
