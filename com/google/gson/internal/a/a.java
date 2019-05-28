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
    public static final o kgB = new o() { // from class: com.google.gson.internal.a.a.1
        @Override // com.google.gson.o
        public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            Type cJu = aVar.cJu();
            if (!(cJu instanceof GenericArrayType) && (!(cJu instanceof Class) || !((Class) cJu).isArray())) {
                return null;
            }
            Type i = C$Gson$Types.i(cJu);
            return new a(dVar, dVar.a(com.google.gson.b.a.l(i)), C$Gson$Types.g(i));
        }
    };
    private final Class<E> kgC;
    private final n<E> kgD;

    public a(com.google.gson.d dVar, n<E> nVar, Class<E> cls) {
        this.kgD = new l(dVar, nVar, cls);
        this.kgC = cls;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.gson.n<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.n
    public void a(com.google.gson.stream.a aVar, Object obj) throws IOException {
        if (obj == null) {
            aVar.cJs();
            return;
        }
        aVar.cJo();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.kgD.a(aVar, Array.get(obj, i));
        }
        aVar.cJp();
    }
}
