package com.google.gson.internal.a;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.n;
import com.google.gson.o;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public final class a<E> extends n<Object> {
    public static final o kgE = new o() { // from class: com.google.gson.internal.a.a.1
        @Override // com.google.gson.o
        public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            Type cJt = aVar.cJt();
            if (!(cJt instanceof GenericArrayType) && (!(cJt instanceof Class) || !((Class) cJt).isArray())) {
                return null;
            }
            Type i = C$Gson$Types.i(cJt);
            return new a(dVar, dVar.a(com.google.gson.b.a.l(i)), C$Gson$Types.g(i));
        }
    };
    private final Class<E> kgF;
    private final n<E> kgG;

    public a(com.google.gson.d dVar, n<E> nVar, Class<E> cls) {
        this.kgG = new l(dVar, nVar, cls);
        this.kgF = cls;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.gson.n<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.n
    public void a(com.google.gson.stream.a aVar, Object obj) throws IOException {
        if (obj == null) {
            aVar.cJr();
            return;
        }
        aVar.cJn();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.kgG.a(aVar, Array.get(obj, i));
        }
        aVar.cJo();
    }
}
