package com.google.gson.internal.a;

import com.google.gson.n;
import com.google.gson.o;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class k<T> extends n<T> {
    private final com.google.gson.d gson;
    private n<T> kmE;
    private final com.google.gson.m<T> kol;
    private final com.google.gson.g<T> kom;
    private final com.google.gson.b.a<T> kon;
    private final o koo;
    private final k<T>.a kop = new a();

    public k(com.google.gson.m<T> mVar, com.google.gson.g<T> gVar, com.google.gson.d dVar, com.google.gson.b.a<T> aVar, o oVar) {
        this.kol = mVar;
        this.kom = gVar;
        this.gson = dVar;
        this.kon = aVar;
        this.koo = oVar;
    }

    @Override // com.google.gson.n
    public void a(com.google.gson.stream.a aVar, T t) throws IOException {
        if (this.kol == null) {
            cMh().a(aVar, t);
        } else if (t == null) {
            aVar.cMx();
        } else {
            com.google.gson.internal.f.b(this.kol.a(t, this.kon.cMz(), this.kop), aVar);
        }
    }

    private n<T> cMh() {
        n<T> nVar = this.kmE;
        if (nVar != null) {
            return nVar;
        }
        n<T> a2 = this.gson.a(this.koo, this.kon);
        this.kmE = a2;
        return a2;
    }

    /* loaded from: classes2.dex */
    private final class a implements com.google.gson.l {
        private a() {
        }
    }
}
