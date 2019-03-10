package com.facebook.imagepipeline.producers;

import android.net.Uri;
/* loaded from: classes2.dex */
public class s {
    private final aj jKB;
    private long jKC = 0;
    private final j<com.facebook.imagepipeline.f.d> jKu;

    public s(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.jKu = jVar;
        this.jKB = ajVar;
    }

    public j<com.facebook.imagepipeline.f.d> czR() {
        return this.jKu;
    }

    public aj czS() {
        return this.jKB;
    }

    public String getId() {
        return this.jKB.getId();
    }

    public al czF() {
        return this.jKB.czF();
    }

    public Uri getUri() {
        return this.jKB.czE().cAr();
    }

    public long czT() {
        return this.jKC;
    }

    public void ef(long j) {
        this.jKC = j;
    }
}
