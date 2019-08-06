package com.google.gson.internal.a;

import com.google.gson.n;
import com.google.gson.o;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class k<T> extends n<T> {
    private final com.google.gson.d gson;
    private n<T> knK;
    private final com.google.gson.m<T> kpr;
    private final com.google.gson.g<T> kps;
    private final com.google.gson.b.a<T> kpt;
    private final o kpu;
    private final k<T>.a kpv = new a();

    public k(com.google.gson.m<T> mVar, com.google.gson.g<T> gVar, com.google.gson.d dVar, com.google.gson.b.a<T> aVar, o oVar) {
        this.kpr = mVar;
        this.kps = gVar;
        this.gson = dVar;
        this.kpt = aVar;
        this.kpu = oVar;
    }

    @Override // com.google.gson.n
    public void a(com.google.gson.stream.a aVar, T t) throws IOException {
        if (this.kpr == null) {
            cMC().a(aVar, t);
        } else if (t == null) {
            aVar.cMS();
        } else {
            com.google.gson.internal.f.b(this.kpr.a(t, this.kpt.cMU(), this.kpv), aVar);
        }
    }

    private n<T> cMC() {
        n<T> nVar = this.knK;
        if (nVar != null) {
            return nVar;
        }
        n<T> a2 = this.gson.a(this.kpu, this.kpt);
        this.knK = a2;
        return a2;
    }

    /* loaded from: classes2.dex */
    private final class a implements com.google.gson.l {
        private a() {
        }
    }
}
