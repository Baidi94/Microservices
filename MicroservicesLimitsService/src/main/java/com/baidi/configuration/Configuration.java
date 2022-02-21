/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baidi.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author Obaidullah
 */
@Component
@Data
@ConfigurationProperties(prefix = "limits-service")
public class Configuration {
    private int minimum;
    private int maximum;
}
