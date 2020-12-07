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
    private RoundingParams pgC;
    private final d pgD;
    private final f pgE;
    private final Drawable pgB = new ColorDrawable(0);
    private final g pgF = new g(this.pgB);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.pgC = bVar.erP();
        int size = (bVar.getOverlays() != null ? bVar.getOverlays().size() : 1) + (bVar.ese() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), (p.b) null);
        drawableArr[1] = a(bVar.erT(), bVar.erU());
        drawableArr[2] = a(this.pgF, bVar.esb(), bVar.esc(), bVar.esd());
        drawableArr[3] = a(bVar.erZ(), bVar.esa());
        drawableArr[4] = a(bVar.erV(), bVar.erW());
        drawableArr[5] = a(bVar.erX(), bVar.erY());
        if (size > 0) {
            if (bVar.getOverlays() != null) {
                for (Drawable drawable : bVar.getOverlays()) {
                    drawableArr[i + 6] = a(drawable, (p.b) null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.ese() != null) {
                drawableArr[i + 6] = a(bVar.ese(), (p.b) null);
            }
        }
        this.pgE = new f(drawableArr);
        this.pgE.Qf(bVar.erQ());
        this.pgD = new d(e.a(this.pgE, this.pgC));
        this.pgD.AT(bVar.erR());
        this.pgD.mutate();
        erN();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.c(e.a(drawable, this.pgC, this.mResources), bVar);
    }

    private void erM() {
        this.pgF.setDrawable(this.pgB);
    }

    private void erN() {
        if (this.pgE != null) {
            this.pgE.erC();
            this.pgE.erE();
            erO();
            Qg(1);
            this.pgE.erF();
            this.pgE.erD();
        }
    }

    private void erO() {
        Qh(1);
        Qh(2);
        Qh(3);
        Qh(4);
        Qh(5);
    }

    private void Qg(int i) {
        if (i >= 0) {
            this.pgE.Qg(i);
        }
    }

    private void Qh(int i) {
        if (i >= 0) {
            this.pgE.Qh(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.pgE.getDrawable(3);
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
        return this.pgD;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        erM();
        erN();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a2 = e.a(drawable, this.pgC, this.mResources);
        a2.mutate();
        this.pgF.setDrawable(a2);
        this.pgE.erC();
        erO();
        Qg(2);
        setProgress(f);
        if (z) {
            this.pgE.erF();
        }
        this.pgE.erD();
    }

    @Override // com.facebook.drawee.d.c
    public void c(float f, boolean z) {
        if (this.pgE.getDrawable(3) != null) {
            this.pgE.erC();
            setProgress(f);
            if (z) {
                this.pgE.erF();
            }
            this.pgE.erD();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void B(Throwable th) {
        this.pgE.erC();
        erO();
        if (this.pgE.getDrawable(5) != null) {
            Qg(5);
        } else {
            Qg(1);
        }
        this.pgE.erD();
    }

    @Override // com.facebook.drawee.d.c
    public void C(Throwable th) {
        this.pgE.erC();
        erO();
        if (this.pgE.getDrawable(4) != null) {
            Qg(4);
        } else {
            Qg(1);
        }
        this.pgE.erD();
    }

    @Override // com.facebook.drawee.d.c
    public void p(@Nullable Drawable drawable) {
        this.pgD.p(drawable);
    }

    private com.facebook.drawee.drawable.c Qi(int i) {
        com.facebook.drawee.drawable.c Qc = this.pgE.Qc(i);
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
            this.pgE.a(i, null);
            return;
        }
        Qi(i).setDrawable(e.a(drawable, this.pgC, this.mResources));
    }

    private o Qj(int i) {
        com.facebook.drawee.drawable.c Qi = Qi(i);
        return Qi instanceof o ? (o) Qi : e.a(Qi, p.b.pgr);
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
        this.pgC = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.pgD, this.pgC);
        for (int i = 0; i < this.pgE.erz(); i++) {
            e.a(Qi(i), this.pgC, this.mResources);
        }
    }

    @Nullable
    public RoundingParams erP() {
        return this.pgC;
    }
}
