package com.facebook.common.time;
/* loaded from: classes13.dex */
public class c implements a {
    private static final c mnr = new c();

    private c() {
    }

    public static c duZ() {
        return mnr;
    }

    @Override // com.facebook.common.time.a
    public long now() {
        return System.currentTimeMillis();
    }
}
