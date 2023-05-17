package com.yy.mobile.framework.revenuesdk.baseapi.utils;

import java.util.UUID;
/* loaded from: classes10.dex */
public class UUIDProvider {
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
