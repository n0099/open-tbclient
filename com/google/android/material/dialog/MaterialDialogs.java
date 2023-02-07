package com.google.android.material.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes7.dex */
public class MaterialDialogs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MaterialDialogs() {
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

    @NonNull
    public static Rect getDialogBackgroundInsets(@NonNull Context context, @AttrRes int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, context, i, i2)) == null) {
            TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, null, R.styleable.MaterialAlertDialog, i, i2, new int[0]);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(2, context.getResources().getDimensionPixelSize(com.baidu.tieba.R.dimen.obfuscated_res_0x7f070435));
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(3, context.getResources().getDimensionPixelSize(com.baidu.tieba.R.dimen.obfuscated_res_0x7f070436));
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(1, context.getResources().getDimensionPixelSize(com.baidu.tieba.R.dimen.obfuscated_res_0x7f070434));
            int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(0, context.getResources().getDimensionPixelSize(com.baidu.tieba.R.dimen.obfuscated_res_0x7f070433));
            obtainStyledAttributes.recycle();
            if (Build.VERSION.SDK_INT >= 17 && context.getResources().getConfiguration().getLayoutDirection() == 1) {
                dimensionPixelSize3 = dimensionPixelSize;
                dimensionPixelSize = dimensionPixelSize3;
            }
            return new Rect(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
        }
        return (Rect) invokeLII.objValue;
    }

    @NonNull
    public static InsetDrawable insetDrawable(@Nullable Drawable drawable, @NonNull Rect rect) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, drawable, rect)) == null) {
            return new InsetDrawable(drawable, rect.left, rect.top, rect.right, rect.bottom);
        }
        return (InsetDrawable) invokeLL.objValue;
    }
}
