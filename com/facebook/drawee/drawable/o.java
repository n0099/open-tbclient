package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.p;
/* loaded from: classes13.dex */
public class o extends g {
    Matrix mDrawMatrix;
    private Matrix mTempMatrix;
    p.b moM;
    Object mpW;
    PointF mpX;
    int mpp;
    int mpq;

    public o(Drawable drawable, p.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.mpX = null;
        this.mpp = 0;
        this.mpq = 0;
        this.mTempMatrix = new Matrix();
        this.moM = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable setCurrent(Drawable drawable) {
        Drawable current = super.setCurrent(drawable);
        configureBounds();
        return current;
    }

    public p.b dwl() {
        return this.moM;
    }

    public void a(p.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.moM, bVar)) {
            this.moM = bVar;
            this.mpW = null;
            configureBounds();
            invalidateSelf();
        }
    }

    public void d(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.mpX, pointF)) {
            if (this.mpX == null) {
                this.mpX = new PointF();
            }
            this.mpX.set(pointF);
            configureBounds();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        dwh();
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

    private void dwh() {
        boolean z;
        boolean z2 = false;
        if (this.moM instanceof p.l) {
            Object state = ((p.l) this.moM).getState();
            z = state == null || !state.equals(this.mpW);
            this.mpW = state;
        } else {
            z = false;
        }
        if (this.mpp != getCurrent().getIntrinsicWidth() || this.mpq != getCurrent().getIntrinsicHeight()) {
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
        this.mpp = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.mpq = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.moM == p.b.mpY) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.moM.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.mpX != null ? this.mpX.x : 0.5f, this.mpX != null ? this.mpX.y : 0.5f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
        dwh();
        if (this.mDrawMatrix != null) {
            matrix.preConcat(this.mDrawMatrix);
        }
    }
}
