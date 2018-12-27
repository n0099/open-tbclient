package com.facebook.imagepipeline.producers;

import android.net.Uri;
/* loaded from: classes2.dex */
public class s {
    private final j<com.facebook.imagepipeline.f.d> itl;
    private final aj its;
    private long itt = 0;

    public s(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.itl = jVar;
        this.its = ajVar;
    }

    public j<com.facebook.imagepipeline.f.d> bZU() {
        return this.itl;
    }

    public aj bZV() {
        return this.its;
    }

    public String getId() {
        return this.its.getId();
    }

    public al bZI() {
        return this.its.bZI();
    }

    public Uri getUri() {
        return this.its.bZH().cau();
    }

    public long bZW() {
        return this.itt;
    }

    public void dA(long j) {
        this.itt = j;
    }
}
