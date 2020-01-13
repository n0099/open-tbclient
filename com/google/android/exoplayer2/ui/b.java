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
    private int mEA;
    private float mEB;
    private int mEC;
    private float mED;
    private float mEE;
    private boolean mEF;
    private boolean mEG;
    private float mEH;
    private float mEI;
    private int mEJ;
    private int mEK;
    private int mEL;
    private int mEM;
    private StaticLayout mEN;
    private int mEO;
    private int mEP;
    private int mEQ;
    private Rect mER;
    private final RectF mEp = new RectF();
    private final float mEq;
    private final float mEr;
    private final float mEs;
    private final float mEt;
    private final float mEu;
    private CharSequence mEv;
    private Layout.Alignment mEw;
    private Bitmap mEx;
    private float mEy;
    private int mEz;
    private int mxK;
    private int mxL;
    private int mxM;
    private final Paint paint;
    private final TextPaint textPaint;

    public b(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16843287, 16843288}, 0, 0);
        this.mEu = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.mEt = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        int round = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.aBn = round;
        this.mEq = round;
        this.mEr = round;
        this.mEs = round;
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
                i5 = (bVar.mxV && z) ? bVar.mxK : aVar.mxK;
            } else {
                return;
            }
        }
        if (b(this.mEv, bVar.text) && v.h(this.mEw, bVar.mxN) && this.mEx == bVar.bitmap && this.mEy == bVar.mxO && this.mEz == bVar.mxP && v.h(Integer.valueOf(this.mEA), Integer.valueOf(bVar.mxQ)) && this.mEB == bVar.mxR && v.h(Integer.valueOf(this.mEC), Integer.valueOf(bVar.mxS)) && this.mED == bVar.mxT && this.mEE == bVar.mxU && this.mEF == z && this.mEG == z2 && this.foregroundColor == aVar.foregroundColor && this.backgroundColor == aVar.backgroundColor && this.mxK == i5 && this.mxL == aVar.mxL && this.mxM == aVar.mxM && v.h(this.textPaint.getTypeface(), aVar.typeface) && this.mEH == f && this.mEI == f2 && this.mEJ == i && this.mEK == i2 && this.mEL == i3 && this.mEM == i4) {
            a(canvas, z3);
            return;
        }
        this.mEv = bVar.text;
        this.mEw = bVar.mxN;
        this.mEx = bVar.bitmap;
        this.mEy = bVar.mxO;
        this.mEz = bVar.mxP;
        this.mEA = bVar.mxQ;
        this.mEB = bVar.mxR;
        this.mEC = bVar.mxS;
        this.mED = bVar.mxT;
        this.mEE = bVar.mxU;
        this.mEF = z;
        this.mEG = z2;
        this.foregroundColor = aVar.foregroundColor;
        this.backgroundColor = aVar.backgroundColor;
        this.mxK = i5;
        this.mxL = aVar.mxL;
        this.mxM = aVar.mxM;
        this.textPaint.setTypeface(aVar.typeface);
        this.mEH = f;
        this.mEI = f2;
        this.mEJ = i;
        this.mEK = i2;
        this.mEL = i3;
        this.mEM = i4;
        if (z3) {
            dxC();
        } else {
            dxD();
        }
        a(canvas, z3);
    }

    private void dxC() {
        CharSequence charSequence;
        int i;
        int i2;
        int i3;
        int round;
        int i4 = this.mEL - this.mEJ;
        int i5 = this.mEM - this.mEK;
        this.textPaint.setTextSize(this.mEH);
        int i6 = (int) ((this.mEH * 0.125f) + 0.5f);
        int i7 = i4 - (i6 * 2);
        if (this.mED != Float.MIN_VALUE) {
            i7 = (int) (i7 * this.mED);
        }
        if (i7 <= 0) {
            Log.w("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        if (this.mEG && this.mEF) {
            charSequence = this.mEv;
        } else if (!this.mEF) {
            charSequence = this.mEv.toString();
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mEv);
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
        Layout.Alignment alignment = this.mEw == null ? Layout.Alignment.ALIGN_CENTER : this.mEw;
        this.mEN = new StaticLayout(charSequence, this.textPaint, i7, alignment, this.mEt, this.mEu, true);
        int height = this.mEN.getHeight();
        int lineCount = this.mEN.getLineCount();
        int i8 = 0;
        int i9 = 0;
        while (i9 < lineCount) {
            int max = Math.max((int) Math.ceil(this.mEN.getLineWidth(i9)), i8);
            i9++;
            i8 = max;
        }
        if (this.mED == Float.MIN_VALUE || i8 >= i7) {
            i7 = i8;
        }
        int i10 = i7 + (i6 * 2);
        if (this.mEB != Float.MIN_VALUE) {
            int round2 = Math.round(i4 * this.mEB) + this.mEJ;
            if (this.mEC == 2) {
                round2 -= i10;
            } else if (this.mEC == 1) {
                round2 = ((round2 * 2) - i10) / 2;
            }
            int max2 = Math.max(round2, this.mEJ);
            i = Math.min(max2 + i10, this.mEL);
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
        if (this.mEy != Float.MIN_VALUE) {
            if (this.mEz == 0) {
                round = Math.round(i5 * this.mEy) + this.mEK;
            } else {
                int lineBottom = this.mEN.getLineBottom(0) - this.mEN.getLineTop(0);
                if (this.mEy >= 0.0f) {
                    round = Math.round(lineBottom * this.mEy) + this.mEK;
                } else {
                    round = Math.round(lineBottom * (this.mEy + 1.0f)) + this.mEM;
                }
            }
            if (this.mEA == 2) {
                round -= height;
            } else if (this.mEA == 1) {
                round = ((round * 2) - height) / 2;
            }
            if (round + height > this.mEM) {
                round = this.mEM - height;
            } else if (round < this.mEK) {
                round = this.mEK;
            }
            i3 = round;
        } else {
            i3 = (this.mEM - height) - ((int) (i5 * this.mEI));
        }
        this.mEN = new StaticLayout(charSequence, this.textPaint, i12, alignment, this.mEt, this.mEu, true);
        this.mEO = i2;
        this.mEP = i3;
        this.mEQ = i6;
    }

    private void dxD() {
        float f;
        int i = this.mEL - this.mEJ;
        int i2 = this.mEM - this.mEK;
        float f2 = this.mEJ + (i * this.mEB);
        float f3 = this.mEK + (i2 * this.mEy);
        int round = Math.round(i * this.mED);
        int round2 = this.mEE != Float.MIN_VALUE ? Math.round(i2 * this.mEE) : Math.round(round * (this.mEx.getHeight() / this.mEx.getWidth()));
        if (this.mEA == 2) {
            f2 -= round;
        } else if (this.mEA == 1) {
            f2 -= round / 2;
        }
        int round3 = Math.round(f2);
        if (this.mEC == 2) {
            f = f3 - round2;
        } else {
            f = this.mEC == 1 ? f3 - (round2 / 2) : f3;
        }
        int round4 = Math.round(f);
        this.mER = new Rect(round3, round4, round + round3, round2 + round4);
    }

    private void a(Canvas canvas, boolean z) {
        if (z) {
            ae(canvas);
        } else {
            af(canvas);
        }
    }

    private void ae(Canvas canvas) {
        StaticLayout staticLayout = this.mEN;
        if (staticLayout != null) {
            int save = canvas.save();
            canvas.translate(this.mEO, this.mEP);
            if (Color.alpha(this.mxK) > 0) {
                this.paint.setColor(this.mxK);
                canvas.drawRect(-this.mEQ, 0.0f, staticLayout.getWidth() + this.mEQ, staticLayout.getHeight(), this.paint);
            }
            if (Color.alpha(this.backgroundColor) > 0) {
                this.paint.setColor(this.backgroundColor);
                int lineCount = staticLayout.getLineCount();
                float lineTop = staticLayout.getLineTop(0);
                for (int i = 0; i < lineCount; i++) {
                    this.mEp.left = staticLayout.getLineLeft(i) - this.mEQ;
                    this.mEp.right = staticLayout.getLineRight(i) + this.mEQ;
                    this.mEp.top = lineTop;
                    this.mEp.bottom = staticLayout.getLineBottom(i);
                    lineTop = this.mEp.bottom;
                    canvas.drawRoundRect(this.mEp, this.aBn, this.aBn, this.paint);
                }
            }
            if (this.mxL == 1) {
                this.textPaint.setStrokeJoin(Paint.Join.ROUND);
                this.textPaint.setStrokeWidth(this.mEq);
                this.textPaint.setColor(this.mxM);
                this.textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                staticLayout.draw(canvas);
            } else if (this.mxL == 2) {
                this.textPaint.setShadowLayer(this.mEr, this.mEs, this.mEs, this.mxM);
            } else if (this.mxL == 3 || this.mxL == 4) {
                boolean z = this.mxL == 3;
                int i2 = z ? -1 : this.mxM;
                int i3 = z ? this.mxM : -1;
                float f = this.mEr / 2.0f;
                this.textPaint.setColor(this.foregroundColor);
                this.textPaint.setStyle(Paint.Style.FILL);
                this.textPaint.setShadowLayer(this.mEr, -f, -f, i2);
                staticLayout.draw(canvas);
                this.textPaint.setShadowLayer(this.mEr, f, f, i3);
            }
            this.textPaint.setColor(this.foregroundColor);
            this.textPaint.setStyle(Paint.Style.FILL);
            staticLayout.draw(canvas);
            this.textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            canvas.restoreToCount(save);
        }
    }

    private void af(Canvas canvas) {
        canvas.drawBitmap(this.mEx, (Rect) null, this.mER, (Paint) null);
    }

    private static boolean b(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }
}
