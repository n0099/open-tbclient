package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.p;
/* loaded from: classes3.dex */
public class o extends g {
    Matrix mDrawMatrix;
    private Matrix mTempMatrix;
    p.b prT;
    int psA;
    int psz;
    Object ptf;
    PointF ptg;

    public o(Drawable drawable, p.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.ptg = null;
        this.psz = 0;
        this.psA = 0;
        this.mTempMatrix = new Matrix();
        this.prT = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable x(Drawable drawable) {
        Drawable x = super.x(drawable);
        erZ();
        return x;
    }

    public p.b esd() {
        return this.prT;
    }

    public void a(p.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.prT, bVar)) {
            this.prT = bVar;
            this.ptf = null;
            erZ();
            invalidateSelf();
        }
    }

    public void d(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.ptg, pointF)) {
            if (this.ptg == null) {
                this.ptg = new PointF();
            }
            this.ptg.set(pointF);
            erZ();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        erY();
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
        erZ();
    }

    private void erY() {
        boolean z;
        boolean z2 = false;
        if (this.prT instanceof p.l) {
            Object state = ((p.l) this.prT).getState();
            z = state == null || !state.equals(this.ptf);
            this.ptf = state;
        } else {
            z = false;
        }
        if (this.psz != getCurrent().getIntrinsicWidth() || this.psA != getCurrent().getIntrinsicHeight()) {
            z2 = true;
        }
        if (z2 || z) {
            erZ();
        }
    }

    void erZ() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.psz = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.psA = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.prT == p.b.pth) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.prT.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.ptg != null ? this.ptg.x : 0.5f, this.ptg != null ? this.ptg.y : 0.5f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void f(Matrix matrix) {
        g(matrix);
        erY();
        if (this.mDrawMatrix != null) {
            matrix.preConcat(this.mDrawMatrix);
        }
    }
}
