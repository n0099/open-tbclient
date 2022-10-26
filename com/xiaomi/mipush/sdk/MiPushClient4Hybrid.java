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
import com.xiaomi.push.bp;
import com.xiaomi.push.ey;
import com.xiaomi.push.h;
import com.xiaomi.push.hj;
import com.xiaomi.push.ht;
import com.xiaomi.push.hw;
import com.xiaomi.push.hx;
import com.xiaomi.push.hz;
import com.xiaomi.push.ii;
import com.xiaomi.push.ij;
import com.xiaomi.push.ik;
import com.xiaomi.push.ip;
import com.xiaomi.push.iq;
import com.xiaomi.push.it;
import com.xiaomi.push.iu;
import com.xiaomi.push.service.bd;
import com.xiaomi.push.service.br;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes8.dex */
public class MiPushClient4Hybrid {
    public static /* synthetic */ Interceptable $ic;
    public static Map dataMap;
    public static MiPushCallback sCallback;
    public static Map sRegisterTimeMap;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class MiPushCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public MiPushCallback() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            String str = miPushMessage.getExtra() == null ? "" : (String) miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
            int intValue = TextUtils.isEmpty(str) ? 0 : Integer.valueOf(str).intValue();
            if (!z) {
                intValue = (intValue & (-4)) + h.a.c.a();
            }
            return (short) intValue;
        }
        return invokeLZ.shortValue;
    }

    public static boolean isRegistered(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) ? b.m131a(context).a(str) != null : invokeLL.booleanValue;
    }

    public static void onReceiveRegisterResult(Context context, ik ikVar) {
        b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, ikVar) == null) {
            String c = ikVar.c();
            if (ikVar.a() == 0 && (aVar = (b.a) dataMap.get(c)) != null) {
                aVar.a(ikVar.f701e, ikVar.f702f);
                b.m131a(context).a(c, aVar);
            }
            ArrayList arrayList = null;
            if (!TextUtils.isEmpty(ikVar.f701e)) {
                arrayList = new ArrayList();
                arrayList.add(ikVar.f701e);
            }
            MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ey.a.f334a, arrayList, ikVar.f689a, ikVar.f700d, null, null);
            MiPushCallback miPushCallback = sCallback;
            if (miPushCallback != null) {
                miPushCallback.onReceiveRegisterResult(c, generateCommandMessage);
            }
        }
    }

    public static void onReceiveUnregisterResult(Context context, iq iqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, context, iqVar) == null) {
            MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ey.b.f334a, null, iqVar.f767a, iqVar.f775d, null, null);
            String a = iqVar.a();
            MiPushCallback miPushCallback = sCallback;
            if (miPushCallback != null) {
                miPushCallback.onReceiveUnregisterResult(a, generateCommandMessage);
            }
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65543, null, context, str, str2, str3) == null) {
            if (b.m131a(context).m136a(str2, str3, str)) {
                ArrayList arrayList = new ArrayList();
                b.a a = b.m131a(context).a(str);
                if (a != null) {
                    arrayList.add(a.c);
                    MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ey.a.f334a, arrayList, 0L, null, null, null);
                    MiPushCallback miPushCallback = sCallback;
                    if (miPushCallback != null) {
                        miPushCallback.onReceiveRegisterResult(str, generateCommandMessage);
                    }
                }
                if (shouldPullNotification(context, str)) {
                    ii iiVar = new ii();
                    iiVar.b(str2);
                    iiVar.c(ht.j.f506a);
                    iiVar.a(bd.a());
                    iiVar.a(false);
                    ao.a(context).a(iiVar, hj.i, false, true, null, false, str, str2);
                    com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid pull offline pass through message");
                    addPullNotificationTime(context, str);
                    return;
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - (sRegisterTimeMap.get(str) != null ? ((Long) sRegisterTimeMap.get(str)).longValue() : 0L)) < 5000) {
                com.xiaomi.channel.commonutils.logger.b.m89a("MiPushClient4Hybrid  Could not send register message within 5s repeatedly.");
                return;
            }
            sRegisterTimeMap.put(str, Long.valueOf(currentTimeMillis));
            String a2 = bp.a(6);
            b.a aVar = new b.a(context);
            aVar.c(str2, str3, a2);
            dataMap.put(str, aVar);
            ij ijVar = new ij();
            ijVar.a(bd.a());
            ijVar.b(str2);
            ijVar.e(str3);
            ijVar.d(str);
            ijVar.f(a2);
            ijVar.c(com.xiaomi.push.h.m384a(context, context.getPackageName()));
            ijVar.b(com.xiaomi.push.h.a(context, context.getPackageName()));
            ijVar.h("4_9_0");
            ijVar.a(40090);
            ijVar.a(hx.c);
            if (!com.xiaomi.push.m.m566d()) {
                String e = com.xiaomi.push.j.e(context);
                if (!TextUtils.isEmpty(e)) {
                    ijVar.i(bp.a(e));
                }
            }
            int a3 = com.xiaomi.push.j.a();
            if (a3 >= 0) {
                ijVar.c(a3);
            }
            ii iiVar2 = new ii();
            iiVar2.c(ht.J.f506a);
            iiVar2.b(b.m131a(context).m132a());
            iiVar2.d(context.getPackageName());
            iiVar2.a(it.a(ijVar));
            iiVar2.a(bd.a());
            ao.a(context).a(iiVar2, hj.i, (hw) null);
        }
    }

    public static void removeDuplicateCache(Context context, MiPushMessage miPushMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, miPushMessage) == null) {
            String str = miPushMessage.getExtra() != null ? (String) miPushMessage.getExtra().get("jobkey") : null;
            if (TextUtils.isEmpty(str)) {
                str = miPushMessage.getMessageId();
            }
            am.a(context, str);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public static void reportMessageArrived(Context context, MiPushMessage miPushMessage, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65545, null, context, miPushMessage, z) == null) {
            if (miPushMessage == null || miPushMessage.getExtra() == null) {
                com.xiaomi.channel.commonutils.logger.b.m89a("do not ack message, message is null");
                return;
            }
            try {
                hz hzVar = new hz();
                hzVar.b(b.m131a(context).m132a());
                hzVar.a(miPushMessage.getMessageId());
                hzVar.a(Long.valueOf((String) miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS)).longValue());
                hzVar.a(getDeviceStatus(miPushMessage, z));
                if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
                    hzVar.c(miPushMessage.getTopic());
                }
                ao.a(context).a((iu) hzVar, hj.f, false, br.a(PushMessageHelper.generateMessage(miPushMessage)));
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
            b.a a = b.m131a(context).a(str);
            if (a == null) {
                return;
            }
            ip ipVar = new ip();
            ipVar.a(bd.a());
            ipVar.d(str);
            ipVar.b(a.f74a);
            ipVar.c(a.c);
            ipVar.e(a.b);
            ii iiVar = new ii();
            iiVar.c(ht.L.f506a);
            iiVar.b(b.m131a(context).m132a());
            iiVar.d(context.getPackageName());
            iiVar.a(it.a(ipVar));
            iiVar.a(bd.a());
            ao.a(context).a(iiVar, hj.i, (hw) null);
            b.m131a(context).b(str);
        }
    }

    public static void uploadClearMessageData(Context context, LinkedList linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, linkedList) == null) {
            com.xiaomi.push.service.al.a(context, linkedList);
        }
    }
}
