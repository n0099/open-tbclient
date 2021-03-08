package com.yy.mediaframework.utils;

import com.baidu.searchbox.v8engine.util.TimeUtils;
/* loaded from: classes6.dex */
public class TimeUtil {
    public static int getTickCount() {
        return (int) (System.nanoTime() / TimeUtils.NANOS_PER_MS);
    }

    public static long getTickCountLong() {
        return System.nanoTime() / TimeUtils.NANOS_PER_MS;
    }
}
