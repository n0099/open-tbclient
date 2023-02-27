package com.vivo.push.util;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public final class i extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int e;

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = 0;
    }

    @Override // com.vivo.push.util.b
    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    private int a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, intent)) == null) {
            ActivityInfo resolveActivityInfo = intent.resolveActivityInfo(this.c.getPackageManager(), 65536);
            if (resolveActivityInfo == null) {
                u.a("AndroidTwelveNotifyClickIntentParam", "activity is null  ");
                u.c(this.c, " 跳转参数对应的Activity找不到 通知不展示   2162");
                return 2162;
            } else if (!resolveActivityInfo.exported) {
                u.a("AndroidTwelveNotifyClickIntentParam", "activity is not exported : " + resolveActivityInfo.toString());
                u.c(this.c, " 跳转参数对应的Activity是非导出的 通知不展示   2161");
                return 2161;
            } else {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static Intent a(Intent intent, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, intent, map)) == null) {
            if (map != null && map.entrySet() != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry != null && entry.getKey() != null) {
                        intent.putExtra(entry.getKey(), entry.getValue());
                    }
                }
            }
            return intent;
        }
        return (Intent) invokeLL.objValue;
    }

    public static Intent b(Intent intent, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, intent, map)) == null) {
            if (map != null && map.entrySet() != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry != null && entry.getKey() != null && !intent.hasExtra(entry.getKey())) {
                        intent.putExtra(entry.getKey(), entry.getValue());
                    }
                }
            }
            return intent;
        }
        return (Intent) invokeLL.objValue;
    }

    private Intent a(String str, String str2, InsideNotificationItem insideNotificationItem, Context context) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, this, str, str2, insideNotificationItem, context)) == null) {
            try {
                Intent parseUri = Intent.parseUri(str, 1);
                parseUri.setSelector(null);
                parseUri.setPackage(str2);
                parseUri.setFlags(335544320);
                a(parseUri, insideNotificationItem.getParams());
                int a = a(parseUri);
                if (a > 0) {
                    this.e = a;
                    u.c(context, " 落地页未找到，通知不展示：  " + this.e);
                    return null;
                }
                return parseUri;
            } catch (Exception e) {
                u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient open activity error : ".concat(String.valueOf(str)), e);
                this.e = 2158;
                return null;
            }
        }
        return (Intent) invokeLLLL.objValue;
    }

    public static Intent a(Map<String, String> map, String str, Context context) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, map, str, context)) == null) {
            Intent intent = new Intent();
            intent.setPackage(str);
            try {
                List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(50);
                if (runningTasks != null) {
                    for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                        ComponentName componentName = runningTaskInfo.topActivity;
                        if (componentName.getPackageName().equals(str)) {
                            u.d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient topClassName=" + componentName.getClassName());
                            intent.setComponent(componentName);
                            intent.setFlags(335544320);
                            a(intent, map);
                            return intent;
                        }
                    }
                }
            } catch (Exception e) {
                u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient ActivityManager", e);
            }
            try {
                intent = context.getPackageManager().getLaunchIntentForPackage(str);
                if (intent != null) {
                    intent.setFlags(335544320);
                    a(intent, map);
                } else {
                    u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient LaunchIntent is null");
                }
            } catch (Exception e2) {
                u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient LaunchIntent Exception" + e2.getMessage());
            }
            return intent;
        }
        return (Intent) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00e3 A[Catch: Exception -> 0x0157, TryCatch #0 {Exception -> 0x0157, blocks: (B:5:0x0009, B:7:0x000f, B:10:0x0017, B:19:0x003f, B:45:0x0123, B:47:0x0139, B:21:0x0049, B:22:0x0066, B:24:0x0083, B:30:0x00a5, B:31:0x00b7, B:32:0x00c1, B:34:0x00cb, B:36:0x00d7, B:41:0x00e3, B:42:0x0109, B:43:0x0119, B:48:0x014f, B:25:0x0088, B:27:0x00a1), top: B:57:0x0009, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0109 A[Catch: Exception -> 0x0157, TryCatch #0 {Exception -> 0x0157, blocks: (B:5:0x0009, B:7:0x000f, B:10:0x0017, B:19:0x003f, B:45:0x0123, B:47:0x0139, B:21:0x0049, B:22:0x0066, B:24:0x0083, B:30:0x00a5, B:31:0x00b7, B:32:0x00c1, B:34:0x00cb, B:36:0x00d7, B:41:0x00e3, B:42:0x0109, B:43:0x0119, B:48:0x014f, B:25:0x0088, B:27:0x00a1), top: B:57:0x0009, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Intent b(Context context, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        InterceptResult invokeLLL;
        String packageName;
        Intent a;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, this, context, insideNotificationItem, notifyArriveCallbackByUser)) == null) {
            try {
                packageName = context.getPackageName();
            } catch (Exception e) {
                u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient parsing error : " + e.getMessage());
                this.e = 2159;
            }
            if (insideNotificationItem != null && !TextUtils.isEmpty(packageName)) {
                u.d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient getSkipType ：：" + insideNotificationItem.getSkipType());
                int skipType = insideNotificationItem.getSkipType();
                boolean z = true;
                if (skipType != 1) {
                    if (skipType != 2) {
                        if (skipType != 3) {
                            if (skipType != 4) {
                                u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient skip type error : intent null");
                                this.e = 2159;
                                a = null;
                            } else {
                                String skipContent = insideNotificationItem.getSkipContent();
                                u.d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient ：：" + insideNotificationItem.getSkipContent());
                                a = a(skipContent, packageName, insideNotificationItem, context);
                            }
                        } else {
                            String skipContent2 = insideNotificationItem.getSkipContent();
                            u.d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient ：：" + insideNotificationItem.getSkipContent());
                            if (notifyArriveCallbackByUser.getIntent() != null) {
                                u.d("AndroidTwelveNotifyClickIntentParam", "notifyArriveCallbackByUser.getIntent()   not null  ");
                                try {
                                    a = notifyArriveCallbackByUser.getIntent();
                                    a.setSelector(null);
                                    a.setFlags(335544320);
                                    b(a, insideNotificationItem.getParams());
                                    a2 = a(a);
                                } catch (Exception e2) {
                                    u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient open activity error : ".concat(String.valueOf(skipContent2)), e2);
                                    this.e = 2158;
                                }
                                if (a2 > 0) {
                                    this.e = a2;
                                    a = null;
                                }
                            } else {
                                u.d("AndroidTwelveNotifyClickIntentParam", "notifyArriveCallbackByUser.getIntent()   is null 根据skipcontent生成跳转参数 ");
                                a = a(skipContent2, packageName, insideNotificationItem, context);
                            }
                        }
                    } else {
                        String skipContent3 = insideNotificationItem.getSkipContent();
                        if (!TextUtils.isEmpty(skipContent3)) {
                            String lowerCase = skipContent3.toLowerCase();
                            if (!lowerCase.startsWith("http://")) {
                                if (lowerCase.startsWith("https://")) {
                                }
                            }
                            if (!z) {
                                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(skipContent3));
                                intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                                a(intent, insideNotificationItem.getParams());
                                u.d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient url urlAddr ::".concat(String.valueOf(skipContent3)));
                                a = intent;
                            } else {
                                u.c(context, " 跳转参数不合法，打开网页地址不符合要求 通知未展示 2157");
                                u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient url not legal");
                                this.e = 2157;
                                a = null;
                            }
                        }
                        z = false;
                        if (!z) {
                        }
                    }
                } else {
                    a = a(insideNotificationItem.getParams(), packageName, context);
                }
                if (a != null) {
                    a.putExtra("vivo_push_messageId", b());
                    a.putExtra("command_type", "reflect_receiver");
                    b.a(a, context);
                    this.e = 0;
                    return a;
                }
                u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient skip type error : " + insideNotificationItem.getSkipType());
                return null;
            }
            u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient notify == null");
            this.e = 2159;
            return null;
        }
        return (Intent) invokeLLL.objValue;
    }

    @Override // com.vivo.push.util.b
    public final PendingIntent a(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, intent)) == null) {
            return PendingIntent.getActivity(context, (int) SystemClock.uptimeMillis(), intent, 201326592);
        }
        return (PendingIntent) invokeLL.objValue;
    }

    @Override // com.vivo.push.util.b
    public final Intent a(Context context, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, insideNotificationItem, notifyArriveCallbackByUser)) == null) {
            return b(context, insideNotificationItem, notifyArriveCallbackByUser);
        }
        return (Intent) invokeLLL.objValue;
    }
}
