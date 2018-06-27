package com.google.gson.internal.a;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.m;
import com.google.gson.n;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public final class a<E> extends m<Object> {
    public static final n hNE = new n() { // from class: com.google.gson.internal.a.a.1
        @Override // com.google.gson.n
        public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            Type bOI = aVar.bOI();
            if (!(bOI instanceof GenericArrayType) && (!(bOI instanceof Class) || !((Class) bOI).isArray())) {
                return null;
            }
            Type h = C$Gson$Types.h(bOI);
            return new a(dVar, dVar.a(com.google.gson.b.a.l(h)), C$Gson$Types.f(h));
        }
    };
    private final Class<E> hNF;
    private final m<E> hNG;

    public a(com.google.gson.d dVar, m<E> mVar, Class<E> cls) {
        this.hNG = new j(dVar, mVar, cls);
        this.hNF = cls;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.gson.m<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.m
    public void a(com.google.gson.stream.a aVar, Object obj) throws IOException {
        if (obj == null) {
            aVar.bOF();
            return;
        }
        aVar.bOB();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.hNG.a(aVar, Array.get(obj, i));
        }
        aVar.bOC();
    }
}
