package com.bytedance.sdk.openadsdk.utils;

import android.os.StatFs;
import android.text.TextUtils;
/* loaded from: classes6.dex */
public class v {
    public static long a(String str) {
        long j = 0;
        try {
            if (!TextUtils.isEmpty(str)) {
                StatFs statFs = new StatFs(str);
                j = statFs.getAvailableBlocks() * statFs.getBlockSize();
            }
            u.b("MemorySize", "getAvailableSize=" + j + ", " + String.valueOf(str));
        } catch (Throwable th) {
            u.b("MemorySize", "getAvailableSize=0, " + String.valueOf(str));
        }
        return j;
    }
}
