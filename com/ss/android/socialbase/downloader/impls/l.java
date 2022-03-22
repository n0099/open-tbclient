package com.ss.android.socialbase.downloader.impls;
/* loaded from: classes7.dex */
public class l {
    public static volatile com.ss.android.socialbase.downloader.downloader.m a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile com.ss.android.socialbase.downloader.downloader.m f43431b;

    public static com.ss.android.socialbase.downloader.downloader.m a(boolean z) {
        if (z && com.ss.android.socialbase.downloader.downloader.c.S()) {
            if (f43431b == null) {
                synchronized (l.class) {
                    if (f43431b == null) {
                        f43431b = com.ss.android.socialbase.downloader.downloader.c.T().b();
                    }
                }
            }
            return f43431b;
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
