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
    p.b mLV;
    int mMy;
    int mMz;
    Object mNe;
    PointF mNf;
    private Matrix mTempMatrix;

    public o(Drawable drawable, p.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.mNf = null;
        this.mMy = 0;
        this.mMz = 0;
        this.mTempMatrix = new Matrix();
        this.mLV = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable setCurrent(Drawable drawable) {
        Drawable current = super.setCurrent(drawable);
        configureBounds();
        return current;
    }

    public p.b dBc() {
        return this.mLV;
    }

    public void a(p.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.mLV, bVar)) {
            this.mLV = bVar;
            this.mNe = null;
            configureBounds();
            invalidateSelf();
        }
    }

    public void d(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.mNf, pointF)) {
            if (this.mNf == null) {
                this.mNf = new PointF();
            }
            this.mNf.set(pointF);
            configureBounds();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        dAY();
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

    private void dAY() {
        boolean z;
        boolean z2 = false;
        if (this.mLV instanceof p.l) {
            Object state = ((p.l) this.mLV).getState();
            z = state == null || !state.equals(this.mNe);
            this.mNe = state;
        } else {
            z = false;
        }
        if (this.mMy != getCurrent().getIntrinsicWidth() || this.mMz != getCurrent().getIntrinsicHeight()) {
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
        this.mMy = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.mMz = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.mLV == p.b.mNg) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.mLV.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.mNf != null ? this.mNf.x : 0.5f, this.mNf != null ? this.mNf.y : 0.5f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
        dAY();
        if (this.mDrawMatrix != null) {
            matrix.preConcat(this.mDrawMatrix);
        }
    }
}
