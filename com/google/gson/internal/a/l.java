package com.google.gson.internal.a;

import com.google.gson.o;
import com.google.gson.p;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class l<T> extends o<T> {
    private final com.google.gson.d gson;
    private o<T> ikf;
    private final com.google.gson.n<T> ilW;
    private final com.google.gson.h<T> ilX;
    private final com.google.gson.b.a<T> ilY;
    private final p ilZ;
    private final l<T>.a ima = new a();

    public l(com.google.gson.n<T> nVar, com.google.gson.h<T> hVar, com.google.gson.d dVar, com.google.gson.b.a<T> aVar, p pVar) {
        this.ilW = nVar;
        this.ilX = hVar;
        this.gson = dVar;
        this.ilY = aVar;
        this.ilZ = pVar;
    }

    @Override // com.google.gson.o
    public T b(com.google.gson.stream.a aVar) throws IOException {
        if (this.ilX == null) {
            return bYU().b(aVar);
        }
        com.google.gson.i h = com.google.gson.internal.g.h(aVar);
        if (h.bYE()) {
            return null;
        }
        return this.ilX.a(h, this.ilY.bZr(), this.ima);
    }

    @Override // com.google.gson.o
    public void a(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.ilW == null) {
            bYU().a(bVar, t);
        } else if (t == null) {
            bVar.bZp();
        } else {
            com.google.gson.internal.g.b(this.ilW.a(t, this.ilY.bZr(), this.ima), bVar);
        }
    }

    private o<T> bYU() {
        o<T> oVar = this.ikf;
        if (oVar != null) {
            return oVar;
        }
        o<T> a2 = this.gson.a(this.ilZ, this.ilY);
        this.ikf = a2;
        return a2;
    }

    /* loaded from: classes2.dex */
    private final class a implements com.google.gson.g, com.google.gson.m {
        private a() {
        }
    }
}
