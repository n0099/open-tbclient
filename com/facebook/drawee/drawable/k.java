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
    private final Path dqa;
    @Nullable
    private p kdP;
    final Matrix keA;
    final Matrix keB;
    final Matrix keC;
    final Matrix keD;
    private float keE;
    private boolean keF;
    private boolean keG;
    private WeakReference<Bitmap> keH;
    private boolean kep;
    private boolean keq;
    private final float[] ker;
    final float[] kes;
    final RectF ket;
    final RectF keu;
    final RectF kev;
    final RectF kew;
    final Matrix kex;
    final Matrix kez;
    private int mBorderColor;
    private final Paint mBorderPaint;
    private float mBorderWidth;
    private final Paint mPaint;
    private final Path mPath;

    public k(Resources resources, Bitmap bitmap, @Nullable Paint paint) {
        super(resources, bitmap);
        this.kep = false;
        this.keq = false;
        this.ker = new float[8];
        this.kes = new float[8];
        this.ket = new RectF();
        this.keu = new RectF();
        this.kev = new RectF();
        this.kew = new RectF();
        this.kex = new Matrix();
        this.kez = new Matrix();
        this.keA = new Matrix();
        this.keB = new Matrix();
        this.keC = new Matrix();
        this.keD = new Matrix();
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.keE = 0.0f;
        this.mPath = new Path();
        this.dqa = new Path();
        this.keF = true;
        this.mPaint = new Paint();
        this.mBorderPaint = new Paint(1);
        this.keG = true;
        if (paint != null) {
            this.mPaint.set(paint);
        }
        this.mPaint.setFlags(1);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.facebook.drawee.drawable.j
    public void sg(boolean z) {
        this.kep = z;
        this.keF = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.ker, f);
        this.keq = f != 0.0f;
        this.keF = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void j(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.ker, 0.0f);
            this.keq = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.ker, 0, 8);
            this.keq = false;
            for (int i = 0; i < 8; i++) {
                this.keq = (fArr[i] > 0.0f) | this.keq;
            }
        }
        this.keF = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void m(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.keF = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aE(float f) {
        if (this.keE != f) {
            this.keE = f;
            this.keF = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.o
    public void a(@Nullable p pVar) {
        this.kdP = pVar;
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
        if (!cEy()) {
            super.draw(canvas);
            return;
        }
        cEz();
        cEA();
        updatePaint();
        int save = canvas.save();
        canvas.concat(this.keC);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth > 0.0f) {
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setColor(e.cE(this.mBorderColor, this.mPaint.getAlpha()));
            canvas.drawPath(this.dqa, this.mBorderPaint);
        }
        canvas.restoreToCount(save);
    }

    boolean cEy() {
        return this.kep || this.keq || this.mBorderWidth > 0.0f;
    }

    private void cEz() {
        if (this.kdP != null) {
            this.kdP.d(this.keA);
            this.kdP.a(this.ket);
        } else {
            this.keA.reset();
            this.ket.set(getBounds());
        }
        this.kev.set(0.0f, 0.0f, getBitmap().getWidth(), getBitmap().getHeight());
        this.kew.set(getBounds());
        this.kex.setRectToRect(this.kev, this.kew, Matrix.ScaleToFit.FILL);
        if (!this.keA.equals(this.keB) || !this.kex.equals(this.kez)) {
            this.keG = true;
            this.keA.invert(this.keC);
            this.keD.set(this.keA);
            this.keD.preConcat(this.kex);
            this.keB.set(this.keA);
            this.kez.set(this.kex);
        }
        if (!this.ket.equals(this.keu)) {
            this.keF = true;
            this.keu.set(this.ket);
        }
    }

    private void cEA() {
        if (this.keF) {
            this.dqa.reset();
            this.ket.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.kep) {
                this.dqa.addCircle(this.ket.centerX(), this.ket.centerY(), Math.min(this.ket.width(), this.ket.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.kes.length; i++) {
                    this.kes[i] = (this.ker[i] + this.keE) - (this.mBorderWidth / 2.0f);
                }
                this.dqa.addRoundRect(this.ket, this.kes, Path.Direction.CW);
            }
            this.ket.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            this.ket.inset(this.keE, this.keE);
            if (this.kep) {
                this.mPath.addCircle(this.ket.centerX(), this.ket.centerY(), Math.min(this.ket.width(), this.ket.height()) / 2.0f, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.ket, this.ker, Path.Direction.CW);
            }
            this.ket.inset(-this.keE, -this.keE);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.keF = false;
        }
    }

    private void updatePaint() {
        Bitmap bitmap = getBitmap();
        if (this.keH == null || this.keH.get() != bitmap) {
            this.keH = new WeakReference<>(bitmap);
            this.mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.keG = true;
        }
        if (this.keG) {
            this.mPaint.getShader().setLocalMatrix(this.keD);
            this.keG = false;
        }
    }
}
