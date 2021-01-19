package com.facebook.common.time;
/* loaded from: classes14.dex */
public class c implements a {
    private static final c ppq = new c();

    private c() {
    }

    public static c eqB() {
        return ppq;
    }

    @Override // com.facebook.common.time.a
    public long now() {
        return System.currentTimeMillis();
    }
}
