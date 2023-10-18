package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.push.fo;
/* loaded from: classes10.dex */
public class fl {
    public static final boolean a = Log.isLoggable("BCompressed", 3);

    public static byte[] a(fk fkVar, byte[] bArr) {
        try {
            byte[] a2 = fo.a.a(bArr);
            if (a) {
                com.xiaomi.channel.commonutils.logger.b.m183a("BCompressed", "decompress " + bArr.length + " to " + a2.length + " for " + fkVar);
                if (fkVar.f373a == 1) {
                    com.xiaomi.channel.commonutils.logger.b.m183a("BCompressed", "decompress not support upStream");
                }
            }
            return a2;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m183a("BCompressed", "decompress error " + e);
            return bArr;
        }
    }
}
