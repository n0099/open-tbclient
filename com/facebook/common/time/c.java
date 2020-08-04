package com.facebook.common.time;
/* loaded from: classes12.dex */
public class c implements a {
    private static final c mRz = new c();

    private c() {
    }

    public static c dCT() {
        return mRz;
    }

    @Override // com.facebook.common.time.a
    public long now() {
        return System.currentTimeMillis();
    }
}
