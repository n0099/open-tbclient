package com.repackage;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes5.dex */
public class en1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ObjectAnimator a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, view2)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, AnimationProperty.TRANSLATE_Y, 0.0f);
            ofFloat.setDuration(320L);
            ofFloat.setInterpolator(new k54(0.32f, 0.6f, 0.1f, 1.0f));
            return ofFloat;
        }
        return (ObjectAnimator) invokeL.objValue;
    }

    public static ObjectAnimator b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, AnimationProperty.OPACITY, 0.0f);
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
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, AnimationProperty.OPACITY, 1.0f);
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
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, AnimationProperty.TRANSLATE_Y, i);
            ofFloat.setDuration(240L);
            ofFloat.setInterpolator(new k54(0.32f, 0.6f, 0.1f, 1.0f));
            return ofFloat;
        }
        return (ObjectAnimator) invokeLI.objValue;
    }
}
