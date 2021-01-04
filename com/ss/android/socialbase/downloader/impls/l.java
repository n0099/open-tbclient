package com.ss.android.socialbase.downloader.impls;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: b  reason: collision with root package name */
    private static volatile com.ss.android.socialbase.downloader.downloader.n f13490b;
    private static volatile com.ss.android.socialbase.downloader.downloader.n pXY;

    public static com.ss.android.socialbase.downloader.downloader.n Cy(boolean z) {
        if (z) {
            if (f13490b == null) {
                synchronized (l.class) {
                    if (f13490b == null) {
                        f13490b = new o();
                    }
                }
            }
            return f13490b;
        }
        if (pXY == null) {
            synchronized (l.class) {
                if (pXY == null) {
                    pXY = new p();
                }
            }
        }
        return pXY;
    }
}
