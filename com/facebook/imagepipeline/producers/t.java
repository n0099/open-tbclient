package com.facebook.imagepipeline.producers;

import android.net.Uri;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class t {
    private final k<com.facebook.imagepipeline.f.e> poV;
    private final ak ppc;
    private long ppd = 0;
    private int ppe;
    @Nullable
    private com.facebook.imagepipeline.common.a ppf;

    public t(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.poV = kVar;
        this.ppc = akVar;
    }

    public k<com.facebook.imagepipeline.f.e> ewI() {
        return this.poV;
    }

    public ak ewJ() {
        return this.ppc;
    }

    public String getId() {
        return this.ppc.getId();
    }

    public am eww() {
        return this.ppc.eww();
    }

    public Uri getUri() {
        return this.ppc.ewv().exl();
    }

    public long ewK() {
        return this.ppd;
    }

    public void ix(long j) {
        this.ppd = j;
    }

    public int ewL() {
        return this.ppe;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a ewM() {
        return this.ppf;
    }
}
