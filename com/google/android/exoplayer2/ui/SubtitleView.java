package com.google.android.exoplayer2.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.text.j;
import com.google.android.exoplayer2.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class SubtitleView extends View implements j {
    private float aAz;
    private boolean mEK;
    private boolean mEL;
    private float mEN;
    private final List<b> mEX;
    private int mEY;
    private com.google.android.exoplayer2.text.a mEZ;
    private List<com.google.android.exoplayer2.text.b> myy;

    public SubtitleView(Context context) {
        this(context, null);
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mEX = new ArrayList();
        this.mEY = 0;
        this.aAz = 0.0533f;
        this.mEK = true;
        this.mEL = true;
        this.mEZ = com.google.android.exoplayer2.text.a.mxO;
        this.mEN = 0.08f;
    }

    @Override // com.google.android.exoplayer2.text.j
    public void fe(List<com.google.android.exoplayer2.text.b> list) {
        setCues(list);
    }

    public void setCues(List<com.google.android.exoplayer2.text.b> list) {
        if (this.myy != list) {
            this.myy = list;
            int size = list == null ? 0 : list.size();
            while (this.mEX.size() < size) {
                this.mEX.add(new b(getContext()));
            }
            invalidate();
        }
    }

    public void setFixedTextSize(int i, float f) {
        Resources resources;
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        setTextSize(2, TypedValue.applyDimension(i, f, resources.getDisplayMetrics()));
    }

    public void setUserDefaultTextSize() {
        setFractionalTextSize(((v.SDK_INT < 19 || isInEditMode()) ? 1.0f : getUserCaptionFontScaleV19()) * 0.0533f);
    }

    public void setFractionalTextSize(float f) {
        setFractionalTextSize(f, false);
    }

    public void setFractionalTextSize(float f, boolean z) {
        setTextSize(z ? 1 : 0, f);
    }

    private void setTextSize(int i, float f) {
        if (this.mEY != i || this.aAz != f) {
            this.mEY = i;
            this.aAz = f;
            invalidate();
        }
    }

    public void setApplyEmbeddedStyles(boolean z) {
        if (this.mEK != z || this.mEL != z) {
            this.mEK = z;
            this.mEL = z;
            invalidate();
        }
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        if (this.mEL != z) {
            this.mEL = z;
            invalidate();
        }
    }

    public void setUserDefaultStyle() {
        setStyle((v.SDK_INT < 19 || isInEditMode()) ? com.google.android.exoplayer2.text.a.mxO : getUserCaptionStyleV19());
    }

    public void setStyle(com.google.android.exoplayer2.text.a aVar) {
        if (this.mEZ != aVar) {
            this.mEZ = aVar;
            invalidate();
        }
    }

    public void setBottomPaddingFraction(float f) {
        if (this.mEN != f) {
            this.mEN = f;
            invalidate();
        }
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        float f;
        int size = this.myy == null ? 0 : this.myy.size();
        int top = getTop();
        int bottom = getBottom();
        int left = getLeft() + getPaddingLeft();
        int paddingTop = top + getPaddingTop();
        int right = getRight() + getPaddingRight();
        int paddingBottom = bottom - getPaddingBottom();
        if (paddingBottom > paddingTop && right > left) {
            if (this.mEY == 2) {
                f = this.aAz;
            } else {
                f = this.aAz * (this.mEY == 0 ? paddingBottom - paddingTop : bottom - top);
            }
            if (f > 0.0f) {
                for (int i = 0; i < size; i++) {
                    this.mEX.get(i).a(this.myy.get(i), this.mEK, this.mEL, this.mEZ, f, this.mEN, canvas, left, paddingTop, right, paddingBottom);
                }
            }
        }
    }

    @TargetApi(19)
    private float getUserCaptionFontScaleV19() {
        return ((CaptioningManager) getContext().getSystemService("captioning")).getFontScale();
    }

    @TargetApi(19)
    private com.google.android.exoplayer2.text.a getUserCaptionStyleV19() {
        return com.google.android.exoplayer2.text.a.a(((CaptioningManager) getContext().getSystemService("captioning")).getUserStyle());
    }
}
