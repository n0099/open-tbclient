package com.google.android.material.theme.overlay;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
/* loaded from: classes10.dex */
public class MaterialThemeOverlay {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] ANDROID_THEME_OVERLAY_ATTRS;
    public static final int[] MATERIAL_THEME_OVERLAY_ATTR;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2025931268, "Lcom/google/android/material/theme/overlay/MaterialThemeOverlay;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2025931268, "Lcom/google/android/material/theme/overlay/MaterialThemeOverlay;");
                return;
            }
        }
        ANDROID_THEME_OVERLAY_ATTRS = new int[]{16842752, R.attr.theme};
        MATERIAL_THEME_OVERLAY_ATTR = new int[]{R.attr.materialThemeOverlay};
    }

    public MaterialThemeOverlay() {
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

    @StyleRes
    public static int obtainAndroidThemeOverlayId(@NonNull Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, attributeSet)) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ANDROID_THEME_OVERLAY_ATTRS);
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
            obtainStyledAttributes.recycle();
            return resourceId != 0 ? resourceId : resourceId2;
        }
        return invokeLL.intValue;
    }

    @StyleRes
    public static int obtainMaterialThemeOverlayId(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65539, null, context, attributeSet, i2, i3)) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, MATERIAL_THEME_OVERLAY_ATTR, i2, i3);
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            obtainStyledAttributes.recycle();
            return resourceId;
        }
        return invokeLLII.intValue;
    }

    @NonNull
    public static Context wrap(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(InputDeviceCompat.SOURCE_TRACKBALL, null, context, attributeSet, i2, i3)) == null) {
            int obtainMaterialThemeOverlayId = obtainMaterialThemeOverlayId(context, attributeSet, i2, i3);
            boolean z = (context instanceof ContextThemeWrapper) && ((ContextThemeWrapper) context).getThemeResId() == obtainMaterialThemeOverlayId;
            if (obtainMaterialThemeOverlayId == 0 || z) {
                return context;
            }
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, obtainMaterialThemeOverlayId);
            int obtainAndroidThemeOverlayId = obtainAndroidThemeOverlayId(context, attributeSet);
            if (obtainAndroidThemeOverlayId != 0) {
                contextThemeWrapper.getTheme().applyStyle(obtainAndroidThemeOverlayId, true);
            }
            return contextThemeWrapper;
        }
        return (Context) invokeLLII.objValue;
    }
}
