package com.facebook.imagepipeline.producers;

import android.net.Uri;
/* loaded from: classes2.dex */
public class s {
    private final aj iuA;
    private long iuB = 0;
    private final j<com.facebook.imagepipeline.f.d> iut;

    public s(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.iut = jVar;
        this.iuA = ajVar;
    }

    public j<com.facebook.imagepipeline.f.d> caC() {
        return this.iut;
    }

    public aj caD() {
        return this.iuA;
    }

    public String getId() {
        return this.iuA.getId();
    }

    public al caq() {
        return this.iuA.caq();
    }

    public Uri getUri() {
        return this.iuA.cap().cbc();
    }

    public long caE() {
        return this.iuB;
    }

    public void dA(long j) {
        this.iuB = j;
    }
}
