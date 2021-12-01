package com.facebook.drawee.drawable;

import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class DrawableUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DrawableUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Nullable
    public static Drawable cloneDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, drawable)) == null) {
            if (drawable instanceof CloneableDrawable) {
                return ((CloneableDrawable) drawable).cloneDrawable();
            }
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                return constantState.newDrawable();
            }
            return null;
        }
        return (Drawable) invokeL.objValue;
    }

    public static void copyProperties(@Nullable Drawable drawable, @Nullable Drawable drawable2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, drawable, drawable2) == null) || drawable2 == null || drawable == null || drawable == drawable2) {
            return;
        }
        drawable.setBounds(drawable2.getBounds());
        drawable.setChangingConfigurations(drawable2.getChangingConfigurations());
        drawable.setLevel(drawable2.getLevel());
        drawable.setVisible(drawable2.isVisible(), false);
        drawable.setState(drawable2.getState());
    }

    public static int getOpacityFromColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            int i3 = i2 >>> 24;
            if (i3 == 255) {
                return -1;
            }
            return i3 == 0 ? -2 : -3;
        }
        return invokeI.intValue;
    }

    public static int multiplyColorAlpha(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3)) == null) ? i3 == 255 ? i2 : i3 == 0 ? i2 & 16777215 : (i2 & 16777215) | ((((i2 >>> 24) * (i3 + (i3 >> 7))) >> 8) << 24) : invokeII.intValue;
    }

    public static void setCallbacks(@Nullable Drawable drawable, @Nullable Drawable.Callback callback, @Nullable TransformCallback transformCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65541, null, drawable, callback, transformCallback) == null) || drawable == null) {
            return;
        }
        drawable.setCallback(callback);
        if (drawable instanceof TransformAwareDrawable) {
            ((TransformAwareDrawable) drawable).setTransformCallback(transformCallback);
        }
    }

    public static void setDrawableProperties(@Nullable Drawable drawable, @Nullable DrawableProperties drawableProperties) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, drawable, drawableProperties) == null) || drawable == null || drawableProperties == null) {
            return;
        }
        drawableProperties.applyTo(drawable);
    }
}
