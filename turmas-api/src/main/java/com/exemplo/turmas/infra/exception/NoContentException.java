package com.exemplo.turmas.infra.exception;

public class NoContentException extends RuntimeException {
    public NoContentException(){ super("sem conteúdo"); }
}
