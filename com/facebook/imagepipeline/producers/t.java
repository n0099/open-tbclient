package com.facebook.imagepipeline.producers;

import android.net.Uri;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class t {
    private final k<com.facebook.imagepipeline.f.e> pBE;
    private final ak pBL;
    private long pBM = 0;
    private int pBN;
    @Nullable
    private com.facebook.imagepipeline.common.a pBO;

    public t(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pBE = kVar;
        this.pBL = akVar;
    }

    public k<com.facebook.imagepipeline.f.e> exc() {
        return this.pBE;
    }

    public ak exd() {
        return this.pBL;
    }

    public String getId() {
        return this.pBL.getId();
    }

    public am ewQ() {
        return this.pBL.ewQ();
    }

    public Uri getUri() {
        return this.pBL.ewP().exF();
    }

    public long exe() {
        return this.pBM;
    }

    public void iL(long j) {
        this.pBM = j;
    }

    public int exf() {
        return this.pBN;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a exg() {
        return this.pBO;
    }
}
