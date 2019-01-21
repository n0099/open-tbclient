package com.google.gson.internal.a;

import com.google.gson.o;
import com.google.gson.p;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class l<T> extends o<T> {
    private final com.google.gson.d gson;
    private o<T> ixt;
    private final com.google.gson.n<T> izk;
    private final com.google.gson.h<T> izl;
    private final com.google.gson.b.a<T> izm;
    private final p izn;
    private final l<T>.a izo = new a();

    public l(com.google.gson.n<T> nVar, com.google.gson.h<T> hVar, com.google.gson.d dVar, com.google.gson.b.a<T> aVar, p pVar) {
        this.izk = nVar;
        this.izl = hVar;
        this.gson = dVar;
        this.izm = aVar;
        this.izn = pVar;
    }

    @Override // com.google.gson.o
    public T b(com.google.gson.stream.a aVar) throws IOException {
        if (this.izl == null) {
            return cbV().b(aVar);
        }
        com.google.gson.i h = com.google.gson.internal.g.h(aVar);
        if (h.cbF()) {
            return null;
        }
        return this.izl.a(h, this.izm.ccs(), this.izo);
    }

    @Override // com.google.gson.o
    public void a(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.izk == null) {
            cbV().a(bVar, t);
        } else if (t == null) {
            bVar.ccq();
        } else {
            com.google.gson.internal.g.b(this.izk.a(t, this.izm.ccs(), this.izo), bVar);
        }
    }

    private o<T> cbV() {
        o<T> oVar = this.ixt;
        if (oVar != null) {
            return oVar;
        }
        o<T> a2 = this.gson.a(this.izn, this.izm);
        this.ixt = a2;
        return a2;
    }

    /* loaded from: classes2.dex */
    private final class a implements com.google.gson.g, com.google.gson.m {
        private a() {
        }
    }
}
