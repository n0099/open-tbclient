package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.bg;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, String> f77132a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(78186022, "Lcom/xiaomi/mipush/sdk/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(78186022, "Lcom/xiaomi/mipush/sdk/i;");
                return;
            }
        }
        f77132a = new HashMap<>();
    }

    public static MiPushMessage a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            MiPushMessage miPushMessage = new MiPushMessage();
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has(MiPushMessage.KEY_MESSAGE_ID)) {
                        miPushMessage.setMessageId(jSONObject.getString(MiPushMessage.KEY_MESSAGE_ID));
                    }
                    if (jSONObject.has("description")) {
                        miPushMessage.setDescription(jSONObject.getString("description"));
                    }
                    if (jSONObject.has("title")) {
                        miPushMessage.setTitle(jSONObject.getString("title"));
                    }
                    if (jSONObject.has("content")) {
                        miPushMessage.setContent(jSONObject.getString("content"));
                    }
                    if (jSONObject.has(MiPushMessage.KEY_PASS_THROUGH)) {
                        miPushMessage.setPassThrough(jSONObject.getInt(MiPushMessage.KEY_PASS_THROUGH));
                    }
                    if (jSONObject.has(MiPushMessage.KEY_NOTIFY_TYPE)) {
                        miPushMessage.setNotifyType(jSONObject.getInt(MiPushMessage.KEY_NOTIFY_TYPE));
                    }
                    if (jSONObject.has("messageType")) {
                        miPushMessage.setMessageType(jSONObject.getInt("messageType"));
                    }
                    if (jSONObject.has("alias")) {
                        miPushMessage.setAlias(jSONObject.getString("alias"));
                    }
                    if (jSONObject.has("topic")) {
                        miPushMessage.setTopic(jSONObject.getString("topic"));
                    }
                    if (jSONObject.has(MiPushMessage.KEY_USER_ACCOUNT)) {
                        miPushMessage.setUserAccount(jSONObject.getString(MiPushMessage.KEY_USER_ACCOUNT));
                    }
                    if (jSONObject.has(MiPushMessage.KEY_NOTIFY_ID)) {
                        miPushMessage.setNotifyId(jSONObject.getInt(MiPushMessage.KEY_NOTIFY_ID));
                    }
                    if (jSONObject.has("category")) {
                        miPushMessage.setCategory(jSONObject.getString("category"));
                    }
                    if (jSONObject.has(MiPushMessage.KEY_NOTIFIED)) {
                        miPushMessage.setNotified(jSONObject.getBoolean(MiPushMessage.KEY_NOTIFIED));
                    }
                    if (jSONObject.has("extra")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("extra");
                        Iterator<String> keys = jSONObject2.keys();
                        HashMap hashMap = new HashMap();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            hashMap.put(next, jSONObject2.getString(next));
                        }
                        if (hashMap.size() > 0) {
                            miPushMessage.setExtra(hashMap);
                        }
                    }
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.d(e2.toString());
                }
            }
            return miPushMessage;
        }
        return (MiPushMessage) invokeL.objValue;
    }

    public static PushMessageReceiver a(Context context) {
        InterceptResult invokeL;
        ResolveInfo resolveInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent.setPackage(context.getPackageName());
            try {
                List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
                if (queryBroadcastReceivers != null) {
                    Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
                    while (it.hasNext()) {
                        resolveInfo = it.next();
                        if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.packageName.equals(context.getPackageName())) {
                            break;
                        }
                    }
                }
                resolveInfo = null;
                if (resolveInfo != null) {
                    return (PushMessageReceiver) com.xiaomi.push.t.a(context, resolveInfo.activityInfo.name).newInstance();
                }
                return null;
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d(e2.toString());
                return null;
            }
        }
        return (PushMessageReceiver) invokeL.objValue;
    }

    public static synchronized String a(Context context, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            synchronized (i.class) {
                str2 = f77132a.get(str);
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public static String a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, eVar)) == null) {
            int i2 = k.f77134a[eVar.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return null;
                        }
                        return "ftos_push_token";
                    }
                    return "cos_push_token";
                }
                return "fcm_push_token";
            }
            return "hms_push_token";
        }
        return (String) invokeL.objValue;
    }

    public static HashMap<String, String> a(Context context, e eVar) {
        InterceptResult invokeLL;
        StringBuilder sb;
        af afVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, eVar)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            String a2 = a(eVar);
            if (TextUtils.isEmpty(a2)) {
                return hashMap;
            }
            int i2 = k.f77134a[eVar.ordinal()];
            String str = null;
            ApplicationInfo applicationInfo = null;
            if (i2 != 1) {
                if (i2 == 2) {
                    sb = new StringBuilder();
                    sb.append("brand:");
                    afVar = af.f77092c;
                } else if (i2 == 3) {
                    sb = new StringBuilder();
                    sb.append("brand:");
                    afVar = af.f77093d;
                } else if (i2 == 4) {
                    sb = new StringBuilder();
                    sb.append("brand:");
                    afVar = af.f77094e;
                }
                sb.append(afVar.name());
                sb.append(Constants.WAVE_SEPARATOR);
                sb.append("token");
                sb.append(":");
                sb.append(a(context, a2));
                sb.append(Constants.WAVE_SEPARATOR);
                sb.append("package_name");
                sb.append(":");
                sb.append(context.getPackageName());
                str = sb.toString();
            } else {
                try {
                    applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.d(e2.toString());
                }
                str = "brand:" + n.a(context).name() + Constants.WAVE_SEPARATOR + "token:" + a(context, a2) + Constants.WAVE_SEPARATOR + "package_name:" + context.getPackageName() + Constants.WAVE_SEPARATOR + "app_id:" + (applicationInfo != null ? applicationInfo.metaData.getInt(Constants.HUAWEI_HMS_CLIENT_APPID) : -1);
            }
            hashMap.put(Constants.ASSEMBLE_PUSH_REG_INFO, str);
            return hashMap;
        }
        return (HashMap) invokeLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m133a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context) == null) {
            boolean z = false;
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            String a2 = a(e.f77125a);
            String a3 = a(e.f77126b);
            if (!TextUtils.isEmpty(sharedPreferences.getString(a2, "")) && TextUtils.isEmpty(sharedPreferences.getString(a3, ""))) {
                z = true;
            }
            if (z) {
                an.a(context).a(2, a2);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m134a(Context context, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, eVar) == null) {
            String a2 = a(eVar);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            com.xiaomi.push.r.a(context.getSharedPreferences("mipush_extra", 0).edit().putString(a2, ""));
        }
    }

    public static void a(Context context, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65544, null, context, eVar, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a2 = a(eVar);
        if (TextUtils.isEmpty(a2)) {
            com.xiaomi.channel.commonutils.logger.b.m73a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            return;
        }
        String string = sharedPreferences.getString(a2, "");
        if (!TextUtils.isEmpty(string) && str.equals(string)) {
            com.xiaomi.channel.commonutils.logger.b.m73a("ASSEMBLE_PUSH : do not need to send token");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m73a("ASSEMBLE_PUSH : send token upload");
        a(eVar, str);
        at a3 = l.a(eVar);
        if (a3 == null) {
            return;
        }
        an.a(context).a((String) null, a3, eVar);
    }

    public static void a(Intent intent) {
        Bundle extras;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, intent) == null) || intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("pushMsg")) {
            return;
        }
        intent.putExtra(PushMessageHelper.KEY_MESSAGE, a(extras.getString("pushMsg")));
    }

    public static synchronized void a(e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, eVar, str) == null) {
            synchronized (i.class) {
                String a2 = a(eVar);
                if (TextUtils.isEmpty(a2)) {
                    com.xiaomi.channel.commonutils.logger.b.m73a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                } else if (TextUtils.isEmpty(str)) {
                    com.xiaomi.channel.commonutils.logger.b.m73a("ASSEMBLE_PUSH : token is null");
                } else {
                    f77132a.put(a2, str);
                }
            }
        }
    }

    public static void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, null, str, i2) == null) {
            MiTinyDataClient.upload("hms_push_error", str, 1L, "error code = " + i2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m135a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            if (context == null) {
                return false;
            }
            return bg.b(context);
        }
        return invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m136a(Context context, e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, eVar)) == null) {
            if (l.m138a(eVar) != null) {
                return com.xiaomi.push.service.aq.a(context).a(l.m138a(eVar).a(), true);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static String b(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, eVar)) == null) {
            int i2 = k.f77134a[eVar.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return null;
                        }
                        return "ftos_push_error";
                    }
                    return "cos_push_error";
                }
                return "fcm_push_error";
            }
            return "hms_push_error";
        }
        return (String) invokeL.objValue;
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, context) == null) {
            f.a(context).register();
        }
    }

    public static void b(Context context, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, context, eVar, str) == null) {
            com.xiaomi.push.ai.a(context).a(new j(str, context, eVar));
        }
    }

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, context) == null) {
            f.a(context).unregister();
        }
    }

    public static synchronized void d(Context context, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65555, null, context, eVar, str) == null) {
            synchronized (i.class) {
                String a2 = a(eVar);
                if (TextUtils.isEmpty(a2)) {
                    com.xiaomi.channel.commonutils.logger.b.m73a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                    return;
                }
                com.xiaomi.push.r.a(context.getSharedPreferences("mipush_extra", 0).edit().putString(a2, str));
                com.xiaomi.channel.commonutils.logger.b.m73a("ASSEMBLE_PUSH : update sp file success!  " + str);
            }
        }
    }
}
