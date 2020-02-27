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
    private RoundingParams lMW;
    private final d lMX;
    private final f lMY;
    private final Resources mResources;
    private final Drawable lMV = new ColorDrawable(0);
    private final g lMZ = new g(this.lMV);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.lMW = bVar.dmF();
        int size = (bVar.dmU() != null ? bVar.dmU().size() : 1) + (bVar.dmV() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.dmJ(), bVar.dmK());
        drawableArr[2] = a(this.lMZ, bVar.dmR(), bVar.dmS(), bVar.dmT());
        drawableArr[3] = a(bVar.dmP(), bVar.dmQ());
        drawableArr[4] = a(bVar.dmL(), bVar.dmM());
        drawableArr[5] = a(bVar.dmN(), bVar.dmO());
        if (size > 0) {
            if (bVar.dmU() != null) {
                for (Drawable drawable : bVar.dmU()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.dmV() != null) {
                drawableArr[i + 6] = a(bVar.dmV(), null);
            }
        }
        this.lMY = new f(drawableArr);
        this.lMY.HG(bVar.dmG());
        this.lMX = new d(e.a(this.lMY, this.lMW));
        this.lMX.vl(bVar.dmH());
        this.lMX.mutate();
        dmD();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.f(e.a(drawable, this.lMW, this.mResources), bVar);
    }

    private void dmC() {
        this.lMZ.setDrawable(this.lMV);
    }

    private void dmD() {
        if (this.lMY != null) {
            this.lMY.dms();
            this.lMY.dmu();
            dmE();
            HH(1);
            this.lMY.dmv();
            this.lMY.dmt();
        }
    }

    private void dmE() {
        HI(1);
        HI(2);
        HI(3);
        HI(4);
        HI(5);
    }

    private void HH(int i) {
        if (i >= 0) {
            this.lMY.HH(i);
        }
    }

    private void HI(int i) {
        if (i >= 0) {
            this.lMY.HI(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.lMY.getDrawable(3);
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
        return this.lMX;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        dmC();
        dmD();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.lMW, this.mResources);
        a.mutate();
        this.lMZ.setDrawable(a);
        this.lMY.dms();
        dmE();
        HH(2);
        setProgress(f);
        if (z) {
            this.lMY.dmv();
        }
        this.lMY.dmt();
    }

    @Override // com.facebook.drawee.d.c
    public void c(float f, boolean z) {
        if (this.lMY.getDrawable(3) != null) {
            this.lMY.dms();
            setProgress(f);
            if (z) {
                this.lMY.dmv();
            }
            this.lMY.dmt();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void z(Throwable th) {
        this.lMY.dms();
        dmE();
        if (this.lMY.getDrawable(5) != null) {
            HH(5);
        } else {
            HH(1);
        }
        this.lMY.dmt();
    }

    @Override // com.facebook.drawee.d.c
    public void A(Throwable th) {
        this.lMY.dms();
        dmE();
        if (this.lMY.getDrawable(4) != null) {
            HH(4);
        } else {
            HH(1);
        }
        this.lMY.dmt();
    }

    @Override // com.facebook.drawee.d.c
    public void n(@Nullable Drawable drawable) {
        this.lMX.n(drawable);
    }

    private com.facebook.drawee.drawable.c HJ(int i) {
        com.facebook.drawee.drawable.c HD = this.lMY.HD(i);
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
            this.lMY.a(i, null);
            return;
        }
        HJ(i).setDrawable(e.a(drawable, this.lMW, this.mResources));
    }

    private o HK(int i) {
        com.facebook.drawee.drawable.c HJ = HJ(i);
        return HJ instanceof o ? (o) HJ : e.a(HJ, p.b.lML);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        HK(2).a(bVar);
    }

    public void a(RectF rectF) {
        this.lMZ.getTransformedBounds(rectF);
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
        this.lMW = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.lMX, this.lMW);
        for (int i = 0; i < this.lMY.dmp(); i++) {
            e.a(HJ(i), this.lMW, this.mResources);
        }
    }

    @Nullable
    public RoundingParams dmF() {
        return this.lMW;
    }
}
