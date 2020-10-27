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
    private RoundingParams oGx;
    private final d oGy;
    private final f oGz;
    private final Drawable oGw = new ColorDrawable(0);
    private final g oGA = new g(this.oGw);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.oGx = bVar.ein();
        int size = (bVar.getOverlays() != null ? bVar.getOverlays().size() : 1) + (bVar.eiC() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), (p.b) null);
        drawableArr[1] = a(bVar.eir(), bVar.eis());
        drawableArr[2] = a(this.oGA, bVar.eiz(), bVar.eiA(), bVar.eiB());
        drawableArr[3] = a(bVar.eix(), bVar.eiy());
        drawableArr[4] = a(bVar.eit(), bVar.eiu());
        drawableArr[5] = a(bVar.eiv(), bVar.eiw());
        if (size > 0) {
            if (bVar.getOverlays() != null) {
                for (Drawable drawable : bVar.getOverlays()) {
                    drawableArr[i + 6] = a(drawable, (p.b) null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.eiC() != null) {
                drawableArr[i + 6] = a(bVar.eiC(), (p.b) null);
            }
        }
        this.oGz = new f(drawableArr);
        this.oGz.Oj(bVar.eio());
        this.oGy = new d(e.a(this.oGz, this.oGx));
        this.oGy.zY(bVar.eip());
        this.oGy.mutate();
        eil();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.f(e.a(drawable, this.oGx, this.mResources), bVar);
    }

    private void eik() {
        this.oGA.setDrawable(this.oGw);
    }

    private void eil() {
        if (this.oGz != null) {
            this.oGz.eia();
            this.oGz.eic();
            eim();
            Ok(1);
            this.oGz.eid();
            this.oGz.eib();
        }
    }

    private void eim() {
        Ol(1);
        Ol(2);
        Ol(3);
        Ol(4);
        Ol(5);
    }

    private void Ok(int i) {
        if (i >= 0) {
            this.oGz.Ok(i);
        }
    }

    private void Ol(int i) {
        if (i >= 0) {
            this.oGz.Ol(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.oGz.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                Ol(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                Ok(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.oGy;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        eik();
        eil();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a2 = e.a(drawable, this.oGx, this.mResources);
        a2.mutate();
        this.oGA.setDrawable(a2);
        this.oGz.eia();
        eim();
        Ok(2);
        setProgress(f);
        if (z) {
            this.oGz.eid();
        }
        this.oGz.eib();
    }

    @Override // com.facebook.drawee.d.c
    public void c(float f, boolean z) {
        if (this.oGz.getDrawable(3) != null) {
            this.oGz.eia();
            setProgress(f);
            if (z) {
                this.oGz.eid();
            }
            this.oGz.eib();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void B(Throwable th) {
        this.oGz.eia();
        eim();
        if (this.oGz.getDrawable(5) != null) {
            Ok(5);
        } else {
            Ok(1);
        }
        this.oGz.eib();
    }

    @Override // com.facebook.drawee.d.c
    public void C(Throwable th) {
        this.oGz.eia();
        eim();
        if (this.oGz.getDrawable(4) != null) {
            Ok(4);
        } else {
            Ok(1);
        }
        this.oGz.eib();
    }

    @Override // com.facebook.drawee.d.c
    public void o(@Nullable Drawable drawable) {
        this.oGy.o(drawable);
    }

    private com.facebook.drawee.drawable.c Om(int i) {
        com.facebook.drawee.drawable.c Og = this.oGz.Og(i);
        if (Og.getDrawable() instanceof h) {
            Og = (h) Og.getDrawable();
        }
        if (Og.getDrawable() instanceof o) {
            return (o) Og.getDrawable();
        }
        return Og;
    }

    private void b(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.oGz.a(i, null);
            return;
        }
        Om(i).setDrawable(e.a(drawable, this.oGx, this.mResources));
    }

    private o On(int i) {
        com.facebook.drawee.drawable.c Om = Om(i);
        return Om instanceof o ? (o) Om : e.a(Om, p.b.oGm);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        On(2).a(bVar);
    }

    public void r(@Nullable Drawable drawable) {
        b(1, drawable);
    }

    public void b(Drawable drawable, p.b bVar) {
        b(1, drawable);
        On(1).a(bVar);
    }

    public void Oo(int i) {
        r(this.mResources.getDrawable(i));
    }

    public void a(int i, p.b bVar) {
        b(this.mResources.getDrawable(i), bVar);
    }

    public void setFailureImage(@Nullable Drawable drawable) {
        b(5, drawable);
    }

    public void c(Drawable drawable, p.b bVar) {
        b(5, drawable);
        On(5).a(bVar);
    }

    public void Op(int i) {
        setFailureImage(this.mResources.getDrawable(i));
    }

    public void d(Drawable drawable, p.b bVar) {
        b(4, drawable);
        On(4).a(bVar);
    }

    public void e(Drawable drawable, p.b bVar) {
        b(3, drawable);
        On(3).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.oGx = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.oGy, this.oGx);
        for (int i = 0; i < this.oGz.ehX(); i++) {
            e.a(Om(i), this.oGx, this.mResources);
        }
    }

    @Nullable
    public RoundingParams ein() {
        return this.oGx;
    }
}
