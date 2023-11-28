package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.ar.pose.PoseAR;
import com.xiaomi.push.aj;
import com.xiaomi.push.ec;
import com.xiaomi.push.ee;
import com.xiaomi.push.hm;
import com.xiaomi.push.hr;
import com.xiaomi.push.ig;
import com.xiaomi.push.ir;
import com.xiaomi.push.is;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.bd;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class o {
    public static void a(Context context, Intent intent, Uri uri) {
        ec a;
        ee eeVar;
        if (context == null) {
            return;
        }
        ao.a(context).m224a();
        if (ec.a(context.getApplicationContext()).m459a() == null) {
            ec.a(context.getApplicationContext()).a(b.m234a(context.getApplicationContext()).m235a(), context.getPackageName(), ba.a(context.getApplicationContext()).a(hm.AwakeInfoUploadWaySwitch.a(), 0), new c());
            ba.a(context).a(new q(102, "awake online config", context));
        }
        if ((context instanceof Activity) && intent != null) {
            a = ec.a(context.getApplicationContext());
            eeVar = ee.ACTIVITY;
        } else if (!(context instanceof Service) || intent == null) {
            if (uri == null || TextUtils.isEmpty(uri.toString())) {
                return;
            }
            ec.a(context.getApplicationContext()).a(ee.PROVIDER, context, (Intent) null, uri.toString());
            return;
        } else if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
            a = ec.a(context.getApplicationContext());
            eeVar = ee.SERVICE_COMPONENT;
        } else {
            a = ec.a(context.getApplicationContext());
            eeVar = ee.SERVICE_ACTION;
        }
        a.a(eeVar, context, intent, (String) null);
    }

    public static void a(Context context, ig igVar) {
        boolean a = ba.a(context).a(hm.AwakeAppPingSwitch.a(), false);
        int a2 = ba.a(context).a(hm.AwakeAppPingFrequency.a(), 0);
        if (a2 >= 0 && a2 < 30) {
            com.xiaomi.channel.commonutils.logger.b.c("aw_ping: frquency need > 30s.");
            a2 = 30;
        }
        boolean z = a2 >= 0 ? a : false;
        if (!com.xiaomi.push.j.m720a()) {
            a(context, igVar, z, a2);
        } else if (z) {
            com.xiaomi.push.aj.a(context.getApplicationContext()).a((aj.a) new p(igVar, context), a2);
        }
    }

    public static final <T extends is<T, ?>> void a(Context context, T t, boolean z, int i) {
        byte[] a = ir.a(t);
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.m190a("send message fail, because msgBytes is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_help_ping");
        intent.putExtra("extra_help_ping_switch", z);
        intent.putExtra("extra_help_ping_frequency", i);
        intent.putExtra("mipush_payload", a);
        intent.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        ao.a(context).m226a(intent);
    }

    public static void a(Context context, String str) {
        com.xiaomi.channel.commonutils.logger.b.m190a("aw_ping : send aw_ping cmd and content to push service from 3rd app");
        HashMap hashMap = new HashMap();
        hashMap.put("awake_info", str);
        hashMap.put(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, String.valueOf(9999));
        hashMap.put("description", "ping message");
        ig igVar = new ig();
        igVar.b(b.m234a(context).m235a());
        igVar.d(context.getPackageName());
        igVar.c(hr.AwakeAppResponse.f504a);
        igVar.a(bd.a());
        igVar.f646a = hashMap;
        a(context, igVar);
    }

    public static void a(Context context, String str, int i, String str2) {
        ig igVar = new ig();
        igVar.b(str);
        igVar.a(new HashMap());
        igVar.m650a().put("extra_aw_app_online_cmd", String.valueOf(i));
        igVar.m650a().put("extra_help_aw_info", str2);
        igVar.a(bd.a());
        byte[] a = ir.a(igVar);
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.m190a("send message fail, because msgBytes is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_aw_app_logic");
        intent.putExtra("mipush_payload", a);
        ao.a(context).m226a(intent);
    }
}
