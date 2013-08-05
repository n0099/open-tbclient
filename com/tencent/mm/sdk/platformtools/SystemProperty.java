package com.tencent.mm.sdk.platformtools;

import java.util.HashMap;
/* loaded from: classes.dex */
public final class SystemProperty {
    private static final HashMap bf = new HashMap();

    private SystemProperty() {
    }

    public static String getProperty(String str) {
        return (String) bf.get(str);
    }

    public static void setProperty(String str, String str2) {
        bf.put(str, str2);
    }
}
