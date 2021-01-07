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
    private RoundingParams pxT;
    private final d pxU;
    private final f pxV;
    private final Drawable pxS = new ColorDrawable(0);
    private final g pxW = new g(this.pxS);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.pxT = bVar.ewa();
        int size = (bVar.getOverlays() != null ? bVar.getOverlays().size() : 1) + (bVar.ewp() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), (p.b) null);
        drawableArr[1] = a(bVar.ewe(), bVar.ewf());
        drawableArr[2] = a(this.pxW, bVar.ewm(), bVar.ewn(), bVar.ewo());
        drawableArr[3] = a(bVar.ewk(), bVar.ewl());
        drawableArr[4] = a(bVar.ewg(), bVar.ewh());
        drawableArr[5] = a(bVar.ewi(), bVar.ewj());
        if (size > 0) {
            if (bVar.getOverlays() != null) {
                for (Drawable drawable : bVar.getOverlays()) {
                    drawableArr[i + 6] = a(drawable, (p.b) null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.ewp() != null) {
                drawableArr[i + 6] = a(bVar.ewp(), (p.b) null);
            }
        }
        this.pxV = new f(drawableArr);
        this.pxV.Qt(bVar.ewb());
        this.pxU = new d(e.a(this.pxV, this.pxT));
        this.pxU.Bb(bVar.ewc());
        this.pxU.mutate();
        evY();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.d(e.a(drawable, this.pxT, this.mResources), bVar);
    }

    private void evX() {
        this.pxW.v(this.pxS);
    }

    private void evY() {
        if (this.pxV != null) {
            this.pxV.evM();
            this.pxV.evO();
            evZ();
            Qu(1);
            this.pxV.evP();
            this.pxV.evN();
        }
    }

    private void evZ() {
        Qv(1);
        Qv(2);
        Qv(3);
        Qv(4);
        Qv(5);
    }

    private void Qu(int i) {
        if (i >= 0) {
            this.pxV.Qu(i);
        }
    }

    private void Qv(int i) {
        if (i >= 0) {
            this.pxV.Qv(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.pxV.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                Qv(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                Qu(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.pxU;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        evX();
        evY();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a2 = e.a(drawable, this.pxT, this.mResources);
        a2.mutate();
        this.pxW.v(a2);
        this.pxV.evM();
        evZ();
        Qu(2);
        setProgress(f);
        if (z) {
            this.pxV.evP();
        }
        this.pxV.evN();
    }

    @Override // com.facebook.drawee.d.c
    public void d(float f, boolean z) {
        if (this.pxV.getDrawable(3) != null) {
            this.pxV.evM();
            setProgress(f);
            if (z) {
                this.pxV.evP();
            }
            this.pxV.evN();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void A(Throwable th) {
        this.pxV.evM();
        evZ();
        if (this.pxV.getDrawable(5) != null) {
            Qu(5);
        } else {
            Qu(1);
        }
        this.pxV.evN();
    }

    @Override // com.facebook.drawee.d.c
    public void B(Throwable th) {
        this.pxV.evM();
        evZ();
        if (this.pxV.getDrawable(4) != null) {
            Qu(4);
        } else {
            Qu(1);
        }
        this.pxV.evN();
    }

    @Override // com.facebook.drawee.d.c
    public void u(@Nullable Drawable drawable) {
        this.pxU.u(drawable);
    }

    private com.facebook.drawee.drawable.c Qw(int i) {
        com.facebook.drawee.drawable.c Qq = this.pxV.Qq(i);
        if (Qq.getDrawable() instanceof h) {
            Qq = (h) Qq.getDrawable();
        }
        if (Qq.getDrawable() instanceof o) {
            return (o) Qq.getDrawable();
        }
        return Qq;
    }

    private void b(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.pxV.a(i, null);
            return;
        }
        Qw(i).v(e.a(drawable, this.pxT, this.mResources));
    }

    private o Qx(int i) {
        com.facebook.drawee.drawable.c Qw = Qw(i);
        return Qw instanceof o ? (o) Qw : e.a(Qw, p.b.pxI);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        Qx(2).a(bVar);
    }

    public void A(@Nullable Drawable drawable) {
        b(1, drawable);
    }

    public void b(Drawable drawable, p.b bVar) {
        b(1, drawable);
        Qx(1).a(bVar);
    }

    public void Qy(int i) {
        A(this.mResources.getDrawable(i));
    }

    public void a(int i, p.b bVar) {
        b(this.mResources.getDrawable(i), bVar);
    }

    public void c(Drawable drawable, p.b bVar) {
        b(5, drawable);
        Qx(5).a(bVar);
    }

    public void b(int i, p.b bVar) {
        c(this.mResources.getDrawable(i), bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.pxT = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.pxU, this.pxT);
        for (int i = 0; i < this.pxV.evJ(); i++) {
            e.a(Qw(i), this.pxT, this.mResources);
        }
    }

    @Nullable
    public RoundingParams ewa() {
        return this.pxT;
    }
}
