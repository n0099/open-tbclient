package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.push.Cif;
import com.xiaomi.push.ai;
import com.xiaomi.push.ek;
import com.xiaomi.push.em;
import com.xiaomi.push.hl;
import com.xiaomi.push.hq;
import com.xiaomi.push.iq;
import com.xiaomi.push.ir;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class p {
    public static void a(Context context, Intent intent, Uri uri) {
        if (context == null) {
            return;
        }
        ay.a(context).m57a();
        if (ek.a(context.getApplicationContext()).m240a() == null) {
            ek.a(context.getApplicationContext()).a(d.m68a(context.getApplicationContext()).m69a(), context.getPackageName(), com.xiaomi.push.service.ag.a(context.getApplicationContext()).a(hl.AwakeInfoUploadWaySwitch.a(), 0), new e());
            com.xiaomi.push.service.ag.a(context).a(new r(102, "awake online config", context));
        }
        if ((context instanceof Activity) && intent != null) {
            ek.a(context.getApplicationContext()).a(em.ACTIVITY, context, intent, (String) null);
        } else if (!(context instanceof Service) || intent == null) {
            if (uri == null || TextUtils.isEmpty(uri.toString())) {
                return;
            }
            ek.a(context.getApplicationContext()).a(em.PROVIDER, context, (Intent) null, uri.toString());
        } else if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
            ek.a(context.getApplicationContext()).a(em.SERVICE_COMPONENT, context, intent, (String) null);
        } else {
            ek.a(context.getApplicationContext()).a(em.SERVICE_ACTION, context, intent, (String) null);
        }
    }

    private static void a(Context context, Cif cif) {
        int i = 30;
        boolean a = com.xiaomi.push.service.ag.a(context).a(hl.AwakeAppPingSwitch.a(), false);
        int a2 = com.xiaomi.push.service.ag.a(context).a(hl.AwakeAppPingFrequency.a(), 0);
        if (a2 < 0 || a2 >= 30) {
            i = a2;
        } else {
            com.xiaomi.channel.commonutils.logger.b.c("aw_ping: frquency need > 30s.");
        }
        boolean z = i >= 0 ? a : false;
        if (!com.xiaomi.push.l.m466a()) {
            a(context, cif, z, i);
        } else if (z) {
            com.xiaomi.push.ai.a(context.getApplicationContext()).a((ai.a) new q(cif, context), i);
        }
    }

    public static final <T extends ir<T, ?>> void a(Context context, T t, boolean z, int i) {
        byte[] a = iq.a(t);
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.m30a("send message fail, because msgBytes is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_help_ping");
        intent.putExtra("extra_help_ping_switch", z);
        intent.putExtra("extra_help_ping_frequency", i);
        intent.putExtra("mipush_payload", a);
        intent.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        ay.a(context).m58a(intent);
    }

    public static void a(Context context, String str) {
        com.xiaomi.channel.commonutils.logger.b.m30a("aw_ping : send aw_ping cmd and content to push service from 3rd app");
        HashMap hashMap = new HashMap();
        hashMap.put("awake_info", str);
        hashMap.put("event_type", String.valueOf(9999));
        hashMap.put("description", "ping message");
        Cif cif = new Cif();
        cif.b(d.m68a(context).m69a());
        cif.d(context.getPackageName());
        cif.c(hq.AwakeAppResponse.f489a);
        cif.a(com.xiaomi.push.service.aj.a());
        cif.f629a = hashMap;
        a(context, cif);
    }

    public static void a(Context context, String str, int i, String str2) {
        Cif cif = new Cif();
        cif.b(str);
        cif.a(new HashMap());
        cif.m399a().put("extra_aw_app_online_cmd", String.valueOf(i));
        cif.m399a().put("extra_help_aw_info", str2);
        cif.a(com.xiaomi.push.service.aj.a());
        byte[] a = iq.a(cif);
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.m30a("send message fail, because msgBytes is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_aw_app_logic");
        intent.putExtra("mipush_payload", a);
        ay.a(context).m58a(intent);
    }
}
