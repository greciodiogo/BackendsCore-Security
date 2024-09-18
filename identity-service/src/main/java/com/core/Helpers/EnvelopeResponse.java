package com.core.Helpers;

public record EnvelopeResponse<T>(
    T data,
    String message,
    Integer statusCode
) {}
