package com.ss.android.socialbase.downloader.impls;

import com.baidu.android.imsdk.internal.IMConnection;
import com.ss.android.socialbase.downloader.downloader.s;
/* loaded from: classes6.dex */
public class j implements s {
    @Override // com.ss.android.socialbase.downloader.downloader.s
    public long a(int i, int i2) {
        if (i == 1) {
            return IMConnection.RETRY_DELAY_TIMES;
        }
        if (i == 2) {
            return 15000L;
        }
        if (i == 3) {
            return 30000L;
        }
        if (i > 3) {
            return 300000L;
        }
        return 0L;
    }
}
