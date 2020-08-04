package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.p;
/* loaded from: classes9.dex */
public class o extends g {
    Matrix mDrawMatrix;
    private Matrix mTempMatrix;
    int mUM;
    int mUN;
    p.b mUi;
    Object mVs;
    PointF mVt;

    public o(Drawable drawable, p.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.mVt = null;
        this.mUM = 0;
        this.mUN = 0;
        this.mTempMatrix = new Matrix();
        this.mUi = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable setCurrent(Drawable drawable) {
        Drawable current = super.setCurrent(drawable);
        configureBounds();
        return current;
    }

    public p.b dEt() {
        return this.mUi;
    }

    public void a(p.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.mUi, bVar)) {
            this.mUi = bVar;
            this.mVs = null;
            configureBounds();
            invalidateSelf();
        }
    }

    public void d(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.mVt, pointF)) {
            if (this.mVt == null) {
                this.mVt = new PointF();
            }
            this.mVt.set(pointF);
            configureBounds();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        dEp();
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

    private void dEp() {
        boolean z;
        boolean z2 = false;
        if (this.mUi instanceof p.l) {
            Object state = ((p.l) this.mUi).getState();
            z = state == null || !state.equals(this.mVs);
            this.mVs = state;
        } else {
            z = false;
        }
        if (this.mUM != getCurrent().getIntrinsicWidth() || this.mUN != getCurrent().getIntrinsicHeight()) {
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
        this.mUM = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.mUN = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.mUi == p.b.mVu) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.mUi.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.mVt != null ? this.mVt.x : 0.5f, this.mVt != null ? this.mVt.y : 0.5f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
        dEp();
        if (this.mDrawMatrix != null) {
            matrix.preConcat(this.mDrawMatrix);
        }
    }
}
