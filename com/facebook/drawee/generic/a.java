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
    private RoundingParams icE;
    private final d icF;
    private final f icG;
    private final Resources mResources;
    private final Drawable icD = new ColorDrawable(0);
    private final g icH = new g(this.icD);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.icE = bVar.bTg();
        int size = (bVar.bTe() != null ? bVar.bTe().size() : 1) + (bVar.bTf() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.bSS(), bVar.bST());
        drawableArr[2] = a(this.icH, bVar.bTa(), bVar.bTc(), bVar.bTb(), bVar.bTd());
        drawableArr[3] = a(bVar.bSY(), bVar.bSZ());
        drawableArr[4] = a(bVar.bSU(), bVar.bSV());
        drawableArr[5] = a(bVar.bSW(), bVar.bSX());
        if (size > 0) {
            if (bVar.bTe() != null) {
                for (Drawable drawable : bVar.bTe()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.bTf() != null) {
                drawableArr[i + 6] = a(bVar.bTf(), null);
            }
        }
        this.icG = new f(drawableArr);
        this.icG.xF(bVar.bSQ());
        this.icF = new d(e.a(this.icG, this.icE));
        this.icF.mutate();
        bSO();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable n.b bVar, @Nullable PointF pointF, @Nullable Matrix matrix, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(e.a(drawable, bVar, pointF), matrix);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable n.b bVar) {
        return e.b(e.a(drawable, this.icE, this.mResources), bVar);
    }

    private void bSN() {
        this.icH.h(this.icD);
    }

    private void bSO() {
        if (this.icG != null) {
            this.icG.bSC();
            this.icG.bSE();
            bSP();
            xG(1);
            this.icG.bSF();
            this.icG.bSD();
        }
    }

    private void bSP() {
        xH(1);
        xH(2);
        xH(3);
        xH(4);
        xH(5);
    }

    private void xG(int i) {
        if (i >= 0) {
            this.icG.xG(i);
        }
    }

    private void xH(int i) {
        if (i >= 0) {
            this.icG.xH(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.icG.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                xH(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                xG(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.icF;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        bSN();
        bSO();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.icE, this.mResources);
        a.mutate();
        this.icH.h(a);
        this.icG.bSC();
        bSP();
        xG(2);
        setProgress(f);
        if (z) {
            this.icG.bSF();
        }
        this.icG.bSD();
    }

    @Override // com.facebook.drawee.d.c
    public void d(float f, boolean z) {
        if (this.icG.getDrawable(3) != null) {
            this.icG.bSC();
            setProgress(f);
            if (z) {
                this.icG.bSF();
            }
            this.icG.bSD();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void y(Throwable th) {
        this.icG.bSC();
        bSP();
        if (this.icG.getDrawable(5) != null) {
            xG(5);
        } else {
            xG(1);
        }
        this.icG.bSD();
    }

    @Override // com.facebook.drawee.d.c
    public void z(Throwable th) {
        this.icG.bSC();
        bSP();
        if (this.icG.getDrawable(4) != null) {
            xG(4);
        } else {
            xG(1);
        }
        this.icG.bSD();
    }

    @Override // com.facebook.drawee.d.c
    public void g(@Nullable Drawable drawable) {
        this.icF.g(drawable);
    }

    private com.facebook.drawee.drawable.c xI(int i) {
        com.facebook.drawee.drawable.c xC = this.icG.xC(i);
        if (xC.getDrawable() instanceof h) {
            xC = (h) xC.getDrawable();
        }
        if (xC.getDrawable() instanceof m) {
            return (m) xC.getDrawable();
        }
        return xC;
    }

    private m xJ(int i) {
        com.facebook.drawee.drawable.c xI = xI(i);
        return xI instanceof m ? (m) xI : e.a(xI, n.b.icu);
    }

    public void b(n.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        xJ(2).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.icE = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.icF, this.icE);
        for (int i = 0; i < this.icG.getNumberOfLayers(); i++) {
            e.a(xI(i), this.icE, this.mResources);
        }
    }
}
