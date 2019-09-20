package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class bg implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(Context context, boolean z) {
        this.a = context;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        String d;
        String d2;
        String d3;
        String c;
        String c2;
        String c3;
        com.xiaomi.channel.commonutils.logger.b.a("do sync info");
        com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai(com.xiaomi.push.service.aq.a(), false);
        d a = d.a(this.a);
        aiVar.c(com.xiaomi.xmpush.thrift.r.SyncInfo.aa);
        aiVar.b(a.c());
        aiVar.d(this.a.getPackageName());
        aiVar.h = new HashMap();
        com.xiaomi.channel.commonutils.android.h.a(aiVar.h, "app_version", com.xiaomi.channel.commonutils.android.a.a(this.a, this.a.getPackageName()));
        com.xiaomi.channel.commonutils.android.h.a(aiVar.h, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.channel.commonutils.android.a.b(this.a, this.a.getPackageName())));
        com.xiaomi.channel.commonutils.android.h.a(aiVar.h, "push_sdk_vn", "3_6_9");
        com.xiaomi.channel.commonutils.android.h.a(aiVar.h, "push_sdk_vc", Integer.toString(30609));
        com.xiaomi.channel.commonutils.android.h.a(aiVar.h, "token", a.d());
        if (!com.xiaomi.channel.commonutils.android.f.g()) {
            String a2 = com.xiaomi.channel.commonutils.string.d.a(com.xiaomi.channel.commonutils.android.d.e(this.a));
            String g = com.xiaomi.channel.commonutils.android.d.g(this.a);
            if (!TextUtils.isEmpty(g)) {
                a2 = a2 + Constants.ACCEPT_TIME_SEPARATOR_SP + g;
            }
            com.xiaomi.channel.commonutils.android.h.a(aiVar.h, Constants.EXTRA_KEY_IMEI_MD5, a2);
        }
        com.xiaomi.channel.commonutils.android.h.a(aiVar.h, Constants.EXTRA_KEY_REG_ID, a.e());
        com.xiaomi.channel.commonutils.android.h.a(aiVar.h, Constants.EXTRA_KEY_REG_SECRET, a.f());
        com.xiaomi.channel.commonutils.android.h.a(aiVar.h, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(this.a).replace(Constants.ACCEPT_TIME_SEPARATOR_SP, Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        if (this.b) {
            Map<String, String> map = aiVar.h;
            c = bf.c(MiPushClient.getAllAlias(this.a));
            com.xiaomi.channel.commonutils.android.h.a(map, Constants.EXTRA_KEY_ALIASES_MD5, c);
            Map<String, String> map2 = aiVar.h;
            c2 = bf.c(MiPushClient.getAllTopic(this.a));
            com.xiaomi.channel.commonutils.android.h.a(map2, Constants.EXTRA_KEY_TOPICS_MD5, c2);
            Map<String, String> map3 = aiVar.h;
            c3 = bf.c(MiPushClient.getAllUserAccount(this.a));
            com.xiaomi.channel.commonutils.android.h.a(map3, Constants.EXTRA_KEY_ACCOUNTS_MD5, c3);
        } else {
            Map<String, String> map4 = aiVar.h;
            d = bf.d(MiPushClient.getAllAlias(this.a));
            com.xiaomi.channel.commonutils.android.h.a(map4, Constants.EXTRA_KEY_ALIASES, d);
            Map<String, String> map5 = aiVar.h;
            d2 = bf.d(MiPushClient.getAllTopic(this.a));
            com.xiaomi.channel.commonutils.android.h.a(map5, Constants.EXTRA_KEY_TOPICS, d2);
            Map<String, String> map6 = aiVar.h;
            d3 = bf.d(MiPushClient.getAllUserAccount(this.a));
            com.xiaomi.channel.commonutils.android.h.a(map6, Constants.EXTRA_KEY_ACCOUNTS, d3);
        }
        az.a(this.a).a((az) aiVar, com.xiaomi.xmpush.thrift.a.Notification, false, (com.xiaomi.xmpush.thrift.u) null);
    }
}
