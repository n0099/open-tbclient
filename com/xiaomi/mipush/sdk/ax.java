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
/* loaded from: classes12.dex */
public final class ax implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4759a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f59a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(Context context, boolean z) {
        this.f4759a = context;
        this.f59a = z;
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
        b m94a = b.m94a(this.f4759a);
        ilVar.c(hw.SyncInfo.f474a);
        ilVar.b(m94a.m95a());
        ilVar.d(this.f4759a.getPackageName());
        ilVar.f615a = new HashMap();
        com.xiaomi.push.n.a(ilVar.f615a, "app_version", com.xiaomi.push.g.m307a(this.f4759a, this.f4759a.getPackageName()));
        com.xiaomi.push.n.a(ilVar.f615a, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.push.g.a(this.f4759a, this.f4759a.getPackageName())));
        com.xiaomi.push.n.a(ilVar.f615a, "push_sdk_vn", "3_7_5");
        com.xiaomi.push.n.a(ilVar.f615a, "push_sdk_vc", Integer.toString(30705));
        com.xiaomi.push.n.a(ilVar.f615a, "token", m94a.b());
        if (!com.xiaomi.push.l.d()) {
            String a2 = bf.a(com.xiaomi.push.i.f(this.f4759a));
            String h = com.xiaomi.push.i.h(this.f4759a);
            if (!TextUtils.isEmpty(h)) {
                a2 = a2 + Constants.ACCEPT_TIME_SEPARATOR_SP + h;
            }
            if (!TextUtils.isEmpty(a2)) {
                com.xiaomi.push.n.a(ilVar.f615a, Constants.EXTRA_KEY_IMEI_MD5, a2);
            }
        }
        com.xiaomi.push.au.a(this.f4759a).a(ilVar.f615a);
        com.xiaomi.push.n.a(ilVar.f615a, Constants.EXTRA_KEY_REG_ID, m94a.m102c());
        com.xiaomi.push.n.a(ilVar.f615a, Constants.EXTRA_KEY_REG_SECRET, m94a.d());
        com.xiaomi.push.n.a(ilVar.f615a, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(this.f4759a).replace(Constants.ACCEPT_TIME_SEPARATOR_SP, Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        if (this.f59a) {
            Map<String, String> map = ilVar.f615a;
            c = aw.c(MiPushClient.getAllAlias(this.f4759a));
            com.xiaomi.push.n.a(map, Constants.EXTRA_KEY_ALIASES_MD5, c);
            Map<String, String> map2 = ilVar.f615a;
            c2 = aw.c(MiPushClient.getAllTopic(this.f4759a));
            com.xiaomi.push.n.a(map2, Constants.EXTRA_KEY_TOPICS_MD5, c2);
            Map<String, String> map3 = ilVar.f615a;
            c3 = aw.c(MiPushClient.getAllUserAccount(this.f4759a));
            com.xiaomi.push.n.a(map3, Constants.EXTRA_KEY_ACCOUNTS_MD5, c3);
        } else {
            Map<String, String> map4 = ilVar.f615a;
            d = aw.d(MiPushClient.getAllAlias(this.f4759a));
            com.xiaomi.push.n.a(map4, Constants.EXTRA_KEY_ALIASES, d);
            Map<String, String> map5 = ilVar.f615a;
            d2 = aw.d(MiPushClient.getAllTopic(this.f4759a));
            com.xiaomi.push.n.a(map5, "topics", d2);
            Map<String, String> map6 = ilVar.f615a;
            d3 = aw.d(MiPushClient.getAllUserAccount(this.f4759a));
            com.xiaomi.push.n.a(map6, Constants.EXTRA_KEY_ACCOUNTS, d3);
        }
        aq.a(this.f4759a).a((aq) ilVar, hm.Notification, false, (hz) null);
    }
}
