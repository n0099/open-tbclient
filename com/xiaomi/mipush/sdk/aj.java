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
/* loaded from: classes8.dex */
public class aj {
    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends ix<T, ?>> ii a(Context context, T t, hm hmVar) {
        return a(context, t, hmVar, !hmVar.equals(hm.Registration), context.getPackageName(), b.m92a(context).m93a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends ix<T, ?>> ii a(Context context, T t, hm hmVar, boolean z, String str, String str2) {
        byte[] a = iw.a(t);
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.m52a("invoke convertThriftObjectToBytes method, return null.");
            return null;
        }
        ii iiVar = new ii();
        if (z) {
            String d = b.m92a(context).d();
            if (TextUtils.isEmpty(d)) {
                com.xiaomi.channel.commonutils.logger.b.m52a("regSecret is empty, return null");
                return null;
            }
            try {
                a = com.xiaomi.push.h.b(bc.m160a(d), a);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("encryption error. ");
            }
        }
        ib ibVar = new ib();
        ibVar.f525a = 5L;
        ibVar.f526a = "fakeid";
        iiVar.a(ibVar);
        iiVar.a(ByteBuffer.wrap(a));
        iiVar.a(hmVar);
        iiVar.b(true);
        iiVar.b(str);
        iiVar.a(z);
        iiVar.a(str2);
        return iiVar;
    }

    public static ix a(Context context, ii iiVar) {
        byte[] m422a;
        if (iiVar.m424b()) {
            try {
                m422a = com.xiaomi.push.h.a(bc.m160a(b.m92a(context).d()), iiVar.m422a());
            } catch (Exception e) {
                throw new t("the aes decrypt failed.", e);
            }
        } else {
            m422a = iiVar.m422a();
        }
        ix a = a(iiVar.a(), iiVar.f605b);
        if (a != null) {
            iw.a(a, m422a);
        }
        return a;
    }

    private static ix a(hm hmVar, boolean z) {
        switch (ak.a[hmVar.ordinal()]) {
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
