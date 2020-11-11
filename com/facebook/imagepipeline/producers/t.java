package com.facebook.imagepipeline.producers;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class t {
    private final k<com.facebook.imagepipeline.g.e> oYA;
    private final ak oYH;
    private long oYI = 0;
    private int oYJ;
    @Nullable
    private com.facebook.imagepipeline.common.a oYK;

    public t(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.oYA = kVar;
        this.oYH = akVar;
    }

    public k<com.facebook.imagepipeline.g.e> erh() {
        return this.oYA;
    }

    public ak eri() {
        return this.oYH;
    }

    public String getId() {
        return this.oYH.getId();
    }

    public am eqW() {
        return this.oYH.eqW();
    }

    public Uri getUri() {
        return this.oYH.eqV().erN();
    }

    public long erj() {
        return this.oYI;
    }

    public void hP(long j) {
        this.oYI = j;
    }

    public int erk() {
        return this.oYJ;
    }

    public void PK(int i) {
        this.oYJ = i;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a erl() {
        return this.oYK;
    }

    public void c(com.facebook.imagepipeline.common.a aVar) {
        this.oYK = aVar;
    }

    public Map<String, String> erm() {
        return this.oYH.eqV().erm();
    }
}
