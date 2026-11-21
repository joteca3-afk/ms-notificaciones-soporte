package com.caviedes.notification.service;


import com.caviedes.notification.model.LogNotificacion;
import com.caviedes.notification.repository.LogNotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final LogNotificacionRepository repository;

    @Autowired
    public NotificationService(LogNotificacionRepository repository) {
        this.repository = repository;
    }

    public LogNotificacion registrarNotificacionManual(String destinatario, String asunto, String cuerpo, String tipoEvento) {
        System.out.println("[SMTP HTE] Despachando correo electrónico a: " + destinatario);

        LogNotificacion log = new LogNotificacion();
        log.setDestinatario(destinatario);
        log.setAsunto(asunto);
        log.setCuerpoMensaje(cuerpo);
        log.setTipoEvento(tipoEvento);

        return this.repository.save(log);
    }
}