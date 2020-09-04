package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import java.util.Arrays;
/* loaded from: classes4.dex */
public abstract class m extends Drawable implements j, q {
    @Nullable
    private r mTransformCallback;
    @Nullable
    float[] npb;
    @Nullable
    RectF npg;
    @Nullable
    Matrix nph;
    private final Drawable npl;
    @Nullable
    Matrix npy;
    protected boolean eWv = false;
    protected boolean npm = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean npn = true;
    protected int mBorderColor = 0;
    protected final Path npd = new Path();
    private final float[] npo = new float[8];
    final float[] npa = new float[8];
    final RectF npp = new RectF();
    final RectF npq = new RectF();
    final RectF npr = new RectF();
    final RectF nps = new RectF();
    final Matrix npt = new Matrix();
    final Matrix npu = new Matrix();
    final Matrix npv = new Matrix();
    final Matrix npw = new Matrix();
    final Matrix npx = new Matrix();
    final Matrix mTransform = new Matrix();
    private float mPadding = 0.0f;
    private boolean npc = false;
    private boolean npz = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.npl = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void xX(boolean z) {
        this.eWv = z;
        this.npz = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.npo, f);
        this.npm = f != 0.0f;
        this.npz = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.npo, 0.0f);
            this.npm = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.npo, 0, 8);
            this.npm = false;
            for (int i = 0; i < 8; i++) {
                this.npm = (fArr[i] > 0.0f) | this.npm;
            }
        }
        this.npz = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.npz = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aM(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.npz = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void xY(boolean z) {
        if (this.npc != z) {
            this.npc = z;
            this.npz = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void setTransformCallback(@Nullable r rVar) {
        this.mTransformCallback = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dQB() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.npv);
            this.mTransformCallback.getRootBounds(this.npp);
        } else {
            this.npv.reset();
            this.npp.set(getBounds());
        }
        this.npr.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.nps.set(this.npl.getBounds());
        this.npt.setRectToRect(this.npr, this.nps, Matrix.ScaleToFit.FILL);
        if (this.npc) {
            if (this.npg == null) {
                this.npg = new RectF(this.npp);
            } else {
                this.npg.set(this.npp);
            }
            this.npg.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.nph == null) {
                this.nph = new Matrix();
            }
            this.nph.setRectToRect(this.npp, this.npg, Matrix.ScaleToFit.FILL);
        } else if (this.nph != null) {
            this.nph.reset();
        }
        if (!this.npv.equals(this.npw) || !this.npt.equals(this.npu) || (this.nph != null && !this.nph.equals(this.npy))) {
            this.npn = true;
            this.npv.invert(this.npx);
            this.mTransform.set(this.npv);
            if (this.npc) {
                this.mTransform.postConcat(this.nph);
            }
            this.mTransform.preConcat(this.npt);
            this.npw.set(this.npv);
            this.npu.set(this.npt);
            if (this.npc) {
                if (this.npy == null) {
                    this.npy = new Matrix(this.nph);
                } else {
                    this.npy.set(this.nph);
                }
            } else if (this.npy != null) {
                this.npy.reset();
            }
        }
        if (!this.npp.equals(this.npq)) {
            this.npz = true;
            this.npq.set(this.npp);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dQA() {
        if (this.npz) {
            this.npd.reset();
            this.npp.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.eWv) {
                this.npd.addCircle(this.npp.centerX(), this.npp.centerY(), Math.min(this.npp.width(), this.npp.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.npa.length; i++) {
                    this.npa[i] = (this.npo[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.npd.addRoundRect(this.npp, this.npa, Path.Direction.CW);
            }
            this.npp.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.npc ? this.mBorderWidth : 0.0f);
            this.npp.inset(f, f);
            if (this.eWv) {
                this.mPath.addCircle(this.npp.centerX(), this.npp.centerY(), Math.min(this.npp.width(), this.npp.height()) / 2.0f, Path.Direction.CW);
            } else if (this.npc) {
                if (this.npb == null) {
                    this.npb = new float[8];
                }
                for (int i2 = 0; i2 < this.npa.length; i2++) {
                    this.npb[i2] = this.npo[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.npp, this.npb, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.npp, this.npo, Path.Direction.CW);
            }
            this.npp.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.npz = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dQz() {
        return this.eWv || this.npm || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.npl.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.npl.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.npl.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.npl.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.npl.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.npl.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    @Nullable
    public ColorFilter getColorFilter() {
        return this.npl.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.npl.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.npl.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.npl.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.npl.draw(canvas);
    }
}
