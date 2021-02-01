package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class i implements com.ss.android.socialbase.downloader.downloader.l {
    @Override // com.ss.android.socialbase.downloader.downloader.l
    public int a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String d = com.ss.android.socialbase.downloader.m.d.d(String.format("%s_%s", str, str2));
        if (TextUtils.isEmpty(d)) {
            return 0;
        }
        return d.hashCode();
    }
}
