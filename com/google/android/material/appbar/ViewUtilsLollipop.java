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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
@RequiresApi(21)
/* loaded from: classes11.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void setBoundsViewOutlineProvider(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, view) == null) {
            view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
    }

    public static void setDefaultAppBarLayoutStateListAnimator(@NonNull View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65539, null, view, f2) == null) {
            int integer = view.getResources().getInteger(R.integer.app_bar_elevation_anim_duration);
            StateListAnimator stateListAnimator = new StateListAnimator();
            long j = integer;
            stateListAnimator.addState(new int[]{16842766, R.attr.state_liftable, -R.attr.state_lifted}, ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(j));
            stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(view, "elevation", f2).setDuration(j));
            stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
            view.setStateListAnimator(stateListAnimator);
        }
    }

    public static void setStateListAnimatorFromAttrs(@NonNull View view, AttributeSet attributeSet, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(InputDeviceCompat.SOURCE_TRACKBALL, null, view, attributeSet, i2, i3) == null) {
            Context context = view.getContext();
            TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, STATE_LIST_ANIM_ATTRS, i2, i3, new int[0]);
            try {
                if (obtainStyledAttributes.hasValue(0)) {
                    view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, obtainStyledAttributes.getResourceId(0, 0)));
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }
}
