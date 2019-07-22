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
    private RoundingParams kdm;
    private final d kdn;
    private final f kdo;
    private final Resources mResources;
    private final Drawable kdl = new ColorDrawable(0);
    private final g kdp = new g(this.kdl);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.kdm = bVar.cGP();
        int size = (bVar.cGN() != null ? bVar.cGN().size() : 1) + (bVar.cGO() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.cGB(), bVar.cGC());
        drawableArr[2] = a(this.kdp, bVar.cGJ(), bVar.cGL(), bVar.cGK(), bVar.cGM());
        drawableArr[3] = a(bVar.cGH(), bVar.cGI());
        drawableArr[4] = a(bVar.cGD(), bVar.cGE());
        drawableArr[5] = a(bVar.cGF(), bVar.cGG());
        if (size > 0) {
            if (bVar.cGN() != null) {
                for (Drawable drawable : bVar.cGN()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.cGO() != null) {
                drawableArr[i + 6] = a(bVar.cGO(), null);
            }
        }
        this.kdo = new f(drawableArr);
        this.kdo.DF(bVar.cGz());
        this.kdn = new d(e.a(this.kdo, this.kdm));
        this.kdn.mutate();
        cGx();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable n.b bVar, @Nullable PointF pointF, @Nullable Matrix matrix, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(e.a(drawable, bVar, pointF), matrix);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable n.b bVar) {
        return e.b(e.a(drawable, this.kdm, this.mResources), bVar);
    }

    private void cGw() {
        this.kdp.h(this.kdl);
    }

    private void cGx() {
        if (this.kdo != null) {
            this.kdo.cGk();
            this.kdo.cGm();
            cGy();
            DG(1);
            this.kdo.cGn();
            this.kdo.cGl();
        }
    }

    private void cGy() {
        DH(1);
        DH(2);
        DH(3);
        DH(4);
        DH(5);
    }

    private void DG(int i) {
        if (i >= 0) {
            this.kdo.DG(i);
        }
    }

    private void DH(int i) {
        if (i >= 0) {
            this.kdo.DH(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.kdo.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                DH(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                DG(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.kdn;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        cGw();
        cGx();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.kdm, this.mResources);
        a.mutate();
        this.kdp.h(a);
        this.kdo.cGk();
        cGy();
        DG(2);
        setProgress(f);
        if (z) {
            this.kdo.cGn();
        }
        this.kdo.cGl();
    }

    @Override // com.facebook.drawee.d.c
    public void d(float f, boolean z) {
        if (this.kdo.getDrawable(3) != null) {
            this.kdo.cGk();
            setProgress(f);
            if (z) {
                this.kdo.cGn();
            }
            this.kdo.cGl();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void y(Throwable th) {
        this.kdo.cGk();
        cGy();
        if (this.kdo.getDrawable(5) != null) {
            DG(5);
        } else {
            DG(1);
        }
        this.kdo.cGl();
    }

    @Override // com.facebook.drawee.d.c
    public void z(Throwable th) {
        this.kdo.cGk();
        cGy();
        if (this.kdo.getDrawable(4) != null) {
            DG(4);
        } else {
            DG(1);
        }
        this.kdo.cGl();
    }

    @Override // com.facebook.drawee.d.c
    public void g(@Nullable Drawable drawable) {
        this.kdn.g(drawable);
    }

    private com.facebook.drawee.drawable.c DI(int i) {
        com.facebook.drawee.drawable.c DC = this.kdo.DC(i);
        if (DC.getDrawable() instanceof h) {
            DC = (h) DC.getDrawable();
        }
        if (DC.getDrawable() instanceof m) {
            return (m) DC.getDrawable();
        }
        return DC;
    }

    private m DJ(int i) {
        com.facebook.drawee.drawable.c DI = DI(i);
        return DI instanceof m ? (m) DI : e.a(DI, n.b.kdc);
    }

    public void b(n.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        DJ(2).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.kdm = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.kdn, this.kdm);
        for (int i = 0; i < this.kdo.cGh(); i++) {
            e.a(DI(i), this.kdm, this.mResources);
        }
    }
}
