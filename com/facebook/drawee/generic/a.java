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
    private RoundingParams keZ;
    private final d kfa;
    private final f kfb;
    private final Resources mResources;
    private final Drawable keY = new ColorDrawable(0);
    private final g kfc = new g(this.keY);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.keZ = bVar.cEW();
        int size = (bVar.cEU() != null ? bVar.cEU().size() : 1) + (bVar.cEV() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.cEI(), bVar.cEJ());
        drawableArr[2] = a(this.kfc, bVar.cEQ(), bVar.cES(), bVar.cER(), bVar.cET());
        drawableArr[3] = a(bVar.cEO(), bVar.cEP());
        drawableArr[4] = a(bVar.cEK(), bVar.cEL());
        drawableArr[5] = a(bVar.cEM(), bVar.cEN());
        if (size > 0) {
            if (bVar.cEU() != null) {
                for (Drawable drawable : bVar.cEU()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.cEV() != null) {
                drawableArr[i + 6] = a(bVar.cEV(), null);
            }
        }
        this.kfb = new f(drawableArr);
        this.kfb.Ch(bVar.cEG());
        this.kfa = new d(e.a(this.kfb, this.keZ));
        this.kfa.mutate();
        cEE();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable n.b bVar, @Nullable PointF pointF, @Nullable Matrix matrix, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(e.a(drawable, bVar, pointF), matrix);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable n.b bVar) {
        return e.b(e.a(drawable, this.keZ, this.mResources), bVar);
    }

    private void cED() {
        this.kfc.f(this.keY);
    }

    private void cEE() {
        if (this.kfb != null) {
            this.kfb.cEr();
            this.kfb.cEt();
            cEF();
            Ci(1);
            this.kfb.cEu();
            this.kfb.cEs();
        }
    }

    private void cEF() {
        Cj(1);
        Cj(2);
        Cj(3);
        Cj(4);
        Cj(5);
    }

    private void Ci(int i) {
        if (i >= 0) {
            this.kfb.Ci(i);
        }
    }

    private void Cj(int i) {
        if (i >= 0) {
            this.kfb.Cj(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.kfb.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                Cj(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                Ci(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.kfa;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        cED();
        cEE();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.keZ, this.mResources);
        a.mutate();
        this.kfc.f(a);
        this.kfb.cEr();
        cEF();
        Ci(2);
        setProgress(f);
        if (z) {
            this.kfb.cEu();
        }
        this.kfb.cEs();
    }

    @Override // com.facebook.drawee.d.c
    public void d(float f, boolean z) {
        if (this.kfb.getDrawable(3) != null) {
            this.kfb.cEr();
            setProgress(f);
            if (z) {
                this.kfb.cEu();
            }
            this.kfb.cEs();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void x(Throwable th) {
        this.kfb.cEr();
        cEF();
        if (this.kfb.getDrawable(5) != null) {
            Ci(5);
        } else {
            Ci(1);
        }
        this.kfb.cEs();
    }

    @Override // com.facebook.drawee.d.c
    public void y(Throwable th) {
        this.kfb.cEr();
        cEF();
        if (this.kfb.getDrawable(4) != null) {
            Ci(4);
        } else {
            Ci(1);
        }
        this.kfb.cEs();
    }

    @Override // com.facebook.drawee.d.c
    public void e(@Nullable Drawable drawable) {
        this.kfa.e(drawable);
    }

    private com.facebook.drawee.drawable.c Ck(int i) {
        com.facebook.drawee.drawable.c Ce = this.kfb.Ce(i);
        if (Ce.getDrawable() instanceof h) {
            Ce = (h) Ce.getDrawable();
        }
        if (Ce.getDrawable() instanceof m) {
            return (m) Ce.getDrawable();
        }
        return Ce;
    }

    private m Cl(int i) {
        com.facebook.drawee.drawable.c Ck = Ck(i);
        return Ck instanceof m ? (m) Ck : e.a(Ck, n.b.keP);
    }

    public void b(n.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        Cl(2).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.keZ = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.kfa, this.keZ);
        for (int i = 0; i < this.kfb.cEo(); i++) {
            e.a(Ck(i), this.keZ, this.mResources);
        }
    }
}
