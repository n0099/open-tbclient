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
    private final Path bJo;
    @Nullable
    private p imZ;
    private boolean inB;
    private boolean inC;
    private final float[] inD;
    final float[] inE;
    final RectF inF;
    final RectF inG;
    final RectF inH;
    final RectF inI;
    final Matrix inJ;
    final Matrix inK;
    final Matrix inL;
    final Matrix inM;
    final Matrix inN;
    final Matrix inO;
    private float inP;
    private boolean inQ;
    private boolean inR;
    private WeakReference<Bitmap> inS;
    private int mBorderColor;
    private final Paint mBorderPaint;
    private float mBorderWidth;
    private final Paint mPaint;
    private final Path mPath;

    public k(Resources resources, Bitmap bitmap, @Nullable Paint paint) {
        super(resources, bitmap);
        this.inB = false;
        this.inC = false;
        this.inD = new float[8];
        this.inE = new float[8];
        this.inF = new RectF();
        this.inG = new RectF();
        this.inH = new RectF();
        this.inI = new RectF();
        this.inJ = new Matrix();
        this.inK = new Matrix();
        this.inL = new Matrix();
        this.inM = new Matrix();
        this.inN = new Matrix();
        this.inO = new Matrix();
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.inP = 0.0f;
        this.mPath = new Path();
        this.bJo = new Path();
        this.inQ = true;
        this.mPaint = new Paint();
        this.mBorderPaint = new Paint(1);
        this.inR = true;
        if (paint != null) {
            this.mPaint.set(paint);
        }
        this.mPaint.setFlags(1);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.facebook.drawee.drawable.j
    public void oY(boolean z) {
        this.inB = z;
        this.inQ = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.inD, f);
        this.inC = f != 0.0f;
        this.inQ = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void f(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.inD, 0.0f);
            this.inC = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.inD, 0, 8);
            this.inC = false;
            for (int i = 0; i < 8; i++) {
                this.inC = (fArr[i] > 0.0f) | this.inC;
            }
        }
        this.inQ = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.inQ = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aI(float f) {
        if (this.inP != f) {
            this.inP = f;
            this.inQ = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.o
    public void a(@Nullable p pVar) {
        this.imZ = pVar;
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
        canvas.concat(this.inN);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth > 0.0f) {
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setColor(e.cf(this.mBorderColor, this.mPaint.getAlpha()));
            canvas.drawPath(this.bJo, this.mBorderPaint);
        }
        canvas.restoreToCount(save);
    }

    boolean bWn() {
        return this.inB || this.inC || this.mBorderWidth > 0.0f;
    }

    private void bWo() {
        if (this.imZ != null) {
            this.imZ.e(this.inL);
            this.imZ.b(this.inF);
        } else {
            this.inL.reset();
            this.inF.set(getBounds());
        }
        this.inH.set(0.0f, 0.0f, getBitmap().getWidth(), getBitmap().getHeight());
        this.inI.set(getBounds());
        this.inJ.setRectToRect(this.inH, this.inI, Matrix.ScaleToFit.FILL);
        if (!this.inL.equals(this.inM) || !this.inJ.equals(this.inK)) {
            this.inR = true;
            this.inL.invert(this.inN);
            this.inO.set(this.inL);
            this.inO.preConcat(this.inJ);
            this.inM.set(this.inL);
            this.inK.set(this.inJ);
        }
        if (!this.inF.equals(this.inG)) {
            this.inQ = true;
            this.inG.set(this.inF);
        }
    }

    private void bWp() {
        if (this.inQ) {
            this.bJo.reset();
            this.inF.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.inB) {
                this.bJo.addCircle(this.inF.centerX(), this.inF.centerY(), Math.min(this.inF.width(), this.inF.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.inE.length; i++) {
                    this.inE[i] = (this.inD[i] + this.inP) - (this.mBorderWidth / 2.0f);
                }
                this.bJo.addRoundRect(this.inF, this.inE, Path.Direction.CW);
            }
            this.inF.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            this.inF.inset(this.inP, this.inP);
            if (this.inB) {
                this.mPath.addCircle(this.inF.centerX(), this.inF.centerY(), Math.min(this.inF.width(), this.inF.height()) / 2.0f, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.inF, this.inD, Path.Direction.CW);
            }
            this.inF.inset(-this.inP, -this.inP);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.inQ = false;
        }
    }

    private void mh() {
        Bitmap bitmap = getBitmap();
        if (this.inS == null || this.inS.get() != bitmap) {
            this.inS = new WeakReference<>(bitmap);
            this.mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.inR = true;
        }
        if (this.inR) {
            this.mPaint.getShader().setLocalMatrix(this.inO);
            this.inR = false;
        }
    }
}
