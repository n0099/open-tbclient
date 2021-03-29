package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import d.g.c.d.a;
import d.g.c.d.b;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* loaded from: classes6.dex */
public final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Gson f30990a;

    /* renamed from: b  reason: collision with root package name */
    public final TypeAdapter<T> f30991b;

    /* renamed from: c  reason: collision with root package name */
    public final Type f30992c;

    public TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter<T> typeAdapter, Type type) {
        this.f30990a = gson;
        this.f30991b = typeAdapter;
        this.f30992c = type;
    }

    public final Type a(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(a aVar) throws IOException {
        return this.f30991b.read(aVar);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(b bVar, T t) throws IOException {
        TypeAdapter<T> typeAdapter = this.f30991b;
        Type a2 = a(this.f30992c, t);
        if (a2 != this.f30992c) {
            typeAdapter = this.f30990a.getAdapter(d.g.c.c.a.b(a2));
            if (typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter) {
                TypeAdapter<T> typeAdapter2 = this.f30991b;
                if (!(typeAdapter2 instanceof ReflectiveTypeAdapterFactory.Adapter)) {
                    typeAdapter = typeAdapter2;
                }
            }
        }
        typeAdapter.write(bVar, t);
    }
}
