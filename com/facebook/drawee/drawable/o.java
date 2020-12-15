package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.p;
/* loaded from: classes8.dex */
public class o extends g {
    Matrix mDrawMatrix;
    private Matrix mTempMatrix;
    int pfL;
    int pfM;
    p.b pfh;
    Object pgr;
    PointF pgs;

    public o(Drawable drawable, p.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.pgs = null;
        this.pfL = 0;
        this.pfM = 0;
        this.mTempMatrix = new Matrix();
        this.pfh = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable setCurrent(Drawable drawable) {
        Drawable current = super.setCurrent(drawable);
        configureBounds();
        return current;
    }

    public p.b erM() {
        return this.pfh;
    }

    public void a(p.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.pfh, bVar)) {
            this.pfh = bVar;
            this.pgr = null;
            configureBounds();
            invalidateSelf();
        }
    }

    public void d(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.pgs, pointF)) {
            if (this.pgs == null) {
                this.pgs = new PointF();
            }
            this.pgs.set(pointF);
            configureBounds();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        erI();
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

    private void erI() {
        boolean z;
        boolean z2 = false;
        if (this.pfh instanceof p.l) {
            Object state = ((p.l) this.pfh).getState();
            z = state == null || !state.equals(this.pgr);
            this.pgr = state;
        } else {
            z = false;
        }
        if (this.pfL != getCurrent().getIntrinsicWidth() || this.pfM != getCurrent().getIntrinsicHeight()) {
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
        this.pfL = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.pfM = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.pfh == p.b.pgt) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.pfh.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.pgs != null ? this.pgs.x : 0.5f, this.pgs != null ? this.pgs.y : 0.5f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
        erI();
        if (this.mDrawMatrix != null) {
            matrix.preConcat(this.mDrawMatrix);
        }
    }
}
