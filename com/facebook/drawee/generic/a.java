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
/* loaded from: classes15.dex */
public class a implements com.facebook.drawee.d.c {
    private final Resources mResources;
    @Nullable
    private RoundingParams pDB;
    private final d pDC;
    private final f pDD;
    private final Drawable pDA = new ColorDrawable(0);
    private final g pDE = new g(this.pDA);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.pDB = bVar.euz();
        int size = (bVar.euO() != null ? bVar.euO().size() : 1) + (bVar.euP() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), (p.b) null);
        drawableArr[1] = a(bVar.euD(), bVar.euE());
        drawableArr[2] = a(this.pDE, bVar.euL(), bVar.euM(), bVar.euN());
        drawableArr[3] = a(bVar.euJ(), bVar.euK());
        drawableArr[4] = a(bVar.euF(), bVar.euG());
        drawableArr[5] = a(bVar.euH(), bVar.euI());
        if (size > 0) {
            if (bVar.euO() != null) {
                for (Drawable drawable : bVar.euO()) {
                    drawableArr[i + 6] = a(drawable, (p.b) null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.euP() != null) {
                drawableArr[i + 6] = a(bVar.euP(), (p.b) null);
            }
        }
        this.pDD = new f(drawableArr);
        this.pDD.Ph(bVar.euA());
        this.pDC = new d(e.a(this.pDD, this.pDB));
        this.pDC.Bq(bVar.euB());
        this.pDC.mutate();
        eux();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.d(e.a(drawable, this.pDB, this.mResources), bVar);
    }

    private void euw() {
        this.pDE.v(this.pDA);
    }

    private void eux() {
        if (this.pDD != null) {
            this.pDD.eul();
            this.pDD.eun();
            euy();
            Pi(1);
            this.pDD.euo();
            this.pDD.eum();
        }
    }

    private void euy() {
        Pj(1);
        Pj(2);
        Pj(3);
        Pj(4);
        Pj(5);
    }

    private void Pi(int i) {
        if (i >= 0) {
            this.pDD.Pi(i);
        }
    }

    private void Pj(int i) {
        if (i >= 0) {
            this.pDD.Pj(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.pDD.getDrawable(3);
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
        return this.pDC;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        euw();
        eux();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a2 = e.a(drawable, this.pDB, this.mResources);
        a2.mutate();
        this.pDE.v(a2);
        this.pDD.eul();
        euy();
        Pi(2);
        setProgress(f);
        if (z) {
            this.pDD.euo();
        }
        this.pDD.eum();
    }

    @Override // com.facebook.drawee.d.c
    public void d(float f, boolean z) {
        if (this.pDD.getDrawable(3) != null) {
            this.pDD.eul();
            setProgress(f);
            if (z) {
                this.pDD.euo();
            }
            this.pDD.eum();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void z(Throwable th) {
        this.pDD.eul();
        euy();
        if (this.pDD.getDrawable(5) != null) {
            Pi(5);
        } else {
            Pi(1);
        }
        this.pDD.eum();
    }

    @Override // com.facebook.drawee.d.c
    public void A(Throwable th) {
        this.pDD.eul();
        euy();
        if (this.pDD.getDrawable(4) != null) {
            Pi(4);
        } else {
            Pi(1);
        }
        this.pDD.eum();
    }

    @Override // com.facebook.drawee.d.c
    public void u(@Nullable Drawable drawable) {
        this.pDC.u(drawable);
    }

    private com.facebook.drawee.drawable.c Pk(int i) {
        com.facebook.drawee.drawable.c Pe = this.pDD.Pe(i);
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
            this.pDD.a(i, null);
            return;
        }
        Pk(i).v(e.a(drawable, this.pDB, this.mResources));
    }

    private o Pl(int i) {
        com.facebook.drawee.drawable.c Pk = Pk(i);
        return Pk instanceof o ? (o) Pk : e.a(Pk, p.b.pDq);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        Pl(2).a(bVar);
    }

    public void A(@Nullable Drawable drawable) {
        b(1, drawable);
    }

    public void b(Drawable drawable, p.b bVar) {
        b(1, drawable);
        Pl(1).a(bVar);
    }

    public void Pm(int i) {
        A(this.mResources.getDrawable(i));
    }

    public void a(int i, p.b bVar) {
        b(this.mResources.getDrawable(i), bVar);
    }

    public void c(Drawable drawable, p.b bVar) {
        b(5, drawable);
        Pl(5).a(bVar);
    }

    public void b(int i, p.b bVar) {
        c(this.mResources.getDrawable(i), bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.pDB = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.pDC, this.pDB);
        for (int i = 0; i < this.pDD.eui(); i++) {
            e.a(Pk(i), this.pDB, this.mResources);
        }
    }

    @Nullable
    public RoundingParams euz() {
        return this.pDB;
    }
}
