package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import com.google.android.exoplayer2.text.CaptionStyleCompat;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Util;
/* loaded from: classes7.dex */
public final class SubtitlePainter {
    public static final float INNER_PADDING_RATIO = 0.125f;
    public static final String TAG = "SubtitlePainter";
    public boolean applyEmbeddedFontSizes;
    public boolean applyEmbeddedStyles;
    public int backgroundColor;
    public Rect bitmapRect;
    public float bottomPaddingFraction;
    public final float cornerRadius;
    public Bitmap cueBitmap;
    public float cueBitmapHeight;
    public float cueLine;
    public int cueLineAnchor;
    public int cueLineType;
    public float cuePosition;
    public int cuePositionAnchor;
    public float cueSize;
    public CharSequence cueText;
    public Layout.Alignment cueTextAlignment;
    public int edgeColor;
    public int edgeType;
    public int foregroundColor;
    public final RectF lineBounds = new RectF();
    public final float outlineWidth;
    public final Paint paint;
    public int parentBottom;
    public int parentLeft;
    public int parentRight;
    public int parentTop;
    public final float shadowOffset;
    public final float shadowRadius;
    public final float spacingAdd;
    public final float spacingMult;
    public StaticLayout textLayout;
    public int textLeft;
    public int textPaddingX;
    public final TextPaint textPaint;
    public float textSizePx;
    public int textTop;
    public int windowColor;

    public SubtitlePainter(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16843287, 16843288}, 0, 0);
        this.spacingAdd = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.spacingMult = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.cornerRadius = round;
        this.outlineWidth = round;
        this.shadowRadius = round;
        this.shadowOffset = round;
        TextPaint textPaint = new TextPaint();
        this.textPaint = textPaint;
        textPaint.setAntiAlias(true);
        this.textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL);
    }

    public static boolean areCharSequencesEqual(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != charSequence2 && (charSequence == null || !charSequence.equals(charSequence2))) {
            return false;
        }
        return true;
    }

    private void drawLayout(Canvas canvas, boolean z) {
        if (z) {
            drawTextLayout(canvas);
        } else {
            drawBitmapLayout(canvas);
        }
    }

    private void drawBitmapLayout(Canvas canvas) {
        canvas.drawBitmap(this.cueBitmap, (Rect) null, this.bitmapRect, (Paint) null);
    }

    private void drawTextLayout(Canvas canvas) {
        int i;
        StaticLayout staticLayout = this.textLayout;
        if (staticLayout == null) {
            return;
        }
        int save = canvas.save();
        canvas.translate(this.textLeft, this.textTop);
        if (Color.alpha(this.windowColor) > 0) {
            this.paint.setColor(this.windowColor);
            canvas.drawRect(-this.textPaddingX, 0.0f, staticLayout.getWidth() + this.textPaddingX, staticLayout.getHeight(), this.paint);
        }
        if (Color.alpha(this.backgroundColor) > 0) {
            this.paint.setColor(this.backgroundColor);
            float lineTop = staticLayout.getLineTop(0);
            int lineCount = staticLayout.getLineCount();
            int i2 = 0;
            while (i2 < lineCount) {
                this.lineBounds.left = staticLayout.getLineLeft(i2) - this.textPaddingX;
                this.lineBounds.right = staticLayout.getLineRight(i2) + this.textPaddingX;
                RectF rectF = this.lineBounds;
                rectF.top = lineTop;
                rectF.bottom = staticLayout.getLineBottom(i2);
                RectF rectF2 = this.lineBounds;
                float f = rectF2.bottom;
                float f2 = this.cornerRadius;
                canvas.drawRoundRect(rectF2, f2, f2, this.paint);
                i2++;
                lineTop = f;
            }
        }
        int i3 = this.edgeType;
        boolean z = true;
        if (i3 == 1) {
            this.textPaint.setStrokeJoin(Paint.Join.ROUND);
            this.textPaint.setStrokeWidth(this.outlineWidth);
            this.textPaint.setColor(this.edgeColor);
            this.textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout.draw(canvas);
        } else if (i3 == 2) {
            TextPaint textPaint = this.textPaint;
            float f3 = this.shadowRadius;
            float f4 = this.shadowOffset;
            textPaint.setShadowLayer(f3, f4, f4, this.edgeColor);
        } else if (i3 == 3 || i3 == 4) {
            if (this.edgeType != 3) {
                z = false;
            }
            int i4 = -1;
            if (z) {
                i = -1;
            } else {
                i = this.edgeColor;
            }
            if (z) {
                i4 = this.edgeColor;
            }
            float f5 = this.shadowRadius / 2.0f;
            this.textPaint.setColor(this.foregroundColor);
            this.textPaint.setStyle(Paint.Style.FILL);
            float f6 = -f5;
            this.textPaint.setShadowLayer(this.shadowRadius, f6, f6, i);
            staticLayout.draw(canvas);
            this.textPaint.setShadowLayer(this.shadowRadius, f5, f5, i4);
        }
        this.textPaint.setColor(this.foregroundColor);
        this.textPaint.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas);
        this.textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas.restoreToCount(save);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setupBitmapLayout() {
        int round;
        float f;
        int i;
        float f2;
        int i2 = this.parentRight;
        int i3 = this.parentLeft;
        int i4 = this.parentBottom;
        int i5 = this.parentTop;
        float f3 = i2 - i3;
        float f4 = i3 + (this.cuePosition * f3);
        float f5 = i4 - i5;
        float f6 = i5 + (this.cueLine * f5);
        int round2 = Math.round(f3 * this.cueSize);
        float f7 = this.cueBitmapHeight;
        if (f7 != Float.MIN_VALUE) {
            round = Math.round(f5 * f7);
        } else {
            round = Math.round(round2 * (this.cueBitmap.getHeight() / this.cueBitmap.getWidth()));
        }
        int i6 = this.cueLineAnchor;
        if (i6 == 2) {
            f = round2;
        } else {
            if (i6 == 1) {
                f = round2 / 2;
            }
            int round3 = Math.round(f4);
            i = this.cuePositionAnchor;
            if (i != 2) {
                f2 = round;
            } else {
                if (i == 1) {
                    f2 = round / 2;
                }
                int round4 = Math.round(f6);
                this.bitmapRect = new Rect(round3, round4, round2 + round3, round + round4);
            }
            f6 -= f2;
            int round42 = Math.round(f6);
            this.bitmapRect = new Rect(round3, round42, round2 + round3, round + round42);
        }
        f4 -= f;
        int round32 = Math.round(f4);
        i = this.cuePositionAnchor;
        if (i != 2) {
        }
        f6 -= f2;
        int round422 = Math.round(f6);
        this.bitmapRect = new Rect(round32, round422, round2 + round32, round + round422);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:74:0x004c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v17, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v6 */
    private void setupTextLayout() {
        ?? spannableStringBuilder;
        int i;
        int i2;
        int i3;
        int round;
        int i4;
        int i5 = this.parentRight - this.parentLeft;
        int i6 = this.parentBottom - this.parentTop;
        this.textPaint.setTextSize(this.textSizePx);
        int i7 = (int) ((this.textSizePx * 0.125f) + 0.5f);
        int i8 = i7 * 2;
        int i9 = i5 - i8;
        float f = this.cueSize;
        if (f != Float.MIN_VALUE) {
            i9 = (int) (i9 * f);
        }
        if (i9 <= 0) {
            Log.w(TAG, "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        if (this.applyEmbeddedFontSizes && this.applyEmbeddedStyles) {
            spannableStringBuilder = this.cueText;
        } else if (!this.applyEmbeddedStyles) {
            spannableStringBuilder = this.cueText.toString();
        } else {
            spannableStringBuilder = new SpannableStringBuilder(this.cueText);
            int length = spannableStringBuilder.length();
            AbsoluteSizeSpan[] absoluteSizeSpanArr = (AbsoluteSizeSpan[]) spannableStringBuilder.getSpans(0, length, AbsoluteSizeSpan.class);
            RelativeSizeSpan[] relativeSizeSpanArr = (RelativeSizeSpan[]) spannableStringBuilder.getSpans(0, length, RelativeSizeSpan.class);
            for (AbsoluteSizeSpan absoluteSizeSpan : absoluteSizeSpanArr) {
                spannableStringBuilder.removeSpan(absoluteSizeSpan);
            }
            for (RelativeSizeSpan relativeSizeSpan : relativeSizeSpanArr) {
                spannableStringBuilder.removeSpan(relativeSizeSpan);
            }
        }
        CharSequence charSequence = spannableStringBuilder;
        Layout.Alignment alignment = this.cueTextAlignment;
        if (alignment == null) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        }
        Layout.Alignment alignment2 = alignment;
        StaticLayout staticLayout = new StaticLayout(charSequence, this.textPaint, i9, alignment2, this.spacingMult, this.spacingAdd, true);
        this.textLayout = staticLayout;
        int height = staticLayout.getHeight();
        int lineCount = this.textLayout.getLineCount();
        int i10 = 0;
        for (int i11 = 0; i11 < lineCount; i11++) {
            i10 = Math.max((int) Math.ceil(this.textLayout.getLineWidth(i11)), i10);
        }
        if (this.cueSize == Float.MIN_VALUE || i10 >= i9) {
            i9 = i10;
        }
        int i12 = i9 + i8;
        float f2 = this.cuePosition;
        if (f2 != Float.MIN_VALUE) {
            int round2 = Math.round(i5 * f2) + this.parentLeft;
            int i13 = this.cuePositionAnchor;
            if (i13 == 2) {
                round2 -= i12;
            } else if (i13 == 1) {
                round2 = ((round2 * 2) - i12) / 2;
            }
            i = Math.max(round2, this.parentLeft);
            i2 = Math.min(i12 + i, this.parentRight);
        } else {
            i = (i5 - i12) / 2;
            i2 = i + i12;
        }
        int i14 = i2 - i;
        if (i14 <= 0) {
            Log.w(TAG, "Skipped drawing subtitle cue (invalid horizontal positioning)");
            return;
        }
        float f3 = this.cueLine;
        if (f3 != Float.MIN_VALUE) {
            if (this.cueLineType == 0) {
                round = Math.round(i6 * f3);
                i4 = this.parentTop;
            } else {
                int lineBottom = this.textLayout.getLineBottom(0) - this.textLayout.getLineTop(0);
                float f4 = this.cueLine;
                if (f4 >= 0.0f) {
                    round = Math.round(f4 * lineBottom);
                    i4 = this.parentTop;
                } else {
                    round = Math.round((f4 + 1.0f) * lineBottom);
                    i4 = this.parentBottom;
                }
            }
            i3 = round + i4;
            int i15 = this.cueLineAnchor;
            if (i15 == 2) {
                i3 -= height;
            } else if (i15 == 1) {
                i3 = ((i3 * 2) - height) / 2;
            }
            int i16 = i3 + height;
            int i17 = this.parentBottom;
            if (i16 > i17) {
                i3 = i17 - height;
            } else {
                int i18 = this.parentTop;
                if (i3 < i18) {
                    i3 = i18;
                }
            }
        } else {
            i3 = (this.parentBottom - height) - ((int) (i6 * this.bottomPaddingFraction));
        }
        this.textLayout = new StaticLayout(charSequence, this.textPaint, i14, alignment2, this.spacingMult, this.spacingAdd, true);
        this.textLeft = i;
        this.textTop = i3;
        this.textPaddingX = i7;
    }

    public void draw(Cue cue, boolean z, boolean z2, CaptionStyleCompat captionStyleCompat, float f, float f2, Canvas canvas, int i, int i2, int i3, int i4) {
        boolean z3;
        if (cue.bitmap == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        int i5 = -16777216;
        if (z3) {
            if (TextUtils.isEmpty(cue.text)) {
                return;
            }
            if (cue.windowColorSet && z) {
                i5 = cue.windowColor;
            } else {
                i5 = captionStyleCompat.windowColor;
            }
        }
        if (areCharSequencesEqual(this.cueText, cue.text) && Util.areEqual(this.cueTextAlignment, cue.textAlignment) && this.cueBitmap == cue.bitmap && this.cueLine == cue.line && this.cueLineType == cue.lineType && Util.areEqual(Integer.valueOf(this.cueLineAnchor), Integer.valueOf(cue.lineAnchor)) && this.cuePosition == cue.position && Util.areEqual(Integer.valueOf(this.cuePositionAnchor), Integer.valueOf(cue.positionAnchor)) && this.cueSize == cue.size && this.cueBitmapHeight == cue.bitmapHeight && this.applyEmbeddedStyles == z && this.applyEmbeddedFontSizes == z2 && this.foregroundColor == captionStyleCompat.foregroundColor && this.backgroundColor == captionStyleCompat.backgroundColor && this.windowColor == i5 && this.edgeType == captionStyleCompat.edgeType && this.edgeColor == captionStyleCompat.edgeColor && Util.areEqual(this.textPaint.getTypeface(), captionStyleCompat.typeface) && this.textSizePx == f && this.bottomPaddingFraction == f2 && this.parentLeft == i && this.parentTop == i2 && this.parentRight == i3 && this.parentBottom == i4) {
            drawLayout(canvas, z3);
            return;
        }
        this.cueText = cue.text;
        this.cueTextAlignment = cue.textAlignment;
        this.cueBitmap = cue.bitmap;
        this.cueLine = cue.line;
        this.cueLineType = cue.lineType;
        this.cueLineAnchor = cue.lineAnchor;
        this.cuePosition = cue.position;
        this.cuePositionAnchor = cue.positionAnchor;
        this.cueSize = cue.size;
        this.cueBitmapHeight = cue.bitmapHeight;
        this.applyEmbeddedStyles = z;
        this.applyEmbeddedFontSizes = z2;
        this.foregroundColor = captionStyleCompat.foregroundColor;
        this.backgroundColor = captionStyleCompat.backgroundColor;
        this.windowColor = i5;
        this.edgeType = captionStyleCompat.edgeType;
        this.edgeColor = captionStyleCompat.edgeColor;
        this.textPaint.setTypeface(captionStyleCompat.typeface);
        this.textSizePx = f;
        this.bottomPaddingFraction = f2;
        this.parentLeft = i;
        this.parentTop = i2;
        this.parentRight = i3;
        this.parentBottom = i4;
        if (z3) {
            setupTextLayout();
        } else {
            setupBitmapLayout();
        }
        drawLayout(canvas, z3);
    }
}
