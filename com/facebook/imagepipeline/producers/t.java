package com.facebook.imagepipeline.producers;

import android.net.Uri;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class t {
    private final ak pEE;
    private long pEF = 0;
    private int pEG;
    @Nullable
    private com.facebook.imagepipeline.common.a pEH;
    private final k<com.facebook.imagepipeline.f.e> pEx;

    public t(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pEx = kVar;
        this.pEE = akVar;
    }

    public k<com.facebook.imagepipeline.f.e> eAq() {
        return this.pEx;
    }

    public ak eAr() {
        return this.pEE;
    }

    public String getId() {
        return this.pEE.getId();
    }

    public am eAe() {
        return this.pEE.eAe();
    }

    public Uri getUri() {
        return this.pEE.eAd().eAT();
    }

    public long eAs() {
        return this.pEF;
    }

    public void iI(long j) {
        this.pEF = j;
    }

    public int eAt() {
        return this.pEG;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a eAu() {
        return this.pEH;
    }
}
