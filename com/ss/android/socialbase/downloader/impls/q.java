package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.s;
/* loaded from: classes4.dex */
public class q implements s {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f13494a;

    public q(String str) {
        this.f13494a = a(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.s
    public long a(int i, int i2) {
        if (this.f13494a == null || this.f13494a.length <= 0) {
            return 0L;
        }
        int i3 = i - 1;
        if (i3 < 0) {
            i3 = 0;
        }
        if (i3 > this.f13494a.length - 1) {
            i3 = this.f13494a.length - 1;
        }
        return this.f13494a[i3];
    }

    private long[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            if (split.length != 0) {
                long[] jArr = new long[split.length];
                for (int i = 0; i < split.length; i++) {
                    jArr[i] = Long.parseLong(split[i]);
                }
                return jArr;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
