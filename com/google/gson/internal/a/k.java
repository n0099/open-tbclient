package com.google.gson.internal.a;

import com.google.gson.n;
import com.google.gson.o;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class k<T> extends n<T> {
    private final com.google.gson.d gson;
    private n<T> kfu;
    private final com.google.gson.m<T> khb;
    private final com.google.gson.g<T> khc;
    private final com.google.gson.b.a<T> khd;
    private final o khe;
    private final k<T>.a khf = new a();

    public k(com.google.gson.m<T> mVar, com.google.gson.g<T> gVar, com.google.gson.d dVar, com.google.gson.b.a<T> aVar, o oVar) {
        this.khb = mVar;
        this.khc = gVar;
        this.gson = dVar;
        this.khd = aVar;
        this.khe = oVar;
    }

    @Override // com.google.gson.n
    public void a(com.google.gson.stream.a aVar, T t) throws IOException {
        if (this.khb == null) {
            cJa().a(aVar, t);
        } else if (t == null) {
            aVar.cJq();
        } else {
            com.google.gson.internal.f.b(this.khb.a(t, this.khd.cJs(), this.khf), aVar);
        }
    }

    private n<T> cJa() {
        n<T> nVar = this.kfu;
        if (nVar != null) {
            return nVar;
        }
        n<T> a2 = this.gson.a(this.khe, this.khd);
        this.kfu = a2;
        return a2;
    }

    /* loaded from: classes2.dex */
    private final class a implements com.google.gson.l {
        private a() {
        }
    }
}
