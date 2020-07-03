package com.facebook.common.time;
/* loaded from: classes13.dex */
public class c implements a {
    private static final c mJr = new c();

    private c() {
    }

    public static c dzC() {
        return mJr;
    }

    @Override // com.facebook.common.time.a
    public long now() {
        return System.currentTimeMillis();
    }
}
