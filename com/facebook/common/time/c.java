package com.facebook.common.time;
/* loaded from: classes6.dex */
public class c implements a {
    private static final c oCx = new c();

    private c() {
    }

    public static c egJ() {
        return oCx;
    }

    @Override // com.facebook.common.time.a
    public long now() {
        return System.currentTimeMillis();
    }
}
