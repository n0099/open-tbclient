package com.google.android.material.resources;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class MaterialAttributes {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MaterialAttributes() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Nullable
    public static TypedValue resolve(@NonNull Context context, @AttrRes int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i)) == null) {
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(i, typedValue, true)) {
                return typedValue;
            }
            return null;
        }
        return (TypedValue) invokeLI.objValue;
    }

    public static boolean resolveBoolean(@NonNull Context context, @AttrRes int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            TypedValue resolve = resolve(context, i);
            return (resolve == null || resolve.type != 18) ? z : resolve.data != 0;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean resolveBooleanOrThrow(@NonNull Context context, @AttrRes int i, @NonNull String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, context, i, str)) == null) ? resolveOrThrow(context, i, str) != 0 : invokeLIL.booleanValue;
    }

    @Px
    public static int resolveDimension(@NonNull Context context, @AttrRes int i, @DimenRes int i2) {
        InterceptResult invokeLII;
        float dimension;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i, i2)) == null) {
            TypedValue resolve = resolve(context, i);
            if (resolve != null && resolve.type == 5) {
                dimension = resolve.getDimension(context.getResources().getDisplayMetrics());
            } else {
                dimension = context.getResources().getDimension(i2);
            }
            return (int) dimension;
        }
        return invokeLII.intValue;
    }

    @Px
    public static int resolveMinimumAccessibleTouchTarget(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? resolveDimension(context, R.attr.obfuscated_res_0x7f0404d2, R.dimen.obfuscated_res_0x7f0704b9) : invokeL.intValue;
    }

    public static int resolveOrThrow(@NonNull Context context, @AttrRes int i, @NonNull String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65542, null, context, i, str)) == null) {
            TypedValue resolve = resolve(context, i);
            if (resolve != null) {
                return resolve.data;
            }
            throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i)));
        }
        return invokeLIL.intValue;
    }

    public static int resolveOrThrow(@NonNull View view2, @AttrRes int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, view2, i)) == null) ? resolveOrThrow(view2.getContext(), i, view2.getClass().getCanonicalName()) : invokeLI.intValue;
    }
}
