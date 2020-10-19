package com.facebook.imagepipeline.producers;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class t {
    private final k<com.facebook.imagepipeline.g.e> nXP;
    private final ak nXW;
    private long nXX = 0;
    private int nXY;
    @Nullable
    private com.facebook.imagepipeline.common.a nXZ;

    public t(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.nXP = kVar;
        this.nXW = akVar;
    }

    public k<com.facebook.imagepipeline.g.e> eds() {
        return this.nXP;
    }

    public ak edt() {
        return this.nXW;
    }

    public String getId() {
        return this.nXW.getId();
    }

    public am edh() {
        return this.nXW.edh();
    }

    public Uri getUri() {
        return this.nXW.edg().edY();
    }

    public long edu() {
        return this.nXX;
    }

    public void hd(long j) {
        this.nXX = j;
    }

    public int edv() {
        return this.nXY;
    }

    public void Ny(int i) {
        this.nXY = i;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a edw() {
        return this.nXZ;
    }

    public void c(com.facebook.imagepipeline.common.a aVar) {
        this.nXZ = aVar;
    }

    public Map<String, String> edx() {
        return this.nXW.edg().edx();
    }
}
