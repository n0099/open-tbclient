package com.google.gson.internal.a;

import com.google.gson.n;
import com.google.gson.o;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class g extends n<Object> {
    public static final o kgA = new o() { // from class: com.google.gson.internal.a.g.1
        @Override // com.google.gson.o
        public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.cJr() == Object.class) {
                return new g(dVar);
            }
            return null;
        }
    };
    private final com.google.gson.d gson;

    g(com.google.gson.d dVar) {
        this.gson = dVar;
    }

    @Override // com.google.gson.n
    public void a(com.google.gson.stream.a aVar, Object obj) throws IOException {
        if (obj == null) {
            aVar.cJq();
            return;
        }
        n v = this.gson.v(obj.getClass());
        if (v instanceof g) {
            aVar.cJo();
            aVar.cJp();
            return;
        }
        v.a(aVar, obj);
    }
}
