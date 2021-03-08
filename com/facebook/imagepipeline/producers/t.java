package com.facebook.imagepipeline.producers;

import android.net.Uri;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class t {
    private int pOA;
    @Nullable
    private com.facebook.imagepipeline.common.a pOB;
    private final k<com.facebook.imagepipeline.f.e> pOr;
    private final ak pOy;
    private long pOz = 0;

    public t(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pOr = kVar;
        this.pOy = akVar;
    }

    public k<com.facebook.imagepipeline.f.e> ezL() {
        return this.pOr;
    }

    public ak ezM() {
        return this.pOy;
    }

    public String getId() {
        return this.pOy.getId();
    }

    public am ezz() {
        return this.pOy.ezz();
    }

    public Uri getUri() {
        return this.pOy.ezy().eAo();
    }

    public long ezN() {
        return this.pOz;
    }

    public void iO(long j) {
        this.pOz = j;
    }

    public int ezO() {
        return this.pOA;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a ezP() {
        return this.pOB;
    }
}
