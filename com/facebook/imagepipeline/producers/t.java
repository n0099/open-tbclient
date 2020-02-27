package com.facebook.imagepipeline.producers;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class t {
    private final ak lVE;
    private long lVF = 0;
    private int lVG;
    @Nullable
    private com.facebook.imagepipeline.common.a lVH;
    private final k<com.facebook.imagepipeline.g.e> lVx;

    public t(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.lVx = kVar;
        this.lVE = akVar;
    }

    public k<com.facebook.imagepipeline.g.e> drH() {
        return this.lVx;
    }

    public ak drI() {
        return this.lVE;
    }

    public String getId() {
        return this.lVE.getId();
    }

    public am drw() {
        return this.lVE.drw();
    }

    public Uri getUri() {
        return this.lVE.drv().dso();
    }

    public long drJ() {
        return this.lVF;
    }

    public void fj(long j) {
        this.lVF = j;
    }

    public int drK() {
        return this.lVG;
    }

    public void IL(int i) {
        this.lVG = i;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a drL() {
        return this.lVH;
    }

    public void c(com.facebook.imagepipeline.common.a aVar) {
        this.lVH = aVar;
    }

    public Map<String, String> drM() {
        return this.lVE.drv().drM();
    }
}
