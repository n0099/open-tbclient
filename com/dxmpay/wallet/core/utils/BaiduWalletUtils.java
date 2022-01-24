package com.dxmpay.wallet.core.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.beans.BeanConstants;
/* loaded from: classes3.dex */
public final class BaiduWalletUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean IS_BAIDUAPP_PLUGIN = false;
    public static int a;

    /* renamed from: b  reason: collision with root package name */
    public static int f54003b;

    /* renamed from: c  reason: collision with root package name */
    public static int f54004c;

    /* renamed from: d  reason: collision with root package name */
    public static int f54005d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public interface IRequestPermissionCallBack {
        void isAllAgree(Boolean bool);

        void isShow(String str, Boolean bool);

        void requestResult(String str, Boolean bool);
    }

    public BaiduWalletUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void finishActivityAnim(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, context) == null) || context == null) {
            return;
        }
        if (f54004c == 0 || f54005d == 0) {
            f54004c = ResUtils.anim(context, "dxm_wallet_base_slide_from_left");
            f54005d = ResUtils.anim(context, "dxm_wallet_base_slide_to_right");
        }
        if ((context instanceof Activity) && BeanConstants.needActAnimation) {
            ((Activity) context).overridePendingTransition(f54004c, f54005d);
        }
        String str = "BaiduWalletUtils-finishActivityAnim-context:" + context + ", mCloseEnter:" + f54004c + ", mCloseExit:" + f54005d;
    }

    public static String getBaiduappVersionCode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getBaiduappVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String[] getForegroundActivityInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                return new String[]{activity.getPackageName(), activity.getComponentName().getClassName()};
            } else if (context == null) {
                return null;
            } else {
                try {
                    ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                    ActivityManager.RunningTaskInfo runningTaskInfo = activityManager != null ? activityManager.getRunningTasks(1).get(0) : null;
                    if (runningTaskInfo != null) {
                        ComponentName componentName = runningTaskInfo.topActivity;
                        return new String[]{componentName.getPackageName(), componentName.getClassName()};
                    }
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }
        return (String[]) invokeL.objValue;
    }

    public static void invokeHostLightapp(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, str) == null) {
        }
    }

    public static boolean isActivity(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) ? (context instanceof Activity) || (context instanceof BaseActivity) : invokeL.booleanValue;
    }

    public static boolean isNightMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void overridePendingTransitionNoAnim(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, activity) == null) || activity == null) {
            return;
        }
        activity.overridePendingTransition(0, 0);
    }

    public static void requestPermissionsDialog(String str, Activity activity, String[] strArr, IRequestPermissionCallBack iRequestPermissionCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, str, activity, strArr, iRequestPermissionCallBack) == null) {
            DangerousPermissionUtils.getInstance().requestPermissionsDialog(str, activity, strArr, iRequestPermissionCallBack);
        }
    }

    public static void startActivity(Intent intent, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, intent, context) == null) || context == null) {
            return;
        }
        context.startActivity(intent);
    }

    public static void startActivityAnim(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, context) == null) || context == null) {
            return;
        }
        if (a == 0 || f54003b == 0) {
            a = ResUtils.anim(context, "dxm_wallet_base_slide_from_right");
            f54003b = ResUtils.anim(context, "dxm_wallet_base_slide_to_left");
        }
        if ((context instanceof Activity) && BeanConstants.needActAnimation) {
            ((Activity) context).overridePendingTransition(a, f54003b);
        }
    }
}
