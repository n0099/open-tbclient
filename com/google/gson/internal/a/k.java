package com.google.gson.internal.a;

import com.google.gson.n;
import com.google.gson.o;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class k<T> extends n<T> {
    private final com.google.gson.d gson;
    private n<T> kot;
    private final com.google.gson.m<T> kqa;
    private final com.google.gson.g<T> kqb;
    private final com.google.gson.b.a<T> kqc;
    private final o kqd;
    private final k<T>.a kqe = new a();

    public k(com.google.gson.m<T> mVar, com.google.gson.g<T> gVar, com.google.gson.d dVar, com.google.gson.b.a<T> aVar, o oVar) {
        this.kqa = mVar;
        this.kqb = gVar;
        this.gson = dVar;
        this.kqc = aVar;
        this.kqd = oVar;
    }

    @Override // com.google.gson.n
    public void a(com.google.gson.stream.a aVar, T t) throws IOException {
        if (this.kqa == null) {
            cKn().a(aVar, t);
        } else if (t == null) {
            aVar.cKD();
        } else {
            com.google.gson.internal.f.b(this.kqa.a(t, this.kqc.cKF(), this.kqe), aVar);
        }
    }

    private n<T> cKn() {
        n<T> nVar = this.kot;
        if (nVar != null) {
            return nVar;
        }
        n<T> a2 = this.gson.a(this.kqd, this.kqc);
        this.kot = a2;
        return a2;
    }

    /* loaded from: classes2.dex */
    private final class a implements com.google.gson.l {
        private a() {
        }
    }
}
