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
    private RoundingParams npN;
    private final d npO;
    private final f npP;
    private final Drawable npM = new ColorDrawable(0);
    private final g npQ = new g(this.npM);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.npN = bVar.dQG();
        int size = (bVar.getOverlays() != null ? bVar.getOverlays().size() : 1) + (bVar.dQV() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.dQK(), bVar.dQL());
        drawableArr[2] = a(this.npQ, bVar.dQS(), bVar.dQT(), bVar.dQU());
        drawableArr[3] = a(bVar.dQQ(), bVar.dQR());
        drawableArr[4] = a(bVar.dQM(), bVar.dQN());
        drawableArr[5] = a(bVar.dQO(), bVar.dQP());
        if (size > 0) {
            if (bVar.getOverlays() != null) {
                for (Drawable drawable : bVar.getOverlays()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.dQV() != null) {
                drawableArr[i + 6] = a(bVar.dQV(), null);
            }
        }
        this.npP = new f(drawableArr);
        this.npP.Lh(bVar.dQH());
        this.npO = new d(e.a(this.npP, this.npN));
        this.npO.ya(bVar.dQI());
        this.npO.mutate();
        dQE();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.f(e.a(drawable, this.npN, this.mResources), bVar);
    }

    private void dQD() {
        this.npQ.setDrawable(this.npM);
    }

    private void dQE() {
        if (this.npP != null) {
            this.npP.dQt();
            this.npP.dQv();
            dQF();
            Li(1);
            this.npP.dQw();
            this.npP.dQu();
        }
    }

    private void dQF() {
        Lj(1);
        Lj(2);
        Lj(3);
        Lj(4);
        Lj(5);
    }

    private void Li(int i) {
        if (i >= 0) {
            this.npP.Li(i);
        }
    }

    private void Lj(int i) {
        if (i >= 0) {
            this.npP.Lj(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.npP.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                Lj(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                Li(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.npO;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        dQD();
        dQE();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.npN, this.mResources);
        a.mutate();
        this.npQ.setDrawable(a);
        this.npP.dQt();
        dQF();
        Li(2);
        setProgress(f);
        if (z) {
            this.npP.dQw();
        }
        this.npP.dQu();
    }

    @Override // com.facebook.drawee.d.c
    public void c(float f, boolean z) {
        if (this.npP.getDrawable(3) != null) {
            this.npP.dQt();
            setProgress(f);
            if (z) {
                this.npP.dQw();
            }
            this.npP.dQu();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void B(Throwable th) {
        this.npP.dQt();
        dQF();
        if (this.npP.getDrawable(5) != null) {
            Li(5);
        } else {
            Li(1);
        }
        this.npP.dQu();
    }

    @Override // com.facebook.drawee.d.c
    public void C(Throwable th) {
        this.npP.dQt();
        dQF();
        if (this.npP.getDrawable(4) != null) {
            Li(4);
        } else {
            Li(1);
        }
        this.npP.dQu();
    }

    @Override // com.facebook.drawee.d.c
    public void j(@Nullable Drawable drawable) {
        this.npO.j(drawable);
    }

    private com.facebook.drawee.drawable.c Lk(int i) {
        com.facebook.drawee.drawable.c Le = this.npP.Le(i);
        if (Le.getDrawable() instanceof h) {
            Le = (h) Le.getDrawable();
        }
        if (Le.getDrawable() instanceof o) {
            return (o) Le.getDrawable();
        }
        return Le;
    }

    private void b(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.npP.a(i, null);
            return;
        }
        Lk(i).setDrawable(e.a(drawable, this.npN, this.mResources));
    }

    private o Ll(int i) {
        com.facebook.drawee.drawable.c Lk = Lk(i);
        return Lk instanceof o ? (o) Lk : e.a(Lk, p.b.npC);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        Ll(2).a(bVar);
    }

    public void m(@Nullable Drawable drawable) {
        b(1, drawable);
    }

    public void b(Drawable drawable, p.b bVar) {
        b(1, drawable);
        Ll(1).a(bVar);
    }

    public void Lm(int i) {
        m(this.mResources.getDrawable(i));
    }

    public void setFailureImage(@Nullable Drawable drawable) {
        b(5, drawable);
    }

    public void c(Drawable drawable, p.b bVar) {
        b(5, drawable);
        Ll(5).a(bVar);
    }

    public void Ln(int i) {
        setFailureImage(this.mResources.getDrawable(i));
    }

    public void d(Drawable drawable, p.b bVar) {
        b(4, drawable);
        Ll(4).a(bVar);
    }

    public void e(Drawable drawable, p.b bVar) {
        b(3, drawable);
        Ll(3).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.npN = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.npO, this.npN);
        for (int i = 0; i < this.npP.dQq(); i++) {
            e.a(Lk(i), this.npN, this.mResources);
        }
    }

    @Nullable
    public RoundingParams dQG() {
        return this.npN;
    }
}
