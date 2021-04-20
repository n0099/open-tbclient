package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import d.g.d.d.a;
import d.g.d.d.b;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* loaded from: classes6.dex */
public final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Gson f31279a;

    /* renamed from: b  reason: collision with root package name */
    public final TypeAdapter<T> f31280b;

    /* renamed from: c  reason: collision with root package name */
    public final Type f31281c;

    public TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter<T> typeAdapter, Type type) {
        this.f31279a = gson;
        this.f31280b = typeAdapter;
        this.f31281c = type;
    }

    public final Type a(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(a aVar) throws IOException {
        return this.f31280b.read(aVar);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(b bVar, T t) throws IOException {
        TypeAdapter<T> typeAdapter = this.f31280b;
        Type a2 = a(this.f31281c, t);
        if (a2 != this.f31281c) {
            typeAdapter = this.f31279a.getAdapter(d.g.d.c.a.b(a2));
            if (typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter) {
                TypeAdapter<T> typeAdapter2 = this.f31280b;
                if (!(typeAdapter2 instanceof ReflectiveTypeAdapterFactory.Adapter)) {
                    typeAdapter = typeAdapter2;
                }
            }
        }
        typeAdapter.write(bVar, t);
    }
}
