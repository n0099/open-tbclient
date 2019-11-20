package com.facebook.common.time;
/* loaded from: classes2.dex */
public class b implements a {
    private static final b kaY = new b();

    private b() {
    }

    public static b cDh() {
        return kaY;
    }

    @Override // com.facebook.common.time.a
    public long now() {
        return System.currentTimeMillis();
    }
}
