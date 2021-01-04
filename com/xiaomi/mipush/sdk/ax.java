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
/* loaded from: classes6.dex */
public final class ax implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f14117a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f140a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(Context context, boolean z) {
        this.f14117a = context;
        this.f140a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        String d;
        String d2;
        String d3;
        String c;
        String c2;
        String c3;
        com.xiaomi.channel.commonutils.logger.b.m73a("do sync info");
        il ilVar = new il(com.xiaomi.push.service.an.a(), false);
        b m113a = b.m113a(this.f14117a);
        ilVar.c(hw.SyncInfo.f555a);
        ilVar.b(m113a.m114a());
        ilVar.d(this.f14117a.getPackageName());
        ilVar.f696a = new HashMap();
        com.xiaomi.push.n.a(ilVar.f696a, "app_version", com.xiaomi.push.g.m326a(this.f14117a, this.f14117a.getPackageName()));
        com.xiaomi.push.n.a(ilVar.f696a, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.push.g.a(this.f14117a, this.f14117a.getPackageName())));
        com.xiaomi.push.n.a(ilVar.f696a, "push_sdk_vn", "3_7_5");
        com.xiaomi.push.n.a(ilVar.f696a, "push_sdk_vc", Integer.toString(30705));
        com.xiaomi.push.n.a(ilVar.f696a, "token", m113a.b());
        if (!com.xiaomi.push.l.d()) {
            String a2 = bf.a(com.xiaomi.push.i.f(this.f14117a));
            String h = com.xiaomi.push.i.h(this.f14117a);
            if (!TextUtils.isEmpty(h)) {
                a2 = a2 + "," + h;
            }
            if (!TextUtils.isEmpty(a2)) {
                com.xiaomi.push.n.a(ilVar.f696a, Constants.EXTRA_KEY_IMEI_MD5, a2);
            }
        }
        com.xiaomi.push.au.a(this.f14117a).a(ilVar.f696a);
        com.xiaomi.push.n.a(ilVar.f696a, Constants.EXTRA_KEY_REG_ID, m113a.m121c());
        com.xiaomi.push.n.a(ilVar.f696a, Constants.EXTRA_KEY_REG_SECRET, m113a.d());
        com.xiaomi.push.n.a(ilVar.f696a, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(this.f14117a).replace(",", Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        if (this.f140a) {
            Map<String, String> map = ilVar.f696a;
            c = aw.c(MiPushClient.getAllAlias(this.f14117a));
            com.xiaomi.push.n.a(map, Constants.EXTRA_KEY_ALIASES_MD5, c);
            Map<String, String> map2 = ilVar.f696a;
            c2 = aw.c(MiPushClient.getAllTopic(this.f14117a));
            com.xiaomi.push.n.a(map2, Constants.EXTRA_KEY_TOPICS_MD5, c2);
            Map<String, String> map3 = ilVar.f696a;
            c3 = aw.c(MiPushClient.getAllUserAccount(this.f14117a));
            com.xiaomi.push.n.a(map3, Constants.EXTRA_KEY_ACCOUNTS_MD5, c3);
        } else {
            Map<String, String> map4 = ilVar.f696a;
            d = aw.d(MiPushClient.getAllAlias(this.f14117a));
            com.xiaomi.push.n.a(map4, Constants.EXTRA_KEY_ALIASES, d);
            Map<String, String> map5 = ilVar.f696a;
            d2 = aw.d(MiPushClient.getAllTopic(this.f14117a));
            com.xiaomi.push.n.a(map5, Constants.EXTRA_KEY_TOPICS, d2);
            Map<String, String> map6 = ilVar.f696a;
            d3 = aw.d(MiPushClient.getAllUserAccount(this.f14117a));
            com.xiaomi.push.n.a(map6, Constants.EXTRA_KEY_ACCOUNTS, d3);
        }
        aq.a(this.f14117a).a((aq) ilVar, hm.Notification, false, (hz) null);
    }
}
