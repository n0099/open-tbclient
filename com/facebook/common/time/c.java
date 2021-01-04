package com.facebook.common.time;
/* loaded from: classes3.dex */
public class c implements a {
    private static final c ptK = new c();

    private c() {
    }

    public static c euo() {
        return ptK;
    }

    @Override // com.facebook.common.time.a
    public long now() {
        return System.currentTimeMillis();
    }
}
