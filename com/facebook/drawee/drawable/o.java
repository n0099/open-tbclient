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
    p.b pEH;
    Object pFT;
    PointF pFU;
    int pFn;
    int pFo;

    public o(Drawable drawable, p.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.pFU = null;
        this.pFn = 0;
        this.pFo = 0;
        this.mTempMatrix = new Matrix();
        this.pEH = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable x(Drawable drawable) {
        Drawable x = super.x(drawable);
        euI();
        return x;
    }

    public p.b euM() {
        return this.pEH;
    }

    public void a(p.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.pEH, bVar)) {
            this.pEH = bVar;
            this.pFT = null;
            euI();
            invalidateSelf();
        }
    }

    public void d(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.pFU, pointF)) {
            if (this.pFU == null) {
                this.pFU = new PointF();
            }
            this.pFU.set(pointF);
            euI();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        euH();
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
        euI();
    }

    private void euH() {
        boolean z;
        boolean z2 = false;
        if (this.pEH instanceof p.l) {
            Object state = ((p.l) this.pEH).getState();
            z = state == null || !state.equals(this.pFT);
            this.pFT = state;
        } else {
            z = false;
        }
        if (this.pFn != getCurrent().getIntrinsicWidth() || this.pFo != getCurrent().getIntrinsicHeight()) {
            z2 = true;
        }
        if (z2 || z) {
            euI();
        }
    }

    void euI() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.pFn = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.pFo = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.pEH == p.b.pFV) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.pEH.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.pFU != null ? this.pFU.x : 0.5f, this.pFU != null ? this.pFU.y : 0.5f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void f(Matrix matrix) {
        g(matrix);
        euH();
        if (this.mDrawMatrix != null) {
            matrix.preConcat(this.mDrawMatrix);
        }
    }
}
