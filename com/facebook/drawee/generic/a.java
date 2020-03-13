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
    private RoundingParams lNj;
    private final d lNk;
    private final f lNl;
    private final Resources mResources;
    private final Drawable lNi = new ColorDrawable(0);
    private final g lNm = new g(this.lNi);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.lNj = bVar.dmI();
        int size = (bVar.dmX() != null ? bVar.dmX().size() : 1) + (bVar.dmY() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.dmM(), bVar.dmN());
        drawableArr[2] = a(this.lNm, bVar.dmU(), bVar.dmV(), bVar.dmW());
        drawableArr[3] = a(bVar.dmS(), bVar.dmT());
        drawableArr[4] = a(bVar.dmO(), bVar.dmP());
        drawableArr[5] = a(bVar.dmQ(), bVar.dmR());
        if (size > 0) {
            if (bVar.dmX() != null) {
                for (Drawable drawable : bVar.dmX()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.dmY() != null) {
                drawableArr[i + 6] = a(bVar.dmY(), null);
            }
        }
        this.lNl = new f(drawableArr);
        this.lNl.HG(bVar.dmJ());
        this.lNk = new d(e.a(this.lNl, this.lNj));
        this.lNk.vl(bVar.dmK());
        this.lNk.mutate();
        dmG();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.f(e.a(drawable, this.lNj, this.mResources), bVar);
    }

    private void dmF() {
        this.lNm.setDrawable(this.lNi);
    }

    private void dmG() {
        if (this.lNl != null) {
            this.lNl.dmv();
            this.lNl.dmx();
            dmH();
            HH(1);
            this.lNl.dmy();
            this.lNl.dmw();
        }
    }

    private void dmH() {
        HI(1);
        HI(2);
        HI(3);
        HI(4);
        HI(5);
    }

    private void HH(int i) {
        if (i >= 0) {
            this.lNl.HH(i);
        }
    }

    private void HI(int i) {
        if (i >= 0) {
            this.lNl.HI(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.lNl.getDrawable(3);
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
        return this.lNk;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        dmF();
        dmG();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.lNj, this.mResources);
        a.mutate();
        this.lNm.setDrawable(a);
        this.lNl.dmv();
        dmH();
        HH(2);
        setProgress(f);
        if (z) {
            this.lNl.dmy();
        }
        this.lNl.dmw();
    }

    @Override // com.facebook.drawee.d.c
    public void c(float f, boolean z) {
        if (this.lNl.getDrawable(3) != null) {
            this.lNl.dmv();
            setProgress(f);
            if (z) {
                this.lNl.dmy();
            }
            this.lNl.dmw();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void z(Throwable th) {
        this.lNl.dmv();
        dmH();
        if (this.lNl.getDrawable(5) != null) {
            HH(5);
        } else {
            HH(1);
        }
        this.lNl.dmw();
    }

    @Override // com.facebook.drawee.d.c
    public void A(Throwable th) {
        this.lNl.dmv();
        dmH();
        if (this.lNl.getDrawable(4) != null) {
            HH(4);
        } else {
            HH(1);
        }
        this.lNl.dmw();
    }

    @Override // com.facebook.drawee.d.c
    public void n(@Nullable Drawable drawable) {
        this.lNk.n(drawable);
    }

    private com.facebook.drawee.drawable.c HJ(int i) {
        com.facebook.drawee.drawable.c HD = this.lNl.HD(i);
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
            this.lNl.a(i, null);
            return;
        }
        HJ(i).setDrawable(e.a(drawable, this.lNj, this.mResources));
    }

    private o HK(int i) {
        com.facebook.drawee.drawable.c HJ = HJ(i);
        return HJ instanceof o ? (o) HJ : e.a(HJ, p.b.lMY);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        HK(2).a(bVar);
    }

    public void a(RectF rectF) {
        this.lNm.getTransformedBounds(rectF);
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
        this.lNj = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.lNk, this.lNj);
        for (int i = 0; i < this.lNl.dms(); i++) {
            e.a(HJ(i), this.lNj, this.mResources);
        }
    }

    @Nullable
    public RoundingParams dmI() {
        return this.lNj;
    }
}
