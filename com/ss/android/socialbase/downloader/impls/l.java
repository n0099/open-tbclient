package com.ss.android.socialbase.downloader.impls;
/* loaded from: classes3.dex */
public class l {
    public static volatile com.ss.android.socialbase.downloader.downloader.m a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile com.ss.android.socialbase.downloader.downloader.m f60169b;

    public static com.ss.android.socialbase.downloader.downloader.m a(boolean z) {
        if (z && com.ss.android.socialbase.downloader.downloader.c.S()) {
            if (f60169b == null) {
                synchronized (l.class) {
                    if (f60169b == null) {
                        f60169b = com.ss.android.socialbase.downloader.downloader.c.T().b();
                    }
                }
            }
            return f60169b;
        }
        if (a == null) {
            synchronized (l.class) {
                if (a == null) {
                    a = new p();
                }
            }
        }
        return a;
    }
}
