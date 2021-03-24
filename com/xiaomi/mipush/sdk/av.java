package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.ax;
import com.xiaomi.push.bm;
import com.xiaomi.push.hf;
import com.xiaomi.push.hp;
import com.xiaomi.push.hs;
import com.xiaomi.push.ie;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public final class av implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f40178a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f75a;

    public av(Context context, boolean z) {
        this.f40178a = context;
        this.f75a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        String d2;
        String d3;
        Map<String, String> map;
        String d4;
        String str;
        String c2;
        String c3;
        com.xiaomi.channel.commonutils.logger.b.m51a("do sync info");
        ie ieVar = new ie(com.xiaomi.push.service.at.a(), false);
        b m92a = b.m92a(this.f40178a);
        ieVar.c(hp.SyncInfo.f506a);
        ieVar.b(m92a.m93a());
        ieVar.d(this.f40178a.getPackageName());
        HashMap hashMap = new HashMap();
        ieVar.f647a = hashMap;
        Context context = this.f40178a;
        com.xiaomi.push.n.a(hashMap, "app_version", com.xiaomi.push.g.m319a(context, context.getPackageName()));
        Map<String, String> map2 = ieVar.f647a;
        Context context2 = this.f40178a;
        com.xiaomi.push.n.a(map2, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.push.g.a(context2, context2.getPackageName())));
        com.xiaomi.push.n.a(ieVar.f647a, "push_sdk_vn", "3_8_5");
        com.xiaomi.push.n.a(ieVar.f647a, "push_sdk_vc", Integer.toString(30805));
        com.xiaomi.push.n.a(ieVar.f647a, "token", m92a.b());
        com.xiaomi.push.i.a(this.f40178a, ieVar.f647a);
        if (!com.xiaomi.push.l.d()) {
            String a2 = bm.a(com.xiaomi.push.i.f(this.f40178a));
            String h2 = com.xiaomi.push.i.h(this.f40178a);
            if (!TextUtils.isEmpty(h2)) {
                a2 = a2 + "," + h2;
            }
            if (!TextUtils.isEmpty(a2)) {
                com.xiaomi.push.n.a(ieVar.f647a, Constants.EXTRA_KEY_IMEI_MD5, a2);
            }
        }
        ax.a(this.f40178a).a(ieVar.f647a);
        com.xiaomi.push.n.a(ieVar.f647a, Constants.EXTRA_KEY_REG_ID, m92a.m100c());
        com.xiaomi.push.n.a(ieVar.f647a, Constants.EXTRA_KEY_REG_SECRET, m92a.d());
        com.xiaomi.push.n.a(ieVar.f647a, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(this.f40178a).replace(",", "-"));
        if (this.f75a) {
            Map<String, String> map3 = ieVar.f647a;
            c2 = au.c(MiPushClient.getAllAlias(this.f40178a));
            com.xiaomi.push.n.a(map3, Constants.EXTRA_KEY_ALIASES_MD5, c2);
            Map<String, String> map4 = ieVar.f647a;
            c3 = au.c(MiPushClient.getAllTopic(this.f40178a));
            com.xiaomi.push.n.a(map4, Constants.EXTRA_KEY_TOPICS_MD5, c3);
            map = ieVar.f647a;
            d4 = au.c(MiPushClient.getAllUserAccount(this.f40178a));
            str = Constants.EXTRA_KEY_ACCOUNTS_MD5;
        } else {
            Map<String, String> map5 = ieVar.f647a;
            d2 = au.d(MiPushClient.getAllAlias(this.f40178a));
            com.xiaomi.push.n.a(map5, Constants.EXTRA_KEY_ALIASES, d2);
            Map<String, String> map6 = ieVar.f647a;
            d3 = au.d(MiPushClient.getAllTopic(this.f40178a));
            com.xiaomi.push.n.a(map6, Constants.EXTRA_KEY_TOPICS, d3);
            map = ieVar.f647a;
            d4 = au.d(MiPushClient.getAllUserAccount(this.f40178a));
            str = Constants.EXTRA_KEY_ACCOUNTS;
        }
        com.xiaomi.push.n.a(map, str, d4);
        an.a(this.f40178a).a((an) ieVar, hf.Notification, false, (hs) null);
    }
}
