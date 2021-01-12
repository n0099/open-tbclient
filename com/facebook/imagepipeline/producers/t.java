package com.facebook.imagepipeline.producers;

import android.net.Uri;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class t {
    private final k<com.facebook.imagepipeline.f.e> pBD;
    private final ak pBK;
    private long pBL = 0;
    private int pBM;
    @Nullable
    private com.facebook.imagepipeline.common.a pBN;

    public t(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pBD = kVar;
        this.pBK = akVar;
    }

    public k<com.facebook.imagepipeline.f.e> exc() {
        return this.pBD;
    }

    public ak exd() {
        return this.pBK;
    }

    public String getId() {
        return this.pBK.getId();
    }

    public am ewQ() {
        return this.pBK.ewQ();
    }

    public Uri getUri() {
        return this.pBK.ewP().exF();
    }

    public long exe() {
        return this.pBL;
    }

    public void iL(long j) {
        this.pBL = j;
    }

    public int exf() {
        return this.pBM;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a exg() {
        return this.pBN;
    }
}
