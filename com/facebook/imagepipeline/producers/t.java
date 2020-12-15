package com.facebook.imagepipeline.producers;

import android.net.Uri;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class t {
    private final k<com.facebook.imagepipeline.f.e> poX;
    private final ak ppe;
    private long ppf = 0;
    private int ppg;
    @Nullable
    private com.facebook.imagepipeline.common.a pph;

    public t(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.poX = kVar;
        this.ppe = akVar;
    }

    public k<com.facebook.imagepipeline.f.e> ewJ() {
        return this.poX;
    }

    public ak ewK() {
        return this.ppe;
    }

    public String getId() {
        return this.ppe.getId();
    }

    public am ewx() {
        return this.ppe.ewx();
    }

    public Uri getUri() {
        return this.ppe.eww().exm();
    }

    public long ewL() {
        return this.ppf;
    }

    public void ix(long j) {
        this.ppf = j;
    }

    public int ewM() {
        return this.ppg;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a ewN() {
        return this.pph;
    }
}
