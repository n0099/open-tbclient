package com.facebook.imagepipeline.producers;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class t {
    private final ak neB;
    private long neC = 0;
    private int neD;
    @Nullable
    private com.facebook.imagepipeline.common.a neE;
    private final k<com.facebook.imagepipeline.g.e> neu;

    public t(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.neu = kVar;
        this.neB = akVar;
    }

    public k<com.facebook.imagepipeline.g.e> dJB() {
        return this.neu;
    }

    public ak dJC() {
        return this.neB;
    }

    public String getId() {
        return this.neB.getId();
    }

    public am dJq() {
        return this.neB.dJq();
    }

    public Uri getUri() {
        return this.neB.dJp().dKh();
    }

    public long dJD() {
        return this.neC;
    }

    public void gi(long j) {
        this.neC = j;
    }

    public int dJE() {
        return this.neD;
    }

    public void JJ(int i) {
        this.neD = i;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dJF() {
        return this.neE;
    }

    public void c(com.facebook.imagepipeline.common.a aVar) {
        this.neE = aVar;
    }

    public Map<String, String> dJG() {
        return this.neB.dJp().dJG();
    }
}
