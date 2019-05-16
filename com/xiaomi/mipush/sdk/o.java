package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.misc.h;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class o {
    public static void a(Context context, Intent intent, Uri uri) {
        if (context == null) {
            return;
        }
        az.a(context).a();
        if (com.xiaomi.push.service.awake.module.c.a(context.getApplicationContext()).a() == null) {
            com.xiaomi.push.service.awake.module.c.a(context.getApplicationContext()).a(d.a(context.getApplicationContext()).c(), context.getPackageName(), com.xiaomi.push.service.an.a(context.getApplicationContext()).a(com.xiaomi.xmpush.thrift.g.AwakeInfoUploadWaySwitch.a(), 0), new e());
        }
        if ((context instanceof Activity) && intent != null) {
            com.xiaomi.push.service.awake.module.c.a(context.getApplicationContext()).a(com.xiaomi.push.service.awake.module.e.ACTIVITY, context, intent, (String) null);
        } else if (!(context instanceof Service) || intent == null) {
            if (uri == null || TextUtils.isEmpty(uri.toString())) {
                return;
            }
            com.xiaomi.push.service.awake.module.c.a(context.getApplicationContext()).a(com.xiaomi.push.service.awake.module.e.PROVIDER, context, (Intent) null, uri.toString());
        } else if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
            com.xiaomi.push.service.awake.module.c.a(context.getApplicationContext()).a(com.xiaomi.push.service.awake.module.e.SERVICE_COMPONENT, context, intent, (String) null);
        } else {
            com.xiaomi.push.service.awake.module.c.a(context.getApplicationContext()).a(com.xiaomi.push.service.awake.module.e.SERVICE_ACTION, context, intent, (String) null);
        }
    }

    private static void a(Context context, com.xiaomi.xmpush.thrift.ai aiVar) {
        int i = 30;
        boolean a = com.xiaomi.push.service.an.a(context).a(com.xiaomi.xmpush.thrift.g.AwakeAppPingSwitch.a(), false);
        int a2 = com.xiaomi.push.service.an.a(context).a(com.xiaomi.xmpush.thrift.g.AwakeAppPingFrequency.a(), 0);
        if (a2 < 0 || a2 >= 30) {
            i = a2;
        } else {
            com.xiaomi.channel.commonutils.logger.b.c("aw_ping: frquency need > 30s.");
        }
        boolean z = i >= 0 ? a : false;
        if (!com.xiaomi.channel.commonutils.android.f.a()) {
            a(context, aiVar, z, i);
        } else if (z) {
            com.xiaomi.channel.commonutils.misc.h.a(context.getApplicationContext()).a((h.a) new p(aiVar, context), i);
        }
    }

    public static void a(Context context, String str) {
        com.xiaomi.channel.commonutils.logger.b.a("aw_ping : send aw_ping cmd and content to push service from 3rd app");
        HashMap hashMap = new HashMap();
        hashMap.put("awake_info", str);
        hashMap.put("event_type", String.valueOf(9999));
        hashMap.put("description", "ping message");
        com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai();
        aiVar.b(d.a(context).c());
        aiVar.d(context.getPackageName());
        aiVar.c(com.xiaomi.xmpush.thrift.r.AwakeAppResponse.aa);
        aiVar.a(com.xiaomi.push.service.aq.a());
        aiVar.h = hashMap;
        a(context, aiVar);
    }

    public static void a(Context context, String str, int i, String str2) {
        com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai();
        aiVar.b(str);
        aiVar.a(new HashMap());
        aiVar.j().put("extra_aw_app_online_cmd", String.valueOf(i));
        aiVar.j().put("extra_help_aw_info", str2);
        aiVar.a(com.xiaomi.push.service.aq.a());
        byte[] a = com.xiaomi.xmpush.thrift.at.a(aiVar);
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.a("send message fail, because msgBytes is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_aw_app_logic");
        intent.putExtra("mipush_payload", a);
        az.a(context).a(intent);
    }

    public static final <T extends org.apache.thrift.a<T, ?>> void a(Context context, T t, boolean z, int i) {
        byte[] a = com.xiaomi.xmpush.thrift.at.a(t);
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.a("send message fail, because msgBytes is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_help_ping");
        intent.putExtra("extra_help_ping_switch", z);
        intent.putExtra("extra_help_ping_frequency", i);
        intent.putExtra("mipush_payload", a);
        intent.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        az.a(context).a(intent);
    }
}
