package com.facebook.imagepipeline.producers;

import android.net.Uri;
/* loaded from: classes2.dex */
public class s {
    private final j<com.facebook.imagepipeline.f.d> jKb;
    private final aj jKi;
    private long jKj = 0;

    public s(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.jKb = jVar;
        this.jKi = ajVar;
    }

    public j<com.facebook.imagepipeline.f.d> czH() {
        return this.jKb;
    }

    public aj czI() {
        return this.jKi;
    }

    public String getId() {
        return this.jKi.getId();
    }

    public al czv() {
        return this.jKi.czv();
    }

    public Uri getUri() {
        return this.jKi.czu().cAh();
    }

    public long czJ() {
        return this.jKj;
    }

    public void ef(long j) {
        this.jKj = j;
    }
}
