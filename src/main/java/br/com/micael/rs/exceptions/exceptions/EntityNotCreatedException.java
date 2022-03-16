package br.com.micael.rs.exceptions.exceptions;

public class EntityNotCreatedException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public EntityNotCreatedException(String msg){
        super(msg);
    }
}
