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
    private final Path bEU;
    private boolean ibU;
    private boolean ibV;
    private final float[] ibW;
    final float[] ibX;
    final RectF ibY;
    final RectF ibZ;
    @Nullable
    private p ibt;
    final RectF ica;
    final RectF icb;
    final Matrix icc;
    final Matrix icd;
    final Matrix ice;
    final Matrix icf;
    final Matrix icg;
    final Matrix ich;
    private float ici;
    private boolean icj;
    private boolean ick;
    private WeakReference<Bitmap> icl;
    private int mBorderColor;
    private final Paint mBorderPaint;
    private float mBorderWidth;
    private final Paint mPaint;
    private final Path mPath;

    public k(Resources resources, Bitmap bitmap, @Nullable Paint paint) {
        super(resources, bitmap);
        this.ibU = false;
        this.ibV = false;
        this.ibW = new float[8];
        this.ibX = new float[8];
        this.ibY = new RectF();
        this.ibZ = new RectF();
        this.ica = new RectF();
        this.icb = new RectF();
        this.icc = new Matrix();
        this.icd = new Matrix();
        this.ice = new Matrix();
        this.icf = new Matrix();
        this.icg = new Matrix();
        this.ich = new Matrix();
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.ici = 0.0f;
        this.mPath = new Path();
        this.bEU = new Path();
        this.icj = true;
        this.mPaint = new Paint();
        this.mBorderPaint = new Paint(1);
        this.ick = true;
        if (paint != null) {
            this.mPaint.set(paint);
        }
        this.mPaint.setFlags(1);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.facebook.drawee.drawable.j
    public void oS(boolean z) {
        this.ibU = z;
        this.icj = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.ibW, f);
        this.ibV = f != 0.0f;
        this.icj = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void e(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.ibW, 0.0f);
            this.ibV = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.ibW, 0, 8);
            this.ibV = false;
            for (int i = 0; i < 8; i++) {
                this.ibV = (fArr[i] > 0.0f) | this.ibV;
            }
        }
        this.icj = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.icj = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aI(float f) {
        if (this.ici != f) {
            this.ici = f;
            this.icj = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.o
    public void a(@Nullable p pVar) {
        this.ibt = pVar;
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
        if (!bSJ()) {
            super.draw(canvas);
            return;
        }
        bSK();
        bSL();
        mi();
        int save = canvas.save();
        canvas.concat(this.icg);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth > 0.0f) {
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setColor(e.cg(this.mBorderColor, this.mPaint.getAlpha()));
            canvas.drawPath(this.bEU, this.mBorderPaint);
        }
        canvas.restoreToCount(save);
    }

    boolean bSJ() {
        return this.ibU || this.ibV || this.mBorderWidth > 0.0f;
    }

    private void bSK() {
        if (this.ibt != null) {
            this.ibt.e(this.ice);
            this.ibt.b(this.ibY);
        } else {
            this.ice.reset();
            this.ibY.set(getBounds());
        }
        this.ica.set(0.0f, 0.0f, getBitmap().getWidth(), getBitmap().getHeight());
        this.icb.set(getBounds());
        this.icc.setRectToRect(this.ica, this.icb, Matrix.ScaleToFit.FILL);
        if (!this.ice.equals(this.icf) || !this.icc.equals(this.icd)) {
            this.ick = true;
            this.ice.invert(this.icg);
            this.ich.set(this.ice);
            this.ich.preConcat(this.icc);
            this.icf.set(this.ice);
            this.icd.set(this.icc);
        }
        if (!this.ibY.equals(this.ibZ)) {
            this.icj = true;
            this.ibZ.set(this.ibY);
        }
    }

    private void bSL() {
        if (this.icj) {
            this.bEU.reset();
            this.ibY.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.ibU) {
                this.bEU.addCircle(this.ibY.centerX(), this.ibY.centerY(), Math.min(this.ibY.width(), this.ibY.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.ibX.length; i++) {
                    this.ibX[i] = (this.ibW[i] + this.ici) - (this.mBorderWidth / 2.0f);
                }
                this.bEU.addRoundRect(this.ibY, this.ibX, Path.Direction.CW);
            }
            this.ibY.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            this.ibY.inset(this.ici, this.ici);
            if (this.ibU) {
                this.mPath.addCircle(this.ibY.centerX(), this.ibY.centerY(), Math.min(this.ibY.width(), this.ibY.height()) / 2.0f, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.ibY, this.ibW, Path.Direction.CW);
            }
            this.ibY.inset(-this.ici, -this.ici);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.icj = false;
        }
    }

    private void mi() {
        Bitmap bitmap = getBitmap();
        if (this.icl == null || this.icl.get() != bitmap) {
            this.icl = new WeakReference<>(bitmap);
            this.mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.ick = true;
        }
        if (this.ick) {
            this.mPaint.getShader().setLocalMatrix(this.ich);
            this.ick = false;
        }
    }
}
