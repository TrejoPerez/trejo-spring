/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trejo.sp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author T-101
 */
@Configuration
public class ConfiguracionServicios {
    @Bean
    public ComportamientoMensaje miServicioMensaje(){
        return new MensajeSerializado();
    }
}
