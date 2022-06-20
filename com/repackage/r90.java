package com.repackage;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
@RequiresApi(21)
/* loaded from: classes7.dex */
public class r90 {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755395640, "Lcom/repackage/r90;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755395640, "Lcom/repackage/r90;");
                return;
            }
        }
        a = new int[]{16843848};
    }

    public static void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, view2) == null) {
            view2.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
    }

    public static void b(View view2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65538, null, view2, f) == null) {
            int integer = view2.getResources().getInteger(R.integer.obfuscated_res_0x7f0a0005);
            StateListAnimator stateListAnimator = new StateListAnimator();
            long j = integer;
            stateListAnimator.addState(new int[]{16842766, R.attr.obfuscated_res_0x7f0405cf, -2130970064}, ObjectAnimator.ofFloat(view2, "elevation", 0.0f).setDuration(j));
            stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(view2, "elevation", f).setDuration(j));
            stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view2, "elevation", 0.0f).setDuration(0L));
            view2.setStateListAnimator(stateListAnimator);
        }
    }

    public static void c(View view2, AttributeSet attributeSet, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, view2, attributeSet, i, i2) == null) {
            Context context = view2.getContext();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a, i, i2);
            try {
                if (obtainStyledAttributes.hasValue(0)) {
                    view2.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, obtainStyledAttributes.getResourceId(0, 0)));
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }
}
