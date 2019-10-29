package com.facebook.imagepipeline.producers;

import android.net.Uri;
/* loaded from: classes2.dex */
public class s {
    private final aj klB;
    private long klC = 0;
    private final j<com.facebook.imagepipeline.f.d> klu;

    public s(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.klu = jVar;
        this.klB = ajVar;
    }

    public j<com.facebook.imagepipeline.f.d> cIU() {
        return this.klu;
    }

    public aj cIV() {
        return this.klB;
    }

    public String getId() {
        return this.klB.getId();
    }

    public al cII() {
        return this.klB.cII();
    }

    public Uri getUri() {
        return this.klB.cIH().cJu();
    }

    public long cIW() {
        return this.klC;
    }

    public void ei(long j) {
        this.klC = j;
    }
}
