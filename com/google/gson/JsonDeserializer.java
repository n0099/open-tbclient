package com.google.gson;

import java.lang.reflect.Type;
/* loaded from: classes7.dex */
public interface JsonDeserializer {
    Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException;
}
