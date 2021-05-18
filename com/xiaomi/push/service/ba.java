package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.webkit.sdk.VideoCloudSetting;
import com.xiaomi.push.co;
import com.xiaomi.push.cr;
import com.xiaomi.push.cs;
import com.xiaomi.push.dt;
import com.xiaomi.push.du;
import com.xiaomi.push.ew;
import com.xiaomi.push.fl;
import com.xiaomi.push.gn;
import com.xiaomi.push.gx;
import com.xiaomi.push.gz;
import com.xiaomi.push.service.bi;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class ba extends bi.a implements cs.a {

    /* renamed from: a  reason: collision with root package name */
    public long f38164a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f919a;

    /* loaded from: classes7.dex */
    public static class a implements cs.b {
        @Override // com.xiaomi.push.cs.b
        public String a(String str) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", String.valueOf(43));
            buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            buildUpon.appendQueryParameter(IAdRequestParam.OS, gn.a(Build.MODEL + ":" + Build.VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter("mi", String.valueOf(com.xiaomi.push.t.a()));
            String builder = buildUpon.toString();
            com.xiaomi.channel.commonutils.logger.b.c("fetch bucket from : " + builder);
            URL url = new URL(builder);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String a2 = com.xiaomi.push.bg.a(com.xiaomi.push.t.m623a(), url);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                gz.a(url.getHost() + ":" + port, (int) currentTimeMillis2, null);
                return a2;
            } catch (IOException e2) {
                gz.a(url.getHost() + ":" + port, -1, e2);
                throw e2;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends cs {
        public b(Context context, cr crVar, cs.b bVar, String str) {
            super(context, crVar, bVar, str);
        }

        @Override // com.xiaomi.push.cs
        public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
            try {
                if (gx.m350a().m355a()) {
                    str2 = bi.m599a();
                }
                return super.a(arrayList, str, str2, z);
            } catch (IOException e2) {
                gz.a(0, ew.GSLB_ERR.a(), 1, null, com.xiaomi.push.bg.c(cs.f37481a) ? 1 : 0);
                throw e2;
            }
        }
    }

    public ba(XMPushService xMPushService) {
        this.f919a = xMPushService;
    }

    public static void a(XMPushService xMPushService) {
        ba baVar = new ba(xMPushService);
        bi.a().a(baVar);
        synchronized (cs.class) {
            cs.a(baVar);
            cs.a(xMPushService, null, new a(), "0", "push", "2.2");
        }
    }

    @Override // com.xiaomi.push.cs.a
    public cs a(Context context, cr crVar, cs.b bVar, String str) {
        return new b(context, crVar, bVar, str);
    }

    @Override // com.xiaomi.push.service.bi.a
    public void a(dt.a aVar) {
    }

    @Override // com.xiaomi.push.service.bi.a
    public void a(du.b bVar) {
        co b2;
        if (bVar.b() && bVar.a() && System.currentTimeMillis() - this.f38164a > VideoCloudSetting.HOUR_MILLISECOND) {
            com.xiaomi.channel.commonutils.logger.b.m57a("fetch bucket :" + bVar.a());
            this.f38164a = System.currentTimeMillis();
            cs a2 = cs.a();
            a2.m218a();
            a2.m221b();
            fl m547a = this.f919a.m547a();
            if (m547a == null || (b2 = a2.b(m547a.m307a().c())) == null) {
                return;
            }
            ArrayList<String> m206a = b2.m206a();
            boolean z = true;
            Iterator<String> it = m206a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().equals(m547a.m308a())) {
                    z = false;
                    break;
                }
            }
            if (!z || m206a.isEmpty()) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m57a("bucket changed, force reconnect");
            this.f919a.a(0, (Exception) null);
            this.f919a.a(false);
        }
    }
}
