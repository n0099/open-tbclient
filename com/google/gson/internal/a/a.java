package com.google.gson.internal.a;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.o;
import com.google.gson.p;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class a<E> extends o<Object> {
    public static final p jOm = new p() { // from class: com.google.gson.internal.a.a.1
        @Override // com.google.gson.p
        public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            Type cBx = aVar.cBx();
            if (!(cBx instanceof GenericArrayType) && (!(cBx instanceof Class) || !((Class) cBx).isArray())) {
                return null;
            }
            Type i = C$Gson$Types.i(cBx);
            return new a(dVar, dVar.a(com.google.gson.b.a.l(i)), C$Gson$Types.g(i));
        }
    };
    private final Class<E> jOn;
    private final o<E> jOo;

    public a(com.google.gson.d dVar, o<E> oVar, Class<E> cls) {
        this.jOo = new m(dVar, oVar, cls);
        this.jOn = cls;
    }

    @Override // com.google.gson.o
    public Object b(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.cBk() == JsonToken.NULL) {
            aVar.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.beginArray();
        while (aVar.hasNext()) {
            arrayList.add(this.jOo.b(aVar));
        }
        aVar.endArray();
        Object newInstance = Array.newInstance((Class<?>) this.jOn, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.gson.o<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.o
    public void a(com.google.gson.stream.b bVar, Object obj) throws IOException {
        if (obj == null) {
            bVar.cBv();
            return;
        }
        bVar.cBr();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.jOo.a(bVar, Array.get(obj, i));
        }
        bVar.cBs();
    }
}
