package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.p;
/* loaded from: classes12.dex */
public class o extends g {
    p.b lKV;
    int lLx;
    int lLy;
    Object lMc;
    PointF lMd;
    Matrix mDrawMatrix;
    private Matrix mTempMatrix;

    public o(Drawable drawable, p.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.lMd = null;
        this.lLx = 0;
        this.lLy = 0;
        this.mTempMatrix = new Matrix();
        this.lKV = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable setCurrent(Drawable drawable) {
        Drawable current = super.setCurrent(drawable);
        configureBounds();
        return current;
    }

    public p.b dlo() {
        return this.lKV;
    }

    public void a(p.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.lKV, bVar)) {
            this.lKV = bVar;
            this.lMc = null;
            configureBounds();
            invalidateSelf();
        }
    }

    public void d(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.lMd, pointF)) {
            if (this.lMd == null) {
                this.lMd = new PointF();
            }
            this.lMd.set(pointF);
            configureBounds();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        dlk();
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

    private void dlk() {
        boolean z;
        boolean z2 = false;
        if (this.lKV instanceof p.l) {
            Object state = ((p.l) this.lKV).getState();
            z = state == null || !state.equals(this.lMc);
            this.lMc = state;
        } else {
            z = false;
        }
        if (this.lLx != getCurrent().getIntrinsicWidth() || this.lLy != getCurrent().getIntrinsicHeight()) {
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
        this.lLx = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.lLy = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.lKV == p.b.lMe) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.lKV.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.lMd != null ? this.lMd.x : 0.5f, this.lMd != null ? this.lMd.y : 0.5f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
        dlk();
        if (this.mDrawMatrix != null) {
            matrix.preConcat(this.mDrawMatrix);
        }
    }
}
