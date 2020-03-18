package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hg;
import com.xiaomi.push.hq;
import com.xiaomi.push.ht;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class bf implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f57a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(Context context, boolean z) {
        this.a = context;
        this.f57a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        String d;
        String d2;
        String d3;
        String c;
        String c2;
        String c3;
        com.xiaomi.channel.commonutils.logger.b.m45a("do sync info");
        Cif cif = new Cif(com.xiaomi.push.service.aj.a(), false);
        d m83a = d.m83a(this.a);
        cif.c(hq.SyncInfo.f489a);
        cif.b(m83a.m84a());
        cif.d(this.a.getPackageName());
        cif.f629a = new HashMap();
        com.xiaomi.push.n.a(cif.f629a, "app_version", com.xiaomi.push.g.m294a(this.a, this.a.getPackageName()));
        com.xiaomi.push.n.a(cif.f629a, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.push.g.a(this.a, this.a.getPackageName())));
        com.xiaomi.push.n.a(cif.f629a, "push_sdk_vn", "3_6_19");
        com.xiaomi.push.n.a(cif.f629a, "push_sdk_vc", Integer.toString(30619));
        com.xiaomi.push.n.a(cif.f629a, "token", m83a.b());
        if (!com.xiaomi.push.l.d()) {
            String a = com.xiaomi.push.ay.a(com.xiaomi.push.i.f(this.a));
            String h = com.xiaomi.push.i.h(this.a);
            if (!TextUtils.isEmpty(h)) {
                a = a + Constants.ACCEPT_TIME_SEPARATOR_SP + h;
            }
            if (!TextUtils.isEmpty(a)) {
                com.xiaomi.push.n.a(cif.f629a, Constants.EXTRA_KEY_IMEI_MD5, a);
            }
        }
        com.xiaomi.push.n.a(cif.f629a, Constants.EXTRA_KEY_REG_ID, m83a.m91c());
        com.xiaomi.push.n.a(cif.f629a, Constants.EXTRA_KEY_REG_SECRET, m83a.d());
        com.xiaomi.push.n.a(cif.f629a, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(this.a).replace(Constants.ACCEPT_TIME_SEPARATOR_SP, Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        if (this.f57a) {
            Map<String, String> map = cif.f629a;
            c = be.c(MiPushClient.getAllAlias(this.a));
            com.xiaomi.push.n.a(map, Constants.EXTRA_KEY_ALIASES_MD5, c);
            Map<String, String> map2 = cif.f629a;
            c2 = be.c(MiPushClient.getAllTopic(this.a));
            com.xiaomi.push.n.a(map2, Constants.EXTRA_KEY_TOPICS_MD5, c2);
            Map<String, String> map3 = cif.f629a;
            c3 = be.c(MiPushClient.getAllUserAccount(this.a));
            com.xiaomi.push.n.a(map3, Constants.EXTRA_KEY_ACCOUNTS_MD5, c3);
        } else {
            Map<String, String> map4 = cif.f629a;
            d = be.d(MiPushClient.getAllAlias(this.a));
            com.xiaomi.push.n.a(map4, Constants.EXTRA_KEY_ALIASES, d);
            Map<String, String> map5 = cif.f629a;
            d2 = be.d(MiPushClient.getAllTopic(this.a));
            com.xiaomi.push.n.a(map5, "topics", d2);
            Map<String, String> map6 = cif.f629a;
            d3 = be.d(MiPushClient.getAllUserAccount(this.a));
            com.xiaomi.push.n.a(map6, Constants.EXTRA_KEY_ACCOUNTS, d3);
        }
        ay.a(this.a).a((ay) cif, hg.Notification, false, (ht) null);
    }
}
