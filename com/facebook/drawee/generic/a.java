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
/* loaded from: classes11.dex */
public class a implements com.facebook.drawee.d.c {
    private final Resources mResources;
    @Nullable
    private RoundingParams nzL;
    private final d nzM;
    private final f nzN;
    private final Drawable nzK = new ColorDrawable(0);
    private final g nzO = new g(this.nzK);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.nzL = bVar.dUE();
        int size = (bVar.getOverlays() != null ? bVar.getOverlays().size() : 1) + (bVar.dUT() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.dUI(), bVar.dUJ());
        drawableArr[2] = a(this.nzO, bVar.dUQ(), bVar.dUR(), bVar.dUS());
        drawableArr[3] = a(bVar.dUO(), bVar.dUP());
        drawableArr[4] = a(bVar.dUK(), bVar.dUL());
        drawableArr[5] = a(bVar.dUM(), bVar.dUN());
        if (size > 0) {
            if (bVar.getOverlays() != null) {
                for (Drawable drawable : bVar.getOverlays()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.dUT() != null) {
                drawableArr[i + 6] = a(bVar.dUT(), null);
            }
        }
        this.nzN = new f(drawableArr);
        this.nzN.LM(bVar.dUF());
        this.nzM = new d(e.a(this.nzN, this.nzL));
        this.nzM.yj(bVar.dUG());
        this.nzM.mutate();
        dUC();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.f(e.a(drawable, this.nzL, this.mResources), bVar);
    }

    private void dUB() {
        this.nzO.setDrawable(this.nzK);
    }

    private void dUC() {
        if (this.nzN != null) {
            this.nzN.dUr();
            this.nzN.dUt();
            dUD();
            LN(1);
            this.nzN.dUu();
            this.nzN.dUs();
        }
    }

    private void dUD() {
        LO(1);
        LO(2);
        LO(3);
        LO(4);
        LO(5);
    }

    private void LN(int i) {
        if (i >= 0) {
            this.nzN.LN(i);
        }
    }

    private void LO(int i) {
        if (i >= 0) {
            this.nzN.LO(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.nzN.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                LO(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                LN(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.nzM;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        dUB();
        dUC();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.nzL, this.mResources);
        a.mutate();
        this.nzO.setDrawable(a);
        this.nzN.dUr();
        dUD();
        LN(2);
        setProgress(f);
        if (z) {
            this.nzN.dUu();
        }
        this.nzN.dUs();
    }

    @Override // com.facebook.drawee.d.c
    public void c(float f, boolean z) {
        if (this.nzN.getDrawable(3) != null) {
            this.nzN.dUr();
            setProgress(f);
            if (z) {
                this.nzN.dUu();
            }
            this.nzN.dUs();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void B(Throwable th) {
        this.nzN.dUr();
        dUD();
        if (this.nzN.getDrawable(5) != null) {
            LN(5);
        } else {
            LN(1);
        }
        this.nzN.dUs();
    }

    @Override // com.facebook.drawee.d.c
    public void C(Throwable th) {
        this.nzN.dUr();
        dUD();
        if (this.nzN.getDrawable(4) != null) {
            LN(4);
        } else {
            LN(1);
        }
        this.nzN.dUs();
    }

    @Override // com.facebook.drawee.d.c
    public void j(@Nullable Drawable drawable) {
        this.nzM.j(drawable);
    }

    private com.facebook.drawee.drawable.c LP(int i) {
        com.facebook.drawee.drawable.c LJ = this.nzN.LJ(i);
        if (LJ.getDrawable() instanceof h) {
            LJ = (h) LJ.getDrawable();
        }
        if (LJ.getDrawable() instanceof o) {
            return (o) LJ.getDrawable();
        }
        return LJ;
    }

    private void b(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.nzN.a(i, null);
            return;
        }
        LP(i).setDrawable(e.a(drawable, this.nzL, this.mResources));
    }

    private o LQ(int i) {
        com.facebook.drawee.drawable.c LP = LP(i);
        return LP instanceof o ? (o) LP : e.a(LP, p.b.nzA);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        LQ(2).a(bVar);
    }

    public void m(@Nullable Drawable drawable) {
        b(1, drawable);
    }

    public void b(Drawable drawable, p.b bVar) {
        b(1, drawable);
        LQ(1).a(bVar);
    }

    public void LR(int i) {
        m(this.mResources.getDrawable(i));
    }

    public void setFailureImage(@Nullable Drawable drawable) {
        b(5, drawable);
    }

    public void c(Drawable drawable, p.b bVar) {
        b(5, drawable);
        LQ(5).a(bVar);
    }

    public void LS(int i) {
        setFailureImage(this.mResources.getDrawable(i));
    }

    public void d(Drawable drawable, p.b bVar) {
        b(4, drawable);
        LQ(4).a(bVar);
    }

    public void e(Drawable drawable, p.b bVar) {
        b(3, drawable);
        LQ(3).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.nzL = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.nzM, this.nzL);
        for (int i = 0; i < this.nzN.dUo(); i++) {
            e.a(LP(i), this.nzL, this.mResources);
        }
    }

    @Nullable
    public RoundingParams dUE() {
        return this.nzL;
    }
}
