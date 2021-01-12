package com.xiaomi.push;

import java.io.File;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, String> f14331a = new HashMap<>();

    static {
        f14331a.put("FFD8FF", "jpg");
        f14331a.put("89504E47", "png");
        f14331a.put("47494638", "gif");
        f14331a.put("474946", "gif");
        f14331a.put("424D", "bmp");
    }

    public static long a(File file) {
        long j = 0;
        try {
            File[] listFiles = file.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                j += listFiles[i].isDirectory() ? a(listFiles[i]) : listFiles[i].length();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
        return j;
    }
}
