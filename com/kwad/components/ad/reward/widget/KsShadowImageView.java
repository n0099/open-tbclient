package com.kwad.components.ad.reward.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes10.dex */
public class KsShadowImageView extends ImageView {
    public Paint AT;
    public BlurMaskFilter AU;
    public int AV;
    public boolean AW;
    public boolean AX;
    public boolean AY;
    public boolean AZ;
    public Rect Ba;
    @ColorInt
    public int Bb;

    public KsShadowImageView(Context context) {
        super(context);
        this.AZ = true;
        a(context, null, 0);
    }

    public KsShadowImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.AZ = true;
        a(context, attributeSet, 0);
    }

    public KsShadowImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.AZ = true;
        a(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public KsShadowImageView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.AZ = true;
        a(context, attributeSet, i);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet, int i) {
        this.AT = new Paint();
        this.AU = new BlurMaskFilter(50.0f, BlurMaskFilter.Blur.OUTER);
        this.Ba = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShadowImageView, i, 0);
        this.AV = obtainStyledAttributes.getDimensionPixelSize(5, 20);
        this.Bb = obtainStyledAttributes.getColor(4, Color.parseColor("#33000000"));
        this.AW = obtainStyledAttributes.getBoolean(1, true);
        this.AX = obtainStyledAttributes.getBoolean(2, true);
        this.AY = obtainStyledAttributes.getBoolean(3, true);
        this.AZ = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        super.onDraw(canvas);
        this.AT.setMaskFilter(this.AU);
        this.AT.setColor(this.Bb);
        this.AT.setStyle(Paint.Style.FILL);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        Rect rect = this.Ba;
        int i4 = 0;
        if (this.AW) {
            i = this.AV;
        } else {
            i = 0;
        }
        rect.left = i;
        Rect rect2 = this.Ba;
        if (this.AY) {
            i2 = this.AV;
        } else {
            i2 = 0;
        }
        rect2.top = i2;
        Rect rect3 = this.Ba;
        if (this.AX) {
            i3 = this.AV;
        } else {
            i3 = 0;
        }
        rect3.right = measuredWidth - i3;
        Rect rect4 = this.Ba;
        if (this.AZ) {
            i4 = this.AV;
        }
        rect4.bottom = measuredHeight - i4;
        canvas.drawRect(this.Ba, this.AT);
    }
}
