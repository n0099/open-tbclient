package com.facebook.drawee.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class k extends BitmapDrawable implements j, o {
    private final Paint GF;
    private int GW;
    private final Path deM;
    private boolean kcD;
    private boolean kcE;
    private final float[] kcF;
    final float[] kcG;
    final RectF kcH;
    final RectF kcI;
    final RectF kcJ;
    final RectF kcK;
    final Matrix kcL;
    final Matrix kcM;
    final Matrix kcN;
    final Matrix kcO;
    final Matrix kcP;
    final Matrix kcQ;
    private float kcR;
    private boolean kcS;
    private boolean kcT;
    private WeakReference<Bitmap> kcU;
    @Nullable
    private p kcd;
    private float mBorderWidth;
    private final Paint mPaint;
    private final Path mPath;

    public k(Resources resources, Bitmap bitmap, @Nullable Paint paint) {
        super(resources, bitmap);
        this.kcD = false;
        this.kcE = false;
        this.kcF = new float[8];
        this.kcG = new float[8];
        this.kcH = new RectF();
        this.kcI = new RectF();
        this.kcJ = new RectF();
        this.kcK = new RectF();
        this.kcL = new Matrix();
        this.kcM = new Matrix();
        this.kcN = new Matrix();
        this.kcO = new Matrix();
        this.kcP = new Matrix();
        this.kcQ = new Matrix();
        this.mBorderWidth = 0.0f;
        this.GW = 0;
        this.kcR = 0.0f;
        this.mPath = new Path();
        this.deM = new Path();
        this.kcS = true;
        this.mPaint = new Paint();
        this.GF = new Paint(1);
        this.kcT = true;
        if (paint != null) {
            this.mPaint.set(paint);
        }
        this.mPaint.setFlags(1);
        this.GF.setStyle(Paint.Style.STROKE);
    }

    @Override // com.facebook.drawee.drawable.j
    public void sx(boolean z) {
        this.kcD = z;
        this.kcS = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.kcF, f);
        this.kcE = f != 0.0f;
        this.kcS = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void j(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.kcF, 0.0f);
            this.kcE = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.kcF, 0, 8);
            this.kcE = false;
            for (int i = 0; i < 8; i++) {
                this.kcE = (fArr[i] > 0.0f) | this.kcE;
            }
        }
        this.kcS = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void l(int i, float f) {
        if (this.GW != i || this.mBorderWidth != f) {
            this.GW = i;
            this.mBorderWidth = f;
            this.kcS = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void ba(float f) {
        if (this.kcR != f) {
            this.kcR = f;
            this.kcS = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.o
    public void a(@Nullable p pVar) {
        this.kcd = pVar;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i);
            super.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        super.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!cGr()) {
            super.draw(canvas);
            return;
        }
        cGs();
        cGt();
        lw();
        int save = canvas.save();
        canvas.concat(this.kcP);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth > 0.0f) {
            this.GF.setStrokeWidth(this.mBorderWidth);
            this.GF.setColor(e.cM(this.GW, this.mPaint.getAlpha()));
            canvas.drawPath(this.deM, this.GF);
        }
        canvas.restoreToCount(save);
    }

    boolean cGr() {
        return this.kcD || this.kcE || this.mBorderWidth > 0.0f;
    }

    private void cGs() {
        if (this.kcd != null) {
            this.kcd.e(this.kcN);
            this.kcd.b(this.kcH);
        } else {
            this.kcN.reset();
            this.kcH.set(getBounds());
        }
        this.kcJ.set(0.0f, 0.0f, getBitmap().getWidth(), getBitmap().getHeight());
        this.kcK.set(getBounds());
        this.kcL.setRectToRect(this.kcJ, this.kcK, Matrix.ScaleToFit.FILL);
        if (!this.kcN.equals(this.kcO) || !this.kcL.equals(this.kcM)) {
            this.kcT = true;
            this.kcN.invert(this.kcP);
            this.kcQ.set(this.kcN);
            this.kcQ.preConcat(this.kcL);
            this.kcO.set(this.kcN);
            this.kcM.set(this.kcL);
        }
        if (!this.kcH.equals(this.kcI)) {
            this.kcS = true;
            this.kcI.set(this.kcH);
        }
    }

    private void cGt() {
        if (this.kcS) {
            this.deM.reset();
            this.kcH.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.kcD) {
                this.deM.addCircle(this.kcH.centerX(), this.kcH.centerY(), Math.min(this.kcH.width(), this.kcH.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.kcG.length; i++) {
                    this.kcG[i] = (this.kcF[i] + this.kcR) - (this.mBorderWidth / 2.0f);
                }
                this.deM.addRoundRect(this.kcH, this.kcG, Path.Direction.CW);
            }
            this.kcH.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            this.kcH.inset(this.kcR, this.kcR);
            if (this.kcD) {
                this.mPath.addCircle(this.kcH.centerX(), this.kcH.centerY(), Math.min(this.kcH.width(), this.kcH.height()) / 2.0f, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.kcH, this.kcF, Path.Direction.CW);
            }
            this.kcH.inset(-this.kcR, -this.kcR);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.kcS = false;
        }
    }

    private void lw() {
        Bitmap bitmap = getBitmap();
        if (this.kcU == null || this.kcU.get() != bitmap) {
            this.kcU = new WeakReference<>(bitmap);
            this.mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.kcT = true;
        }
        if (this.kcT) {
            this.mPaint.getShader().setLocalMatrix(this.kcQ);
            this.kcT = false;
        }
    }
}
