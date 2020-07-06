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
    p.b mLY;
    int mMB;
    int mMC;
    Object mNh;
    PointF mNi;
    private Matrix mTempMatrix;

    public o(Drawable drawable, p.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.mNi = null;
        this.mMB = 0;
        this.mMC = 0;
        this.mTempMatrix = new Matrix();
        this.mLY = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable setCurrent(Drawable drawable) {
        Drawable current = super.setCurrent(drawable);
        configureBounds();
        return current;
    }

    public p.b dBg() {
        return this.mLY;
    }

    public void a(p.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.mLY, bVar)) {
            this.mLY = bVar;
            this.mNh = null;
            configureBounds();
            invalidateSelf();
        }
    }

    public void d(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.mNi, pointF)) {
            if (this.mNi == null) {
                this.mNi = new PointF();
            }
            this.mNi.set(pointF);
            configureBounds();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        dBc();
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

    private void dBc() {
        boolean z;
        boolean z2 = false;
        if (this.mLY instanceof p.l) {
            Object state = ((p.l) this.mLY).getState();
            z = state == null || !state.equals(this.mNh);
            this.mNh = state;
        } else {
            z = false;
        }
        if (this.mMB != getCurrent().getIntrinsicWidth() || this.mMC != getCurrent().getIntrinsicHeight()) {
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
        this.mMB = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.mMC = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.mLY == p.b.mNj) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.mLY.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.mNi != null ? this.mNi.x : 0.5f, this.mNi != null ? this.mNi.y : 0.5f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
        dBc();
        if (this.mDrawMatrix != null) {
            matrix.preConcat(this.mDrawMatrix);
        }
    }
}
