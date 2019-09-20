package com.facebook.imagepipeline.producers;

import android.net.Uri;
/* loaded from: classes2.dex */
public class s {
    private final j<com.facebook.imagepipeline.f.d> kni;
    private final aj knp;
    private long knq = 0;

    public s(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.kni = jVar;
        this.knp = ajVar;
    }

    public j<com.facebook.imagepipeline.f.d> cLX() {
        return this.kni;
    }

    public aj cLY() {
        return this.knp;
    }

    public String getId() {
        return this.knp.getId();
    }

    public al cLL() {
        return this.knp.cLL();
    }

    public Uri getUri() {
        return this.knp.cLK().cMx();
    }

    public long cLZ() {
        return this.knq;
    }

    public void eO(long j) {
        this.knq = j;
    }
}
