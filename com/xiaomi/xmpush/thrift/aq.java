package com.xiaomi.xmpush.thrift;

import android.content.Context;
import com.xiaomi.push.service.ay;
import org.apache.thrift.protocol.a;
import org.apache.thrift.protocol.k;
/* loaded from: classes2.dex */
public class aq {
    public static short a(Context context, ab abVar) {
        return (short) ((com.xiaomi.channel.commonutils.misc.e.a(context) ? 8 : 0) + 0 + com.xiaomi.channel.commonutils.android.b.d(context, abVar.f).a() + (com.xiaomi.channel.commonutils.misc.e.b(context) ? 4 : 0) + (ay.a(context, abVar) ? 16 : 0));
    }

    public static short a(boolean z, boolean z2, boolean z3) {
        return (short) ((z3 ? 1 : 0) + (z2 ? 2 : 0) + 0 + (z ? 4 : 0));
    }

    public static <T extends org.apache.thrift.a<T, ?>> void a(T t, byte[] bArr) {
        if (bArr == null) {
            throw new org.apache.thrift.f("the message byte is empty.");
        }
        new org.apache.thrift.e(new k.a(true, true, bArr.length)).a(t, bArr);
    }

    public static <T extends org.apache.thrift.a<T, ?>> byte[] a(T t) {
        if (t == null) {
            return null;
        }
        try {
            return new org.apache.thrift.g(new a.C0205a()).a(t);
        } catch (org.apache.thrift.f e) {
            com.xiaomi.channel.commonutils.logger.b.a("convertThriftObjectToBytes catch TException.", e);
            return null;
        }
    }
}
