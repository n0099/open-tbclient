package com.facebook.imagepipeline.producers;

import android.net.Uri;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class t {
    private final k<com.facebook.imagepipeline.f.e> pLM;
    private final ak pLT;
    private long pLU = 0;
    private int pLV;
    @Nullable
    private com.facebook.imagepipeline.common.a pLW;

    public t(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pLM = kVar;
        this.pLT = akVar;
    }

    public k<com.facebook.imagepipeline.f.e> ezu() {
        return this.pLM;
    }

    public ak ezv() {
        return this.pLT;
    }

    public String getId() {
        return this.pLT.getId();
    }

    public am ezi() {
        return this.pLT.ezi();
    }

    public Uri getUri() {
        return this.pLT.ezh().ezX();
    }

    public long ezw() {
        return this.pLU;
    }

    public void iO(long j) {
        this.pLU = j;
    }

    public int ezx() {
        return this.pLV;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a ezy() {
        return this.pLW;
    }
}
