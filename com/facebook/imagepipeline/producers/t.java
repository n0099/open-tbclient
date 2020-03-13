package com.facebook.imagepipeline.producers;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class t {
    private final k<com.facebook.imagepipeline.g.e> lVK;
    private final ak lVR;
    private long lVS = 0;
    private int lVT;
    @Nullable
    private com.facebook.imagepipeline.common.a lVU;

    public t(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.lVK = kVar;
        this.lVR = akVar;
    }

    public k<com.facebook.imagepipeline.g.e> drK() {
        return this.lVK;
    }

    public ak drL() {
        return this.lVR;
    }

    public String getId() {
        return this.lVR.getId();
    }

    public am drz() {
        return this.lVR.drz();
    }

    public Uri getUri() {
        return this.lVR.dry().dsr();
    }

    public long drM() {
        return this.lVS;
    }

    public void fj(long j) {
        this.lVS = j;
    }

    public int drN() {
        return this.lVT;
    }

    public void IL(int i) {
        this.lVT = i;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a drO() {
        return this.lVU;
    }

    public void c(com.facebook.imagepipeline.common.a aVar) {
        this.lVU = aVar;
    }

    public Map<String, String> drP() {
        return this.lVR.dry().drP();
    }
}
