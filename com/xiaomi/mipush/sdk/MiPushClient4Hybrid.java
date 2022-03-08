package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bm;
import com.xiaomi.push.ev;
import com.xiaomi.push.g;
import com.xiaomi.push.hf;
import com.xiaomi.push.hp;
import com.xiaomi.push.hs;
import com.xiaomi.push.ht;
import com.xiaomi.push.hv;
import com.xiaomi.push.ie;
import com.xiaomi.push.ig;
import com.xiaomi.push.il;
import com.xiaomi.push.im;
import com.xiaomi.push.ip;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes8.dex */
public class MiPushClient4Hybrid {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, b.a> dataMap;
    public static MiPushCallback sCallback;
    public static Map<String, Long> sRegisterTimeMap;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class MiPushCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public MiPushCallback() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void onCommandResult(String str, MiPushCommandMessage miPushCommandMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, miPushCommandMessage) == null) {
            }
        }

        public void onReceiveRegisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, miPushCommandMessage) == null) {
            }
        }

        public void onReceiveUnregisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, str, miPushCommandMessage) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1767404672, "Lcom/xiaomi/mipush/sdk/MiPushClient4Hybrid;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1767404672, "Lcom/xiaomi/mipush/sdk/MiPushClient4Hybrid;");
                return;
            }
        }
        dataMap = new HashMap();
        sRegisterTimeMap = new HashMap();
    }

    public MiPushClient4Hybrid() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void addPullNotificationTime(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, str) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            sharedPreferences.edit().putLong("last_pull_notification_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static short getDeviceStatus(MiPushMessage miPushMessage, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, miPushMessage, z)) == null) {
            String str = miPushMessage.getExtra() == null ? "" : miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
            int intValue = TextUtils.isEmpty(str) ? 0 : Integer.valueOf(str).intValue();
            if (!z) {
                intValue = (intValue & (-4)) + g.a.f59662c.a();
            }
            return (short) intValue;
        }
        return invokeLZ.shortValue;
    }

    public static boolean isRegistered(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) ? b.m174a(context).a(str) != null : invokeLL.booleanValue;
    }

    public static void onReceiveRegisterResult(Context context, ig igVar) {
        b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, igVar) == null) {
            String b2 = igVar.b();
            if (igVar.a() == 0 && (aVar = dataMap.get(b2)) != null) {
                aVar.a(igVar.f709e, igVar.f710f);
                b.m174a(context).a(b2, aVar);
            }
            ArrayList arrayList = null;
            if (!TextUtils.isEmpty(igVar.f709e)) {
                arrayList = new ArrayList();
                arrayList.add(igVar.f709e);
            }
            MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ev.a.f345a, arrayList, igVar.f699a, igVar.f708d, null);
            MiPushCallback miPushCallback = sCallback;
            if (miPushCallback != null) {
                miPushCallback.onReceiveRegisterResult(b2, generateCommandMessage);
            }
        }
    }

    public static void onReceiveUnregisterResult(Context context, im imVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, context, imVar) == null) {
            MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ev.f59603b.f345a, null, imVar.f775a, imVar.f783d, null);
            String a = imVar.a();
            MiPushCallback miPushCallback = sCallback;
            if (miPushCallback != null) {
                miPushCallback.onReceiveUnregisterResult(a, generateCommandMessage);
            }
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65543, null, context, str, str2, str3) == null) {
            if (b.m174a(context).m179a(str2, str3, str)) {
                ArrayList arrayList = new ArrayList();
                b.a a = b.m174a(context).a(str);
                if (a != null) {
                    arrayList.add(a.f59454c);
                    MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ev.a.f345a, arrayList, 0L, null, null);
                    MiPushCallback miPushCallback = sCallback;
                    if (miPushCallback != null) {
                        miPushCallback.onReceiveRegisterResult(str, generateCommandMessage);
                    }
                }
                if (shouldPullNotification(context, str)) {
                    ie ieVar = new ie();
                    ieVar.b(str2);
                    ieVar.c(hp.f59774j.f514a);
                    ieVar.a(com.xiaomi.push.service.at.a());
                    ieVar.a(false);
                    an.a(context).a(ieVar, hf.f59728i, false, true, null, false, str, str2);
                    com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid pull offline pass through message");
                    addPullNotificationTime(context, str);
                    return;
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - (sRegisterTimeMap.get(str) != null ? sRegisterTimeMap.get(str).longValue() : 0L)) < 5000) {
                com.xiaomi.channel.commonutils.logger.b.m133a("MiPushClient4Hybrid  Could not send register message within 5s repeatedly.");
                return;
            }
            sRegisterTimeMap.put(str, Long.valueOf(currentTimeMillis));
            String a2 = bm.a(6);
            b.a aVar = new b.a(context);
            aVar.c(str2, str3, a2);
            dataMap.put(str, aVar);
            Cif cif = new Cif();
            cif.a(com.xiaomi.push.service.at.a());
            cif.b(str2);
            cif.e(str3);
            cif.d(str);
            cif.f(a2);
            cif.c(com.xiaomi.push.g.m401a(context, context.getPackageName()));
            cif.b(com.xiaomi.push.g.a(context, context.getPackageName()));
            cif.h("3_8_5");
            cif.a(30805);
            cif.a(ht.f59800c);
            if (!com.xiaomi.push.l.d()) {
                String g2 = com.xiaomi.push.i.g(context);
                if (!TextUtils.isEmpty(g2)) {
                    cif.i(bm.a(g2));
                }
            }
            int a3 = com.xiaomi.push.i.a();
            if (a3 >= 0) {
                cif.c(a3);
            }
            ie ieVar2 = new ie();
            ieVar2.c(hp.J.f514a);
            ieVar2.b(b.m174a(context).m175a());
            ieVar2.d(context.getPackageName());
            ieVar2.a(ip.a(cif));
            ieVar2.a(com.xiaomi.push.service.at.a());
            an.a(context).a((an) ieVar2, hf.f59728i, (hs) null);
        }
    }

    public static void removeDuplicateCache(Context context, MiPushMessage miPushMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, miPushMessage) == null) {
            String str = miPushMessage.getExtra() != null ? miPushMessage.getExtra().get("jobkey") : null;
            if (TextUtils.isEmpty(str)) {
                str = miPushMessage.getMessageId();
            }
            al.a(context, str);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public static void reportMessageArrived(Context context, MiPushMessage miPushMessage, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65545, null, context, miPushMessage, z) == null) {
            if (miPushMessage == null || miPushMessage.getExtra() == null) {
                com.xiaomi.channel.commonutils.logger.b.m133a("do not ack message, message is null");
                return;
            }
            try {
                hv hvVar = new hv();
                hvVar.b(b.m174a(context).m175a());
                hvVar.a(miPushMessage.getMessageId());
                hvVar.a(Long.valueOf(miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS)).longValue());
                hvVar.a(getDeviceStatus(miPushMessage, z));
                if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
                    hvVar.c(miPushMessage.getTopic());
                }
                an.a(context).a((an) hvVar, hf.f59725f, false, PushMessageHelper.generateMessage(miPushMessage));
                com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid ack mina message, messageId is " + miPushMessage.getMessageId());
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, context, miPushMessage) == null) {
            MiPushClient.reportMessageClicked(context, miPushMessage);
        }
    }

    public static void setCallback(MiPushCallback miPushCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, miPushCallback) == null) {
            sCallback = miPushCallback;
        }
    }

    public static boolean shouldPullNotification(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, context, str)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            StringBuilder sb = new StringBuilder();
            sb.append("last_pull_notification_");
            sb.append(str);
            return Math.abs(System.currentTimeMillis() - sharedPreferences.getLong(sb.toString(), -1L)) > 300000;
        }
        return invokeLL.booleanValue;
    }

    public static void unregisterPush(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, context, str) == null) {
            sRegisterTimeMap.remove(str);
            b.a a = b.m174a(context).a(str);
            if (a == null) {
                return;
            }
            il ilVar = new il();
            ilVar.a(com.xiaomi.push.service.at.a());
            ilVar.d(str);
            ilVar.b(a.f89a);
            ilVar.c(a.f59454c);
            ilVar.e(a.f59453b);
            ie ieVar = new ie();
            ieVar.c(hp.L.f514a);
            ieVar.b(b.m174a(context).m175a());
            ieVar.d(context.getPackageName());
            ieVar.a(ip.a(ilVar));
            ieVar.a(com.xiaomi.push.service.at.a());
            an.a(context).a((an) ieVar, hf.f59728i, (hs) null);
            b.m174a(context).b(str);
        }
    }

    public static void uploadClearMessageData(Context context, LinkedList<? extends Object> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, linkedList) == null) {
            com.xiaomi.push.service.ac.a(context, linkedList);
        }
    }
}
