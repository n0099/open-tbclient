package com.facebook.imagepipeline.producers;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class t {
    @Nullable
    private com.facebook.imagepipeline.common.a lXA;
    private final k<com.facebook.imagepipeline.g.e> lXq;
    private final ak lXx;
    private long lXy = 0;
    private int lXz;

    public t(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.lXq = kVar;
        this.lXx = akVar;
    }

    public k<com.facebook.imagepipeline.g.e> dsh() {
        return this.lXq;
    }

    public ak dsi() {
        return this.lXx;
    }

    public String getId() {
        return this.lXx.getId();
    }

    public am drW() {
        return this.lXx.drW();
    }

    public Uri getUri() {
        return this.lXx.drV().dsO();
    }

    public long dsj() {
        return this.lXy;
    }

    public void fk(long j) {
        this.lXy = j;
    }

    public int dsk() {
        return this.lXz;
    }

    public void IR(int i) {
        this.lXz = i;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dsl() {
        return this.lXA;
    }

    public void c(com.facebook.imagepipeline.common.a aVar) {
        this.lXA = aVar;
    }

    public Map<String, String> dsm() {
        return this.lXx.drV().dsm();
    }
}
