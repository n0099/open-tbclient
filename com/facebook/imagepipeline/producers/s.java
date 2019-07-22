package com.facebook.imagepipeline.producers;

import android.net.Uri;
/* loaded from: classes2.dex */
public class s {
    private final j<com.facebook.imagepipeline.f.d> kjF;
    private final aj kjM;
    private long kjN = 0;

    public s(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.kjF = jVar;
        this.kjM = ajVar;
    }

    public j<com.facebook.imagepipeline.f.d> cKO() {
        return this.kjF;
    }

    public aj cKP() {
        return this.kjM;
    }

    public String getId() {
        return this.kjM.getId();
    }

    public al cKC() {
        return this.kjM.cKC();
    }

    public Uri getUri() {
        return this.kjM.cKB().cLo();
    }

    public long cKQ() {
        return this.kjN;
    }

    public void eL(long j) {
        this.kjN = j;
    }
}
