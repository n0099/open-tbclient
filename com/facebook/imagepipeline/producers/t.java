package com.facebook.imagepipeline.producers;

import android.net.Uri;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class t {
    private final k<com.facebook.imagepipeline.f.e> pGe;
    private final ak pGl;
    private long pGm = 0;
    private int pGn;
    @Nullable
    private com.facebook.imagepipeline.common.a pGo;

    public t(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pGe = kVar;
        this.pGl = akVar;
    }

    public k<com.facebook.imagepipeline.f.e> eAU() {
        return this.pGe;
    }

    public ak eAV() {
        return this.pGl;
    }

    public String getId() {
        return this.pGl.getId();
    }

    public am eAI() {
        return this.pGl.eAI();
    }

    public Uri getUri() {
        return this.pGl.eAH().eBx();
    }

    public long eAW() {
        return this.pGm;
    }

    public void iL(long j) {
        this.pGm = j;
    }

    public int eAX() {
        return this.pGn;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a eAY() {
        return this.pGo;
    }
}
