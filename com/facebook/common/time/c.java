package com.facebook.common.time;
/* loaded from: classes4.dex */
public class c implements a {
    private static final c pCe = new c();

    private c() {
    }

    public static c etl() {
        return pCe;
    }

    @Override // com.facebook.common.time.a
    public long now() {
        return System.currentTimeMillis();
    }
}
