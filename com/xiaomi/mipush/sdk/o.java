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
import com.xiaomi.push.al;
import com.xiaomi.push.ed;
import com.xiaomi.push.ef;
import com.xiaomi.push.ho;
import com.xiaomi.push.ht;
import com.xiaomi.push.ii;
import com.xiaomi.push.it;
import com.xiaomi.push.iu;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.bd;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, Intent intent, Uri uri) {
        ed a;
        ef efVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65536, null, context, intent, uri) == null) || context == null) {
            return;
        }
        ao.a(context).m132a();
        if (ed.a(context.getApplicationContext()).m316a() == null) {
            ed.a(context.getApplicationContext()).a(b.m141a(context.getApplicationContext()).m142a(), context.getPackageName(), ba.a(context.getApplicationContext()).a(ho.aF.a(), 0), new c());
            ba.a(context).a(new q(102, "awake online config", context));
        }
        if ((context instanceof Activity) && intent != null) {
            a = ed.a(context.getApplicationContext());
            efVar = ef.a;
        } else if (!(context instanceof Service) || intent == null) {
            if (uri == null || TextUtils.isEmpty(uri.toString())) {
                return;
            }
            ed.a(context.getApplicationContext()).a(ef.d, context, (Intent) null, uri.toString());
            return;
        } else if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
            a = ed.a(context.getApplicationContext());
            efVar = ef.c;
        } else {
            a = ed.a(context.getApplicationContext());
            efVar = ef.b;
        }
        a.a(efVar, context, intent, (String) null);
    }

    public static void a(Context context, ii iiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, iiVar) == null) {
            boolean a = ba.a(context).a(ho.aG.a(), false);
            int a2 = ba.a(context).a(ho.aH.a(), 0);
            if (a2 >= 0 && a2 < 30) {
                com.xiaomi.channel.commonutils.logger.b.c("aw_ping: frquency need > 30s.");
                a2 = 30;
            }
            boolean z = a2 >= 0 ? a : false;
            if (!com.xiaomi.push.m.m570a()) {
                a(context, iiVar, z, a2);
            } else if (z) {
                com.xiaomi.push.al.a(context.getApplicationContext()).a((al.a) new p(iiVar, context), a2);
            }
        }
    }

    public static final <T extends iu<T, ?>> void a(Context context, T t, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, t, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            byte[] a = it.a(t);
            if (a == null) {
                com.xiaomi.channel.commonutils.logger.b.m99a("send message fail, because msgBytes is null.");
                return;
            }
            Intent intent = new Intent();
            intent.setAction("action_help_ping");
            intent.putExtra("extra_help_ping_switch", z);
            intent.putExtra("extra_help_ping_frequency", i);
            intent.putExtra("mipush_payload", a);
            intent.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
            ao.a(context).m133a(intent);
        }
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, str) == null) {
            com.xiaomi.channel.commonutils.logger.b.m99a("aw_ping : send aw_ping cmd and content to push service from 3rd app");
            HashMap hashMap = new HashMap();
            hashMap.put("awake_info", str);
            hashMap.put(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, String.valueOf(9999));
            hashMap.put("description", "ping message");
            ii iiVar = new ii();
            iiVar.b(b.m141a(context).m142a());
            iiVar.d(context.getPackageName());
            iiVar.c(ht.I.f529a);
            iiVar.a(bd.a());
            iiVar.f668a = hashMap;
            a(context, iiVar);
        }
    }

    public static void a(Context context, String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, i, str2) == null) {
            ii iiVar = new ii();
            iiVar.b(str);
            iiVar.a(new HashMap());
            iiVar.m491a().put("extra_aw_app_online_cmd", String.valueOf(i));
            iiVar.m491a().put("extra_help_aw_info", str2);
            iiVar.a(bd.a());
            byte[] a = it.a(iiVar);
            if (a == null) {
                com.xiaomi.channel.commonutils.logger.b.m99a("send message fail, because msgBytes is null.");
                return;
            }
            Intent intent = new Intent();
            intent.setAction("action_aw_app_logic");
            intent.putExtra("mipush_payload", a);
            ao.a(context).m133a(intent);
        }
    }
}
