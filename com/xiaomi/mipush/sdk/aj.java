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
        return a(context, t, hmVar, !hmVar.equals(hm.Registration), context.getPackageName(), b.m113a(context).m114a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends ix<T, ?>> ii a(Context context, T t, hm hmVar, boolean z, String str, String str2) {
        byte[] a2 = iw.a(t);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m73a("invoke convertThriftObjectToBytes method, return null.");
            return null;
        }
        ii iiVar = new ii();
        if (z) {
            String d = b.m113a(context).d();
            if (TextUtils.isEmpty(d)) {
                com.xiaomi.channel.commonutils.logger.b.m73a("regSecret is empty, return null");
                return null;
            }
            try {
                a2 = com.xiaomi.push.h.b(bc.m181a(d), a2);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("encryption error. ");
            }
        }
        ib ibVar = new ib();
        ibVar.f605a = 5L;
        ibVar.f606a = "fakeid";
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
        byte[] m443a;
        if (iiVar.m445b()) {
            try {
                m443a = com.xiaomi.push.h.a(bc.m181a(b.m113a(context).d()), iiVar.m443a());
            } catch (Exception e) {
                throw new t("the aes decrypt failed.", e);
            }
        } else {
            m443a = iiVar.m443a();
        }
        ix a2 = a(iiVar.a(), iiVar.f685b);
        if (a2 != null) {
            iw.a(a2, m443a);
        }
        return a2;
    }

    private static ix a(hm hmVar, boolean z) {
        switch (ak.f14103a[hmVar.ordinal()]) {
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
