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
    private XMPushService f874a;

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
                String a = com.xiaomi.push.az.a(com.xiaomi.push.t.m577a(), url);
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
                if (he.m328a().m333a()) {
                    str2 = be.m553a();
                }
                return super.a(arrayList, str, str2, z);
            } catch (IOException e) {
                hg.a(0, fh.GSLB_ERR.a(), 1, null, com.xiaomi.push.az.b(a) ? 1 : 0);
                throw e;
            }
        }
    }

    au(XMPushService xMPushService) {
        this.f874a = xMPushService;
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
            com.xiaomi.channel.commonutils.logger.b.m48a("fetch bucket :" + bVar.a());
            this.a = System.currentTimeMillis();
            cz a2 = cz.a();
            a2.m212a();
            a2.m215b();
            fs m513a = this.f874a.m513a();
            if (m513a == null || (b2 = a2.b(m513a.m287a().c())) == null) {
                return;
            }
            ArrayList<String> m200a = b2.m200a();
            Iterator<String> it = m200a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (it.next().equals(m513a.m288a())) {
                    z = false;
                    break;
                }
            }
            if (!z || m200a.isEmpty()) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m48a("bucket changed, force reconnect");
            this.f874a.a(0, (Exception) null);
            this.f874a.a(false);
        }
    }
}
