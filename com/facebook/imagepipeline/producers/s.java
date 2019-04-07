package com.facebook.imagepipeline.producers;

import android.net.Uri;
/* loaded from: classes2.dex */
public class s {
    private final j<com.facebook.imagepipeline.f.d> jJG;
    private final aj jJN;
    private long jJO = 0;

    public s(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.jJG = jVar;
        this.jJN = ajVar;
    }

    public j<com.facebook.imagepipeline.f.d> czN() {
        return this.jJG;
    }

    public aj czO() {
        return this.jJN;
    }

    public String getId() {
        return this.jJN.getId();
    }

    public al czB() {
        return this.jJN.czB();
    }

    public Uri getUri() {
        return this.jJN.czA().cAn();
    }

    public long czP() {
        return this.jJO;
    }

    public void ee(long j) {
        this.jJO = j;
    }
}
