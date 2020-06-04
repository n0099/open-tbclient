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
    final /* synthetic */ boolean f60a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(Context context, boolean z) {
        this.a = context;
        this.f60a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        String d;
        String d2;
        String d3;
        String c;
        String c2;
        String c3;
        com.xiaomi.channel.commonutils.logger.b.m51a("do sync info");
        il ilVar = new il(com.xiaomi.push.service.an.a(), false);
        b m91a = b.m91a(this.a);
        ilVar.c(hw.SyncInfo.f475a);
        ilVar.b(m91a.m92a());
        ilVar.d(this.a.getPackageName());
        ilVar.f616a = new HashMap();
        com.xiaomi.push.n.a(ilVar.f616a, "app_version", com.xiaomi.push.g.m304a(this.a, this.a.getPackageName()));
        com.xiaomi.push.n.a(ilVar.f616a, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.push.g.a(this.a, this.a.getPackageName())));
        com.xiaomi.push.n.a(ilVar.f616a, "push_sdk_vn", "3_7_5");
        com.xiaomi.push.n.a(ilVar.f616a, "push_sdk_vc", Integer.toString(30705));
        com.xiaomi.push.n.a(ilVar.f616a, "token", m91a.b());
        if (!com.xiaomi.push.l.d()) {
            String a = bf.a(com.xiaomi.push.i.f(this.a));
            String h = com.xiaomi.push.i.h(this.a);
            if (!TextUtils.isEmpty(h)) {
                a = a + Constants.ACCEPT_TIME_SEPARATOR_SP + h;
            }
            if (!TextUtils.isEmpty(a)) {
                com.xiaomi.push.n.a(ilVar.f616a, Constants.EXTRA_KEY_IMEI_MD5, a);
            }
        }
        com.xiaomi.push.au.a(this.a).a(ilVar.f616a);
        com.xiaomi.push.n.a(ilVar.f616a, Constants.EXTRA_KEY_REG_ID, m91a.m99c());
        com.xiaomi.push.n.a(ilVar.f616a, Constants.EXTRA_KEY_REG_SECRET, m91a.d());
        com.xiaomi.push.n.a(ilVar.f616a, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(this.a).replace(Constants.ACCEPT_TIME_SEPARATOR_SP, Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        if (this.f60a) {
            Map<String, String> map = ilVar.f616a;
            c = aw.c(MiPushClient.getAllAlias(this.a));
            com.xiaomi.push.n.a(map, Constants.EXTRA_KEY_ALIASES_MD5, c);
            Map<String, String> map2 = ilVar.f616a;
            c2 = aw.c(MiPushClient.getAllTopic(this.a));
            com.xiaomi.push.n.a(map2, Constants.EXTRA_KEY_TOPICS_MD5, c2);
            Map<String, String> map3 = ilVar.f616a;
            c3 = aw.c(MiPushClient.getAllUserAccount(this.a));
            com.xiaomi.push.n.a(map3, Constants.EXTRA_KEY_ACCOUNTS_MD5, c3);
        } else {
            Map<String, String> map4 = ilVar.f616a;
            d = aw.d(MiPushClient.getAllAlias(this.a));
            com.xiaomi.push.n.a(map4, Constants.EXTRA_KEY_ALIASES, d);
            Map<String, String> map5 = ilVar.f616a;
            d2 = aw.d(MiPushClient.getAllTopic(this.a));
            com.xiaomi.push.n.a(map5, "topics", d2);
            Map<String, String> map6 = ilVar.f616a;
            d3 = aw.d(MiPushClient.getAllUserAccount(this.a));
            com.xiaomi.push.n.a(map6, Constants.EXTRA_KEY_ACCOUNTS, d3);
        }
        aq.a(this.a).a((aq) ilVar, hm.Notification, false, (hz) null);
    }
}
