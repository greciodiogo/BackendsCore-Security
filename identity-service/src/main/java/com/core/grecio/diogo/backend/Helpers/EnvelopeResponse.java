package com.core.grecio.diogo.backend.Helpers;

public record EnvelopeResponse<T>(
    T data,
    String message,
    Integer statusCode
) {}
