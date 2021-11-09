package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes2.dex */
public class FCMPushHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public FCMPushHelper() {
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

    public static void clearToken(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            i.m134a(context, e.f70622b);
        }
    }

    public static void convertMessage(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, intent) == null) {
            i.a(intent);
        }
    }

    public static boolean isFCMSwitchOpen(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? i.m136a(context, e.f70622b) && MiPushClient.getOpenFCMPush(context) : invokeL.booleanValue;
    }

    public static void notifyFCMNotificationCome(Context context, Map<String, String> map) {
        PushMessageReceiver a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, map) == null) {
            String str = map.get("pushMsg");
            if (TextUtils.isEmpty(str) || (a2 = i.a(context)) == null) {
                return;
            }
            a2.onNotificationMessageArrived(context, i.a(str));
        }
    }

    public static void notifyFCMPassThoughMessageCome(Context context, Map<String, String> map) {
        PushMessageReceiver a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, map) == null) {
            String str = map.get("pushMsg");
            if (TextUtils.isEmpty(str) || (a2 = i.a(context)) == null) {
                return;
            }
            a2.onReceivePassThroughMessage(context, i.a(str));
        }
    }

    public static void reportFCMMessageDelete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            MiTinyDataClient.upload(i.b(e.f70622b), "fcm", 1L, "some fcm messages was deleted ");
        }
    }

    public static void uploadToken(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, str) == null) {
            i.a(context, e.f70622b, str);
        }
    }
}
