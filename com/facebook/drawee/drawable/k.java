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
    private final Path dgE;
    @Nullable
    private p kfH;
    private boolean kgh;
    private boolean kgi;
    private final float[] kgj;
    final float[] kgk;
    final RectF kgl;
    final RectF kgm;
    final RectF kgn;
    final RectF kgo;
    final Matrix kgp;
    final Matrix kgq;
    final Matrix kgr;
    final Matrix kgs;
    final Matrix kgt;
    final Matrix kgu;
    private float kgv;
    private boolean kgw;
    private boolean kgx;
    private WeakReference<Bitmap> kgy;
    private float mBorderWidth;
    private final Paint mPaint;
    private final Path mPath;

    public k(Resources resources, Bitmap bitmap, @Nullable Paint paint) {
        super(resources, bitmap);
        this.kgh = false;
        this.kgi = false;
        this.kgj = new float[8];
        this.kgk = new float[8];
        this.kgl = new RectF();
        this.kgm = new RectF();
        this.kgn = new RectF();
        this.kgo = new RectF();
        this.kgp = new Matrix();
        this.kgq = new Matrix();
        this.kgr = new Matrix();
        this.kgs = new Matrix();
        this.kgt = new Matrix();
        this.kgu = new Matrix();
        this.mBorderWidth = 0.0f;
        this.GW = 0;
        this.kgv = 0.0f;
        this.mPath = new Path();
        this.dgE = new Path();
        this.kgw = true;
        this.mPaint = new Paint();
        this.GF = new Paint(1);
        this.kgx = true;
        if (paint != null) {
            this.mPaint.set(paint);
        }
        this.mPaint.setFlags(1);
        this.GF.setStyle(Paint.Style.STROKE);
    }

    @Override // com.facebook.drawee.drawable.j
    public void sB(boolean z) {
        this.kgh = z;
        this.kgw = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.kgj, f);
        this.kgi = f != 0.0f;
        this.kgw = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void j(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.kgj, 0.0f);
            this.kgi = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.kgj, 0, 8);
            this.kgi = false;
            for (int i = 0; i < 8; i++) {
                this.kgi = (fArr[i] > 0.0f) | this.kgi;
            }
        }
        this.kgw = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void l(int i, float f) {
        if (this.GW != i || this.mBorderWidth != f) {
            this.GW = i;
            this.mBorderWidth = f;
            this.kgw = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bb(float f) {
        if (this.kgv != f) {
            this.kgv = f;
            this.kgw = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.o
    public void a(@Nullable p pVar) {
        this.kfH = pVar;
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
        if (!cHA()) {
            super.draw(canvas);
            return;
        }
        cHB();
        cHC();
        lw();
        int save = canvas.save();
        canvas.concat(this.kgt);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth > 0.0f) {
            this.GF.setStrokeWidth(this.mBorderWidth);
            this.GF.setColor(e.cL(this.GW, this.mPaint.getAlpha()));
            canvas.drawPath(this.dgE, this.GF);
        }
        canvas.restoreToCount(save);
    }

    boolean cHA() {
        return this.kgh || this.kgi || this.mBorderWidth > 0.0f;
    }

    private void cHB() {
        if (this.kfH != null) {
            this.kfH.e(this.kgr);
            this.kfH.b(this.kgl);
        } else {
            this.kgr.reset();
            this.kgl.set(getBounds());
        }
        this.kgn.set(0.0f, 0.0f, getBitmap().getWidth(), getBitmap().getHeight());
        this.kgo.set(getBounds());
        this.kgp.setRectToRect(this.kgn, this.kgo, Matrix.ScaleToFit.FILL);
        if (!this.kgr.equals(this.kgs) || !this.kgp.equals(this.kgq)) {
            this.kgx = true;
            this.kgr.invert(this.kgt);
            this.kgu.set(this.kgr);
            this.kgu.preConcat(this.kgp);
            this.kgs.set(this.kgr);
            this.kgq.set(this.kgp);
        }
        if (!this.kgl.equals(this.kgm)) {
            this.kgw = true;
            this.kgm.set(this.kgl);
        }
    }

    private void cHC() {
        if (this.kgw) {
            this.dgE.reset();
            this.kgl.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.kgh) {
                this.dgE.addCircle(this.kgl.centerX(), this.kgl.centerY(), Math.min(this.kgl.width(), this.kgl.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.kgk.length; i++) {
                    this.kgk[i] = (this.kgj[i] + this.kgv) - (this.mBorderWidth / 2.0f);
                }
                this.dgE.addRoundRect(this.kgl, this.kgk, Path.Direction.CW);
            }
            this.kgl.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            this.kgl.inset(this.kgv, this.kgv);
            if (this.kgh) {
                this.mPath.addCircle(this.kgl.centerX(), this.kgl.centerY(), Math.min(this.kgl.width(), this.kgl.height()) / 2.0f, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.kgl, this.kgj, Path.Direction.CW);
            }
            this.kgl.inset(-this.kgv, -this.kgv);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.kgw = false;
        }
    }

    private void lw() {
        Bitmap bitmap = getBitmap();
        if (this.kgy == null || this.kgy.get() != bitmap) {
            this.kgy = new WeakReference<>(bitmap);
            this.mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.kgx = true;
        }
        if (this.kgx) {
            this.mPaint.getShader().setLocalMatrix(this.kgu);
            this.kgx = false;
        }
    }
}
