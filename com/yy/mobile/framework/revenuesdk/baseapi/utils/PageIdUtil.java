package com.yy.mobile.framework.revenuesdk.baseapi.utils;
/* loaded from: classes7.dex */
public class PageIdUtil {
    public static synchronized String newPageId() {
        String valueOf;
        synchronized (PageIdUtil.class) {
            valueOf = String.valueOf(UUIDProvider.getUUID());
        }
        return valueOf;
    }
}
