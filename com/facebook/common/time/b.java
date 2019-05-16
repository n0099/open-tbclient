package com.facebook.common.time;
/* loaded from: classes2.dex */
public class b implements a {
    private static final b jSV = new b();

    private b() {
    }

    public static b cCa() {
        return jSV;
    }

    @Override // com.facebook.common.time.a
    public long now() {
        return System.currentTimeMillis();
    }
}
