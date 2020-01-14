package com.facebook.imagepipeline.producers;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes10.dex */
public class t {
    private final k<com.facebook.imagepipeline.g.e> lUQ;
    private final ak lUX;
    private long lUY = 0;
    private int lUZ;
    @Nullable
    private com.facebook.imagepipeline.common.a lVa;

    public t(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.lUQ = kVar;
        this.lUX = akVar;
    }

    public k<com.facebook.imagepipeline.g.e> dqv() {
        return this.lUQ;
    }

    public ak dqw() {
        return this.lUX;
    }

    public String getId() {
        return this.lUX.getId();
    }

    public am dqk() {
        return this.lUX.dqk();
    }

    public Uri getUri() {
        return this.lUX.dqj().drc();
    }

    public long dqx() {
        return this.lUY;
    }

    public void fl(long j) {
        this.lUY = j;
    }

    public int dqy() {
        return this.lUZ;
    }

    public void IG(int i) {
        this.lUZ = i;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dqz() {
        return this.lVa;
    }

    public void c(com.facebook.imagepipeline.common.a aVar) {
        this.lVa = aVar;
    }

    public Map<String, String> dqA() {
        return this.lUX.dqj().dqA();
    }
}
