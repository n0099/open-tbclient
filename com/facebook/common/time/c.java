package com.facebook.common.time;
/* loaded from: classes13.dex */
public class c implements a {
    private static final c mmh = new c();

    private c() {
    }

    public static c duL() {
        return mmh;
    }

    @Override // com.facebook.common.time.a
    public long now() {
        return System.currentTimeMillis();
    }
}
