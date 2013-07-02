package com.google.gson;

import java.lang.reflect.Type;
/* loaded from: classes.dex */
public interface JsonDeserializationContext {
    Object deserialize(JsonElement jsonElement, Type type);
}
