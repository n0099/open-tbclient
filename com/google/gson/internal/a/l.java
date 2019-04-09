package com.google.gson.internal.a;

import com.google.gson.o;
import com.google.gson.p;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class l<T> extends o<T> {
    private final com.google.gson.d gson;
    private o<T> jMK;
    private final com.google.gson.n<T> jOA;
    private final com.google.gson.h<T> jOB;
    private final com.google.gson.b.a<T> jOC;
    private final p jOD;
    private final l<T>.a jOE = new a();

    public l(com.google.gson.n<T> nVar, com.google.gson.h<T> hVar, com.google.gson.d dVar, com.google.gson.b.a<T> aVar, p pVar) {
        this.jOA = nVar;
        this.jOB = hVar;
        this.gson = dVar;
        this.jOC = aVar;
        this.jOD = pVar;
    }

    @Override // com.google.gson.o
    public T b(com.google.gson.stream.a aVar) throws IOException {
        if (this.jOB == null) {
            return cBg().b(aVar);
        }
        com.google.gson.i h = com.google.gson.internal.g.h(aVar);
        if (h.cAQ()) {
            return null;
        }
        return this.jOB.a(h, this.jOC.cBD(), this.jOE);
    }

    @Override // com.google.gson.o
    public void a(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.jOA == null) {
            cBg().a(bVar, t);
        } else if (t == null) {
            bVar.cBB();
        } else {
            com.google.gson.internal.g.b(this.jOA.a(t, this.jOC.cBD(), this.jOE), bVar);
        }
    }

    private o<T> cBg() {
        o<T> oVar = this.jMK;
        if (oVar != null) {
            return oVar;
        }
        o<T> a2 = this.gson.a(this.jOD, this.jOC);
        this.jMK = a2;
        return a2;
    }

    /* loaded from: classes2.dex */
    private final class a implements com.google.gson.g, com.google.gson.m {
        private a() {
        }
    }
}
