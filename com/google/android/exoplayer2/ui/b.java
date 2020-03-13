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
    private final float aFF;
    private int backgroundColor;
    private int foregroundColor;
    private float mFA;
    private int mFB;
    private float mFC;
    private float mFD;
    private boolean mFE;
    private boolean mFF;
    private float mFG;
    private float mFH;
    private int mFI;
    private int mFJ;
    private int mFK;
    private int mFL;
    private StaticLayout mFM;
    private int mFN;
    private int mFO;
    private int mFP;
    private Rect mFQ;
    private final RectF mFo = new RectF();
    private final float mFp;
    private final float mFq;
    private final float mFr;
    private final float mFs;
    private final float mFt;
    private CharSequence mFu;
    private Layout.Alignment mFv;
    private Bitmap mFw;
    private float mFx;
    private int mFy;
    private int mFz;
    private int myI;
    private int myJ;
    private int myK;
    private final Paint paint;
    private final TextPaint textPaint;

    public b(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16843287, 16843288}, 0, 0);
        this.mFt = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.mFs = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        int round = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.aFF = round;
        this.mFp = round;
        this.mFq = round;
        this.mFr = round;
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
                i5 = (bVar.myT && z) ? bVar.myI : aVar.myI;
            } else {
                return;
            }
        }
        if (b(this.mFu, bVar.text) && v.h(this.mFv, bVar.myL) && this.mFw == bVar.bitmap && this.mFx == bVar.myM && this.mFy == bVar.myN && v.h(Integer.valueOf(this.mFz), Integer.valueOf(bVar.myO)) && this.mFA == bVar.myP && v.h(Integer.valueOf(this.mFB), Integer.valueOf(bVar.myQ)) && this.mFC == bVar.myR && this.mFD == bVar.myS && this.mFE == z && this.mFF == z2 && this.foregroundColor == aVar.foregroundColor && this.backgroundColor == aVar.backgroundColor && this.myI == i5 && this.myJ == aVar.myJ && this.myK == aVar.myK && v.h(this.textPaint.getTypeface(), aVar.typeface) && this.mFG == f && this.mFH == f2 && this.mFI == i && this.mFJ == i2 && this.mFK == i3 && this.mFL == i4) {
            a(canvas, z3);
            return;
        }
        this.mFu = bVar.text;
        this.mFv = bVar.myL;
        this.mFw = bVar.bitmap;
        this.mFx = bVar.myM;
        this.mFy = bVar.myN;
        this.mFz = bVar.myO;
        this.mFA = bVar.myP;
        this.mFB = bVar.myQ;
        this.mFC = bVar.myR;
        this.mFD = bVar.myS;
        this.mFE = z;
        this.mFF = z2;
        this.foregroundColor = aVar.foregroundColor;
        this.backgroundColor = aVar.backgroundColor;
        this.myI = i5;
        this.myJ = aVar.myJ;
        this.myK = aVar.myK;
        this.textPaint.setTypeface(aVar.typeface);
        this.mFG = f;
        this.mFH = f2;
        this.mFI = i;
        this.mFJ = i2;
        this.mFK = i3;
        this.mFL = i4;
        if (z3) {
            dyR();
        } else {
            dyS();
        }
        a(canvas, z3);
    }

    private void dyR() {
        CharSequence charSequence;
        int i;
        int i2;
        int i3;
        int round;
        int i4 = this.mFK - this.mFI;
        int i5 = this.mFL - this.mFJ;
        this.textPaint.setTextSize(this.mFG);
        int i6 = (int) ((this.mFG * 0.125f) + 0.5f);
        int i7 = i4 - (i6 * 2);
        if (this.mFC != Float.MIN_VALUE) {
            i7 = (int) (i7 * this.mFC);
        }
        if (i7 <= 0) {
            Log.w("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        if (this.mFF && this.mFE) {
            charSequence = this.mFu;
        } else if (!this.mFE) {
            charSequence = this.mFu.toString();
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mFu);
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
        Layout.Alignment alignment = this.mFv == null ? Layout.Alignment.ALIGN_CENTER : this.mFv;
        this.mFM = new StaticLayout(charSequence, this.textPaint, i7, alignment, this.mFs, this.mFt, true);
        int height = this.mFM.getHeight();
        int lineCount = this.mFM.getLineCount();
        int i8 = 0;
        int i9 = 0;
        while (i9 < lineCount) {
            int max = Math.max((int) Math.ceil(this.mFM.getLineWidth(i9)), i8);
            i9++;
            i8 = max;
        }
        if (this.mFC == Float.MIN_VALUE || i8 >= i7) {
            i7 = i8;
        }
        int i10 = i7 + (i6 * 2);
        if (this.mFA != Float.MIN_VALUE) {
            int round2 = Math.round(i4 * this.mFA) + this.mFI;
            if (this.mFB == 2) {
                round2 -= i10;
            } else if (this.mFB == 1) {
                round2 = ((round2 * 2) - i10) / 2;
            }
            int max2 = Math.max(round2, this.mFI);
            i = Math.min(max2 + i10, this.mFK);
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
        if (this.mFx != Float.MIN_VALUE) {
            if (this.mFy == 0) {
                round = Math.round(i5 * this.mFx) + this.mFJ;
            } else {
                int lineBottom = this.mFM.getLineBottom(0) - this.mFM.getLineTop(0);
                if (this.mFx >= 0.0f) {
                    round = Math.round(lineBottom * this.mFx) + this.mFJ;
                } else {
                    round = Math.round(lineBottom * (this.mFx + 1.0f)) + this.mFL;
                }
            }
            if (this.mFz == 2) {
                round -= height;
            } else if (this.mFz == 1) {
                round = ((round * 2) - height) / 2;
            }
            if (round + height > this.mFL) {
                round = this.mFL - height;
            } else if (round < this.mFJ) {
                round = this.mFJ;
            }
            i3 = round;
        } else {
            i3 = (this.mFL - height) - ((int) (i5 * this.mFH));
        }
        this.mFM = new StaticLayout(charSequence, this.textPaint, i12, alignment, this.mFs, this.mFt, true);
        this.mFN = i2;
        this.mFO = i3;
        this.mFP = i6;
    }

    private void dyS() {
        float f;
        int i = this.mFK - this.mFI;
        int i2 = this.mFL - this.mFJ;
        float f2 = this.mFI + (i * this.mFA);
        float f3 = this.mFJ + (i2 * this.mFx);
        int round = Math.round(i * this.mFC);
        int round2 = this.mFD != Float.MIN_VALUE ? Math.round(i2 * this.mFD) : Math.round(round * (this.mFw.getHeight() / this.mFw.getWidth()));
        if (this.mFz == 2) {
            f2 -= round;
        } else if (this.mFz == 1) {
            f2 -= round / 2;
        }
        int round3 = Math.round(f2);
        if (this.mFB == 2) {
            f = f3 - round2;
        } else {
            f = this.mFB == 1 ? f3 - (round2 / 2) : f3;
        }
        int round4 = Math.round(f);
        this.mFQ = new Rect(round3, round4, round + round3, round2 + round4);
    }

    private void a(Canvas canvas, boolean z) {
        if (z) {
            ae(canvas);
        } else {
            af(canvas);
        }
    }

    private void ae(Canvas canvas) {
        StaticLayout staticLayout = this.mFM;
        if (staticLayout != null) {
            int save = canvas.save();
            canvas.translate(this.mFN, this.mFO);
            if (Color.alpha(this.myI) > 0) {
                this.paint.setColor(this.myI);
                canvas.drawRect(-this.mFP, 0.0f, staticLayout.getWidth() + this.mFP, staticLayout.getHeight(), this.paint);
            }
            if (Color.alpha(this.backgroundColor) > 0) {
                this.paint.setColor(this.backgroundColor);
                int lineCount = staticLayout.getLineCount();
                float lineTop = staticLayout.getLineTop(0);
                for (int i = 0; i < lineCount; i++) {
                    this.mFo.left = staticLayout.getLineLeft(i) - this.mFP;
                    this.mFo.right = staticLayout.getLineRight(i) + this.mFP;
                    this.mFo.top = lineTop;
                    this.mFo.bottom = staticLayout.getLineBottom(i);
                    lineTop = this.mFo.bottom;
                    canvas.drawRoundRect(this.mFo, this.aFF, this.aFF, this.paint);
                }
            }
            if (this.myJ == 1) {
                this.textPaint.setStrokeJoin(Paint.Join.ROUND);
                this.textPaint.setStrokeWidth(this.mFp);
                this.textPaint.setColor(this.myK);
                this.textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                staticLayout.draw(canvas);
            } else if (this.myJ == 2) {
                this.textPaint.setShadowLayer(this.mFq, this.mFr, this.mFr, this.myK);
            } else if (this.myJ == 3 || this.myJ == 4) {
                boolean z = this.myJ == 3;
                int i2 = z ? -1 : this.myK;
                int i3 = z ? this.myK : -1;
                float f = this.mFq / 2.0f;
                this.textPaint.setColor(this.foregroundColor);
                this.textPaint.setStyle(Paint.Style.FILL);
                this.textPaint.setShadowLayer(this.mFq, -f, -f, i2);
                staticLayout.draw(canvas);
                this.textPaint.setShadowLayer(this.mFq, f, f, i3);
            }
            this.textPaint.setColor(this.foregroundColor);
            this.textPaint.setStyle(Paint.Style.FILL);
            staticLayout.draw(canvas);
            this.textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            canvas.restoreToCount(save);
        }
    }

    private void af(Canvas canvas) {
        canvas.drawBitmap(this.mFw, (Rect) null, this.mFQ, (Paint) null);
    }

    private static boolean b(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }
}
