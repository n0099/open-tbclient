package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.p;
/* loaded from: classes11.dex */
public class o extends g {
    int lHU;
    int lHV;
    p.b lHs;
    Object lIA;
    PointF lIB;
    Matrix mDrawMatrix;
    private Matrix mTempMatrix;

    public o(Drawable drawable, p.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.lIB = null;
        this.lHU = 0;
        this.lHV = 0;
        this.mTempMatrix = new Matrix();
        this.lHs = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable setCurrent(Drawable drawable) {
        Drawable current = super.setCurrent(drawable);
        configureBounds();
        return current;
    }

    public p.b dkl() {
        return this.lHs;
    }

    public void a(p.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.lHs, bVar)) {
            this.lHs = bVar;
            this.lIA = null;
            configureBounds();
            invalidateSelf();
        }
    }

    public void d(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.lIB, pointF)) {
            if (this.lIB == null) {
                this.lIB = new PointF();
            }
            this.lIB.set(pointF);
            configureBounds();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        dkh();
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

    private void dkh() {
        boolean z;
        boolean z2 = false;
        if (this.lHs instanceof p.l) {
            Object state = ((p.l) this.lHs).getState();
            z = state == null || !state.equals(this.lIA);
            this.lIA = state;
        } else {
            z = false;
        }
        if (this.lHU != getCurrent().getIntrinsicWidth() || this.lHV != getCurrent().getIntrinsicHeight()) {
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
        this.lHU = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.lHV = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.lHs == p.b.lIC) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.lHs.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.lIB != null ? this.lIB.x : 0.5f, this.lIB != null ? this.lIB.y : 0.5f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
        dkh();
        if (this.mDrawMatrix != null) {
            matrix.preConcat(this.mDrawMatrix);
        }
    }
}
