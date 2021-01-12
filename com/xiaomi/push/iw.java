package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.je;
import com.xiaomi.push.jo;
/* loaded from: classes6.dex */
public class iw {
    public static short a(Context context, ii iiVar) {
        return (short) ((ah.b(context) ? 4 : 0) + 0 + g.m332a(context, iiVar.f684b).a() + (ah.a(context) ? 8 : 0));
    }

    public static <T extends ix<T, ?>> void a(T t, byte[] bArr) {
        if (bArr == null) {
            throw new jc("the message byte is empty.");
        }
        new jb(new jo.a(true, true, bArr.length)).a(t, bArr);
    }

    public static <T extends ix<T, ?>> byte[] a(T t) {
        if (t == null) {
            return null;
        }
        try {
            return new jd(new je.a()).a(t);
        } catch (jc e) {
            com.xiaomi.channel.commonutils.logger.b.a("convertThriftObjectToBytes catch TException.", e);
            return null;
        }
    }
}
