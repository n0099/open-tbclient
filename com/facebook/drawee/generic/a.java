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
/* loaded from: classes11.dex */
public class a implements com.facebook.drawee.d.c {
    @Nullable
    private RoundingParams lIN;
    private final d lIO;
    private final f lIP;
    private final Resources mResources;
    private final Drawable lIM = new ColorDrawable(0);
    private final g lIQ = new g(this.lIM);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.lIN = bVar.dkG();
        int size = (bVar.dkE() != null ? bVar.dkE().size() : 1) + (bVar.dkF() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.dkt(), bVar.dku());
        drawableArr[2] = a(this.lIQ, bVar.dkB(), bVar.dkC(), bVar.dkD());
        drawableArr[3] = a(bVar.dkz(), bVar.dkA());
        drawableArr[4] = a(bVar.dkv(), bVar.dkw());
        drawableArr[5] = a(bVar.dkx(), bVar.dky());
        if (size > 0) {
            if (bVar.dkE() != null) {
                for (Drawable drawable : bVar.dkE()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.dkF() != null) {
                drawableArr[i + 6] = a(bVar.dkF(), null);
            }
        }
        this.lIP = new f(drawableArr);
        this.lIP.Hw(bVar.dkq());
        this.lIO = new d(e.a(this.lIP, this.lIN));
        this.lIO.uV(bVar.dkr());
        this.lIO.mutate();
        dko();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.b(e.a(drawable, this.lIN, this.mResources), bVar);
    }

    private void dkn() {
        this.lIQ.setDrawable(this.lIM);
    }

    private void dko() {
        if (this.lIP != null) {
            this.lIP.dkc();
            this.lIP.dke();
            dkp();
            Hx(1);
            this.lIP.dkf();
            this.lIP.dkd();
        }
    }

    private void dkp() {
        Hy(1);
        Hy(2);
        Hy(3);
        Hy(4);
        Hy(5);
    }

    private void Hx(int i) {
        if (i >= 0) {
            this.lIP.Hx(i);
        }
    }

    private void Hy(int i) {
        if (i >= 0) {
            this.lIP.Hy(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.lIP.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                Hy(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                Hx(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.lIO;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        dkn();
        dko();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.lIN, this.mResources);
        a.mutate();
        this.lIQ.setDrawable(a);
        this.lIP.dkc();
        dkp();
        Hx(2);
        setProgress(f);
        if (z) {
            this.lIP.dkf();
        }
        this.lIP.dkd();
    }

    @Override // com.facebook.drawee.d.c
    public void c(float f, boolean z) {
        if (this.lIP.getDrawable(3) != null) {
            this.lIP.dkc();
            setProgress(f);
            if (z) {
                this.lIP.dkf();
            }
            this.lIP.dkd();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void A(Throwable th) {
        this.lIP.dkc();
        dkp();
        if (this.lIP.getDrawable(5) != null) {
            Hx(5);
        } else {
            Hx(1);
        }
        this.lIP.dkd();
    }

    @Override // com.facebook.drawee.d.c
    public void B(Throwable th) {
        this.lIP.dkc();
        dkp();
        if (this.lIP.getDrawable(4) != null) {
            Hx(4);
        } else {
            Hx(1);
        }
        this.lIP.dkd();
    }

    @Override // com.facebook.drawee.d.c
    public void n(@Nullable Drawable drawable) {
        this.lIO.n(drawable);
    }

    private com.facebook.drawee.drawable.c Hz(int i) {
        com.facebook.drawee.drawable.c Ht = this.lIP.Ht(i);
        if (Ht.getDrawable() instanceof h) {
            Ht = (h) Ht.getDrawable();
        }
        if (Ht.getDrawable() instanceof o) {
            return (o) Ht.getDrawable();
        }
        return Ht;
    }

    private void b(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.lIP.a(i, null);
            return;
        }
        Hz(i).setDrawable(e.a(drawable, this.lIN, this.mResources));
    }

    private o HA(int i) {
        com.facebook.drawee.drawable.c Hz = Hz(i);
        return Hz instanceof o ? (o) Hz : e.a(Hz, p.b.lIC);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        HA(2).a(bVar);
    }

    public void a(RectF rectF) {
        this.lIQ.getTransformedBounds(rectF);
    }

    public void q(@Nullable Drawable drawable) {
        b(1, drawable);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.lIN = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.lIO, this.lIN);
        for (int i = 0; i < this.lIP.djZ(); i++) {
            e.a(Hz(i), this.lIN, this.mResources);
        }
    }
}
