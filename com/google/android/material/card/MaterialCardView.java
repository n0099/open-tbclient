package com.google.android.material.card;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.cardview.widget.CardView;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
/* loaded from: classes6.dex */
public class MaterialCardView extends CardView {
    public final MaterialCardViewHelper cardViewHelper;

    public MaterialCardView(Context context) {
        this(context, null);
    }

    @ColorInt
    public int getStrokeColor() {
        return this.cardViewHelper.getStrokeColor();
    }

    @Dimension
    public int getStrokeWidth() {
        return this.cardViewHelper.getStrokeWidth();
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f2) {
        super.setRadius(f2);
        this.cardViewHelper.updateForeground();
    }

    public void setStrokeColor(@ColorInt int i) {
        this.cardViewHelper.setStrokeColor(i);
    }

    public void setStrokeWidth(@Dimension int i) {
        this.cardViewHelper.setStrokeWidth(i);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialCardViewStyle);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.MaterialCardView, i, R.style.Widget_MaterialComponents_CardView, new int[0]);
        MaterialCardViewHelper materialCardViewHelper = new MaterialCardViewHelper(this);
        this.cardViewHelper = materialCardViewHelper;
        materialCardViewHelper.loadFromAttributes(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
