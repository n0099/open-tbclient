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
/* loaded from: classes4.dex */
public class a implements com.facebook.drawee.d.c {
    private final Resources mResources;
    @Nullable
    private RoundingParams pGg;
    private final d pGh;
    private final f pGi;
    private final Drawable pGf = new ColorDrawable(0);
    private final g pGj = new g(this.pGf);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.pGg = bVar.euQ();
        int size = (bVar.evf() != null ? bVar.evf().size() : 1) + (bVar.evg() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), (p.b) null);
        drawableArr[1] = a(bVar.euU(), bVar.euV());
        drawableArr[2] = a(this.pGj, bVar.evc(), bVar.evd(), bVar.eve());
        drawableArr[3] = a(bVar.eva(), bVar.evb());
        drawableArr[4] = a(bVar.euW(), bVar.euX());
        drawableArr[5] = a(bVar.euY(), bVar.euZ());
        if (size > 0) {
            if (bVar.evf() != null) {
                for (Drawable drawable : bVar.evf()) {
                    drawableArr[i + 6] = a(drawable, (p.b) null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.evg() != null) {
                drawableArr[i + 6] = a(bVar.evg(), (p.b) null);
            }
        }
        this.pGi = new f(drawableArr);
        this.pGi.Pm(bVar.euR());
        this.pGh = new d(e.a(this.pGi, this.pGg));
        this.pGh.Bo(bVar.euS());
        this.pGh.mutate();
        euO();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.d(e.a(drawable, this.pGg, this.mResources), bVar);
    }

    private void euN() {
        this.pGj.v(this.pGf);
    }

    private void euO() {
        if (this.pGi != null) {
            this.pGi.euC();
            this.pGi.euE();
            euP();
            Pn(1);
            this.pGi.euF();
            this.pGi.euD();
        }
    }

    private void euP() {
        Po(1);
        Po(2);
        Po(3);
        Po(4);
        Po(5);
    }

    private void Pn(int i) {
        if (i >= 0) {
            this.pGi.Pn(i);
        }
    }

    private void Po(int i) {
        if (i >= 0) {
            this.pGi.Po(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.pGi.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                Po(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                Pn(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.pGh;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        euN();
        euO();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a2 = e.a(drawable, this.pGg, this.mResources);
        a2.mutate();
        this.pGj.v(a2);
        this.pGi.euC();
        euP();
        Pn(2);
        setProgress(f);
        if (z) {
            this.pGi.euF();
        }
        this.pGi.euD();
    }

    @Override // com.facebook.drawee.d.c
    public void d(float f, boolean z) {
        if (this.pGi.getDrawable(3) != null) {
            this.pGi.euC();
            setProgress(f);
            if (z) {
                this.pGi.euF();
            }
            this.pGi.euD();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void z(Throwable th) {
        this.pGi.euC();
        euP();
        if (this.pGi.getDrawable(5) != null) {
            Pn(5);
        } else {
            Pn(1);
        }
        this.pGi.euD();
    }

    @Override // com.facebook.drawee.d.c
    public void A(Throwable th) {
        this.pGi.euC();
        euP();
        if (this.pGi.getDrawable(4) != null) {
            Pn(4);
        } else {
            Pn(1);
        }
        this.pGi.euD();
    }

    @Override // com.facebook.drawee.d.c
    public void u(@Nullable Drawable drawable) {
        this.pGh.u(drawable);
    }

    private com.facebook.drawee.drawable.c Pp(int i) {
        com.facebook.drawee.drawable.c Pj = this.pGi.Pj(i);
        if (Pj.getDrawable() instanceof h) {
            Pj = (h) Pj.getDrawable();
        }
        if (Pj.getDrawable() instanceof o) {
            return (o) Pj.getDrawable();
        }
        return Pj;
    }

    private void b(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.pGi.a(i, null);
            return;
        }
        Pp(i).v(e.a(drawable, this.pGg, this.mResources));
    }

    private o Pq(int i) {
        com.facebook.drawee.drawable.c Pp = Pp(i);
        return Pp instanceof o ? (o) Pp : e.a(Pp, p.b.pFV);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        Pq(2).a(bVar);
    }

    public void A(@Nullable Drawable drawable) {
        b(1, drawable);
    }

    public void b(Drawable drawable, p.b bVar) {
        b(1, drawable);
        Pq(1).a(bVar);
    }

    public void Pr(int i) {
        A(this.mResources.getDrawable(i));
    }

    public void a(int i, p.b bVar) {
        b(this.mResources.getDrawable(i), bVar);
    }

    public void c(Drawable drawable, p.b bVar) {
        b(5, drawable);
        Pq(5).a(bVar);
    }

    public void b(int i, p.b bVar) {
        c(this.mResources.getDrawable(i), bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.pGg = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.pGh, this.pGg);
        for (int i = 0; i < this.pGi.euz(); i++) {
            e.a(Pp(i), this.pGg, this.mResources);
        }
    }

    @Nullable
    public RoundingParams euQ() {
        return this.pGg;
    }
}
