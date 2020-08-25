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
    p.b nnX;
    int noC;
    int noD;
    Object npi;
    PointF npj;

    public o(Drawable drawable, p.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.npj = null;
        this.noC = 0;
        this.noD = 0;
        this.mTempMatrix = new Matrix();
        this.nnX = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable setCurrent(Drawable drawable) {
        Drawable current = super.setCurrent(drawable);
        configureBounds();
        return current;
    }

    public p.b dQt() {
        return this.nnX;
    }

    public void a(p.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.nnX, bVar)) {
            this.nnX = bVar;
            this.npi = null;
            configureBounds();
            invalidateSelf();
        }
    }

    public void d(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.npj, pointF)) {
            if (this.npj == null) {
                this.npj = new PointF();
            }
            this.npj.set(pointF);
            configureBounds();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        dQp();
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

    private void dQp() {
        boolean z;
        boolean z2 = false;
        if (this.nnX instanceof p.l) {
            Object state = ((p.l) this.nnX).getState();
            z = state == null || !state.equals(this.npi);
            this.npi = state;
        } else {
            z = false;
        }
        if (this.noC != getCurrent().getIntrinsicWidth() || this.noD != getCurrent().getIntrinsicHeight()) {
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
        this.noC = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.noD = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.nnX == p.b.npk) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.nnX.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.npj != null ? this.npj.x : 0.5f, this.npj != null ? this.npj.y : 0.5f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
        dQp();
        if (this.mDrawMatrix != null) {
            matrix.preConcat(this.mDrawMatrix);
        }
    }
}
