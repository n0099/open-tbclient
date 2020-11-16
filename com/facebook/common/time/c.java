package com.facebook.common.time;
/* loaded from: classes12.dex */
public class c implements a {
    private static final c oNu = new c();

    private c() {
    }

    public static c ekw() {
        return oNu;
    }

    @Override // com.facebook.common.time.a
    public long now() {
        return System.currentTimeMillis();
    }
}
