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
    private final float aFE;
    private int backgroundColor;
    private int foregroundColor;
    private int mFA;
    private StaticLayout mFB;
    private int mFC;
    private int mFD;
    private int mFE;
    private Rect mFF;
    private final RectF mFc = new RectF();
    private final float mFe;
    private final float mFf;
    private final float mFg;
    private final float mFh;
    private final float mFi;
    private CharSequence mFj;
    private Layout.Alignment mFk;
    private Bitmap mFl;
    private float mFm;
    private int mFn;
    private int mFo;
    private float mFp;
    private int mFq;
    private float mFr;
    private float mFs;
    private boolean mFt;
    private boolean mFu;
    private float mFv;
    private float mFw;
    private int mFx;
    private int mFy;
    private int mFz;
    private int myx;
    private int myy;
    private int myz;
    private final Paint paint;
    private final TextPaint textPaint;

    public b(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16843287, 16843288}, 0, 0);
        this.mFi = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.mFh = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        int round = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.aFE = round;
        this.mFe = round;
        this.mFf = round;
        this.mFg = round;
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
                i5 = (bVar.myI && z) ? bVar.myx : aVar.myx;
            } else {
                return;
            }
        }
        if (b(this.mFj, bVar.text) && v.h(this.mFk, bVar.myA) && this.mFl == bVar.bitmap && this.mFm == bVar.myB && this.mFn == bVar.myC && v.h(Integer.valueOf(this.mFo), Integer.valueOf(bVar.myD)) && this.mFp == bVar.myE && v.h(Integer.valueOf(this.mFq), Integer.valueOf(bVar.myF)) && this.mFr == bVar.myG && this.mFs == bVar.myH && this.mFt == z && this.mFu == z2 && this.foregroundColor == aVar.foregroundColor && this.backgroundColor == aVar.backgroundColor && this.myx == i5 && this.myy == aVar.myy && this.myz == aVar.myz && v.h(this.textPaint.getTypeface(), aVar.typeface) && this.mFv == f && this.mFw == f2 && this.mFx == i && this.mFy == i2 && this.mFz == i3 && this.mFA == i4) {
            a(canvas, z3);
            return;
        }
        this.mFj = bVar.text;
        this.mFk = bVar.myA;
        this.mFl = bVar.bitmap;
        this.mFm = bVar.myB;
        this.mFn = bVar.myC;
        this.mFo = bVar.myD;
        this.mFp = bVar.myE;
        this.mFq = bVar.myF;
        this.mFr = bVar.myG;
        this.mFs = bVar.myH;
        this.mFt = z;
        this.mFu = z2;
        this.foregroundColor = aVar.foregroundColor;
        this.backgroundColor = aVar.backgroundColor;
        this.myx = i5;
        this.myy = aVar.myy;
        this.myz = aVar.myz;
        this.textPaint.setTypeface(aVar.typeface);
        this.mFv = f;
        this.mFw = f2;
        this.mFx = i;
        this.mFy = i2;
        this.mFz = i3;
        this.mFA = i4;
        if (z3) {
            dyQ();
        } else {
            dyR();
        }
        a(canvas, z3);
    }

    private void dyQ() {
        CharSequence charSequence;
        int i;
        int i2;
        int i3;
        int round;
        int i4 = this.mFz - this.mFx;
        int i5 = this.mFA - this.mFy;
        this.textPaint.setTextSize(this.mFv);
        int i6 = (int) ((this.mFv * 0.125f) + 0.5f);
        int i7 = i4 - (i6 * 2);
        if (this.mFr != Float.MIN_VALUE) {
            i7 = (int) (i7 * this.mFr);
        }
        if (i7 <= 0) {
            Log.w("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        if (this.mFu && this.mFt) {
            charSequence = this.mFj;
        } else if (!this.mFt) {
            charSequence = this.mFj.toString();
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mFj);
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
        Layout.Alignment alignment = this.mFk == null ? Layout.Alignment.ALIGN_CENTER : this.mFk;
        this.mFB = new StaticLayout(charSequence, this.textPaint, i7, alignment, this.mFh, this.mFi, true);
        int height = this.mFB.getHeight();
        int lineCount = this.mFB.getLineCount();
        int i8 = 0;
        int i9 = 0;
        while (i9 < lineCount) {
            int max = Math.max((int) Math.ceil(this.mFB.getLineWidth(i9)), i8);
            i9++;
            i8 = max;
        }
        if (this.mFr == Float.MIN_VALUE || i8 >= i7) {
            i7 = i8;
        }
        int i10 = i7 + (i6 * 2);
        if (this.mFp != Float.MIN_VALUE) {
            int round2 = Math.round(i4 * this.mFp) + this.mFx;
            if (this.mFq == 2) {
                round2 -= i10;
            } else if (this.mFq == 1) {
                round2 = ((round2 * 2) - i10) / 2;
            }
            int max2 = Math.max(round2, this.mFx);
            i = Math.min(max2 + i10, this.mFz);
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
        if (this.mFm != Float.MIN_VALUE) {
            if (this.mFn == 0) {
                round = Math.round(i5 * this.mFm) + this.mFy;
            } else {
                int lineBottom = this.mFB.getLineBottom(0) - this.mFB.getLineTop(0);
                if (this.mFm >= 0.0f) {
                    round = Math.round(lineBottom * this.mFm) + this.mFy;
                } else {
                    round = Math.round(lineBottom * (this.mFm + 1.0f)) + this.mFA;
                }
            }
            if (this.mFo == 2) {
                round -= height;
            } else if (this.mFo == 1) {
                round = ((round * 2) - height) / 2;
            }
            if (round + height > this.mFA) {
                round = this.mFA - height;
            } else if (round < this.mFy) {
                round = this.mFy;
            }
            i3 = round;
        } else {
            i3 = (this.mFA - height) - ((int) (i5 * this.mFw));
        }
        this.mFB = new StaticLayout(charSequence, this.textPaint, i12, alignment, this.mFh, this.mFi, true);
        this.mFC = i2;
        this.mFD = i3;
        this.mFE = i6;
    }

    private void dyR() {
        float f;
        int i = this.mFz - this.mFx;
        int i2 = this.mFA - this.mFy;
        float f2 = this.mFx + (i * this.mFp);
        float f3 = this.mFy + (i2 * this.mFm);
        int round = Math.round(i * this.mFr);
        int round2 = this.mFs != Float.MIN_VALUE ? Math.round(i2 * this.mFs) : Math.round(round * (this.mFl.getHeight() / this.mFl.getWidth()));
        if (this.mFo == 2) {
            f2 -= round;
        } else if (this.mFo == 1) {
            f2 -= round / 2;
        }
        int round3 = Math.round(f2);
        if (this.mFq == 2) {
            f = f3 - round2;
        } else {
            f = this.mFq == 1 ? f3 - (round2 / 2) : f3;
        }
        int round4 = Math.round(f);
        this.mFF = new Rect(round3, round4, round + round3, round2 + round4);
    }

    private void a(Canvas canvas, boolean z) {
        if (z) {
            ae(canvas);
        } else {
            af(canvas);
        }
    }

    private void ae(Canvas canvas) {
        StaticLayout staticLayout = this.mFB;
        if (staticLayout != null) {
            int save = canvas.save();
            canvas.translate(this.mFC, this.mFD);
            if (Color.alpha(this.myx) > 0) {
                this.paint.setColor(this.myx);
                canvas.drawRect(-this.mFE, 0.0f, staticLayout.getWidth() + this.mFE, staticLayout.getHeight(), this.paint);
            }
            if (Color.alpha(this.backgroundColor) > 0) {
                this.paint.setColor(this.backgroundColor);
                int lineCount = staticLayout.getLineCount();
                float lineTop = staticLayout.getLineTop(0);
                for (int i = 0; i < lineCount; i++) {
                    this.mFc.left = staticLayout.getLineLeft(i) - this.mFE;
                    this.mFc.right = staticLayout.getLineRight(i) + this.mFE;
                    this.mFc.top = lineTop;
                    this.mFc.bottom = staticLayout.getLineBottom(i);
                    lineTop = this.mFc.bottom;
                    canvas.drawRoundRect(this.mFc, this.aFE, this.aFE, this.paint);
                }
            }
            if (this.myy == 1) {
                this.textPaint.setStrokeJoin(Paint.Join.ROUND);
                this.textPaint.setStrokeWidth(this.mFe);
                this.textPaint.setColor(this.myz);
                this.textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                staticLayout.draw(canvas);
            } else if (this.myy == 2) {
                this.textPaint.setShadowLayer(this.mFf, this.mFg, this.mFg, this.myz);
            } else if (this.myy == 3 || this.myy == 4) {
                boolean z = this.myy == 3;
                int i2 = z ? -1 : this.myz;
                int i3 = z ? this.myz : -1;
                float f = this.mFf / 2.0f;
                this.textPaint.setColor(this.foregroundColor);
                this.textPaint.setStyle(Paint.Style.FILL);
                this.textPaint.setShadowLayer(this.mFf, -f, -f, i2);
                staticLayout.draw(canvas);
                this.textPaint.setShadowLayer(this.mFf, f, f, i3);
            }
            this.textPaint.setColor(this.foregroundColor);
            this.textPaint.setStyle(Paint.Style.FILL);
            staticLayout.draw(canvas);
            this.textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            canvas.restoreToCount(save);
        }
    }

    private void af(Canvas canvas) {
        canvas.drawBitmap(this.mFl, (Rect) null, this.mFF, (Paint) null);
    }

    private static boolean b(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }
}
