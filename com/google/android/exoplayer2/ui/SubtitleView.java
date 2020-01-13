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
    private boolean mEF;
    private boolean mEG;
    private float mEI;
    private final List<b> mES;
    private int mET;
    private com.google.android.exoplayer2.text.a mEU;
    private List<com.google.android.exoplayer2.text.b> myt;

    public SubtitleView(Context context) {
        this(context, null);
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mES = new ArrayList();
        this.mET = 0;
        this.aAz = 0.0533f;
        this.mEF = true;
        this.mEG = true;
        this.mEU = com.google.android.exoplayer2.text.a.mxJ;
        this.mEI = 0.08f;
    }

    @Override // com.google.android.exoplayer2.text.j
    public void fe(List<com.google.android.exoplayer2.text.b> list) {
        setCues(list);
    }

    public void setCues(List<com.google.android.exoplayer2.text.b> list) {
        if (this.myt != list) {
            this.myt = list;
            int size = list == null ? 0 : list.size();
            while (this.mES.size() < size) {
                this.mES.add(new b(getContext()));
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
        if (this.mET != i || this.aAz != f) {
            this.mET = i;
            this.aAz = f;
            invalidate();
        }
    }

    public void setApplyEmbeddedStyles(boolean z) {
        if (this.mEF != z || this.mEG != z) {
            this.mEF = z;
            this.mEG = z;
            invalidate();
        }
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        if (this.mEG != z) {
            this.mEG = z;
            invalidate();
        }
    }

    public void setUserDefaultStyle() {
        setStyle((v.SDK_INT < 19 || isInEditMode()) ? com.google.android.exoplayer2.text.a.mxJ : getUserCaptionStyleV19());
    }

    public void setStyle(com.google.android.exoplayer2.text.a aVar) {
        if (this.mEU != aVar) {
            this.mEU = aVar;
            invalidate();
        }
    }

    public void setBottomPaddingFraction(float f) {
        if (this.mEI != f) {
            this.mEI = f;
            invalidate();
        }
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        float f;
        int size = this.myt == null ? 0 : this.myt.size();
        int top = getTop();
        int bottom = getBottom();
        int left = getLeft() + getPaddingLeft();
        int paddingTop = top + getPaddingTop();
        int right = getRight() + getPaddingRight();
        int paddingBottom = bottom - getPaddingBottom();
        if (paddingBottom > paddingTop && right > left) {
            if (this.mET == 2) {
                f = this.aAz;
            } else {
                f = this.aAz * (this.mET == 0 ? paddingBottom - paddingTop : bottom - top);
            }
            if (f > 0.0f) {
                for (int i = 0; i < size; i++) {
                    this.mES.get(i).a(this.myt.get(i), this.mEF, this.mEG, this.mEU, f, this.mEI, canvas, left, paddingTop, right, paddingBottom);
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
