package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.pose.PoseAR;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.ai;
import com.xiaomi.push.ea;
import com.xiaomi.push.ec;
import com.xiaomi.push.hk;
import com.xiaomi.push.hp;
import com.xiaomi.push.ie;
import com.xiaomi.push.ip;
import com.xiaomi.push.iq;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, Intent intent, Uri uri) {
        ea a2;
        ec ecVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65536, null, context, intent, uri) == null) || context == null) {
            return;
        }
        an.a(context).m105a();
        if (ea.a(context.getApplicationContext()).m286a() == null) {
            ea.a(context.getApplicationContext()).a(b.m114a(context.getApplicationContext()).m115a(), context.getPackageName(), com.xiaomi.push.service.aq.a(context.getApplicationContext()).a(hk.aF.a(), 0), new c());
            com.xiaomi.push.service.aq.a(context).a(new q(102, "awake online config", context));
        }
        if ((context instanceof Activity) && intent != null) {
            a2 = ea.a(context.getApplicationContext());
            ecVar = ec.f77383a;
        } else if (!(context instanceof Service) || intent == null) {
            if (uri == null || TextUtils.isEmpty(uri.toString())) {
                return;
            }
            ea.a(context.getApplicationContext()).a(ec.f77386d, context, (Intent) null, uri.toString());
            return;
        } else if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
            a2 = ea.a(context.getApplicationContext());
            ecVar = ec.f77385c;
        } else {
            a2 = ea.a(context.getApplicationContext());
            ecVar = ec.f77384b;
        }
        a2.a(ecVar, context, intent, (String) null);
    }

    public static void a(Context context, ie ieVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, ieVar) == null) {
            boolean a2 = com.xiaomi.push.service.aq.a(context).a(hk.aG.a(), false);
            int a3 = com.xiaomi.push.service.aq.a(context).a(hk.aH.a(), 0);
            if (a3 >= 0 && a3 < 30) {
                com.xiaomi.channel.commonutils.logger.b.c("aw_ping: frquency need > 30s.");
                a3 = 30;
            }
            boolean z = a3 >= 0 ? a2 : false;
            if (!com.xiaomi.push.l.m538a()) {
                a(context, ieVar, z, a3);
            } else if (z) {
                com.xiaomi.push.ai.a(context.getApplicationContext()).a((ai.a) new p(ieVar, context), a3);
            }
        }
    }

    public static final <T extends iq<T, ?>> void a(Context context, T t, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, t, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            byte[] a2 = ip.a(t);
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.m73a("send message fail, because msgBytes is null.");
                return;
            }
            Intent intent = new Intent();
            intent.setAction("action_help_ping");
            intent.putExtra("extra_help_ping_switch", z);
            intent.putExtra("extra_help_ping_frequency", i2);
            intent.putExtra("mipush_payload", a2);
            intent.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
            an.a(context).m106a(intent);
        }
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, str) == null) {
            com.xiaomi.channel.commonutils.logger.b.m73a("aw_ping : send aw_ping cmd and content to push service from 3rd app");
            HashMap hashMap = new HashMap();
            hashMap.put("awake_info", str);
            hashMap.put(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, String.valueOf(9999));
            hashMap.put("description", "ping message");
            ie ieVar = new ie();
            ieVar.b(b.m114a(context).m115a());
            ieVar.d(context.getPackageName());
            ieVar.c(hp.I.f513a);
            ieVar.a(com.xiaomi.push.service.at.a());
            ieVar.f654a = hashMap;
            a(context, ieVar);
        }
    }

    public static void a(Context context, String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, i2, str2) == null) {
            ie ieVar = new ie();
            ieVar.b(str);
            ieVar.a(new HashMap());
            ieVar.m469a().put("extra_aw_app_online_cmd", String.valueOf(i2));
            ieVar.m469a().put("extra_help_aw_info", str2);
            ieVar.a(com.xiaomi.push.service.at.a());
            byte[] a2 = ip.a(ieVar);
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.m73a("send message fail, because msgBytes is null.");
                return;
            }
            Intent intent = new Intent();
            intent.setAction("action_aw_app_logic");
            intent.putExtra("mipush_payload", a2);
            an.a(context).m106a(intent);
        }
    }
}
