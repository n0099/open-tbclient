package com.google.gson.internal.a;

import com.google.gson.o;
import com.google.gson.p;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class l<T> extends o<T> {
    private final com.google.gson.d gson;
    private o<T> jNp;
    private final com.google.gson.n<T> jPg;
    private final com.google.gson.h<T> jPh;
    private final com.google.gson.b.a<T> jPi;
    private final p jPj;
    private final l<T>.a jPk = new a();

    public l(com.google.gson.n<T> nVar, com.google.gson.h<T> hVar, com.google.gson.d dVar, com.google.gson.b.a<T> aVar, p pVar) {
        this.jPg = nVar;
        this.jPh = hVar;
        this.gson = dVar;
        this.jPi = aVar;
        this.jPj = pVar;
    }

    @Override // com.google.gson.o
    public T b(com.google.gson.stream.a aVar) throws IOException {
        if (this.jPh == null) {
            return cBn().b(aVar);
        }
        com.google.gson.i h = com.google.gson.internal.g.h(aVar);
        if (h.cAX()) {
            return null;
        }
        return this.jPh.a(h, this.jPi.cBK(), this.jPk);
    }

    @Override // com.google.gson.o
    public void a(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.jPg == null) {
            cBn().a(bVar, t);
        } else if (t == null) {
            bVar.cBI();
        } else {
            com.google.gson.internal.g.b(this.jPg.a(t, this.jPi.cBK(), this.jPk), bVar);
        }
    }

    private o<T> cBn() {
        o<T> oVar = this.jNp;
        if (oVar != null) {
            return oVar;
        }
        o<T> a2 = this.gson.a(this.jPj, this.jPi);
        this.jNp = a2;
        return a2;
    }

    /* loaded from: classes2.dex */
    private final class a implements com.google.gson.g, com.google.gson.m {
        private a() {
        }
    }
}
