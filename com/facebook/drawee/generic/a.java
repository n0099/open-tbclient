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
/* loaded from: classes14.dex */
public class a implements com.facebook.drawee.d.c {
    private final Resources mResources;
    @Nullable
    private RoundingParams oRt;
    private final d oRu;
    private final f oRv;
    private final Drawable oRs = new ColorDrawable(0);
    private final g oRw = new g(this.oRs);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.oRt = bVar.ema();
        int size = (bVar.getOverlays() != null ? bVar.getOverlays().size() : 1) + (bVar.emp() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), (p.b) null);
        drawableArr[1] = a(bVar.eme(), bVar.emf());
        drawableArr[2] = a(this.oRw, bVar.emm(), bVar.emn(), bVar.emo());
        drawableArr[3] = a(bVar.emk(), bVar.eml());
        drawableArr[4] = a(bVar.emg(), bVar.emh());
        drawableArr[5] = a(bVar.emi(), bVar.emj());
        if (size > 0) {
            if (bVar.getOverlays() != null) {
                for (Drawable drawable : bVar.getOverlays()) {
                    drawableArr[i + 6] = a(drawable, (p.b) null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.emp() != null) {
                drawableArr[i + 6] = a(bVar.emp(), (p.b) null);
            }
        }
        this.oRv = new f(drawableArr);
        this.oRv.Ph(bVar.emb());
        this.oRu = new d(e.a(this.oRv, this.oRt));
        this.oRu.Aq(bVar.emc());
        this.oRu.mutate();
        elY();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.f(e.a(drawable, this.oRt, this.mResources), bVar);
    }

    private void elX() {
        this.oRw.setDrawable(this.oRs);
    }

    private void elY() {
        if (this.oRv != null) {
            this.oRv.elN();
            this.oRv.elP();
            elZ();
            Pi(1);
            this.oRv.elQ();
            this.oRv.elO();
        }
    }

    private void elZ() {
        Pj(1);
        Pj(2);
        Pj(3);
        Pj(4);
        Pj(5);
    }

    private void Pi(int i) {
        if (i >= 0) {
            this.oRv.Pi(i);
        }
    }

    private void Pj(int i) {
        if (i >= 0) {
            this.oRv.Pj(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.oRv.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                Pj(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                Pi(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.oRu;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        elX();
        elY();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a2 = e.a(drawable, this.oRt, this.mResources);
        a2.mutate();
        this.oRw.setDrawable(a2);
        this.oRv.elN();
        elZ();
        Pi(2);
        setProgress(f);
        if (z) {
            this.oRv.elQ();
        }
        this.oRv.elO();
    }

    @Override // com.facebook.drawee.d.c
    public void c(float f, boolean z) {
        if (this.oRv.getDrawable(3) != null) {
            this.oRv.elN();
            setProgress(f);
            if (z) {
                this.oRv.elQ();
            }
            this.oRv.elO();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void B(Throwable th) {
        this.oRv.elN();
        elZ();
        if (this.oRv.getDrawable(5) != null) {
            Pi(5);
        } else {
            Pi(1);
        }
        this.oRv.elO();
    }

    @Override // com.facebook.drawee.d.c
    public void C(Throwable th) {
        this.oRv.elN();
        elZ();
        if (this.oRv.getDrawable(4) != null) {
            Pi(4);
        } else {
            Pi(1);
        }
        this.oRv.elO();
    }

    @Override // com.facebook.drawee.d.c
    public void p(@Nullable Drawable drawable) {
        this.oRu.p(drawable);
    }

    private com.facebook.drawee.drawable.c Pk(int i) {
        com.facebook.drawee.drawable.c Pe = this.oRv.Pe(i);
        if (Pe.getDrawable() instanceof h) {
            Pe = (h) Pe.getDrawable();
        }
        if (Pe.getDrawable() instanceof o) {
            return (o) Pe.getDrawable();
        }
        return Pe;
    }

    private void b(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.oRv.a(i, null);
            return;
        }
        Pk(i).setDrawable(e.a(drawable, this.oRt, this.mResources));
    }

    private o Pl(int i) {
        com.facebook.drawee.drawable.c Pk = Pk(i);
        return Pk instanceof o ? (o) Pk : e.a(Pk, p.b.oRi);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        Pl(2).a(bVar);
    }

    public void s(@Nullable Drawable drawable) {
        b(1, drawable);
    }

    public void b(Drawable drawable, p.b bVar) {
        b(1, drawable);
        Pl(1).a(bVar);
    }

    public void Pm(int i) {
        s(this.mResources.getDrawable(i));
    }

    public void a(int i, p.b bVar) {
        b(this.mResources.getDrawable(i), bVar);
    }

    public void setFailureImage(@Nullable Drawable drawable) {
        b(5, drawable);
    }

    public void c(Drawable drawable, p.b bVar) {
        b(5, drawable);
        Pl(5).a(bVar);
    }

    public void Pn(int i) {
        setFailureImage(this.mResources.getDrawable(i));
    }

    public void d(Drawable drawable, p.b bVar) {
        b(4, drawable);
        Pl(4).a(bVar);
    }

    public void e(Drawable drawable, p.b bVar) {
        b(3, drawable);
        Pl(3).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.oRt = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.oRu, this.oRt);
        for (int i = 0; i < this.oRv.elK(); i++) {
            e.a(Pk(i), this.oRt, this.mResources);
        }
    }

    @Nullable
    public RoundingParams ema() {
        return this.oRt;
    }
}
