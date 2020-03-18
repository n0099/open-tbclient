package com.facebook.common.time;
/* loaded from: classes13.dex */
public class c implements a {
    private static final c lKR = new c();

    private c() {
    }

    public static c dlB() {
        return lKR;
    }

    @Override // com.facebook.common.time.a
    public long now() {
        return System.currentTimeMillis();
    }
}
