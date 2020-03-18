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
    private RoundingParams lOP;
    private final d lOQ;
    private final f lOR;
    private final Resources mResources;
    private final Drawable lOO = new ColorDrawable(0);
    private final g lOS = new g(this.lOO);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.lOP = bVar.dnf();
        int size = (bVar.dnv() != null ? bVar.dnv().size() : 1) + (bVar.dnw() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.dnj(), bVar.dnk());
        drawableArr[2] = a(this.lOS, bVar.dnr(), bVar.dnt(), bVar.dnu());
        drawableArr[3] = a(bVar.dnp(), bVar.dnq());
        drawableArr[4] = a(bVar.dnl(), bVar.dnm());
        drawableArr[5] = a(bVar.dnn(), bVar.dno());
        if (size > 0) {
            if (bVar.dnv() != null) {
                for (Drawable drawable : bVar.dnv()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.dnw() != null) {
                drawableArr[i + 6] = a(bVar.dnw(), null);
            }
        }
        this.lOR = new f(drawableArr);
        this.lOR.HM(bVar.dng());
        this.lOQ = new d(e.a(this.lOR, this.lOP));
        this.lOQ.vs(bVar.dnh());
        this.lOQ.mutate();
        dnd();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.f(e.a(drawable, this.lOP, this.mResources), bVar);
    }

    private void dnc() {
        this.lOS.setDrawable(this.lOO);
    }

    private void dnd() {
        if (this.lOR != null) {
            this.lOR.dmS();
            this.lOR.dmU();
            dne();
            HN(1);
            this.lOR.dmV();
            this.lOR.dmT();
        }
    }

    private void dne() {
        HO(1);
        HO(2);
        HO(3);
        HO(4);
        HO(5);
    }

    private void HN(int i) {
        if (i >= 0) {
            this.lOR.HN(i);
        }
    }

    private void HO(int i) {
        if (i >= 0) {
            this.lOR.HO(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.lOR.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                HO(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                HN(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.lOQ;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        dnc();
        dnd();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.lOP, this.mResources);
        a.mutate();
        this.lOS.setDrawable(a);
        this.lOR.dmS();
        dne();
        HN(2);
        setProgress(f);
        if (z) {
            this.lOR.dmV();
        }
        this.lOR.dmT();
    }

    @Override // com.facebook.drawee.d.c
    public void c(float f, boolean z) {
        if (this.lOR.getDrawable(3) != null) {
            this.lOR.dmS();
            setProgress(f);
            if (z) {
                this.lOR.dmV();
            }
            this.lOR.dmT();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void z(Throwable th) {
        this.lOR.dmS();
        dne();
        if (this.lOR.getDrawable(5) != null) {
            HN(5);
        } else {
            HN(1);
        }
        this.lOR.dmT();
    }

    @Override // com.facebook.drawee.d.c
    public void A(Throwable th) {
        this.lOR.dmS();
        dne();
        if (this.lOR.getDrawable(4) != null) {
            HN(4);
        } else {
            HN(1);
        }
        this.lOR.dmT();
    }

    @Override // com.facebook.drawee.d.c
    public void n(@Nullable Drawable drawable) {
        this.lOQ.n(drawable);
    }

    private com.facebook.drawee.drawable.c HP(int i) {
        com.facebook.drawee.drawable.c HJ = this.lOR.HJ(i);
        if (HJ.getDrawable() instanceof h) {
            HJ = (h) HJ.getDrawable();
        }
        if (HJ.getDrawable() instanceof o) {
            return (o) HJ.getDrawable();
        }
        return HJ;
    }

    private void b(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.lOR.a(i, null);
            return;
        }
        HP(i).setDrawable(e.a(drawable, this.lOP, this.mResources));
    }

    private o HQ(int i) {
        com.facebook.drawee.drawable.c HP = HP(i);
        return HP instanceof o ? (o) HP : e.a(HP, p.b.lOE);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        HQ(2).a(bVar);
    }

    public void a(RectF rectF) {
        this.lOS.getTransformedBounds(rectF);
    }

    public void q(@Nullable Drawable drawable) {
        b(1, drawable);
    }

    public void b(Drawable drawable, p.b bVar) {
        b(1, drawable);
        HQ(1).a(bVar);
    }

    public void HR(int i) {
        q(this.mResources.getDrawable(i));
    }

    public void setFailureImage(@Nullable Drawable drawable) {
        b(5, drawable);
    }

    public void c(Drawable drawable, p.b bVar) {
        b(5, drawable);
        HQ(5).a(bVar);
    }

    public void HS(int i) {
        setFailureImage(this.mResources.getDrawable(i));
    }

    public void d(Drawable drawable, p.b bVar) {
        b(4, drawable);
        HQ(4).a(bVar);
    }

    public void e(Drawable drawable, p.b bVar) {
        b(3, drawable);
        HQ(3).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.lOP = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.lOQ, this.lOP);
        for (int i = 0; i < this.lOR.dmP(); i++) {
            e.a(HP(i), this.lOP, this.mResources);
        }
    }

    @Nullable
    public RoundingParams dnf() {
        return this.lOP;
    }
}
