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
    private final Path bIA;
    @Nullable
    private p ilQ;
    final Matrix imA;
    final Matrix imB;
    final Matrix imC;
    final Matrix imD;
    final Matrix imE;
    final Matrix imF;
    private float imG;
    private boolean imH;
    private boolean imI;
    private WeakReference<Bitmap> imJ;
    private boolean ims;
    private boolean imt;
    private final float[] imu;
    final float[] imv;
    final RectF imw;
    final RectF imx;
    final RectF imy;
    final RectF imz;
    private int mBorderColor;
    private final Paint mBorderPaint;
    private float mBorderWidth;
    private final Paint mPaint;
    private final Path mPath;

    public k(Resources resources, Bitmap bitmap, @Nullable Paint paint) {
        super(resources, bitmap);
        this.ims = false;
        this.imt = false;
        this.imu = new float[8];
        this.imv = new float[8];
        this.imw = new RectF();
        this.imx = new RectF();
        this.imy = new RectF();
        this.imz = new RectF();
        this.imA = new Matrix();
        this.imB = new Matrix();
        this.imC = new Matrix();
        this.imD = new Matrix();
        this.imE = new Matrix();
        this.imF = new Matrix();
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.imG = 0.0f;
        this.mPath = new Path();
        this.bIA = new Path();
        this.imH = true;
        this.mPaint = new Paint();
        this.mBorderPaint = new Paint(1);
        this.imI = true;
        if (paint != null) {
            this.mPaint.set(paint);
        }
        this.mPaint.setFlags(1);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.facebook.drawee.drawable.j
    public void oX(boolean z) {
        this.ims = z;
        this.imH = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.imu, f);
        this.imt = f != 0.0f;
        this.imH = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void e(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.imu, 0.0f);
            this.imt = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.imu, 0, 8);
            this.imt = false;
            for (int i = 0; i < 8; i++) {
                this.imt = (fArr[i] > 0.0f) | this.imt;
            }
        }
        this.imH = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.imH = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aI(float f) {
        if (this.imG != f) {
            this.imG = f;
            this.imH = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.o
    public void a(@Nullable p pVar) {
        this.ilQ = pVar;
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
        if (!bVF()) {
            super.draw(canvas);
            return;
        }
        bVG();
        bVH();
        mh();
        int save = canvas.save();
        canvas.concat(this.imE);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth > 0.0f) {
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setColor(e.cf(this.mBorderColor, this.mPaint.getAlpha()));
            canvas.drawPath(this.bIA, this.mBorderPaint);
        }
        canvas.restoreToCount(save);
    }

    boolean bVF() {
        return this.ims || this.imt || this.mBorderWidth > 0.0f;
    }

    private void bVG() {
        if (this.ilQ != null) {
            this.ilQ.e(this.imC);
            this.ilQ.b(this.imw);
        } else {
            this.imC.reset();
            this.imw.set(getBounds());
        }
        this.imy.set(0.0f, 0.0f, getBitmap().getWidth(), getBitmap().getHeight());
        this.imz.set(getBounds());
        this.imA.setRectToRect(this.imy, this.imz, Matrix.ScaleToFit.FILL);
        if (!this.imC.equals(this.imD) || !this.imA.equals(this.imB)) {
            this.imI = true;
            this.imC.invert(this.imE);
            this.imF.set(this.imC);
            this.imF.preConcat(this.imA);
            this.imD.set(this.imC);
            this.imB.set(this.imA);
        }
        if (!this.imw.equals(this.imx)) {
            this.imH = true;
            this.imx.set(this.imw);
        }
    }

    private void bVH() {
        if (this.imH) {
            this.bIA.reset();
            this.imw.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.ims) {
                this.bIA.addCircle(this.imw.centerX(), this.imw.centerY(), Math.min(this.imw.width(), this.imw.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.imv.length; i++) {
                    this.imv[i] = (this.imu[i] + this.imG) - (this.mBorderWidth / 2.0f);
                }
                this.bIA.addRoundRect(this.imw, this.imv, Path.Direction.CW);
            }
            this.imw.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            this.imw.inset(this.imG, this.imG);
            if (this.ims) {
                this.mPath.addCircle(this.imw.centerX(), this.imw.centerY(), Math.min(this.imw.width(), this.imw.height()) / 2.0f, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.imw, this.imu, Path.Direction.CW);
            }
            this.imw.inset(-this.imG, -this.imG);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.imH = false;
        }
    }

    private void mh() {
        Bitmap bitmap = getBitmap();
        if (this.imJ == null || this.imJ.get() != bitmap) {
            this.imJ = new WeakReference<>(bitmap);
            this.mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.imI = true;
        }
        if (this.imI) {
            this.mPaint.getShader().setLocalMatrix(this.imF);
            this.imI = false;
        }
    }
}
