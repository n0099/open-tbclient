package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.p;
/* loaded from: classes13.dex */
public class o extends g {
    p.b lUP;
    Object lVY;
    PointF lVZ;
    int lVs;
    int lVt;
    Matrix mDrawMatrix;
    private Matrix mTempMatrix;

    public o(Drawable drawable, p.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.lVZ = null;
        this.lVs = 0;
        this.lVt = 0;
        this.mTempMatrix = new Matrix();
        this.lUP = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable setCurrent(Drawable drawable) {
        Drawable current = super.setCurrent(drawable);
        configureBounds();
        return current;
    }

    public p.b doV() {
        return this.lUP;
    }

    public void a(p.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.lUP, bVar)) {
            this.lUP = bVar;
            this.lVY = null;
            configureBounds();
            invalidateSelf();
        }
    }

    public void d(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.lVZ, pointF)) {
            if (this.lVZ == null) {
                this.lVZ = new PointF();
            }
            this.lVZ.set(pointF);
            configureBounds();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        doR();
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

    private void doR() {
        boolean z;
        boolean z2 = false;
        if (this.lUP instanceof p.l) {
            Object state = ((p.l) this.lUP).getState();
            z = state == null || !state.equals(this.lVY);
            this.lVY = state;
        } else {
            z = false;
        }
        if (this.lVs != getCurrent().getIntrinsicWidth() || this.lVt != getCurrent().getIntrinsicHeight()) {
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
        this.lVs = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.lVt = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.lUP == p.b.lWa) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.lUP.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.lVZ != null ? this.lVZ.x : 0.5f, this.lVZ != null ? this.lVZ.y : 0.5f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
        doR();
        if (this.mDrawMatrix != null) {
            matrix.preConcat(this.mDrawMatrix);
        }
    }
}
