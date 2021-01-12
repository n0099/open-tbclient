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
    p.b prS;
    int psy;
    int psz;
    Object pte;
    PointF ptf;

    public o(Drawable drawable, p.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.ptf = null;
        this.psy = 0;
        this.psz = 0;
        this.mTempMatrix = new Matrix();
        this.prS = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable x(Drawable drawable) {
        Drawable x = super.x(drawable);
        erZ();
        return x;
    }

    public p.b esd() {
        return this.prS;
    }

    public void a(p.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.prS, bVar)) {
            this.prS = bVar;
            this.pte = null;
            erZ();
            invalidateSelf();
        }
    }

    public void d(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.ptf, pointF)) {
            if (this.ptf == null) {
                this.ptf = new PointF();
            }
            this.ptf.set(pointF);
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
        if (this.prS instanceof p.l) {
            Object state = ((p.l) this.prS).getState();
            z = state == null || !state.equals(this.pte);
            this.pte = state;
        } else {
            z = false;
        }
        if (this.psy != getCurrent().getIntrinsicWidth() || this.psz != getCurrent().getIntrinsicHeight()) {
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
        this.psy = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.psz = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.prS == p.b.ptg) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.prS.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.ptf != null ? this.ptf.x : 0.5f, this.ptf != null ? this.ptf.y : 0.5f);
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
