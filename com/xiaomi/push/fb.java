package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.push.fe;
/* loaded from: classes7.dex */
public class fb {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f40492a = Log.isLoggable("BCompressed", 3);

    public static byte[] a(fa faVar, byte[] bArr) {
        try {
            byte[] a2 = fe.a.a(bArr);
            if (f40492a) {
                com.xiaomi.channel.commonutils.logger.b.m52a("BCompressed", "decompress " + bArr.length + " to " + a2.length + " for " + faVar);
                if (faVar.f357a == 1) {
                    com.xiaomi.channel.commonutils.logger.b.m52a("BCompressed", "decompress not support upStream");
                }
            }
            return a2;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m52a("BCompressed", "decompress error " + e2);
            return bArr;
        }
    }
}
