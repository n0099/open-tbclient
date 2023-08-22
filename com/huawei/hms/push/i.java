package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.push.utils.PluginUtil;
import com.huawei.hms.support.log.HMSLog;
/* loaded from: classes10.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, context, intent) == null) {
            try {
                if (context != null && intent != null) {
                    String action = intent.getAction();
                    if ("com.huawei.intent.action.PUSH".equals(action) || "com.huawei.push.msg.NOTIFY_MSG".equals(action) || "com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(action)) {
                        byte[] byteArrayExtra = intent.getByteArrayExtra("selfshow_info");
                        byte[] byteArrayExtra2 = intent.getByteArrayExtra("selfshow_token");
                        if (byteArrayExtra != null && byteArrayExtra2 != null && byteArrayExtra.length != 0 && byteArrayExtra2.length != 0) {
                            a(context, intent, byteArrayExtra, byteArrayExtra2);
                            return;
                        }
                        HMSLog.i("PushSelfShowLog", "self show info or token is null.");
                        return;
                    }
                    return;
                }
                HMSLog.d("PushSelfShowLog", "enter SelfShowReceiver receiver, context or intent is null");
            } catch (RuntimeException e) {
                HMSLog.e("PushSelfShowLog", "onReceive RuntimeException.", e);
            } catch (Exception unused) {
                HMSLog.d("PushSelfShowLog", "onReceive Exception.");
            }
        }
    }

    public static void a(Context context, Intent intent, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, intent, kVar) == null) {
            HMSLog.i("PushSelfShowLog", "receive a selfshow message, the cmd type is " + kVar.i());
            if (!j.a(kVar.i())) {
                return;
            }
            long a = q.a(kVar.c());
            if (a == 0) {
                new p(context, kVar).start();
                return;
            }
            HMSLog.d("PushSelfShowLog", "waiting...");
            intent.setPackage(context.getPackageName());
            q.a(context, intent, a);
        }
    }

    public static void a(Context context, Intent intent, String str, k kVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, intent, str, kVar, Integer.valueOf(i)}) == null) {
            HMSLog.d("PushSelfShowLog", "receive a selfshow user handle message eventId = " + str);
            if (!"-1".equals(str)) {
                q.a(context, intent);
            } else {
                q.a(context, i);
            }
            if ("1".equals(str)) {
                new j(context, kVar).c();
                PluginUtil.onNotificationClicked(context, kVar.p(), kVar.b());
            } else if ("2".equals(str)) {
                e.a(context, kVar.p(), kVar.b(), "2");
            } else {
                HMSLog.d("PushSelfShowLog", "other event");
            }
        }
    }

    public static void a(Context context, Intent intent, byte[] bArr, byte[] bArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, context, intent, bArr, bArr2) == null) {
            String stringExtra = intent.getStringExtra("selfshow_event_id");
            int intExtra = intent.getIntExtra("selfshow_notify_id", 0);
            HMSLog.i("PushSelfShowLog", "get notifyId:" + intExtra);
            k kVar = new k(bArr, bArr2);
            if (!kVar.z()) {
                HMSLog.d("PushSelfShowLog", "parseMessage failed");
                return;
            }
            HMSLog.i("PushSelfShowLog", "onReceive the msg id = " + kVar.p() + ",and cmd is " + kVar.i() + ",and the eventId is " + stringExtra);
            if (stringExtra == null) {
                a(context, intent, kVar);
            } else {
                a(context, intent, stringExtra, kVar, intExtra);
            }
        }
    }
}
