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
    private RoundingParams iaU;
    private final d iaV;
    private final f iaW;
    private final Resources mResources;
    private final Drawable iaT = new ColorDrawable(0);
    private final g iaX = new g(this.iaT);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.iaU = bVar.bTL();
        int size = (bVar.bTJ() != null ? bVar.bTJ().size() : 1) + (bVar.bTK() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.bTx(), bVar.bTy());
        drawableArr[2] = a(this.iaX, bVar.bTF(), bVar.bTH(), bVar.bTG(), bVar.bTI());
        drawableArr[3] = a(bVar.bTD(), bVar.bTE());
        drawableArr[4] = a(bVar.bTz(), bVar.bTA());
        drawableArr[5] = a(bVar.bTB(), bVar.bTC());
        if (size > 0) {
            if (bVar.bTJ() != null) {
                for (Drawable drawable : bVar.bTJ()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.bTK() != null) {
                drawableArr[i + 6] = a(bVar.bTK(), null);
            }
        }
        this.iaW = new f(drawableArr);
        this.iaW.xm(bVar.bTv());
        this.iaV = new d(e.a(this.iaW, this.iaU));
        this.iaV.mutate();
        bTt();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable n.b bVar, @Nullable PointF pointF, @Nullable Matrix matrix, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(e.a(drawable, bVar, pointF), matrix);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable n.b bVar) {
        return e.b(e.a(drawable, this.iaU, this.mResources), bVar);
    }

    private void bTs() {
        this.iaX.h(this.iaT);
    }

    private void bTt() {
        if (this.iaW != null) {
            this.iaW.bTh();
            this.iaW.bTj();
            bTu();
            xn(1);
            this.iaW.bTk();
            this.iaW.bTi();
        }
    }

    private void bTu() {
        xo(1);
        xo(2);
        xo(3);
        xo(4);
        xo(5);
    }

    private void xn(int i) {
        if (i >= 0) {
            this.iaW.xn(i);
        }
    }

    private void xo(int i) {
        if (i >= 0) {
            this.iaW.xo(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.iaW.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                xo(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                xn(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.iaV;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        bTs();
        bTt();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.iaU, this.mResources);
        a.mutate();
        this.iaX.h(a);
        this.iaW.bTh();
        bTu();
        xn(2);
        setProgress(f);
        if (z) {
            this.iaW.bTk();
        }
        this.iaW.bTi();
    }

    @Override // com.facebook.drawee.d.c
    public void d(float f, boolean z) {
        if (this.iaW.getDrawable(3) != null) {
            this.iaW.bTh();
            setProgress(f);
            if (z) {
                this.iaW.bTk();
            }
            this.iaW.bTi();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void y(Throwable th) {
        this.iaW.bTh();
        bTu();
        if (this.iaW.getDrawable(5) != null) {
            xn(5);
        } else {
            xn(1);
        }
        this.iaW.bTi();
    }

    @Override // com.facebook.drawee.d.c
    public void z(Throwable th) {
        this.iaW.bTh();
        bTu();
        if (this.iaW.getDrawable(4) != null) {
            xn(4);
        } else {
            xn(1);
        }
        this.iaW.bTi();
    }

    @Override // com.facebook.drawee.d.c
    public void g(@Nullable Drawable drawable) {
        this.iaV.g(drawable);
    }

    private com.facebook.drawee.drawable.c xp(int i) {
        com.facebook.drawee.drawable.c xj = this.iaW.xj(i);
        if (xj.getDrawable() instanceof h) {
            xj = (h) xj.getDrawable();
        }
        if (xj.getDrawable() instanceof m) {
            return (m) xj.getDrawable();
        }
        return xj;
    }

    private m xq(int i) {
        com.facebook.drawee.drawable.c xp = xp(i);
        return xp instanceof m ? (m) xp : e.a(xp, n.b.iaK);
    }

    public void b(n.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        xq(2).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.iaU = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.iaV, this.iaU);
        for (int i = 0; i < this.iaW.getNumberOfLayers(); i++) {
            e.a(xp(i), this.iaU, this.mResources);
        }
    }
}
