package com.xiaomi.push;

import com.baidu.searchbox.crius.constants.NativeConstants;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class x {
    public static final HashMap<String, String> a;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put("FFD8FF", "jpg");
        a.put("89504E47", "png");
        a.put("47494638", NativeConstants.TYPE_GIF);
        a.put("474946", NativeConstants.TYPE_GIF);
        a.put("424D", "bmp");
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
