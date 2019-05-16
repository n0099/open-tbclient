package com.facebook.imagepipeline.producers;

import android.net.Uri;
/* loaded from: classes2.dex */
public class s {
    private final aj kcB;
    private long kcC = 0;
    private final j<com.facebook.imagepipeline.f.d> kcu;

    public s(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.kcu = jVar;
        this.kcB = ajVar;
    }

    public j<com.facebook.imagepipeline.f.d> cHJ() {
        return this.kcu;
    }

    public aj cHK() {
        return this.kcB;
    }

    public String getId() {
        return this.kcB.getId();
    }

    public al cHx() {
        return this.kcB.cHx();
    }

    public Uri getUri() {
        return this.kcB.cHw().cIj();
    }

    public long cHL() {
        return this.kcC;
    }

    public void eD(long j) {
        this.kcC = j;
    }
}
