package com.google.gson.internal.a;

import com.google.gson.m;
import com.google.gson.n;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class f extends m<Object> {
    public static final n hGj = new n() { // from class: com.google.gson.internal.a.f.1
        @Override // com.google.gson.n
        public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.bKr() == Object.class) {
                return new f(dVar);
            }
            return null;
        }
    };
    private final com.google.gson.d gson;

    private f(com.google.gson.d dVar) {
        this.gson = dVar;
    }

    @Override // com.google.gson.m
    public void a(com.google.gson.stream.a aVar, Object obj) throws IOException {
        if (obj == null) {
            aVar.bKp();
            return;
        }
        m o = this.gson.o(obj.getClass());
        if (o instanceof f) {
            aVar.bKn();
            aVar.bKo();
            return;
        }
        o.a(aVar, obj);
    }
}
