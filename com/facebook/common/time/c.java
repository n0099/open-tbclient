package com.facebook.common.time;
/* loaded from: classes17.dex */
public class c implements a {
    private static final c nvL = new c();

    private c() {
    }

    public static c dTa() {
        return nvL;
    }

    @Override // com.facebook.common.time.a
    public long now() {
        return System.currentTimeMillis();
    }
}
