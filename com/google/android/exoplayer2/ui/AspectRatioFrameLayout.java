package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.ui.a;
/* loaded from: classes6.dex */
public final class AspectRatioFrameLayout extends FrameLayout {
    private float mDG;
    private int mDH;

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDH = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.f.AspectRatioFrameLayout, 0, 0);
            try {
                this.mDH = obtainStyledAttributes.getInt(a.f.AspectRatioFrameLayout_resize_mode, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setAspectRatio(float f) {
        if (this.mDG != f) {
            this.mDG = f;
            requestLayout();
        }
    }

    public int getResizeMode() {
        return this.mDH;
    }

    public void setResizeMode(int i) {
        if (this.mDH != i) {
            this.mDH = i;
            requestLayout();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mDH != 3 && this.mDG > 0.0f) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float f = (this.mDG / (measuredWidth / measuredHeight)) - 1.0f;
            if (Math.abs(f) > 0.01f) {
                switch (this.mDH) {
                    case 1:
                        measuredHeight = (int) (measuredWidth / this.mDG);
                        break;
                    case 2:
                        measuredWidth = (int) (measuredHeight * this.mDG);
                        break;
                    case 3:
                    default:
                        if (f > 0.0f) {
                            measuredHeight = (int) (measuredWidth / this.mDG);
                            break;
                        } else {
                            measuredWidth = (int) (measuredHeight * this.mDG);
                            break;
                        }
                    case 4:
                        if (f > 0.0f) {
                            measuredWidth = (int) (measuredHeight * this.mDG);
                            break;
                        } else {
                            measuredHeight = (int) (measuredWidth / this.mDG);
                            break;
                        }
                }
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            }
        }
    }
}
