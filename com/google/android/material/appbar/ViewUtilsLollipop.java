package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.internal.ThemeEnforcement;
@RequiresApi(21)
/* loaded from: classes4.dex */
public class ViewUtilsLollipop {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] STATE_LIST_ANIM_ATTRS;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-922144939, "Lcom/google/android/material/appbar/ViewUtilsLollipop;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-922144939, "Lcom/google/android/material/appbar/ViewUtilsLollipop;");
                return;
            }
        }
        STATE_LIST_ANIM_ATTRS = new int[]{16843848};
    }

    public ViewUtilsLollipop() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void setBoundsViewOutlineProvider(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, view2) == null) {
            view2.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
    }

    public static void setDefaultAppBarLayoutStateListAnimator(@NonNull View view2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65539, null, view2, f) == null) {
            int integer = view2.getResources().getInteger(R.integer.obfuscated_res_0x7f0a0005);
            StateListAnimator stateListAnimator = new StateListAnimator();
            long j = integer;
            stateListAnimator.addState(new int[]{16842766, R.attr.obfuscated_res_0x7f0405c8, -2130970057}, ObjectAnimator.ofFloat(view2, "elevation", 0.0f).setDuration(j));
            stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(view2, "elevation", f).setDuration(j));
            stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view2, "elevation", 0.0f).setDuration(0L));
            view2.setStateListAnimator(stateListAnimator);
        }
    }

    public static void setStateListAnimatorFromAttrs(@NonNull View view2, AttributeSet attributeSet, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(InputDeviceCompat.SOURCE_TRACKBALL, null, view2, attributeSet, i, i2) == null) {
            Context context = view2.getContext();
            TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, STATE_LIST_ANIM_ATTRS, i, i2, new int[0]);
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
