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
    private final Path cUJ;
    @Nullable
    private p jCL;
    private float jDA;
    private boolean jDB;
    private boolean jDC;
    private WeakReference<Bitmap> jDD;
    private boolean jDm;
    private boolean jDn;
    private final float[] jDo;
    final float[] jDp;
    final RectF jDq;
    final RectF jDr;
    final RectF jDs;
    final RectF jDt;
    final Matrix jDu;
    final Matrix jDv;
    final Matrix jDw;
    final Matrix jDx;
    final Matrix jDy;
    final Matrix jDz;
    private int mBorderColor;
    private final Paint mBorderPaint;
    private float mBorderWidth;
    private final Paint mPaint;
    private final Path mPath;

    public k(Resources resources, Bitmap bitmap, @Nullable Paint paint) {
        super(resources, bitmap);
        this.jDm = false;
        this.jDn = false;
        this.jDo = new float[8];
        this.jDp = new float[8];
        this.jDq = new RectF();
        this.jDr = new RectF();
        this.jDs = new RectF();
        this.jDt = new RectF();
        this.jDu = new Matrix();
        this.jDv = new Matrix();
        this.jDw = new Matrix();
        this.jDx = new Matrix();
        this.jDy = new Matrix();
        this.jDz = new Matrix();
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.jDA = 0.0f;
        this.mPath = new Path();
        this.cUJ = new Path();
        this.jDB = true;
        this.mPaint = new Paint();
        this.mBorderPaint = new Paint(1);
        this.jDC = true;
        if (paint != null) {
            this.mPaint.set(paint);
        }
        this.mPaint.setFlags(1);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.facebook.drawee.drawable.j
    public void rs(boolean z) {
        this.jDm = z;
        this.jDB = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.jDo, f);
        this.jDn = f != 0.0f;
        this.jDB = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void f(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.jDo, 0.0f);
            this.jDn = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.jDo, 0, 8);
            this.jDn = false;
            for (int i = 0; i < 8; i++) {
                this.jDn = (fArr[i] > 0.0f) | this.jDn;
            }
        }
        this.jDB = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.jDB = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aV(float f) {
        if (this.jDA != f) {
            this.jDA = f;
            this.jDB = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.o
    public void a(@Nullable p pVar) {
        this.jCL = pVar;
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
        if (!cvz()) {
            super.draw(canvas);
            return;
        }
        cvA();
        cvB();
        mm();
        int save = canvas.save();
        canvas.concat(this.jDy);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth > 0.0f) {
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setColor(e.cA(this.mBorderColor, this.mPaint.getAlpha()));
            canvas.drawPath(this.cUJ, this.mBorderPaint);
        }
        canvas.restoreToCount(save);
    }

    boolean cvz() {
        return this.jDm || this.jDn || this.mBorderWidth > 0.0f;
    }

    private void cvA() {
        if (this.jCL != null) {
            this.jCL.e(this.jDw);
            this.jCL.b(this.jDq);
        } else {
            this.jDw.reset();
            this.jDq.set(getBounds());
        }
        this.jDs.set(0.0f, 0.0f, getBitmap().getWidth(), getBitmap().getHeight());
        this.jDt.set(getBounds());
        this.jDu.setRectToRect(this.jDs, this.jDt, Matrix.ScaleToFit.FILL);
        if (!this.jDw.equals(this.jDx) || !this.jDu.equals(this.jDv)) {
            this.jDC = true;
            this.jDw.invert(this.jDy);
            this.jDz.set(this.jDw);
            this.jDz.preConcat(this.jDu);
            this.jDx.set(this.jDw);
            this.jDv.set(this.jDu);
        }
        if (!this.jDq.equals(this.jDr)) {
            this.jDB = true;
            this.jDr.set(this.jDq);
        }
    }

    private void cvB() {
        if (this.jDB) {
            this.cUJ.reset();
            this.jDq.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.jDm) {
                this.cUJ.addCircle(this.jDq.centerX(), this.jDq.centerY(), Math.min(this.jDq.width(), this.jDq.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.jDp.length; i++) {
                    this.jDp[i] = (this.jDo[i] + this.jDA) - (this.mBorderWidth / 2.0f);
                }
                this.cUJ.addRoundRect(this.jDq, this.jDp, Path.Direction.CW);
            }
            this.jDq.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            this.jDq.inset(this.jDA, this.jDA);
            if (this.jDm) {
                this.mPath.addCircle(this.jDq.centerX(), this.jDq.centerY(), Math.min(this.jDq.width(), this.jDq.height()) / 2.0f, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.jDq, this.jDo, Path.Direction.CW);
            }
            this.jDq.inset(-this.jDA, -this.jDA);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.jDB = false;
        }
    }

    private void mm() {
        Bitmap bitmap = getBitmap();
        if (this.jDD == null || this.jDD.get() != bitmap) {
            this.jDD = new WeakReference<>(bitmap);
            this.mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.jDC = true;
        }
        if (this.jDC) {
            this.mPaint.getShader().setLocalMatrix(this.jDz);
            this.jDC = false;
        }
    }
}
