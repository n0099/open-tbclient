package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.bl;
import com.xiaomi.push.hh;
import com.xiaomi.push.hw;
import com.xiaomi.push.hx;
import com.xiaomi.push.hy;
import com.xiaomi.push.ic;
import com.xiaomi.push.id;
import com.xiaomi.push.ig;
import com.xiaomi.push.ii;
import com.xiaomi.push.ij;
import com.xiaomi.push.ik;
import com.xiaomi.push.im;
import com.xiaomi.push.io;
import com.xiaomi.push.iq;
import com.xiaomi.push.ir;
import com.xiaomi.push.is;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class ai {
    public static <T extends is<T, ?>> id a(Context context, T t, hh hhVar) {
        return a(context, t, hhVar, !hhVar.equals(hh.Registration), context.getPackageName(), b.m234a(context).m235a());
    }

    public static <T extends is<T, ?>> id a(Context context, T t, hh hhVar, boolean z, String str, String str2) {
        return a(context, t, hhVar, z, str, str2, true);
    }

    public static <T extends is<T, ?>> id a(Context context, T t, hh hhVar, boolean z, String str, String str2, boolean z2) {
        String str3;
        byte[] a = ir.a(t);
        if (a != null) {
            id idVar = new id();
            if (z) {
                String d = b.m234a(context).d();
                if (TextUtils.isEmpty(d)) {
                    str3 = "regSecret is empty, return null";
                } else {
                    try {
                        a = com.xiaomi.push.h.b(bl.m306a(d), a);
                    } catch (Exception unused) {
                        com.xiaomi.channel.commonutils.logger.b.d("encryption error. ");
                    }
                }
            }
            hw hwVar = new hw();
            hwVar.f552a = 5L;
            hwVar.f553a = "fakeid";
            idVar.a(hwVar);
            idVar.a(ByteBuffer.wrap(a));
            idVar.a(hhVar);
            idVar.b(z2);
            idVar.b(str);
            idVar.a(z);
            idVar.a(str2);
            return idVar;
        }
        str3 = "invoke convertThriftObjectToBytes method, return null.";
        com.xiaomi.channel.commonutils.logger.b.m190a(str3);
        return null;
    }

    public static is a(Context context, id idVar) {
        byte[] m640a;
        if (idVar.m642b()) {
            byte[] a = i.a(context, idVar, e.ASSEMBLE_PUSH_FCM);
            if (a == null) {
                a = bl.m306a(b.m234a(context).d());
            }
            try {
                m640a = com.xiaomi.push.h.a(a, idVar.m640a());
            } catch (Exception e) {
                throw new u("the aes decrypt failed.", e);
            }
        } else {
            m640a = idVar.m640a();
        }
        is a2 = a(idVar.a(), idVar.f635b);
        if (a2 != null) {
            ir.a(a2, m640a);
        }
        return a2;
    }

    public static is a(hh hhVar, boolean z) {
        switch (aj.a[hhVar.ordinal()]) {
            case 1:
                return new ii();
            case 2:
                return new io();
            case 3:
                return new im();
            case 4:
                return new iq();
            case 5:
                return new ik();
            case 6:
                return new hx();
            case 7:
                return new ic();
            case 8:
                return new ij();
            case 9:
                if (z) {
                    return new ig();
                }
                hy hyVar = new hy();
                hyVar.a(true);
                return hyVar;
            case 10:
                return new ic();
            default:
                return null;
        }
    }

    public static <T extends is<T, ?>> id b(Context context, T t, hh hhVar, boolean z, String str, String str2) {
        return a(context, t, hhVar, z, str, str2, false);
    }
}
