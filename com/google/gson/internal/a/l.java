package com.google.gson.internal.a;

import com.google.gson.o;
import com.google.gson.p;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class l<T> extends o<T> {
    private final com.google.gson.d gson;
    private o<T> jNe;
    private final com.google.gson.n<T> jOV;
    private final com.google.gson.h<T> jOW;
    private final com.google.gson.b.a<T> jOX;
    private final p jOY;
    private final l<T>.a jOZ = new a();

    public l(com.google.gson.n<T> nVar, com.google.gson.h<T> hVar, com.google.gson.d dVar, com.google.gson.b.a<T> aVar, p pVar) {
        this.jOV = nVar;
        this.jOW = hVar;
        this.gson = dVar;
        this.jOX = aVar;
        this.jOY = pVar;
    }

    @Override // com.google.gson.o
    public T b(com.google.gson.stream.a aVar) throws IOException {
        if (this.jOW == null) {
            return cBa().b(aVar);
        }
        com.google.gson.i h = com.google.gson.internal.g.h(aVar);
        if (h.cAK()) {
            return null;
        }
        return this.jOW.a(h, this.jOX.cBx(), this.jOZ);
    }

    @Override // com.google.gson.o
    public void a(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.jOV == null) {
            cBa().a(bVar, t);
        } else if (t == null) {
            bVar.cBv();
        } else {
            com.google.gson.internal.g.b(this.jOV.a(t, this.jOX.cBx(), this.jOZ), bVar);
        }
    }

    private o<T> cBa() {
        o<T> oVar = this.jNe;
        if (oVar != null) {
            return oVar;
        }
        o<T> a2 = this.gson.a(this.jOY, this.jOX);
        this.jNe = a2;
        return a2;
    }

    /* loaded from: classes2.dex */
    private final class a implements com.google.gson.g, com.google.gson.m {
        private a() {
        }
    }
}
