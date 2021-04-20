package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import d.g.d.b.b;
import d.g.d.c.a;
/* loaded from: classes6.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: e  reason: collision with root package name */
    public final b f31239e;

    public JsonAdapterAnnotationTypeAdapterFactory(b bVar) {
        this.f31239e = bVar;
    }

    public TypeAdapter<?> a(b bVar, Gson gson, a<?> aVar, d.g.d.a.b bVar2) {
        TypeAdapter<?> treeTypeAdapter;
        Object a2 = bVar.a(a.a(bVar2.value())).a();
        if (a2 instanceof TypeAdapter) {
            treeTypeAdapter = (TypeAdapter) a2;
        } else if (a2 instanceof TypeAdapterFactory) {
            treeTypeAdapter = ((TypeAdapterFactory) a2).create(gson, aVar);
        } else {
            boolean z = a2 instanceof JsonSerializer;
            if (!z && !(a2 instanceof JsonDeserializer)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + a2.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            treeTypeAdapter = new TreeTypeAdapter<>(z ? (JsonSerializer) a2 : null, a2 instanceof JsonDeserializer ? (JsonDeserializer) a2 : null, gson, aVar, null);
        }
        return (treeTypeAdapter == null || !bVar2.nullSafe()) ? treeTypeAdapter : treeTypeAdapter.nullSafe();
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, a<T> aVar) {
        d.g.d.a.b bVar = (d.g.d.a.b) aVar.c().getAnnotation(d.g.d.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (TypeAdapter<T>) a(this.f31239e, gson, aVar, bVar);
    }
}
