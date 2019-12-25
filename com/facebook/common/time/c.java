package com.facebook.common.time;
/* loaded from: classes11.dex */
public class c implements a {
    private static final c lEO = new c();

    private c() {
    }

    public static c diL() {
        return lEO;
    }

    @Override // com.facebook.common.time.a
    public long now() {
        return System.currentTimeMillis();
    }
}
