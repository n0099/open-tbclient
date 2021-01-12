package com.facebook.common.time;
/* loaded from: classes14.dex */
public class c implements a {
    private static final c ppp = new c();

    private c() {
    }

    public static c eqB() {
        return ppp;
    }

    @Override // com.facebook.common.time.a
    public long now() {
        return System.currentTimeMillis();
    }
}
