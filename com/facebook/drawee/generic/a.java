package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.f;
import com.facebook.drawee.drawable.g;
import com.facebook.drawee.drawable.h;
import com.facebook.drawee.drawable.m;
import com.facebook.drawee.drawable.n;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements com.facebook.drawee.d.c {
    @Nullable
    private RoundingParams jDq;
    private final d jDr;
    private final f jDs;
    private final Resources mResources;
    private final Drawable jDp = new ColorDrawable(0);
    private final g jDt = new g(this.jDp);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.jDq = bVar.cvP();
        int size = (bVar.cvN() != null ? bVar.cvN().size() : 1) + (bVar.cvO() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.cvB(), bVar.cvC());
        drawableArr[2] = a(this.jDt, bVar.cvJ(), bVar.cvL(), bVar.cvK(), bVar.cvM());
        drawableArr[3] = a(bVar.cvH(), bVar.cvI());
        drawableArr[4] = a(bVar.cvD(), bVar.cvE());
        drawableArr[5] = a(bVar.cvF(), bVar.cvG());
        if (size > 0) {
            if (bVar.cvN() != null) {
                for (Drawable drawable : bVar.cvN()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.cvO() != null) {
                drawableArr[i + 6] = a(bVar.cvO(), null);
            }
        }
        this.jDs = new f(drawableArr);
        this.jDs.BU(bVar.cvz());
        this.jDr = new d(e.a(this.jDs, this.jDq));
        this.jDr.mutate();
        cvx();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable n.b bVar, @Nullable PointF pointF, @Nullable Matrix matrix, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(e.a(drawable, bVar, pointF), matrix);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable n.b bVar) {
        return e.b(e.a(drawable, this.jDq, this.mResources), bVar);
    }

    private void cvw() {
        this.jDt.i(this.jDp);
    }

    private void cvx() {
        if (this.jDs != null) {
            this.jDs.cvl();
            this.jDs.cvn();
            cvy();
            BV(1);
            this.jDs.cvo();
            this.jDs.cvm();
        }
    }

    private void cvy() {
        BW(1);
        BW(2);
        BW(3);
        BW(4);
        BW(5);
    }

    private void BV(int i) {
        if (i >= 0) {
            this.jDs.BV(i);
        }
    }

    private void BW(int i) {
        if (i >= 0) {
            this.jDs.BW(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.jDs.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                BW(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                BV(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.jDr;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        cvw();
        cvx();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.jDq, this.mResources);
        a.mutate();
        this.jDt.i(a);
        this.jDs.cvl();
        cvy();
        BV(2);
        setProgress(f);
        if (z) {
            this.jDs.cvo();
        }
        this.jDs.cvm();
    }

    @Override // com.facebook.drawee.d.c
    public void d(float f, boolean z) {
        if (this.jDs.getDrawable(3) != null) {
            this.jDs.cvl();
            setProgress(f);
            if (z) {
                this.jDs.cvo();
            }
            this.jDs.cvm();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void z(Throwable th) {
        this.jDs.cvl();
        cvy();
        if (this.jDs.getDrawable(5) != null) {
            BV(5);
        } else {
            BV(1);
        }
        this.jDs.cvm();
    }

    @Override // com.facebook.drawee.d.c
    public void A(Throwable th) {
        this.jDs.cvl();
        cvy();
        if (this.jDs.getDrawable(4) != null) {
            BV(4);
        } else {
            BV(1);
        }
        this.jDs.cvm();
    }

    @Override // com.facebook.drawee.d.c
    public void h(@Nullable Drawable drawable) {
        this.jDr.h(drawable);
    }

    private com.facebook.drawee.drawable.c BX(int i) {
        com.facebook.drawee.drawable.c BR = this.jDs.BR(i);
        if (BR.getDrawable() instanceof h) {
            BR = (h) BR.getDrawable();
        }
        if (BR.getDrawable() instanceof m) {
            return (m) BR.getDrawable();
        }
        return BR;
    }

    private m BY(int i) {
        com.facebook.drawee.drawable.c BX = BX(i);
        return BX instanceof m ? (m) BX : e.a(BX, n.b.jDg);
    }

    public void b(n.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        BY(2).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.jDq = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.jDr, this.jDq);
        for (int i = 0; i < this.jDs.getNumberOfLayers(); i++) {
            e.a(BX(i), this.jDq, this.mResources);
        }
    }
}
