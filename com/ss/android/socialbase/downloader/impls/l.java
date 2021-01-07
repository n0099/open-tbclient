package com.ss.android.socialbase.downloader.impls;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: b  reason: collision with root package name */
    private static volatile com.ss.android.socialbase.downloader.downloader.n f13491b;
    private static volatile com.ss.android.socialbase.downloader.downloader.n pZG;

    public static com.ss.android.socialbase.downloader.downloader.n Cy(boolean z) {
        if (z) {
            if (f13491b == null) {
                synchronized (l.class) {
                    if (f13491b == null) {
                        f13491b = new o();
                    }
                }
            }
            return f13491b;
        }
        if (pZG == null) {
            synchronized (l.class) {
                if (pZG == null) {
                    pZG = new p();
                }
            }
        }
        return pZG;
    }
}
