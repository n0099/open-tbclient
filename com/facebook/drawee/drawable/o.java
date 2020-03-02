package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.p;
/* loaded from: classes13.dex */
public class o extends g {
    p.b lLE;
    Object lML;
    PointF lMM;
    int lMg;
    int lMh;
    Matrix mDrawMatrix;
    private Matrix mTempMatrix;

    public o(Drawable drawable, p.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.lMM = null;
        this.lMg = 0;
        this.lMh = 0;
        this.mTempMatrix = new Matrix();
        this.lLE = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable setCurrent(Drawable drawable) {
        Drawable current = super.setCurrent(drawable);
        configureBounds();
        return current;
    }

    public p.b dmD() {
        return this.lLE;
    }

    public void a(p.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.lLE, bVar)) {
            this.lLE = bVar;
            this.lML = null;
            configureBounds();
            invalidateSelf();
        }
    }

    public void d(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.lMM, pointF)) {
            if (this.lMM == null) {
                this.lMM = new PointF();
            }
            this.lMM.set(pointF);
            configureBounds();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        dmz();
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

    private void dmz() {
        boolean z;
        boolean z2 = false;
        if (this.lLE instanceof p.l) {
            Object state = ((p.l) this.lLE).getState();
            z = state == null || !state.equals(this.lML);
            this.lML = state;
        } else {
            z = false;
        }
        if (this.lMg != getCurrent().getIntrinsicWidth() || this.lMh != getCurrent().getIntrinsicHeight()) {
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
        this.lMg = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.lMh = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.lLE == p.b.lMN) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.lLE.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.lMM != null ? this.lMM.x : 0.5f, this.lMM != null ? this.lMM.y : 0.5f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
        dmz();
        if (this.mDrawMatrix != null) {
            matrix.preConcat(this.mDrawMatrix);
        }
    }
}
