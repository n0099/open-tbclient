package com.sina.weibo.sdk.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class UIUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public UIUtils() {
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

    public static int dip2px(int i2, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i2, context)) == null) ? (int) ((i2 * context.getResources().getDisplayMetrics().density) + 0.5f) : invokeIL.intValue;
    }

    public static void showAlert(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, context, str, str2) == null) || context == null) {
            return;
        }
        new AlertDialog.Builder(context).setTitle(str).setMessage(str2).create().show();
    }

    public static void showToast(Context context, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i2, i3) == null) || context == null) {
            return;
        }
        Toast.makeText(context, i2, i3).show();
    }

    public static void showToastInCenter(Context context, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(AdIconUtil.BAIDU_LOGO_ID, null, context, i2, i3) == null) || context == null) {
            return;
        }
        Toast makeText = Toast.makeText(context, i2, i3);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    public static void showToast(Context context, CharSequence charSequence, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(AdIconUtil.AD_TEXT_ID, null, context, charSequence, i2) == null) || context == null) {
            return;
        }
        Toast.makeText(context, charSequence, i2).show();
    }

    public static void showAlert(Context context, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65538, null, context, i2, i3) == null) || context == null) {
            return;
        }
        showAlert(context, context.getString(i2), context.getString(i3));
    }
}
