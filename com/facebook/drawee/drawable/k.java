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
    private final Path deT;
    private boolean kdJ;
    private boolean kdK;
    private final float[] kdL;
    final float[] kdM;
    final RectF kdN;
    final RectF kdO;
    final RectF kdP;
    final RectF kdQ;
    final Matrix kdR;
    final Matrix kdS;
    final Matrix kdT;
    final Matrix kdU;
    final Matrix kdV;
    final Matrix kdW;
    private float kdX;
    private boolean kdY;
    private boolean kdZ;
    @Nullable
    private p kdj;
    private WeakReference<Bitmap> kea;
    private float mBorderWidth;
    private final Paint mPaint;
    private final Path mPath;

    public k(Resources resources, Bitmap bitmap, @Nullable Paint paint) {
        super(resources, bitmap);
        this.kdJ = false;
        this.kdK = false;
        this.kdL = new float[8];
        this.kdM = new float[8];
        this.kdN = new RectF();
        this.kdO = new RectF();
        this.kdP = new RectF();
        this.kdQ = new RectF();
        this.kdR = new Matrix();
        this.kdS = new Matrix();
        this.kdT = new Matrix();
        this.kdU = new Matrix();
        this.kdV = new Matrix();
        this.kdW = new Matrix();
        this.mBorderWidth = 0.0f;
        this.GW = 0;
        this.kdX = 0.0f;
        this.mPath = new Path();
        this.deT = new Path();
        this.kdY = true;
        this.mPaint = new Paint();
        this.GF = new Paint(1);
        this.kdZ = true;
        if (paint != null) {
            this.mPaint.set(paint);
        }
        this.mPaint.setFlags(1);
        this.GF.setStyle(Paint.Style.STROKE);
    }

    @Override // com.facebook.drawee.drawable.j
    public void sy(boolean z) {
        this.kdJ = z;
        this.kdY = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.kdL, f);
        this.kdK = f != 0.0f;
        this.kdY = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void j(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.kdL, 0.0f);
            this.kdK = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.kdL, 0, 8);
            this.kdK = false;
            for (int i = 0; i < 8; i++) {
                this.kdK = (fArr[i] > 0.0f) | this.kdK;
            }
        }
        this.kdY = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void l(int i, float f) {
        if (this.GW != i || this.mBorderWidth != f) {
            this.GW = i;
            this.mBorderWidth = f;
            this.kdY = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void ba(float f) {
        if (this.kdX != f) {
            this.kdX = f;
            this.kdY = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.o
    public void a(@Nullable p pVar) {
        this.kdj = pVar;
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
        if (!cGM()) {
            super.draw(canvas);
            return;
        }
        cGN();
        cGO();
        lw();
        int save = canvas.save();
        canvas.concat(this.kdV);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth > 0.0f) {
            this.GF.setStrokeWidth(this.mBorderWidth);
            this.GF.setColor(e.cM(this.GW, this.mPaint.getAlpha()));
            canvas.drawPath(this.deT, this.GF);
        }
        canvas.restoreToCount(save);
    }

    boolean cGM() {
        return this.kdJ || this.kdK || this.mBorderWidth > 0.0f;
    }

    private void cGN() {
        if (this.kdj != null) {
            this.kdj.e(this.kdT);
            this.kdj.b(this.kdN);
        } else {
            this.kdT.reset();
            this.kdN.set(getBounds());
        }
        this.kdP.set(0.0f, 0.0f, getBitmap().getWidth(), getBitmap().getHeight());
        this.kdQ.set(getBounds());
        this.kdR.setRectToRect(this.kdP, this.kdQ, Matrix.ScaleToFit.FILL);
        if (!this.kdT.equals(this.kdU) || !this.kdR.equals(this.kdS)) {
            this.kdZ = true;
            this.kdT.invert(this.kdV);
            this.kdW.set(this.kdT);
            this.kdW.preConcat(this.kdR);
            this.kdU.set(this.kdT);
            this.kdS.set(this.kdR);
        }
        if (!this.kdN.equals(this.kdO)) {
            this.kdY = true;
            this.kdO.set(this.kdN);
        }
    }

    private void cGO() {
        if (this.kdY) {
            this.deT.reset();
            this.kdN.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.kdJ) {
                this.deT.addCircle(this.kdN.centerX(), this.kdN.centerY(), Math.min(this.kdN.width(), this.kdN.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.kdM.length; i++) {
                    this.kdM[i] = (this.kdL[i] + this.kdX) - (this.mBorderWidth / 2.0f);
                }
                this.deT.addRoundRect(this.kdN, this.kdM, Path.Direction.CW);
            }
            this.kdN.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            this.kdN.inset(this.kdX, this.kdX);
            if (this.kdJ) {
                this.mPath.addCircle(this.kdN.centerX(), this.kdN.centerY(), Math.min(this.kdN.width(), this.kdN.height()) / 2.0f, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.kdN, this.kdL, Path.Direction.CW);
            }
            this.kdN.inset(-this.kdX, -this.kdX);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.kdY = false;
        }
    }

    private void lw() {
        Bitmap bitmap = getBitmap();
        if (this.kea == null || this.kea.get() != bitmap) {
            this.kea = new WeakReference<>(bitmap);
            this.mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.kdZ = true;
        }
        if (this.kdZ) {
            this.mPaint.getShader().setLocalMatrix(this.kdW);
            this.kdZ = false;
        }
    }
}
