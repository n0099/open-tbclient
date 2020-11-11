package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.p;
/* loaded from: classes15.dex */
public class o extends g {
    Matrix mDrawMatrix;
    private Matrix mTempMatrix;
    int oOX;
    int oOY;
    p.b oOu;
    Object oPD;
    PointF oPE;

    public o(Drawable drawable, p.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.oPE = null;
        this.oOX = 0;
        this.oOY = 0;
        this.mTempMatrix = new Matrix();
        this.oOu = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable setCurrent(Drawable drawable) {
        Drawable current = super.setCurrent(drawable);
        configureBounds();
        return current;
    }

    public p.b elY() {
        return this.oOu;
    }

    public void a(p.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.oOu, bVar)) {
            this.oOu = bVar;
            this.oPD = null;
            configureBounds();
            invalidateSelf();
        }
    }

    public void d(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.oPE, pointF)) {
            if (this.oPE == null) {
                this.oPE = new PointF();
            }
            this.oPE.set(pointF);
            configureBounds();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        elU();
        if (this.mDrawMatrix != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.mDrawMatrix);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        configureBounds();
    }

    private void elU() {
        boolean z;
        boolean z2 = false;
        if (this.oOu instanceof p.l) {
            Object state = ((p.l) this.oOu).getState();
            z = state == null || !state.equals(this.oPD);
            this.oPD = state;
        } else {
            z = false;
        }
        if (this.oOX != getCurrent().getIntrinsicWidth() || this.oOY != getCurrent().getIntrinsicHeight()) {
            z2 = true;
        }
        if (z2 || z) {
            configureBounds();
        }
    }

    void configureBounds() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.oOX = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.oOY = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.oOu == p.b.oPF) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.oOu.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.oPE != null ? this.oPE.x : 0.5f, this.oPE != null ? this.oPE.y : 0.5f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
        elU();
        if (this.mDrawMatrix != null) {
            matrix.preConcat(this.mDrawMatrix);
        }
    }
}
