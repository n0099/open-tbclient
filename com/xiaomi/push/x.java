package com.xiaomi.push;

import java.io.File;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, String> f39005a;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f39005a = hashMap;
        hashMap.put("FFD8FF", "jpg");
        f39005a.put("89504E47", "png");
        f39005a.put("47494638", "gif");
        f39005a.put("474946", "gif");
        f39005a.put("424D", "bmp");
    }

    public static long a(File file) {
        long j = 0;
        try {
            File[] listFiles = file.listFiles();
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                j += listFiles[i2].isDirectory() ? a(listFiles[i2]) : listFiles[i2].length();
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
        return j;
    }
}
