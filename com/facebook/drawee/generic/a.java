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
    @Nullable
    private RoundingParams lWp;
    private final d lWq;
    private final f lWr;
    private final Resources mResources;
    private final Drawable lWo = new ColorDrawable(0);
    private final g lWs = new g(this.lWo);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.lWp = bVar.doX();
        int size = (bVar.dpm() != null ? bVar.dpm().size() : 1) + (bVar.dpn() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.dpb(), bVar.dpc());
        drawableArr[2] = a(this.lWs, bVar.dpj(), bVar.dpk(), bVar.dpl());
        drawableArr[3] = a(bVar.dph(), bVar.dpi());
        drawableArr[4] = a(bVar.dpd(), bVar.dpe());
        drawableArr[5] = a(bVar.dpf(), bVar.dpg());
        if (size > 0) {
            if (bVar.dpm() != null) {
                for (Drawable drawable : bVar.dpm()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.dpn() != null) {
                drawableArr[i + 6] = a(bVar.dpn(), null);
            }
        }
        this.lWr = new f(drawableArr);
        this.lWr.Gn(bVar.doY());
        this.lWq = new d(e.a(this.lWr, this.lWp));
        this.lWq.vG(bVar.doZ());
        this.lWq.mutate();
        doV();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.f(e.a(drawable, this.lWp, this.mResources), bVar);
    }

    private void doU() {
        this.lWs.setDrawable(this.lWo);
    }

    private void doV() {
        if (this.lWr != null) {
            this.lWr.doK();
            this.lWr.doM();
            doW();
            Go(1);
            this.lWr.doN();
            this.lWr.doL();
        }
    }

    private void doW() {
        Gp(1);
        Gp(2);
        Gp(3);
        Gp(4);
        Gp(5);
    }

    private void Go(int i) {
        if (i >= 0) {
            this.lWr.Go(i);
        }
    }

    private void Gp(int i) {
        if (i >= 0) {
            this.lWr.Gp(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.lWr.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                Gp(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                Go(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.lWq;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        doU();
        doV();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.lWp, this.mResources);
        a.mutate();
        this.lWs.setDrawable(a);
        this.lWr.doK();
        doW();
        Go(2);
        setProgress(f);
        if (z) {
            this.lWr.doN();
        }
        this.lWr.doL();
    }

    @Override // com.facebook.drawee.d.c
    public void c(float f, boolean z) {
        if (this.lWr.getDrawable(3) != null) {
            this.lWr.doK();
            setProgress(f);
            if (z) {
                this.lWr.doN();
            }
            this.lWr.doL();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void D(Throwable th) {
        this.lWr.doK();
        doW();
        if (this.lWr.getDrawable(5) != null) {
            Go(5);
        } else {
            Go(1);
        }
        this.lWr.doL();
    }

    @Override // com.facebook.drawee.d.c
    public void E(Throwable th) {
        this.lWr.doK();
        doW();
        if (this.lWr.getDrawable(4) != null) {
            Go(4);
        } else {
            Go(1);
        }
        this.lWr.doL();
    }

    @Override // com.facebook.drawee.d.c
    public void j(@Nullable Drawable drawable) {
        this.lWq.j(drawable);
    }

    private com.facebook.drawee.drawable.c Gq(int i) {
        com.facebook.drawee.drawable.c Gk = this.lWr.Gk(i);
        if (Gk.getDrawable() instanceof h) {
            Gk = (h) Gk.getDrawable();
        }
        if (Gk.getDrawable() instanceof o) {
            return (o) Gk.getDrawable();
        }
        return Gk;
    }

    private void b(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.lWr.a(i, null);
            return;
        }
        Gq(i).setDrawable(e.a(drawable, this.lWp, this.mResources));
    }

    private o Gr(int i) {
        com.facebook.drawee.drawable.c Gq = Gq(i);
        return Gq instanceof o ? (o) Gq : e.a(Gq, p.b.lWe);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        Gr(2).a(bVar);
    }

    public void m(@Nullable Drawable drawable) {
        b(1, drawable);
    }

    public void b(Drawable drawable, p.b bVar) {
        b(1, drawable);
        Gr(1).a(bVar);
    }

    public void Gs(int i) {
        m(this.mResources.getDrawable(i));
    }

    public void setFailureImage(@Nullable Drawable drawable) {
        b(5, drawable);
    }

    public void c(Drawable drawable, p.b bVar) {
        b(5, drawable);
        Gr(5).a(bVar);
    }

    public void Gt(int i) {
        setFailureImage(this.mResources.getDrawable(i));
    }

    public void d(Drawable drawable, p.b bVar) {
        b(4, drawable);
        Gr(4).a(bVar);
    }

    public void e(Drawable drawable, p.b bVar) {
        b(3, drawable);
        Gr(3).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.lWp = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.lWq, this.lWp);
        for (int i = 0; i < this.lWr.doH(); i++) {
            e.a(Gq(i), this.lWp, this.mResources);
        }
    }

    @Nullable
    public RoundingParams doX() {
        return this.lWp;
    }
}
