package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.al;
import com.xiaomi.push.eq;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class cc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, map)) == null) ? Math.max(0, com.xiaomi.push.w.a(map.get("notification_top_period"), 0)) : invokeL.intValue;
    }

    @TargetApi(19)
    public static Notification a(Notification notification, int i, String str, ax axVar) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65537, null, notification, i, str, axVar)) == null) {
            if (notification != null) {
                if (!str.equals(notification.extras.getString("message_id"))) {
                    notification = null;
                }
                return notification;
            }
            List<StatusBarNotification> m641b = axVar.m641b();
            if (m641b != null) {
                for (StatusBarNotification statusBarNotification : m641b) {
                    Notification notification2 = statusBarNotification.getNotification();
                    String string = notification2.extras.getString("message_id");
                    if (i == statusBarNotification.getId() && str.equals(string)) {
                        return notification2;
                    }
                }
                return null;
            }
            return null;
        }
        return (Notification) invokeLILL.objValue;
    }

    public static al.a a(Context context, String str, int i, String str2, Notification notification) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, str, Integer.valueOf(i), str2, notification})) == null) ? new cd(i, str2, context, str, notification) : (al.a) invokeCommon.objValue;
    }

    @TargetApi(19)
    /* renamed from: a  reason: collision with other method in class */
    public static void m666a(Context context, String str, int i, String str2, Notification notification) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, Integer.valueOf(i), str2, notification}) == null) && com.xiaomi.push.m.m571a(context) && notification != null && notification.extras.getBoolean("mipush_n_top_flag", false)) {
            c(context, str, i, str2, notification);
        }
    }

    public static void a(Context context, Map<String, String> map, eq eqVar, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, map, eqVar, Long.valueOf(j)}) == null) && map != null && eqVar != null && com.xiaomi.push.m.m571a(context) && m667a(map)) {
            int a = a(map);
            int b = b(map);
            if (a <= 0 || b > a) {
                com.xiaomi.channel.commonutils.logger.b.d("set top notification failed - period:" + a + " frequency:" + b);
                return;
            }
            eqVar.setPriority(2);
            Bundle bundle = new Bundle();
            bundle.putLong("mipush_org_when", j);
            bundle.putBoolean("mipush_n_top_flag", true);
            if (b > 0) {
                bundle.putInt("mipush_n_top_fre", b);
            }
            bundle.putInt("mipush_n_top_prd", a);
            eqVar.addExtras(bundle);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m667a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, map)) == null) {
            String str = map.get("notification_top_repeat");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            boolean parseBoolean = Boolean.parseBoolean(str);
            com.xiaomi.channel.commonutils.logger.b.c("top notification' repeat is " + parseBoolean);
            return parseBoolean;
        }
        return invokeL.booleanValue;
    }

    public static int b(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, map)) == null) ? Math.max(0, com.xiaomi.push.w.a(map.get("notification_top_frequency"), 0)) : invokeL.intValue;
    }

    public static String b(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65544, null, i, str)) == null) {
            return "n_top_update_" + i + "_" + str;
        }
        return (String) invokeIL.objValue;
    }

    @TargetApi(19)
    public static void c(Context context, String str, int i, String str2, Notification notification) {
        ax a;
        Notification a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{context, str, Integer.valueOf(i), str2, notification}) == null) || context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Build.VERSION.SDK_INT < 26 || (a2 = a(notification, i, str2, (a = ax.a(context, str)))) == null) {
            return;
        }
        boolean z = notification != null;
        if (a2.getGroupAlertBehavior() != 1) {
            com.xiaomi.push.bk.a((Object) a2, "mGroupAlertBehavior", (Object) 1);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = a2.extras.getLong("mipush_org_when", 0L);
        int i2 = a2.extras.getInt("mipush_n_top_fre", 0);
        int i3 = a2.extras.getInt("mipush_n_top_prd", 0);
        if (i3 <= 0 || i3 < i2) {
            return;
        }
        long j2 = (i3 * 1000) + j;
        int min = (j >= currentTimeMillis || currentTimeMillis >= j2) ? 0 : i2 > 0 ? (int) Math.min((j2 - currentTimeMillis) / 1000, i2) : i3;
        if (!z) {
            if (min > 0) {
                a2.when = currentTimeMillis;
                com.xiaomi.channel.commonutils.logger.b.m99a("update top notification: " + str2);
                a.a(i, a2);
            } else {
                Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, a2);
                recoverBuilder.setPriority(0);
                recoverBuilder.setWhen(currentTimeMillis);
                Bundle extras = recoverBuilder.getExtras();
                if (extras != null) {
                    extras.remove("mipush_n_top_flag");
                    extras.remove("mipush_org_when");
                    extras.remove("mipush_n_top_fre");
                    extras.remove("mipush_n_top_prd");
                    recoverBuilder.setExtras(extras);
                }
                com.xiaomi.channel.commonutils.logger.b.m99a("update top notification to common: " + str2);
                a.a(i, recoverBuilder.build());
            }
        }
        if (min > 0) {
            com.xiaomi.channel.commonutils.logger.b.m99a("schedule top notification next update delay: " + min);
            com.xiaomi.push.al.a(context).m177a(b(i, str2));
            com.xiaomi.push.al.a(context).b(a(context, str, i, str2, (Notification) null), min);
        }
    }
}
