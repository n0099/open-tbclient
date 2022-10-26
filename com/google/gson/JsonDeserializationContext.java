package com.google.gson;

import java.lang.reflect.Type;
/* loaded from: classes7.dex */
public interface JsonDeserializationContext {
    Object deserialize(JsonElement jsonElement, Type type) throws JsonParseException;
}
