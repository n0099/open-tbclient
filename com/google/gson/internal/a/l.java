package com.google.gson.internal.a;

import com.google.gson.o;
import com.google.gson.p;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class l<T> extends o<T> {
    private final com.google.gson.d gson;
    private o<T> ixs;
    private final com.google.gson.n<T> izj;
    private final com.google.gson.h<T> izk;
    private final com.google.gson.b.a<T> izl;
    private final p izm;
    private final l<T>.a izn = new a();

    public l(com.google.gson.n<T> nVar, com.google.gson.h<T> hVar, com.google.gson.d dVar, com.google.gson.b.a<T> aVar, p pVar) {
        this.izj = nVar;
        this.izk = hVar;
        this.gson = dVar;
        this.izl = aVar;
        this.izm = pVar;
    }

    @Override // com.google.gson.o
    public T b(com.google.gson.stream.a aVar) throws IOException {
        if (this.izk == null) {
            return cbV().b(aVar);
        }
        com.google.gson.i h = com.google.gson.internal.g.h(aVar);
        if (h.cbF()) {
            return null;
        }
        return this.izk.a(h, this.izl.ccs(), this.izn);
    }

    @Override // com.google.gson.o
    public void a(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.izj == null) {
            cbV().a(bVar, t);
        } else if (t == null) {
            bVar.ccq();
        } else {
            com.google.gson.internal.g.b(this.izj.a(t, this.izl.ccs(), this.izn), bVar);
        }
    }

    private o<T> cbV() {
        o<T> oVar = this.ixs;
        if (oVar != null) {
            return oVar;
        }
        o<T> a2 = this.gson.a(this.izm, this.izl);
        this.ixs = a2;
        return a2;
    }

    /* loaded from: classes2.dex */
    private final class a implements com.google.gson.g, com.google.gson.m {
        private a() {
        }
    }
}
