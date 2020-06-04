package com.facebook.imagepipeline.producers;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class t {
    private final k<com.facebook.imagepipeline.g.e> mAg;
    private final ak mAn;
    private long mAo = 0;
    private int mAp;
    @Nullable
    private com.facebook.imagepipeline.common.a mAq;

    public t(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.mAg = kVar;
        this.mAn = akVar;
    }

    public k<com.facebook.imagepipeline.g.e> dBI() {
        return this.mAg;
    }

    public ak dBJ() {
        return this.mAn;
    }

    public String getId() {
        return this.mAn.getId();
    }

    public am dBx() {
        return this.mAn.dBx();
    }

    public Uri getUri() {
        return this.mAn.dBw().dCo();
    }

    public long dBK() {
        return this.mAo;
    }

    public void fQ(long j) {
        this.mAo = j;
    }

    public int dBL() {
        return this.mAp;
    }

    public void Ih(int i) {
        this.mAp = i;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dBM() {
        return this.mAq;
    }

    public void c(com.facebook.imagepipeline.common.a aVar) {
        this.mAq = aVar;
    }

    public Map<String, String> dBN() {
        return this.mAn.dBw().dBN();
    }
}
