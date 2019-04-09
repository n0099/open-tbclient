package com.facebook.imagepipeline.producers;

import android.net.Uri;
/* loaded from: classes2.dex */
public class s {
    private final j<com.facebook.imagepipeline.f.d> jJH;
    private final aj jJO;
    private long jJP = 0;

    public s(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.jJH = jVar;
        this.jJO = ajVar;
    }

    public j<com.facebook.imagepipeline.f.d> czN() {
        return this.jJH;
    }

    public aj czO() {
        return this.jJO;
    }

    public String getId() {
        return this.jJO.getId();
    }

    public al czB() {
        return this.jJO.czB();
    }

    public Uri getUri() {
        return this.jJO.czA().cAn();
    }

    public long czP() {
        return this.jJP;
    }

    public void ee(long j) {
        this.jJP = j;
    }
}
