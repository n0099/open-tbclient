package com.xiaomi.push;

import java.io.File;
import java.util.HashMap;
/* loaded from: classes18.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, String> f5128a = new HashMap<>();

    static {
        f5128a.put("FFD8FF", "jpg");
        f5128a.put("89504E47", "png");
        f5128a.put("47494638", "gif");
        f5128a.put("474946", "gif");
        f5128a.put("424D", "bmp");
    }

    public static long a(File file) {
        long j;
        Exception e;
        try {
            File[] listFiles = file.listFiles();
            j = 0;
            for (int i = 0; i < listFiles.length; i++) {
                try {
                    j += listFiles[i].isDirectory() ? a(listFiles[i]) : listFiles[i].length();
                } catch (Exception e2) {
                    e = e2;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    return j;
                }
            }
        } catch (Exception e3) {
            j = 0;
            e = e3;
        }
        return j;
    }
}
