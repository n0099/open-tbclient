package com.facebook.imagepipeline.producers;

import android.net.Uri;
/* loaded from: classes2.dex */
public class s {
    private final j<com.facebook.imagepipeline.f.d> iiP;
    private final aj iiW;
    private long iiX = 0;

    public s(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.iiP = jVar;
        this.iiW = ajVar;
    }

    public j<com.facebook.imagepipeline.f.d> bWY() {
        return this.iiP;
    }

    public aj bWZ() {
        return this.iiW;
    }

    public String getId() {
        return this.iiW.getId();
    }

    public al bWM() {
        return this.iiW.bWM();
    }

    public Uri getUri() {
        return this.iiW.bWL().bXy();
    }

    public long bXa() {
        return this.iiX;
    }

    /* renamed from: do  reason: not valid java name */
    public void m24do(long j) {
        this.iiX = j;
    }
}
