package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.bc;
import com.xiaomi.push.hm;
import com.xiaomi.push.ib;
import com.xiaomi.push.ic;
import com.xiaomi.push.id;
import com.xiaomi.push.ih;
import com.xiaomi.push.ii;
import com.xiaomi.push.il;
import com.xiaomi.push.in;
import com.xiaomi.push.io;
import com.xiaomi.push.ip;
import com.xiaomi.push.ir;
import com.xiaomi.push.it;
import com.xiaomi.push.iv;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class aj {
    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends ix<T, ?>> ii a(Context context, T t, hm hmVar) {
        return a(context, t, hmVar, !hmVar.equals(hm.Registration), context.getPackageName(), b.m124a(context).m125a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends ix<T, ?>> ii a(Context context, T t, hm hmVar, boolean z, String str, String str2) {
        byte[] a2 = iw.a(t);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m84a("invoke convertThriftObjectToBytes method, return null.");
            return null;
        }
        ii iiVar = new ii();
        if (z) {
            String d = b.m124a(context).d();
            if (TextUtils.isEmpty(d)) {
                com.xiaomi.channel.commonutils.logger.b.m84a("regSecret is empty, return null");
                return null;
            }
            try {
                a2 = com.xiaomi.push.h.b(bc.m192a(d), a2);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("encryption error. ");
            }
        }
        ib ibVar = new ib();
        ibVar.f606a = 5L;
        ibVar.f607a = "fakeid";
        iiVar.a(ibVar);
        iiVar.a(ByteBuffer.wrap(a2));
        iiVar.a(hmVar);
        iiVar.b(true);
        iiVar.b(str);
        iiVar.a(z);
        iiVar.a(str2);
        return iiVar;
    }

    public static ix a(Context context, ii iiVar) {
        byte[] m454a;
        if (iiVar.m456b()) {
            try {
                m454a = com.xiaomi.push.h.a(bc.m192a(b.m124a(context).d()), iiVar.m454a());
            } catch (Exception e) {
                throw new t("the aes decrypt failed.", e);
            }
        } else {
            m454a = iiVar.m454a();
        }
        ix a2 = a(iiVar.a(), iiVar.f686b);
        if (a2 != null) {
            iw.a(a2, m454a);
        }
        return a2;
    }

    private static ix a(hm hmVar, boolean z) {
        switch (ak.f14104a[hmVar.ordinal()]) {
            case 1:
                return new in();
            case 2:
                return new it();
            case 3:
                return new ir();
            case 4:
                return new iv();
            case 5:
                return new ip();
            case 6:
                return new ic();
            case 7:
                return new ih();
            case 8:
                return new io();
            case 9:
                if (z) {
                    return new il();
                }
                id idVar = new id();
                idVar.a(true);
                return idVar;
            case 10:
                return new ih();
            default:
                return null;
        }
    }
}
