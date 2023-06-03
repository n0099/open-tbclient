package com.huawei.hms.push.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.tbadk.core.data.WorkPostNotifyFlutterData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.e;
import com.huawei.hms.push.h;
import com.huawei.hms.push.i;
import com.huawei.hms.push.u;
import com.huawei.hms.push.x;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class PluginUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PluginUtil() {
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

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.put("data", str);
                jSONObject2.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject);
                return jSONObject2.toString();
            } catch (JSONException unused) {
                HMSLog.e("PluginUtil", "rebuild message failed");
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, str) == null) {
            e.a(context, str, null, WorkPostNotifyFlutterData.FAIL_POST);
        }
    }

    public static void saveNotifySwitch(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65550, null, context, z) == null) {
            new PushPreferences(context, "push_notify_flag").saveBoolean("notify_msg_enable", z);
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, context, str, str2, str3) == null) {
            HMSLog.i("PluginUtil", "onNotification");
            if (!u.a(context)) {
                HMSLog.i("PluginUtil", context.getPackageName() + " disable display notification.");
                e.a(context, str, null, "103");
                return;
            }
            Intent intent = new Intent();
            intent.setAction("com.huawei.push.msg.NOTIFY_MSG");
            intent.putExtra("selfshow_info", str3.getBytes(x.a));
            intent.putExtra("selfshow_token", str2.getBytes(x.a));
            intent.setPackage(context.getPackageName());
            i.a(context, intent);
            HMSLog.i("PluginUtil", "invokeSelfShow done");
        }
    }

    public static boolean onDataMessage(Context context, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{context, str, str2, Boolean.valueOf(z)})) == null) {
            HMSLog.i("PluginUtil", "onDataMessage");
            if (TextUtils.isEmpty(str2)) {
                HMSLog.i("PluginUtil", "Empty message received");
                return true;
            }
            if (z) {
                a(context, str);
            }
            Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
            intent.setPackage(context.getPackageName());
            Bundle bundle = new Bundle();
            bundle.putString("message_id", str);
            bundle.putByteArray(RemoteMessageConst.MSGBODY, str2.getBytes(x.a));
            bundle.putString("message_type", "received_message");
            return new h().a(context, bundle, intent);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean onNewToken(Context context, String str, String str2, ErrorEnum errorEnum) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65546, null, context, str, str2, errorEnum)) == null) {
            HMSLog.i("PluginUtil", "onNewToken called.");
            Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
            intent.setPackage(context.getPackageName());
            Bundle bundle = new Bundle();
            bundle.putInt("error", errorEnum.getInternalCode());
            bundle.putString("message_type", "new_token");
            bundle.putString(RemoteMessageConst.DEVICE_TOKEN, str);
            if (TextUtils.equals(str2, context.getPackageName())) {
                bundle.putString("subjectId", null);
            } else {
                bundle.putString("subjectId", str2);
            }
            bundle.putString("message_proxy_type", ProxyCenter.getProxy().getProxyType());
            return new h().a(context, bundle, intent);
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                HMSLog.w("PluginUtil", "get running app processes null!");
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                    int i = runningAppProcessInfo.importance;
                    if (i == 100 || i == 200) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean onDeletedMessages(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            HMSLog.i("PluginUtil", "onDeletedMessages");
            if (context == null) {
                return false;
            }
            Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
            intent.setPackage(context.getPackageName());
            Bundle bundle = new Bundle();
            bundle.putString("message_proxy_type", ProxyCenter.getProxy().getProxyType());
            bundle.putString("message_type", "server_deleted_message");
            return new h().a(context, bundle, intent);
        }
        return invokeL.booleanValue;
    }

    public static boolean a(Context context, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, strArr)) == null) {
            if (!TextUtils.equals(strArr[1], "0")) {
                return false;
            }
            if (a(context) || TextUtils.equals(strArr[2], "1")) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void onAppOpened(Context context, String str, String str2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, null, context, str, str2, bundle) == null) {
            e.a(context, str, str2, "appHasOpenedId");
            e.a(context, bundle, "hmsStatistics");
        }
    }

    public static void onMessage(Context context, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, strArr) == null) {
            HMSLog.i("PluginUtil", "onMessage");
            if (context != null && strArr != null && strArr.length >= 5) {
                if (ResourceLoaderUtil.getmContext() == null) {
                    ResourceLoaderUtil.setmContext(context.getApplicationContext());
                }
                if (a(context, strArr)) {
                    a(context, strArr[0], strArr[3], strArr[4]);
                } else {
                    onDataMessage(context, strArr[0], strArr[4], true);
                }
            }
        }
    }

    public static void onNotificationArrived(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, context, str, str2) == null) {
            e.a(context, str, str2, YYOption.UrlProtocol.USER);
        }
    }

    public static void onNotificationClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, context, str, str2) == null) {
            e.a(context, str, str2, "1");
            onAppOpened(context, str, str2, null);
        }
    }

    public static boolean onOldDataMessage(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, context, str, str2)) == null) {
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context.getApplicationContext());
            }
            return onDataMessage(context, str, a(str2), true);
        }
        return invokeLLL.booleanValue;
    }
}
