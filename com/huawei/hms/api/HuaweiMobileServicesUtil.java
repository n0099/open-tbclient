package com.huawei.hms.api;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.common.ActivityMgr;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ReadApkFileUtil;
/* loaded from: classes8.dex */
public abstract class HuaweiMobileServicesUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HMS_ERROR_DIALOG = "HuaweiMobileServicesErrorDialog";
    public static final int HMS_VERSION_CODE_NOMDM = 20500000;
    public static final String TAG = "HuaweiMobileServicesUtil";
    public transient /* synthetic */ FieldHolder $fh;

    @Deprecated
    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? "" : (String) invokeL.objValue;
    }

    public HuaweiMobileServicesUtil() {
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

    public static Dialog getErrorDialog(int i, Activity activity, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), activity, Integer.valueOf(i2)})) == null) {
            return HuaweiApiAvailability.getInstance().getErrorDialog(activity, i, i2, null);
        }
        return (Dialog) invokeCommon.objValue;
    }

    public static boolean showErrorDialogFragment(int i, Activity activity, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i), activity, Integer.valueOf(i2)})) == null) {
            return HuaweiApiAvailability.getInstance().showErrorDialogFragment(activity, i, i2, null);
        }
        return invokeCommon.booleanValue;
    }

    public static Dialog getErrorDialog(int i, Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), activity, Integer.valueOf(i2), onCancelListener})) == null) {
            return HuaweiApiAvailability.getInstance().getErrorDialog(activity, i, i2, onCancelListener);
        }
        return (Dialog) invokeCommon.objValue;
    }

    public static boolean popupErrDlgFragment(int i, Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Integer.valueOf(i), activity, Integer.valueOf(i2), onCancelListener})) == null) {
            return HuaweiApiAvailability.getInstance().showErrorDialogFragment(activity, i, i2, onCancelListener);
        }
        return invokeCommon.booleanValue;
    }

    public static String getErrorString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            return HuaweiApiAvailability.getInstance().getErrorString(i);
        }
        return (String) invokeI.objValue;
    }

    public static Context getRemoteContext(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                return context.createPackageContext(HMSPackageManager.getInstance(context).getHMSPackageName(), 2);
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
        return (Context) invokeL.objValue;
    }

    public static Resources getRemoteResource(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            try {
                return context.getPackageManager().getResourcesForApplication(HMSPackageManager.getInstance(context).getHMSPackageName());
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
        return (Resources) invokeL.objValue;
    }

    public static int isHuaweiMobileServicesAvailable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            return HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(context);
        }
        return invokeL.intValue;
    }

    public static boolean isUserRecoverableError(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) {
            return HuaweiApiAvailability.getInstance().isUserResolvableError(i);
        }
        return invokeI.booleanValue;
    }

    public static void setApplication(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, application) == null) {
            ActivityMgr.INST.init(application);
        }
    }

    public static int isHuaweiMobileServicesAvailable(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, context, i)) == null) {
            Checker.checkNonNull(context, "context must not be null.");
            if (Build.VERSION.SDK_INT < 16) {
                return 21;
            }
            PackageManagerHelper packageManagerHelper = new PackageManagerHelper(context);
            String hMSPackageNameForMultiService = HMSPackageManager.getInstance(context).getHMSPackageNameForMultiService();
            HMSLog.i(TAG, "hmsPackageName is " + hMSPackageNameForMultiService);
            PackageManagerHelper.PackageStates hMSPackageStatesForMultiService = HMSPackageManager.getInstance(context).getHMSPackageStatesForMultiService();
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(hMSPackageStatesForMultiService)) {
                HMSLog.i(TAG, "HMS is not installed");
                return 1;
            }
            String hmsPath = ReadApkFileUtil.getHmsPath(context);
            if (HwBuildEx.VERSION.EMUI_SDK_INT < 5 && packageManagerHelper.getPackageVersionCode(hMSPackageNameForMultiService) < 20500000 && ReadApkFileUtil.isCertFound(hmsPath)) {
                String packageSignature = packageManagerHelper.getPackageSignature(hMSPackageNameForMultiService);
                if ("B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05".equalsIgnoreCase(packageSignature) || "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C".equalsIgnoreCase(packageSignature) || "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C".equalsIgnoreCase(packageSignature)) {
                    return 2;
                }
                return 9;
            } else if (PackageManagerHelper.PackageStates.SPOOF.equals(hMSPackageStatesForMultiService)) {
                HMSLog.i(TAG, "HMS is spoofed");
                return 9;
            } else if (PackageManagerHelper.PackageStates.DISABLED.equals(hMSPackageStatesForMultiService)) {
                HMSLog.i(TAG, "HMS is disabled");
                return 3;
            } else {
                if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(hMSPackageStatesForMultiService)) {
                    String packageSignature2 = packageManagerHelper.getPackageSignature(hMSPackageNameForMultiService);
                    if (!"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05".equalsIgnoreCase(packageSignature2) && !"3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C".equalsIgnoreCase(packageSignature2) && !"3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C".equalsIgnoreCase(packageSignature2)) {
                        return 9;
                    }
                }
                int hmsMultiServiceVersion = HMSPackageManager.getInstance(context).getHmsMultiServiceVersion();
                HMSLog.i(TAG, "connect versionCode:" + hmsMultiServiceVersion);
                if (HMSPackageManager.getInstance(context).isApkUpdateNecessary(i)) {
                    HMSLog.i(TAG, "The current version does not meet the minimum version requirements");
                    return 2;
                }
                return 0;
            }
        }
        return invokeLI.intValue;
    }

    public static boolean popupErrDlgFragment(int i, Activity activity, Fragment fragment, int i2, DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Integer.valueOf(i), activity, fragment, Integer.valueOf(i2), onCancelListener})) == null) {
            return HuaweiApiAvailability.getInstance().showErrorDialogFragment(activity, i, fragment, i2, onCancelListener);
        }
        return invokeCommon.booleanValue;
    }

    public static void showErrorNotification(int i, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65550, null, i, context) == null) {
            HuaweiApiAvailability.getInstance().showErrorNotification(context, i);
        }
    }
}
