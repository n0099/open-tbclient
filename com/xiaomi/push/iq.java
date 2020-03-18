package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.iy;
import com.xiaomi.push.ji;
/* loaded from: classes8.dex */
public class iq {
    public static short a(Context context, ic icVar) {
        return (short) ((ah.b(context) ? 4 : 0) + 0 + g.m293a(context, icVar.f617b).a() + (ah.a(context) ? 8 : 0));
    }

    public static <T extends ir<T, ?>> void a(T t, byte[] bArr) {
        if (bArr == null) {
            throw new iw("the message byte is empty.");
        }
        new iv(new ji.a(true, true, bArr.length)).a(t, bArr);
    }

    public static <T extends ir<T, ?>> byte[] a(T t) {
        if (t == null) {
            return null;
        }
        try {
            return new ix(new iy.a()).a(t);
        } catch (iw e) {
            com.xiaomi.channel.commonutils.logger.b.a("convertThriftObjectToBytes catch TException.", e);
            return null;
        }
    }
}
