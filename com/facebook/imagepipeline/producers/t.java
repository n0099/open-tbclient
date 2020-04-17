package com.facebook.imagepipeline.producers;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class t {
    private final k<com.facebook.imagepipeline.g.e> mfb;
    private final ak mfi;
    private long mfj = 0;
    private int mfk;
    @Nullable
    private com.facebook.imagepipeline.common.a mfl;

    public t(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.mfb = kVar;
        this.mfi = akVar;
    }

    public k<com.facebook.imagepipeline.g.e> duf() {
        return this.mfb;
    }

    public ak dug() {
        return this.mfi;
    }

    public String getId() {
        return this.mfi.getId();
    }

    public am dtU() {
        return this.mfi.dtU();
    }

    public Uri getUri() {
        return this.mfi.dtT().duL();
    }

    public long duh() {
        return this.mfj;
    }

    public void fQ(long j) {
        this.mfj = j;
    }

    public int dui() {
        return this.mfk;
    }

    public void Ht(int i) {
        this.mfk = i;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a duj() {
        return this.mfl;
    }

    public void c(com.facebook.imagepipeline.common.a aVar) {
        this.mfl = aVar;
    }

    public Map<String, String> duk() {
        return this.mfi.dtT().duk();
    }
}
