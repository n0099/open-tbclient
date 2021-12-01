package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class ThemeEnforcement {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] APPCOMPAT_CHECK_ATTRS;
    public static final String APPCOMPAT_THEME_NAME = "Theme.AppCompat";
    public static final int[] MATERIAL_CHECK_ATTRS;
    public static final String MATERIAL_THEME_NAME = "Theme.MaterialComponents";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1246547074, "Lcom/google/android/material/internal/ThemeEnforcement;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1246547074, "Lcom/google/android/material/internal/ThemeEnforcement;");
                return;
            }
        }
        APPCOMPAT_CHECK_ATTRS = new int[]{R.attr.colorPrimary};
        MATERIAL_CHECK_ATTRS = new int[]{R.attr.colorPrimaryVariant};
    }

    public ThemeEnforcement() {
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

    public static void checkAppCompatTheme(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            checkTheme(context, APPCOMPAT_CHECK_ATTRS, APPCOMPAT_THEME_NAME);
        }
    }

    public static void checkCompatibleTheme(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, context, attributeSet, i2, i3) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeEnforcement, i2, i3);
            boolean z = obtainStyledAttributes.getBoolean(R.styleable.ThemeEnforcement_enforceMaterialTheme, false);
            obtainStyledAttributes.recycle();
            if (z) {
                TypedValue typedValue = new TypedValue();
                if (!context.getTheme().resolveAttribute(R.attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                    checkMaterialTheme(context);
                }
            }
            checkAppCompatTheme(context);
        }
    }

    public static void checkMaterialTheme(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            checkTheme(context, MATERIAL_CHECK_ATTRS, MATERIAL_THEME_NAME);
        }
    }

    public static void checkTextAppearance(@NonNull Context context, AttributeSet attributeSet, @NonNull @StyleableRes int[] iArr, @AttrRes int i2, @StyleRes int i3, @Nullable @StyleableRes int... iArr2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, attributeSet, iArr, Integer.valueOf(i2), Integer.valueOf(i3), iArr2}) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeEnforcement, i2, i3);
            if (!obtainStyledAttributes.getBoolean(R.styleable.ThemeEnforcement_enforceTextAppearance, false)) {
                obtainStyledAttributes.recycle();
                return;
            }
            if (iArr2 != null && iArr2.length != 0) {
                z = isCustomTextAppearanceValid(context, attributeSet, iArr, i2, i3, iArr2);
            } else {
                z = obtainStyledAttributes.getResourceId(R.styleable.ThemeEnforcement_android_textAppearance, -1) != -1;
            }
            obtainStyledAttributes.recycle();
            if (!z) {
                throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
            }
        }
    }

    public static void checkTheme(@NonNull Context context, @NonNull int[] iArr, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, context, iArr, str) == null) || isTheme(context, iArr)) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }

    public static boolean isAppCompatTheme(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? isTheme(context, APPCOMPAT_CHECK_ATTRS) : invokeL.booleanValue;
    }

    public static boolean isCustomTextAppearanceValid(@NonNull Context context, AttributeSet attributeSet, @NonNull @StyleableRes int[] iArr, @AttrRes int i2, @StyleRes int i3, @NonNull @StyleableRes int... iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{context, attributeSet, iArr, Integer.valueOf(i2), Integer.valueOf(i3), iArr2})) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
            for (int i4 : iArr2) {
                if (obtainStyledAttributes.getResourceId(i4, -1) == -1) {
                    obtainStyledAttributes.recycle();
                    return false;
                }
            }
            obtainStyledAttributes.recycle();
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isMaterialTheme(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) ? isTheme(context, MATERIAL_CHECK_ATTRS) : invokeL.booleanValue;
    }

    public static boolean isTheme(@NonNull Context context, @NonNull int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, iArr)) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
            for (int i2 = 0; i2 < iArr.length; i2++) {
                if (!obtainStyledAttributes.hasValue(i2)) {
                    obtainStyledAttributes.recycle();
                    return false;
                }
            }
            obtainStyledAttributes.recycle();
            return true;
        }
        return invokeLL.booleanValue;
    }

    @NonNull
    public static TypedArray obtainStyledAttributes(@NonNull Context context, AttributeSet attributeSet, @NonNull @StyleableRes int[] iArr, @AttrRes int i2, @StyleRes int i3, @StyleableRes int... iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{context, attributeSet, iArr, Integer.valueOf(i2), Integer.valueOf(i3), iArr2})) == null) {
            checkCompatibleTheme(context, attributeSet, i2, i3);
            checkTextAppearance(context, attributeSet, iArr, i2, i3, iArr2);
            return context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        }
        return (TypedArray) invokeCommon.objValue;
    }

    public static TintTypedArray obtainTintedStyledAttributes(@NonNull Context context, AttributeSet attributeSet, @NonNull @StyleableRes int[] iArr, @AttrRes int i2, @StyleRes int i3, @StyleableRes int... iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{context, attributeSet, iArr, Integer.valueOf(i2), Integer.valueOf(i3), iArr2})) == null) {
            checkCompatibleTheme(context, attributeSet, i2, i3);
            checkTextAppearance(context, attributeSet, iArr, i2, i3, iArr2);
            return TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i2, i3);
        }
        return (TintTypedArray) invokeCommon.objValue;
    }
}
