package com.yy.hiidostatis.inner.util;

import java.util.UUID;
/* loaded from: classes8.dex */
public class StringUtil {
    public static final int GUID_LEN = 20;

    public static String geneGuid() {
        return UUID.randomUUID().toString().substring(0, 20);
    }
}
