package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes6.dex */
public class FTOSPushHelper {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static long f40023a;

    /* renamed from: a  reason: collision with other field name */
    public static volatile boolean f45a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1127311731, "Lcom/xiaomi/mipush/sdk/FTOSPushHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1127311731, "Lcom/xiaomi/mipush/sdk/FTOSPushHelper;");
        }
    }

    public FTOSPushHelper() {
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

    public static void a(Context context) {
        AbstractPushManager a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, context) == null) || (a2 = f.a(context).a(e.f40076d)) == null) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m70a("ASSEMBLE_PUSH :  register fun touch os when network change!");
        a2.register();
    }

    public static void doInNetworkChange(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (getNeedRegister()) {
                long j = f40023a;
                if (j <= 0 || j + 300000 <= elapsedRealtime) {
                    f40023a = elapsedRealtime;
                    a(context);
                }
            }
        }
    }

    public static boolean getNeedRegister() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f45a : invokeV.booleanValue;
    }

    public static boolean hasNetwork(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? i.m132a(context) : invokeL.booleanValue;
    }

    public static void notifyFTOSNotificationClicked(Context context, Map<String, String> map) {
        PushMessageReceiver a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, map) == null) && map != null && map.containsKey("pushMsg")) {
            String str = map.get("pushMsg");
            if (TextUtils.isEmpty(str) || (a2 = i.a(context)) == null) {
                return;
            }
            MiPushMessage a3 = i.a(str);
            if (a3.getExtra().containsKey("notify_effect")) {
                return;
            }
            a2.onNotificationMessageClicked(context, a3);
        }
    }

    public static void setNeedRegister(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, null, z) == null) {
            f45a = z;
        }
    }

    public static void uploadToken(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, str) == null) {
            i.a(context, e.f40076d, str);
        }
    }
}
