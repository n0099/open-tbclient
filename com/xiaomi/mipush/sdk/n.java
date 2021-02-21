package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.ar.pose.PoseAR;
import com.xiaomi.push.ai;
import com.xiaomi.push.eq;
import com.xiaomi.push.es;
import com.xiaomi.push.hr;
import com.xiaomi.push.hw;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class n {
    public static void a(Context context, Intent intent, Uri uri) {
        if (context == null) {
            return;
        }
        aq.a(context).m110a();
        if (eq.a(context.getApplicationContext()).m293a() == null) {
            eq.a(context.getApplicationContext()).a(b.m119a(context.getApplicationContext()).m120a(), context.getPackageName(), com.xiaomi.push.service.ak.a(context.getApplicationContext()).a(hr.AwakeInfoUploadWaySwitch.a(), 0), new c());
            com.xiaomi.push.service.ak.a(context).a(new p(102, "awake online config", context));
        }
        if ((context instanceof Activity) && intent != null) {
            eq.a(context.getApplicationContext()).a(es.ACTIVITY, context, intent, (String) null);
        } else if (!(context instanceof Service) || intent == null) {
            if (uri == null || TextUtils.isEmpty(uri.toString())) {
                return;
            }
            eq.a(context.getApplicationContext()).a(es.PROVIDER, context, (Intent) null, uri.toString());
        } else if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
            eq.a(context.getApplicationContext()).a(es.SERVICE_COMPONENT, context, intent, (String) null);
        } else {
            eq.a(context.getApplicationContext()).a(es.SERVICE_ACTION, context, intent, (String) null);
        }
    }

    private static void a(Context context, il ilVar) {
        int i = 30;
        boolean a2 = com.xiaomi.push.service.ak.a(context).a(hr.AwakeAppPingSwitch.a(), false);
        int a3 = com.xiaomi.push.service.ak.a(context).a(hr.AwakeAppPingFrequency.a(), 0);
        if (a3 < 0 || a3 >= 30) {
            i = a3;
        } else {
            com.xiaomi.channel.commonutils.logger.b.c("aw_ping: frquency need > 30s.");
        }
        boolean z = i >= 0 ? a2 : false;
        if (!com.xiaomi.push.l.m525a()) {
            a(context, ilVar, z, i);
        } else if (z) {
            com.xiaomi.push.ai.a(context.getApplicationContext()).a((ai.a) new o(ilVar, context), i);
        }
    }

    public static final <T extends ix<T, ?>> void a(Context context, T t, boolean z, int i) {
        byte[] a2 = iw.a(t);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m79a("send message fail, because msgBytes is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_help_ping");
        intent.putExtra("extra_help_ping_switch", z);
        intent.putExtra("extra_help_ping_frequency", i);
        intent.putExtra("mipush_payload", a2);
        intent.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        aq.a(context).m111a(intent);
    }

    public static void a(Context context, String str) {
        com.xiaomi.channel.commonutils.logger.b.m79a("aw_ping : send aw_ping cmd and content to push service from 3rd app");
        HashMap hashMap = new HashMap();
        hashMap.put("awake_info", str);
        hashMap.put(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, String.valueOf((int) AlaRecorderLog.ErrorCode.ERROR_RECORDER_NOT_DEFINE_ERROR));
        hashMap.put("description", "ping message");
        il ilVar = new il();
        ilVar.b(b.m119a(context).m120a());
        ilVar.d(context.getPackageName());
        ilVar.c(hw.AwakeAppResponse.f555a);
        ilVar.a(com.xiaomi.push.service.an.a());
        ilVar.f696a = hashMap;
        a(context, ilVar);
    }

    public static void a(Context context, String str, int i, String str2) {
        il ilVar = new il();
        ilVar.b(str);
        ilVar.a(new HashMap());
        ilVar.m458a().put("extra_aw_app_online_cmd", String.valueOf(i));
        ilVar.m458a().put("extra_help_aw_info", str2);
        ilVar.a(com.xiaomi.push.service.an.a());
        byte[] a2 = iw.a(ilVar);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m79a("send message fail, because msgBytes is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_aw_app_logic");
        intent.putExtra("mipush_payload", a2);
        aq.a(context).m111a(intent);
    }
}
