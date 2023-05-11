package com.example.pp_3_1_2_springboot.dao;

import com.example.pp_3_1_2_springboot.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User,Integer> {
    @Override
    Optional<User> findById(Integer id);
    @Override
    <S extends User> S save(S entity);
    @Override
    Iterable<User> findAll();
    @Override
    void delete(User user);

    @Override
    void deleteById(Integer integer);
}
