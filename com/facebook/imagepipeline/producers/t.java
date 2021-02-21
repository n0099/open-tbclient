package com.facebook.imagepipeline.producers;

import android.net.Uri;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class t {
    private final k<com.facebook.imagepipeline.f.e> pMm;
    private final ak pMt;
    private long pMu = 0;
    private int pMv;
    @Nullable
    private com.facebook.imagepipeline.common.a pMw;

    public t(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pMm = kVar;
        this.pMt = akVar;
    }

    public k<com.facebook.imagepipeline.f.e> ezC() {
        return this.pMm;
    }

    public ak ezD() {
        return this.pMt;
    }

    public String getId() {
        return this.pMt.getId();
    }

    public am ezq() {
        return this.pMt.ezq();
    }

    public Uri getUri() {
        return this.pMt.ezp().eAf();
    }

    public long ezE() {
        return this.pMu;
    }

    public void iO(long j) {
        this.pMu = j;
    }

    public int ezF() {
        return this.pMv;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a ezG() {
        return this.pMw;
    }
}
