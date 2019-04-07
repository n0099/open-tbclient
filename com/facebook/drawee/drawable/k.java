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
    private final Path cUL;
    private boolean jCG;
    private boolean jCH;
    private final float[] jCI;
    final float[] jCJ;
    final RectF jCK;
    final RectF jCL;
    final RectF jCM;
    final RectF jCN;
    final Matrix jCO;
    final Matrix jCP;
    final Matrix jCQ;
    final Matrix jCR;
    final Matrix jCS;
    final Matrix jCT;
    private float jCU;
    private boolean jCV;
    private boolean jCW;
    private WeakReference<Bitmap> jCX;
    @Nullable
    private p jCf;
    private int mBorderColor;
    private final Paint mBorderPaint;
    private float mBorderWidth;
    private final Paint mPaint;
    private final Path mPath;

    public k(Resources resources, Bitmap bitmap, @Nullable Paint paint) {
        super(resources, bitmap);
        this.jCG = false;
        this.jCH = false;
        this.jCI = new float[8];
        this.jCJ = new float[8];
        this.jCK = new RectF();
        this.jCL = new RectF();
        this.jCM = new RectF();
        this.jCN = new RectF();
        this.jCO = new Matrix();
        this.jCP = new Matrix();
        this.jCQ = new Matrix();
        this.jCR = new Matrix();
        this.jCS = new Matrix();
        this.jCT = new Matrix();
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.jCU = 0.0f;
        this.mPath = new Path();
        this.cUL = new Path();
        this.jCV = true;
        this.mPaint = new Paint();
        this.mBorderPaint = new Paint(1);
        this.jCW = true;
        if (paint != null) {
            this.mPaint.set(paint);
        }
        this.mPaint.setFlags(1);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.facebook.drawee.drawable.j
    public void rs(boolean z) {
        this.jCG = z;
        this.jCV = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.jCI, f);
        this.jCH = f != 0.0f;
        this.jCV = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void f(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.jCI, 0.0f);
            this.jCH = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.jCI, 0, 8);
            this.jCH = false;
            for (int i = 0; i < 8; i++) {
                this.jCH = (fArr[i] > 0.0f) | this.jCH;
            }
        }
        this.jCV = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.jCV = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aV(float f) {
        if (this.jCU != f) {
            this.jCU = f;
            this.jCV = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.o
    public void a(@Nullable p pVar) {
        this.jCf = pVar;
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
        if (!cvs()) {
            super.draw(canvas);
            return;
        }
        cvt();
        cvu();
        mm();
        int save = canvas.save();
        canvas.concat(this.jCS);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth > 0.0f) {
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setColor(e.cA(this.mBorderColor, this.mPaint.getAlpha()));
            canvas.drawPath(this.cUL, this.mBorderPaint);
        }
        canvas.restoreToCount(save);
    }

    boolean cvs() {
        return this.jCG || this.jCH || this.mBorderWidth > 0.0f;
    }

    private void cvt() {
        if (this.jCf != null) {
            this.jCf.e(this.jCQ);
            this.jCf.b(this.jCK);
        } else {
            this.jCQ.reset();
            this.jCK.set(getBounds());
        }
        this.jCM.set(0.0f, 0.0f, getBitmap().getWidth(), getBitmap().getHeight());
        this.jCN.set(getBounds());
        this.jCO.setRectToRect(this.jCM, this.jCN, Matrix.ScaleToFit.FILL);
        if (!this.jCQ.equals(this.jCR) || !this.jCO.equals(this.jCP)) {
            this.jCW = true;
            this.jCQ.invert(this.jCS);
            this.jCT.set(this.jCQ);
            this.jCT.preConcat(this.jCO);
            this.jCR.set(this.jCQ);
            this.jCP.set(this.jCO);
        }
        if (!this.jCK.equals(this.jCL)) {
            this.jCV = true;
            this.jCL.set(this.jCK);
        }
    }

    private void cvu() {
        if (this.jCV) {
            this.cUL.reset();
            this.jCK.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.jCG) {
                this.cUL.addCircle(this.jCK.centerX(), this.jCK.centerY(), Math.min(this.jCK.width(), this.jCK.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.jCJ.length; i++) {
                    this.jCJ[i] = (this.jCI[i] + this.jCU) - (this.mBorderWidth / 2.0f);
                }
                this.cUL.addRoundRect(this.jCK, this.jCJ, Path.Direction.CW);
            }
            this.jCK.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            this.jCK.inset(this.jCU, this.jCU);
            if (this.jCG) {
                this.mPath.addCircle(this.jCK.centerX(), this.jCK.centerY(), Math.min(this.jCK.width(), this.jCK.height()) / 2.0f, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.jCK, this.jCI, Path.Direction.CW);
            }
            this.jCK.inset(-this.jCU, -this.jCU);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.jCV = false;
        }
    }

    private void mm() {
        Bitmap bitmap = getBitmap();
        if (this.jCX == null || this.jCX.get() != bitmap) {
            this.jCX = new WeakReference<>(bitmap);
            this.mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.jCW = true;
        }
        if (this.jCW) {
            this.mPaint.getShader().setLocalMatrix(this.jCT);
            this.jCW = false;
        }
    }
}
