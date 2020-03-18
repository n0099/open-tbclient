package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.ui.a;
/* loaded from: classes6.dex */
public final class AspectRatioFrameLayout extends FrameLayout {
    private float mFn;
    private int mFo;

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFo = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.f.AspectRatioFrameLayout, 0, 0);
            try {
                this.mFo = obtainStyledAttributes.getInt(a.f.AspectRatioFrameLayout_resize_mode, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setAspectRatio(float f) {
        if (this.mFn != f) {
            this.mFn = f;
            requestLayout();
        }
    }

    public int getResizeMode() {
        return this.mFo;
    }

    public void setResizeMode(int i) {
        if (this.mFo != i) {
            this.mFo = i;
            requestLayout();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mFo != 3 && this.mFn > 0.0f) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float f = (this.mFn / (measuredWidth / measuredHeight)) - 1.0f;
            if (Math.abs(f) > 0.01f) {
                switch (this.mFo) {
                    case 1:
                        measuredHeight = (int) (measuredWidth / this.mFn);
                        break;
                    case 2:
                        measuredWidth = (int) (measuredHeight * this.mFn);
                        break;
                    case 3:
                    default:
                        if (f > 0.0f) {
                            measuredHeight = (int) (measuredWidth / this.mFn);
                            break;
                        } else {
                            measuredWidth = (int) (measuredHeight * this.mFn);
                            break;
                        }
                    case 4:
                        if (f > 0.0f) {
                            measuredWidth = (int) (measuredHeight * this.mFn);
                            break;
                        } else {
                            measuredHeight = (int) (measuredWidth / this.mFn);
                            break;
                        }
                }
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            }
        }
    }
}
