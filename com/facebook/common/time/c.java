package com.facebook.common.time;
/* loaded from: classes3.dex */
public class c implements a {
    private static final c ptR = new c();

    private c() {
    }

    public static c euv() {
        return ptR;
    }

    @Override // com.facebook.common.time.a
    public long now() {
        return System.currentTimeMillis();
    }
}
