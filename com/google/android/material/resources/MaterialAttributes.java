package com.google.android.material.resources;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
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

    public static TypedValue resolve(Context context, int i) {
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

    public static int resolveOrThrow(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, view2, i)) == null) {
            return resolveOrThrow(view2.getContext(), i, view2.getClass().getCanonicalName());
        }
        return invokeLI.intValue;
    }

    public static boolean resolveBoolean(Context context, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            TypedValue resolve = resolve(context, i);
            if (resolve != null && resolve.type == 18) {
                if (resolve.data != 0) {
                    return true;
                }
                return false;
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public static int resolveDimension(Context context, int i, int i2) {
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

    public static int resolveOrThrow(Context context, int i, String str) {
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

    public static boolean resolveBooleanOrThrow(Context context, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, context, i, str)) == null) {
            if (resolveOrThrow(context, i, str) != 0) {
                return true;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static int resolveMinimumAccessibleTouchTarget(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            return resolveDimension(context, R.attr.obfuscated_res_0x7f0404d2, R.dimen.obfuscated_res_0x7f0704b9);
        }
        return invokeL.intValue;
    }
}
