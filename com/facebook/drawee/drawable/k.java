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
    private p hZI;
    private WeakReference<Bitmap> iaA;
    private boolean iaj;
    private boolean iak;
    private final float[] ial;
    final float[] iam;
    final RectF ian;
    final RectF iao;
    final RectF iap;
    final RectF iaq;
    final Matrix iar;
    final Matrix ias;
    final Matrix iat;
    final Matrix iau;
    final Matrix iav;
    final Matrix iaw;
    private float iax;
    private boolean iay;
    private boolean iaz;
    private int mBorderColor;
    private final Paint mBorderPaint;
    private float mBorderWidth;
    private final Paint mPaint;
    private final Path mPath;

    public k(Resources resources, Bitmap bitmap, @Nullable Paint paint) {
        super(resources, bitmap);
        this.iaj = false;
        this.iak = false;
        this.ial = new float[8];
        this.iam = new float[8];
        this.ian = new RectF();
        this.iao = new RectF();
        this.iap = new RectF();
        this.iaq = new RectF();
        this.iar = new Matrix();
        this.ias = new Matrix();
        this.iat = new Matrix();
        this.iau = new Matrix();
        this.iav = new Matrix();
        this.iaw = new Matrix();
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.iax = 0.0f;
        this.mPath = new Path();
        this.bEi = new Path();
        this.iay = true;
        this.mPaint = new Paint();
        this.mBorderPaint = new Paint(1);
        this.iaz = true;
        if (paint != null) {
            this.mPaint.set(paint);
        }
        this.mPaint.setFlags(1);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.facebook.drawee.drawable.j
    public void oE(boolean z) {
        this.iaj = z;
        this.iay = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.ial, f);
        this.iak = f != 0.0f;
        this.iay = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void e(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.ial, 0.0f);
            this.iak = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.ial, 0, 8);
            this.iak = false;
            for (int i = 0; i < 8; i++) {
                this.iak = (fArr[i] > 0.0f) | this.iak;
            }
        }
        this.iay = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.iay = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aG(float f) {
        if (this.iax != f) {
            this.iax = f;
            this.iay = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.o
    public void a(@Nullable p pVar) {
        this.hZI = pVar;
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
        canvas.concat(this.iav);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth > 0.0f) {
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setColor(e.cd(this.mBorderColor, this.mPaint.getAlpha()));
            canvas.drawPath(this.bEi, this.mBorderPaint);
        }
        canvas.restoreToCount(save);
    }

    boolean bTo() {
        return this.iaj || this.iak || this.mBorderWidth > 0.0f;
    }

    private void bTp() {
        if (this.hZI != null) {
            this.hZI.e(this.iat);
            this.hZI.b(this.ian);
        } else {
            this.iat.reset();
            this.ian.set(getBounds());
        }
        this.iap.set(0.0f, 0.0f, getBitmap().getWidth(), getBitmap().getHeight());
        this.iaq.set(getBounds());
        this.iar.setRectToRect(this.iap, this.iaq, Matrix.ScaleToFit.FILL);
        if (!this.iat.equals(this.iau) || !this.iar.equals(this.ias)) {
            this.iaz = true;
            this.iat.invert(this.iav);
            this.iaw.set(this.iat);
            this.iaw.preConcat(this.iar);
            this.iau.set(this.iat);
            this.ias.set(this.iar);
        }
        if (!this.ian.equals(this.iao)) {
            this.iay = true;
            this.iao.set(this.ian);
        }
    }

    private void bTq() {
        if (this.iay) {
            this.bEi.reset();
            this.ian.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.iaj) {
                this.bEi.addCircle(this.ian.centerX(), this.ian.centerY(), Math.min(this.ian.width(), this.ian.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.iam.length; i++) {
                    this.iam[i] = (this.ial[i] + this.iax) - (this.mBorderWidth / 2.0f);
                }
                this.bEi.addRoundRect(this.ian, this.iam, Path.Direction.CW);
            }
            this.ian.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            this.ian.inset(this.iax, this.iax);
            if (this.iaj) {
                this.mPath.addCircle(this.ian.centerX(), this.ian.centerY(), Math.min(this.ian.width(), this.ian.height()) / 2.0f, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.ian, this.ial, Path.Direction.CW);
            }
            this.ian.inset(-this.iax, -this.iax);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.iay = false;
        }
    }

    private void mk() {
        Bitmap bitmap = getBitmap();
        if (this.iaA == null || this.iaA.get() != bitmap) {
            this.iaA = new WeakReference<>(bitmap);
            this.mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.iaz = true;
        }
        if (this.iaz) {
            this.mPaint.getShader().setLocalMatrix(this.iaw);
            this.iaz = false;
        }
    }
}
