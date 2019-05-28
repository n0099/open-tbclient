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
    private final Path ddk;
    @Nullable
    private p jUW;
    final RectF jVA;
    final RectF jVB;
    final RectF jVC;
    final RectF jVD;
    final Matrix jVE;
    final Matrix jVF;
    final Matrix jVG;
    final Matrix jVH;
    final Matrix jVI;
    final Matrix jVJ;
    private float jVK;
    private boolean jVL;
    private boolean jVM;
    private WeakReference<Bitmap> jVN;
    private boolean jVw;
    private boolean jVx;
    private final float[] jVy;
    final float[] jVz;
    private int mBorderColor;
    private final Paint mBorderPaint;
    private float mBorderWidth;
    private final Paint mPaint;
    private final Path mPath;

    public k(Resources resources, Bitmap bitmap, @Nullable Paint paint) {
        super(resources, bitmap);
        this.jVw = false;
        this.jVx = false;
        this.jVy = new float[8];
        this.jVz = new float[8];
        this.jVA = new RectF();
        this.jVB = new RectF();
        this.jVC = new RectF();
        this.jVD = new RectF();
        this.jVE = new Matrix();
        this.jVF = new Matrix();
        this.jVG = new Matrix();
        this.jVH = new Matrix();
        this.jVI = new Matrix();
        this.jVJ = new Matrix();
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.jVK = 0.0f;
        this.mPath = new Path();
        this.ddk = new Path();
        this.jVL = true;
        this.mPaint = new Paint();
        this.mBorderPaint = new Paint(1);
        this.jVM = true;
        if (paint != null) {
            this.mPaint.set(paint);
        }
        this.mPaint.setFlags(1);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.facebook.drawee.drawable.j
    public void sh(boolean z) {
        this.jVw = z;
        this.jVL = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.jVy, f);
        this.jVx = f != 0.0f;
        this.jVL = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void j(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.jVy, 0.0f);
            this.jVx = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.jVy, 0, 8);
            this.jVx = false;
            for (int i = 0; i < 8; i++) {
                this.jVx = (fArr[i] > 0.0f) | this.jVx;
            }
        }
        this.jVL = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void l(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.jVL = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aZ(float f) {
        if (this.jVK != f) {
            this.jVK = f;
            this.jVL = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.o
    public void a(@Nullable p pVar) {
        this.jUW = pVar;
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
        if (!cDq()) {
            super.draw(canvas);
            return;
        }
        cDr();
        cDs();
        lg();
        int save = canvas.save();
        canvas.concat(this.jVI);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth > 0.0f) {
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setColor(e.cH(this.mBorderColor, this.mPaint.getAlpha()));
            canvas.drawPath(this.ddk, this.mBorderPaint);
        }
        canvas.restoreToCount(save);
    }

    boolean cDq() {
        return this.jVw || this.jVx || this.mBorderWidth > 0.0f;
    }

    private void cDr() {
        if (this.jUW != null) {
            this.jUW.e(this.jVG);
            this.jUW.b(this.jVA);
        } else {
            this.jVG.reset();
            this.jVA.set(getBounds());
        }
        this.jVC.set(0.0f, 0.0f, getBitmap().getWidth(), getBitmap().getHeight());
        this.jVD.set(getBounds());
        this.jVE.setRectToRect(this.jVC, this.jVD, Matrix.ScaleToFit.FILL);
        if (!this.jVG.equals(this.jVH) || !this.jVE.equals(this.jVF)) {
            this.jVM = true;
            this.jVG.invert(this.jVI);
            this.jVJ.set(this.jVG);
            this.jVJ.preConcat(this.jVE);
            this.jVH.set(this.jVG);
            this.jVF.set(this.jVE);
        }
        if (!this.jVA.equals(this.jVB)) {
            this.jVL = true;
            this.jVB.set(this.jVA);
        }
    }

    private void cDs() {
        if (this.jVL) {
            this.ddk.reset();
            this.jVA.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.jVw) {
                this.ddk.addCircle(this.jVA.centerX(), this.jVA.centerY(), Math.min(this.jVA.width(), this.jVA.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.jVz.length; i++) {
                    this.jVz[i] = (this.jVy[i] + this.jVK) - (this.mBorderWidth / 2.0f);
                }
                this.ddk.addRoundRect(this.jVA, this.jVz, Path.Direction.CW);
            }
            this.jVA.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            this.jVA.inset(this.jVK, this.jVK);
            if (this.jVw) {
                this.mPath.addCircle(this.jVA.centerX(), this.jVA.centerY(), Math.min(this.jVA.width(), this.jVA.height()) / 2.0f, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.jVA, this.jVy, Path.Direction.CW);
            }
            this.jVA.inset(-this.jVK, -this.jVK);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.jVL = false;
        }
    }

    private void lg() {
        Bitmap bitmap = getBitmap();
        if (this.jVN == null || this.jVN.get() != bitmap) {
            this.jVN = new WeakReference<>(bitmap);
            this.mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.jVM = true;
        }
        if (this.jVM) {
            this.mPaint.getShader().setLocalMatrix(this.jVJ);
            this.jVM = false;
        }
    }
}
