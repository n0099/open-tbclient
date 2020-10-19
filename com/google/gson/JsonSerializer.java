package com.google.gson;

import java.lang.reflect.Type;
/* loaded from: classes17.dex */
public interface JsonSerializer<T> {
    JsonElement serialize(T t, Type type, JsonSerializationContext jsonSerializationContext);
}
