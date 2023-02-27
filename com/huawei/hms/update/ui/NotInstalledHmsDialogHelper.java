package com.huawei.hms.update.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.AndroidException;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.ResourceLoaderUtil;
/* loaded from: classes8.dex */
public class NotInstalledHmsDialogHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public NotInstalledHmsDialogHelper() {
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

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                return 0;
            }
            return context.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
        }
        return invokeL.intValue;
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, context) == null) && ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(context.getApplicationContext());
        }
    }

    public static String getAppName(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity)) == null) {
            return a(activity, activity.getPackageName());
        }
        return (String) invokeL.objValue;
    }

    public static int getConfirmResId(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, activity)) == null) {
            Checker.checkNonNull(activity, "activity must not be null");
            b(activity);
            return ResourceLoaderUtil.getStringId("hms_confirm");
        }
        return invokeL.intValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context == null) {
                HMSLog.e("NotInstalledHmsDialogHelper", "In getAppName, context is null.");
                return "";
            }
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                HMSLog.e("NotInstalledHmsDialogHelper", "In getAppName, Failed to get 'PackageManager' instance.");
                return "";
            }
            try {
                if (TextUtils.isEmpty(str)) {
                    str = context.getPackageName();
                }
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128));
                if (applicationLabel == null) {
                    return "";
                }
                return applicationLabel.toString();
            } catch (AndroidException | RuntimeException unused) {
                HMSLog.e("NotInstalledHmsDialogHelper", "In getAppName, Failed to get app name.");
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static AlertDialog.Builder getDialogBuilder(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, activity)) == null) {
            Checker.checkNonNull(activity, "activity must not be null");
            b(activity);
            return new AlertDialog.Builder(activity, getDialogThemeId(activity)).setMessage(activity.getString(ResourceLoaderUtil.getStringId("hms_apk_not_installed_hints"), new Object[]{a(activity, activity.getPackageName())}));
        }
        return (AlertDialog.Builder) invokeL.objValue;
    }

    public static int getDialogThemeId(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, activity)) == null) {
            if (a(activity) != 0 && Build.VERSION.SDK_INT >= 16) {
                return 0;
            }
            if (activity == null || (activity.getResources().getConfiguration().uiMode & 48) != 32) {
                return 3;
            }
            return 2;
        }
        return invokeL.intValue;
    }
}
