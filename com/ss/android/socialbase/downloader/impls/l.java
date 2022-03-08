package com.ss.android.socialbase.downloader.impls;
/* loaded from: classes8.dex */
public class l {
    public static volatile com.ss.android.socialbase.downloader.downloader.m a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile com.ss.android.socialbase.downloader.downloader.m f58731b;

    public static com.ss.android.socialbase.downloader.downloader.m a(boolean z) {
        if (z && com.ss.android.socialbase.downloader.downloader.c.S()) {
            if (f58731b == null) {
                synchronized (l.class) {
                    if (f58731b == null) {
                        f58731b = com.ss.android.socialbase.downloader.downloader.c.T().b();
                    }
                }
            }
            return f58731b;
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
