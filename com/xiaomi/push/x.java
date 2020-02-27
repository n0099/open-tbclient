package com.xiaomi.push;

import com.baidu.searchbox.picture.component.BaseBrowseView;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class x {
    private static final HashMap<String, String> a = new HashMap<>();

    static {
        a.put("FFD8FF", "jpg");
        a.put("89504E47", "png");
        a.put("47494638", BaseBrowseView.IMG_TYPE_GIF);
        a.put("474946", BaseBrowseView.IMG_TYPE_GIF);
        a.put("424D", "bmp");
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
