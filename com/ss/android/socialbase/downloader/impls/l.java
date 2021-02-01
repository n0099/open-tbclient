package com.ss.android.socialbase.downloader.impls;
/* loaded from: classes6.dex */
public class l {

    /* renamed from: b  reason: collision with root package name */
    private static volatile com.ss.android.socialbase.downloader.downloader.n f13193b;
    private static volatile com.ss.android.socialbase.downloader.downloader.n qfk;

    public static com.ss.android.socialbase.downloader.downloader.n CO(boolean z) {
        if (z) {
            if (f13193b == null) {
                synchronized (l.class) {
                    if (f13193b == null) {
                        f13193b = new o();
                    }
                }
            }
            return f13193b;
        }
        if (qfk == null) {
            synchronized (l.class) {
                if (qfk == null) {
                    qfk = new p();
                }
            }
        }
        return qfk;
    }
}
