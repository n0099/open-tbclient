package com.facebook.imagepipeline.producers;

import android.net.Uri;
/* loaded from: classes2.dex */
public class s {
    private final aj kcC;
    private long kcD = 0;
    private final j<com.facebook.imagepipeline.f.d> kcv;

    public s(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.kcv = jVar;
        this.kcC = ajVar;
    }

    public j<com.facebook.imagepipeline.f.d> cHL() {
        return this.kcv;
    }

    public aj cHM() {
        return this.kcC;
    }

    public String getId() {
        return this.kcC.getId();
    }

    public al cHz() {
        return this.kcC.cHz();
    }

    public Uri getUri() {
        return this.kcC.cHy().cIl();
    }

    public long cHN() {
        return this.kcD;
    }

    public void eD(long j) {
        this.kcD = j;
    }
}
