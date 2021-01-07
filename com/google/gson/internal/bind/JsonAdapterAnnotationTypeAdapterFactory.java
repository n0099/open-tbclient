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
        com.google.gson.a.b bVar = (com.google.gson.a.b) aVar.eDm().getAnnotation(com.google.gson.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (TypeAdapter<T>) a(this.constructorConstructor, gson, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TypeAdapter<?> a(com.google.gson.internal.b bVar, Gson gson, com.google.gson.b.a<?> aVar, com.google.gson.a.b bVar2) {
        TypeAdapter<?> treeTypeAdapter;
        Object eCw = bVar.a(com.google.gson.b.a.C(bVar2.value())).eCw();
        if (eCw instanceof TypeAdapter) {
            treeTypeAdapter = (TypeAdapter) eCw;
        } else if (eCw instanceof TypeAdapterFactory) {
            treeTypeAdapter = ((TypeAdapterFactory) eCw).create(gson, aVar);
        } else if ((eCw instanceof JsonSerializer) || (eCw instanceof JsonDeserializer)) {
            treeTypeAdapter = new TreeTypeAdapter<>(eCw instanceof JsonSerializer ? (JsonSerializer) eCw : null, eCw instanceof JsonDeserializer ? (JsonDeserializer) eCw : null, gson, aVar, null);
        } else {
            throw new IllegalArgumentException("Invalid attempt to bind an instance of " + eCw.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
        }
        if (treeTypeAdapter != null && bVar2.eCt()) {
            return treeTypeAdapter.nullSafe();
        }
        return treeTypeAdapter;
    }
}
