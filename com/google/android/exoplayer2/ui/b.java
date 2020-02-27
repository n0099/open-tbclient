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
    private final float aFD;
    private int backgroundColor;
    private int foregroundColor;
    private int mFA;
    private int mFB;
    private int mFC;
    private Rect mFD;
    private final RectF mFa = new RectF();
    private final float mFb;
    private final float mFc;
    private final float mFe;
    private final float mFf;
    private final float mFg;
    private CharSequence mFh;
    private Layout.Alignment mFi;
    private Bitmap mFj;
    private float mFk;
    private int mFl;
    private int mFm;
    private float mFn;
    private int mFo;
    private float mFp;
    private float mFq;
    private boolean mFr;
    private boolean mFs;
    private float mFt;
    private float mFu;
    private int mFv;
    private int mFw;
    private int mFx;
    private int mFy;
    private StaticLayout mFz;
    private int myv;
    private int myw;
    private int myx;
    private final Paint paint;
    private final TextPaint textPaint;

    public b(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16843287, 16843288}, 0, 0);
        this.mFg = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.mFf = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        int round = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.aFD = round;
        this.mFb = round;
        this.mFc = round;
        this.mFe = round;
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
                i5 = (bVar.myG && z) ? bVar.myv : aVar.myv;
            } else {
                return;
            }
        }
        if (b(this.mFh, bVar.text) && v.h(this.mFi, bVar.myy) && this.mFj == bVar.bitmap && this.mFk == bVar.myz && this.mFl == bVar.myA && v.h(Integer.valueOf(this.mFm), Integer.valueOf(bVar.myB)) && this.mFn == bVar.myC && v.h(Integer.valueOf(this.mFo), Integer.valueOf(bVar.myD)) && this.mFp == bVar.myE && this.mFq == bVar.myF && this.mFr == z && this.mFs == z2 && this.foregroundColor == aVar.foregroundColor && this.backgroundColor == aVar.backgroundColor && this.myv == i5 && this.myw == aVar.myw && this.myx == aVar.myx && v.h(this.textPaint.getTypeface(), aVar.typeface) && this.mFt == f && this.mFu == f2 && this.mFv == i && this.mFw == i2 && this.mFx == i3 && this.mFy == i4) {
            a(canvas, z3);
            return;
        }
        this.mFh = bVar.text;
        this.mFi = bVar.myy;
        this.mFj = bVar.bitmap;
        this.mFk = bVar.myz;
        this.mFl = bVar.myA;
        this.mFm = bVar.myB;
        this.mFn = bVar.myC;
        this.mFo = bVar.myD;
        this.mFp = bVar.myE;
        this.mFq = bVar.myF;
        this.mFr = z;
        this.mFs = z2;
        this.foregroundColor = aVar.foregroundColor;
        this.backgroundColor = aVar.backgroundColor;
        this.myv = i5;
        this.myw = aVar.myw;
        this.myx = aVar.myx;
        this.textPaint.setTypeface(aVar.typeface);
        this.mFt = f;
        this.mFu = f2;
        this.mFv = i;
        this.mFw = i2;
        this.mFx = i3;
        this.mFy = i4;
        if (z3) {
            dyO();
        } else {
            dyP();
        }
        a(canvas, z3);
    }

    private void dyO() {
        CharSequence charSequence;
        int i;
        int i2;
        int i3;
        int round;
        int i4 = this.mFx - this.mFv;
        int i5 = this.mFy - this.mFw;
        this.textPaint.setTextSize(this.mFt);
        int i6 = (int) ((this.mFt * 0.125f) + 0.5f);
        int i7 = i4 - (i6 * 2);
        if (this.mFp != Float.MIN_VALUE) {
            i7 = (int) (i7 * this.mFp);
        }
        if (i7 <= 0) {
            Log.w("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        if (this.mFs && this.mFr) {
            charSequence = this.mFh;
        } else if (!this.mFr) {
            charSequence = this.mFh.toString();
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mFh);
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
        Layout.Alignment alignment = this.mFi == null ? Layout.Alignment.ALIGN_CENTER : this.mFi;
        this.mFz = new StaticLayout(charSequence, this.textPaint, i7, alignment, this.mFf, this.mFg, true);
        int height = this.mFz.getHeight();
        int lineCount = this.mFz.getLineCount();
        int i8 = 0;
        int i9 = 0;
        while (i9 < lineCount) {
            int max = Math.max((int) Math.ceil(this.mFz.getLineWidth(i9)), i8);
            i9++;
            i8 = max;
        }
        if (this.mFp == Float.MIN_VALUE || i8 >= i7) {
            i7 = i8;
        }
        int i10 = i7 + (i6 * 2);
        if (this.mFn != Float.MIN_VALUE) {
            int round2 = Math.round(i4 * this.mFn) + this.mFv;
            if (this.mFo == 2) {
                round2 -= i10;
            } else if (this.mFo == 1) {
                round2 = ((round2 * 2) - i10) / 2;
            }
            int max2 = Math.max(round2, this.mFv);
            i = Math.min(max2 + i10, this.mFx);
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
        if (this.mFk != Float.MIN_VALUE) {
            if (this.mFl == 0) {
                round = Math.round(i5 * this.mFk) + this.mFw;
            } else {
                int lineBottom = this.mFz.getLineBottom(0) - this.mFz.getLineTop(0);
                if (this.mFk >= 0.0f) {
                    round = Math.round(lineBottom * this.mFk) + this.mFw;
                } else {
                    round = Math.round(lineBottom * (this.mFk + 1.0f)) + this.mFy;
                }
            }
            if (this.mFm == 2) {
                round -= height;
            } else if (this.mFm == 1) {
                round = ((round * 2) - height) / 2;
            }
            if (round + height > this.mFy) {
                round = this.mFy - height;
            } else if (round < this.mFw) {
                round = this.mFw;
            }
            i3 = round;
        } else {
            i3 = (this.mFy - height) - ((int) (i5 * this.mFu));
        }
        this.mFz = new StaticLayout(charSequence, this.textPaint, i12, alignment, this.mFf, this.mFg, true);
        this.mFA = i2;
        this.mFB = i3;
        this.mFC = i6;
    }

    private void dyP() {
        float f;
        int i = this.mFx - this.mFv;
        int i2 = this.mFy - this.mFw;
        float f2 = this.mFv + (i * this.mFn);
        float f3 = this.mFw + (i2 * this.mFk);
        int round = Math.round(i * this.mFp);
        int round2 = this.mFq != Float.MIN_VALUE ? Math.round(i2 * this.mFq) : Math.round(round * (this.mFj.getHeight() / this.mFj.getWidth()));
        if (this.mFm == 2) {
            f2 -= round;
        } else if (this.mFm == 1) {
            f2 -= round / 2;
        }
        int round3 = Math.round(f2);
        if (this.mFo == 2) {
            f = f3 - round2;
        } else {
            f = this.mFo == 1 ? f3 - (round2 / 2) : f3;
        }
        int round4 = Math.round(f);
        this.mFD = new Rect(round3, round4, round + round3, round2 + round4);
    }

    private void a(Canvas canvas, boolean z) {
        if (z) {
            ae(canvas);
        } else {
            af(canvas);
        }
    }

    private void ae(Canvas canvas) {
        StaticLayout staticLayout = this.mFz;
        if (staticLayout != null) {
            int save = canvas.save();
            canvas.translate(this.mFA, this.mFB);
            if (Color.alpha(this.myv) > 0) {
                this.paint.setColor(this.myv);
                canvas.drawRect(-this.mFC, 0.0f, staticLayout.getWidth() + this.mFC, staticLayout.getHeight(), this.paint);
            }
            if (Color.alpha(this.backgroundColor) > 0) {
                this.paint.setColor(this.backgroundColor);
                int lineCount = staticLayout.getLineCount();
                float lineTop = staticLayout.getLineTop(0);
                for (int i = 0; i < lineCount; i++) {
                    this.mFa.left = staticLayout.getLineLeft(i) - this.mFC;
                    this.mFa.right = staticLayout.getLineRight(i) + this.mFC;
                    this.mFa.top = lineTop;
                    this.mFa.bottom = staticLayout.getLineBottom(i);
                    lineTop = this.mFa.bottom;
                    canvas.drawRoundRect(this.mFa, this.aFD, this.aFD, this.paint);
                }
            }
            if (this.myw == 1) {
                this.textPaint.setStrokeJoin(Paint.Join.ROUND);
                this.textPaint.setStrokeWidth(this.mFb);
                this.textPaint.setColor(this.myx);
                this.textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                staticLayout.draw(canvas);
            } else if (this.myw == 2) {
                this.textPaint.setShadowLayer(this.mFc, this.mFe, this.mFe, this.myx);
            } else if (this.myw == 3 || this.myw == 4) {
                boolean z = this.myw == 3;
                int i2 = z ? -1 : this.myx;
                int i3 = z ? this.myx : -1;
                float f = this.mFc / 2.0f;
                this.textPaint.setColor(this.foregroundColor);
                this.textPaint.setStyle(Paint.Style.FILL);
                this.textPaint.setShadowLayer(this.mFc, -f, -f, i2);
                staticLayout.draw(canvas);
                this.textPaint.setShadowLayer(this.mFc, f, f, i3);
            }
            this.textPaint.setColor(this.foregroundColor);
            this.textPaint.setStyle(Paint.Style.FILL);
            staticLayout.draw(canvas);
            this.textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            canvas.restoreToCount(save);
        }
    }

    private void af(Canvas canvas) {
        canvas.drawBitmap(this.mFj, (Rect) null, this.mFD, (Paint) null);
    }

    private static boolean b(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }
}
