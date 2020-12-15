package com.facebook.common.time;
/* loaded from: classes19.dex */
public class c implements a {
    private static final c pcE = new c();

    private c() {
    }

    public static c eqm() {
        return pcE;
    }

    @Override // com.facebook.common.time.a
    public long now() {
        return System.currentTimeMillis();
    }
}
