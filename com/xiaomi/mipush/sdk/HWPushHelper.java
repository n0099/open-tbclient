package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.task.item.StrictModeTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class HWPushHelper {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f76875a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1660867696, "Lcom/xiaomi/mipush/sdk/HWPushHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1660867696, "Lcom/xiaomi/mipush/sdk/HWPushHelper;");
        }
    }

    public HWPushHelper() {
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

    public static void convertMessage(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, intent) == null) {
            i.a(intent);
        }
    }

    public static boolean hasNetwork(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? i.m135a(context) : invokeL.booleanValue;
    }

    public static boolean isHmsTokenSynced(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            String a2 = i.a(e.f76924a);
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            String a3 = i.a(context, a2);
            String a4 = ae.a(context).a(at.f76910c);
            return (TextUtils.isEmpty(a3) || TextUtils.isEmpty(a4) || !"synced".equals(a4)) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isUserOpenHmsPush(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? MiPushClient.getOpenHmsPush(context) : invokeL.booleanValue;
    }

    public static boolean needConnect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f76875a : invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
        r2 = r3.getString("pushMsg");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void notifyHmsNotificationMessageClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, str) == null) {
            String str2 = "";
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    if (jSONArray.length() > 0) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= jSONArray.length()) {
                                break;
                            }
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            if (jSONObject.has("pushMsg")) {
                                break;
                            }
                            i2++;
                        }
                    }
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.d(e2.toString());
                }
            }
            PushMessageReceiver a2 = i.a(context);
            if (a2 != null) {
                MiPushMessage a3 = i.a(str2);
                if (a3.getExtra().containsKey("notify_effect")) {
                    return;
                }
                a2.onNotificationMessageClicked(context, a3);
            }
        }
    }

    public static void notifyHmsPassThoughMessageArrived(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, str) == null) {
            String str2 = "";
            try {
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("content")) {
                        str2 = jSONObject.getString("content");
                    }
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d(e2.toString());
            }
            PushMessageReceiver a2 = i.a(context);
            if (a2 != null) {
                a2.onReceivePassThroughMessage(context, i.a(str2));
            }
        }
    }

    public static void registerHuaWeiAssemblePush(Context context) {
        AbstractPushManager a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, context) == null) || (a2 = f.a(context).a(e.f76924a)) == null) {
            return;
        }
        a2.register();
    }

    public static void reportError(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65546, null, str, i2) == null) {
            i.a(str, i2);
        }
    }

    public static synchronized void setConnectTime(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            synchronized (HWPushHelper.class) {
                context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_connect_time", System.currentTimeMillis()).commit();
            }
        }
    }

    public static synchronized void setGetTokenTime(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, context) == null) {
            synchronized (HWPushHelper.class) {
                context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_get_token_time", System.currentTimeMillis()).commit();
            }
        }
    }

    public static void setNeedConnect(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65549, null, z) == null) {
            f76875a = z;
        }
    }

    public static synchronized boolean shouldGetToken(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            synchronized (HWPushHelper.class) {
                z = Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_get_token_time", -1L)) > StrictModeTask.CLEAN_FILE_INTERVAL;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static synchronized boolean shouldTryConnect(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            synchronized (HWPushHelper.class) {
                z = Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_connect_time", -1L)) > 5000;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static void uploadToken(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, context, str) == null) {
            i.a(context, e.f76924a, str);
        }
    }
}
