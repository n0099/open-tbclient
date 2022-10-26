package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class MaterialResources {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MaterialResources() {
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

    public static ColorStateList getColorStateList(Context context, TypedArray typedArray, int i) {
        InterceptResult invokeLLI;
        int color;
        int resourceId;
        ColorStateList colorStateList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, context, typedArray, i)) == null) {
            if (typedArray.hasValue(i) && (resourceId = typedArray.getResourceId(i, 0)) != 0 && (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) != null) {
                return colorStateList;
            }
            if (Build.VERSION.SDK_INT <= 15 && (color = typedArray.getColor(i, -1)) != -1) {
                return ColorStateList.valueOf(color);
            }
            return typedArray.getColorStateList(i);
        }
        return (ColorStateList) invokeLLI.objValue;
    }

    public static ColorStateList getColorStateList(Context context, TintTypedArray tintTypedArray, int i) {
        InterceptResult invokeLLI;
        int color;
        int resourceId;
        ColorStateList colorStateList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, context, tintTypedArray, i)) == null) {
            if (tintTypedArray.hasValue(i) && (resourceId = tintTypedArray.getResourceId(i, 0)) != 0 && (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) != null) {
                return colorStateList;
            }
            if (Build.VERSION.SDK_INT <= 15 && (color = tintTypedArray.getColor(i, -1)) != -1) {
                return ColorStateList.valueOf(color);
            }
            return tintTypedArray.getColorStateList(i);
        }
        return (ColorStateList) invokeLLI.objValue;
    }

    public static int getDimensionPixelSize(Context context, TypedArray typedArray, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65539, null, context, typedArray, i, i2)) == null) {
            TypedValue typedValue = new TypedValue();
            if (typedArray.getValue(i, typedValue) && typedValue.type == 2) {
                TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i2);
                obtainStyledAttributes.recycle();
                return dimensionPixelSize;
            }
            return typedArray.getDimensionPixelSize(i, i2);
        }
        return invokeLLII.intValue;
    }

    public static Drawable getDrawable(Context context, TypedArray typedArray, int i) {
        InterceptResult invokeLLI;
        int resourceId;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, typedArray, i)) == null) {
            if (typedArray.hasValue(i) && (resourceId = typedArray.getResourceId(i, 0)) != 0 && (drawable = AppCompatResources.getDrawable(context, resourceId)) != null) {
                return drawable;
            }
            return typedArray.getDrawable(i);
        }
        return (Drawable) invokeLLI.objValue;
    }

    public static int getIndexWithValue(TypedArray typedArray, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65541, null, typedArray, i, i2)) == null) {
            if (typedArray.hasValue(i)) {
                return i;
            }
            return i2;
        }
        return invokeLII.intValue;
    }

    public static TextAppearance getTextAppearance(Context context, TypedArray typedArray, int i) {
        InterceptResult invokeLLI;
        int resourceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65542, null, context, typedArray, i)) == null) {
            if (typedArray.hasValue(i) && (resourceId = typedArray.getResourceId(i, 0)) != 0) {
                return new TextAppearance(context, resourceId);
            }
            return null;
        }
        return (TextAppearance) invokeLLI.objValue;
    }
}
