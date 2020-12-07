package com.facebook.common.time;
/* loaded from: classes19.dex */
public class c implements a {
    private static final c pcC = new c();

    private c() {
    }

    public static c eql() {
        return pcC;
    }

    @Override // com.facebook.common.time.a
    public long now() {
        return System.currentTimeMillis();
    }
}
