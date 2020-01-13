package com.facebook.common.time;
/* loaded from: classes12.dex */
public class c implements a {
    private static final c lIm = new c();

    private c() {
    }

    public static c djM() {
        return lIm;
    }

    @Override // com.facebook.common.time.a
    public long now() {
        return System.currentTimeMillis();
    }
}
