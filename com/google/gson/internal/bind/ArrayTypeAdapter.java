package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.stream.JsonToken;
import d.h.d.c.a;
import d.h.d.d.b;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {

    /* renamed from: c  reason: collision with root package name */
    public static final TypeAdapterFactory f31326c = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.ArrayTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, a<T> aVar) {
            Type e2 = aVar.e();
            if ((e2 instanceof GenericArrayType) || ((e2 instanceof Class) && ((Class) e2).isArray())) {
                Type g2 = C$Gson$Types.g(e2);
                return new ArrayTypeAdapter(gson, gson.getAdapter(a.b(g2)), C$Gson$Types.k(g2));
            }
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final Class<E> f31327a;

    /* renamed from: b  reason: collision with root package name */
    public final TypeAdapter<E> f31328b;

    public ArrayTypeAdapter(Gson gson, TypeAdapter<E> typeAdapter, Class<E> cls) {
        this.f31328b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.f31327a = cls;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(d.h.d.d.a aVar) throws IOException {
        if (aVar.M() == JsonToken.NULL) {
            aVar.I();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.n();
        while (aVar.y()) {
            arrayList.add(this.f31328b.read(aVar));
        }
        aVar.t();
        int size = arrayList.size();
        Object newInstance = Array.newInstance((Class<?>) this.f31327a, size);
        for (int i = 0; i < size; i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.gson.TypeAdapter<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.TypeAdapter
    public void write(b bVar, Object obj) throws IOException {
        if (obj == null) {
            bVar.B();
            return;
        }
        bVar.q();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f31328b.write(bVar, Array.get(obj, i));
        }
        bVar.t();
    }
}
