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
/* loaded from: classes13.dex */
public class a implements com.facebook.drawee.d.c {
    private final Resources mResources;
    @Nullable
    private RoundingParams mqj;
    private final d mqk;
    private final f mql;
    private final Drawable mqi = new ColorDrawable(0);
    private final g mqm = new g(this.mqi);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.mqj = bVar.dwp();
        int size = (bVar.dwE() != null ? bVar.dwE().size() : 1) + (bVar.dwF() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.dwt(), bVar.dwu());
        drawableArr[2] = a(this.mqm, bVar.dwB(), bVar.dwC(), bVar.dwD());
        drawableArr[3] = a(bVar.dwz(), bVar.dwA());
        drawableArr[4] = a(bVar.dwv(), bVar.dww());
        drawableArr[5] = a(bVar.dwx(), bVar.dwy());
        if (size > 0) {
            if (bVar.dwE() != null) {
                for (Drawable drawable : bVar.dwE()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.dwF() != null) {
                drawableArr[i + 6] = a(bVar.dwF(), null);
            }
        }
        this.mql = new f(drawableArr);
        this.mql.GZ(bVar.dwq());
        this.mqk = new d(e.a(this.mql, this.mqj));
        this.mqk.we(bVar.dwr());
        this.mqk.mutate();
        dwn();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.f(e.a(drawable, this.mqj, this.mResources), bVar);
    }

    private void dwm() {
        this.mqm.setDrawable(this.mqi);
    }

    private void dwn() {
        if (this.mql != null) {
            this.mql.dwc();
            this.mql.dwe();
            dwo();
            Ha(1);
            this.mql.dwf();
            this.mql.dwd();
        }
    }

    private void dwo() {
        Hb(1);
        Hb(2);
        Hb(3);
        Hb(4);
        Hb(5);
    }

    private void Ha(int i) {
        if (i >= 0) {
            this.mql.Ha(i);
        }
    }

    private void Hb(int i) {
        if (i >= 0) {
            this.mql.Hb(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.mql.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                Hb(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                Ha(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.mqk;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        dwm();
        dwn();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.mqj, this.mResources);
        a.mutate();
        this.mqm.setDrawable(a);
        this.mql.dwc();
        dwo();
        Ha(2);
        setProgress(f);
        if (z) {
            this.mql.dwf();
        }
        this.mql.dwd();
    }

    @Override // com.facebook.drawee.d.c
    public void c(float f, boolean z) {
        if (this.mql.getDrawable(3) != null) {
            this.mql.dwc();
            setProgress(f);
            if (z) {
                this.mql.dwf();
            }
            this.mql.dwd();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void D(Throwable th) {
        this.mql.dwc();
        dwo();
        if (this.mql.getDrawable(5) != null) {
            Ha(5);
        } else {
            Ha(1);
        }
        this.mql.dwd();
    }

    @Override // com.facebook.drawee.d.c
    public void E(Throwable th) {
        this.mql.dwc();
        dwo();
        if (this.mql.getDrawable(4) != null) {
            Ha(4);
        } else {
            Ha(1);
        }
        this.mql.dwd();
    }

    @Override // com.facebook.drawee.d.c
    public void j(@Nullable Drawable drawable) {
        this.mqk.j(drawable);
    }

    private com.facebook.drawee.drawable.c Hc(int i) {
        com.facebook.drawee.drawable.c GW = this.mql.GW(i);
        if (GW.getDrawable() instanceof h) {
            GW = (h) GW.getDrawable();
        }
        if (GW.getDrawable() instanceof o) {
            return (o) GW.getDrawable();
        }
        return GW;
    }

    private void b(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.mql.a(i, null);
            return;
        }
        Hc(i).setDrawable(e.a(drawable, this.mqj, this.mResources));
    }

    private o Hd(int i) {
        com.facebook.drawee.drawable.c Hc = Hc(i);
        return Hc instanceof o ? (o) Hc : e.a(Hc, p.b.mpY);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        Hd(2).a(bVar);
    }

    public void m(@Nullable Drawable drawable) {
        b(1, drawable);
    }

    public void b(Drawable drawable, p.b bVar) {
        b(1, drawable);
        Hd(1).a(bVar);
    }

    public void He(int i) {
        m(this.mResources.getDrawable(i));
    }

    public void setFailureImage(@Nullable Drawable drawable) {
        b(5, drawable);
    }

    public void c(Drawable drawable, p.b bVar) {
        b(5, drawable);
        Hd(5).a(bVar);
    }

    public void Hf(int i) {
        setFailureImage(this.mResources.getDrawable(i));
    }

    public void d(Drawable drawable, p.b bVar) {
        b(4, drawable);
        Hd(4).a(bVar);
    }

    public void e(Drawable drawable, p.b bVar) {
        b(3, drawable);
        Hd(3).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.mqj = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.mqk, this.mqj);
        for (int i = 0; i < this.mql.dvZ(); i++) {
            e.a(Hc(i), this.mqj, this.mResources);
        }
    }

    @Nullable
    public RoundingParams dwp() {
        return this.mqj;
    }
}
