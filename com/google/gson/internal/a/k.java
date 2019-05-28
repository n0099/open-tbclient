package com.google.gson.internal.a;

import com.google.gson.n;
import com.google.gson.o;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class k<T> extends n<T> {
    private final com.google.gson.d gson;
    private n<T> kfv;
    private final com.google.gson.m<T> khc;
    private final com.google.gson.g<T> khd;
    private final com.google.gson.b.a<T> khe;
    private final o khf;
    private final k<T>.a khg = new a();

    public k(com.google.gson.m<T> mVar, com.google.gson.g<T> gVar, com.google.gson.d dVar, com.google.gson.b.a<T> aVar, o oVar) {
        this.khc = mVar;
        this.khd = gVar;
        this.gson = dVar;
        this.khe = aVar;
        this.khf = oVar;
    }

    @Override // com.google.gson.n
    public void a(com.google.gson.stream.a aVar, T t) throws IOException {
        if (this.khc == null) {
            cJc().a(aVar, t);
        } else if (t == null) {
            aVar.cJs();
        } else {
            com.google.gson.internal.f.b(this.khc.a(t, this.khe.cJu(), this.khg), aVar);
        }
    }

    private n<T> cJc() {
        n<T> nVar = this.kfv;
        if (nVar != null) {
            return nVar;
        }
        n<T> a2 = this.gson.a(this.khf, this.khe);
        this.kfv = a2;
        return a2;
    }

    /* loaded from: classes2.dex */
    private final class a implements com.google.gson.l {
        private a() {
        }
    }
}
