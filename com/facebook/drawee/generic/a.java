package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.f;
import com.facebook.drawee.drawable.g;
import com.facebook.drawee.drawable.h;
import com.facebook.drawee.drawable.o;
import com.facebook.drawee.drawable.p;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a implements com.facebook.drawee.d.c {
    @Nullable
    private RoundingParams lMY;
    private final d lMZ;
    private final f lNa;
    private final Resources mResources;
    private final Drawable lMX = new ColorDrawable(0);
    private final g lNb = new g(this.lMX);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.lMY = bVar.dmH();
        int size = (bVar.dmW() != null ? bVar.dmW().size() : 1) + (bVar.dmX() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.dmL(), bVar.dmM());
        drawableArr[2] = a(this.lNb, bVar.dmT(), bVar.dmU(), bVar.dmV());
        drawableArr[3] = a(bVar.dmR(), bVar.dmS());
        drawableArr[4] = a(bVar.dmN(), bVar.dmO());
        drawableArr[5] = a(bVar.dmP(), bVar.dmQ());
        if (size > 0) {
            if (bVar.dmW() != null) {
                for (Drawable drawable : bVar.dmW()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.dmX() != null) {
                drawableArr[i + 6] = a(bVar.dmX(), null);
            }
        }
        this.lNa = new f(drawableArr);
        this.lNa.HG(bVar.dmI());
        this.lMZ = new d(e.a(this.lNa, this.lMY));
        this.lMZ.vl(bVar.dmJ());
        this.lMZ.mutate();
        dmF();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.f(e.a(drawable, this.lMY, this.mResources), bVar);
    }

    private void dmE() {
        this.lNb.setDrawable(this.lMX);
    }

    private void dmF() {
        if (this.lNa != null) {
            this.lNa.dmu();
            this.lNa.dmw();
            dmG();
            HH(1);
            this.lNa.dmx();
            this.lNa.dmv();
        }
    }

    private void dmG() {
        HI(1);
        HI(2);
        HI(3);
        HI(4);
        HI(5);
    }

    private void HH(int i) {
        if (i >= 0) {
            this.lNa.HH(i);
        }
    }

    private void HI(int i) {
        if (i >= 0) {
            this.lNa.HI(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.lNa.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                HI(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                HH(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.lMZ;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        dmE();
        dmF();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.lMY, this.mResources);
        a.mutate();
        this.lNb.setDrawable(a);
        this.lNa.dmu();
        dmG();
        HH(2);
        setProgress(f);
        if (z) {
            this.lNa.dmx();
        }
        this.lNa.dmv();
    }

    @Override // com.facebook.drawee.d.c
    public void c(float f, boolean z) {
        if (this.lNa.getDrawable(3) != null) {
            this.lNa.dmu();
            setProgress(f);
            if (z) {
                this.lNa.dmx();
            }
            this.lNa.dmv();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void z(Throwable th) {
        this.lNa.dmu();
        dmG();
        if (this.lNa.getDrawable(5) != null) {
            HH(5);
        } else {
            HH(1);
        }
        this.lNa.dmv();
    }

    @Override // com.facebook.drawee.d.c
    public void A(Throwable th) {
        this.lNa.dmu();
        dmG();
        if (this.lNa.getDrawable(4) != null) {
            HH(4);
        } else {
            HH(1);
        }
        this.lNa.dmv();
    }

    @Override // com.facebook.drawee.d.c
    public void n(@Nullable Drawable drawable) {
        this.lMZ.n(drawable);
    }

    private com.facebook.drawee.drawable.c HJ(int i) {
        com.facebook.drawee.drawable.c HD = this.lNa.HD(i);
        if (HD.getDrawable() instanceof h) {
            HD = (h) HD.getDrawable();
        }
        if (HD.getDrawable() instanceof o) {
            return (o) HD.getDrawable();
        }
        return HD;
    }

    private void b(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.lNa.a(i, null);
            return;
        }
        HJ(i).setDrawable(e.a(drawable, this.lMY, this.mResources));
    }

    private o HK(int i) {
        com.facebook.drawee.drawable.c HJ = HJ(i);
        return HJ instanceof o ? (o) HJ : e.a(HJ, p.b.lMN);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        HK(2).a(bVar);
    }

    public void a(RectF rectF) {
        this.lNb.getTransformedBounds(rectF);
    }

    public void q(@Nullable Drawable drawable) {
        b(1, drawable);
    }

    public void b(Drawable drawable, p.b bVar) {
        b(1, drawable);
        HK(1).a(bVar);
    }

    public void HL(int i) {
        q(this.mResources.getDrawable(i));
    }

    public void setFailureImage(@Nullable Drawable drawable) {
        b(5, drawable);
    }

    public void c(Drawable drawable, p.b bVar) {
        b(5, drawable);
        HK(5).a(bVar);
    }

    public void HM(int i) {
        setFailureImage(this.mResources.getDrawable(i));
    }

    public void d(Drawable drawable, p.b bVar) {
        b(4, drawable);
        HK(4).a(bVar);
    }

    public void e(Drawable drawable, p.b bVar) {
        b(3, drawable);
        HK(3).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.lMY = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.lMZ, this.lMY);
        for (int i = 0; i < this.lNa.dmr(); i++) {
            e.a(HJ(i), this.lMY, this.mResources);
        }
    }

    @Nullable
    public RoundingParams dmH() {
        return this.lMY;
    }
}
