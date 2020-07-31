package com.google.gson.internal.a;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
/* loaded from: classes10.dex */
public final class d implements TypeAdapterFactory {
    private final com.google.gson.internal.b constructorConstructor;

    public d(com.google.gson.internal.b bVar) {
        this.constructorConstructor = bVar;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
        com.google.gson.a.b bVar = (com.google.gson.a.b) aVar.dLG().getAnnotation(com.google.gson.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (TypeAdapter<T>) a(this.constructorConstructor, gson, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TypeAdapter<?> a(com.google.gson.internal.b bVar, Gson gson, com.google.gson.b.a<?> aVar, com.google.gson.a.b bVar2) {
        TypeAdapter<?> lVar;
        Object construct = bVar.a(com.google.gson.b.a.J(bVar2.value())).construct();
        if (construct instanceof TypeAdapter) {
            lVar = (TypeAdapter) construct;
        } else if (construct instanceof TypeAdapterFactory) {
            lVar = ((TypeAdapterFactory) construct).create(gson, aVar);
        } else if ((construct instanceof JsonSerializer) || (construct instanceof JsonDeserializer)) {
            lVar = new l<>(construct instanceof JsonSerializer ? (JsonSerializer) construct : null, construct instanceof JsonDeserializer ? (JsonDeserializer) construct : null, gson, aVar, null);
        } else {
            throw new IllegalArgumentException("Invalid attempt to bind an instance of " + construct.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
        }
        if (lVar != null && bVar2.dKS()) {
            return lVar.nullSafe();
        }
        return lVar;
    }
}
