package com.facebook.imagepipeline.producers;

import android.net.Uri;
/* loaded from: classes2.dex */
public class s {
    private final j<com.facebook.imagepipeline.f.d> jKm;
    private final aj jKt;
    private long jKu = 0;

    public s(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.jKm = jVar;
        this.jKt = ajVar;
    }

    public j<com.facebook.imagepipeline.f.d> czU() {
        return this.jKm;
    }

    public aj czV() {
        return this.jKt;
    }

    public String getId() {
        return this.jKt.getId();
    }

    public al czI() {
        return this.jKt.czI();
    }

    public Uri getUri() {
        return this.jKt.czH().cAu();
    }

    public long czW() {
        return this.jKu;
    }

    public void ef(long j) {
        this.jKu = j;
    }
}
