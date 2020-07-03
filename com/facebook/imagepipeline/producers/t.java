package com.facebook.imagepipeline.producers;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class t {
    private final k<com.facebook.imagepipeline.g.e> mWn;
    private final ak mWu;
    private long mWv = 0;
    private int mWw;
    @Nullable
    private com.facebook.imagepipeline.common.a mWx;

    public t(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.mWn = kVar;
        this.mWu = akVar;
    }

    public k<com.facebook.imagepipeline.g.e> dGk() {
        return this.mWn;
    }

    public ak dGl() {
        return this.mWu;
    }

    public String getId() {
        return this.mWu.getId();
    }

    public am dFZ() {
        return this.mWu.dFZ();
    }

    public Uri getUri() {
        return this.mWu.dFY().dGQ();
    }

    public long dGm() {
        return this.mWv;
    }

    public void fV(long j) {
        this.mWv = j;
    }

    public int dGn() {
        return this.mWw;
    }

    public void Jo(int i) {
        this.mWw = i;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dGo() {
        return this.mWx;
    }

    public void c(com.facebook.imagepipeline.common.a aVar) {
        this.mWx = aVar;
    }

    public Map<String, String> dGp() {
        return this.mWu.dFY().dGp();
    }
}
