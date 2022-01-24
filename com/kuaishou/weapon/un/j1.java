package com.kuaishou.weapon.un;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.WeaponS;
import com.kuaishou.weapon.fingerprinter.WeaponHW;
/* loaded from: classes3.dex */
public class j1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long a = 60000;

    /* renamed from: b  reason: collision with root package name */
    public static final long f55137b = 3600000;

    /* renamed from: c  reason: collision with root package name */
    public static final long f55138c = 86400000;

    /* renamed from: d  reason: collision with root package name */
    public static final long f55139d = 604800000;

    /* renamed from: e  reason: collision with root package name */
    public static final int f55140e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static final int f55141f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static final int f55142g = 2;

    /* renamed from: h  reason: collision with root package name */
    public static final int f55143h = 3;

    /* renamed from: i  reason: collision with root package name */
    public static final int f55144i = 10000;

    /* renamed from: j  reason: collision with root package name */
    public static final int f55145j = 10001;
    public static final int k = 10002;
    public static final int l;
    public static final int m;
    public static final int n;
    public static final int o = 92810;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(534994697, "Lcom/kuaishou/weapon/un/j1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(534994697, "Lcom/kuaishou/weapon/un/j1;");
                return;
            }
        }
        l = Integer.valueOf(q0.a).intValue();
        m = Integer.valueOf(q0.f55255b).intValue();
        n = Integer.valueOf(q0.f55256c).intValue();
    }

    public j1() {
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

    public static void a(Context context, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            try {
                new d(context);
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                Intent intent = new Intent("com.kuaishou.action.WEAPON.VIEW");
                intent.setClass(context, WeaponS.class);
                intent.setPackage(context.getPackageName());
                intent.addCategory("com.kuaishou.category.WEAPON");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.putExtra("from_plugin", context.getPackageName());
                intent.putExtra("call_class", v0.class.getCanonicalName());
                intent.putExtra("call_method", "");
                intent.putExtra("from", 0);
                PendingIntent service = PendingIntent.getService(context, 10001, intent, 134217728);
                long currentTimeMillis = System.currentTimeMillis() + 0;
                alarmManager.cancel(service);
                alarmManager.set(0, currentTimeMillis, service);
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }

    public static void a(Context context, Long l2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, l2) == null) {
            try {
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                Intent intent = new Intent("com.kuaishou.action.WEAPON.VIEW");
                intent.setClass(context, WeaponS.class);
                intent.setPackage(context.getPackageName());
                intent.addCategory("com.kuaishou.category.WEAPON");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.putExtra("from_plugin_apk", context.getPackageName());
                intent.putExtra("call_class", WeaponHW.class.getCanonicalName());
                intent.putExtra("call_method", "doAppListReport");
                intent.putExtra("from_type", 4);
                PendingIntent service = PendingIntent.getService(context, m, intent, 134217728);
                long currentTimeMillis = System.currentTimeMillis() + l2.longValue();
                alarmManager.cancel(service);
                String str = "applist next ReportTime : " + y1.a(currentTimeMillis);
                alarmManager.set(0, currentTimeMillis, service);
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }

    public static void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, context, z) == null) {
            try {
                d dVar = new d(context);
                Long l2 = 86400000L;
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                Intent intent = new Intent("com.kuaishou.action.WEAPON.VIEW");
                intent.setClass(context, WeaponS.class);
                intent.setPackage(context.getPackageName());
                intent.addCategory("com.kuaishou.category.WEAPON");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.putExtra("from_plugin_apk", context.getPackageName());
                intent.putExtra("call_class", v0.class.getCanonicalName());
                intent.putExtra("call_method", "");
                intent.putExtra("from_type", 4);
                PendingIntent service = PendingIntent.getService(context, 10000, intent, 134217728);
                long currentTimeMillis = ((System.currentTimeMillis() + l2.longValue()) - 600000) + ((long) (Math.random() * 900000.0d));
                dVar.a(d.k, currentTimeMillis);
                alarmManager.cancel(service);
                alarmManager.set(0, currentTimeMillis, service);
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }

    public static void b(Context context, Long l2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, l2) == null) {
            try {
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                Intent intent = new Intent("com.kuaishou.action.WEAPON.VIEW");
                intent.setClass(context, WeaponS.class);
                intent.setPackage(context.getPackageName());
                intent.addCategory("com.kuaishou.category.WEAPON");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.putExtra("from_plugin_apk", context.getPackageName());
                intent.putExtra("call_class", WeaponHW.class.getCanonicalName());
                intent.putExtra("call_method", "doEnvReport");
                intent.putExtra("from_type", 4);
                PendingIntent service = PendingIntent.getService(context, n, intent, 134217728);
                long currentTimeMillis = System.currentTimeMillis() + l2.longValue();
                alarmManager.cancel(service);
                String str = "env next ReportTime : " + y1.a(currentTimeMillis);
                alarmManager.set(0, currentTimeMillis, service);
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }

    public static void c(Context context, Long l2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, context, l2) == null) {
            try {
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                Intent intent = new Intent("com.kuaishou.action.WEAPON.VIEW");
                intent.setClass(context, WeaponS.class);
                intent.setPackage(context.getPackageName());
                intent.addCategory("com.kuaishou.category.WEAPON");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.putExtra("from_plugin_apk", context.getPackageName());
                intent.putExtra("call_class", WeaponHW.class.getCanonicalName());
                intent.putExtra("call_method", "doFingerPrinterReport");
                intent.putExtra("from_type", 4);
                PendingIntent service = PendingIntent.getService(context, l, intent, 134217728);
                long currentTimeMillis = System.currentTimeMillis() + l2.longValue();
                alarmManager.cancel(service);
                String str = "sdk next ReportTime : " + y1.a(currentTimeMillis);
                alarmManager.set(0, currentTimeMillis, service);
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }
}
