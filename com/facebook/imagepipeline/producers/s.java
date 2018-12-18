package com.facebook.imagepipeline.producers;

import android.net.Uri;
/* loaded from: classes2.dex */
public class s {
    private final j<com.facebook.imagepipeline.f.d> iqb;
    private final aj iqi;
    private long iqj = 0;

    public s(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.iqb = jVar;
        this.iqi = ajVar;
    }

    public j<com.facebook.imagepipeline.f.d> bZd() {
        return this.iqb;
    }

    public aj bZe() {
        return this.iqi;
    }

    public String getId() {
        return this.iqi.getId();
    }

    public al bYR() {
        return this.iqi.bYR();
    }

    public Uri getUri() {
        return this.iqi.bYQ().bZD();
    }

    public long bZf() {
        return this.iqj;
    }

    public void dv(long j) {
        this.iqj = j;
    }
}
