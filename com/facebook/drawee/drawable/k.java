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
    private final Path ddj;
    @Nullable
    private p jUV;
    final RectF jVA;
    final RectF jVB;
    final RectF jVC;
    final Matrix jVD;
    final Matrix jVE;
    final Matrix jVF;
    final Matrix jVG;
    final Matrix jVH;
    final Matrix jVI;
    private float jVJ;
    private boolean jVK;
    private boolean jVL;
    private WeakReference<Bitmap> jVM;
    private boolean jVv;
    private boolean jVw;
    private final float[] jVx;
    final float[] jVy;
    final RectF jVz;
    private int mBorderColor;
    private final Paint mBorderPaint;
    private float mBorderWidth;
    private final Paint mPaint;
    private final Path mPath;

    public k(Resources resources, Bitmap bitmap, @Nullable Paint paint) {
        super(resources, bitmap);
        this.jVv = false;
        this.jVw = false;
        this.jVx = new float[8];
        this.jVy = new float[8];
        this.jVz = new RectF();
        this.jVA = new RectF();
        this.jVB = new RectF();
        this.jVC = new RectF();
        this.jVD = new Matrix();
        this.jVE = new Matrix();
        this.jVF = new Matrix();
        this.jVG = new Matrix();
        this.jVH = new Matrix();
        this.jVI = new Matrix();
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.jVJ = 0.0f;
        this.mPath = new Path();
        this.ddj = new Path();
        this.jVK = true;
        this.mPaint = new Paint();
        this.mBorderPaint = new Paint(1);
        this.jVL = true;
        if (paint != null) {
            this.mPaint.set(paint);
        }
        this.mPaint.setFlags(1);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.facebook.drawee.drawable.j
    public void sh(boolean z) {
        this.jVv = z;
        this.jVK = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.jVx, f);
        this.jVw = f != 0.0f;
        this.jVK = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void j(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.jVx, 0.0f);
            this.jVw = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.jVx, 0, 8);
            this.jVw = false;
            for (int i = 0; i < 8; i++) {
                this.jVw = (fArr[i] > 0.0f) | this.jVw;
            }
        }
        this.jVK = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void l(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.jVK = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aZ(float f) {
        if (this.jVJ != f) {
            this.jVJ = f;
            this.jVK = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.o
    public void a(@Nullable p pVar) {
        this.jUV = pVar;
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
        if (!cDo()) {
            super.draw(canvas);
            return;
        }
        cDp();
        cDq();
        lg();
        int save = canvas.save();
        canvas.concat(this.jVH);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth > 0.0f) {
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setColor(e.cH(this.mBorderColor, this.mPaint.getAlpha()));
            canvas.drawPath(this.ddj, this.mBorderPaint);
        }
        canvas.restoreToCount(save);
    }

    boolean cDo() {
        return this.jVv || this.jVw || this.mBorderWidth > 0.0f;
    }

    private void cDp() {
        if (this.jUV != null) {
            this.jUV.e(this.jVF);
            this.jUV.b(this.jVz);
        } else {
            this.jVF.reset();
            this.jVz.set(getBounds());
        }
        this.jVB.set(0.0f, 0.0f, getBitmap().getWidth(), getBitmap().getHeight());
        this.jVC.set(getBounds());
        this.jVD.setRectToRect(this.jVB, this.jVC, Matrix.ScaleToFit.FILL);
        if (!this.jVF.equals(this.jVG) || !this.jVD.equals(this.jVE)) {
            this.jVL = true;
            this.jVF.invert(this.jVH);
            this.jVI.set(this.jVF);
            this.jVI.preConcat(this.jVD);
            this.jVG.set(this.jVF);
            this.jVE.set(this.jVD);
        }
        if (!this.jVz.equals(this.jVA)) {
            this.jVK = true;
            this.jVA.set(this.jVz);
        }
    }

    private void cDq() {
        if (this.jVK) {
            this.ddj.reset();
            this.jVz.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.jVv) {
                this.ddj.addCircle(this.jVz.centerX(), this.jVz.centerY(), Math.min(this.jVz.width(), this.jVz.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.jVy.length; i++) {
                    this.jVy[i] = (this.jVx[i] + this.jVJ) - (this.mBorderWidth / 2.0f);
                }
                this.ddj.addRoundRect(this.jVz, this.jVy, Path.Direction.CW);
            }
            this.jVz.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            this.jVz.inset(this.jVJ, this.jVJ);
            if (this.jVv) {
                this.mPath.addCircle(this.jVz.centerX(), this.jVz.centerY(), Math.min(this.jVz.width(), this.jVz.height()) / 2.0f, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.jVz, this.jVx, Path.Direction.CW);
            }
            this.jVz.inset(-this.jVJ, -this.jVJ);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.jVK = false;
        }
    }

    private void lg() {
        Bitmap bitmap = getBitmap();
        if (this.jVM == null || this.jVM.get() != bitmap) {
            this.jVM = new WeakReference<>(bitmap);
            this.mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.jVL = true;
        }
        if (this.jVL) {
            this.mPaint.getShader().setLocalMatrix(this.jVI);
            this.jVL = false;
        }
    }
}
