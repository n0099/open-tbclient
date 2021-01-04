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
    int pwT;
    int pwU;
    p.b pwn;
    PointF pxA;
    Object pxz;

    public o(Drawable drawable, p.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.pxA = null;
        this.pwT = 0;
        this.pwU = 0;
        this.mTempMatrix = new Matrix();
        this.pwn = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable x(Drawable drawable) {
        Drawable x = super.x(drawable);
        evL();
        return x;
    }

    public p.b evP() {
        return this.pwn;
    }

    public void a(p.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.pwn, bVar)) {
            this.pwn = bVar;
            this.pxz = null;
            evL();
            invalidateSelf();
        }
    }

    public void d(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.pxA, pointF)) {
            if (this.pxA == null) {
                this.pxA = new PointF();
            }
            this.pxA.set(pointF);
            evL();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        evK();
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
        evL();
    }

    private void evK() {
        boolean z;
        boolean z2 = false;
        if (this.pwn instanceof p.l) {
            Object state = ((p.l) this.pwn).getState();
            z = state == null || !state.equals(this.pxz);
            this.pxz = state;
        } else {
            z = false;
        }
        if (this.pwT != getCurrent().getIntrinsicWidth() || this.pwU != getCurrent().getIntrinsicHeight()) {
            z2 = true;
        }
        if (z2 || z) {
            evL();
        }
    }

    void evL() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.pwT = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.pwU = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.pwn == p.b.pxB) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.pwn.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.pxA != null ? this.pxA.x : 0.5f, this.pxA != null ? this.pxA.y : 0.5f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void f(Matrix matrix) {
        g(matrix);
        evK();
        if (this.mDrawMatrix != null) {
            matrix.preConcat(this.mDrawMatrix);
        }
    }
}
