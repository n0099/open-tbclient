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
import android.os.Process;
import android.text.TextUtils;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes10.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f78022a;

        /* renamed from: a  reason: collision with other field name */
        public static final /* synthetic */ a[] f425a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f78023b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f78024c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with other field name */
        public final int f426a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1747654670, "Lcom/xiaomi/push/g$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1747654670, "Lcom/xiaomi/push/g$a;");
                    return;
                }
            }
            f78022a = new a(RomUtils.UNKNOWN, 0, 0);
            f78023b = new a("ALLOWED", 1, 1);
            a aVar = new a("NOT_ALLOWED", 2, 2);
            f78024c = aVar;
            f425a = new a[]{f78022a, f78023b, aVar};
        }

        public a(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f426a = i3;
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) f425a.clone() : (a[]) invokeV.objValue;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f426a : invokeV.intValue;
        }
    }

    public static int a(Context context, String str) {
        PackageInfo packageInfo;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
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
    public static ApplicationInfo m339a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            if (str.equals(context.getPackageName())) {
                return context.getApplicationInfo();
            }
            try {
                return context.getPackageManager().getApplicationInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                com.xiaomi.channel.commonutils.logger.b.m73a("not found app info " + str);
                return null;
            }
        }
        return (ApplicationInfo) invokeLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Drawable m340a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            ApplicationInfo m339a = m339a(context, str);
            Drawable drawable = null;
            if (m339a != null) {
                try {
                    drawable = m339a.loadIcon(context.getPackageManager());
                    if (drawable == null && Build.VERSION.SDK_INT >= 9) {
                        drawable = m339a.loadLogo(context.getPackageManager());
                    }
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m73a("get app icon drawable failed, " + e2);
                }
            }
            return drawable != null ? drawable : new ColorDrawable(0);
        }
        return (Drawable) invokeLL.objValue;
    }

    public static a a(Context context, ApplicationInfo applicationInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, applicationInfo)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (applicationInfo == null || i2 < 24) {
                return a.f78022a;
            }
            Boolean bool = null;
            try {
                if (applicationInfo.packageName.equals(context.getPackageName())) {
                    bool = Boolean.valueOf(((NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)).areNotificationsEnabled());
                } else {
                    Object a2 = i2 >= 29 ? bh.a(context.getSystemService(ActionJsonData.TAG_NOTIFICATION), "getService", new Object[0]) : context.getSystemService("security");
                    if (a2 != null) {
                        bool = (Boolean) bh.b(a2, "areNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid));
                    }
                }
                if (bool != null) {
                    return bool.booleanValue() ? a.f78023b : a.f78024c;
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m73a("are notifications enabled error " + e2);
            }
            return a.f78022a;
        }
        return (a) invokeLL.objValue;
    }

    @TargetApi(19)
    public static a a(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        ApplicationInfo applicationInfo;
        a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, z)) == null) {
            if (context == null || TextUtils.isEmpty(str) || Build.VERSION.SDK_INT < 19) {
                return a.f78022a;
            }
            try {
                applicationInfo = str.equals(context.getPackageName()) ? context.getApplicationInfo() : context.getPackageManager().getApplicationInfo(str, 0);
                a2 = a(context, applicationInfo);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m73a("get app op error " + th);
            }
            if (a2 != a.f78022a) {
                return a2;
            }
            Integer num = (Integer) bh.a((Class<? extends Object>) AppOpsManager.class, NotificationManagerCompat.OP_POST_NOTIFICATION);
            if (num == null) {
                return a.f78022a;
            }
            Integer num2 = (Integer) bh.a((Object) ((AppOpsManager) context.getSystemService("appops")), NotificationManagerCompat.CHECK_OP_NO_THROW, num, Integer.valueOf(applicationInfo.uid), str);
            int i2 = (Integer) bh.a((Class<? extends Object>) AppOpsManager.class, "MODE_ALLOWED");
            int i3 = (Integer) bh.a((Class<? extends Object>) AppOpsManager.class, "MODE_IGNORED");
            com.xiaomi.channel.commonutils.logger.b.b(String.format("get app mode %s|%s|%s", num2, i2, i3));
            if (i2 == null) {
                i2 = 0;
            }
            if (i3 == null) {
                i3 = 1;
            }
            if (num2 != null) {
                return z ? !num2.equals(i3) ? a.f78023b : a.f78024c : num2.equals(i2) ? a.f78023b : a.f78024c;
            }
            return a.f78022a;
        }
        return (a) invokeLLZ.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? a(context, Process.myPid()) : (String) invokeL.objValue;
    }

    public static String a(Context context, int i2) {
        InterceptResult invokeLI;
        List<ActivityManager.RunningAppProcessInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, context, i2)) == null) {
            if (context == null) {
                return null;
            }
            try {
                list = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            } catch (Exception unused) {
                list = null;
            }
            if (list == null) {
                return null;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
                if (runningAppProcessInfo.pid == i2) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        }
        return (String) invokeLI.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m341a(Context context, String str) {
        PackageInfo packageInfo;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                packageInfo = null;
            }
            return packageInfo != null ? packageInfo.versionName : "1.0";
        }
        return (String) invokeLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m342a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null && runningAppProcesses.size() >= 1) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == Process.myPid() && runningAppProcessInfo.processName.equals(context.getPackageName())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m343a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, str)) == null) {
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
        return invokeLL.booleanValue;
    }

    public static int b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) {
            ApplicationInfo m339a = m339a(context, str);
            if (m339a != null) {
                int i2 = m339a.icon;
                return (i2 != 0 || Build.VERSION.SDK_INT < 9) ? i2 : m339a.logo;
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    String[] strArr = runningAppProcessInfo.pkgList;
                    for (int i2 = 0; strArr != null && i2 < strArr.length; i2++) {
                        if (!arrayList.contains(strArr[i2])) {
                            arrayList.add(strArr[i2]);
                            if (arrayList.size() == 1) {
                                str = (String) arrayList.get(0);
                            } else {
                                sb.append("#");
                                str = strArr[i2];
                            }
                            sb.append(str.hashCode() % 100000);
                        }
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static String m344b(Context context, String str) {
        ApplicationInfo applicationInfo;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, context, str)) == null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                return (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) ? str : packageManager.getApplicationLabel(applicationInfo).toString();
            } catch (PackageManager.NameNotFoundException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                return str;
            }
        }
        return (String) invokeLL.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m345b(Context context, String str) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) {
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, context, str)) == null) ? context.getPackageManager().checkPermission(str, context.getPackageName()) == 0 : invokeLL.booleanValue;
    }
}
