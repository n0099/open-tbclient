package com.facebook.imagepipeline.producers;

import android.net.Uri;
/* loaded from: classes2.dex */
public class s {
    private final j<com.facebook.imagepipeline.f.d> ihf;
    private final aj ihm;
    private long ihn = 0;

    public s(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.ihf = jVar;
        this.ihm = ajVar;
    }

    public j<com.facebook.imagepipeline.f.d> bXD() {
        return this.ihf;
    }

    public aj bXE() {
        return this.ihm;
    }

    public String getId() {
        return this.ihm.getId();
    }

    public al bXr() {
        return this.ihm.bXr();
    }

    public Uri getUri() {
        return this.ihm.bXq().bYd();
    }

    public long bXF() {
        return this.ihn;
    }

    public void dt(long j) {
        this.ihn = j;
    }
}
