package com.google.gson.internal.a;

import com.google.gson.n;
import com.google.gson.o;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class k<T> extends n<T> {
    private final com.google.gson.d gson;
    private n<T> kfy;
    private final com.google.gson.m<T> khf;
    private final com.google.gson.g<T> khg;
    private final com.google.gson.b.a<T> khh;
    private final o khi;
    private final k<T>.a khj = new a();

    public k(com.google.gson.m<T> mVar, com.google.gson.g<T> gVar, com.google.gson.d dVar, com.google.gson.b.a<T> aVar, o oVar) {
        this.khf = mVar;
        this.khg = gVar;
        this.gson = dVar;
        this.khh = aVar;
        this.khi = oVar;
    }

    @Override // com.google.gson.n
    public void a(com.google.gson.stream.a aVar, T t) throws IOException {
        if (this.khf == null) {
            cJb().a(aVar, t);
        } else if (t == null) {
            aVar.cJr();
        } else {
            com.google.gson.internal.f.b(this.khf.a(t, this.khh.cJt(), this.khj), aVar);
        }
    }

    private n<T> cJb() {
        n<T> nVar = this.kfy;
        if (nVar != null) {
            return nVar;
        }
        n<T> a2 = this.gson.a(this.khi, this.khh);
        this.kfy = a2;
        return a2;
    }

    /* loaded from: classes2.dex */
    private final class a implements com.google.gson.l {
        private a() {
        }
    }
}
