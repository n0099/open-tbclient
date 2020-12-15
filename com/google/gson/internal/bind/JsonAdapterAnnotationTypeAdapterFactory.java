package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
/* loaded from: classes5.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {
    private final com.google.gson.internal.b constructorConstructor;

    public JsonAdapterAnnotationTypeAdapterFactory(com.google.gson.internal.b bVar) {
        this.constructorConstructor = bVar;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
        com.google.gson.a.b bVar = (com.google.gson.a.b) aVar.eyW().getAnnotation(com.google.gson.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (TypeAdapter<T>) a(this.constructorConstructor, gson, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TypeAdapter<?> a(com.google.gson.internal.b bVar, Gson gson, com.google.gson.b.a<?> aVar, com.google.gson.a.b bVar2) {
        TypeAdapter<?> treeTypeAdapter;
        Object construct = bVar.a(com.google.gson.b.a.J(bVar2.value())).construct();
        if (construct instanceof TypeAdapter) {
            treeTypeAdapter = (TypeAdapter) construct;
        } else if (construct instanceof TypeAdapterFactory) {
            treeTypeAdapter = ((TypeAdapterFactory) construct).create(gson, aVar);
        } else if ((construct instanceof JsonSerializer) || (construct instanceof JsonDeserializer)) {
            treeTypeAdapter = new TreeTypeAdapter<>(construct instanceof JsonSerializer ? (JsonSerializer) construct : null, construct instanceof JsonDeserializer ? (JsonDeserializer) construct : null, gson, aVar, null);
        } else {
            throw new IllegalArgumentException("Invalid attempt to bind an instance of " + construct.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
        }
        if (treeTypeAdapter != null && bVar2.eye()) {
            return treeTypeAdapter.nullSafe();
        }
        return treeTypeAdapter;
    }
}
