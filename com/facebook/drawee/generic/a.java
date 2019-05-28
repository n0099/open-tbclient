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
    private RoundingParams jWf;
    private final d jWg;
    private final f jWh;
    private final Resources mResources;
    private final Drawable jWe = new ColorDrawable(0);
    private final g jWi = new g(this.jWe);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.jWf = bVar.cDN();
        int size = (bVar.cDL() != null ? bVar.cDL().size() : 1) + (bVar.cDM() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.cDz(), bVar.cDA());
        drawableArr[2] = a(this.jWi, bVar.cDH(), bVar.cDJ(), bVar.cDI(), bVar.cDK());
        drawableArr[3] = a(bVar.cDF(), bVar.cDG());
        drawableArr[4] = a(bVar.cDB(), bVar.cDC());
        drawableArr[5] = a(bVar.cDD(), bVar.cDE());
        if (size > 0) {
            if (bVar.cDL() != null) {
                for (Drawable drawable : bVar.cDL()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.cDM() != null) {
                drawableArr[i + 6] = a(bVar.cDM(), null);
            }
        }
        this.jWh = new f(drawableArr);
        this.jWh.CY(bVar.cDx());
        this.jWg = new d(e.a(this.jWh, this.jWf));
        this.jWg.mutate();
        cDv();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable n.b bVar, @Nullable PointF pointF, @Nullable Matrix matrix, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(e.a(drawable, bVar, pointF), matrix);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable n.b bVar) {
        return e.b(e.a(drawable, this.jWf, this.mResources), bVar);
    }

    private void cDu() {
        this.jWi.h(this.jWe);
    }

    private void cDv() {
        if (this.jWh != null) {
            this.jWh.cDj();
            this.jWh.cDl();
            cDw();
            CZ(1);
            this.jWh.cDm();
            this.jWh.cDk();
        }
    }

    private void cDw() {
        Da(1);
        Da(2);
        Da(3);
        Da(4);
        Da(5);
    }

    private void CZ(int i) {
        if (i >= 0) {
            this.jWh.CZ(i);
        }
    }

    private void Da(int i) {
        if (i >= 0) {
            this.jWh.Da(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.jWh.getDrawable(3);
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
        return this.jWg;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        cDu();
        cDv();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.jWf, this.mResources);
        a.mutate();
        this.jWi.h(a);
        this.jWh.cDj();
        cDw();
        CZ(2);
        setProgress(f);
        if (z) {
            this.jWh.cDm();
        }
        this.jWh.cDk();
    }

    @Override // com.facebook.drawee.d.c
    public void d(float f, boolean z) {
        if (this.jWh.getDrawable(3) != null) {
            this.jWh.cDj();
            setProgress(f);
            if (z) {
                this.jWh.cDm();
            }
            this.jWh.cDk();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void y(Throwable th) {
        this.jWh.cDj();
        cDw();
        if (this.jWh.getDrawable(5) != null) {
            CZ(5);
        } else {
            CZ(1);
        }
        this.jWh.cDk();
    }

    @Override // com.facebook.drawee.d.c
    public void z(Throwable th) {
        this.jWh.cDj();
        cDw();
        if (this.jWh.getDrawable(4) != null) {
            CZ(4);
        } else {
            CZ(1);
        }
        this.jWh.cDk();
    }

    @Override // com.facebook.drawee.d.c
    public void g(@Nullable Drawable drawable) {
        this.jWg.g(drawable);
    }

    private com.facebook.drawee.drawable.c Db(int i) {
        com.facebook.drawee.drawable.c CV = this.jWh.CV(i);
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
        return Db instanceof m ? (m) Db : e.a(Db, n.b.jVV);
    }

    public void b(n.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        Dc(2).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.jWf = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.jWg, this.jWf);
        for (int i = 0; i < this.jWh.getNumberOfLayers(); i++) {
            e.a(Db(i), this.jWf, this.mResources);
        }
    }
}
