package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.p;
/* loaded from: classes12.dex */
public class o extends g {
    p.b lKQ;
    Object lLX;
    PointF lLY;
    int lLs;
    int lLt;
    Matrix mDrawMatrix;
    private Matrix mTempMatrix;

    public o(Drawable drawable, p.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.lLY = null;
        this.lLs = 0;
        this.lLt = 0;
        this.mTempMatrix = new Matrix();
        this.lKQ = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable setCurrent(Drawable drawable) {
        Drawable current = super.setCurrent(drawable);
        configureBounds();
        return current;
    }

    public p.b dlm() {
        return this.lKQ;
    }

    public void a(p.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.lKQ, bVar)) {
            this.lKQ = bVar;
            this.lLX = null;
            configureBounds();
            invalidateSelf();
        }
    }

    public void d(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.lLY, pointF)) {
            if (this.lLY == null) {
                this.lLY = new PointF();
            }
            this.lLY.set(pointF);
            configureBounds();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        dli();
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

    private void dli() {
        boolean z;
        boolean z2 = false;
        if (this.lKQ instanceof p.l) {
            Object state = ((p.l) this.lKQ).getState();
            z = state == null || !state.equals(this.lLX);
            this.lLX = state;
        } else {
            z = false;
        }
        if (this.lLs != getCurrent().getIntrinsicWidth() || this.lLt != getCurrent().getIntrinsicHeight()) {
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
        this.lLs = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.lLt = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.lKQ == p.b.lLZ) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.lKQ.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.lLY != null ? this.lLY.x : 0.5f, this.lLY != null ? this.lLY.y : 0.5f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
        dli();
        if (this.mDrawMatrix != null) {
            matrix.preConcat(this.mDrawMatrix);
        }
    }
}
