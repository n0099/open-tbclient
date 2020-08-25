package com.facebook.imagepipeline.producers;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class t {
    private final k<com.facebook.imagepipeline.g.e> nyj;
    private final ak nyq;
    private long nyr = 0;
    private int nys;
    @Nullable
    private com.facebook.imagepipeline.common.a nyt;

    public t(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.nyj = kVar;
        this.nyq = akVar;
    }

    public k<com.facebook.imagepipeline.g.e> dVA() {
        return this.nyj;
    }

    public ak dVB() {
        return this.nyq;
    }

    public String getId() {
        return this.nyq.getId();
    }

    public am dVp() {
        return this.nyq.dVp();
    }

    public Uri getUri() {
        return this.nyq.dVo().dWg();
    }

    public long dVC() {
        return this.nyr;
    }

    public void gv(long j) {
        this.nyr = j;
    }

    public int dVD() {
        return this.nys;
    }

    public void Mn(int i) {
        this.nys = i;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dVE() {
        return this.nyt;
    }

    public void c(com.facebook.imagepipeline.common.a aVar) {
        this.nyt = aVar;
    }

    public Map<String, String> dVF() {
        return this.nyq.dVo().dVF();
    }
}
