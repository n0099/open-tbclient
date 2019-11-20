package com.facebook.imagepipeline.producers;

import android.net.Uri;
/* loaded from: classes2.dex */
public class s {
    private final j<com.facebook.imagepipeline.f.d> kkD;
    private final aj kkK;
    private long kkL = 0;

    public s(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.kkD = jVar;
        this.kkK = ajVar;
    }

    public j<com.facebook.imagepipeline.f.d> cIS() {
        return this.kkD;
    }

    public aj cIT() {
        return this.kkK;
    }

    public String getId() {
        return this.kkK.getId();
    }

    public al cIG() {
        return this.kkK.cIG();
    }

    public Uri getUri() {
        return this.kkK.cIF().cJs();
    }

    public long cIU() {
        return this.kkL;
    }

    public void eh(long j) {
        this.kkL = j;
    }
}
