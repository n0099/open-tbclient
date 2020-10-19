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
/* loaded from: classes15.dex */
public class a implements com.facebook.drawee.d.c {
    private final Resources mResources;
    @Nullable
    private RoundingParams nPe;
    private final d nPf;
    private final f nPg;
    private final Drawable nPd = new ColorDrawable(0);
    private final g nPh = new g(this.nPd);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.nPe = bVar.dYp();
        int size = (bVar.getOverlays() != null ? bVar.getOverlays().size() : 1) + (bVar.dYE() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), (p.b) null);
        drawableArr[1] = a(bVar.dYt(), bVar.dYu());
        drawableArr[2] = a(this.nPh, bVar.dYB(), bVar.dYC(), bVar.dYD());
        drawableArr[3] = a(bVar.dYz(), bVar.dYA());
        drawableArr[4] = a(bVar.dYv(), bVar.dYw());
        drawableArr[5] = a(bVar.dYx(), bVar.dYy());
        if (size > 0) {
            if (bVar.getOverlays() != null) {
                for (Drawable drawable : bVar.getOverlays()) {
                    drawableArr[i + 6] = a(drawable, (p.b) null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.dYE() != null) {
                drawableArr[i + 6] = a(bVar.dYE(), (p.b) null);
            }
        }
        this.nPg = new f(drawableArr);
        this.nPg.Ms(bVar.dYq());
        this.nPf = new d(e.a(this.nPg, this.nPe));
        this.nPf.yQ(bVar.dYr());
        this.nPf.mutate();
        dYn();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.f(e.a(drawable, this.nPe, this.mResources), bVar);
    }

    private void dYm() {
        this.nPh.setDrawable(this.nPd);
    }

    private void dYn() {
        if (this.nPg != null) {
            this.nPg.dYc();
            this.nPg.dYe();
            dYo();
            Mt(1);
            this.nPg.dYf();
            this.nPg.dYd();
        }
    }

    private void dYo() {
        Mu(1);
        Mu(2);
        Mu(3);
        Mu(4);
        Mu(5);
    }

    private void Mt(int i) {
        if (i >= 0) {
            this.nPg.Mt(i);
        }
    }

    private void Mu(int i) {
        if (i >= 0) {
            this.nPg.Mu(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.nPg.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                Mu(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                Mt(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.nPf;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        dYm();
        dYn();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a2 = e.a(drawable, this.nPe, this.mResources);
        a2.mutate();
        this.nPh.setDrawable(a2);
        this.nPg.dYc();
        dYo();
        Mt(2);
        setProgress(f);
        if (z) {
            this.nPg.dYf();
        }
        this.nPg.dYd();
    }

    @Override // com.facebook.drawee.d.c
    public void c(float f, boolean z) {
        if (this.nPg.getDrawable(3) != null) {
            this.nPg.dYc();
            setProgress(f);
            if (z) {
                this.nPg.dYf();
            }
            this.nPg.dYd();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void B(Throwable th) {
        this.nPg.dYc();
        dYo();
        if (this.nPg.getDrawable(5) != null) {
            Mt(5);
        } else {
            Mt(1);
        }
        this.nPg.dYd();
    }

    @Override // com.facebook.drawee.d.c
    public void C(Throwable th) {
        this.nPg.dYc();
        dYo();
        if (this.nPg.getDrawable(4) != null) {
            Mt(4);
        } else {
            Mt(1);
        }
        this.nPg.dYd();
    }

    @Override // com.facebook.drawee.d.c
    public void j(@Nullable Drawable drawable) {
        this.nPf.j(drawable);
    }

    private com.facebook.drawee.drawable.c Mv(int i) {
        com.facebook.drawee.drawable.c Mp = this.nPg.Mp(i);
        if (Mp.getDrawable() instanceof h) {
            Mp = (h) Mp.getDrawable();
        }
        if (Mp.getDrawable() instanceof o) {
            return (o) Mp.getDrawable();
        }
        return Mp;
    }

    private void b(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.nPg.a(i, null);
            return;
        }
        Mv(i).setDrawable(e.a(drawable, this.nPe, this.mResources));
    }

    private o Mw(int i) {
        com.facebook.drawee.drawable.c Mv = Mv(i);
        return Mv instanceof o ? (o) Mv : e.a(Mv, p.b.nOT);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        Mw(2).a(bVar);
    }

    public void m(@Nullable Drawable drawable) {
        b(1, drawable);
    }

    public void b(Drawable drawable, p.b bVar) {
        b(1, drawable);
        Mw(1).a(bVar);
    }

    public void Mx(int i) {
        m(this.mResources.getDrawable(i));
    }

    public void a(int i, p.b bVar) {
        b(this.mResources.getDrawable(i), bVar);
    }

    public void setFailureImage(@Nullable Drawable drawable) {
        b(5, drawable);
    }

    public void c(Drawable drawable, p.b bVar) {
        b(5, drawable);
        Mw(5).a(bVar);
    }

    public void My(int i) {
        setFailureImage(this.mResources.getDrawable(i));
    }

    public void d(Drawable drawable, p.b bVar) {
        b(4, drawable);
        Mw(4).a(bVar);
    }

    public void e(Drawable drawable, p.b bVar) {
        b(3, drawable);
        Mw(3).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.nPe = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.nPf, this.nPe);
        for (int i = 0; i < this.nPg.dXZ(); i++) {
            e.a(Mv(i), this.nPe, this.mResources);
        }
    }

    @Nullable
    public RoundingParams dYp() {
        return this.nPe;
    }
}
