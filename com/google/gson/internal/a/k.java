package com.google.gson.internal.a;

import com.google.gson.n;
import com.google.gson.o;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class k<T> extends n<T> {
    private final com.google.gson.d gson;
    private n<T> kqh;
    private final com.google.gson.m<T> krO;
    private final com.google.gson.g<T> krP;
    private final com.google.gson.b.a<T> krQ;
    private final o krR;
    private final k<T>.a krS = new a();

    public k(com.google.gson.m<T> mVar, com.google.gson.g<T> gVar, com.google.gson.d dVar, com.google.gson.b.a<T> aVar, o oVar) {
        this.krO = mVar;
        this.krP = gVar;
        this.gson = dVar;
        this.krQ = aVar;
        this.krR = oVar;
    }

    @Override // com.google.gson.n
    public void a(com.google.gson.stream.a aVar, T t) throws IOException {
        if (this.krO == null) {
            cNq().a(aVar, t);
        } else if (t == null) {
            aVar.cNG();
        } else {
            com.google.gson.internal.f.b(this.krO.a(t, this.krQ.cNI(), this.krS), aVar);
        }
    }

    private n<T> cNq() {
        n<T> nVar = this.kqh;
        if (nVar != null) {
            return nVar;
        }
        n<T> a2 = this.gson.a(this.krR, this.krQ);
        this.kqh = a2;
        return a2;
    }

    /* loaded from: classes2.dex */
    private final class a implements com.google.gson.l {
        private a() {
        }
    }
}
