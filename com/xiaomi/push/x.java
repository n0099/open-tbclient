package com.xiaomi.push;

import java.io.File;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, String> f41075a;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f41075a = hashMap;
        hashMap.put("FFD8FF", "jpg");
        f41075a.put("89504E47", "png");
        f41075a.put("47494638", "gif");
        f41075a.put("474946", "gif");
        f41075a.put("424D", "bmp");
    }

    public static long a(File file) {
        long j = 0;
        try {
            File[] listFiles = file.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                j += listFiles[i].isDirectory() ? a(listFiles[i]) : listFiles[i].length();
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
        return j;
    }
}
