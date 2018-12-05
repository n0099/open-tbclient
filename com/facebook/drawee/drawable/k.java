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
    private final Path bIx;
    @Nullable
    private p iiG;
    private boolean ijh;
    private boolean iji;
    private final float[] ijj;
    final float[] ijk;
    final RectF ijl;
    final RectF ijm;
    final RectF ijn;
    final RectF ijo;
    final Matrix ijp;
    final Matrix ijq;
    final Matrix ijr;
    final Matrix ijs;
    final Matrix ijt;
    final Matrix iju;
    private float ijv;
    private boolean ijw;
    private boolean ijx;
    private WeakReference<Bitmap> ijy;
    private int mBorderColor;
    private final Paint mBorderPaint;
    private float mBorderWidth;
    private final Paint mPaint;
    private final Path mPath;

    public k(Resources resources, Bitmap bitmap, @Nullable Paint paint) {
        super(resources, bitmap);
        this.ijh = false;
        this.iji = false;
        this.ijj = new float[8];
        this.ijk = new float[8];
        this.ijl = new RectF();
        this.ijm = new RectF();
        this.ijn = new RectF();
        this.ijo = new RectF();
        this.ijp = new Matrix();
        this.ijq = new Matrix();
        this.ijr = new Matrix();
        this.ijs = new Matrix();
        this.ijt = new Matrix();
        this.iju = new Matrix();
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.ijv = 0.0f;
        this.mPath = new Path();
        this.bIx = new Path();
        this.ijw = true;
        this.mPaint = new Paint();
        this.mBorderPaint = new Paint(1);
        this.ijx = true;
        if (paint != null) {
            this.mPaint.set(paint);
        }
        this.mPaint.setFlags(1);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.facebook.drawee.drawable.j
    public void oU(boolean z) {
        this.ijh = z;
        this.ijw = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.ijj, f);
        this.iji = f != 0.0f;
        this.ijw = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void e(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.ijj, 0.0f);
            this.iji = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.ijj, 0, 8);
            this.iji = false;
            for (int i = 0; i < 8; i++) {
                this.iji = (fArr[i] > 0.0f) | this.iji;
            }
        }
        this.ijw = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.ijw = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aI(float f) {
        if (this.ijv != f) {
            this.ijv = f;
            this.ijw = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.o
    public void a(@Nullable p pVar) {
        this.iiG = pVar;
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
        if (!bUP()) {
            super.draw(canvas);
            return;
        }
        bUQ();
        bUR();
        mh();
        int save = canvas.save();
        canvas.concat(this.ijt);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth > 0.0f) {
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setColor(e.ce(this.mBorderColor, this.mPaint.getAlpha()));
            canvas.drawPath(this.bIx, this.mBorderPaint);
        }
        canvas.restoreToCount(save);
    }

    boolean bUP() {
        return this.ijh || this.iji || this.mBorderWidth > 0.0f;
    }

    private void bUQ() {
        if (this.iiG != null) {
            this.iiG.e(this.ijr);
            this.iiG.b(this.ijl);
        } else {
            this.ijr.reset();
            this.ijl.set(getBounds());
        }
        this.ijn.set(0.0f, 0.0f, getBitmap().getWidth(), getBitmap().getHeight());
        this.ijo.set(getBounds());
        this.ijp.setRectToRect(this.ijn, this.ijo, Matrix.ScaleToFit.FILL);
        if (!this.ijr.equals(this.ijs) || !this.ijp.equals(this.ijq)) {
            this.ijx = true;
            this.ijr.invert(this.ijt);
            this.iju.set(this.ijr);
            this.iju.preConcat(this.ijp);
            this.ijs.set(this.ijr);
            this.ijq.set(this.ijp);
        }
        if (!this.ijl.equals(this.ijm)) {
            this.ijw = true;
            this.ijm.set(this.ijl);
        }
    }

    private void bUR() {
        if (this.ijw) {
            this.bIx.reset();
            this.ijl.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.ijh) {
                this.bIx.addCircle(this.ijl.centerX(), this.ijl.centerY(), Math.min(this.ijl.width(), this.ijl.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.ijk.length; i++) {
                    this.ijk[i] = (this.ijj[i] + this.ijv) - (this.mBorderWidth / 2.0f);
                }
                this.bIx.addRoundRect(this.ijl, this.ijk, Path.Direction.CW);
            }
            this.ijl.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            this.ijl.inset(this.ijv, this.ijv);
            if (this.ijh) {
                this.mPath.addCircle(this.ijl.centerX(), this.ijl.centerY(), Math.min(this.ijl.width(), this.ijl.height()) / 2.0f, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.ijl, this.ijj, Path.Direction.CW);
            }
            this.ijl.inset(-this.ijv, -this.ijv);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.ijw = false;
        }
    }

    private void mh() {
        Bitmap bitmap = getBitmap();
        if (this.ijy == null || this.ijy.get() != bitmap) {
            this.ijy = new WeakReference<>(bitmap);
            this.mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.ijx = true;
        }
        if (this.ijx) {
            this.mPaint.getShader().setLocalMatrix(this.iju);
            this.ijx = false;
        }
    }
}
