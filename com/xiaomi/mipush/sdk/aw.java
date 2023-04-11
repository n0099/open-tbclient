package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.az;
import com.xiaomi.push.bo;
import com.xiaomi.push.hh;
import com.xiaomi.push.hr;
import com.xiaomi.push.hu;
import com.xiaomi.push.ig;
import com.xiaomi.push.service.bd;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class aw implements Runnable {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f69a;

    public aw(Context context, boolean z) {
        this.a = context;
        this.f69a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        String d;
        String d2;
        Map<String, String> map;
        String d3;
        String str;
        String c;
        String c2;
        com.xiaomi.channel.commonutils.logger.b.m101a("do sync info");
        ig igVar = new ig(bd.a(), false);
        b m145a = b.m145a(this.a);
        igVar.c(hr.SyncInfo.f508a);
        igVar.b(m145a.m146a());
        igVar.d(this.a.getPackageName());
        HashMap hashMap = new HashMap();
        igVar.f650a = hashMap;
        Context context = this.a;
        com.xiaomi.push.k.a(hashMap, "app_version", com.xiaomi.push.g.m436a(context, context.getPackageName()));
        Map<String, String> map2 = igVar.f650a;
        Context context2 = this.a;
        com.xiaomi.push.k.a(map2, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.push.g.a(context2, context2.getPackageName())));
        com.xiaomi.push.k.a(igVar.f650a, "push_sdk_vn", BuildConfig.VERSION_NAME);
        com.xiaomi.push.k.a(igVar.f650a, "push_sdk_vc", Integer.toString(50005));
        com.xiaomi.push.k.a(igVar.f650a, "token", m145a.b());
        if (!com.xiaomi.push.j.m637d()) {
            String a = bo.a(com.xiaomi.push.i.c(this.a));
            String e = com.xiaomi.push.i.e(this.a);
            if (!TextUtils.isEmpty(e)) {
                a = a + "," + e;
            }
            if (!TextUtils.isEmpty(a)) {
                com.xiaomi.push.k.a(igVar.f650a, Constants.EXTRA_KEY_IMEI_MD5, a);
            }
        }
        az.a(this.a).a(igVar.f650a);
        com.xiaomi.push.k.a(igVar.f650a, Constants.EXTRA_KEY_REG_ID, m145a.m153c());
        com.xiaomi.push.k.a(igVar.f650a, Constants.EXTRA_KEY_REG_SECRET, m145a.d());
        com.xiaomi.push.k.a(igVar.f650a, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(this.a).replace(",", "-"));
        if (this.f69a) {
            Map<String, String> map3 = igVar.f650a;
            c = av.c(MiPushClient.getAllAlias(this.a));
            com.xiaomi.push.k.a(map3, Constants.EXTRA_KEY_ALIASES_MD5, c);
            Map<String, String> map4 = igVar.f650a;
            c2 = av.c(MiPushClient.getAllTopic(this.a));
            com.xiaomi.push.k.a(map4, Constants.EXTRA_KEY_TOPICS_MD5, c2);
            map = igVar.f650a;
            d3 = av.c(MiPushClient.getAllUserAccount(this.a));
            str = Constants.EXTRA_KEY_ACCOUNTS_MD5;
        } else {
            Map<String, String> map5 = igVar.f650a;
            d = av.d(MiPushClient.getAllAlias(this.a));
            com.xiaomi.push.k.a(map5, Constants.EXTRA_KEY_ALIASES, d);
            Map<String, String> map6 = igVar.f650a;
            d2 = av.d(MiPushClient.getAllTopic(this.a));
            com.xiaomi.push.k.a(map6, Constants.EXTRA_KEY_TOPICS, d2);
            map = igVar.f650a;
            d3 = av.d(MiPushClient.getAllUserAccount(this.a));
            str = Constants.EXTRA_KEY_ACCOUNTS;
        }
        com.xiaomi.push.k.a(map, str, d3);
        ao.a(this.a).a((ao) igVar, hh.Notification, false, (hu) null);
    }
}
