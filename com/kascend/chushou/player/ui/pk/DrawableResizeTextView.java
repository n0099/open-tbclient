package com.kascend.chushou.player.ui.pk;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.util.AttributeSet;
import com.kascend.chushou.a;
/* loaded from: classes4.dex */
public class DrawableResizeTextView extends AppCompatCheckedTextView {
    public DrawableResizeTextView(Context context) {
        this(context, null);
    }

    public DrawableResizeTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawableResizeTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.ShowDrawableResizeTextView);
        Drawable[] compoundDrawables = getCompoundDrawables();
        Drawable drawable = compoundDrawables[0];
        Drawable drawable2 = compoundDrawables[1];
        Drawable drawable3 = compoundDrawables[2];
        Drawable drawable4 = compoundDrawables[3];
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(a.k.ShowDrawableResizeTextView_drawLeftWidth, drawable != null ? drawable.getIntrinsicWidth() : -1);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(a.k.ShowDrawableResizeTextView_drawLeftHeight, drawable != null ? drawable.getIntrinsicHeight() : -1);
        if (drawable != null) {
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize2);
        }
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(a.k.ShowDrawableResizeTextView_drawTopWidth, drawable2 != null ? drawable2.getIntrinsicWidth() : -1);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(a.k.ShowDrawableResizeTextView_drawTopHeight, drawable2 != null ? drawable2.getIntrinsicWidth() : -1);
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, dimensionPixelSize3, dimensionPixelSize4);
        }
        int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(a.k.ShowDrawableResizeTextView_drawRightWidth, drawable3 != null ? drawable3.getIntrinsicWidth() : -1);
        int dimensionPixelSize6 = obtainStyledAttributes.getDimensionPixelSize(a.k.ShowDrawableResizeTextView_drawRightHeight, drawable3 != null ? drawable3.getIntrinsicWidth() : -1);
        if (drawable3 != null) {
            drawable3.setBounds(0, 0, dimensionPixelSize5, dimensionPixelSize6);
        }
        int dimensionPixelSize7 = obtainStyledAttributes.getDimensionPixelSize(a.k.ShowDrawableResizeTextView_drawBottomWidth, drawable4 != null ? drawable4.getIntrinsicWidth() : -1);
        int dimensionPixelSize8 = obtainStyledAttributes.getDimensionPixelSize(a.k.ShowDrawableResizeTextView_drawBottomHeight, drawable4 != null ? drawable4.getIntrinsicWidth() : -1);
        if (drawable4 != null) {
            drawable4.setBounds(0, 0, dimensionPixelSize7, dimensionPixelSize8);
        }
        setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        obtainStyledAttributes.recycle();
    }
}
