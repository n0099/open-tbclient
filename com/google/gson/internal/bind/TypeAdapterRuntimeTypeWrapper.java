package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import d.h.d.d.a;
import d.h.d.d.b;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* loaded from: classes6.dex */
public final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Gson f31374a;

    /* renamed from: b  reason: collision with root package name */
    public final TypeAdapter<T> f31375b;

    /* renamed from: c  reason: collision with root package name */
    public final Type f31376c;

    public TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter<T> typeAdapter, Type type) {
        this.f31374a = gson;
        this.f31375b = typeAdapter;
        this.f31376c = type;
    }

    public final Type a(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(a aVar) throws IOException {
        return this.f31375b.read(aVar);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(b bVar, T t) throws IOException {
        TypeAdapter<T> typeAdapter = this.f31375b;
        Type a2 = a(this.f31376c, t);
        if (a2 != this.f31376c) {
            typeAdapter = this.f31374a.getAdapter(d.h.d.c.a.b(a2));
            if (typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter) {
                TypeAdapter<T> typeAdapter2 = this.f31375b;
                if (!(typeAdapter2 instanceof ReflectiveTypeAdapterFactory.Adapter)) {
                    typeAdapter = typeAdapter2;
                }
            }
        }
        typeAdapter.write(bVar, t);
    }
}
