package com.caviedes.notification.controller;


import com.caviedes.notification.model.LogNotificacion;
import com.caviedes.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/notificaciones")
@CrossOrigin(origins = "*")
@Tag(name = "Notificaciones y Soporte", description = "Endpoints tradicionales sin DTOs usando Maps")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/reserva")
    @Operation(summary = "Procesar y registrar correo de reserva pendiente (HU-14)")
    public ResponseEntity<LogNotificacion> procesarNotificacionReserva(@RequestBody Map<String, String> body) {
        String correo = body.get("correo");
        String nombre = body.get("nombre");
        String nombrePlan = body.get("nombrePlan");

        String asunto = "Tu solicitud de reserva está siendo evaluada - Huila Travel Expedition";
        String cuerpo = "Hola " + nombre + ",\n\nHemos recibido correctamente tu solicitud para el plan '" 
                + nombrePlan + "'. Actualmente se encuentra en estado PENDIENTE de aprobación.";

        LogNotificacion logGuardado = notificationService.registrarNotificacionManual(correo, asunto, cuerpo, "CONFIRMACION_RESERVA");
        return new ResponseEntity<>(logGuardado, HttpStatus.CREATED);
    }

    @PostMapping("/soporte")
    @Operation(summary = "Procesar y confirmar el formulario de contacto web (HU-20)")
    public ResponseEntity<LogNotificacion> procesarNotificacionSoporte(@RequestBody Map<String, String> body) {
        String correo = body.get("correo");
        String nombre = body.get("nombre");
        String asuntoMensaje = body.get("asunto");

        String asunto = "Confirmación de Recepción: Caso Soporte Técnico HTE";
        String cuerpo = "Hola " + nombre + ",\n\nTu requerimiento sobre '" + asuntoMensaje 
                + "' ha entrado a nuestra bandeja. Nos comunicaremos contigo pronto.";

        LogNotificacion logGuardado = notificationService.registrarNotificacionManual(correo, asunto, cuerpo, "SOPORTE");
        return new ResponseEntity<>(logGuardado, HttpStatus.CREATED);
    }
}
