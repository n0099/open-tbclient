package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.f;
import com.facebook.drawee.drawable.g;
import com.facebook.drawee.drawable.h;
import com.facebook.drawee.drawable.o;
import com.facebook.drawee.drawable.p;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class a implements com.facebook.drawee.d.c {
    private final Resources mResources;
    @Nullable
    private RoundingParams mVD;
    private final d mVE;
    private final f mVF;
    private final Drawable mVC = new ColorDrawable(0);
    private final g mVG = new g(this.mVC);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.mVD = bVar.dEw();
        int size = (bVar.dEL() != null ? bVar.dEL().size() : 1) + (bVar.dEM() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.dEA(), bVar.dEB());
        drawableArr[2] = a(this.mVG, bVar.dEI(), bVar.dEJ(), bVar.dEK());
        drawableArr[3] = a(bVar.dEG(), bVar.dEH());
        drawableArr[4] = a(bVar.dEC(), bVar.dED());
        drawableArr[5] = a(bVar.dEE(), bVar.dEF());
        if (size > 0) {
            if (bVar.dEL() != null) {
                for (Drawable drawable : bVar.dEL()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.dEM() != null) {
                drawableArr[i + 6] = a(bVar.dEM(), null);
            }
        }
        this.mVF = new f(drawableArr);
        this.mVF.ID(bVar.dEx());
        this.mVE = new d(e.a(this.mVF, this.mVD));
        this.mVE.xh(bVar.dEy());
        this.mVE.mutate();
        dEu();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.f(e.a(drawable, this.mVD, this.mResources), bVar);
    }

    private void dEt() {
        this.mVG.setDrawable(this.mVC);
    }

    private void dEu() {
        if (this.mVF != null) {
            this.mVF.dEj();
            this.mVF.dEl();
            dEv();
            IE(1);
            this.mVF.dEm();
            this.mVF.dEk();
        }
    }

    private void dEv() {
        IF(1);
        IF(2);
        IF(3);
        IF(4);
        IF(5);
    }

    private void IE(int i) {
        if (i >= 0) {
            this.mVF.IE(i);
        }
    }

    private void IF(int i) {
        if (i >= 0) {
            this.mVF.IF(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.mVF.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                IF(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                IE(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.mVE;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        dEt();
        dEu();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.mVD, this.mResources);
        a.mutate();
        this.mVG.setDrawable(a);
        this.mVF.dEj();
        dEv();
        IE(2);
        setProgress(f);
        if (z) {
            this.mVF.dEm();
        }
        this.mVF.dEk();
    }

    @Override // com.facebook.drawee.d.c
    public void c(float f, boolean z) {
        if (this.mVF.getDrawable(3) != null) {
            this.mVF.dEj();
            setProgress(f);
            if (z) {
                this.mVF.dEm();
            }
            this.mVF.dEk();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void C(Throwable th) {
        this.mVF.dEj();
        dEv();
        if (this.mVF.getDrawable(5) != null) {
            IE(5);
        } else {
            IE(1);
        }
        this.mVF.dEk();
    }

    @Override // com.facebook.drawee.d.c
    public void D(Throwable th) {
        this.mVF.dEj();
        dEv();
        if (this.mVF.getDrawable(4) != null) {
            IE(4);
        } else {
            IE(1);
        }
        this.mVF.dEk();
    }

    @Override // com.facebook.drawee.d.c
    public void j(@Nullable Drawable drawable) {
        this.mVE.j(drawable);
    }

    private com.facebook.drawee.drawable.c IG(int i) {
        com.facebook.drawee.drawable.c IA = this.mVF.IA(i);
        if (IA.getDrawable() instanceof h) {
            IA = (h) IA.getDrawable();
        }
        if (IA.getDrawable() instanceof o) {
            return (o) IA.getDrawable();
        }
        return IA;
    }

    private void b(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.mVF.a(i, null);
            return;
        }
        IG(i).setDrawable(e.a(drawable, this.mVD, this.mResources));
    }

    private o IH(int i) {
        com.facebook.drawee.drawable.c IG = IG(i);
        return IG instanceof o ? (o) IG : e.a(IG, p.b.mVs);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        IH(2).a(bVar);
    }

    public void m(@Nullable Drawable drawable) {
        b(1, drawable);
    }

    public void b(Drawable drawable, p.b bVar) {
        b(1, drawable);
        IH(1).a(bVar);
    }

    public void II(int i) {
        m(this.mResources.getDrawable(i));
    }

    public void setFailureImage(@Nullable Drawable drawable) {
        b(5, drawable);
    }

    public void c(Drawable drawable, p.b bVar) {
        b(5, drawable);
        IH(5).a(bVar);
    }

    public void IJ(int i) {
        setFailureImage(this.mResources.getDrawable(i));
    }

    public void d(Drawable drawable, p.b bVar) {
        b(4, drawable);
        IH(4).a(bVar);
    }

    public void e(Drawable drawable, p.b bVar) {
        b(3, drawable);
        IH(3).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.mVD = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.mVE, this.mVD);
        for (int i = 0; i < this.mVF.dEg(); i++) {
            e.a(IG(i), this.mVD, this.mResources);
        }
    }

    @Nullable
    public RoundingParams dEw() {
        return this.mVD;
    }
}
