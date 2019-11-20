package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.xiaomi.push.cq;
import com.xiaomi.push.ct;
import com.xiaomi.push.cu;
import com.xiaomi.push.ed;
import com.xiaomi.push.ee;
import com.xiaomi.push.fb;
import com.xiaomi.push.fm;
import com.xiaomi.push.go;
import com.xiaomi.push.gy;
import com.xiaomi.push.ha;
import com.xiaomi.push.service.ba;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class aq extends ba.a implements cu.a {
    private long a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f869a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a implements cu.b {
        a() {
        }

        @Override // com.xiaomi.push.cu.b
        public String a(String str) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", String.valueOf(38));
            buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            buildUpon.appendQueryParameter("os", go.a(Build.MODEL + ":" + Build.VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter(BdStatsConstant.StatsKey.MERGE_ITEM, String.valueOf(com.xiaomi.push.t.a()));
            String builder = buildUpon.toString();
            com.xiaomi.channel.commonutils.logger.b.c("fetch bucket from : " + builder);
            URL url = new URL(builder);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String a = com.xiaomi.push.as.a(com.xiaomi.push.t.m544a(), url);
                ha.a(url.getHost() + ":" + port, (int) (System.currentTimeMillis() - currentTimeMillis), null);
                return a;
            } catch (IOException e) {
                ha.a(url.getHost() + ":" + port, -1, e);
                throw e;
            }
        }
    }

    /* loaded from: classes3.dex */
    static class b extends cu {
        protected b(Context context, ct ctVar, cu.b bVar, String str) {
            super(context, ctVar, bVar, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaomi.push.cu
        public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
            try {
                if (gy.m306a().m311a()) {
                    str2 = ba.m509a();
                }
                return super.a(arrayList, str, str2, z);
            } catch (IOException e) {
                ha.a(0, fb.GSLB_ERR.a(), 1, null, com.xiaomi.push.as.b(a) ? 1 : 0);
                throw e;
            }
        }
    }

    aq(XMPushService xMPushService) {
        this.f869a = xMPushService;
    }

    public static void a(XMPushService xMPushService) {
        aq aqVar = new aq(xMPushService);
        ba.a().a(aqVar);
        synchronized (cu.class) {
            cu.a(aqVar);
            cu.a(xMPushService, null, new a(), "0", "push", "2.2");
        }
    }

    @Override // com.xiaomi.push.cu.a
    public cu a(Context context, ct ctVar, cu.b bVar, String str) {
        return new b(context, ctVar, bVar, str);
    }

    @Override // com.xiaomi.push.service.ba.a
    public void a(ed.a aVar) {
    }

    @Override // com.xiaomi.push.service.ba.a
    public void a(ee.b bVar) {
        cq b2;
        boolean z;
        if (bVar.b() && bVar.a() && System.currentTimeMillis() - this.a > BdKVCache.MILLS_1Hour) {
            com.xiaomi.channel.commonutils.logger.b.m30a("fetch bucket :" + bVar.a());
            this.a = System.currentTimeMillis();
            cu a2 = cu.a();
            a2.m192a();
            a2.m195b();
            fm m482a = this.f869a.m482a();
            if (m482a == null || (b2 = a2.b(m482a.m265a().c())) == null) {
                return;
            }
            ArrayList<String> m180a = b2.m180a();
            Iterator<String> it = m180a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (it.next().equals(m482a.m266a())) {
                    z = false;
                    break;
                }
            }
            if (!z || m180a.isEmpty()) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m30a("bucket changed, force reconnect");
            this.f869a.a(0, (Exception) null);
            this.f869a.a(false);
        }
    }
}
