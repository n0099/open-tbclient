package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.p;
/* loaded from: classes11.dex */
public class o extends g {
    Matrix mDrawMatrix;
    private Matrix mTempMatrix;
    int nyS;
    int nyT;
    p.b nyp;
    Object nzy;
    PointF nzz;

    public o(Drawable drawable, p.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.nzz = null;
        this.nyS = 0;
        this.nyT = 0;
        this.mTempMatrix = new Matrix();
        this.nyp = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable setCurrent(Drawable drawable) {
        Drawable current = super.setCurrent(drawable);
        configureBounds();
        return current;
    }

    public p.b dUA() {
        return this.nyp;
    }

    public void a(p.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.nyp, bVar)) {
            this.nyp = bVar;
            this.nzy = null;
            configureBounds();
            invalidateSelf();
        }
    }

    public void d(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.nzz, pointF)) {
            if (this.nzz == null) {
                this.nzz = new PointF();
            }
            this.nzz.set(pointF);
            configureBounds();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        dUw();
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

    private void dUw() {
        boolean z;
        boolean z2 = false;
        if (this.nyp instanceof p.l) {
            Object state = ((p.l) this.nyp).getState();
            z = state == null || !state.equals(this.nzy);
            this.nzy = state;
        } else {
            z = false;
        }
        if (this.nyS != getCurrent().getIntrinsicWidth() || this.nyT != getCurrent().getIntrinsicHeight()) {
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
        this.nyS = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.nyT = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.nyp == p.b.nzA) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.nyp.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.nzz != null ? this.nzz.x : 0.5f, this.nzz != null ? this.nzz.y : 0.5f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
        dUw();
        if (this.mDrawMatrix != null) {
            matrix.preConcat(this.mDrawMatrix);
        }
    }
}
