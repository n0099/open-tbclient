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
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.CaptionStyleCompat;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Util;
/* loaded from: classes7.dex */
public final class SubtitlePainter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float INNER_PADDING_RATIO = 0.125f;
    public static final String TAG = "SubtitlePainter";
    public transient /* synthetic */ FieldHolder $fh;
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
    public final RectF lineBounds;
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
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.lineBounds = new RectF();
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
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, charSequence, charSequence2)) == null) ? charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2)) : invokeLL.booleanValue;
    }

    private void drawBitmapLayout(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, canvas) == null) {
            canvas.drawBitmap(this.cueBitmap, (Rect) null, this.bitmapRect, (Paint) null);
        }
    }

    private void drawLayout(Canvas canvas, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, this, canvas, z) == null) {
            if (z) {
                drawTextLayout(canvas);
            } else {
                drawBitmapLayout(canvas);
            }
        }
    }

    private void drawTextLayout(Canvas canvas) {
        StaticLayout staticLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, canvas) == null) || (staticLayout = this.textLayout) == null) {
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
                float f2 = rectF2.bottom;
                float f3 = this.cornerRadius;
                canvas.drawRoundRect(rectF2, f3, f3, this.paint);
                i2++;
                lineTop = f2;
            }
        }
        int i3 = this.edgeType;
        if (i3 == 1) {
            this.textPaint.setStrokeJoin(Paint.Join.ROUND);
            this.textPaint.setStrokeWidth(this.outlineWidth);
            this.textPaint.setColor(this.edgeColor);
            this.textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout.draw(canvas);
        } else if (i3 == 2) {
            TextPaint textPaint = this.textPaint;
            float f4 = this.shadowRadius;
            float f5 = this.shadowOffset;
            textPaint.setShadowLayer(f4, f5, f5, this.edgeColor);
        } else if (i3 == 3 || i3 == 4) {
            boolean z = this.edgeType == 3;
            int i4 = z ? -1 : this.edgeColor;
            int i5 = z ? this.edgeColor : -1;
            float f6 = this.shadowRadius / 2.0f;
            this.textPaint.setColor(this.foregroundColor);
            this.textPaint.setStyle(Paint.Style.FILL);
            float f7 = -f6;
            this.textPaint.setShadowLayer(this.shadowRadius, f7, f7, i4);
            staticLayout.draw(canvas);
            this.textPaint.setShadowLayer(this.shadowRadius, f6, f6, i5);
        }
        this.textPaint.setColor(this.foregroundColor);
        this.textPaint.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas);
        this.textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas.restoreToCount(save);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setupBitmapLayout() {
        float f2;
        int i2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            int i3 = this.parentRight;
            int i4 = this.parentLeft;
            int i5 = this.parentBottom;
            int i6 = this.parentTop;
            float f4 = i3 - i4;
            float f5 = i4 + (this.cuePosition * f4);
            float f6 = i5 - i6;
            float f7 = i6 + (this.cueLine * f6);
            int round = Math.round(f4 * this.cueSize);
            float f8 = this.cueBitmapHeight;
            int round2 = f8 != Float.MIN_VALUE ? Math.round(f6 * f8) : Math.round(round * (this.cueBitmap.getHeight() / this.cueBitmap.getWidth()));
            int i7 = this.cueLineAnchor;
            if (i7 != 2) {
                if (i7 == 1) {
                    f2 = round / 2;
                }
                int round3 = Math.round(f5);
                i2 = this.cuePositionAnchor;
                if (i2 == 2) {
                    if (i2 == 1) {
                        f3 = round2 / 2;
                    }
                    int round4 = Math.round(f7);
                    this.bitmapRect = new Rect(round3, round4, round + round3, round2 + round4);
                }
                f3 = round2;
                f7 -= f3;
                int round42 = Math.round(f7);
                this.bitmapRect = new Rect(round3, round42, round + round3, round2 + round42);
            }
            f2 = round;
            f5 -= f2;
            int round32 = Math.round(f5);
            i2 = this.cuePositionAnchor;
            if (i2 == 2) {
            }
            f7 -= f3;
            int round422 = Math.round(f7);
            this.bitmapRect = new Rect(round32, round422, round + round32, round2 + round422);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:76:0x0049 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v6 */
    private void setupTextLayout() {
        ?? spannableStringBuilder;
        int i2;
        int i3;
        int i4;
        int round;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            int i6 = this.parentRight - this.parentLeft;
            int i7 = this.parentBottom - this.parentTop;
            this.textPaint.setTextSize(this.textSizePx);
            int i8 = (int) ((this.textSizePx * 0.125f) + 0.5f);
            int i9 = i8 * 2;
            int i10 = i6 - i9;
            float f2 = this.cueSize;
            if (f2 != Float.MIN_VALUE) {
                i10 = (int) (i10 * f2);
            }
            if (i10 <= 0) {
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
            StaticLayout staticLayout = new StaticLayout(charSequence, this.textPaint, i10, alignment2, this.spacingMult, this.spacingAdd, true);
            this.textLayout = staticLayout;
            int height = staticLayout.getHeight();
            int lineCount = this.textLayout.getLineCount();
            int i11 = 0;
            for (int i12 = 0; i12 < lineCount; i12++) {
                i11 = Math.max((int) Math.ceil(this.textLayout.getLineWidth(i12)), i11);
            }
            if (this.cueSize == Float.MIN_VALUE || i11 >= i10) {
                i10 = i11;
            }
            int i13 = i10 + i9;
            float f3 = this.cuePosition;
            if (f3 != Float.MIN_VALUE) {
                int round2 = Math.round(i6 * f3) + this.parentLeft;
                int i14 = this.cuePositionAnchor;
                if (i14 == 2) {
                    round2 -= i13;
                } else if (i14 == 1) {
                    round2 = ((round2 * 2) - i13) / 2;
                }
                i2 = Math.max(round2, this.parentLeft);
                i3 = Math.min(i13 + i2, this.parentRight);
            } else {
                i2 = (i6 - i13) / 2;
                i3 = i2 + i13;
            }
            int i15 = i3 - i2;
            if (i15 <= 0) {
                return;
            }
            float f4 = this.cueLine;
            if (f4 != Float.MIN_VALUE) {
                if (this.cueLineType == 0) {
                    round = Math.round(i7 * f4);
                    i5 = this.parentTop;
                } else {
                    int lineBottom = this.textLayout.getLineBottom(0) - this.textLayout.getLineTop(0);
                    float f5 = this.cueLine;
                    if (f5 >= 0.0f) {
                        round = Math.round(f5 * lineBottom);
                        i5 = this.parentTop;
                    } else {
                        round = Math.round((f5 + 1.0f) * lineBottom);
                        i5 = this.parentBottom;
                    }
                }
                i4 = round + i5;
                int i16 = this.cueLineAnchor;
                if (i16 == 2) {
                    i4 -= height;
                } else if (i16 == 1) {
                    i4 = ((i4 * 2) - height) / 2;
                }
                int i17 = i4 + height;
                int i18 = this.parentBottom;
                if (i17 > i18) {
                    i4 = i18 - height;
                } else {
                    int i19 = this.parentTop;
                    if (i4 < i19) {
                        i4 = i19;
                    }
                }
            } else {
                i4 = (this.parentBottom - height) - ((int) (i7 * this.bottomPaddingFraction));
            }
            this.textLayout = new StaticLayout(charSequence, this.textPaint, i15, alignment2, this.spacingMult, this.spacingAdd, true);
            this.textLeft = i2;
            this.textTop = i4;
            this.textPaddingX = i8;
        }
    }

    public void draw(Cue cue, boolean z, boolean z2, CaptionStyleCompat captionStyleCompat, float f2, float f3, Canvas canvas, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{cue, Boolean.valueOf(z), Boolean.valueOf(z2), captionStyleCompat, Float.valueOf(f2), Float.valueOf(f3), canvas, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            boolean z3 = cue.bitmap == null;
            int i6 = -16777216;
            if (z3) {
                if (TextUtils.isEmpty(cue.text)) {
                    return;
                }
                i6 = (cue.windowColorSet && z) ? cue.windowColor : captionStyleCompat.windowColor;
            }
            if (areCharSequencesEqual(this.cueText, cue.text) && Util.areEqual(this.cueTextAlignment, cue.textAlignment) && this.cueBitmap == cue.bitmap && this.cueLine == cue.line && this.cueLineType == cue.lineType && Util.areEqual(Integer.valueOf(this.cueLineAnchor), Integer.valueOf(cue.lineAnchor)) && this.cuePosition == cue.position && Util.areEqual(Integer.valueOf(this.cuePositionAnchor), Integer.valueOf(cue.positionAnchor)) && this.cueSize == cue.size && this.cueBitmapHeight == cue.bitmapHeight && this.applyEmbeddedStyles == z && this.applyEmbeddedFontSizes == z2 && this.foregroundColor == captionStyleCompat.foregroundColor && this.backgroundColor == captionStyleCompat.backgroundColor && this.windowColor == i6 && this.edgeType == captionStyleCompat.edgeType && this.edgeColor == captionStyleCompat.edgeColor && Util.areEqual(this.textPaint.getTypeface(), captionStyleCompat.typeface) && this.textSizePx == f2 && this.bottomPaddingFraction == f3 && this.parentLeft == i2 && this.parentTop == i3 && this.parentRight == i4 && this.parentBottom == i5) {
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
            this.windowColor = i6;
            this.edgeType = captionStyleCompat.edgeType;
            this.edgeColor = captionStyleCompat.edgeColor;
            this.textPaint.setTypeface(captionStyleCompat.typeface);
            this.textSizePx = f2;
            this.bottomPaddingFraction = f3;
            this.parentLeft = i2;
            this.parentTop = i3;
            this.parentRight = i4;
            this.parentBottom = i5;
            if (z3) {
                setupTextLayout();
            } else {
                setupBitmapLayout();
            }
            drawLayout(canvas, z3);
        }
    }
}
