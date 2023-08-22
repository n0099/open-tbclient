package com.huawei.hms.push;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.api.push.TransActivity;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
/* loaded from: classes10.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    public static Notification a(Context context, k kVar, int[] iArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, context, kVar, iArr)) == null) {
            Notification.Builder builder = new Notification.Builder(context);
            if (m.a(kVar) == n.b) {
                m.a(builder, kVar.g(), kVar);
            }
            l.a(context, builder, kVar);
            b(kVar, builder);
            d(kVar, builder);
            a(context, kVar, builder);
            a(builder);
            a(kVar, builder);
            c(kVar, builder);
            builder.setContentIntent(c(context, kVar, iArr));
            builder.setDeleteIntent(b(context, kVar, iArr));
            if (Build.VERSION.SDK_INT >= 26) {
                builder.setChannelId("HwPushChannelID");
            }
            b(context, builder, kVar);
            a(context, builder, kVar);
            return builder.build();
        }
        return (Notification) invokeLLL.objValue;
    }

    public static Intent a(Context context, k kVar, int[] iArr, String str, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, kVar, iArr, str, Integer.valueOf(i)})) == null) {
            Intent intent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
            intent.putExtra("selfshow_info", kVar.o()).putExtra("selfshow_token", kVar.y()).putExtra("selfshow_event_id", str).putExtra("selfshow_notify_id", iArr[0]).putExtra("selfshow_auto_clear_id", iArr[3]).setPackage(context.getPackageName()).setFlags(i);
            return intent;
        }
        return (Intent) invokeCommon.objValue;
    }

    public static void a(Notification.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, builder) == null) {
            builder.setShowWhen(true);
            builder.setWhen(System.currentTimeMillis());
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(Context context, Notification.Builder builder, k kVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, context, builder, kVar) == null) && HwBuildEx.VERSION.EMUI_SDK_INT >= 11 && q.a(context)) {
            Bundle bundle = new Bundle();
            String k = kVar.k();
            HMSLog.i("PushSelfShowLog", "the package name of notification is:" + k);
            if (!TextUtils.isEmpty(k)) {
                String a2 = q.a(context, k);
                HMSLog.i("PushSelfShowLog", "the app name is:" + a2);
                if (a2 != null) {
                    bundle.putCharSequence("android.extraAppName", a2);
                }
            }
            builder.setExtras(bundle);
        }
    }

    public static void a(Context context, Intent intent, long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, intent, Long.valueOf(j), Integer.valueOf(i)}) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("enter setDelayAlarm(interval:");
                sb.append(j);
                sb.append("ms.");
                HMSLog.d("PushSelfShowLog", sb.toString());
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                if (alarmManager != null) {
                    alarmManager.set(0, System.currentTimeMillis() + j, PendingIntent.getBroadcast(context, i, intent, q.b()));
                }
            } catch (Exception e) {
                HMSLog.w("PushSelfShowLog", "set DelayAlarm error." + e.toString());
            }
        }
    }

    public static synchronized void a(Context context, k kVar) {
        int hashCode;
        int i;
        int i2;
        int hashCode2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, kVar) == null) {
            synchronized (o.class) {
                if (context != null) {
                    if (!a(kVar)) {
                        HMSLog.d("PushSelfShowLog", "showNotification, the msg id = " + kVar.p());
                        if (a == 0) {
                            a = (context.getPackageName() + System.currentTimeMillis()).hashCode();
                        }
                        if (TextUtils.isEmpty(kVar.l())) {
                            String q = kVar.q();
                            if (!TextUtils.isEmpty(q)) {
                                int hashCode3 = q.hashCode();
                                kVar.a(hashCode3);
                                HMSLog.d("PushSelfShowLog", "notification msgTag = " + hashCode3);
                            }
                            if (kVar.s() != -1) {
                                hashCode = kVar.s();
                                i = (kVar.k() + System.currentTimeMillis()).hashCode();
                                i2 = i + 1;
                                hashCode2 = (kVar.s() + kVar.k() + context.getPackageName()).hashCode();
                            } else {
                                hashCode = a + 1;
                                a = hashCode;
                                i = hashCode + 1;
                                a = i;
                                i2 = i + 1;
                                a = i2;
                                hashCode2 = i2 + 1;
                                a = hashCode2;
                            }
                        } else {
                            hashCode = (kVar.l() + kVar.k()).hashCode();
                            i = a + 1;
                            a = i;
                            i2 = i + 1;
                            a = i2;
                            hashCode2 = (kVar.l() + kVar.k() + context.getPackageName()).hashCode();
                        }
                        HMSLog.d("PushSelfShowLog", "notifyId:" + hashCode + ",openNotifyId:" + i + ",delNotifyId:" + i2 + ",alarmNotifyId:" + hashCode2);
                        int[] iArr = new int[4];
                        iArr[0] = hashCode;
                        iArr[1] = i;
                        iArr[2] = i2;
                        if (kVar.f() <= 0) {
                            hashCode2 = 0;
                        }
                        iArr[3] = hashCode2;
                        Notification notification = null;
                        if (q.e()) {
                            notification = a(context, kVar, iArr);
                        }
                        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                        if (notificationManager != null && notification != null) {
                            if (Build.VERSION.SDK_INT >= 26) {
                                notificationManager.createNotificationChannel(new NotificationChannel("HwPushChannelID", context.getString(ResourceLoaderUtil.getStringId("hms_push_channel")), 3));
                            }
                            notificationManager.notify(hashCode, notification);
                            d(context, kVar, iArr);
                            e.a(context, kVar.p(), kVar.b(), YYOption.UrlProtocol.USER);
                        }
                    }
                }
            }
        }
    }

    public static void a(Context context, k kVar, Notification.Builder builder) {
        Bitmap a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65542, null, context, kVar, builder) == null) && (a2 = l.a(context, kVar)) != null) {
            builder.setLargeIcon(a2);
        }
    }

    public static void a(k kVar, Notification.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, kVar, builder) == null) {
            boolean z = true;
            if (kVar.e() != 1) {
                z = false;
            }
            builder.setAutoCancel(z);
            builder.setOngoing(false);
        }
    }

    public static void b(k kVar, Notification.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, kVar, builder) == null) {
            String t = kVar.t();
            if (!TextUtils.isEmpty(t)) {
                builder.setSubText(t);
            }
        }
    }

    public static void c(k kVar, Notification.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, kVar, builder) == null) {
            builder.setTicker(kVar.x());
        }
    }

    public static void d(k kVar, Notification.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, kVar, builder) == null) {
            String u = kVar.u();
            String j = kVar.j();
            if (TextUtils.isEmpty(j)) {
                builder.setContentText(u);
                return;
            }
            builder.setContentText(j);
            if (!TextUtils.isEmpty(u)) {
                builder.setContentTitle(u);
            }
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean a(k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, kVar)) == null) {
            if (kVar != null && (!TextUtils.isEmpty(kVar.u()) || !TextUtils.isEmpty(kVar.j()))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static PendingIntent b(Context context, k kVar, int[] iArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, context, kVar, iArr)) == null) {
            Intent a2 = a(context, kVar, iArr, "2", LaunchTaskConstants.OTHER_PROCESS);
            if (a()) {
                a2.setClass(context, TransActivity.class);
                a2.setFlags(268468224);
                return PendingIntent.getActivity(context, iArr[2], a2, q.b());
            }
            return PendingIntent.getBroadcast(context, iArr[2], a2, q.b());
        }
        return (PendingIntent) invokeLLL.objValue;
    }

    public static PendingIntent c(Context context, k kVar, int[] iArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, context, kVar, iArr)) == null) {
            Intent a2 = a(context, kVar, iArr, "1", LaunchTaskConstants.OTHER_PROCESS);
            if (a()) {
                a2.setClass(context, TransActivity.class);
                a2.setFlags(268468224);
                return PendingIntent.getActivity(context, iArr[1], a2, q.b());
            }
            return PendingIntent.getBroadcast(context, iArr[1], a2, q.b());
        }
        return (PendingIntent) invokeLLL.objValue;
    }

    public static void d(Context context, k kVar, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, context, kVar, iArr) == null) {
            HMSLog.i("PushSelfShowLog", "setAutoClear time is: " + kVar.f());
            if (kVar.f() <= 0) {
                return;
            }
            a(context, a(context, kVar, iArr, "-1", 32), kVar.f(), iArr[3]);
        }
    }

    @SuppressLint({"NewApi"})
    public static void b(Context context, Notification.Builder builder, k kVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65547, null, context, builder, kVar) == null) && "com.huawei.android.pushagent".equals(context.getPackageName())) {
            Bundle bundle = new Bundle();
            String k = kVar.k();
            if (!TextUtils.isEmpty(k)) {
                bundle.putString("hw_origin_sender_package_name", k);
                builder.setExtras(bundle);
            }
        }
    }
}
