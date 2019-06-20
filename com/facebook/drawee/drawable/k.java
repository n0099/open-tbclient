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
    private final Path ddl;
    @Nullable
    private p jUZ;
    private boolean jVA;
    private final float[] jVB;
    final float[] jVC;
    final RectF jVD;
    final RectF jVE;
    final RectF jVF;
    final RectF jVG;
    final Matrix jVH;
    final Matrix jVI;
    final Matrix jVJ;
    final Matrix jVK;
    final Matrix jVL;
    final Matrix jVM;
    private float jVN;
    private boolean jVO;
    private boolean jVP;
    private WeakReference<Bitmap> jVQ;
    private boolean jVz;
    private int mBorderColor;
    private final Paint mBorderPaint;
    private float mBorderWidth;
    private final Paint mPaint;
    private final Path mPath;

    public k(Resources resources, Bitmap bitmap, @Nullable Paint paint) {
        super(resources, bitmap);
        this.jVz = false;
        this.jVA = false;
        this.jVB = new float[8];
        this.jVC = new float[8];
        this.jVD = new RectF();
        this.jVE = new RectF();
        this.jVF = new RectF();
        this.jVG = new RectF();
        this.jVH = new Matrix();
        this.jVI = new Matrix();
        this.jVJ = new Matrix();
        this.jVK = new Matrix();
        this.jVL = new Matrix();
        this.jVM = new Matrix();
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.jVN = 0.0f;
        this.mPath = new Path();
        this.ddl = new Path();
        this.jVO = true;
        this.mPaint = new Paint();
        this.mBorderPaint = new Paint(1);
        this.jVP = true;
        if (paint != null) {
            this.mPaint.set(paint);
        }
        this.mPaint.setFlags(1);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.facebook.drawee.drawable.j
    public void si(boolean z) {
        this.jVz = z;
        this.jVO = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.jVB, f);
        this.jVA = f != 0.0f;
        this.jVO = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void j(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.jVB, 0.0f);
            this.jVA = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.jVB, 0, 8);
            this.jVA = false;
            for (int i = 0; i < 8; i++) {
                this.jVA = (fArr[i] > 0.0f) | this.jVA;
            }
        }
        this.jVO = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void l(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.jVO = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aZ(float f) {
        if (this.jVN != f) {
            this.jVN = f;
            this.jVO = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.o
    public void a(@Nullable p pVar) {
        this.jUZ = pVar;
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
        if (!cDp()) {
            super.draw(canvas);
            return;
        }
        cDq();
        cDr();
        lg();
        int save = canvas.save();
        canvas.concat(this.jVL);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth > 0.0f) {
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setColor(e.cH(this.mBorderColor, this.mPaint.getAlpha()));
            canvas.drawPath(this.ddl, this.mBorderPaint);
        }
        canvas.restoreToCount(save);
    }

    boolean cDp() {
        return this.jVz || this.jVA || this.mBorderWidth > 0.0f;
    }

    private void cDq() {
        if (this.jUZ != null) {
            this.jUZ.e(this.jVJ);
            this.jUZ.b(this.jVD);
        } else {
            this.jVJ.reset();
            this.jVD.set(getBounds());
        }
        this.jVF.set(0.0f, 0.0f, getBitmap().getWidth(), getBitmap().getHeight());
        this.jVG.set(getBounds());
        this.jVH.setRectToRect(this.jVF, this.jVG, Matrix.ScaleToFit.FILL);
        if (!this.jVJ.equals(this.jVK) || !this.jVH.equals(this.jVI)) {
            this.jVP = true;
            this.jVJ.invert(this.jVL);
            this.jVM.set(this.jVJ);
            this.jVM.preConcat(this.jVH);
            this.jVK.set(this.jVJ);
            this.jVI.set(this.jVH);
        }
        if (!this.jVD.equals(this.jVE)) {
            this.jVO = true;
            this.jVE.set(this.jVD);
        }
    }

    private void cDr() {
        if (this.jVO) {
            this.ddl.reset();
            this.jVD.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.jVz) {
                this.ddl.addCircle(this.jVD.centerX(), this.jVD.centerY(), Math.min(this.jVD.width(), this.jVD.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.jVC.length; i++) {
                    this.jVC[i] = (this.jVB[i] + this.jVN) - (this.mBorderWidth / 2.0f);
                }
                this.ddl.addRoundRect(this.jVD, this.jVC, Path.Direction.CW);
            }
            this.jVD.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            this.jVD.inset(this.jVN, this.jVN);
            if (this.jVz) {
                this.mPath.addCircle(this.jVD.centerX(), this.jVD.centerY(), Math.min(this.jVD.width(), this.jVD.height()) / 2.0f, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.jVD, this.jVB, Path.Direction.CW);
            }
            this.jVD.inset(-this.jVN, -this.jVN);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.jVO = false;
        }
    }

    private void lg() {
        Bitmap bitmap = getBitmap();
        if (this.jVQ == null || this.jVQ.get() != bitmap) {
            this.jVQ = new WeakReference<>(bitmap);
            this.mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.jVP = true;
        }
        if (this.jVP) {
            this.mPaint.getShader().setLocalMatrix(this.jVM);
            this.jVP = false;
        }
    }
}
