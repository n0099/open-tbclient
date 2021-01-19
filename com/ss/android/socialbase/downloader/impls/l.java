package com.ss.android.socialbase.downloader.impls;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: b  reason: collision with root package name */
    private static volatile com.ss.android.socialbase.downloader.downloader.n f13191b;
    private static volatile com.ss.android.socialbase.downloader.downloader.n pVg;

    public static com.ss.android.socialbase.downloader.downloader.n Cu(boolean z) {
        if (z) {
            if (f13191b == null) {
                synchronized (l.class) {
                    if (f13191b == null) {
                        f13191b = new o();
                    }
                }
            }
            return f13191b;
        }
        if (pVg == null) {
            synchronized (l.class) {
                if (pVg == null) {
                    pVg = new p();
                }
            }
        }
        return pVg;
    }
}
