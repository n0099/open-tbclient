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
/* loaded from: classes4.dex */
public final class SubtitleView extends View implements j {
    private float azO;
    private boolean mAN;
    private boolean mAO;
    private float mAQ;
    private final List<b> mBa;
    private int mBb;
    private com.google.android.exoplayer2.text.a mBc;
    private List<com.google.android.exoplayer2.text.b> muG;

    public SubtitleView(Context context) {
        this(context, null);
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBa = new ArrayList();
        this.mBb = 0;
        this.azO = 0.0533f;
        this.mAN = true;
        this.mAO = true;
        this.mBc = com.google.android.exoplayer2.text.a.mtW;
        this.mAQ = 0.08f;
    }

    @Override // com.google.android.exoplayer2.text.j
    public void fe(List<com.google.android.exoplayer2.text.b> list) {
        setCues(list);
    }

    public void setCues(List<com.google.android.exoplayer2.text.b> list) {
        if (this.muG != list) {
            this.muG = list;
            int size = list == null ? 0 : list.size();
            while (this.mBa.size() < size) {
                this.mBa.add(new b(getContext()));
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
        if (this.mBb != i || this.azO != f) {
            this.mBb = i;
            this.azO = f;
            invalidate();
        }
    }

    public void setApplyEmbeddedStyles(boolean z) {
        if (this.mAN != z || this.mAO != z) {
            this.mAN = z;
            this.mAO = z;
            invalidate();
        }
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        if (this.mAO != z) {
            this.mAO = z;
            invalidate();
        }
    }

    public void setUserDefaultStyle() {
        setStyle((v.SDK_INT < 19 || isInEditMode()) ? com.google.android.exoplayer2.text.a.mtW : getUserCaptionStyleV19());
    }

    public void setStyle(com.google.android.exoplayer2.text.a aVar) {
        if (this.mBc != aVar) {
            this.mBc = aVar;
            invalidate();
        }
    }

    public void setBottomPaddingFraction(float f) {
        if (this.mAQ != f) {
            this.mAQ = f;
            invalidate();
        }
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        float f;
        int size = this.muG == null ? 0 : this.muG.size();
        int top = getTop();
        int bottom = getBottom();
        int left = getLeft() + getPaddingLeft();
        int paddingTop = top + getPaddingTop();
        int right = getRight() + getPaddingRight();
        int paddingBottom = bottom - getPaddingBottom();
        if (paddingBottom > paddingTop && right > left) {
            if (this.mBb == 2) {
                f = this.azO;
            } else {
                f = this.azO * (this.mBb == 0 ? paddingBottom - paddingTop : bottom - top);
            }
            if (f > 0.0f) {
                for (int i = 0; i < size; i++) {
                    this.mBa.get(i).a(this.muG.get(i), this.mAN, this.mAO, this.mBc, f, this.mAQ, canvas, left, paddingTop, right, paddingBottom);
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
