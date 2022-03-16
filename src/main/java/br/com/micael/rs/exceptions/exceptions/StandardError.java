package br.com.micael.rs.exceptions.exceptions;

import java.io.Serializable;
import java.time.Instant;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StandardError implements Serializable{
    private static final long serialVersionUID = 1;

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}
