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
/* loaded from: classes8.dex */
public final class ax implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f66a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(Context context, boolean z) {
        this.a = context;
        this.f66a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        String d;
        String d2;
        String d3;
        String c;
        String c2;
        String c3;
        com.xiaomi.channel.commonutils.logger.b.m48a("do sync info");
        il ilVar = new il(com.xiaomi.push.service.an.a(), false);
        b m88a = b.m88a(this.a);
        ilVar.c(hw.SyncInfo.f481a);
        ilVar.b(m88a.m89a());
        ilVar.d(this.a.getPackageName());
        ilVar.f622a = new HashMap();
        com.xiaomi.push.n.a(ilVar.f622a, "app_version", com.xiaomi.push.g.m301a(this.a, this.a.getPackageName()));
        com.xiaomi.push.n.a(ilVar.f622a, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.push.g.a(this.a, this.a.getPackageName())));
        com.xiaomi.push.n.a(ilVar.f622a, "push_sdk_vn", "3_7_5");
        com.xiaomi.push.n.a(ilVar.f622a, "push_sdk_vc", Integer.toString(30705));
        com.xiaomi.push.n.a(ilVar.f622a, "token", m88a.b());
        if (!com.xiaomi.push.l.d()) {
            String a = bf.a(com.xiaomi.push.i.f(this.a));
            String h = com.xiaomi.push.i.h(this.a);
            if (!TextUtils.isEmpty(h)) {
                a = a + Constants.ACCEPT_TIME_SEPARATOR_SP + h;
            }
            if (!TextUtils.isEmpty(a)) {
                com.xiaomi.push.n.a(ilVar.f622a, Constants.EXTRA_KEY_IMEI_MD5, a);
            }
        }
        com.xiaomi.push.au.a(this.a).a(ilVar.f622a);
        com.xiaomi.push.n.a(ilVar.f622a, Constants.EXTRA_KEY_REG_ID, m88a.m96c());
        com.xiaomi.push.n.a(ilVar.f622a, Constants.EXTRA_KEY_REG_SECRET, m88a.d());
        com.xiaomi.push.n.a(ilVar.f622a, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(this.a).replace(Constants.ACCEPT_TIME_SEPARATOR_SP, Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        if (this.f66a) {
            Map<String, String> map = ilVar.f622a;
            c = aw.c(MiPushClient.getAllAlias(this.a));
            com.xiaomi.push.n.a(map, Constants.EXTRA_KEY_ALIASES_MD5, c);
            Map<String, String> map2 = ilVar.f622a;
            c2 = aw.c(MiPushClient.getAllTopic(this.a));
            com.xiaomi.push.n.a(map2, Constants.EXTRA_KEY_TOPICS_MD5, c2);
            Map<String, String> map3 = ilVar.f622a;
            c3 = aw.c(MiPushClient.getAllUserAccount(this.a));
            com.xiaomi.push.n.a(map3, Constants.EXTRA_KEY_ACCOUNTS_MD5, c3);
        } else {
            Map<String, String> map4 = ilVar.f622a;
            d = aw.d(MiPushClient.getAllAlias(this.a));
            com.xiaomi.push.n.a(map4, Constants.EXTRA_KEY_ALIASES, d);
            Map<String, String> map5 = ilVar.f622a;
            d2 = aw.d(MiPushClient.getAllTopic(this.a));
            com.xiaomi.push.n.a(map5, "topics", d2);
            Map<String, String> map6 = ilVar.f622a;
            d3 = aw.d(MiPushClient.getAllUserAccount(this.a));
            com.xiaomi.push.n.a(map6, Constants.EXTRA_KEY_ACCOUNTS, d3);
        }
        aq.a(this.a).a((aq) ilVar, hm.Notification, false, (hz) null);
    }
}
