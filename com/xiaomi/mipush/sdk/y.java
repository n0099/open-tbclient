package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.xmpush.thrift.ae;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class y implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Context context, boolean z) {
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
        ae aeVar = new ae(MiPushClient.generatePacketID(), false);
        a a = a.a(this.a);
        aeVar.c(com.xiaomi.xmpush.thrift.o.SyncInfo.N);
        aeVar.b(a.c());
        aeVar.d(this.a.getPackageName());
        aeVar.h = new HashMap();
        com.xiaomi.channel.commonutils.android.h.a(aeVar.h, "app_version", com.xiaomi.channel.commonutils.android.b.a(this.a, this.a.getPackageName()));
        com.xiaomi.channel.commonutils.android.h.a(aeVar.h, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.channel.commonutils.android.b.b(this.a, this.a.getPackageName())));
        com.xiaomi.channel.commonutils.android.h.a(aeVar.h, "push_sdk_vn", "3_2_2");
        com.xiaomi.channel.commonutils.android.h.a(aeVar.h, "push_sdk_vc", Integer.toString(30202));
        com.xiaomi.channel.commonutils.android.h.a(aeVar.h, "token", a.d());
        com.xiaomi.channel.commonutils.android.h.a(aeVar.h, Constants.EXTRA_KEY_IMEI_MD5, com.xiaomi.channel.commonutils.string.d.a(com.xiaomi.channel.commonutils.android.e.c(this.a)));
        com.xiaomi.channel.commonutils.android.h.a(aeVar.h, Constants.EXTRA_KEY_REG_ID, a.e());
        com.xiaomi.channel.commonutils.android.h.a(aeVar.h, Constants.EXTRA_KEY_REG_SECRET, a.f());
        com.xiaomi.channel.commonutils.android.h.a(aeVar.h, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(this.a).replace(",", Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        if (this.b) {
            Map<String, String> map = aeVar.h;
            c = x.c(MiPushClient.getAllAlias(this.a));
            com.xiaomi.channel.commonutils.android.h.a(map, Constants.EXTRA_KEY_ALIASES_MD5, c);
            Map<String, String> map2 = aeVar.h;
            c2 = x.c(MiPushClient.getAllTopic(this.a));
            com.xiaomi.channel.commonutils.android.h.a(map2, Constants.EXTRA_KEY_TOPICS_MD5, c2);
            Map<String, String> map3 = aeVar.h;
            c3 = x.c(MiPushClient.getAllUserAccount(this.a));
            com.xiaomi.channel.commonutils.android.h.a(map3, Constants.EXTRA_KEY_ACCOUNTS_MD5, c3);
        } else {
            Map<String, String> map4 = aeVar.h;
            d = x.d(MiPushClient.getAllAlias(this.a));
            com.xiaomi.channel.commonutils.android.h.a(map4, Constants.EXTRA_KEY_ALIASES, d);
            Map<String, String> map5 = aeVar.h;
            d2 = x.d(MiPushClient.getAllTopic(this.a));
            com.xiaomi.channel.commonutils.android.h.a(map5, Constants.EXTRA_KEY_TOPICS, d2);
            Map<String, String> map6 = aeVar.h;
            d3 = x.d(MiPushClient.getAllUserAccount(this.a));
            com.xiaomi.channel.commonutils.android.h.a(map6, Constants.EXTRA_KEY_ACCOUNTS, d3);
        }
        u.a(this.a).a(aeVar, com.xiaomi.xmpush.thrift.a.Notification, false, null);
    }
}
