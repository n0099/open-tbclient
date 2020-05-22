package com.facebook.imagepipeline.producers;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class t {
    private final k<com.facebook.imagepipeline.g.e> myW;
    private final ak mzd;
    private long mze = 0;
    private int mzf;
    @Nullable
    private com.facebook.imagepipeline.common.a mzg;

    public t(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.myW = kVar;
        this.mzd = akVar;
    }

    public k<com.facebook.imagepipeline.g.e> dBu() {
        return this.myW;
    }

    public ak dBv() {
        return this.mzd;
    }

    public String getId() {
        return this.mzd.getId();
    }

    public am dBj() {
        return this.mzd.dBj();
    }

    public Uri getUri() {
        return this.mzd.dBi().dCa();
    }

    public long dBw() {
        return this.mze;
    }

    public void fQ(long j) {
        this.mze = j;
    }

    public int dBx() {
        return this.mzf;
    }

    public void If(int i) {
        this.mzf = i;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dBy() {
        return this.mzg;
    }

    public void c(com.facebook.imagepipeline.common.a aVar) {
        this.mzg = aVar;
    }

    public Map<String, String> dBz() {
        return this.mzd.dBi().dBz();
    }
}
