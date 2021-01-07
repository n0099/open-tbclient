package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.p;
/* loaded from: classes4.dex */
public class o extends g {
    Matrix mDrawMatrix;
    private Matrix mTempMatrix;
    p.b pwu;
    Object pxG;
    PointF pxH;
    int pxa;
    int pxb;

    public o(Drawable drawable, p.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.pxH = null;
        this.pxa = 0;
        this.pxb = 0;
        this.mTempMatrix = new Matrix();
        this.pwu = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable x(Drawable drawable) {
        Drawable x = super.x(drawable);
        evS();
        return x;
    }

    public p.b evW() {
        return this.pwu;
    }

    public void a(p.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.pwu, bVar)) {
            this.pwu = bVar;
            this.pxG = null;
            evS();
            invalidateSelf();
        }
    }

    public void d(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.pxH, pointF)) {
            if (this.pxH == null) {
                this.pxH = new PointF();
            }
            this.pxH.set(pointF);
            evS();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        evR();
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
        evS();
    }

    private void evR() {
        boolean z;
        boolean z2 = false;
        if (this.pwu instanceof p.l) {
            Object state = ((p.l) this.pwu).getState();
            z = state == null || !state.equals(this.pxG);
            this.pxG = state;
        } else {
            z = false;
        }
        if (this.pxa != getCurrent().getIntrinsicWidth() || this.pxb != getCurrent().getIntrinsicHeight()) {
            z2 = true;
        }
        if (z2 || z) {
            evS();
        }
    }

    void evS() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.pxa = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.pxb = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.pwu == p.b.pxI) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.pwu.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.pxH != null ? this.pxH.x : 0.5f, this.pxH != null ? this.pxH.y : 0.5f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void f(Matrix matrix) {
        g(matrix);
        evR();
        if (this.mDrawMatrix != null) {
            matrix.preConcat(this.mDrawMatrix);
        }
    }
}
