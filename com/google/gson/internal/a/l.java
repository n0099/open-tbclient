package com.google.gson.internal.a;

import com.google.gson.o;
import com.google.gson.p;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class l<T> extends o<T> {
    private final com.google.gson.d gson;
    private o<T> ike;
    private final com.google.gson.n<T> ilV;
    private final com.google.gson.h<T> ilW;
    private final com.google.gson.b.a<T> ilX;
    private final p ilY;
    private final l<T>.a ilZ = new a();

    public l(com.google.gson.n<T> nVar, com.google.gson.h<T> hVar, com.google.gson.d dVar, com.google.gson.b.a<T> aVar, p pVar) {
        this.ilV = nVar;
        this.ilW = hVar;
        this.gson = dVar;
        this.ilX = aVar;
        this.ilY = pVar;
    }

    @Override // com.google.gson.o
    public T b(com.google.gson.stream.a aVar) throws IOException {
        if (this.ilW == null) {
            return bYU().b(aVar);
        }
        com.google.gson.i h = com.google.gson.internal.g.h(aVar);
        if (h.bYE()) {
            return null;
        }
        return this.ilW.a(h, this.ilX.bZr(), this.ilZ);
    }

    @Override // com.google.gson.o
    public void a(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.ilV == null) {
            bYU().a(bVar, t);
        } else if (t == null) {
            bVar.bZp();
        } else {
            com.google.gson.internal.g.b(this.ilV.a(t, this.ilX.bZr(), this.ilZ), bVar);
        }
    }

    private o<T> bYU() {
        o<T> oVar = this.ike;
        if (oVar != null) {
            return oVar;
        }
        o<T> a2 = this.gson.a(this.ilY, this.ilX);
        this.ike = a2;
        return a2;
    }

    /* loaded from: classes2.dex */
    private final class a implements com.google.gson.g, com.google.gson.m {
        private a() {
        }
    }
}
