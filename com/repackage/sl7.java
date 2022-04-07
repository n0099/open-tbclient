package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes7.dex */
public interface sl7 {
    public static final String a = File.separator;
    public static final String b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String c = b + a + ".tieba_video_monitor";
    public static final String d = c + a + "v1";
    public static final String e;
    public static final String f;
    public static final String g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(d);
        sb.append(a);
        e = sb.toString();
        f = b + a + ".tieba_video_monitor_log";
        g = f + a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(g);
        sb2.append(a);
        sb2.toString();
    }
}
