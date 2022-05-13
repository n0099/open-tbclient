package com.repackage;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class up6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static bs4 a(bs4 bs4Var, @StringRes int i, @StringRes int i2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{bs4Var, Integer.valueOf(i), Integer.valueOf(i2), onClickListener, onClickListener2})) == null) {
            if (bs4Var == null) {
                return null;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a(i, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a(i2, TBAlertConfig.OperateBtnStyle.SECONDARY);
            bs4Var.r(aVar2, aVar);
            bs4Var.g();
            aVar.a(onClickListener);
            aVar2.a(onClickListener2);
            return bs4Var;
        }
        return (bs4) invokeCommon.objValue;
    }

    public static bs4 b(Activity activity, @StringRes int i, @StringRes int i2, View view2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{activity, Integer.valueOf(i), Integer.valueOf(i2), view2})) == null) {
            bs4 bs4Var = new bs4(activity);
            bs4Var.v(i);
            bs4Var.l(i2);
            bs4Var.n(true);
            bs4Var.i(false);
            if (view2 != null) {
                bs4Var.j(view2);
            }
            return bs4Var;
        }
        return (bs4) invokeCommon.objValue;
    }

    public static View c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            final LinearLayout linearLayout = new LinearLayout(activity);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X013);
            linearLayout.setPadding(dimenPixelSize, UtilHelper.getDimenPixelSize(R.dimen.tbds53), dimenPixelSize, 0);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            final ImageView imageView = new ImageView(activity);
            WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f080905, R.color.CAM_X0108, null);
            int f = mi.f(activity, R.dimen.tbds53);
            linearLayout.addView(imageView, new LinearLayout.LayoutParams(f, f));
            TextView textView = new TextView(activity);
            textView.setText(R.string.obfuscated_res_0x7f0f0327);
            textView.setTextSize(0, UtilHelper.getDimenPixelSize(R.dimen.T_X07));
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.repackage.cp6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        up6.d(linearLayout, imageView, view2);
                    }
                }
            });
            return linearLayout;
        }
        return (View) invokeL.objValue;
    }

    public static /* synthetic */ void d(LinearLayout linearLayout, ImageView imageView, View view2) {
        if (kg.a(linearLayout.getTag(), false)) {
            iu4.k().u("key_vpb_booster_disconnect_alert", true);
            WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f080905, R.color.CAM_X0108, null);
            linearLayout.setTag(Boolean.FALSE);
            return;
        }
        iu4.k().u("key_vpb_booster_disconnect_alert", false);
        WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f080906, R.color.CAM_X0304, null);
        linearLayout.setTag(Boolean.TRUE);
    }

    public static void e(Activity activity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, onClickListener) == null) {
            a(b(activity, R.string.obfuscated_res_0x7f0f0323, R.string.obfuscated_res_0x7f0f0321, null), R.string.obfuscated_res_0x7f0f0428, R.string.obfuscated_res_0x7f0f0374, onClickListener, null).y();
        }
    }

    public static void f(Activity activity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, activity, onClickListener) == null) {
            a(b(activity, R.string.obfuscated_res_0x7f0f0323, R.string.obfuscated_res_0x7f0f0322, null), R.string.obfuscated_res_0x7f0f0428, R.string.obfuscated_res_0x7f0f0374, onClickListener, null).y();
        }
    }

    public static void g(Activity activity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, activity, onClickListener) == null) && iu4.k().h("key_vpb_booster_disconnect_alert", true)) {
            a(b(activity, R.string.obfuscated_res_0x7f0f0328, R.string.obfuscated_res_0x7f0f0326, c(activity)), R.string.obfuscated_res_0x7f0f0325, R.string.obfuscated_res_0x7f0f0324, onClickListener, null).y();
        }
    }

    public static void h(Activity activity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, activity, onClickListener, onClickListener2) == null) {
            a(b(activity, R.string.obfuscated_res_0x7f0f032c, R.string.obfuscated_res_0x7f0f0329, null), R.string.obfuscated_res_0x7f0f032b, R.string.obfuscated_res_0x7f0f032a, onClickListener, onClickListener2).y();
        }
    }

    public static void i(Activity activity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, activity, onClickListener) == null) {
            a(b(activity, R.string.obfuscated_res_0x7f0f0331, R.string.obfuscated_res_0x7f0f0330, null), R.string.obfuscated_res_0x7f0f032f, R.string.obfuscated_res_0x7f0f0374, onClickListener, null).y();
        }
    }
}
