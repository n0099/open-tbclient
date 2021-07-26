package d.a.o0.a.t;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.k.d;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ObjectAnimator a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, view)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f);
            ofFloat.setDuration(320L);
            ofFloat.setInterpolator(new d(0.32f, 0.6f, 0.1f, 1.0f));
            return ofFloat;
        }
        return (ObjectAnimator) invokeL.objValue;
    }

    public static ObjectAnimator b(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f);
            ofFloat.setDuration(240L);
            ofFloat.setInterpolator(new LinearInterpolator());
            return ofFloat;
        }
        return (ObjectAnimator) invokeL.objValue;
    }

    public static ObjectAnimator c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f);
            ofFloat.setDuration(320L);
            ofFloat.setInterpolator(new LinearInterpolator());
            return ofFloat;
        }
        return (ObjectAnimator) invokeL.objValue;
    }

    public static ObjectAnimator d(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, view, i2)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", i2);
            ofFloat.setDuration(240L);
            ofFloat.setInterpolator(new d(0.32f, 0.6f, 0.1f, 1.0f));
            return ofFloat;
        }
        return (ObjectAnimator) invokeLI.objValue;
    }
}
