package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import androidx.appcompat.content.res.AppCompatResources;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes15.dex */
public class MaterialResources {
    private MaterialResources() {
    }

    @Nullable
    public static ColorStateList getColorStateList(Context context, TypedArray typedArray, @StyleableRes int i) {
        int resourceId;
        ColorStateList colorStateList;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateList;
    }

    @Nullable
    public static Drawable getDrawable(Context context, TypedArray typedArray, @StyleableRes int i) {
        int resourceId;
        Drawable drawable;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (drawable = AppCompatResources.getDrawable(context, resourceId)) == null) ? typedArray.getDrawable(i) : drawable;
    }

    @Nullable
    public static TextAppearance getTextAppearance(Context context, TypedArray typedArray, @StyleableRes int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return new TextAppearance(context, resourceId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @StyleableRes
    public static int getIndexWithValue(TypedArray typedArray, @StyleableRes int i, @StyleableRes int i2) {
        return typedArray.hasValue(i) ? i : i2;
    }
}
