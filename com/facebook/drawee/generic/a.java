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
    private RoundingParams kes;
    private final d ket;
    private final f keu;
    private final Resources mResources;
    private final Drawable ker = new ColorDrawable(0);
    private final g kev = new g(this.ker);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.kes = bVar.cHk();
        int size = (bVar.cHi() != null ? bVar.cHi().size() : 1) + (bVar.cHj() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.cGW(), bVar.cGX());
        drawableArr[2] = a(this.kev, bVar.cHe(), bVar.cHg(), bVar.cHf(), bVar.cHh());
        drawableArr[3] = a(bVar.cHc(), bVar.cHd());
        drawableArr[4] = a(bVar.cGY(), bVar.cGZ());
        drawableArr[5] = a(bVar.cHa(), bVar.cHb());
        if (size > 0) {
            if (bVar.cHi() != null) {
                for (Drawable drawable : bVar.cHi()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.cHj() != null) {
                drawableArr[i + 6] = a(bVar.cHj(), null);
            }
        }
        this.keu = new f(drawableArr);
        this.keu.DH(bVar.cGU());
        this.ket = new d(e.a(this.keu, this.kes));
        this.ket.mutate();
        cGS();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable n.b bVar, @Nullable PointF pointF, @Nullable Matrix matrix, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(e.a(drawable, bVar, pointF), matrix);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable n.b bVar) {
        return e.b(e.a(drawable, this.kes, this.mResources), bVar);
    }

    private void cGR() {
        this.kev.h(this.ker);
    }

    private void cGS() {
        if (this.keu != null) {
            this.keu.cGF();
            this.keu.cGH();
            cGT();
            DI(1);
            this.keu.cGI();
            this.keu.cGG();
        }
    }

    private void cGT() {
        DJ(1);
        DJ(2);
        DJ(3);
        DJ(4);
        DJ(5);
    }

    private void DI(int i) {
        if (i >= 0) {
            this.keu.DI(i);
        }
    }

    private void DJ(int i) {
        if (i >= 0) {
            this.keu.DJ(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.keu.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                DJ(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                DI(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.ket;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        cGR();
        cGS();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.kes, this.mResources);
        a.mutate();
        this.kev.h(a);
        this.keu.cGF();
        cGT();
        DI(2);
        setProgress(f);
        if (z) {
            this.keu.cGI();
        }
        this.keu.cGG();
    }

    @Override // com.facebook.drawee.d.c
    public void d(float f, boolean z) {
        if (this.keu.getDrawable(3) != null) {
            this.keu.cGF();
            setProgress(f);
            if (z) {
                this.keu.cGI();
            }
            this.keu.cGG();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void y(Throwable th) {
        this.keu.cGF();
        cGT();
        if (this.keu.getDrawable(5) != null) {
            DI(5);
        } else {
            DI(1);
        }
        this.keu.cGG();
    }

    @Override // com.facebook.drawee.d.c
    public void z(Throwable th) {
        this.keu.cGF();
        cGT();
        if (this.keu.getDrawable(4) != null) {
            DI(4);
        } else {
            DI(1);
        }
        this.keu.cGG();
    }

    @Override // com.facebook.drawee.d.c
    public void g(@Nullable Drawable drawable) {
        this.ket.g(drawable);
    }

    private com.facebook.drawee.drawable.c DK(int i) {
        com.facebook.drawee.drawable.c DE = this.keu.DE(i);
        if (DE.getDrawable() instanceof h) {
            DE = (h) DE.getDrawable();
        }
        if (DE.getDrawable() instanceof m) {
            return (m) DE.getDrawable();
        }
        return DE;
    }

    private m DL(int i) {
        com.facebook.drawee.drawable.c DK = DK(i);
        return DK instanceof m ? (m) DK : e.a(DK, n.b.kei);
    }

    public void b(n.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        DL(2).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.kes = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.ket, this.kes);
        for (int i = 0; i < this.keu.cGC(); i++) {
            e.a(DK(i), this.kes, this.mResources);
        }
    }
}
