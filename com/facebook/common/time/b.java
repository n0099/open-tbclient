package com.facebook.common.time;
/* loaded from: classes2.dex */
public class b implements a {
    private static final b kbP = new b();

    private b() {
    }

    public static b cDj() {
        return kbP;
    }

    @Override // com.facebook.common.time.a
    public long now() {
        return System.currentTimeMillis();
    }
}
