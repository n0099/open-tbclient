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

    public j<com.facebook.imagepipeline.f.d> bZe() {
        return this.iqb;
    }

    public aj bZf() {
        return this.iqi;
    }

    public String getId() {
        return this.iqi.getId();
    }

    public al bYS() {
        return this.iqi.bYS();
    }

    public Uri getUri() {
        return this.iqi.bYR().bZE();
    }

    public long bZg() {
        return this.iqj;
    }

    public void dv(long j) {
        this.iqj = j;
    }
}
