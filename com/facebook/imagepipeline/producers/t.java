package com.facebook.imagepipeline.producers;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class t {
    private final k<com.facebook.imagepipeline.g.e> nyB;
    private final ak nyI;
    private long nyJ = 0;
    private int nyK;
    @Nullable
    private com.facebook.imagepipeline.common.a nyL;

    public t(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.nyB = kVar;
        this.nyI = akVar;
    }

    public k<com.facebook.imagepipeline.g.e> dVJ() {
        return this.nyB;
    }

    public ak dVK() {
        return this.nyI;
    }

    public String getId() {
        return this.nyI.getId();
    }

    public am dVy() {
        return this.nyI.dVy();
    }

    public Uri getUri() {
        return this.nyI.dVx().dWp();
    }

    public long dVL() {
        return this.nyJ;
    }

    public void gx(long j) {
        this.nyJ = j;
    }

    public int dVM() {
        return this.nyK;
    }

    public void Mn(int i) {
        this.nyK = i;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dVN() {
        return this.nyL;
    }

    public void c(com.facebook.imagepipeline.common.a aVar) {
        this.nyL = aVar;
    }

    public Map<String, String> dVO() {
        return this.nyI.dVx().dVO();
    }
}
