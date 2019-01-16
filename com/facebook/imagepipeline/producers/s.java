package com.facebook.imagepipeline.producers;

import android.net.Uri;
/* loaded from: classes2.dex */
public class s {
    private long iuA = 0;
    private final j<com.facebook.imagepipeline.f.d> ius;
    private final aj iuz;

    public s(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.ius = jVar;
        this.iuz = ajVar;
    }

    public j<com.facebook.imagepipeline.f.d> caC() {
        return this.ius;
    }

    public aj caD() {
        return this.iuz;
    }

    public String getId() {
        return this.iuz.getId();
    }

    public al caq() {
        return this.iuz.caq();
    }

    public Uri getUri() {
        return this.iuz.cap().cbc();
    }

    public long caE() {
        return this.iuA;
    }

    public void dA(long j) {
        this.iuA = j;
    }
}
