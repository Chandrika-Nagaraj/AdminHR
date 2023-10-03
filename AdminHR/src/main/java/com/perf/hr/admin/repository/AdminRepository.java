package com.perf.hr.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perf.hr.admin.entity.AdminLogin;
import java.util.List;


@Repository
public interface AdminRepository extends JpaRepository<AdminLogin, Integer>{
List<AdminLogin> findByAdminemail(String adminemail);
List<AdminLogin> findByAdminemailEquals(String name);
                            


}
