package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class as {
    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends org.apache.thrift.a<T, ?>> com.xiaomi.xmpush.thrift.af a(Context context, T t, com.xiaomi.xmpush.thrift.a aVar) {
        return a(context, t, aVar, !aVar.equals(com.xiaomi.xmpush.thrift.a.Registration), context.getPackageName(), d.a(context).c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends org.apache.thrift.a<T, ?>> com.xiaomi.xmpush.thrift.af a(Context context, T t, com.xiaomi.xmpush.thrift.a aVar, boolean z, String str, String str2) {
        byte[] a = com.xiaomi.xmpush.thrift.at.a(t);
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.a("invoke convertThriftObjectToBytes method, return null.");
            return null;
        }
        com.xiaomi.xmpush.thrift.af afVar = new com.xiaomi.xmpush.thrift.af();
        if (z) {
            String f = d.a(context).f();
            if (TextUtils.isEmpty(f)) {
                com.xiaomi.channel.commonutils.logger.b.a("regSecret is empty, return null");
                return null;
            }
            try {
                a = com.xiaomi.channel.commonutils.android.c.b(com.xiaomi.channel.commonutils.string.a.a(f), a);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("encryption error. ");
            }
        }
        com.xiaomi.xmpush.thrift.x xVar = new com.xiaomi.xmpush.thrift.x();
        xVar.a = 5L;
        xVar.b = "fakeid";
        afVar.a(xVar);
        afVar.a(ByteBuffer.wrap(a));
        afVar.a(aVar);
        afVar.c(true);
        afVar.b(str);
        afVar.a(z);
        afVar.a(str2);
        return afVar;
    }

    public static org.apache.thrift.a a(Context context, com.xiaomi.xmpush.thrift.af afVar) {
        byte[] f;
        if (afVar.c()) {
            try {
                f = com.xiaomi.channel.commonutils.android.c.a(com.xiaomi.channel.commonutils.string.a.a(d.a(context).f()), afVar.f());
            } catch (Exception e) {
                throw new t("the aes decrypt failed.", e);
            }
        } else {
            f = afVar.f();
        }
        org.apache.thrift.a a = a(afVar.a(), afVar.c);
        if (a != null) {
            com.xiaomi.xmpush.thrift.at.a(a, f);
        }
        return a;
    }

    private static org.apache.thrift.a a(com.xiaomi.xmpush.thrift.a aVar, boolean z) {
        switch (at.a[aVar.ordinal()]) {
            case 1:
                return new com.xiaomi.xmpush.thrift.ak();
            case 2:
                return new com.xiaomi.xmpush.thrift.aq();
            case 3:
                return new com.xiaomi.xmpush.thrift.ao();
            case 4:
                return new com.xiaomi.xmpush.thrift.as();
            case 5:
                return new com.xiaomi.xmpush.thrift.am();
            case 6:
                return new com.xiaomi.xmpush.thrift.z();
            case 7:
                return new com.xiaomi.xmpush.thrift.ae();
            case 8:
                return new com.xiaomi.xmpush.thrift.al();
            case 9:
                if (z) {
                    return new com.xiaomi.xmpush.thrift.ai();
                }
                com.xiaomi.xmpush.thrift.aa aaVar = new com.xiaomi.xmpush.thrift.aa();
                aaVar.a(true);
                return aaVar;
            case 10:
                return new com.xiaomi.xmpush.thrift.ae();
            default:
                return null;
        }
    }
}
