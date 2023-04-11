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
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public class MaterialDialogs {
    @NonNull
    public static Rect getDialogBackgroundInsets(@NonNull Context context, @AttrRes int i, int i2) {
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

    @NonNull
    public static InsetDrawable insetDrawable(@Nullable Drawable drawable, @NonNull Rect rect) {
        return new InsetDrawable(drawable, rect.left, rect.top, rect.right, rect.bottom);
    }
}
