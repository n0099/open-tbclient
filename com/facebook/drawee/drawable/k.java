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
    private final Path bEi;
    @Nullable
    private p hZJ;
    private boolean iaA;
    private WeakReference<Bitmap> iaB;
    private boolean iak;
    private boolean ial;
    private final float[] iam;
    final float[] ian;
    final RectF iao;
    final RectF iap;
    final RectF iaq;
    final RectF iar;
    final Matrix ias;
    final Matrix iat;
    final Matrix iau;
    final Matrix iav;
    final Matrix iaw;
    final Matrix iax;
    private float iay;
    private boolean iaz;
    private int mBorderColor;
    private final Paint mBorderPaint;
    private float mBorderWidth;
    private final Paint mPaint;
    private final Path mPath;

    public k(Resources resources, Bitmap bitmap, @Nullable Paint paint) {
        super(resources, bitmap);
        this.iak = false;
        this.ial = false;
        this.iam = new float[8];
        this.ian = new float[8];
        this.iao = new RectF();
        this.iap = new RectF();
        this.iaq = new RectF();
        this.iar = new RectF();
        this.ias = new Matrix();
        this.iat = new Matrix();
        this.iau = new Matrix();
        this.iav = new Matrix();
        this.iaw = new Matrix();
        this.iax = new Matrix();
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.iay = 0.0f;
        this.mPath = new Path();
        this.bEi = new Path();
        this.iaz = true;
        this.mPaint = new Paint();
        this.mBorderPaint = new Paint(1);
        this.iaA = true;
        if (paint != null) {
            this.mPaint.set(paint);
        }
        this.mPaint.setFlags(1);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.facebook.drawee.drawable.j
    public void oE(boolean z) {
        this.iak = z;
        this.iaz = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.iam, f);
        this.ial = f != 0.0f;
        this.iaz = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void e(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.iam, 0.0f);
            this.ial = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.iam, 0, 8);
            this.ial = false;
            for (int i = 0; i < 8; i++) {
                this.ial = (fArr[i] > 0.0f) | this.ial;
            }
        }
        this.iaz = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.iaz = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aG(float f) {
        if (this.iay != f) {
            this.iay = f;
            this.iaz = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.o
    public void a(@Nullable p pVar) {
        this.hZJ = pVar;
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
        if (!bTo()) {
            super.draw(canvas);
            return;
        }
        bTp();
        bTq();
        mk();
        int save = canvas.save();
        canvas.concat(this.iaw);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth > 0.0f) {
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setColor(e.cd(this.mBorderColor, this.mPaint.getAlpha()));
            canvas.drawPath(this.bEi, this.mBorderPaint);
        }
        canvas.restoreToCount(save);
    }

    boolean bTo() {
        return this.iak || this.ial || this.mBorderWidth > 0.0f;
    }

    private void bTp() {
        if (this.hZJ != null) {
            this.hZJ.e(this.iau);
            this.hZJ.b(this.iao);
        } else {
            this.iau.reset();
            this.iao.set(getBounds());
        }
        this.iaq.set(0.0f, 0.0f, getBitmap().getWidth(), getBitmap().getHeight());
        this.iar.set(getBounds());
        this.ias.setRectToRect(this.iaq, this.iar, Matrix.ScaleToFit.FILL);
        if (!this.iau.equals(this.iav) || !this.ias.equals(this.iat)) {
            this.iaA = true;
            this.iau.invert(this.iaw);
            this.iax.set(this.iau);
            this.iax.preConcat(this.ias);
            this.iav.set(this.iau);
            this.iat.set(this.ias);
        }
        if (!this.iao.equals(this.iap)) {
            this.iaz = true;
            this.iap.set(this.iao);
        }
    }

    private void bTq() {
        if (this.iaz) {
            this.bEi.reset();
            this.iao.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.iak) {
                this.bEi.addCircle(this.iao.centerX(), this.iao.centerY(), Math.min(this.iao.width(), this.iao.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.ian.length; i++) {
                    this.ian[i] = (this.iam[i] + this.iay) - (this.mBorderWidth / 2.0f);
                }
                this.bEi.addRoundRect(this.iao, this.ian, Path.Direction.CW);
            }
            this.iao.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            this.iao.inset(this.iay, this.iay);
            if (this.iak) {
                this.mPath.addCircle(this.iao.centerX(), this.iao.centerY(), Math.min(this.iao.width(), this.iao.height()) / 2.0f, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.iao, this.iam, Path.Direction.CW);
            }
            this.iao.inset(-this.iay, -this.iay);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.iaz = false;
        }
    }

    private void mk() {
        Bitmap bitmap = getBitmap();
        if (this.iaB == null || this.iaB.get() != bitmap) {
            this.iaB = new WeakReference<>(bitmap);
            this.mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.iaA = true;
        }
        if (this.iaA) {
            this.mPaint.getShader().setLocalMatrix(this.iax);
            this.iaA = false;
        }
    }
}
