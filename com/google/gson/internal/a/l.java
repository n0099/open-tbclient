package com.google.gson.internal.a;

import com.google.gson.o;
import com.google.gson.p;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class l<T> extends o<T> {
    private final com.google.gson.d gson;
    private o<T> ilP;
    private final com.google.gson.n<T> inI;
    private final com.google.gson.h<T> inJ;
    private final com.google.gson.b.a<T> inK;
    private final p inL;
    private final l<T>.a inM = new a();

    public l(com.google.gson.n<T> nVar, com.google.gson.h<T> hVar, com.google.gson.d dVar, com.google.gson.b.a<T> aVar, p pVar) {
        this.inI = nVar;
        this.inJ = hVar;
        this.gson = dVar;
        this.inK = aVar;
        this.inL = pVar;
    }

    @Override // com.google.gson.o
    public T b(com.google.gson.stream.a aVar) throws IOException {
        if (this.inJ == null) {
            return bYr().b(aVar);
        }
        com.google.gson.i h = com.google.gson.internal.g.h(aVar);
        if (h.bYb()) {
            return null;
        }
        return this.inJ.a(h, this.inK.bYO(), this.inM);
    }

    @Override // com.google.gson.o
    public void a(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.inI == null) {
            bYr().a(bVar, t);
        } else if (t == null) {
            bVar.bYM();
        } else {
            com.google.gson.internal.g.b(this.inI.a(t, this.inK.bYO(), this.inM), bVar);
        }
    }

    private o<T> bYr() {
        o<T> oVar = this.ilP;
        if (oVar != null) {
            return oVar;
        }
        o<T> a2 = this.gson.a(this.inL, this.inK);
        this.ilP = a2;
        return a2;
    }

    /* loaded from: classes2.dex */
    private final class a implements com.google.gson.g, com.google.gson.m {
        private a() {
        }
    }
}
