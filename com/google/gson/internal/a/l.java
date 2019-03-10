package com.google.gson.internal.a;

import com.google.gson.o;
import com.google.gson.p;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class l<T> extends o<T> {
    private final com.google.gson.d gson;
    private o<T> jNx;
    private final com.google.gson.n<T> jPo;
    private final com.google.gson.h<T> jPp;
    private final com.google.gson.b.a<T> jPq;
    private final p jPr;
    private final l<T>.a jPs = new a();

    public l(com.google.gson.n<T> nVar, com.google.gson.h<T> hVar, com.google.gson.d dVar, com.google.gson.b.a<T> aVar, p pVar) {
        this.jPo = nVar;
        this.jPp = hVar;
        this.gson = dVar;
        this.jPq = aVar;
        this.jPr = pVar;
    }

    @Override // com.google.gson.o
    public T b(com.google.gson.stream.a aVar) throws IOException {
        if (this.jPp == null) {
            return cBk().b(aVar);
        }
        com.google.gson.i h = com.google.gson.internal.g.h(aVar);
        if (h.cAU()) {
            return null;
        }
        return this.jPp.a(h, this.jPq.cBH(), this.jPs);
    }

    @Override // com.google.gson.o
    public void a(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.jPo == null) {
            cBk().a(bVar, t);
        } else if (t == null) {
            bVar.cBF();
        } else {
            com.google.gson.internal.g.b(this.jPo.a(t, this.jPq.cBH(), this.jPs), bVar);
        }
    }

    private o<T> cBk() {
        o<T> oVar = this.jNx;
        if (oVar != null) {
            return oVar;
        }
        o<T> a2 = this.gson.a(this.jPr, this.jPq);
        this.jNx = a2;
        return a2;
    }

    /* loaded from: classes2.dex */
    private final class a implements com.google.gson.g, com.google.gson.m {
        private a() {
        }
    }
}
