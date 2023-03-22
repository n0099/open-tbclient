package com.yy.mobile.framework.revenuesdk.baseapi.utils;
/* loaded from: classes9.dex */
public class TraceIdUtil {
    public static synchronized String newTraceId() {
        String valueOf;
        synchronized (TraceIdUtil.class) {
            valueOf = String.valueOf(UUIDProvider.getUUID());
        }
        return valueOf;
    }
}
