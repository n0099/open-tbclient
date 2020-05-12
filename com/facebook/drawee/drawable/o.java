package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.p;
/* loaded from: classes13.dex */
public class o extends g {
    p.b lUT;
    int lVw;
    int lVx;
    Object lWc;
    PointF lWd;
    Matrix mDrawMatrix;
    private Matrix mTempMatrix;

    public o(Drawable drawable, p.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.lWd = null;
        this.lVw = 0;
        this.lVx = 0;
        this.mTempMatrix = new Matrix();
        this.lUT = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable setCurrent(Drawable drawable) {
        Drawable current = super.setCurrent(drawable);
        configureBounds();
        return current;
    }

    public p.b doT() {
        return this.lUT;
    }

    public void a(p.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.lUT, bVar)) {
            this.lUT = bVar;
            this.lWc = null;
            configureBounds();
            invalidateSelf();
        }
    }

    public void d(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.lWd, pointF)) {
            if (this.lWd == null) {
                this.lWd = new PointF();
            }
            this.lWd.set(pointF);
            configureBounds();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        doP();
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

    private void doP() {
        boolean z;
        boolean z2 = false;
        if (this.lUT instanceof p.l) {
            Object state = ((p.l) this.lUT).getState();
            z = state == null || !state.equals(this.lWc);
            this.lWc = state;
        } else {
            z = false;
        }
        if (this.lVw != getCurrent().getIntrinsicWidth() || this.lVx != getCurrent().getIntrinsicHeight()) {
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
        this.lVw = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.lVx = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.lUT == p.b.lWe) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.lUT.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.lWd != null ? this.lWd.x : 0.5f, this.lWd != null ? this.lWd.y : 0.5f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
        doP();
        if (this.mDrawMatrix != null) {
            matrix.preConcat(this.mDrawMatrix);
        }
    }
}
