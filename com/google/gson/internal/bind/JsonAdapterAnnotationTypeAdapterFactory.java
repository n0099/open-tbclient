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
        com.google.gson.a.b bVar = (com.google.gson.a.b) aVar.eCI().getAnnotation(com.google.gson.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (TypeAdapter<T>) a(this.constructorConstructor, gson, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TypeAdapter<?> a(com.google.gson.internal.b bVar, Gson gson, com.google.gson.b.a<?> aVar, com.google.gson.a.b bVar2) {
        TypeAdapter<?> treeTypeAdapter;
        Object eBS = bVar.a(com.google.gson.b.a.C(bVar2.value())).eBS();
        if (eBS instanceof TypeAdapter) {
            treeTypeAdapter = (TypeAdapter) eBS;
        } else if (eBS instanceof TypeAdapterFactory) {
            treeTypeAdapter = ((TypeAdapterFactory) eBS).create(gson, aVar);
        } else if ((eBS instanceof JsonSerializer) || (eBS instanceof JsonDeserializer)) {
            treeTypeAdapter = new TreeTypeAdapter<>(eBS instanceof JsonSerializer ? (JsonSerializer) eBS : null, eBS instanceof JsonDeserializer ? (JsonDeserializer) eBS : null, gson, aVar, null);
        } else {
            throw new IllegalArgumentException("Invalid attempt to bind an instance of " + eBS.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
        }
        if (treeTypeAdapter != null && bVar2.eBP()) {
            return treeTypeAdapter.nullSafe();
        }
        return treeTypeAdapter;
    }
}
