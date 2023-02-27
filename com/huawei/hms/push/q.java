package com.huawei.hms.push;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidubce.auth.NTLMEngineImpl;
import com.google.protobuf.CodedInputStream;
import com.huawei.hms.support.log.HMSLog;
import java.util.Date;
import java.util.List;
/* loaded from: classes8.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (d()) {
                return 603979776;
            }
            return NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH;
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (c()) {
                return CodedInputStream.DEFAULT_SIZE_LIMIT;
            }
            return 134217728;
        }
        return invokeV.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (Build.VERSION.SDK_INT >= 11) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str == null) {
                str = "";
            }
            try {
                Date date = new Date();
                int hours = (date.getHours() * 2) + (date.getMinutes() / 30);
                String concat = str.concat(str);
                StringBuilder sb = new StringBuilder();
                sb.append("startIndex is ");
                sb.append(hours);
                sb.append(",ap is:");
                sb.append(concat);
                sb.append(",length is:");
                sb.append(concat.length());
                HMSLog.i("PushSelfShowLog", sb.toString());
                int length = concat.length();
                for (int i = hours; i < length; i++) {
                    if (concat.charAt(i) != '0') {
                        long minutes = (((i - hours) * 30) - (date.getMinutes() % 30)) * 60000;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("startIndex is:");
                        sb2.append(hours);
                        sb2.append(" i is:");
                        sb2.append(i);
                        sb2.append(" delay:");
                        sb2.append(minutes);
                        HMSLog.d("PushSelfShowLog", sb2.toString());
                        if (minutes < 0) {
                            return 0L;
                        }
                        return minutes;
                    }
                }
            } catch (Exception e) {
                HMSLog.e("PushSelfShowLog", "error ", e);
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static Boolean a(Context context, String str, Intent intent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, intent)) == null) {
            try {
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
                if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                    int size = queryIntentActivities.size();
                    for (int i = 0; i < size; i++) {
                        if (queryIntentActivities.get(i).activityInfo != null && str.equals(queryIntentActivities.get(i).activityInfo.applicationInfo.packageName)) {
                            return Boolean.TRUE;
                        }
                    }
                }
            } catch (Exception e) {
                HMSLog.e("PushSelfShowLog", e.toString(), e);
            }
            return Boolean.FALSE;
        }
        return (Boolean) invokeLLL.objValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                return packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128)).toString();
            } catch (PackageManager.NameNotFoundException unused) {
                HMSLog.i("PushSelfShowLog", "get the app name of package:" + str + " failed.");
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static Intent b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, str)) == null) {
            try {
                return context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception unused) {
                HMSLog.w("PushSelfShowLog", str + " not have launch activity");
                return null;
            }
        }
        return (Intent) invokeLL.objValue;
    }

    public static void a(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i) == null) {
            if (context == null) {
                HMSLog.e("PushSelfShowLog", "context is null");
                return;
            }
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancel(i);
                }
            } catch (Exception e) {
                HMSLog.e("PushSelfShowLog", "removeNotifiCationById err:" + e.toString());
            }
        }
    }

    public static void a(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, intent) == null) {
            try {
                int intExtra = intent.getIntExtra("selfshow_auto_clear_id", 0);
                StringBuilder sb = new StringBuilder();
                sb.append("setDelayAlarm(cancel) alarmNotityId ");
                sb.append(intExtra);
                HMSLog.d("PushSelfShowLog", sb.toString());
                if (intExtra == 0) {
                    return;
                }
                Intent intent2 = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
                intent2.setPackage(context.getPackageName()).setFlags(32);
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                PendingIntent broadcast = PendingIntent.getBroadcast(context, intExtra, intent2, a());
                if (broadcast != null && alarmManager != null) {
                    HMSLog.d("PushSelfShowLog", "alarm cancel");
                    alarmManager.cancel(broadcast);
                } else {
                    HMSLog.d("PushSelfShowLog", "alarm not exist");
                }
            } catch (Exception e) {
                HMSLog.e("PushSelfShowLog", "cancelAlarm err:" + e.toString());
            }
        }
    }

    public static void a(Context context, Intent intent, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{context, intent, Long.valueOf(j)}) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("enter setAPDelayAlarm(interval:");
                sb.append(j);
                sb.append("ms.");
                HMSLog.d("PushSelfShowLog", sb.toString());
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                if (alarmManager != null) {
                    alarmManager.set(0, System.currentTimeMillis() + j, PendingIntent.getBroadcast(context, (int) (System.currentTimeMillis() / 1000), intent, b()));
                }
            } catch (Exception e) {
                HMSLog.w("PushSelfShowLog", "set DelayAlarm error" + e.toString());
            }
        }
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            return "com.huawei.hwid".equals(context.getPackageName());
        }
        return invokeL.booleanValue;
    }

    public static boolean c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, str)) == null) {
            if (context != null && str != null && !"".equals(str)) {
                try {
                    if (context.getPackageManager().getApplicationInfo(str, 8192) == null) {
                        return false;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(" is installed");
                    HMSLog.d("PushSelfShowLog", sb.toString());
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
