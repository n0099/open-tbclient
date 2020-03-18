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
/* loaded from: classes6.dex */
final class b {
    private final float aFT;
    private int backgroundColor;
    private int foregroundColor;
    private int mAp;
    private int mAq;
    private int mAr;
    private final RectF mGU = new RectF();
    private final float mGV;
    private final float mGW;
    private final float mGX;
    private final float mGY;
    private final float mGZ;
    private CharSequence mHa;
    private Layout.Alignment mHb;
    private Bitmap mHc;
    private float mHd;
    private int mHe;
    private int mHf;
    private float mHg;
    private int mHh;
    private float mHi;
    private float mHj;
    private boolean mHk;
    private boolean mHl;
    private float mHm;
    private float mHn;
    private int mHo;
    private int mHp;
    private int mHq;
    private int mHr;
    private StaticLayout mHs;
    private int mHt;
    private int mHu;
    private int mHv;
    private Rect mHw;
    private final Paint paint;
    private final TextPaint textPaint;

    public b(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16843287, 16843288}, 0, 0);
        this.mGZ = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.mGY = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        int round = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.aFT = round;
        this.mGV = round;
        this.mGW = round;
        this.mGX = round;
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
                i5 = (bVar.mAA && z) ? bVar.mAp : aVar.mAp;
            } else {
                return;
            }
        }
        if (b(this.mHa, bVar.text) && v.h(this.mHb, bVar.mAs) && this.mHc == bVar.bitmap && this.mHd == bVar.mAt && this.mHe == bVar.mAu && v.h(Integer.valueOf(this.mHf), Integer.valueOf(bVar.mAv)) && this.mHg == bVar.mAw && v.h(Integer.valueOf(this.mHh), Integer.valueOf(bVar.mAx)) && this.mHi == bVar.mAy && this.mHj == bVar.mAz && this.mHk == z && this.mHl == z2 && this.foregroundColor == aVar.foregroundColor && this.backgroundColor == aVar.backgroundColor && this.mAp == i5 && this.mAq == aVar.mAq && this.mAr == aVar.mAr && v.h(this.textPaint.getTypeface(), aVar.typeface) && this.mHm == f && this.mHn == f2 && this.mHo == i && this.mHp == i2 && this.mHq == i3 && this.mHr == i4) {
            a(canvas, z3);
            return;
        }
        this.mHa = bVar.text;
        this.mHb = bVar.mAs;
        this.mHc = bVar.bitmap;
        this.mHd = bVar.mAt;
        this.mHe = bVar.mAu;
        this.mHf = bVar.mAv;
        this.mHg = bVar.mAw;
        this.mHh = bVar.mAx;
        this.mHi = bVar.mAy;
        this.mHj = bVar.mAz;
        this.mHk = z;
        this.mHl = z2;
        this.foregroundColor = aVar.foregroundColor;
        this.backgroundColor = aVar.backgroundColor;
        this.mAp = i5;
        this.mAq = aVar.mAq;
        this.mAr = aVar.mAr;
        this.textPaint.setTypeface(aVar.typeface);
        this.mHm = f;
        this.mHn = f2;
        this.mHo = i;
        this.mHp = i2;
        this.mHq = i3;
        this.mHr = i4;
        if (z3) {
            dzo();
        } else {
            dzp();
        }
        a(canvas, z3);
    }

    private void dzo() {
        CharSequence charSequence;
        int i;
        int i2;
        int i3;
        int round;
        int i4 = this.mHq - this.mHo;
        int i5 = this.mHr - this.mHp;
        this.textPaint.setTextSize(this.mHm);
        int i6 = (int) ((this.mHm * 0.125f) + 0.5f);
        int i7 = i4 - (i6 * 2);
        if (this.mHi != Float.MIN_VALUE) {
            i7 = (int) (i7 * this.mHi);
        }
        if (i7 <= 0) {
            Log.w("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        if (this.mHl && this.mHk) {
            charSequence = this.mHa;
        } else if (!this.mHk) {
            charSequence = this.mHa.toString();
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mHa);
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
        Layout.Alignment alignment = this.mHb == null ? Layout.Alignment.ALIGN_CENTER : this.mHb;
        this.mHs = new StaticLayout(charSequence, this.textPaint, i7, alignment, this.mGY, this.mGZ, true);
        int height = this.mHs.getHeight();
        int lineCount = this.mHs.getLineCount();
        int i8 = 0;
        int i9 = 0;
        while (i9 < lineCount) {
            int max = Math.max((int) Math.ceil(this.mHs.getLineWidth(i9)), i8);
            i9++;
            i8 = max;
        }
        if (this.mHi == Float.MIN_VALUE || i8 >= i7) {
            i7 = i8;
        }
        int i10 = i7 + (i6 * 2);
        if (this.mHg != Float.MIN_VALUE) {
            int round2 = Math.round(i4 * this.mHg) + this.mHo;
            if (this.mHh == 2) {
                round2 -= i10;
            } else if (this.mHh == 1) {
                round2 = ((round2 * 2) - i10) / 2;
            }
            int max2 = Math.max(round2, this.mHo);
            i = Math.min(max2 + i10, this.mHq);
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
        if (this.mHd != Float.MIN_VALUE) {
            if (this.mHe == 0) {
                round = Math.round(i5 * this.mHd) + this.mHp;
            } else {
                int lineBottom = this.mHs.getLineBottom(0) - this.mHs.getLineTop(0);
                if (this.mHd >= 0.0f) {
                    round = Math.round(lineBottom * this.mHd) + this.mHp;
                } else {
                    round = Math.round(lineBottom * (this.mHd + 1.0f)) + this.mHr;
                }
            }
            if (this.mHf == 2) {
                round -= height;
            } else if (this.mHf == 1) {
                round = ((round * 2) - height) / 2;
            }
            if (round + height > this.mHr) {
                round = this.mHr - height;
            } else if (round < this.mHp) {
                round = this.mHp;
            }
            i3 = round;
        } else {
            i3 = (this.mHr - height) - ((int) (i5 * this.mHn));
        }
        this.mHs = new StaticLayout(charSequence, this.textPaint, i12, alignment, this.mGY, this.mGZ, true);
        this.mHt = i2;
        this.mHu = i3;
        this.mHv = i6;
    }

    private void dzp() {
        float f;
        int i = this.mHq - this.mHo;
        int i2 = this.mHr - this.mHp;
        float f2 = this.mHo + (i * this.mHg);
        float f3 = this.mHp + (i2 * this.mHd);
        int round = Math.round(i * this.mHi);
        int round2 = this.mHj != Float.MIN_VALUE ? Math.round(i2 * this.mHj) : Math.round(round * (this.mHc.getHeight() / this.mHc.getWidth()));
        if (this.mHf == 2) {
            f2 -= round;
        } else if (this.mHf == 1) {
            f2 -= round / 2;
        }
        int round3 = Math.round(f2);
        if (this.mHh == 2) {
            f = f3 - round2;
        } else {
            f = this.mHh == 1 ? f3 - (round2 / 2) : f3;
        }
        int round4 = Math.round(f);
        this.mHw = new Rect(round3, round4, round + round3, round2 + round4);
    }

    private void a(Canvas canvas, boolean z) {
        if (z) {
            af(canvas);
        } else {
            ag(canvas);
        }
    }

    private void af(Canvas canvas) {
        StaticLayout staticLayout = this.mHs;
        if (staticLayout != null) {
            int save = canvas.save();
            canvas.translate(this.mHt, this.mHu);
            if (Color.alpha(this.mAp) > 0) {
                this.paint.setColor(this.mAp);
                canvas.drawRect(-this.mHv, 0.0f, staticLayout.getWidth() + this.mHv, staticLayout.getHeight(), this.paint);
            }
            if (Color.alpha(this.backgroundColor) > 0) {
                this.paint.setColor(this.backgroundColor);
                int lineCount = staticLayout.getLineCount();
                float lineTop = staticLayout.getLineTop(0);
                for (int i = 0; i < lineCount; i++) {
                    this.mGU.left = staticLayout.getLineLeft(i) - this.mHv;
                    this.mGU.right = staticLayout.getLineRight(i) + this.mHv;
                    this.mGU.top = lineTop;
                    this.mGU.bottom = staticLayout.getLineBottom(i);
                    lineTop = this.mGU.bottom;
                    canvas.drawRoundRect(this.mGU, this.aFT, this.aFT, this.paint);
                }
            }
            if (this.mAq == 1) {
                this.textPaint.setStrokeJoin(Paint.Join.ROUND);
                this.textPaint.setStrokeWidth(this.mGV);
                this.textPaint.setColor(this.mAr);
                this.textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                staticLayout.draw(canvas);
            } else if (this.mAq == 2) {
                this.textPaint.setShadowLayer(this.mGW, this.mGX, this.mGX, this.mAr);
            } else if (this.mAq == 3 || this.mAq == 4) {
                boolean z = this.mAq == 3;
                int i2 = z ? -1 : this.mAr;
                int i3 = z ? this.mAr : -1;
                float f = this.mGW / 2.0f;
                this.textPaint.setColor(this.foregroundColor);
                this.textPaint.setStyle(Paint.Style.FILL);
                this.textPaint.setShadowLayer(this.mGW, -f, -f, i2);
                staticLayout.draw(canvas);
                this.textPaint.setShadowLayer(this.mGW, f, f, i3);
            }
            this.textPaint.setColor(this.foregroundColor);
            this.textPaint.setStyle(Paint.Style.FILL);
            staticLayout.draw(canvas);
            this.textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            canvas.restoreToCount(save);
        }
    }

    private void ag(Canvas canvas) {
        canvas.drawBitmap(this.mHc, (Rect) null, this.mHw, (Paint) null);
    }

    private static boolean b(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }
}
