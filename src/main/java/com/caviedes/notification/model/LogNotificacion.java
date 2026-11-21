package com.caviedes.notification.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "logs_notificaciones")
public class LogNotificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotificacion;

    @Column(nullable = false)
    private String destinatario;

    @Column(nullable = false)
    private String asunto;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String cuerpoMensaje;

    @Column(nullable = false)
    private String tipoEvento;

    private LocalDateTime fechaEnvio;
    private String estadoEnvio;

    // Constructor Manual Obligatorio para JPA
    public LogNotificacion() {
        this.fechaEnvio = LocalDateTime.now();
        this.estadoEnvio = "PROCESADO";
    }

    // --- GETTERS Y SETTERS MANUALES ---
    public Long getIdNotificacion() { return idNotificacion; }
    public void setIdNotificacion(Long idNotificacion) { this.idNotificacion = idNotificacion; }

    public String getDestinatario() { return destinatario; }
    public void setDestinatario(String destinatario) { this.destinatario = destinatario; }

    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }

    public String getCuerpoMensaje() { return cuerpoMensaje; }
    public void setCuerpoMensaje(String cuerpoMensaje) { this.cuerpoMensaje = cuerpoMensaje; }

    public String getTipoEvento() { return tipoEvento; }
    public void setTipoEvento(String tipoEvento) { this.tipoEvento = tipoEvento; }

    public LocalDateTime getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(LocalDateTime fechaEnvio) { this.fechaEnvio = fechaEnvio; }

    public String getEstadoEnvio() { return estadoEnvio; }
    public void setEstadoEnvio(String estadoEnvio) { this.estadoEnvio = estadoEnvio; }
}