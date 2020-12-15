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
/* loaded from: classes8.dex */
public class a implements com.facebook.drawee.d.c {
    private final Resources mResources;
    @Nullable
    private RoundingParams pgE;
    private final d pgF;
    private final f pgG;
    private final Drawable pgD = new ColorDrawable(0);
    private final g pgH = new g(this.pgD);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.pgE = bVar.erQ();
        int size = (bVar.getOverlays() != null ? bVar.getOverlays().size() : 1) + (bVar.esf() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), (p.b) null);
        drawableArr[1] = a(bVar.erU(), bVar.erV());
        drawableArr[2] = a(this.pgH, bVar.esc(), bVar.esd(), bVar.ese());
        drawableArr[3] = a(bVar.esa(), bVar.esb());
        drawableArr[4] = a(bVar.erW(), bVar.erX());
        drawableArr[5] = a(bVar.erY(), bVar.erZ());
        if (size > 0) {
            if (bVar.getOverlays() != null) {
                for (Drawable drawable : bVar.getOverlays()) {
                    drawableArr[i + 6] = a(drawable, (p.b) null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.esf() != null) {
                drawableArr[i + 6] = a(bVar.esf(), (p.b) null);
            }
        }
        this.pgG = new f(drawableArr);
        this.pgG.Qf(bVar.erR());
        this.pgF = new d(e.a(this.pgG, this.pgE));
        this.pgF.AT(bVar.erS());
        this.pgF.mutate();
        erO();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.c(e.a(drawable, this.pgE, this.mResources), bVar);
    }

    private void erN() {
        this.pgH.setDrawable(this.pgD);
    }

    private void erO() {
        if (this.pgG != null) {
            this.pgG.erD();
            this.pgG.erF();
            erP();
            Qg(1);
            this.pgG.erG();
            this.pgG.erE();
        }
    }

    private void erP() {
        Qh(1);
        Qh(2);
        Qh(3);
        Qh(4);
        Qh(5);
    }

    private void Qg(int i) {
        if (i >= 0) {
            this.pgG.Qg(i);
        }
    }

    private void Qh(int i) {
        if (i >= 0) {
            this.pgG.Qh(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.pgG.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                Qh(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                Qg(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.pgF;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        erN();
        erO();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a2 = e.a(drawable, this.pgE, this.mResources);
        a2.mutate();
        this.pgH.setDrawable(a2);
        this.pgG.erD();
        erP();
        Qg(2);
        setProgress(f);
        if (z) {
            this.pgG.erG();
        }
        this.pgG.erE();
    }

    @Override // com.facebook.drawee.d.c
    public void c(float f, boolean z) {
        if (this.pgG.getDrawable(3) != null) {
            this.pgG.erD();
            setProgress(f);
            if (z) {
                this.pgG.erG();
            }
            this.pgG.erE();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void B(Throwable th) {
        this.pgG.erD();
        erP();
        if (this.pgG.getDrawable(5) != null) {
            Qg(5);
        } else {
            Qg(1);
        }
        this.pgG.erE();
    }

    @Override // com.facebook.drawee.d.c
    public void C(Throwable th) {
        this.pgG.erD();
        erP();
        if (this.pgG.getDrawable(4) != null) {
            Qg(4);
        } else {
            Qg(1);
        }
        this.pgG.erE();
    }

    @Override // com.facebook.drawee.d.c
    public void p(@Nullable Drawable drawable) {
        this.pgF.p(drawable);
    }

    private com.facebook.drawee.drawable.c Qi(int i) {
        com.facebook.drawee.drawable.c Qc = this.pgG.Qc(i);
        if (Qc.getDrawable() instanceof h) {
            Qc = (h) Qc.getDrawable();
        }
        if (Qc.getDrawable() instanceof o) {
            return (o) Qc.getDrawable();
        }
        return Qc;
    }

    private void b(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.pgG.a(i, null);
            return;
        }
        Qi(i).setDrawable(e.a(drawable, this.pgE, this.mResources));
    }

    private o Qj(int i) {
        com.facebook.drawee.drawable.c Qi = Qi(i);
        return Qi instanceof o ? (o) Qi : e.a(Qi, p.b.pgt);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        Qj(2).a(bVar);
    }

    public void s(@Nullable Drawable drawable) {
        b(1, drawable);
    }

    public void b(Drawable drawable, p.b bVar) {
        b(1, drawable);
        Qj(1).a(bVar);
    }

    public void Qk(int i) {
        s(this.mResources.getDrawable(i));
    }

    public void a(int i, p.b bVar) {
        b(this.mResources.getDrawable(i), bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.pgE = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.pgF, this.pgE);
        for (int i = 0; i < this.pgG.erA(); i++) {
            e.a(Qi(i), this.pgE, this.mResources);
        }
    }

    @Nullable
    public RoundingParams erQ() {
        return this.pgE;
    }
}
