package com.google.gson.internal.a;

import com.google.gson.o;
import com.google.gson.p;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class l<T> extends o<T> {
    private final com.google.gson.d gson;
    private o<T> itb;
    private final com.google.gson.n<T> iuS;
    private final com.google.gson.h<T> iuT;
    private final com.google.gson.b.a<T> iuU;
    private final p iuV;
    private final l<T>.a iuW = new a();

    public l(com.google.gson.n<T> nVar, com.google.gson.h<T> hVar, com.google.gson.d dVar, com.google.gson.b.a<T> aVar, p pVar) {
        this.iuS = nVar;
        this.iuT = hVar;
        this.gson = dVar;
        this.iuU = aVar;
        this.iuV = pVar;
    }

    @Override // com.google.gson.o
    public T b(com.google.gson.stream.a aVar) throws IOException {
        if (this.iuT == null) {
            return caw().b(aVar);
        }
        com.google.gson.i h = com.google.gson.internal.g.h(aVar);
        if (h.cag()) {
            return null;
        }
        return this.iuT.a(h, this.iuU.caT(), this.iuW);
    }

    @Override // com.google.gson.o
    public void a(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.iuS == null) {
            caw().a(bVar, t);
        } else if (t == null) {
            bVar.caR();
        } else {
            com.google.gson.internal.g.b(this.iuS.a(t, this.iuU.caT(), this.iuW), bVar);
        }
    }

    private o<T> caw() {
        o<T> oVar = this.itb;
        if (oVar != null) {
            return oVar;
        }
        o<T> a2 = this.gson.a(this.iuV, this.iuU);
        this.itb = a2;
        return a2;
    }

    /* loaded from: classes2.dex */
    private final class a implements com.google.gson.g, com.google.gson.m {
        private a() {
        }
    }
}
