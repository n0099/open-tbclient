package com.facebook.imagepipeline.producers;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class t {
    private final k<com.facebook.imagepipeline.g.e> pae;
    private final ak pal;
    private long pam = 0;
    private int pan;
    @Nullable
    private com.facebook.imagepipeline.common.a pao;

    public t(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.pae = kVar;
        this.pal = akVar;
    }

    public k<com.facebook.imagepipeline.g.e> erf() {
        return this.pae;
    }

    public ak erg() {
        return this.pal;
    }

    public String getId() {
        return this.pal.getId();
    }

    public am eqU() {
        return this.pal.eqU();
    }

    public Uri getUri() {
        return this.pal.eqT().erL();
    }

    public long erh() {
        return this.pam;
    }

    public void hS(long j) {
        this.pam = j;
    }

    public int eri() {
        return this.pan;
    }

    public void Qn(int i) {
        this.pan = i;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a erj() {
        return this.pao;
    }

    public void c(com.facebook.imagepipeline.common.a aVar) {
        this.pao = aVar;
    }

    public Map<String, String> erk() {
        return this.pal.eqT().erk();
    }
}
