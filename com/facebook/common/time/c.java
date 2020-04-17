package com.facebook.common.time;
/* loaded from: classes13.dex */
public class c implements a {
    private static final c lSl = new c();

    private c() {
    }

    public static c dnv() {
        return lSl;
    }

    @Override // com.facebook.common.time.a
    public long now() {
        return System.currentTimeMillis();
    }
}
