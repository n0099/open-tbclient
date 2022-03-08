package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.downloader.s;
/* loaded from: classes8.dex */
public class j implements s {
    @Override // com.ss.android.socialbase.downloader.downloader.s
    public long a(int i2, int i3) {
        if (i2 == 1) {
            return 3000L;
        }
        if (i2 == 2) {
            return 15000L;
        }
        if (i2 == 3) {
            return 30000L;
        }
        return i2 > 3 ? 300000L : 0L;
    }
}
