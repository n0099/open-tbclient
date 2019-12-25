package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes4.dex */
final class b {
    private final float aAD;
    private int backgroundColor;
    private int foregroundColor;
    private final float mAA;
    private final float mAB;
    private final float mAC;
    private CharSequence mAD;
    private Layout.Alignment mAE;
    private Bitmap mAF;
    private float mAG;
    private int mAH;
    private int mAI;
    private float mAJ;
    private int mAK;
    private float mAL;
    private float mAM;
    private boolean mAN;
    private boolean mAO;
    private float mAP;
    private float mAQ;
    private int mAR;
    private int mAS;
    private int mAT;
    private int mAU;
    private StaticLayout mAV;
    private int mAW;
    private int mAX;
    private int mAY;
    private Rect mAZ;
    private final RectF mAx = new RectF();
    private final float mAy;
    private final float mAz;
    private int mtX;
    private int mtY;
    private int mtZ;
    private final Paint paint;
    private final TextPaint textPaint;

    public b(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16843287, 16843288}, 0, 0);
        this.mAC = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.mAB = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        int round = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.aAD = round;
        this.mAy = round;
        this.mAz = round;
        this.mAA = round;
        this.textPaint = new TextPaint();
        this.textPaint.setAntiAlias(true);
        this.textPaint.setSubpixelText(true);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL);
    }

    public void a(com.google.android.exoplayer2.text.b bVar, boolean z, boolean z2, com.google.android.exoplayer2.text.a aVar, float f, float f2, Canvas canvas, int i, int i2, int i3, int i4) {
        boolean z3 = bVar.bitmap == null;
        int i5 = ViewCompat.MEASURED_STATE_MASK;
        if (z3) {
            if (!TextUtils.isEmpty(bVar.text)) {
                i5 = (bVar.mui && z) ? bVar.mtX : aVar.mtX;
            } else {
                return;
            }
        }
        if (b(this.mAD, bVar.text) && v.h(this.mAE, bVar.mua) && this.mAF == bVar.bitmap && this.mAG == bVar.mub && this.mAH == bVar.muc && v.h(Integer.valueOf(this.mAI), Integer.valueOf(bVar.mud)) && this.mAJ == bVar.mue && v.h(Integer.valueOf(this.mAK), Integer.valueOf(bVar.muf)) && this.mAL == bVar.mug && this.mAM == bVar.muh && this.mAN == z && this.mAO == z2 && this.foregroundColor == aVar.foregroundColor && this.backgroundColor == aVar.backgroundColor && this.mtX == i5 && this.mtY == aVar.mtY && this.mtZ == aVar.mtZ && v.h(this.textPaint.getTypeface(), aVar.typeface) && this.mAP == f && this.mAQ == f2 && this.mAR == i && this.mAS == i2 && this.mAT == i3 && this.mAU == i4) {
            a(canvas, z3);
            return;
        }
        this.mAD = bVar.text;
        this.mAE = bVar.mua;
        this.mAF = bVar.bitmap;
        this.mAG = bVar.mub;
        this.mAH = bVar.muc;
        this.mAI = bVar.mud;
        this.mAJ = bVar.mue;
        this.mAK = bVar.muf;
        this.mAL = bVar.mug;
        this.mAM = bVar.muh;
        this.mAN = z;
        this.mAO = z2;
        this.foregroundColor = aVar.foregroundColor;
        this.backgroundColor = aVar.backgroundColor;
        this.mtX = i5;
        this.mtY = aVar.mtY;
        this.mtZ = aVar.mtZ;
        this.textPaint.setTypeface(aVar.typeface);
        this.mAP = f;
        this.mAQ = f2;
        this.mAR = i;
        this.mAS = i2;
        this.mAT = i3;
        this.mAU = i4;
        if (z3) {
            dwr();
        } else {
            dws();
        }
        a(canvas, z3);
    }

    private void dwr() {
        CharSequence charSequence;
        int i;
        int i2;
        int i3;
        int round;
        int i4 = this.mAT - this.mAR;
        int i5 = this.mAU - this.mAS;
        this.textPaint.setTextSize(this.mAP);
        int i6 = (int) ((this.mAP * 0.125f) + 0.5f);
        int i7 = i4 - (i6 * 2);
        if (this.mAL != Float.MIN_VALUE) {
            i7 = (int) (i7 * this.mAL);
        }
        if (i7 <= 0) {
            Log.w("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        if (this.mAO && this.mAN) {
            charSequence = this.mAD;
        } else if (!this.mAN) {
            charSequence = this.mAD.toString();
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mAD);
            int length = spannableStringBuilder.length();
            AbsoluteSizeSpan[] absoluteSizeSpanArr = (AbsoluteSizeSpan[]) spannableStringBuilder.getSpans(0, length, AbsoluteSizeSpan.class);
            RelativeSizeSpan[] relativeSizeSpanArr = (RelativeSizeSpan[]) spannableStringBuilder.getSpans(0, length, RelativeSizeSpan.class);
            for (AbsoluteSizeSpan absoluteSizeSpan : absoluteSizeSpanArr) {
                spannableStringBuilder.removeSpan(absoluteSizeSpan);
            }
            for (RelativeSizeSpan relativeSizeSpan : relativeSizeSpanArr) {
                spannableStringBuilder.removeSpan(relativeSizeSpan);
            }
            charSequence = spannableStringBuilder;
        }
        Layout.Alignment alignment = this.mAE == null ? Layout.Alignment.ALIGN_CENTER : this.mAE;
        this.mAV = new StaticLayout(charSequence, this.textPaint, i7, alignment, this.mAB, this.mAC, true);
        int height = this.mAV.getHeight();
        int lineCount = this.mAV.getLineCount();
        int i8 = 0;
        int i9 = 0;
        while (i9 < lineCount) {
            int max = Math.max((int) Math.ceil(this.mAV.getLineWidth(i9)), i8);
            i9++;
            i8 = max;
        }
        if (this.mAL == Float.MIN_VALUE || i8 >= i7) {
            i7 = i8;
        }
        int i10 = i7 + (i6 * 2);
        if (this.mAJ != Float.MIN_VALUE) {
            int round2 = Math.round(i4 * this.mAJ) + this.mAR;
            if (this.mAK == 2) {
                round2 -= i10;
            } else if (this.mAK == 1) {
                round2 = ((round2 * 2) - i10) / 2;
            }
            int max2 = Math.max(round2, this.mAR);
            i = Math.min(max2 + i10, this.mAT);
            i2 = max2;
        } else {
            int i11 = (i4 - i10) / 2;
            i = i11 + i10;
            i2 = i11;
        }
        int i12 = i - i2;
        if (i12 <= 0) {
            Log.w("SubtitlePainter", "Skipped drawing subtitle cue (invalid horizontal positioning)");
            return;
        }
        if (this.mAG != Float.MIN_VALUE) {
            if (this.mAH == 0) {
                round = Math.round(i5 * this.mAG) + this.mAS;
            } else {
                int lineBottom = this.mAV.getLineBottom(0) - this.mAV.getLineTop(0);
                if (this.mAG >= 0.0f) {
                    round = Math.round(lineBottom * this.mAG) + this.mAS;
                } else {
                    round = Math.round(lineBottom * (this.mAG + 1.0f)) + this.mAU;
                }
            }
            if (this.mAI == 2) {
                round -= height;
            } else if (this.mAI == 1) {
                round = ((round * 2) - height) / 2;
            }
            if (round + height > this.mAU) {
                round = this.mAU - height;
            } else if (round < this.mAS) {
                round = this.mAS;
            }
            i3 = round;
        } else {
            i3 = (this.mAU - height) - ((int) (i5 * this.mAQ));
        }
        this.mAV = new StaticLayout(charSequence, this.textPaint, i12, alignment, this.mAB, this.mAC, true);
        this.mAW = i2;
        this.mAX = i3;
        this.mAY = i6;
    }

    private void dws() {
        float f;
        int i = this.mAT - this.mAR;
        int i2 = this.mAU - this.mAS;
        float f2 = this.mAR + (i * this.mAJ);
        float f3 = this.mAS + (i2 * this.mAG);
        int round = Math.round(i * this.mAL);
        int round2 = this.mAM != Float.MIN_VALUE ? Math.round(i2 * this.mAM) : Math.round(round * (this.mAF.getHeight() / this.mAF.getWidth()));
        if (this.mAI == 2) {
            f2 -= round;
        } else if (this.mAI == 1) {
            f2 -= round / 2;
        }
        int round3 = Math.round(f2);
        if (this.mAK == 2) {
            f = f3 - round2;
        } else {
            f = this.mAK == 1 ? f3 - (round2 / 2) : f3;
        }
        int round4 = Math.round(f);
        this.mAZ = new Rect(round3, round4, round + round3, round2 + round4);
    }

    private void a(Canvas canvas, boolean z) {
        if (z) {
            ae(canvas);
        } else {
            af(canvas);
        }
    }

    private void ae(Canvas canvas) {
        StaticLayout staticLayout = this.mAV;
        if (staticLayout != null) {
            int save = canvas.save();
            canvas.translate(this.mAW, this.mAX);
            if (Color.alpha(this.mtX) > 0) {
                this.paint.setColor(this.mtX);
                canvas.drawRect(-this.mAY, 0.0f, staticLayout.getWidth() + this.mAY, staticLayout.getHeight(), this.paint);
            }
            if (Color.alpha(this.backgroundColor) > 0) {
                this.paint.setColor(this.backgroundColor);
                int lineCount = staticLayout.getLineCount();
                float lineTop = staticLayout.getLineTop(0);
                for (int i = 0; i < lineCount; i++) {
                    this.mAx.left = staticLayout.getLineLeft(i) - this.mAY;
                    this.mAx.right = staticLayout.getLineRight(i) + this.mAY;
                    this.mAx.top = lineTop;
                    this.mAx.bottom = staticLayout.getLineBottom(i);
                    lineTop = this.mAx.bottom;
                    canvas.drawRoundRect(this.mAx, this.aAD, this.aAD, this.paint);
                }
            }
            if (this.mtY == 1) {
                this.textPaint.setStrokeJoin(Paint.Join.ROUND);
                this.textPaint.setStrokeWidth(this.mAy);
                this.textPaint.setColor(this.mtZ);
                this.textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                staticLayout.draw(canvas);
            } else if (this.mtY == 2) {
                this.textPaint.setShadowLayer(this.mAz, this.mAA, this.mAA, this.mtZ);
            } else if (this.mtY == 3 || this.mtY == 4) {
                boolean z = this.mtY == 3;
                int i2 = z ? -1 : this.mtZ;
                int i3 = z ? this.mtZ : -1;
                float f = this.mAz / 2.0f;
                this.textPaint.setColor(this.foregroundColor);
                this.textPaint.setStyle(Paint.Style.FILL);
                this.textPaint.setShadowLayer(this.mAz, -f, -f, i2);
                staticLayout.draw(canvas);
                this.textPaint.setShadowLayer(this.mAz, f, f, i3);
            }
            this.textPaint.setColor(this.foregroundColor);
            this.textPaint.setStyle(Paint.Style.FILL);
            staticLayout.draw(canvas);
            this.textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            canvas.restoreToCount(save);
        }
    }

    private void af(Canvas canvas) {
        canvas.drawBitmap(this.mAF, (Rect) null, this.mAZ, (Paint) null);
    }

    private static boolean b(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }
}
