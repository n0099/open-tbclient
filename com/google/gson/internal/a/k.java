package com.google.gson.internal.a;

import com.google.gson.n;
import com.google.gson.o;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class k<T> extends n<T> {
    private final com.google.gson.d gson;
    private n<T> knC;
    private final com.google.gson.m<T> kpj;
    private final com.google.gson.g<T> kpk;
    private final com.google.gson.b.a<T> kpl;
    private final o kpm;
    private final k<T>.a kpn = new a();

    public k(com.google.gson.m<T> mVar, com.google.gson.g<T> gVar, com.google.gson.d dVar, com.google.gson.b.a<T> aVar, o oVar) {
        this.kpj = mVar;
        this.kpk = gVar;
        this.gson = dVar;
        this.kpl = aVar;
        this.kpm = oVar;
    }

    @Override // com.google.gson.n
    public void a(com.google.gson.stream.a aVar, T t) throws IOException {
        if (this.kpj == null) {
            cKl().a(aVar, t);
        } else if (t == null) {
            aVar.cKB();
        } else {
            com.google.gson.internal.f.b(this.kpj.a(t, this.kpl.cKD(), this.kpn), aVar);
        }
    }

    private n<T> cKl() {
        n<T> nVar = this.knC;
        if (nVar != null) {
            return nVar;
        }
        n<T> a2 = this.gson.a(this.kpm, this.kpl);
        this.knC = a2;
        return a2;
    }

    /* loaded from: classes2.dex */
    private final class a implements com.google.gson.l {
        private a() {
        }
    }
}
