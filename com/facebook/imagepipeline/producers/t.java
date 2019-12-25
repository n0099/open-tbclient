package com.facebook.imagepipeline.producers;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class t {
    private final k<com.facebook.imagepipeline.g.e> lQX;
    private final ak lRe;
    private long lRf = 0;
    private int lRg;
    @Nullable
    private com.facebook.imagepipeline.common.a lRh;

    public t(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.lQX = kVar;
        this.lRe = akVar;
    }

    public k<com.facebook.imagepipeline.g.e> dpj() {
        return this.lQX;
    }

    public ak dpk() {
        return this.lRe;
    }

    public String getId() {
        return this.lRe.getId();
    }

    public am doY() {
        return this.lRe.doY();
    }

    public Uri getUri() {
        return this.lRe.doX().dpN();
    }

    public long dpl() {
        return this.lRf;
    }

    public void fg(long j) {
        this.lRf = j;
    }

    public int dpm() {
        return this.lRg;
    }

    public void Ix(int i) {
        this.lRg = i;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dpn() {
        return this.lRh;
    }

    public void c(com.facebook.imagepipeline.common.a aVar) {
        this.lRh = aVar;
    }

    public Map<String, String> dpo() {
        return this.lRe.doX().dpo();
    }
}
