package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.xiaomi.push.cv;
import com.xiaomi.push.cy;
import com.xiaomi.push.cz;
import com.xiaomi.push.ej;
import com.xiaomi.push.ek;
import com.xiaomi.push.fh;
import com.xiaomi.push.fs;
import com.xiaomi.push.gu;
import com.xiaomi.push.he;
import com.xiaomi.push.hg;
import com.xiaomi.push.service.be;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class au extends be.a implements cz.a {
    private long a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f867a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a implements cz.b {
        a() {
        }

        @Override // com.xiaomi.push.cz.b
        public String a(String str) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", String.valueOf(39));
            buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            buildUpon.appendQueryParameter("os", gu.a(Build.MODEL + ":" + Build.VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter(BdStatsConstant.StatsKey.MERGE_ITEM, String.valueOf(com.xiaomi.push.t.a()));
            String builder = buildUpon.toString();
            com.xiaomi.channel.commonutils.logger.b.c("fetch bucket from : " + builder);
            URL url = new URL(builder);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String a = com.xiaomi.push.az.a(com.xiaomi.push.t.m581a(), url);
                hg.a(url.getHost() + ":" + port, (int) (System.currentTimeMillis() - currentTimeMillis), null);
                return a;
            } catch (IOException e) {
                hg.a(url.getHost() + ":" + port, -1, e);
                throw e;
            }
        }
    }

    /* loaded from: classes8.dex */
    static class b extends cz {
        protected b(Context context, cy cyVar, cz.b bVar, String str) {
            super(context, cyVar, bVar, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaomi.push.cz
        public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
            try {
                if (he.m332a().m337a()) {
                    str2 = be.m557a();
                }
                return super.a(arrayList, str, str2, z);
            } catch (IOException e) {
                hg.a(0, fh.GSLB_ERR.a(), 1, null, com.xiaomi.push.az.b(a) ? 1 : 0);
                throw e;
            }
        }
    }

    au(XMPushService xMPushService) {
        this.f867a = xMPushService;
    }

    public static void a(XMPushService xMPushService) {
        au auVar = new au(xMPushService);
        be.a().a(auVar);
        synchronized (cz.class) {
            cz.a(auVar);
            cz.a(xMPushService, null, new a(), "0", "push", "2.2");
        }
    }

    @Override // com.xiaomi.push.cz.a
    public cz a(Context context, cy cyVar, cz.b bVar, String str) {
        return new b(context, cyVar, bVar, str);
    }

    @Override // com.xiaomi.push.service.be.a
    public void a(ej.a aVar) {
    }

    @Override // com.xiaomi.push.service.be.a
    public void a(ek.b bVar) {
        cv b2;
        boolean z;
        if (bVar.b() && bVar.a() && System.currentTimeMillis() - this.a > BdKVCache.MILLS_1Hour) {
            com.xiaomi.channel.commonutils.logger.b.m52a("fetch bucket :" + bVar.a());
            this.a = System.currentTimeMillis();
            cz a2 = cz.a();
            a2.m216a();
            a2.m219b();
            fs m517a = this.f867a.m517a();
            if (m517a == null || (b2 = a2.b(m517a.m291a().c())) == null) {
                return;
            }
            ArrayList<String> m204a = b2.m204a();
            Iterator<String> it = m204a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (it.next().equals(m517a.m292a())) {
                    z = false;
                    break;
                }
            }
            if (!z || m204a.isEmpty()) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m52a("bucket changed, force reconnect");
            this.f867a.a(0, (Exception) null);
            this.f867a.a(false);
        }
    }
}
