package com.facebook.imagepipeline.producers;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class t {
    private long neA = 0;
    private int neB;
    @Nullable
    private com.facebook.imagepipeline.common.a neC;
    private final k<com.facebook.imagepipeline.g.e> ner;
    private final ak nez;

    public t(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.ner = kVar;
        this.nez = akVar;
    }

    public k<com.facebook.imagepipeline.g.e> dJA() {
        return this.ner;
    }

    public ak dJB() {
        return this.nez;
    }

    public String getId() {
        return this.nez.getId();
    }

    public am dJp() {
        return this.nez.dJp();
    }

    public Uri getUri() {
        return this.nez.dJo().dKg();
    }

    public long dJC() {
        return this.neA;
    }

    public void gi(long j) {
        this.neA = j;
    }

    public int dJD() {
        return this.neB;
    }

    public void JJ(int i) {
        this.neB = i;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dJE() {
        return this.neC;
    }

    public void c(com.facebook.imagepipeline.common.a aVar) {
        this.neC = aVar;
    }

    public Map<String, String> dJF() {
        return this.nez.dJo().dJF();
    }
}
