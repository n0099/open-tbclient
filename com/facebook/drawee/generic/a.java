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
    private RoundingParams pEb;
    private final d pEc;
    private final f pEd;
    private final Drawable pEa = new ColorDrawable(0);
    private final g pEe = new g(this.pEa);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.pEb = bVar.euH();
        int size = (bVar.euW() != null ? bVar.euW().size() : 1) + (bVar.euX() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), (p.b) null);
        drawableArr[1] = a(bVar.euL(), bVar.euM());
        drawableArr[2] = a(this.pEe, bVar.euT(), bVar.euU(), bVar.euV());
        drawableArr[3] = a(bVar.euR(), bVar.euS());
        drawableArr[4] = a(bVar.euN(), bVar.euO());
        drawableArr[5] = a(bVar.euP(), bVar.euQ());
        if (size > 0) {
            if (bVar.euW() != null) {
                for (Drawable drawable : bVar.euW()) {
                    drawableArr[i + 6] = a(drawable, (p.b) null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.euX() != null) {
                drawableArr[i + 6] = a(bVar.euX(), (p.b) null);
            }
        }
        this.pEd = new f(drawableArr);
        this.pEd.Pi(bVar.euI());
        this.pEc = new d(e.a(this.pEd, this.pEb));
        this.pEc.Bq(bVar.euJ());
        this.pEc.mutate();
        euF();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.d(e.a(drawable, this.pEb, this.mResources), bVar);
    }

    private void euE() {
        this.pEe.v(this.pEa);
    }

    private void euF() {
        if (this.pEd != null) {
            this.pEd.eut();
            this.pEd.euv();
            euG();
            Pj(1);
            this.pEd.euw();
            this.pEd.euu();
        }
    }

    private void euG() {
        Pk(1);
        Pk(2);
        Pk(3);
        Pk(4);
        Pk(5);
    }

    private void Pj(int i) {
        if (i >= 0) {
            this.pEd.Pj(i);
        }
    }

    private void Pk(int i) {
        if (i >= 0) {
            this.pEd.Pk(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.pEd.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                Pk(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                Pj(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.pEc;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        euE();
        euF();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a2 = e.a(drawable, this.pEb, this.mResources);
        a2.mutate();
        this.pEe.v(a2);
        this.pEd.eut();
        euG();
        Pj(2);
        setProgress(f);
        if (z) {
            this.pEd.euw();
        }
        this.pEd.euu();
    }

    @Override // com.facebook.drawee.d.c
    public void d(float f, boolean z) {
        if (this.pEd.getDrawable(3) != null) {
            this.pEd.eut();
            setProgress(f);
            if (z) {
                this.pEd.euw();
            }
            this.pEd.euu();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void z(Throwable th) {
        this.pEd.eut();
        euG();
        if (this.pEd.getDrawable(5) != null) {
            Pj(5);
        } else {
            Pj(1);
        }
        this.pEd.euu();
    }

    @Override // com.facebook.drawee.d.c
    public void A(Throwable th) {
        this.pEd.eut();
        euG();
        if (this.pEd.getDrawable(4) != null) {
            Pj(4);
        } else {
            Pj(1);
        }
        this.pEd.euu();
    }

    @Override // com.facebook.drawee.d.c
    public void u(@Nullable Drawable drawable) {
        this.pEc.u(drawable);
    }

    private com.facebook.drawee.drawable.c Pl(int i) {
        com.facebook.drawee.drawable.c Pf = this.pEd.Pf(i);
        if (Pf.getDrawable() instanceof h) {
            Pf = (h) Pf.getDrawable();
        }
        if (Pf.getDrawable() instanceof o) {
            return (o) Pf.getDrawable();
        }
        return Pf;
    }

    private void b(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.pEd.a(i, null);
            return;
        }
        Pl(i).v(e.a(drawable, this.pEb, this.mResources));
    }

    private o Pm(int i) {
        com.facebook.drawee.drawable.c Pl = Pl(i);
        return Pl instanceof o ? (o) Pl : e.a(Pl, p.b.pDQ);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        Pm(2).a(bVar);
    }

    public void A(@Nullable Drawable drawable) {
        b(1, drawable);
    }

    public void b(Drawable drawable, p.b bVar) {
        b(1, drawable);
        Pm(1).a(bVar);
    }

    public void Pn(int i) {
        A(this.mResources.getDrawable(i));
    }

    public void a(int i, p.b bVar) {
        b(this.mResources.getDrawable(i), bVar);
    }

    public void c(Drawable drawable, p.b bVar) {
        b(5, drawable);
        Pm(5).a(bVar);
    }

    public void b(int i, p.b bVar) {
        c(this.mResources.getDrawable(i), bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.pEb = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.pEc, this.pEb);
        for (int i = 0; i < this.pEd.euq(); i++) {
            e.a(Pl(i), this.pEb, this.mResources);
        }
    }

    @Nullable
    public RoundingParams euH() {
        return this.pEb;
    }
}
