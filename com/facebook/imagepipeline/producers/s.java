package com.facebook.imagepipeline.producers;

import android.net.Uri;
/* loaded from: classes2.dex */
public class s {
    private final aj kcF;
    private long kcG = 0;
    private final j<com.facebook.imagepipeline.f.d> kcy;

    public s(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.kcy = jVar;
        this.kcF = ajVar;
    }

    public j<com.facebook.imagepipeline.f.d> cHK() {
        return this.kcy;
    }

    public aj cHL() {
        return this.kcF;
    }

    public String getId() {
        return this.kcF.getId();
    }

    public al cHy() {
        return this.kcF.cHy();
    }

    public Uri getUri() {
        return this.kcF.cHx().cIk();
    }

    public long cHM() {
        return this.kcG;
    }

    public void eD(long j) {
        this.kcG = j;
    }
}
