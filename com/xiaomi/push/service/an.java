package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.baidu.ar.util.SystemInfoUtil;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.HostFilter;
import com.xiaomi.network.HostManager;
import com.xiaomi.network.HostManagerV2;
import com.xiaomi.push.protobuf.a;
import com.xiaomi.push.protobuf.b;
import com.xiaomi.push.service.at;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class an extends at.a implements HostManager.HostManagerFactory {
    private XMPushService a;
    private long b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a implements HostManager.HttpGet {
        a() {
        }

        @Override // com.xiaomi.network.HostManager.HttpGet
        public String a(String str) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", String.valueOf(26));
            buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            buildUpon.appendQueryParameter("os", com.xiaomi.smack.util.d.a(Build.MODEL + SystemInfoUtil.COLON + Build.VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter("mi", String.valueOf(com.xiaomi.channel.commonutils.android.j.c()));
            String builder = buildUpon.toString();
            com.xiaomi.channel.commonutils.logger.b.c("fetch bucket from : " + builder);
            URL url = new URL(builder);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String a = com.xiaomi.channel.commonutils.network.d.a(com.xiaomi.channel.commonutils.android.j.a(), url);
                com.xiaomi.stats.h.a(url.getHost() + SystemInfoUtil.COLON + port, (int) (System.currentTimeMillis() - currentTimeMillis), null);
                return a;
            } catch (IOException e) {
                com.xiaomi.stats.h.a(url.getHost() + SystemInfoUtil.COLON + port, -1, e);
                throw e;
            }
        }
    }

    /* loaded from: classes3.dex */
    static class b extends HostManagerV2 {
        protected b(Context context, HostFilter hostFilter, HostManager.HttpGet httpGet, String str) {
            super(context, hostFilter, httpGet, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaomi.network.HostManagerV2, com.xiaomi.network.HostManager
        public String getRemoteFallbackJSON(ArrayList<String> arrayList, String str, String str2) {
            try {
                if (com.xiaomi.stats.f.a().c()) {
                    str2 = at.e();
                }
                return super.getRemoteFallbackJSON(arrayList, str, str2);
            } catch (IOException e) {
                com.xiaomi.stats.h.a(0, com.xiaomi.push.thrift.a.GSLB_ERR.a(), 1, null, com.xiaomi.channel.commonutils.network.d.d(this.sAppContext) ? 1 : 0);
                throw e;
            }
        }
    }

    an(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    public static void a(XMPushService xMPushService) {
        an anVar = new an(xMPushService);
        at.a().a(anVar);
        synchronized (HostManager.class) {
            HostManager.setHostManagerFactory(anVar);
            HostManager.init(xMPushService, null, new a(), "0", "push", "2.2");
        }
    }

    @Override // com.xiaomi.network.HostManager.HostManagerFactory
    public HostManager a(Context context, HostFilter hostFilter, HostManager.HttpGet httpGet, String str) {
        return new b(context, hostFilter, httpGet, str);
    }

    @Override // com.xiaomi.push.service.at.a
    public void a(a.C0290a c0290a) {
    }

    @Override // com.xiaomi.push.service.at.a
    public void a(b.C0291b c0291b) {
        Fallback fallbacksByHost;
        boolean z;
        if (c0291b.e() && c0291b.d() && System.currentTimeMillis() - this.b > 3600000) {
            com.xiaomi.channel.commonutils.logger.b.a("fetch bucket :" + c0291b.d());
            this.b = System.currentTimeMillis();
            HostManager hostManager = HostManager.getInstance();
            hostManager.clear();
            hostManager.refreshFallbacks();
            com.xiaomi.smack.a h = this.a.h();
            if (h == null || (fallbacksByHost = hostManager.getFallbacksByHost(h.c().e())) == null) {
                return;
            }
            ArrayList<String> d = fallbacksByHost.d();
            Iterator<String> it = d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (it.next().equals(h.d())) {
                    z = false;
                    break;
                }
            }
            if (!z || d.isEmpty()) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.a("bucket changed, force reconnect");
            this.a.a(0, (Exception) null);
            this.a.a(false);
        }
    }
}
