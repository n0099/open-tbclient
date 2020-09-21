package com.facebook.imagepipeline.producers;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes25.dex */
public class t {
    private final ak nIF;
    private long nIG = 0;
    private int nIH;
    @Nullable
    private com.facebook.imagepipeline.common.a nII;
    private final k<com.facebook.imagepipeline.g.e> nIy;

    public t(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.nIy = kVar;
        this.nIF = akVar;
    }

    public k<com.facebook.imagepipeline.g.e> dZH() {
        return this.nIy;
    }

    public ak dZI() {
        return this.nIF;
    }

    public String getId() {
        return this.nIF.getId();
    }

    public am dZw() {
        return this.nIF.dZw();
    }

    public Uri getUri() {
        return this.nIF.dZv().ean();
    }

    public long dZJ() {
        return this.nIG;
    }

    public void gL(long j) {
        this.nIG = j;
    }

    public int dZK() {
        return this.nIH;
    }

    public void MS(int i) {
        this.nIH = i;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dZL() {
        return this.nII;
    }

    public void c(com.facebook.imagepipeline.common.a aVar) {
        this.nII = aVar;
    }

    public Map<String, String> dZM() {
        return this.nIF.dZv().dZM();
    }
}
