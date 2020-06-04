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
    p.b mpW;
    int mqA;
    int mqz;
    Object mrg;
    PointF mrh;

    public o(Drawable drawable, p.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.mrh = null;
        this.mqz = 0;
        this.mqA = 0;
        this.mTempMatrix = new Matrix();
        this.mpW = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable setCurrent(Drawable drawable) {
        Drawable current = super.setCurrent(drawable);
        configureBounds();
        return current;
    }

    public p.b dwz() {
        return this.mpW;
    }

    public void a(p.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.mpW, bVar)) {
            this.mpW = bVar;
            this.mrg = null;
            configureBounds();
            invalidateSelf();
        }
    }

    public void d(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.mrh, pointF)) {
            if (this.mrh == null) {
                this.mrh = new PointF();
            }
            this.mrh.set(pointF);
            configureBounds();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        dwv();
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

    private void dwv() {
        boolean z;
        boolean z2 = false;
        if (this.mpW instanceof p.l) {
            Object state = ((p.l) this.mpW).getState();
            z = state == null || !state.equals(this.mrg);
            this.mrg = state;
        } else {
            z = false;
        }
        if (this.mqz != getCurrent().getIntrinsicWidth() || this.mqA != getCurrent().getIntrinsicHeight()) {
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
        this.mqz = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.mqA = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.mpW == p.b.mri) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.mpW.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.mrh != null ? this.mrh.x : 0.5f, this.mrh != null ? this.mrh.y : 0.5f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
        dwv();
        if (this.mDrawMatrix != null) {
            matrix.preConcat(this.mDrawMatrix);
        }
    }
}
