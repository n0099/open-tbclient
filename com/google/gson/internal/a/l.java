package com.google.gson.internal.a;

import com.google.gson.o;
import com.google.gson.p;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class l<T> extends o<T> {
    private final com.google.gson.d gson;
    private o<T> jMJ;
    private final com.google.gson.h<T> jOA;
    private final com.google.gson.b.a<T> jOB;
    private final p jOC;
    private final l<T>.a jOD = new a();
    private final com.google.gson.n<T> jOz;

    public l(com.google.gson.n<T> nVar, com.google.gson.h<T> hVar, com.google.gson.d dVar, com.google.gson.b.a<T> aVar, p pVar) {
        this.jOz = nVar;
        this.jOA = hVar;
        this.gson = dVar;
        this.jOB = aVar;
        this.jOC = pVar;
    }

    @Override // com.google.gson.o
    public T b(com.google.gson.stream.a aVar) throws IOException {
        if (this.jOA == null) {
            return cBg().b(aVar);
        }
        com.google.gson.i h = com.google.gson.internal.g.h(aVar);
        if (h.cAQ()) {
            return null;
        }
        return this.jOA.a(h, this.jOB.cBD(), this.jOD);
    }

    @Override // com.google.gson.o
    public void a(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.jOz == null) {
            cBg().a(bVar, t);
        } else if (t == null) {
            bVar.cBB();
        } else {
            com.google.gson.internal.g.b(this.jOz.a(t, this.jOB.cBD(), this.jOD), bVar);
        }
    }

    private o<T> cBg() {
        o<T> oVar = this.jMJ;
        if (oVar != null) {
            return oVar;
        }
        o<T> a2 = this.gson.a(this.jOC, this.jOB);
        this.jMJ = a2;
        return a2;
    }

    /* loaded from: classes2.dex */
    private final class a implements com.google.gson.g, com.google.gson.m {
        private a() {
        }
    }
}
