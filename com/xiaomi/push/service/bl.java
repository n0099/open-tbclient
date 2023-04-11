package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.xiaomi.push.cu;
import com.xiaomi.push.dv;
import com.xiaomi.push.dw;
import com.xiaomi.push.ey;
import com.xiaomi.push.fg;
import com.xiaomi.push.fi;
import com.xiaomi.push.fv;
import com.xiaomi.push.gx;
import com.xiaomi.push.service.bv;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class bl extends bv.a implements cu.a {
    public long a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f944a;

    /* loaded from: classes8.dex */
    public static class a implements cu.b {
        @Override // com.xiaomi.push.cu.b
        public String a(String str) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter(BaseStatisContent.SDKVER, String.valueOf(48));
            buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            buildUpon.appendQueryParameter("os", gx.a(Build.MODEL + ":" + Build.VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter("mi", String.valueOf(com.xiaomi.push.s.a()));
            String builder = buildUpon.toString();
            com.xiaomi.channel.commonutils.logger.b.c("fetch bucket from : " + builder);
            URL url = new URL(builder);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String a = com.xiaomi.push.bi.a(com.xiaomi.push.s.m643a(), url);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                fi.a(url.getHost() + ":" + port, (int) currentTimeMillis2, null);
                return a;
            } catch (IOException e) {
                fi.a(url.getHost() + ":" + port, -1, e);
                throw e;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends com.xiaomi.push.cu {
        public b(Context context, com.xiaomi.push.ct ctVar, cu.b bVar, String str) {
            super(context, ctVar, bVar, str);
        }

        @Override // com.xiaomi.push.cu
        public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
            try {
                if (fg.m396a().m401a()) {
                    str2 = bv.m725a();
                }
                return super.a(arrayList, str, str2, z);
            } catch (IOException e) {
                fi.a(0, ey.GSLB_ERR.a(), 1, null, com.xiaomi.push.bi.c(com.xiaomi.push.cu.a) ? 1 : 0);
                throw e;
            }
        }
    }

    public bl(XMPushService xMPushService) {
        this.f944a = xMPushService;
    }

    public static void a(XMPushService xMPushService) {
        bl blVar = new bl(xMPushService);
        bv.a().a(blVar);
        synchronized (com.xiaomi.push.cu.class) {
            com.xiaomi.push.cu.a(blVar);
            com.xiaomi.push.cu.a(xMPushService, null, new a(), "0", "push", "2.2");
        }
    }

    @Override // com.xiaomi.push.cu.a
    public com.xiaomi.push.cu a(Context context, com.xiaomi.push.ct ctVar, cu.b bVar, String str) {
        return new b(context, ctVar, bVar, str);
    }

    @Override // com.xiaomi.push.service.bv.a
    public void a(dv.a aVar) {
    }

    @Override // com.xiaomi.push.service.bv.a
    public void a(dw.b bVar) {
        com.xiaomi.push.cq b2;
        if (bVar.m311b() && bVar.m310a() && System.currentTimeMillis() - this.a > 3600000) {
            com.xiaomi.channel.commonutils.logger.b.m101a("fetch bucket :" + bVar.m310a());
            this.a = System.currentTimeMillis();
            com.xiaomi.push.cu a2 = com.xiaomi.push.cu.a();
            a2.m268a();
            a2.m271b();
            fv m666a = this.f944a.m666a();
            if (m666a == null || (b2 = a2.b(m666a.m424a().c())) == null) {
                return;
            }
            ArrayList<String> m256a = b2.m256a();
            boolean z = true;
            Iterator<String> it = m256a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().equals(m666a.mo425a())) {
                    z = false;
                    break;
                }
            }
            if (!z || m256a.isEmpty()) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m101a("bucket changed, force reconnect");
            this.f944a.a(0, (Exception) null);
            this.f944a.a(false);
        }
    }
}
