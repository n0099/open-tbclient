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
/* loaded from: classes18.dex */
public final class ax implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4531a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f62a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(Context context, boolean z) {
        this.f4531a = context;
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
        com.xiaomi.channel.commonutils.logger.b.m47a("do sync info");
        il ilVar = new il(com.xiaomi.push.service.an.a(), false);
        b m87a = b.m87a(this.f4531a);
        ilVar.c(hw.SyncInfo.f477a);
        ilVar.b(m87a.m88a());
        ilVar.d(this.f4531a.getPackageName());
        ilVar.f618a = new HashMap();
        com.xiaomi.push.n.a(ilVar.f618a, "app_version", com.xiaomi.push.g.m300a(this.f4531a, this.f4531a.getPackageName()));
        com.xiaomi.push.n.a(ilVar.f618a, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.push.g.a(this.f4531a, this.f4531a.getPackageName())));
        com.xiaomi.push.n.a(ilVar.f618a, "push_sdk_vn", "3_7_5");
        com.xiaomi.push.n.a(ilVar.f618a, "push_sdk_vc", Integer.toString(30705));
        com.xiaomi.push.n.a(ilVar.f618a, "token", m87a.b());
        if (!com.xiaomi.push.l.d()) {
            String a2 = bf.a(com.xiaomi.push.i.f(this.f4531a));
            String h = com.xiaomi.push.i.h(this.f4531a);
            if (!TextUtils.isEmpty(h)) {
                a2 = a2 + "," + h;
            }
            if (!TextUtils.isEmpty(a2)) {
                com.xiaomi.push.n.a(ilVar.f618a, Constants.EXTRA_KEY_IMEI_MD5, a2);
            }
        }
        com.xiaomi.push.au.a(this.f4531a).a(ilVar.f618a);
        com.xiaomi.push.n.a(ilVar.f618a, Constants.EXTRA_KEY_REG_ID, m87a.m95c());
        com.xiaomi.push.n.a(ilVar.f618a, Constants.EXTRA_KEY_REG_SECRET, m87a.d());
        com.xiaomi.push.n.a(ilVar.f618a, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(this.f4531a).replace(",", Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        if (this.f62a) {
            Map<String, String> map = ilVar.f618a;
            c = aw.c(MiPushClient.getAllAlias(this.f4531a));
            com.xiaomi.push.n.a(map, Constants.EXTRA_KEY_ALIASES_MD5, c);
            Map<String, String> map2 = ilVar.f618a;
            c2 = aw.c(MiPushClient.getAllTopic(this.f4531a));
            com.xiaomi.push.n.a(map2, Constants.EXTRA_KEY_TOPICS_MD5, c2);
            Map<String, String> map3 = ilVar.f618a;
            c3 = aw.c(MiPushClient.getAllUserAccount(this.f4531a));
            com.xiaomi.push.n.a(map3, Constants.EXTRA_KEY_ACCOUNTS_MD5, c3);
        } else {
            Map<String, String> map4 = ilVar.f618a;
            d = aw.d(MiPushClient.getAllAlias(this.f4531a));
            com.xiaomi.push.n.a(map4, Constants.EXTRA_KEY_ALIASES, d);
            Map<String, String> map5 = ilVar.f618a;
            d2 = aw.d(MiPushClient.getAllTopic(this.f4531a));
            com.xiaomi.push.n.a(map5, "topics", d2);
            Map<String, String> map6 = ilVar.f618a;
            d3 = aw.d(MiPushClient.getAllUserAccount(this.f4531a));
            com.xiaomi.push.n.a(map6, Constants.EXTRA_KEY_ACCOUNTS, d3);
        }
        aq.a(this.f4531a).a((aq) ilVar, hm.Notification, false, (hz) null);
    }
}
