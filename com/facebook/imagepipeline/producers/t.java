package com.facebook.imagepipeline.producers;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes10.dex */
public class t {
    private final k<com.facebook.imagepipeline.g.e> lUL;
    private final ak lUS;
    private long lUT = 0;
    private int lUU;
    @Nullable
    private com.facebook.imagepipeline.common.a lUV;

    public t(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.lUL = kVar;
        this.lUS = akVar;
    }

    public k<com.facebook.imagepipeline.g.e> dqt() {
        return this.lUL;
    }

    public ak dqu() {
        return this.lUS;
    }

    public String getId() {
        return this.lUS.getId();
    }

    public am dqi() {
        return this.lUS.dqi();
    }

    public Uri getUri() {
        return this.lUS.dqh().dra();
    }

    public long dqv() {
        return this.lUT;
    }

    public void fl(long j) {
        this.lUT = j;
    }

    public int dqw() {
        return this.lUU;
    }

    public void IG(int i) {
        this.lUU = i;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dqx() {
        return this.lUV;
    }

    public void c(com.facebook.imagepipeline.common.a aVar) {
        this.lUV = aVar;
    }

    public Map<String, String> dqy() {
        return this.lUS.dqh().dqy();
    }
}
