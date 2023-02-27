package com.google.android.exoplayer2.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.text.CaptionStyleCompat;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class SubtitleView extends View implements TextOutput {
    public static final int ABSOLUTE = 2;
    public static final float DEFAULT_BOTTOM_PADDING_FRACTION = 0.08f;
    public static final float DEFAULT_TEXT_SIZE_FRACTION = 0.0533f;
    public static final int FRACTIONAL = 0;
    public static final int FRACTIONAL_IGNORE_PADDING = 1;
    public boolean applyEmbeddedFontSizes;
    public boolean applyEmbeddedStyles;
    public float bottomPaddingFraction;
    public List<Cue> cues;
    public final List<SubtitlePainter> painters;
    public CaptionStyleCompat style;
    public float textSize;
    public int textSizeType;

    public SubtitleView(Context context) {
        this(context, null);
    }

    @Override // com.google.android.exoplayer2.text.TextOutput
    public void onCues(List<Cue> list) {
        setCues(list);
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        if (this.applyEmbeddedFontSizes == z) {
            return;
        }
        this.applyEmbeddedFontSizes = z;
        invalidate();
    }

    public void setApplyEmbeddedStyles(boolean z) {
        if (this.applyEmbeddedStyles == z && this.applyEmbeddedFontSizes == z) {
            return;
        }
        this.applyEmbeddedStyles = z;
        this.applyEmbeddedFontSizes = z;
        invalidate();
    }

    public void setBottomPaddingFraction(float f) {
        if (this.bottomPaddingFraction == f) {
            return;
        }
        this.bottomPaddingFraction = f;
        invalidate();
    }

    public void setCues(List<Cue> list) {
        int size;
        if (this.cues == list) {
            return;
        }
        this.cues = list;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        while (this.painters.size() < size) {
            this.painters.add(new SubtitlePainter(getContext()));
        }
        invalidate();
    }

    public void setFractionalTextSize(float f) {
        setFractionalTextSize(f, false);
    }

    public void setStyle(CaptionStyleCompat captionStyleCompat) {
        if (this.style == captionStyleCompat) {
            return;
        }
        this.style = captionStyleCompat;
        invalidate();
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.painters = new ArrayList();
        this.textSizeType = 0;
        this.textSize = 0.0533f;
        this.applyEmbeddedStyles = true;
        this.applyEmbeddedFontSizes = true;
        this.style = CaptionStyleCompat.DEFAULT;
        this.bottomPaddingFraction = 0.08f;
    }

    private void setTextSize(int i, float f) {
        if (this.textSizeType == i && this.textSize == f) {
            return;
        }
        this.textSizeType = i;
        this.textSize = f;
        invalidate();
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

    public void setFractionalTextSize(float f, boolean z) {
        setTextSize(z ? 1 : 0, f);
    }

    @TargetApi(19)
    private float getUserCaptionFontScaleV19() {
        return ((CaptioningManager) getContext().getSystemService("captioning")).getFontScale();
    }

    @TargetApi(19)
    private CaptionStyleCompat getUserCaptionStyleV19() {
        return CaptionStyleCompat.createFromCaptionStyle(((CaptioningManager) getContext().getSystemService("captioning")).getUserStyle());
    }

    public void setUserDefaultStyle() {
        CaptionStyleCompat captionStyleCompat;
        if (Util.SDK_INT >= 19 && !isInEditMode()) {
            captionStyleCompat = getUserCaptionStyleV19();
        } else {
            captionStyleCompat = CaptionStyleCompat.DEFAULT;
        }
        setStyle(captionStyleCompat);
    }

    public void setUserDefaultTextSize() {
        float f;
        if (Util.SDK_INT >= 19 && !isInEditMode()) {
            f = getUserCaptionFontScaleV19();
        } else {
            f = 1.0f;
        }
        setFractionalTextSize(f * 0.0533f);
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        int size;
        int i;
        float f;
        List<Cue> list = this.cues;
        int i2 = 0;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        int top = getTop();
        int bottom = getBottom();
        int left = getLeft() + getPaddingLeft();
        int paddingTop = getPaddingTop() + top;
        int right = getRight() + getPaddingRight();
        int paddingBottom = bottom - getPaddingBottom();
        if (paddingBottom > paddingTop && right > left) {
            int i3 = this.textSizeType;
            if (i3 == 2) {
                f = this.textSize;
            } else {
                float f2 = this.textSize;
                if (i3 == 0) {
                    i = paddingBottom - paddingTop;
                } else {
                    i = bottom - top;
                }
                f = i * f2;
            }
            if (f <= 0.0f) {
                return;
            }
            while (i2 < size) {
                int i4 = paddingBottom;
                int i5 = right;
                this.painters.get(i2).draw(this.cues.get(i2), this.applyEmbeddedStyles, this.applyEmbeddedFontSizes, this.style, f, this.bottomPaddingFraction, canvas, left, paddingTop, i5, i4);
                i2++;
                paddingBottom = i4;
                right = i5;
            }
        }
    }
}
