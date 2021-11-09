package com.dxmpay.wallet.core.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.ContextThemeWrapper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.base.widget.LoadingDialog;
import com.dxmpay.wallet.core.BaseActivity;
@SuppressLint({"InlinedApi", "NewApi"})
/* loaded from: classes11.dex */
public final class WalletGlobalUtils {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static Dialog f62612a = null;
    public static String showStr = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(659677668, "Lcom/dxmpay/wallet/core/utils/WalletGlobalUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(659677668, "Lcom/dxmpay/wallet/core/utils/WalletGlobalUtils;");
        }
    }

    public WalletGlobalUtils() {
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

    public static void DismissLoadingDialog() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || (dialog = f62612a) == null) {
            return;
        }
        Context context = dialog.getContext();
        if (context instanceof ContextThemeWrapper) {
            context = ((ContextThemeWrapper) context).getBaseContext();
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        try {
            f62612a.dismiss();
        } catch (Throwable th) {
            LogUtil.e("globalUtils", "dialog Exception", th);
        }
        f62612a = null;
    }

    public static void safeDismissDialog(BaseActivity baseActivity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, baseActivity, i2) == null) {
            try {
                showStr = "";
                Activity activity = baseActivity.getActivity();
                if (activity == null || activity.isFinishing()) {
                    return;
                }
                baseActivity.getActivity().removeDialog(i2);
            } catch (Throwable th) {
                LogUtil.e("globalUtils", "dialog Exception", th);
            }
        }
    }

    public static void safeShowDialog(BaseActivity baseActivity, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, baseActivity, i2, str) == null) {
            try {
                showStr = str;
                baseActivity.getActivity().showDialog(i2);
            } catch (Exception unused) {
            }
        }
    }

    public static void showLoadingDialog(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context) == null) {
            if (f62612a == null) {
                f62612a = new LoadingDialog(context);
            }
            f62612a.show();
        }
    }

    public static void showLoadingDialog(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str, str2) == null) {
            if (f62612a == null) {
                f62612a = new LoadingDialog(context, str, str2);
            }
            f62612a.show();
        }
    }
}
