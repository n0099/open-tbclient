package com.facebook.imagepipeline.producers;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class t {
    private final ak lVG;
    private long lVH = 0;
    private int lVI;
    @Nullable
    private com.facebook.imagepipeline.common.a lVJ;
    private final k<com.facebook.imagepipeline.g.e> lVz;

    public t(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.lVz = kVar;
        this.lVG = akVar;
    }

    public k<com.facebook.imagepipeline.g.e> drJ() {
        return this.lVz;
    }

    public ak drK() {
        return this.lVG;
    }

    public String getId() {
        return this.lVG.getId();
    }

    public am dry() {
        return this.lVG.dry();
    }

    public Uri getUri() {
        return this.lVG.drx().dsq();
    }

    public long drL() {
        return this.lVH;
    }

    public void fj(long j) {
        this.lVH = j;
    }

    public int drM() {
        return this.lVI;
    }

    public void IL(int i) {
        this.lVI = i;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a drN() {
        return this.lVJ;
    }

    public void c(com.facebook.imagepipeline.common.a aVar) {
        this.lVJ = aVar;
    }

    public Map<String, String> drO() {
        return this.lVG.drx().drO();
    }
}
