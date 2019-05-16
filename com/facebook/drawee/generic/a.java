package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.f;
import com.facebook.drawee.drawable.g;
import com.facebook.drawee.drawable.h;
import com.facebook.drawee.drawable.m;
import com.facebook.drawee.drawable.n;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements com.facebook.drawee.d.c {
    @Nullable
    private RoundingParams jWe;
    private final d jWf;
    private final f jWg;
    private final Resources mResources;
    private final Drawable jWd = new ColorDrawable(0);
    private final g jWh = new g(this.jWd);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.jWe = bVar.cDL();
        int size = (bVar.cDJ() != null ? bVar.cDJ().size() : 1) + (bVar.cDK() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.cDx(), bVar.cDy());
        drawableArr[2] = a(this.jWh, bVar.cDF(), bVar.cDH(), bVar.cDG(), bVar.cDI());
        drawableArr[3] = a(bVar.cDD(), bVar.cDE());
        drawableArr[4] = a(bVar.cDz(), bVar.cDA());
        drawableArr[5] = a(bVar.cDB(), bVar.cDC());
        if (size > 0) {
            if (bVar.cDJ() != null) {
                for (Drawable drawable : bVar.cDJ()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.cDK() != null) {
                drawableArr[i + 6] = a(bVar.cDK(), null);
            }
        }
        this.jWg = new f(drawableArr);
        this.jWg.CY(bVar.cDv());
        this.jWf = new d(e.a(this.jWg, this.jWe));
        this.jWf.mutate();
        cDt();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable n.b bVar, @Nullable PointF pointF, @Nullable Matrix matrix, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(e.a(drawable, bVar, pointF), matrix);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable n.b bVar) {
        return e.b(e.a(drawable, this.jWe, this.mResources), bVar);
    }

    private void cDs() {
        this.jWh.h(this.jWd);
    }

    private void cDt() {
        if (this.jWg != null) {
            this.jWg.cDh();
            this.jWg.cDj();
            cDu();
            CZ(1);
            this.jWg.cDk();
            this.jWg.cDi();
        }
    }

    private void cDu() {
        Da(1);
        Da(2);
        Da(3);
        Da(4);
        Da(5);
    }

    private void CZ(int i) {
        if (i >= 0) {
            this.jWg.CZ(i);
        }
    }

    private void Da(int i) {
        if (i >= 0) {
            this.jWg.Da(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.jWg.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                Da(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                CZ(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.jWf;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        cDs();
        cDt();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.jWe, this.mResources);
        a.mutate();
        this.jWh.h(a);
        this.jWg.cDh();
        cDu();
        CZ(2);
        setProgress(f);
        if (z) {
            this.jWg.cDk();
        }
        this.jWg.cDi();
    }

    @Override // com.facebook.drawee.d.c
    public void d(float f, boolean z) {
        if (this.jWg.getDrawable(3) != null) {
            this.jWg.cDh();
            setProgress(f);
            if (z) {
                this.jWg.cDk();
            }
            this.jWg.cDi();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void y(Throwable th) {
        this.jWg.cDh();
        cDu();
        if (this.jWg.getDrawable(5) != null) {
            CZ(5);
        } else {
            CZ(1);
        }
        this.jWg.cDi();
    }

    @Override // com.facebook.drawee.d.c
    public void z(Throwable th) {
        this.jWg.cDh();
        cDu();
        if (this.jWg.getDrawable(4) != null) {
            CZ(4);
        } else {
            CZ(1);
        }
        this.jWg.cDi();
    }

    @Override // com.facebook.drawee.d.c
    public void g(@Nullable Drawable drawable) {
        this.jWf.g(drawable);
    }

    private com.facebook.drawee.drawable.c Db(int i) {
        com.facebook.drawee.drawable.c CV = this.jWg.CV(i);
        if (CV.getDrawable() instanceof h) {
            CV = (h) CV.getDrawable();
        }
        if (CV.getDrawable() instanceof m) {
            return (m) CV.getDrawable();
        }
        return CV;
    }

    private m Dc(int i) {
        com.facebook.drawee.drawable.c Db = Db(i);
        return Db instanceof m ? (m) Db : e.a(Db, n.b.jVU);
    }

    public void b(n.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        Dc(2).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.jWe = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.jWf, this.jWe);
        for (int i = 0; i < this.jWg.getNumberOfLayers(); i++) {
            e.a(Db(i), this.jWe, this.mResources);
        }
    }
}
