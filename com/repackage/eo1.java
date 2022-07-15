package com.repackage;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class eo1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ObjectAnimator a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, view2)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "translationY", 0.0f);
            ofFloat.setDuration(320L);
            ofFloat.setInterpolator(new k64(0.32f, 0.6f, 0.1f, 1.0f));
            return ofFloat;
        }
        return (ObjectAnimator) invokeL.objValue;
    }

    public static ObjectAnimator b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "alpha", 0.0f);
            ofFloat.setDuration(240L);
            ofFloat.setInterpolator(new LinearInterpolator());
            return ofFloat;
        }
        return (ObjectAnimator) invokeL.objValue;
    }

    public static ObjectAnimator c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "alpha", 1.0f);
            ofFloat.setDuration(320L);
            ofFloat.setInterpolator(new LinearInterpolator());
            return ofFloat;
        }
        return (ObjectAnimator) invokeL.objValue;
    }

    public static ObjectAnimator d(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, view2, i)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "translationY", i);
            ofFloat.setDuration(240L);
            ofFloat.setInterpolator(new k64(0.32f, 0.6f, 0.1f, 1.0f));
            return ofFloat;
        }
        return (ObjectAnimator) invokeLI.objValue;
    }
}
