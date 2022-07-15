package com.repackage;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rp6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static TBAlertBuilder a(TBAlertBuilder tBAlertBuilder, @StringRes int i, @StringRes int i2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{tBAlertBuilder, Integer.valueOf(i), Integer.valueOf(i2), onClickListener, onClickListener2})) == null) {
            if (tBAlertBuilder == null) {
                return null;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a(i, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a(i2, TBAlertConfig.OperateBtnStyle.SECONDARY);
            tBAlertBuilder.r(aVar2, aVar);
            tBAlertBuilder.g();
            aVar.a(onClickListener);
            aVar2.a(onClickListener2);
            return tBAlertBuilder;
        }
        return (TBAlertBuilder) invokeCommon.objValue;
    }

    public static TBAlertBuilder b(Activity activity, @StringRes int i, @StringRes int i2, View view2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{activity, Integer.valueOf(i), Integer.valueOf(i2), view2})) == null) {
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(activity);
            tBAlertBuilder.t(i);
            tBAlertBuilder.l(i2);
            tBAlertBuilder.n(true);
            tBAlertBuilder.i(false);
            if (view2 != null) {
                tBAlertBuilder.j(view2);
            }
            return tBAlertBuilder;
        }
        return (TBAlertBuilder) invokeCommon.objValue;
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
            WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f0808fd, R.color.CAM_X0108, null);
            int f = pi.f(activity, R.dimen.tbds53);
            linearLayout.addView(imageView, new LinearLayout.LayoutParams(f, f));
            TextView textView = new TextView(activity);
            textView.setText(R.string.obfuscated_res_0x7f0f032b);
            textView.setTextSize(0, UtilHelper.getDimenPixelSize(R.dimen.T_X07));
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.repackage.zo6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        rp6.d(linearLayout, imageView, view2);
                    }
                }
            });
            return linearLayout;
        }
        return (View) invokeL.objValue;
    }

    public static /* synthetic */ void d(LinearLayout linearLayout, ImageView imageView, View view2) {
        if (ng.a(linearLayout.getTag(), false)) {
            xt4.k().u("key_vpb_booster_disconnect_alert", true);
            WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f0808fd, R.color.CAM_X0108, null);
            linearLayout.setTag(Boolean.FALSE);
            return;
        }
        xt4.k().u("key_vpb_booster_disconnect_alert", false);
        WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f0808fe, R.color.CAM_X0304, null);
        linearLayout.setTag(Boolean.TRUE);
    }

    public static void e(Activity activity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, onClickListener) == null) {
            a(b(activity, R.string.obfuscated_res_0x7f0f0327, R.string.obfuscated_res_0x7f0f0325, null), R.string.obfuscated_res_0x7f0f0427, R.string.obfuscated_res_0x7f0f036a, onClickListener, null).w();
        }
    }

    public static void f(Activity activity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, activity, onClickListener) == null) {
            a(b(activity, R.string.obfuscated_res_0x7f0f0327, R.string.obfuscated_res_0x7f0f0326, null), R.string.obfuscated_res_0x7f0f0427, R.string.obfuscated_res_0x7f0f036a, onClickListener, null).w();
        }
    }

    public static void g(Activity activity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, activity, onClickListener) == null) && xt4.k().h("key_vpb_booster_disconnect_alert", true)) {
            a(b(activity, R.string.obfuscated_res_0x7f0f032c, R.string.obfuscated_res_0x7f0f032a, c(activity)), R.string.obfuscated_res_0x7f0f0329, R.string.obfuscated_res_0x7f0f0328, onClickListener, null).w();
        }
    }

    public static void h(Activity activity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, activity, onClickListener, onClickListener2) == null) {
            a(b(activity, R.string.obfuscated_res_0x7f0f0330, R.string.obfuscated_res_0x7f0f032d, null), R.string.obfuscated_res_0x7f0f032f, R.string.obfuscated_res_0x7f0f032e, onClickListener, onClickListener2).w();
        }
    }

    public static void i(Activity activity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, activity, onClickListener) == null) {
            a(b(activity, R.string.obfuscated_res_0x7f0f0335, R.string.obfuscated_res_0x7f0f0334, null), R.string.obfuscated_res_0x7f0f0333, R.string.obfuscated_res_0x7f0f036a, onClickListener, null).w();
        }
    }
}
