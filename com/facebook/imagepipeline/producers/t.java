package com.facebook.imagepipeline.producers;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class t {
    private final k<com.facebook.imagepipeline.g.e> oPh;
    private final ak oPo;
    private long oPp = 0;
    private int oPq;
    @Nullable
    private com.facebook.imagepipeline.common.a oPr;

    public t(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.oPh = kVar;
        this.oPo = akVar;
    }

    public k<com.facebook.imagepipeline.g.e> enr() {
        return this.oPh;
    }

    public ak ens() {
        return this.oPo;
    }

    public String getId() {
        return this.oPo.getId();
    }

    public am eng() {
        return this.oPo.eng();
    }

    public Uri getUri() {
        return this.oPo.enf().enX();
    }

    public long ent() {
        return this.oPp;
    }

    public void ht(long j) {
        this.oPp = j;
    }

    public int enu() {
        return this.oPq;
    }

    public void Pp(int i) {
        this.oPq = i;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a env() {
        return this.oPr;
    }

    public void c(com.facebook.imagepipeline.common.a aVar) {
        this.oPr = aVar;
    }

    public Map<String, String> enw() {
        return this.oPo.enf().enw();
    }
}
