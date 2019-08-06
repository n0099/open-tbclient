package com.facebook.imagepipeline.producers;

import android.net.Uri;
/* loaded from: classes2.dex */
public class s {
    private final j<com.facebook.imagepipeline.f.d> kkL;
    private final aj kkS;
    private long kkT = 0;

    public s(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.kkL = jVar;
        this.kkS = ajVar;
    }

    public j<com.facebook.imagepipeline.f.d> cLj() {
        return this.kkL;
    }

    public aj cLk() {
        return this.kkS;
    }

    public String getId() {
        return this.kkS.getId();
    }

    public al cKX() {
        return this.kkS.cKX();
    }

    public Uri getUri() {
        return this.kkS.cKW().cLJ();
    }

    public long cLl() {
        return this.kkT;
    }

    public void eL(long j) {
        this.kkT = j;
    }
}
