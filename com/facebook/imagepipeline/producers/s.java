package com.facebook.imagepipeline.producers;

import android.net.Uri;
/* loaded from: classes2.dex */
public class s {
    private final j<com.facebook.imagepipeline.f.d> ihe;
    private final aj ihl;
    private long ihm = 0;

    public s(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.ihe = jVar;
        this.ihl = ajVar;
    }

    public j<com.facebook.imagepipeline.f.d> bXD() {
        return this.ihe;
    }

    public aj bXE() {
        return this.ihl;
    }

    public String getId() {
        return this.ihl.getId();
    }

    public al bXr() {
        return this.ihl.bXr();
    }

    public Uri getUri() {
        return this.ihl.bXq().bYd();
    }

    public long bXF() {
        return this.ihm;
    }

    public void dt(long j) {
        this.ihm = j;
    }
}
