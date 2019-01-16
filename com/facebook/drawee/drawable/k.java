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
    private final Path bJn;
    @Nullable
    private p imY;
    private boolean inA;
    private boolean inB;
    private final float[] inC;
    final float[] inD;
    final RectF inE;
    final RectF inF;
    final RectF inG;
    final RectF inH;
    final Matrix inI;
    final Matrix inJ;
    final Matrix inK;
    final Matrix inL;
    final Matrix inM;
    final Matrix inN;
    private float inO;
    private boolean inP;
    private boolean inQ;
    private WeakReference<Bitmap> inR;
    private int mBorderColor;
    private final Paint mBorderPaint;
    private float mBorderWidth;
    private final Paint mPaint;
    private final Path mPath;

    public k(Resources resources, Bitmap bitmap, @Nullable Paint paint) {
        super(resources, bitmap);
        this.inA = false;
        this.inB = false;
        this.inC = new float[8];
        this.inD = new float[8];
        this.inE = new RectF();
        this.inF = new RectF();
        this.inG = new RectF();
        this.inH = new RectF();
        this.inI = new Matrix();
        this.inJ = new Matrix();
        this.inK = new Matrix();
        this.inL = new Matrix();
        this.inM = new Matrix();
        this.inN = new Matrix();
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.inO = 0.0f;
        this.mPath = new Path();
        this.bJn = new Path();
        this.inP = true;
        this.mPaint = new Paint();
        this.mBorderPaint = new Paint(1);
        this.inQ = true;
        if (paint != null) {
            this.mPaint.set(paint);
        }
        this.mPaint.setFlags(1);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.facebook.drawee.drawable.j
    public void oY(boolean z) {
        this.inA = z;
        this.inP = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.inC, f);
        this.inB = f != 0.0f;
        this.inP = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void f(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.inC, 0.0f);
            this.inB = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.inC, 0, 8);
            this.inB = false;
            for (int i = 0; i < 8; i++) {
                this.inB = (fArr[i] > 0.0f) | this.inB;
            }
        }
        this.inP = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.inP = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aI(float f) {
        if (this.inO != f) {
            this.inO = f;
            this.inP = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.o
    public void a(@Nullable p pVar) {
        this.imY = pVar;
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
        if (!bWn()) {
            super.draw(canvas);
            return;
        }
        bWo();
        bWp();
        mh();
        int save = canvas.save();
        canvas.concat(this.inM);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth > 0.0f) {
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setColor(e.cf(this.mBorderColor, this.mPaint.getAlpha()));
            canvas.drawPath(this.bJn, this.mBorderPaint);
        }
        canvas.restoreToCount(save);
    }

    boolean bWn() {
        return this.inA || this.inB || this.mBorderWidth > 0.0f;
    }

    private void bWo() {
        if (this.imY != null) {
            this.imY.e(this.inK);
            this.imY.b(this.inE);
        } else {
            this.inK.reset();
            this.inE.set(getBounds());
        }
        this.inG.set(0.0f, 0.0f, getBitmap().getWidth(), getBitmap().getHeight());
        this.inH.set(getBounds());
        this.inI.setRectToRect(this.inG, this.inH, Matrix.ScaleToFit.FILL);
        if (!this.inK.equals(this.inL) || !this.inI.equals(this.inJ)) {
            this.inQ = true;
            this.inK.invert(this.inM);
            this.inN.set(this.inK);
            this.inN.preConcat(this.inI);
            this.inL.set(this.inK);
            this.inJ.set(this.inI);
        }
        if (!this.inE.equals(this.inF)) {
            this.inP = true;
            this.inF.set(this.inE);
        }
    }

    private void bWp() {
        if (this.inP) {
            this.bJn.reset();
            this.inE.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.inA) {
                this.bJn.addCircle(this.inE.centerX(), this.inE.centerY(), Math.min(this.inE.width(), this.inE.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.inD.length; i++) {
                    this.inD[i] = (this.inC[i] + this.inO) - (this.mBorderWidth / 2.0f);
                }
                this.bJn.addRoundRect(this.inE, this.inD, Path.Direction.CW);
            }
            this.inE.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            this.inE.inset(this.inO, this.inO);
            if (this.inA) {
                this.mPath.addCircle(this.inE.centerX(), this.inE.centerY(), Math.min(this.inE.width(), this.inE.height()) / 2.0f, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.inE, this.inC, Path.Direction.CW);
            }
            this.inE.inset(-this.inO, -this.inO);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.inP = false;
        }
    }

    private void mh() {
        Bitmap bitmap = getBitmap();
        if (this.inR == null || this.inR.get() != bitmap) {
            this.inR = new WeakReference<>(bitmap);
            this.mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.inQ = true;
        }
        if (this.inQ) {
            this.mPaint.getShader().setLocalMatrix(this.inN);
            this.inQ = false;
        }
    }
}
