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
    private RoundingParams jWi;
    private final d jWj;
    private final f jWk;
    private final Resources mResources;
    private final Drawable jWh = new ColorDrawable(0);
    private final g jWl = new g(this.jWh);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.jWi = bVar.cDM();
        int size = (bVar.cDK() != null ? bVar.cDK().size() : 1) + (bVar.cDL() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.cDy(), bVar.cDz());
        drawableArr[2] = a(this.jWl, bVar.cDG(), bVar.cDI(), bVar.cDH(), bVar.cDJ());
        drawableArr[3] = a(bVar.cDE(), bVar.cDF());
        drawableArr[4] = a(bVar.cDA(), bVar.cDB());
        drawableArr[5] = a(bVar.cDC(), bVar.cDD());
        if (size > 0) {
            if (bVar.cDK() != null) {
                for (Drawable drawable : bVar.cDK()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.cDL() != null) {
                drawableArr[i + 6] = a(bVar.cDL(), null);
            }
        }
        this.jWk = new f(drawableArr);
        this.jWk.CY(bVar.cDw());
        this.jWj = new d(e.a(this.jWk, this.jWi));
        this.jWj.mutate();
        cDu();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable n.b bVar, @Nullable PointF pointF, @Nullable Matrix matrix, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(e.a(drawable, bVar, pointF), matrix);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable n.b bVar) {
        return e.b(e.a(drawable, this.jWi, this.mResources), bVar);
    }

    private void cDt() {
        this.jWl.h(this.jWh);
    }

    private void cDu() {
        if (this.jWk != null) {
            this.jWk.cDi();
            this.jWk.cDk();
            cDv();
            CZ(1);
            this.jWk.cDl();
            this.jWk.cDj();
        }
    }

    private void cDv() {
        Da(1);
        Da(2);
        Da(3);
        Da(4);
        Da(5);
    }

    private void CZ(int i) {
        if (i >= 0) {
            this.jWk.CZ(i);
        }
    }

    private void Da(int i) {
        if (i >= 0) {
            this.jWk.Da(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.jWk.getDrawable(3);
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
        return this.jWj;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        cDt();
        cDu();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.jWi, this.mResources);
        a.mutate();
        this.jWl.h(a);
        this.jWk.cDi();
        cDv();
        CZ(2);
        setProgress(f);
        if (z) {
            this.jWk.cDl();
        }
        this.jWk.cDj();
    }

    @Override // com.facebook.drawee.d.c
    public void d(float f, boolean z) {
        if (this.jWk.getDrawable(3) != null) {
            this.jWk.cDi();
            setProgress(f);
            if (z) {
                this.jWk.cDl();
            }
            this.jWk.cDj();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void y(Throwable th) {
        this.jWk.cDi();
        cDv();
        if (this.jWk.getDrawable(5) != null) {
            CZ(5);
        } else {
            CZ(1);
        }
        this.jWk.cDj();
    }

    @Override // com.facebook.drawee.d.c
    public void z(Throwable th) {
        this.jWk.cDi();
        cDv();
        if (this.jWk.getDrawable(4) != null) {
            CZ(4);
        } else {
            CZ(1);
        }
        this.jWk.cDj();
    }

    @Override // com.facebook.drawee.d.c
    public void g(@Nullable Drawable drawable) {
        this.jWj.g(drawable);
    }

    private com.facebook.drawee.drawable.c Db(int i) {
        com.facebook.drawee.drawable.c CV = this.jWk.CV(i);
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
        return Db instanceof m ? (m) Db : e.a(Db, n.b.jVY);
    }

    public void b(n.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        Dc(2).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.jWi = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.jWj, this.jWi);
        for (int i = 0; i < this.jWk.getNumberOfLayers(); i++) {
            e.a(Db(i), this.jWi, this.mResources);
        }
    }
}
