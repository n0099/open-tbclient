package com.ss.android.socialbase.downloader.impls;
/* loaded from: classes6.dex */
public class b implements com.ss.android.socialbase.downloader.downloader.h {
    @Override // com.ss.android.socialbase.downloader.downloader.h
    public int a(int i, com.ss.android.socialbase.downloader.i.k kVar) {
        if (kVar.ordinal() <= com.ss.android.socialbase.downloader.i.k.MODERATE.ordinal()) {
            return 1;
        }
        if (kVar == com.ss.android.socialbase.downloader.i.k.GOOD) {
            return i - 1;
        }
        return i;
    }
}
