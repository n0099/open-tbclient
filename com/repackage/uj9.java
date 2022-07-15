package com.repackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException;
import com.google.android.gms.common.GooglePlayServicesMissingManifestValueException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class uj9 {
    public static /* synthetic */ Interceptable $ic = null;
    @Deprecated
    public static final int a = 12451000;
    public static final AtomicBoolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755258899, "Lcom/repackage/uj9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755258899, "Lcom/repackage/uj9;");
                return;
            }
        }
        new AtomicBoolean();
        b = new AtomicBoolean();
    }

    @Deprecated
    public static int a(@NonNull Context context, int i) {
        InterceptResult invokeLI;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i)) == null) {
            try {
                context.getResources().getString(R.string.obfuscated_res_0x7f0f040c);
            } catch (Throwable unused) {
                Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
            }
            if (!"com.google.android.gms".equals(context.getPackageName()) && !b.get()) {
                int a2 = hk9.a(context);
                if (a2 != 0) {
                    if (a2 != a) {
                        throw new GooglePlayServicesIncorrectManifestValueException(a2);
                    }
                } else {
                    throw new GooglePlayServicesMissingManifestValueException();
                }
            }
            boolean z = (uk9.b(context) || uk9.d(context)) ? false : true;
            dk9.a(i >= 0);
            String packageName = context.getPackageName();
            PackageManager packageManager = context.getPackageManager();
            if (z) {
                try {
                    packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
                } catch (PackageManager.NameNotFoundException unused2) {
                    Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires the Google Play Store, but it is missing."));
                }
            } else {
                packageInfo = null;
            }
            try {
                PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
                vj9.a(context);
                if (!vj9.c(packageInfo2, true)) {
                    Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but their signature is invalid."));
                } else {
                    if (z) {
                        dk9.d(packageInfo);
                        if (!vj9.c(packageInfo, true)) {
                            Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature is invalid."));
                        }
                    }
                    if (z && packageInfo != null && !packageInfo.signatures[0].equals(packageInfo2.signatures[0])) {
                        Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature doesn't match that of Google Play services."));
                    } else if (wk9.a(packageInfo2.versionCode) < wk9.a(i)) {
                        int i2 = packageInfo2.versionCode;
                        StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 82);
                        sb.append("Google Play services out of date for ");
                        sb.append(packageName);
                        sb.append(".  Requires ");
                        sb.append(i);
                        sb.append(" but found ");
                        sb.append(i2);
                        Log.w("GooglePlayServicesUtil", sb.toString());
                        return 2;
                    } else {
                        ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
                        if (applicationInfo == null) {
                            try {
                                applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                            } catch (PackageManager.NameNotFoundException e) {
                                Log.wtf("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they're missing when getting application info."), e);
                                return 1;
                            }
                        }
                        return !applicationInfo.enabled ? 3 : 0;
                    }
                }
                return 9;
            } catch (PackageManager.NameNotFoundException unused3) {
                Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they are missing."));
                return 1;
            }
        }
        return invokeLI.intValue;
    }

    @Deprecated
    public static boolean b(@NonNull Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, context, i)) == null) {
            if (i == 18) {
                return true;
            }
            if (i == 1) {
                return d(context, "com.google.android.gms");
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    @TargetApi(18)
    public static boolean c(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (vk9.a()) {
                Object systemService = context.getSystemService("user");
                dk9.d(systemService);
                Bundle applicationRestrictions = ((UserManager) systemService).getApplicationRestrictions(context.getPackageName());
                return applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @TargetApi(21)
    public static boolean d(Context context, String str) {
        InterceptResult invokeLL;
        ApplicationInfo applicationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            boolean equals = str.equals("com.google.android.gms");
            if (vk9.c()) {
                try {
                    for (PackageInstaller.SessionInfo sessionInfo : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                        if (str.equals(sessionInfo.getAppPackageName())) {
                            return true;
                        }
                    }
                } catch (Exception unused) {
                    return false;
                }
            }
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
            } catch (PackageManager.NameNotFoundException unused2) {
            }
            if (equals) {
                return applicationInfo.enabled;
            }
            return applicationInfo.enabled && !c(context);
        }
        return invokeLL.booleanValue;
    }
}
