package com.facebook.common.time;
/* loaded from: classes6.dex */
public class c implements a {
    private static final c nLe = new c();

    private c() {
    }

    public static c dWL() {
        return nLe;
    }

    @Override // com.facebook.common.time.a
    public long now() {
        return System.currentTimeMillis();
    }
}
