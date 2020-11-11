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
/* loaded from: classes15.dex */
public abstract class m extends Drawable implements j, q {
    @Nullable
    private r mTransformCallback;
    @Nullable
    Matrix oPB;
    @Nullable
    float[] oPe;
    @Nullable
    RectF oPj;
    @Nullable
    Matrix oPk;
    private final Drawable oPo;
    protected boolean fzP = false;
    protected boolean oPp = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean oPq = true;
    protected int mBorderColor = 0;
    protected final Path oPg = new Path();
    private final float[] oPr = new float[8];
    final float[] oPd = new float[8];
    final RectF oPs = new RectF();
    final RectF oPt = new RectF();
    final RectF oPu = new RectF();
    final RectF oPv = new RectF();
    final Matrix oPw = new Matrix();
    final Matrix oPx = new Matrix();
    final Matrix oPy = new Matrix();
    final Matrix oPz = new Matrix();
    final Matrix oPA = new Matrix();
    final Matrix mTransform = new Matrix();
    private float mPadding = 0.0f;
    private boolean oPf = false;
    private boolean oPC = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.oPo = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void Ag(boolean z) {
        this.fzP = z;
        this.oPC = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.oPr, f);
        this.oPp = f != 0.0f;
        this.oPC = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.oPr, 0.0f);
            this.oPp = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.oPr, 0, 8);
            this.oPp = false;
            for (int i = 0; i < 8; i++) {
                this.oPp = (fArr[i] > 0.0f) | this.oPp;
            }
        }
        this.oPC = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void o(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.oPC = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bl(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.oPC = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void Ah(boolean z) {
        if (this.oPf != z) {
            this.oPf = z;
            this.oPC = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void setTransformCallback(@Nullable r rVar) {
        this.mTransformCallback = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void elX() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.oPy);
            this.mTransformCallback.getRootBounds(this.oPs);
        } else {
            this.oPy.reset();
            this.oPs.set(getBounds());
        }
        this.oPu.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.oPv.set(this.oPo.getBounds());
        this.oPw.setRectToRect(this.oPu, this.oPv, Matrix.ScaleToFit.FILL);
        if (this.oPf) {
            if (this.oPj == null) {
                this.oPj = new RectF(this.oPs);
            } else {
                this.oPj.set(this.oPs);
            }
            this.oPj.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.oPk == null) {
                this.oPk = new Matrix();
            }
            this.oPk.setRectToRect(this.oPs, this.oPj, Matrix.ScaleToFit.FILL);
        } else if (this.oPk != null) {
            this.oPk.reset();
        }
        if (!this.oPy.equals(this.oPz) || !this.oPw.equals(this.oPx) || (this.oPk != null && !this.oPk.equals(this.oPB))) {
            this.oPq = true;
            this.oPy.invert(this.oPA);
            this.mTransform.set(this.oPy);
            if (this.oPf) {
                this.mTransform.postConcat(this.oPk);
            }
            this.mTransform.preConcat(this.oPw);
            this.oPz.set(this.oPy);
            this.oPx.set(this.oPw);
            if (this.oPf) {
                if (this.oPB == null) {
                    this.oPB = new Matrix(this.oPk);
                } else {
                    this.oPB.set(this.oPk);
                }
            } else if (this.oPB != null) {
                this.oPB.reset();
            }
        }
        if (!this.oPs.equals(this.oPt)) {
            this.oPC = true;
            this.oPt.set(this.oPs);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void elW() {
        if (this.oPC) {
            this.oPg.reset();
            this.oPs.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.fzP) {
                this.oPg.addCircle(this.oPs.centerX(), this.oPs.centerY(), Math.min(this.oPs.width(), this.oPs.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.oPd.length; i++) {
                    this.oPd[i] = (this.oPr[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.oPg.addRoundRect(this.oPs, this.oPd, Path.Direction.CW);
            }
            this.oPs.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.oPf ? this.mBorderWidth : 0.0f);
            this.oPs.inset(f, f);
            if (this.fzP) {
                this.mPath.addCircle(this.oPs.centerX(), this.oPs.centerY(), Math.min(this.oPs.width(), this.oPs.height()) / 2.0f, Path.Direction.CW);
            } else if (this.oPf) {
                if (this.oPe == null) {
                    this.oPe = new float[8];
                }
                for (int i2 = 0; i2 < this.oPd.length; i2++) {
                    this.oPe[i2] = this.oPr[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.oPs, this.oPe, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.oPs, this.oPr, Path.Direction.CW);
            }
            this.oPs.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.oPC = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean elV() {
        return this.fzP || this.oPp || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.oPo.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.oPo.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.oPo.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.oPo.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.oPo.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.oPo.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    @Nullable
    public ColorFilter getColorFilter() {
        return this.oPo.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.oPo.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.oPo.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.oPo.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.oPo.draw(canvas);
    }
}
