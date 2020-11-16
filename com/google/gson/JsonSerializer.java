package com.google.gson;

import java.lang.reflect.Type;
/* loaded from: classes5.dex */
public interface JsonSerializer<T> {
    JsonElement serialize(T t, Type type, JsonSerializationContext jsonSerializationContext);
}
