package com.repackage;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ru4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ImageView imageView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65536, null, imageView, i) == null) || imageView == null) {
            return;
        }
        WebPManager.setPureDrawable(imageView, i, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = mi.f(TbadkApplication.getInst(), R.dimen.tbds52);
            layoutParams.height = mi.f(TbadkApplication.getInst(), R.dimen.tbds52);
            imageView.setLayoutParams(layoutParams);
        }
    }

    public static void b(ViewGroup viewGroup) {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, viewGroup) == null) || viewGroup == null || (layoutParams = viewGroup.getLayoutParams()) == null) {
            return;
        }
        layoutParams.height = mi.f(TbadkApplication.getInst(), R.dimen.tbds120);
        viewGroup.setLayoutParams(layoutParams);
    }

    public static void c(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, textView) == null) || textView == null) {
            return;
        }
        gs4.d(textView).v(R.color.CAM_X0107);
    }

    public static void d(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, textView) == null) || textView == null) {
            return;
        }
        gs4.d(textView).z(R.dimen.tbds36);
    }

    public static void e(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, textView) == null) || textView == null) {
            return;
        }
        gs4 d = gs4.d(textView);
        d.z(R.dimen.tbds36);
        d.v(R.color.CAM_X0107);
    }

    public static void f(TBLottieAnimationView tBLottieAnimationView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65541, null, tBLottieAnimationView, i) == null) || tBLottieAnimationView == null) {
            return;
        }
        if (i != 1 && i != 4) {
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.obfuscated_res_0x7f11001e);
        } else {
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.obfuscated_res_0x7f110020);
        }
        tBLottieAnimationView.setColorFilter(SkinManager.getColor(R.color.CAM_X0107));
    }
}
