package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.iz;
import com.xiaomi.push.jj;
/* loaded from: classes9.dex */
public class ir {
    public static short a(Context context, id idVar) {
        return a(context, idVar.f638b);
    }

    public static short a(Context context, String str) {
        return (short) (g.a(context, str, false).a() + 0 + (ai.b(context) ? 4 : 0) + (ai.a(context) ? 8 : 0) + (com.xiaomi.push.service.ax.m700a(context) ? 16 : 0));
    }

    public static <T extends is<T, ?>> void a(T t, byte[] bArr) {
        if (bArr == null) {
            throw new ix("the message byte is empty.");
        }
        new iw(new jj.a(true, true, bArr.length)).a(t, bArr);
    }

    public static <T extends is<T, ?>> byte[] a(T t) {
        if (t == null) {
            return null;
        }
        try {
            return new iy(new iz.a()).a(t);
        } catch (ix e) {
            com.xiaomi.channel.commonutils.logger.b.a("convertThriftObjectToBytes catch TException.", e);
            return null;
        }
    }
}
