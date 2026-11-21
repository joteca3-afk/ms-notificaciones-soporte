package com.caviedes.notification.repository;

import com.caviedes.notification.model.LogNotificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogNotificacionRepository extends JpaRepository<LogNotificacion, Long> {
    // Hereda los métodos automáticos de persistencia para MySQL
}