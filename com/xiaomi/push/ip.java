package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ix;
import com.xiaomi.push.jh;
/* loaded from: classes7.dex */
public class ip {
    public static short a(Context context, ib ibVar) {
        return (short) (g.a(context, ibVar.f635b, false).a() + 0 + (ah.b(context) ? 4 : 0) + (ah.a(context) ? 8 : 0));
    }

    public static <T extends iq<T, ?>> void a(T t, byte[] bArr) {
        if (bArr == null) {
            throw new iv("the message byte is empty.");
        }
        new iu(new jh.a(true, true, bArr.length)).a(t, bArr);
    }

    public static <T extends iq<T, ?>> byte[] a(T t) {
        if (t == null) {
            return null;
        }
        try {
            return new iw(new ix.a()).a(t);
        } catch (iv e2) {
            com.xiaomi.channel.commonutils.logger.b.a("convertThriftObjectToBytes catch TException.", e2);
            return null;
        }
    }
}
