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
    private float aEQ;
    private final List<b> mFG;
    private int mFH;
    private com.google.android.exoplayer2.text.a mFI;
    private boolean mFt;
    private boolean mFu;
    private float mFw;
    private List<com.google.android.exoplayer2.text.b> mzg;

    public SubtitleView(Context context) {
        this(context, null);
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFG = new ArrayList();
        this.mFH = 0;
        this.aEQ = 0.0533f;
        this.mFt = true;
        this.mFu = true;
        this.mFI = com.google.android.exoplayer2.text.a.myw;
        this.mFw = 0.08f;
    }

    @Override // com.google.android.exoplayer2.text.j
    public void eZ(List<com.google.android.exoplayer2.text.b> list) {
        setCues(list);
    }

    public void setCues(List<com.google.android.exoplayer2.text.b> list) {
        if (this.mzg != list) {
            this.mzg = list;
            int size = list == null ? 0 : list.size();
            while (this.mFG.size() < size) {
                this.mFG.add(new b(getContext()));
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
        if (this.mFH != i || this.aEQ != f) {
            this.mFH = i;
            this.aEQ = f;
            invalidate();
        }
    }

    public void setApplyEmbeddedStyles(boolean z) {
        if (this.mFt != z || this.mFu != z) {
            this.mFt = z;
            this.mFu = z;
            invalidate();
        }
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        if (this.mFu != z) {
            this.mFu = z;
            invalidate();
        }
    }

    public void setUserDefaultStyle() {
        setStyle((v.SDK_INT < 19 || isInEditMode()) ? com.google.android.exoplayer2.text.a.myw : getUserCaptionStyleV19());
    }

    public void setStyle(com.google.android.exoplayer2.text.a aVar) {
        if (this.mFI != aVar) {
            this.mFI = aVar;
            invalidate();
        }
    }

    public void setBottomPaddingFraction(float f) {
        if (this.mFw != f) {
            this.mFw = f;
            invalidate();
        }
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        float f;
        int size = this.mzg == null ? 0 : this.mzg.size();
        int top2 = getTop();
        int bottom = getBottom();
        int left = getLeft() + getPaddingLeft();
        int paddingTop = top2 + getPaddingTop();
        int right = getRight() + getPaddingRight();
        int paddingBottom = bottom - getPaddingBottom();
        if (paddingBottom > paddingTop && right > left) {
            if (this.mFH == 2) {
                f = this.aEQ;
            } else {
                f = this.aEQ * (this.mFH == 0 ? paddingBottom - paddingTop : bottom - top2);
            }
            if (f > 0.0f) {
                for (int i = 0; i < size; i++) {
                    this.mFG.get(i).a(this.mzg.get(i), this.mFt, this.mFu, this.mFI, f, this.mFw, canvas, left, paddingTop, right, paddingBottom);
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
