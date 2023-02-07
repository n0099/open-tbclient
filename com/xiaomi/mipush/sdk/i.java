package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bj;
import com.xiaomi.push.bk;
import com.xiaomi.push.bo;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
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
        a = new HashMap<>();
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            Integer num = (Integer) bk.a("com.xiaomi.assemble.control.AssembleConstants", "ASSEMBLE_VERSION_CODE");
            if (num == null) {
                return 0;
            }
            return num.intValue();
        }
        return invokeV.intValue;
    }

    public static int a(Context context, e eVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, eVar, str)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            String a2 = a(eVar);
            String string = sharedPreferences.getString(a2, "");
            String m155c = b.m147a(context).m155c();
            String string2 = sharedPreferences.getString("last_check_token", "");
            if (TextUtils.isEmpty(a2)) {
                com.xiaomi.channel.commonutils.logger.b.m105a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                return 0;
            } else if (TextUtils.isEmpty(string)) {
                return 1;
            } else {
                if (string.equals(str)) {
                    if (TextUtils.equals(m155c, string2)) {
                        if (m172a(eVar)) {
                            if (a() != sharedPreferences.getInt(b(eVar), 0)) {
                                return 4;
                            }
                        }
                        return 0;
                    }
                    return 3;
                }
                return 2;
            }
        }
        return invokeLLL.intValue;
    }

    public static MiPushMessage a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
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
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.d(e.toString());
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
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
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
                    return (PushMessageReceiver) com.xiaomi.push.v.a(context, resolveInfo.activityInfo.name).newInstance();
                }
                return null;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d(e.toString());
                return null;
            }
        }
        return (PushMessageReceiver) invokeL.objValue;
    }

    public static String a(Context context, e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, eVar)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            String a2 = a(eVar);
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            return sharedPreferences.getString(a2, "");
        }
        return (String) invokeLL.objValue;
    }

    public static synchronized String a(Context context, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            synchronized (i.class) {
                str2 = a.get(str);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, eVar)) == null) {
            int i = k.a[eVar.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return null;
                        }
                        return "ftos_push_token";
                    }
                    return "cos_push_token";
                }
                return "fcm_push_token_v2";
            }
            return "hms_push_token";
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
        if (r12 != 0) goto L17;
     */
    /* renamed from: a  reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HashMap<String, String> m166a(Context context, e eVar) {
        InterceptResult invokeLL;
        w.a a2;
        int a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, eVar)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            String a4 = a(eVar);
            if (TextUtils.isEmpty(a4)) {
                return hashMap;
            }
            int i = k.a[eVar.ordinal()];
            String str = null;
            ApplicationInfo applicationInfo = null;
            if (i != 1) {
                if (i == 2) {
                    a2 = new w.a(":", Constants.WAVE_SEPARATOR).a(Constants.PHONE_BRAND, ag.c.name()).a("token", a(context, a4)).a("package_name", context.getPackageName());
                    a3 = a();
                    if (a3 == 0) {
                        a3 = 40090;
                    }
                } else if (i == 3) {
                    str = "brand:" + ag.d.name() + Constants.WAVE_SEPARATOR + "token:" + a(context, a4) + Constants.WAVE_SEPARATOR + "package_name:" + context.getPackageName();
                } else if (i == 4) {
                    a2 = new w.a(":", Constants.WAVE_SEPARATOR).a(Constants.PHONE_BRAND, ag.e.name()).a("token", a(context, a4)).a("package_name", context.getPackageName());
                    a3 = a();
                }
                a2.a("version", Integer.valueOf(a3));
                str = a2.toString();
            } else {
                try {
                    applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.d(e.toString());
                }
                str = "brand:" + n.a(context).name() + Constants.WAVE_SEPARATOR + "token:" + a(context, a4) + Constants.WAVE_SEPARATOR + "package_name:" + context.getPackageName() + Constants.WAVE_SEPARATOR + "app_id:" + (applicationInfo != null ? applicationInfo.metaData.getInt(Constants.HUAWEI_HMS_CLIENT_APPID) : -1);
            }
            hashMap.put(Constants.ASSEMBLE_PUSH_REG_INFO, str);
            return hashMap;
        }
        return (HashMap) invokeLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m167a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, context) == null) {
            boolean z = false;
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            String a2 = a(e.a);
            String a3 = a(e.b);
            if (!TextUtils.isEmpty(sharedPreferences.getString(a2, "")) && TextUtils.isEmpty(sharedPreferences.getString(a3, ""))) {
                z = true;
            }
            if (z) {
                ao.a(context).a(2, a2);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m168a(Context context, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, context, eVar) == null) {
            String a2 = a(eVar);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            com.xiaomi.push.t.a(context.getSharedPreferences("mipush_extra", 0).edit().putString(a2, ""));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m169a(Context context, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65547, null, context, eVar, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        int a2 = a(context, eVar, str);
        if (a2 == 0) {
            com.xiaomi.channel.commonutils.logger.b.m105a("ASSEMBLE_PUSH : do not need to send token");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m105a("ASSEMBLE_PUSH : send token upload, check:" + a2);
        a(eVar, str);
        au a3 = l.a(eVar);
        if (a3 == null) {
            return;
        }
        ao.a(context).a((String) null, a3, eVar);
    }

    public static void a(Intent intent) {
        Bundle extras;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, intent) == null) || intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("pushMsg")) {
            return;
        }
        intent.putExtra(PushMessageHelper.KEY_MESSAGE, a(extras.getString("pushMsg")));
    }

    public static synchronized void a(e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, eVar, str) == null) {
            synchronized (i.class) {
                String a2 = a(eVar);
                if (TextUtils.isEmpty(a2)) {
                    com.xiaomi.channel.commonutils.logger.b.m105a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                } else if (TextUtils.isEmpty(str)) {
                    com.xiaomi.channel.commonutils.logger.b.m105a("ASSEMBLE_PUSH : token is null");
                } else {
                    a.put(a2, str);
                }
            }
        }
    }

    public static void a(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, str, i) == null) {
            MiTinyDataClient.upload("hms_push_error", str, 1L, "error code = " + i);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m170a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            if (context == null) {
                return false;
            }
            return bj.b(context);
        }
        return invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m171a(Context context, e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, context, eVar)) == null) {
            if (l.m174a(eVar) != null) {
                return ba.a(context).a(l.m174a(eVar).a(), true);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m172a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, eVar)) == null) ? eVar == e.d || eVar == e.b : invokeL.booleanValue;
    }

    public static boolean a(Cif cif, e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, cif, eVar)) == null) {
            if (cif == null || cif.m540a() == null || cif.m540a().m507a() == null) {
                return false;
            }
            return (eVar == e.b ? "FCM" : "").equalsIgnoreCase(cif.m540a().m507a().get("assemble_push_type"));
        }
        return invokeLL.booleanValue;
    }

    public static byte[] a(Context context, Cif cif, e eVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65555, null, context, cif, eVar)) == null) {
            if (a(cif, eVar)) {
                return bo.m220a(a(context, eVar));
            }
            return null;
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static String b(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, eVar)) == null) {
            return a(eVar) + "_version";
        }
        return (String) invokeL.objValue;
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, context) == null) {
            f.a(context).register();
        }
    }

    public static void b(Context context, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65558, null, context, eVar, str) == null) {
            com.xiaomi.push.al.a(context).a(new j(str, context, eVar));
        }
    }

    public static String c(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, eVar)) == null) {
            int i = k.a[eVar.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
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

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, context) == null) {
            f.a(context).unregister();
        }
    }

    public static synchronized void d(Context context, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65562, null, context, eVar, str) == null) {
            synchronized (i.class) {
                String a2 = a(eVar);
                if (TextUtils.isEmpty(a2)) {
                    com.xiaomi.channel.commonutils.logger.b.m105a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                    return;
                }
                SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
                edit.putString(a2, str).putString("last_check_token", b.m147a(context).m155c());
                if (m172a(eVar)) {
                    edit.putInt(b(eVar), a());
                }
                com.xiaomi.push.t.a(edit);
                com.xiaomi.channel.commonutils.logger.b.m105a("ASSEMBLE_PUSH : update sp file success!  " + str);
            }
        }
    }
}
