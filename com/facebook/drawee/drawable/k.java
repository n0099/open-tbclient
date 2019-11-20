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
    private final Path dpj;
    @Nullable
    private p kcY;
    private final float[] kdA;
    final float[] kdB;
    final RectF kdC;
    final RectF kdD;
    final RectF kdE;
    final RectF kdF;
    final Matrix kdG;
    final Matrix kdH;
    final Matrix kdI;
    final Matrix kdJ;
    final Matrix kdK;
    final Matrix kdL;
    private float kdM;
    private boolean kdN;
    private boolean kdO;
    private WeakReference<Bitmap> kdP;
    private boolean kdy;
    private boolean kdz;
    private int mBorderColor;
    private final Paint mBorderPaint;
    private float mBorderWidth;
    private final Paint mPaint;
    private final Path mPath;

    public k(Resources resources, Bitmap bitmap, @Nullable Paint paint) {
        super(resources, bitmap);
        this.kdy = false;
        this.kdz = false;
        this.kdA = new float[8];
        this.kdB = new float[8];
        this.kdC = new RectF();
        this.kdD = new RectF();
        this.kdE = new RectF();
        this.kdF = new RectF();
        this.kdG = new Matrix();
        this.kdH = new Matrix();
        this.kdI = new Matrix();
        this.kdJ = new Matrix();
        this.kdK = new Matrix();
        this.kdL = new Matrix();
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.kdM = 0.0f;
        this.mPath = new Path();
        this.dpj = new Path();
        this.kdN = true;
        this.mPaint = new Paint();
        this.mBorderPaint = new Paint(1);
        this.kdO = true;
        if (paint != null) {
            this.mPaint.set(paint);
        }
        this.mPaint.setFlags(1);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.facebook.drawee.drawable.j
    public void sg(boolean z) {
        this.kdy = z;
        this.kdN = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.kdA, f);
        this.kdz = f != 0.0f;
        this.kdN = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void j(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.kdA, 0.0f);
            this.kdz = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.kdA, 0, 8);
            this.kdz = false;
            for (int i = 0; i < 8; i++) {
                this.kdz = (fArr[i] > 0.0f) | this.kdz;
            }
        }
        this.kdN = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void m(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.kdN = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aE(float f) {
        if (this.kdM != f) {
            this.kdM = f;
            this.kdN = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.o
    public void a(@Nullable p pVar) {
        this.kcY = pVar;
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
        if (!cEw()) {
            super.draw(canvas);
            return;
        }
        cEx();
        cEy();
        updatePaint();
        int save = canvas.save();
        canvas.concat(this.kdK);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth > 0.0f) {
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setColor(e.cC(this.mBorderColor, this.mPaint.getAlpha()));
            canvas.drawPath(this.dpj, this.mBorderPaint);
        }
        canvas.restoreToCount(save);
    }

    boolean cEw() {
        return this.kdy || this.kdz || this.mBorderWidth > 0.0f;
    }

    private void cEx() {
        if (this.kcY != null) {
            this.kcY.d(this.kdI);
            this.kcY.a(this.kdC);
        } else {
            this.kdI.reset();
            this.kdC.set(getBounds());
        }
        this.kdE.set(0.0f, 0.0f, getBitmap().getWidth(), getBitmap().getHeight());
        this.kdF.set(getBounds());
        this.kdG.setRectToRect(this.kdE, this.kdF, Matrix.ScaleToFit.FILL);
        if (!this.kdI.equals(this.kdJ) || !this.kdG.equals(this.kdH)) {
            this.kdO = true;
            this.kdI.invert(this.kdK);
            this.kdL.set(this.kdI);
            this.kdL.preConcat(this.kdG);
            this.kdJ.set(this.kdI);
            this.kdH.set(this.kdG);
        }
        if (!this.kdC.equals(this.kdD)) {
            this.kdN = true;
            this.kdD.set(this.kdC);
        }
    }

    private void cEy() {
        if (this.kdN) {
            this.dpj.reset();
            this.kdC.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.kdy) {
                this.dpj.addCircle(this.kdC.centerX(), this.kdC.centerY(), Math.min(this.kdC.width(), this.kdC.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.kdB.length; i++) {
                    this.kdB[i] = (this.kdA[i] + this.kdM) - (this.mBorderWidth / 2.0f);
                }
                this.dpj.addRoundRect(this.kdC, this.kdB, Path.Direction.CW);
            }
            this.kdC.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            this.kdC.inset(this.kdM, this.kdM);
            if (this.kdy) {
                this.mPath.addCircle(this.kdC.centerX(), this.kdC.centerY(), Math.min(this.kdC.width(), this.kdC.height()) / 2.0f, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.kdC, this.kdA, Path.Direction.CW);
            }
            this.kdC.inset(-this.kdM, -this.kdM);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.kdN = false;
        }
    }

    private void updatePaint() {
        Bitmap bitmap = getBitmap();
        if (this.kdP == null || this.kdP.get() != bitmap) {
            this.kdP = new WeakReference<>(bitmap);
            this.mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.kdO = true;
        }
        if (this.kdO) {
            this.mPaint.getShader().setLocalMatrix(this.kdL);
            this.kdO = false;
        }
    }
}
