package com.kwad.sdk.core.network.idc.a;
/* loaded from: classes10.dex */
public final class a {
    public final long auE;
    public volatile boolean auF = false;

    public a(long j, boolean z) {
        this.auE = j;
    }

    public final boolean CN() {
        return this.auF;
    }

    public final long CO() {
        return this.auE;
    }

    public final a bm(boolean z) {
        this.auF = true;
        return this;
    }
}
