package com.google.gson.internal.a;

import com.google.gson.o;
import com.google.gson.p;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class l<T> extends o<T> {
    private final com.google.gson.d gson;
    private o<T> iwl;
    private final com.google.gson.n<T> iyc;
    private final com.google.gson.h<T> iyd;
    private final com.google.gson.b.a<T> iye;
    private final p iyf;
    private final l<T>.a iyg = new a();

    public l(com.google.gson.n<T> nVar, com.google.gson.h<T> hVar, com.google.gson.d dVar, com.google.gson.b.a<T> aVar, p pVar) {
        this.iyc = nVar;
        this.iyd = hVar;
        this.gson = dVar;
        this.iye = aVar;
        this.iyf = pVar;
    }

    @Override // com.google.gson.o
    public T b(com.google.gson.stream.a aVar) throws IOException {
        if (this.iyd == null) {
            return cbn().b(aVar);
        }
        com.google.gson.i h = com.google.gson.internal.g.h(aVar);
        if (h.caX()) {
            return null;
        }
        return this.iyd.a(h, this.iye.cbK(), this.iyg);
    }

    @Override // com.google.gson.o
    public void a(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.iyc == null) {
            cbn().a(bVar, t);
        } else if (t == null) {
            bVar.cbI();
        } else {
            com.google.gson.internal.g.b(this.iyc.a(t, this.iye.cbK(), this.iyg), bVar);
        }
    }

    private o<T> cbn() {
        o<T> oVar = this.iwl;
        if (oVar != null) {
            return oVar;
        }
        o<T> a2 = this.gson.a(this.iyf, this.iye);
        this.iwl = a2;
        return a2;
    }

    /* loaded from: classes2.dex */
    private final class a implements com.google.gson.g, com.google.gson.m {
        private a() {
        }
    }
}
