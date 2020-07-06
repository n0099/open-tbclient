package com.facebook.imagepipeline.producers;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class t {
    @Nullable
    private com.facebook.imagepipeline.common.a mWA;
    private final k<com.facebook.imagepipeline.g.e> mWq;
    private final ak mWx;
    private long mWy = 0;
    private int mWz;

    public t(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.mWq = kVar;
        this.mWx = akVar;
    }

    public k<com.facebook.imagepipeline.g.e> dGo() {
        return this.mWq;
    }

    public ak dGp() {
        return this.mWx;
    }

    public String getId() {
        return this.mWx.getId();
    }

    public am dGd() {
        return this.mWx.dGd();
    }

    public Uri getUri() {
        return this.mWx.dGc().dGU();
    }

    public long dGq() {
        return this.mWy;
    }

    public void fV(long j) {
        this.mWy = j;
    }

    public int dGr() {
        return this.mWz;
    }

    public void Jo(int i) {
        this.mWz = i;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dGs() {
        return this.mWA;
    }

    public void c(com.facebook.imagepipeline.common.a aVar) {
        this.mWA = aVar;
    }

    public Map<String, String> dGt() {
        return this.mWx.dGc().dGt();
    }
}
