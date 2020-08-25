package com.facebook.common.time;
/* loaded from: classes9.dex */
public class c implements a {
    private static final c nlt = new c();

    private c() {
    }

    public static c dOT() {
        return nlt;
    }

    @Override // com.facebook.common.time.a
    public long now() {
        return System.currentTimeMillis();
    }
}
