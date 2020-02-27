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
/* loaded from: classes6.dex */
public final class SubtitleView extends View implements j {
    private float aEP;
    private final List<b> mFE;
    private int mFF;
    private com.google.android.exoplayer2.text.a mFG;
    private boolean mFr;
    private boolean mFs;
    private float mFu;
    private List<com.google.android.exoplayer2.text.b> mze;

    public SubtitleView(Context context) {
        this(context, null);
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFE = new ArrayList();
        this.mFF = 0;
        this.aEP = 0.0533f;
        this.mFr = true;
        this.mFs = true;
        this.mFG = com.google.android.exoplayer2.text.a.myu;
        this.mFu = 0.08f;
    }

    @Override // com.google.android.exoplayer2.text.j
    public void eZ(List<com.google.android.exoplayer2.text.b> list) {
        setCues(list);
    }

    public void setCues(List<com.google.android.exoplayer2.text.b> list) {
        if (this.mze != list) {
            this.mze = list;
            int size = list == null ? 0 : list.size();
            while (this.mFE.size() < size) {
                this.mFE.add(new b(getContext()));
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
        if (this.mFF != i || this.aEP != f) {
            this.mFF = i;
            this.aEP = f;
            invalidate();
        }
    }

    public void setApplyEmbeddedStyles(boolean z) {
        if (this.mFr != z || this.mFs != z) {
            this.mFr = z;
            this.mFs = z;
            invalidate();
        }
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        if (this.mFs != z) {
            this.mFs = z;
            invalidate();
        }
    }

    public void setUserDefaultStyle() {
        setStyle((v.SDK_INT < 19 || isInEditMode()) ? com.google.android.exoplayer2.text.a.myu : getUserCaptionStyleV19());
    }

    public void setStyle(com.google.android.exoplayer2.text.a aVar) {
        if (this.mFG != aVar) {
            this.mFG = aVar;
            invalidate();
        }
    }

    public void setBottomPaddingFraction(float f) {
        if (this.mFu != f) {
            this.mFu = f;
            invalidate();
        }
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        float f;
        int size = this.mze == null ? 0 : this.mze.size();
        int top2 = getTop();
        int bottom = getBottom();
        int left = getLeft() + getPaddingLeft();
        int paddingTop = top2 + getPaddingTop();
        int right = getRight() + getPaddingRight();
        int paddingBottom = bottom - getPaddingBottom();
        if (paddingBottom > paddingTop && right > left) {
            if (this.mFF == 2) {
                f = this.aEP;
            } else {
                f = this.aEP * (this.mFF == 0 ? paddingBottom - paddingTop : bottom - top2);
            }
            if (f > 0.0f) {
                for (int i = 0; i < size; i++) {
                    this.mFE.get(i).a(this.mze.get(i), this.mFr, this.mFs, this.mFG, f, this.mFu, canvas, left, paddingTop, right, paddingBottom);
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
