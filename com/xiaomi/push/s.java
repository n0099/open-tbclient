package com.xiaomi.push;
/* loaded from: classes3.dex */
public class s {
    public static String a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m30a("SystemProperties.get: " + e);
            return str2;
        }
    }
}
