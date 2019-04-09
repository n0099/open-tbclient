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
    private final Path cUM;
    private boolean jCH;
    private boolean jCI;
    private final float[] jCJ;
    final float[] jCK;
    final RectF jCL;
    final RectF jCM;
    final RectF jCN;
    final RectF jCO;
    final Matrix jCP;
    final Matrix jCQ;
    final Matrix jCR;
    final Matrix jCS;
    final Matrix jCT;
    final Matrix jCU;
    private float jCV;
    private boolean jCW;
    private boolean jCX;
    private WeakReference<Bitmap> jCY;
    @Nullable
    private p jCg;
    private int mBorderColor;
    private final Paint mBorderPaint;
    private float mBorderWidth;
    private final Paint mPaint;
    private final Path mPath;

    public k(Resources resources, Bitmap bitmap, @Nullable Paint paint) {
        super(resources, bitmap);
        this.jCH = false;
        this.jCI = false;
        this.jCJ = new float[8];
        this.jCK = new float[8];
        this.jCL = new RectF();
        this.jCM = new RectF();
        this.jCN = new RectF();
        this.jCO = new RectF();
        this.jCP = new Matrix();
        this.jCQ = new Matrix();
        this.jCR = new Matrix();
        this.jCS = new Matrix();
        this.jCT = new Matrix();
        this.jCU = new Matrix();
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.jCV = 0.0f;
        this.mPath = new Path();
        this.cUM = new Path();
        this.jCW = true;
        this.mPaint = new Paint();
        this.mBorderPaint = new Paint(1);
        this.jCX = true;
        if (paint != null) {
            this.mPaint.set(paint);
        }
        this.mPaint.setFlags(1);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.facebook.drawee.drawable.j
    public void rs(boolean z) {
        this.jCH = z;
        this.jCW = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.jCJ, f);
        this.jCI = f != 0.0f;
        this.jCW = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void f(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.jCJ, 0.0f);
            this.jCI = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.jCJ, 0, 8);
            this.jCI = false;
            for (int i = 0; i < 8; i++) {
                this.jCI = (fArr[i] > 0.0f) | this.jCI;
            }
        }
        this.jCW = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.jCW = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aV(float f) {
        if (this.jCV != f) {
            this.jCV = f;
            this.jCW = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.o
    public void a(@Nullable p pVar) {
        this.jCg = pVar;
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
        canvas.concat(this.jCT);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth > 0.0f) {
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setColor(e.cA(this.mBorderColor, this.mPaint.getAlpha()));
            canvas.drawPath(this.cUM, this.mBorderPaint);
        }
        canvas.restoreToCount(save);
    }

    boolean cvs() {
        return this.jCH || this.jCI || this.mBorderWidth > 0.0f;
    }

    private void cvt() {
        if (this.jCg != null) {
            this.jCg.e(this.jCR);
            this.jCg.b(this.jCL);
        } else {
            this.jCR.reset();
            this.jCL.set(getBounds());
        }
        this.jCN.set(0.0f, 0.0f, getBitmap().getWidth(), getBitmap().getHeight());
        this.jCO.set(getBounds());
        this.jCP.setRectToRect(this.jCN, this.jCO, Matrix.ScaleToFit.FILL);
        if (!this.jCR.equals(this.jCS) || !this.jCP.equals(this.jCQ)) {
            this.jCX = true;
            this.jCR.invert(this.jCT);
            this.jCU.set(this.jCR);
            this.jCU.preConcat(this.jCP);
            this.jCS.set(this.jCR);
            this.jCQ.set(this.jCP);
        }
        if (!this.jCL.equals(this.jCM)) {
            this.jCW = true;
            this.jCM.set(this.jCL);
        }
    }

    private void cvu() {
        if (this.jCW) {
            this.cUM.reset();
            this.jCL.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.jCH) {
                this.cUM.addCircle(this.jCL.centerX(), this.jCL.centerY(), Math.min(this.jCL.width(), this.jCL.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.jCK.length; i++) {
                    this.jCK[i] = (this.jCJ[i] + this.jCV) - (this.mBorderWidth / 2.0f);
                }
                this.cUM.addRoundRect(this.jCL, this.jCK, Path.Direction.CW);
            }
            this.jCL.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            this.jCL.inset(this.jCV, this.jCV);
            if (this.jCH) {
                this.mPath.addCircle(this.jCL.centerX(), this.jCL.centerY(), Math.min(this.jCL.width(), this.jCL.height()) / 2.0f, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.jCL, this.jCJ, Path.Direction.CW);
            }
            this.jCL.inset(-this.jCV, -this.jCV);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.jCW = false;
        }
    }

    private void mm() {
        Bitmap bitmap = getBitmap();
        if (this.jCY == null || this.jCY.get() != bitmap) {
            this.jCY = new WeakReference<>(bitmap);
            this.mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.jCX = true;
        }
        if (this.jCX) {
            this.mPaint.getShader().setLocalMatrix(this.jCU);
            this.jCX = false;
        }
    }
}
