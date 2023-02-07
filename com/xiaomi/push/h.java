package com.xiaomi.push;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;

        /* renamed from: a  reason: collision with other field name */
        public static final /* synthetic */ a[] f474a;
        public static final a b;
        public static final a c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with other field name */
        public final int f475a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1747624879, "Lcom/xiaomi/push/h$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1747624879, "Lcom/xiaomi/push/h$a;");
                    return;
                }
            }
            a = new a(RomUtils.UNKNOWN, 0, 0);
            b = new a("ALLOWED", 1, 1);
            a aVar = new a("NOT_ALLOWED", 2, 2);
            c = aVar;
            f474a = new a[]{a, b, aVar};
        }

        public a(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f475a = i2;
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) f474a.clone() : (a[]) invokeV.objValue;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f475a : invokeV.intValue;
        }
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context != null) {
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.android.systemui", 128);
                    if (applicationInfo == null || applicationInfo.metaData == null) {
                        return 0;
                    }
                    return applicationInfo.metaData.getInt("SupportForPushVersionCode");
                } catch (PackageManager.NameNotFoundException unused) {
                    return 0;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int a(Context context, String str) {
        PackageInfo packageInfo;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
            } catch (Exception unused) {
                packageInfo = null;
            }
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static ApplicationInfo m457a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (str.equals(context.getPackageName())) {
                return context.getApplicationInfo();
            }
            try {
                return context.getPackageManager().getApplicationInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                com.xiaomi.channel.commonutils.logger.b.m105a("not found app info " + str);
                return null;
            }
        }
        return (ApplicationInfo) invokeLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Drawable m458a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            ApplicationInfo m457a = m457a(context, str);
            Drawable drawable = null;
            if (m457a != null) {
                try {
                    drawable = m457a.loadIcon(context.getPackageManager());
                    if (drawable == null) {
                        drawable = m457a.loadLogo(context.getPackageManager());
                    }
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m105a("get app icon drawable failed, " + e);
                }
            }
            return drawable != null ? drawable : new ColorDrawable(0);
        }
        return (Drawable) invokeLL.objValue;
    }

    public static a a(Context context, ApplicationInfo applicationInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, applicationInfo)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (applicationInfo == null || i < 24) {
                return a.a;
            }
            Boolean bool = null;
            try {
                if (applicationInfo.packageName.equals(context.getPackageName())) {
                    bool = Boolean.valueOf(((NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)).areNotificationsEnabled());
                } else {
                    Object a2 = i >= 29 ? bk.a(context.getSystemService(ActionJsonData.TAG_NOTIFICATION), "getService", new Object[0]) : context.getSystemService("security");
                    if (a2 != null) {
                        bool = (Boolean) bk.b(a2, "areNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid));
                    }
                }
                if (bool != null) {
                    return bool.booleanValue() ? a.b : a.c;
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m105a("are notifications enabled error " + e);
            }
            return a.a;
        }
        return (a) invokeLL.objValue;
    }

    @TargetApi(19)
    public static a a(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        ApplicationInfo applicationInfo;
        a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, context, str, z)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return a.a;
            }
            try {
                applicationInfo = str.equals(context.getPackageName()) ? context.getApplicationInfo() : context.getPackageManager().getApplicationInfo(str, 0);
                a2 = a(context, applicationInfo);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m105a("get app op error " + th);
            }
            if (a2 != a.a) {
                return a2;
            }
            Integer num = (Integer) bk.a((Class<? extends Object>) AppOpsManager.class, NotificationManagerCompat.OP_POST_NOTIFICATION);
            if (num == null) {
                return a.a;
            }
            Integer num2 = (Integer) bk.a((Object) ((AppOpsManager) context.getSystemService("appops")), NotificationManagerCompat.CHECK_OP_NO_THROW, num, Integer.valueOf(applicationInfo.uid), str);
            int i = (Integer) bk.a((Class<? extends Object>) AppOpsManager.class, "MODE_ALLOWED");
            int i2 = (Integer) bk.a((Class<? extends Object>) AppOpsManager.class, "MODE_IGNORED");
            com.xiaomi.channel.commonutils.logger.b.b(String.format("get app mode %s|%s|%s", num2, i, i2));
            if (i == null) {
                i = 0;
            }
            if (i2 == null) {
                i2 = 1;
            }
            if (num2 != null) {
                return z ? !num2.equals(i2) ? a.b : a.c : num2.equals(i) ? a.b : a.c;
            }
            return a.a;
        }
        return (a) invokeLLZ.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m459a(Context context, String str) {
        PackageInfo packageInfo;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
            } catch (Exception unused) {
                packageInfo = null;
            }
            return packageInfo != null ? packageInfo.versionName : "1.0";
        }
        return (String) invokeLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m460a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            String str = (String) bk.a("android.app.ActivityThread", "currentProcessName", new Object[0]);
            if (TextUtils.isEmpty(str) || context == null) {
                return false;
            }
            return str.equals(context.getPackageName());
        }
        return invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m461a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            if (m.m636a()) {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (Arrays.asList(runningAppProcessInfo.pkgList).contains(str)) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static int b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, str)) == null) {
            ApplicationInfo m457a = m457a(context, str);
            if (m457a != null) {
                int i = m457a.icon;
                return i == 0 ? m457a.logo : i;
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static String m462b(Context context, String str) {
        ApplicationInfo applicationInfo;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                return (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) ? str : packageManager.getApplicationLabel(applicationInfo).toString();
            } catch (PackageManager.NameNotFoundException unused) {
                return str;
            }
        }
        return (String) invokeLL.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m463b(Context context, String str) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, str)) == null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            return packageInfo != null;
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, context, str)) == null) ? context.getPackageManager().checkPermission(str, context.getPackageName()) == 0 : invokeLL.booleanValue;
    }

    public static boolean d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                if (Settings.Secure.getInt(context.getContentResolver(), "freeform_window_state", -1) >= 0) {
                    return str.equals(ApiReplaceUtil.Overload.getString(context.getContentResolver(), "freeform_package_name"));
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
