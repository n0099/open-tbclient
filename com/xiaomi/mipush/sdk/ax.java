package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.bf;
import com.xiaomi.push.hm;
import com.xiaomi.push.hw;
import com.xiaomi.push.hz;
import com.xiaomi.push.il;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class ax implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f62a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(Context context, boolean z) {
        this.a = context;
        this.f62a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        String d;
        String d2;
        String d3;
        String c;
        String c2;
        String c3;
        com.xiaomi.channel.commonutils.logger.b.m54a("do sync info");
        il ilVar = new il(com.xiaomi.push.service.an.a(), false);
        b m94a = b.m94a(this.a);
        ilVar.c(hw.SyncInfo.f477a);
        ilVar.b(m94a.m95a());
        ilVar.d(this.a.getPackageName());
        ilVar.f618a = new HashMap();
        com.xiaomi.push.n.a(ilVar.f618a, "app_version", com.xiaomi.push.g.m307a(this.a, this.a.getPackageName()));
        com.xiaomi.push.n.a(ilVar.f618a, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.push.g.a(this.a, this.a.getPackageName())));
        com.xiaomi.push.n.a(ilVar.f618a, "push_sdk_vn", "3_7_5");
        com.xiaomi.push.n.a(ilVar.f618a, "push_sdk_vc", Integer.toString(30705));
        com.xiaomi.push.n.a(ilVar.f618a, "token", m94a.b());
        if (!com.xiaomi.push.l.d()) {
            String a = bf.a(com.xiaomi.push.i.f(this.a));
            String h = com.xiaomi.push.i.h(this.a);
            if (!TextUtils.isEmpty(h)) {
                a = a + Constants.ACCEPT_TIME_SEPARATOR_SP + h;
            }
            if (!TextUtils.isEmpty(a)) {
                com.xiaomi.push.n.a(ilVar.f618a, Constants.EXTRA_KEY_IMEI_MD5, a);
            }
        }
        com.xiaomi.push.au.a(this.a).a(ilVar.f618a);
        com.xiaomi.push.n.a(ilVar.f618a, Constants.EXTRA_KEY_REG_ID, m94a.m102c());
        com.xiaomi.push.n.a(ilVar.f618a, Constants.EXTRA_KEY_REG_SECRET, m94a.d());
        com.xiaomi.push.n.a(ilVar.f618a, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(this.a).replace(Constants.ACCEPT_TIME_SEPARATOR_SP, Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        if (this.f62a) {
            Map<String, String> map = ilVar.f618a;
            c = aw.c(MiPushClient.getAllAlias(this.a));
            com.xiaomi.push.n.a(map, Constants.EXTRA_KEY_ALIASES_MD5, c);
            Map<String, String> map2 = ilVar.f618a;
            c2 = aw.c(MiPushClient.getAllTopic(this.a));
            com.xiaomi.push.n.a(map2, Constants.EXTRA_KEY_TOPICS_MD5, c2);
            Map<String, String> map3 = ilVar.f618a;
            c3 = aw.c(MiPushClient.getAllUserAccount(this.a));
            com.xiaomi.push.n.a(map3, Constants.EXTRA_KEY_ACCOUNTS_MD5, c3);
        } else {
            Map<String, String> map4 = ilVar.f618a;
            d = aw.d(MiPushClient.getAllAlias(this.a));
            com.xiaomi.push.n.a(map4, Constants.EXTRA_KEY_ALIASES, d);
            Map<String, String> map5 = ilVar.f618a;
            d2 = aw.d(MiPushClient.getAllTopic(this.a));
            com.xiaomi.push.n.a(map5, "topics", d2);
            Map<String, String> map6 = ilVar.f618a;
            d3 = aw.d(MiPushClient.getAllUserAccount(this.a));
            com.xiaomi.push.n.a(map6, Constants.EXTRA_KEY_ACCOUNTS, d3);
        }
        aq.a(this.a).a((aq) ilVar, hm.Notification, false, (hz) null);
    }
}
