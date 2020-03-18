package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hg;
import com.xiaomi.push.hv;
import com.xiaomi.push.hw;
import com.xiaomi.push.hx;
import com.xiaomi.push.ib;
import com.xiaomi.push.ic;
import com.xiaomi.push.ih;
import com.xiaomi.push.ii;
import com.xiaomi.push.ij;
import com.xiaomi.push.il;
import com.xiaomi.push.in;
import com.xiaomi.push.ip;
import com.xiaomi.push.iq;
import com.xiaomi.push.ir;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class ar {
    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends ir<T, ?>> ic a(Context context, T t, hg hgVar) {
        return a(context, t, hgVar, !hgVar.equals(hg.Registration), context.getPackageName(), d.m83a(context).m84a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends ir<T, ?>> ic a(Context context, T t, hg hgVar, boolean z, String str, String str2) {
        byte[] a = iq.a(t);
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.m45a("invoke convertThriftObjectToBytes method, return null.");
            return null;
        }
        ic icVar = new ic();
        if (z) {
            String d = d.m83a(context).d();
            if (TextUtils.isEmpty(d)) {
                com.xiaomi.channel.commonutils.logger.b.m45a("regSecret is empty, return null");
                return null;
            }
            try {
                a = com.xiaomi.push.h.b(com.xiaomi.push.av.a(d), a);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("encryption error. ");
            }
        }
        hv hvVar = new hv();
        hvVar.f537a = 5L;
        hvVar.f538a = "fakeid";
        icVar.a(hvVar);
        icVar.a(ByteBuffer.wrap(a));
        icVar.a(hgVar);
        icVar.b(true);
        icVar.b(str);
        icVar.a(z);
        icVar.a(str2);
        return icVar;
    }

    public static ir a(Context context, ic icVar) {
        byte[] m405a;
        if (icVar.m407b()) {
            try {
                m405a = com.xiaomi.push.h.a(com.xiaomi.push.av.a(d.m83a(context).d()), icVar.m405a());
            } catch (Exception e) {
                throw new v("the aes decrypt failed.", e);
            }
        } else {
            m405a = icVar.m405a();
        }
        ir a = a(icVar.a(), icVar.f618b);
        if (a != null) {
            iq.a(a, m405a);
        }
        return a;
    }

    private static ir a(hg hgVar, boolean z) {
        switch (as.a[hgVar.ordinal()]) {
            case 1:
                return new ih();
            case 2:
                return new in();
            case 3:
                return new il();
            case 4:
                return new ip();
            case 5:
                return new ij();
            case 6:
                return new hw();
            case 7:
                return new ib();
            case 8:
                return new ii();
            case 9:
                if (z) {
                    return new Cif();
                }
                hx hxVar = new hx();
                hxVar.a(true);
                return hxVar;
            case 10:
                return new ib();
            default:
                return null;
        }
    }
}
