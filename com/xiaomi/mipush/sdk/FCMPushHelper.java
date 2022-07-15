package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hj;
import com.xiaomi.push.im;
import com.xiaomi.push.it;
import com.xiaomi.push.service.bk;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class FCMPushHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public FCMPushHelper() {
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

    public static Map<String, String> a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("actionType", String.valueOf(hj.f.a()));
            hashMap.put("deviceStatus", String.valueOf((int) it.a(context, context.getPackageName())));
            hashMap.put("mat", Long.toString(System.currentTimeMillis()));
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static void a(Context context, Cif cif) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, cif) == null) {
            try {
                MiPushMessage generateMessage = PushMessageHelper.generateMessage((im) ai.a(context, cif), cif.m1403a(), false);
                PushMessageReceiver a = i.a(context);
                if (a != null) {
                    a.onNotificationMessageArrived(context, generateMessage);
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a("fcm broadcast notification come error ", th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, byte[] bArr) {
        String format;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65539, null, context, bArr) != null) {
            return;
        }
        boolean m1062a = ao.a(context).m1062a();
        boolean z = true;
        boolean z2 = !"com.xiaomi.xmsf".equals(context.getPackageName());
        boolean m1040a = m1040a(context);
        boolean z3 = false;
        if (m1062a && z2 && m1040a) {
            bArr = com.xiaomi.push.service.n.a(bArr, b.m1069a(context).d());
            if (bArr != null) {
                String encodeToString = Base64.encodeToString(bArr, 2);
                if (TextUtils.isEmpty(encodeToString)) {
                    com.xiaomi.channel.commonutils.logger.b.m1027a("fcm message buf base64 encode failed");
                    z = false;
                } else {
                    Intent intent = new Intent(bk.n);
                    intent.setPackage("com.xiaomi.xmsf");
                    intent.setClassName("com.xiaomi.xmsf", "com.xiaomi.push.service.XMPushService");
                    intent.putExtra("ext_fcm_container_buffer", encodeToString);
                    intent.putExtra("mipush_app_package", context.getPackageName());
                    context.startService(intent);
                    com.xiaomi.channel.commonutils.logger.b.m1027a("fcm message reroute to xmsf");
                }
                z3 = z;
                if (z3) {
                    com.xiaomi.channel.commonutils.logger.b.b("fcm message post local");
                    com.xiaomi.push.service.al.m1543a(context, com.xiaomi.push.service.y.a(bArr), bArr);
                    return;
                }
                return;
            }
            format = "fcm message encrypt failed";
        } else {
            format = String.format("xmsf can not receive fcm msg - shouldUseMIUIPush=%s;isNotXmsf=%s;xmsfSupport=%s", Boolean.valueOf(m1062a), Boolean.valueOf(z2), Boolean.valueOf(m1040a));
        }
        com.xiaomi.channel.commonutils.logger.b.m1027a(format);
        if (z3) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m1040a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? ((long) com.xiaomi.push.m.b(context)) >= 50002000 && b(context) : invokeL.booleanValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? context.getSharedPreferences("mipush_extra", 0).getBoolean("is_xmsf_sup_decrypt", false) : invokeL.booleanValue;
    }

    public static void clearToken(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            i.m1090a(context, e.b);
        }
    }

    public static void convertMessage(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, intent) == null) {
            i.a(intent);
        }
    }

    public static boolean isFCMSwitchOpen(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? i.m1093a(context, e.b) && MiPushClient.getOpenFCMPush(context) : invokeL.booleanValue;
    }

    public static void notifyFCMNotificationCome(Context context, Map<String, String> map) {
        PushMessageReceiver a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, map) == null) {
            String str = map.get("pushMsg");
            if (TextUtils.isEmpty(str) || (a = i.a(context)) == null) {
                return;
            }
            a.onNotificationMessageArrived(context, i.a(str));
        }
    }

    public static Map<String, String> notifyFCMPassThoughMessageCome(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        PushMessageReceiver a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, map)) == null) {
            String str = map.get("pushMsg");
            if (!TextUtils.isEmpty(str) && (a = i.a(context)) != null) {
                a.onReceivePassThroughMessage(context, i.a(str));
            }
            String str2 = map.get("mipushContainer");
            if (TextUtils.isEmpty(str2)) {
                return new HashMap();
            }
            try {
                byte[] decode = Base64.decode(str2, 2);
                a(context, com.xiaomi.push.service.y.a(decode));
                a(context, decode);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a("fcm notify notification error ", th);
            }
            return a(context);
        }
        return (Map) invokeLL.objValue;
    }

    public static void persistIfXmsfSupDecrypt(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            context.getSharedPreferences("mipush_extra", 0).edit().putBoolean("is_xmsf_sup_decrypt", ((long) com.xiaomi.push.m.b(context)) >= 50002000).apply();
        }
    }

    public static void reportFCMMessageDelete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            MiTinyDataClient.upload(i.c(e.b), "fcm", 1L, "some fcm messages was deleted ");
        }
    }

    public static void uploadToken(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, context, str) == null) {
            i.m1091a(context, e.b, str);
        }
    }
}
