package com.yy.mobile.framework.revenuesdk.baseapi.utils;

import java.util.UUID;
/* loaded from: classes7.dex */
public class SeqUtil {
    public static synchronized String increaseSeqId() {
        String uuid;
        synchronized (SeqUtil.class) {
            uuid = UUID.randomUUID().toString();
        }
        return uuid;
    }
}
