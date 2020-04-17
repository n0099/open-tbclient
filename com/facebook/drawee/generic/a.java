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
    private RoundingParams lWl;
    private final d lWm;
    private final f lWn;
    private final Resources mResources;
    private final Drawable lWk = new ColorDrawable(0);
    private final g lWo = new g(this.lWk);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.lWl = bVar.doZ();
        int size = (bVar.dpo() != null ? bVar.dpo().size() : 1) + (bVar.dpp() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.dpd(), bVar.dpe());
        drawableArr[2] = a(this.lWo, bVar.dpl(), bVar.dpm(), bVar.dpn());
        drawableArr[3] = a(bVar.dpj(), bVar.dpk());
        drawableArr[4] = a(bVar.dpf(), bVar.dpg());
        drawableArr[5] = a(bVar.dph(), bVar.dpi());
        if (size > 0) {
            if (bVar.dpo() != null) {
                for (Drawable drawable : bVar.dpo()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.dpp() != null) {
                drawableArr[i + 6] = a(bVar.dpp(), null);
            }
        }
        this.lWn = new f(drawableArr);
        this.lWn.Gn(bVar.dpa());
        this.lWm = new d(e.a(this.lWn, this.lWl));
        this.lWm.vG(bVar.dpb());
        this.lWm.mutate();
        doX();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.f(e.a(drawable, this.lWl, this.mResources), bVar);
    }

    private void doW() {
        this.lWo.setDrawable(this.lWk);
    }

    private void doX() {
        if (this.lWn != null) {
            this.lWn.doM();
            this.lWn.doO();
            doY();
            Go(1);
            this.lWn.doP();
            this.lWn.doN();
        }
    }

    private void doY() {
        Gp(1);
        Gp(2);
        Gp(3);
        Gp(4);
        Gp(5);
    }

    private void Go(int i) {
        if (i >= 0) {
            this.lWn.Go(i);
        }
    }

    private void Gp(int i) {
        if (i >= 0) {
            this.lWn.Gp(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.lWn.getDrawable(3);
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
        return this.lWm;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        doW();
        doX();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.lWl, this.mResources);
        a.mutate();
        this.lWo.setDrawable(a);
        this.lWn.doM();
        doY();
        Go(2);
        setProgress(f);
        if (z) {
            this.lWn.doP();
        }
        this.lWn.doN();
    }

    @Override // com.facebook.drawee.d.c
    public void c(float f, boolean z) {
        if (this.lWn.getDrawable(3) != null) {
            this.lWn.doM();
            setProgress(f);
            if (z) {
                this.lWn.doP();
            }
            this.lWn.doN();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void D(Throwable th) {
        this.lWn.doM();
        doY();
        if (this.lWn.getDrawable(5) != null) {
            Go(5);
        } else {
            Go(1);
        }
        this.lWn.doN();
    }

    @Override // com.facebook.drawee.d.c
    public void E(Throwable th) {
        this.lWn.doM();
        doY();
        if (this.lWn.getDrawable(4) != null) {
            Go(4);
        } else {
            Go(1);
        }
        this.lWn.doN();
    }

    @Override // com.facebook.drawee.d.c
    public void j(@Nullable Drawable drawable) {
        this.lWm.j(drawable);
    }

    private com.facebook.drawee.drawable.c Gq(int i) {
        com.facebook.drawee.drawable.c Gk = this.lWn.Gk(i);
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
            this.lWn.a(i, null);
            return;
        }
        Gq(i).setDrawable(e.a(drawable, this.lWl, this.mResources));
    }

    private o Gr(int i) {
        com.facebook.drawee.drawable.c Gq = Gq(i);
        return Gq instanceof o ? (o) Gq : e.a(Gq, p.b.lWa);
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
        this.lWl = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.lWm, this.lWl);
        for (int i = 0; i < this.lWn.doJ(); i++) {
            e.a(Gq(i), this.lWl, this.mResources);
        }
    }

    @Nullable
    public RoundingParams doZ() {
        return this.lWl;
    }
}
