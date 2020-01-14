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
/* loaded from: classes5.dex */
final class b {
    private final float aBn;
    private int backgroundColor;
    private int foregroundColor;
    private CharSequence mEA;
    private Layout.Alignment mEB;
    private Bitmap mEC;
    private float mED;
    private int mEE;
    private int mEF;
    private float mEG;
    private int mEH;
    private float mEI;
    private float mEJ;
    private boolean mEK;
    private boolean mEL;
    private float mEM;
    private float mEN;
    private int mEO;
    private int mEP;
    private int mEQ;
    private int mER;
    private StaticLayout mES;
    private int mET;
    private int mEU;
    private int mEV;
    private Rect mEW;
    private final RectF mEu = new RectF();
    private final float mEv;
    private final float mEw;
    private final float mEx;
    private final float mEy;
    private final float mEz;
    private int mxP;
    private int mxQ;
    private int mxR;
    private final Paint paint;
    private final TextPaint textPaint;

    public b(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16843287, 16843288}, 0, 0);
        this.mEz = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.mEy = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        int round = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.aBn = round;
        this.mEv = round;
        this.mEw = round;
        this.mEx = round;
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
                i5 = (bVar.mya && z) ? bVar.mxP : aVar.mxP;
            } else {
                return;
            }
        }
        if (b(this.mEA, bVar.text) && v.h(this.mEB, bVar.mxS) && this.mEC == bVar.bitmap && this.mED == bVar.mxT && this.mEE == bVar.mxU && v.h(Integer.valueOf(this.mEF), Integer.valueOf(bVar.mxV)) && this.mEG == bVar.mxW && v.h(Integer.valueOf(this.mEH), Integer.valueOf(bVar.mxX)) && this.mEI == bVar.mxY && this.mEJ == bVar.mxZ && this.mEK == z && this.mEL == z2 && this.foregroundColor == aVar.foregroundColor && this.backgroundColor == aVar.backgroundColor && this.mxP == i5 && this.mxQ == aVar.mxQ && this.mxR == aVar.mxR && v.h(this.textPaint.getTypeface(), aVar.typeface) && this.mEM == f && this.mEN == f2 && this.mEO == i && this.mEP == i2 && this.mEQ == i3 && this.mER == i4) {
            a(canvas, z3);
            return;
        }
        this.mEA = bVar.text;
        this.mEB = bVar.mxS;
        this.mEC = bVar.bitmap;
        this.mED = bVar.mxT;
        this.mEE = bVar.mxU;
        this.mEF = bVar.mxV;
        this.mEG = bVar.mxW;
        this.mEH = bVar.mxX;
        this.mEI = bVar.mxY;
        this.mEJ = bVar.mxZ;
        this.mEK = z;
        this.mEL = z2;
        this.foregroundColor = aVar.foregroundColor;
        this.backgroundColor = aVar.backgroundColor;
        this.mxP = i5;
        this.mxQ = aVar.mxQ;
        this.mxR = aVar.mxR;
        this.textPaint.setTypeface(aVar.typeface);
        this.mEM = f;
        this.mEN = f2;
        this.mEO = i;
        this.mEP = i2;
        this.mEQ = i3;
        this.mER = i4;
        if (z3) {
            dxE();
        } else {
            dxF();
        }
        a(canvas, z3);
    }

    private void dxE() {
        CharSequence charSequence;
        int i;
        int i2;
        int i3;
        int round;
        int i4 = this.mEQ - this.mEO;
        int i5 = this.mER - this.mEP;
        this.textPaint.setTextSize(this.mEM);
        int i6 = (int) ((this.mEM * 0.125f) + 0.5f);
        int i7 = i4 - (i6 * 2);
        if (this.mEI != Float.MIN_VALUE) {
            i7 = (int) (i7 * this.mEI);
        }
        if (i7 <= 0) {
            Log.w("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        if (this.mEL && this.mEK) {
            charSequence = this.mEA;
        } else if (!this.mEK) {
            charSequence = this.mEA.toString();
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mEA);
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
        Layout.Alignment alignment = this.mEB == null ? Layout.Alignment.ALIGN_CENTER : this.mEB;
        this.mES = new StaticLayout(charSequence, this.textPaint, i7, alignment, this.mEy, this.mEz, true);
        int height = this.mES.getHeight();
        int lineCount = this.mES.getLineCount();
        int i8 = 0;
        int i9 = 0;
        while (i9 < lineCount) {
            int max = Math.max((int) Math.ceil(this.mES.getLineWidth(i9)), i8);
            i9++;
            i8 = max;
        }
        if (this.mEI == Float.MIN_VALUE || i8 >= i7) {
            i7 = i8;
        }
        int i10 = i7 + (i6 * 2);
        if (this.mEG != Float.MIN_VALUE) {
            int round2 = Math.round(i4 * this.mEG) + this.mEO;
            if (this.mEH == 2) {
                round2 -= i10;
            } else if (this.mEH == 1) {
                round2 = ((round2 * 2) - i10) / 2;
            }
            int max2 = Math.max(round2, this.mEO);
            i = Math.min(max2 + i10, this.mEQ);
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
        if (this.mED != Float.MIN_VALUE) {
            if (this.mEE == 0) {
                round = Math.round(i5 * this.mED) + this.mEP;
            } else {
                int lineBottom = this.mES.getLineBottom(0) - this.mES.getLineTop(0);
                if (this.mED >= 0.0f) {
                    round = Math.round(lineBottom * this.mED) + this.mEP;
                } else {
                    round = Math.round(lineBottom * (this.mED + 1.0f)) + this.mER;
                }
            }
            if (this.mEF == 2) {
                round -= height;
            } else if (this.mEF == 1) {
                round = ((round * 2) - height) / 2;
            }
            if (round + height > this.mER) {
                round = this.mER - height;
            } else if (round < this.mEP) {
                round = this.mEP;
            }
            i3 = round;
        } else {
            i3 = (this.mER - height) - ((int) (i5 * this.mEN));
        }
        this.mES = new StaticLayout(charSequence, this.textPaint, i12, alignment, this.mEy, this.mEz, true);
        this.mET = i2;
        this.mEU = i3;
        this.mEV = i6;
    }

    private void dxF() {
        float f;
        int i = this.mEQ - this.mEO;
        int i2 = this.mER - this.mEP;
        float f2 = this.mEO + (i * this.mEG);
        float f3 = this.mEP + (i2 * this.mED);
        int round = Math.round(i * this.mEI);
        int round2 = this.mEJ != Float.MIN_VALUE ? Math.round(i2 * this.mEJ) : Math.round(round * (this.mEC.getHeight() / this.mEC.getWidth()));
        if (this.mEF == 2) {
            f2 -= round;
        } else if (this.mEF == 1) {
            f2 -= round / 2;
        }
        int round3 = Math.round(f2);
        if (this.mEH == 2) {
            f = f3 - round2;
        } else {
            f = this.mEH == 1 ? f3 - (round2 / 2) : f3;
        }
        int round4 = Math.round(f);
        this.mEW = new Rect(round3, round4, round + round3, round2 + round4);
    }

    private void a(Canvas canvas, boolean z) {
        if (z) {
            ae(canvas);
        } else {
            af(canvas);
        }
    }

    private void ae(Canvas canvas) {
        StaticLayout staticLayout = this.mES;
        if (staticLayout != null) {
            int save = canvas.save();
            canvas.translate(this.mET, this.mEU);
            if (Color.alpha(this.mxP) > 0) {
                this.paint.setColor(this.mxP);
                canvas.drawRect(-this.mEV, 0.0f, staticLayout.getWidth() + this.mEV, staticLayout.getHeight(), this.paint);
            }
            if (Color.alpha(this.backgroundColor) > 0) {
                this.paint.setColor(this.backgroundColor);
                int lineCount = staticLayout.getLineCount();
                float lineTop = staticLayout.getLineTop(0);
                for (int i = 0; i < lineCount; i++) {
                    this.mEu.left = staticLayout.getLineLeft(i) - this.mEV;
                    this.mEu.right = staticLayout.getLineRight(i) + this.mEV;
                    this.mEu.top = lineTop;
                    this.mEu.bottom = staticLayout.getLineBottom(i);
                    lineTop = this.mEu.bottom;
                    canvas.drawRoundRect(this.mEu, this.aBn, this.aBn, this.paint);
                }
            }
            if (this.mxQ == 1) {
                this.textPaint.setStrokeJoin(Paint.Join.ROUND);
                this.textPaint.setStrokeWidth(this.mEv);
                this.textPaint.setColor(this.mxR);
                this.textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                staticLayout.draw(canvas);
            } else if (this.mxQ == 2) {
                this.textPaint.setShadowLayer(this.mEw, this.mEx, this.mEx, this.mxR);
            } else if (this.mxQ == 3 || this.mxQ == 4) {
                boolean z = this.mxQ == 3;
                int i2 = z ? -1 : this.mxR;
                int i3 = z ? this.mxR : -1;
                float f = this.mEw / 2.0f;
                this.textPaint.setColor(this.foregroundColor);
                this.textPaint.setStyle(Paint.Style.FILL);
                this.textPaint.setShadowLayer(this.mEw, -f, -f, i2);
                staticLayout.draw(canvas);
                this.textPaint.setShadowLayer(this.mEw, f, f, i3);
            }
            this.textPaint.setColor(this.foregroundColor);
            this.textPaint.setStyle(Paint.Style.FILL);
            staticLayout.draw(canvas);
            this.textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            canvas.restoreToCount(save);
        }
    }

    private void af(Canvas canvas) {
        canvas.drawBitmap(this.mEC, (Rect) null, this.mEW, (Paint) null);
    }

    private static boolean b(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }
}
