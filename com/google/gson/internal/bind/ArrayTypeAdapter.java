package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {
    public static final TypeAdapterFactory pUg = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.ArrayTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            Type type = aVar.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type o = C$Gson$Types.o(type);
            return new ArrayTypeAdapter(gson, gson.getAdapter(com.google.gson.b.a.r(o)), C$Gson$Types.m(o));
        }
    };
    private final Class<E> componentType;
    private final TypeAdapter<E> pUh;

    public ArrayTypeAdapter(Gson gson, TypeAdapter<E> typeAdapter, Class<E> cls) {
        this.pUh = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.componentType = cls;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.eBD() == JsonToken.NULL) {
            aVar.eBJ();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.eBB();
        while (aVar.hasNext()) {
            arrayList.add(this.pUh.read(aVar));
        }
        aVar.endArray();
        int size = arrayList.size();
        Object newInstance = Array.newInstance((Class<?>) this.componentType, size);
        for (int i = 0; i < size; i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.gson.TypeAdapter<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, Object obj) throws IOException {
        if (obj == null) {
            bVar.eBW();
            return;
        }
        bVar.eBS();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.pUh.write(bVar, Array.get(obj, i));
        }
        bVar.eBT();
    }
}
