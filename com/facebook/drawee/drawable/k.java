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
    private p jCA;
    private boolean jDb;
    private boolean jDc;
    private final float[] jDd;
    final float[] jDe;
    final RectF jDf;
    final RectF jDg;
    final RectF jDh;
    final RectF jDi;
    final Matrix jDj;
    final Matrix jDk;
    final Matrix jDl;
    final Matrix jDm;
    final Matrix jDn;
    final Matrix jDo;
    private float jDp;
    private boolean jDq;
    private boolean jDr;
    private WeakReference<Bitmap> jDs;
    private int mBorderColor;
    private final Paint mBorderPaint;
    private float mBorderWidth;
    private final Paint mPaint;
    private final Path mPath;

    public k(Resources resources, Bitmap bitmap, @Nullable Paint paint) {
        super(resources, bitmap);
        this.jDb = false;
        this.jDc = false;
        this.jDd = new float[8];
        this.jDe = new float[8];
        this.jDf = new RectF();
        this.jDg = new RectF();
        this.jDh = new RectF();
        this.jDi = new RectF();
        this.jDj = new Matrix();
        this.jDk = new Matrix();
        this.jDl = new Matrix();
        this.jDm = new Matrix();
        this.jDn = new Matrix();
        this.jDo = new Matrix();
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.jDp = 0.0f;
        this.mPath = new Path();
        this.cUN = new Path();
        this.jDq = true;
        this.mPaint = new Paint();
        this.mBorderPaint = new Paint(1);
        this.jDr = true;
        if (paint != null) {
            this.mPaint.set(paint);
        }
        this.mPaint.setFlags(1);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.facebook.drawee.drawable.j
    public void rs(boolean z) {
        this.jDb = z;
        this.jDq = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.jDd, f);
        this.jDc = f != 0.0f;
        this.jDq = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void f(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.jDd, 0.0f);
            this.jDc = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.jDd, 0, 8);
            this.jDc = false;
            for (int i = 0; i < 8; i++) {
                this.jDc = (fArr[i] > 0.0f) | this.jDc;
            }
        }
        this.jDq = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.jDq = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aV(float f) {
        if (this.jDp != f) {
            this.jDp = f;
            this.jDq = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.o
    public void a(@Nullable p pVar) {
        this.jCA = pVar;
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
        if (!cvm()) {
            super.draw(canvas);
            return;
        }
        cvn();
        cvo();
        mm();
        int save = canvas.save();
        canvas.concat(this.jDn);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth > 0.0f) {
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setColor(e.cA(this.mBorderColor, this.mPaint.getAlpha()));
            canvas.drawPath(this.cUN, this.mBorderPaint);
        }
        canvas.restoreToCount(save);
    }

    boolean cvm() {
        return this.jDb || this.jDc || this.mBorderWidth > 0.0f;
    }

    private void cvn() {
        if (this.jCA != null) {
            this.jCA.e(this.jDl);
            this.jCA.b(this.jDf);
        } else {
            this.jDl.reset();
            this.jDf.set(getBounds());
        }
        this.jDh.set(0.0f, 0.0f, getBitmap().getWidth(), getBitmap().getHeight());
        this.jDi.set(getBounds());
        this.jDj.setRectToRect(this.jDh, this.jDi, Matrix.ScaleToFit.FILL);
        if (!this.jDl.equals(this.jDm) || !this.jDj.equals(this.jDk)) {
            this.jDr = true;
            this.jDl.invert(this.jDn);
            this.jDo.set(this.jDl);
            this.jDo.preConcat(this.jDj);
            this.jDm.set(this.jDl);
            this.jDk.set(this.jDj);
        }
        if (!this.jDf.equals(this.jDg)) {
            this.jDq = true;
            this.jDg.set(this.jDf);
        }
    }

    private void cvo() {
        if (this.jDq) {
            this.cUN.reset();
            this.jDf.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.jDb) {
                this.cUN.addCircle(this.jDf.centerX(), this.jDf.centerY(), Math.min(this.jDf.width(), this.jDf.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.jDe.length; i++) {
                    this.jDe[i] = (this.jDd[i] + this.jDp) - (this.mBorderWidth / 2.0f);
                }
                this.cUN.addRoundRect(this.jDf, this.jDe, Path.Direction.CW);
            }
            this.jDf.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            this.jDf.inset(this.jDp, this.jDp);
            if (this.jDb) {
                this.mPath.addCircle(this.jDf.centerX(), this.jDf.centerY(), Math.min(this.jDf.width(), this.jDf.height()) / 2.0f, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.jDf, this.jDd, Path.Direction.CW);
            }
            this.jDf.inset(-this.jDp, -this.jDp);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.jDq = false;
        }
    }

    private void mm() {
        Bitmap bitmap = getBitmap();
        if (this.jDs == null || this.jDs.get() != bitmap) {
            this.jDs = new WeakReference<>(bitmap);
            this.mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.jDr = true;
        }
        if (this.jDr) {
            this.mPaint.getShader().setLocalMatrix(this.jDo);
            this.jDr = false;
        }
    }
}
