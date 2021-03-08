package com.ss.android.socialbase.downloader.impls;
/* loaded from: classes6.dex */
public class l {
    private static volatile com.ss.android.socialbase.downloader.downloader.n b;
    private static volatile com.ss.android.socialbase.downloader.downloader.n qgz;

    public static com.ss.android.socialbase.downloader.downloader.n CM(boolean z) {
        if (z) {
            if (b == null) {
                synchronized (l.class) {
                    if (b == null) {
                        b = new o();
                    }
                }
            }
            return b;
        }
        if (qgz == null) {
            synchronized (l.class) {
                if (qgz == null) {
                    qgz = new p();
                }
            }
        }
        return qgz;
    }
}
