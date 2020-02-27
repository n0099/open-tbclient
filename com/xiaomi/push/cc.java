package com.xiaomi.push;

import android.os.Build;
import android.system.ErrnoException;
import android.system.Os;
import java.io.File;
/* loaded from: classes8.dex */
public class cc {
    public static long a(String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                if (new File(str).exists()) {
                    return Os.stat(str).st_size;
                }
                return 0L;
            } catch (ErrnoException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return 0L;
            }
        }
        return 0L;
    }
}
