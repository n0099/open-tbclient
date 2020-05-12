package com.facebook.imagepipeline.producers;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class t {
    private final k<com.facebook.imagepipeline.g.e> mff;
    private final ak mfm;
    private long mfn = 0;
    private int mfo;
    @Nullable
    private com.facebook.imagepipeline.common.a mfp;

    public t(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.mff = kVar;
        this.mfm = akVar;
    }

    public k<com.facebook.imagepipeline.g.e> dud() {
        return this.mff;
    }

    public ak due() {
        return this.mfm;
    }

    public String getId() {
        return this.mfm.getId();
    }

    public am dtS() {
        return this.mfm.dtS();
    }

    public Uri getUri() {
        return this.mfm.dtR().duJ();
    }

    public long duf() {
        return this.mfn;
    }

    public void fQ(long j) {
        this.mfn = j;
    }

    public int dug() {
        return this.mfo;
    }

    public void Ht(int i) {
        this.mfo = i;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a duh() {
        return this.mfp;
    }

    public void c(com.facebook.imagepipeline.common.a aVar) {
        this.mfp = aVar;
    }

    public Map<String, String> dui() {
        return this.mfm.dtR().dui();
    }
}
