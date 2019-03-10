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
    private final Path cUN;
    @Nullable
    private p jCT;
    final RectF jDA;
    final RectF jDB;
    final Matrix jDC;
    final Matrix jDD;
    final Matrix jDE;
    final Matrix jDF;
    final Matrix jDG;
    final Matrix jDH;
    private float jDI;
    private boolean jDJ;
    private boolean jDK;
    private WeakReference<Bitmap> jDL;
    private boolean jDu;
    private boolean jDv;
    private final float[] jDw;
    final float[] jDx;
    final RectF jDy;
    final RectF jDz;
    private int mBorderColor;
    private final Paint mBorderPaint;
    private float mBorderWidth;
    private final Paint mPaint;
    private final Path mPath;

    public k(Resources resources, Bitmap bitmap, @Nullable Paint paint) {
        super(resources, bitmap);
        this.jDu = false;
        this.jDv = false;
        this.jDw = new float[8];
        this.jDx = new float[8];
        this.jDy = new RectF();
        this.jDz = new RectF();
        this.jDA = new RectF();
        this.jDB = new RectF();
        this.jDC = new Matrix();
        this.jDD = new Matrix();
        this.jDE = new Matrix();
        this.jDF = new Matrix();
        this.jDG = new Matrix();
        this.jDH = new Matrix();
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.jDI = 0.0f;
        this.mPath = new Path();
        this.cUN = new Path();
        this.jDJ = true;
        this.mPaint = new Paint();
        this.mBorderPaint = new Paint(1);
        this.jDK = true;
        if (paint != null) {
            this.mPaint.set(paint);
        }
        this.mPaint.setFlags(1);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.facebook.drawee.drawable.j
    public void rs(boolean z) {
        this.jDu = z;
        this.jDJ = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.jDw, f);
        this.jDv = f != 0.0f;
        this.jDJ = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void f(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.jDw, 0.0f);
            this.jDv = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.jDw, 0, 8);
            this.jDv = false;
            for (int i = 0; i < 8; i++) {
                this.jDv = (fArr[i] > 0.0f) | this.jDv;
            }
        }
        this.jDJ = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.jDJ = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aV(float f) {
        if (this.jDI != f) {
            this.jDI = f;
            this.jDJ = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.o
    public void a(@Nullable p pVar) {
        this.jCT = pVar;
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
        if (!cvw()) {
            super.draw(canvas);
            return;
        }
        cvx();
        cvy();
        mm();
        int save = canvas.save();
        canvas.concat(this.jDG);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth > 0.0f) {
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setColor(e.cA(this.mBorderColor, this.mPaint.getAlpha()));
            canvas.drawPath(this.cUN, this.mBorderPaint);
        }
        canvas.restoreToCount(save);
    }

    boolean cvw() {
        return this.jDu || this.jDv || this.mBorderWidth > 0.0f;
    }

    private void cvx() {
        if (this.jCT != null) {
            this.jCT.e(this.jDE);
            this.jCT.b(this.jDy);
        } else {
            this.jDE.reset();
            this.jDy.set(getBounds());
        }
        this.jDA.set(0.0f, 0.0f, getBitmap().getWidth(), getBitmap().getHeight());
        this.jDB.set(getBounds());
        this.jDC.setRectToRect(this.jDA, this.jDB, Matrix.ScaleToFit.FILL);
        if (!this.jDE.equals(this.jDF) || !this.jDC.equals(this.jDD)) {
            this.jDK = true;
            this.jDE.invert(this.jDG);
            this.jDH.set(this.jDE);
            this.jDH.preConcat(this.jDC);
            this.jDF.set(this.jDE);
            this.jDD.set(this.jDC);
        }
        if (!this.jDy.equals(this.jDz)) {
            this.jDJ = true;
            this.jDz.set(this.jDy);
        }
    }

    private void cvy() {
        if (this.jDJ) {
            this.cUN.reset();
            this.jDy.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.jDu) {
                this.cUN.addCircle(this.jDy.centerX(), this.jDy.centerY(), Math.min(this.jDy.width(), this.jDy.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.jDx.length; i++) {
                    this.jDx[i] = (this.jDw[i] + this.jDI) - (this.mBorderWidth / 2.0f);
                }
                this.cUN.addRoundRect(this.jDy, this.jDx, Path.Direction.CW);
            }
            this.jDy.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            this.jDy.inset(this.jDI, this.jDI);
            if (this.jDu) {
                this.mPath.addCircle(this.jDy.centerX(), this.jDy.centerY(), Math.min(this.jDy.width(), this.jDy.height()) / 2.0f, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.jDy, this.jDw, Path.Direction.CW);
            }
            this.jDy.inset(-this.jDI, -this.jDI);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.jDJ = false;
        }
    }

    private void mm() {
        Bitmap bitmap = getBitmap();
        if (this.jDL == null || this.jDL.get() != bitmap) {
            this.jDL = new WeakReference<>(bitmap);
            this.mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.jDK = true;
        }
        if (this.jDK) {
            this.mPaint.getShader().setLocalMatrix(this.jDH);
            this.jDK = false;
        }
    }
}
