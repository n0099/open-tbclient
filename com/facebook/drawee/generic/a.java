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
/* loaded from: classes12.dex */
public class a implements com.facebook.drawee.d.c {
    @Nullable
    private RoundingParams lMk;
    private final d lMl;
    private final f lMm;
    private final Resources mResources;
    private final Drawable lMj = new ColorDrawable(0);
    private final g lMn = new g(this.lMj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.lMk = bVar.dlr();
        int size = (bVar.dlG() != null ? bVar.dlG().size() : 1) + (bVar.dlH() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.dlv(), bVar.dlw());
        drawableArr[2] = a(this.lMn, bVar.dlD(), bVar.dlE(), bVar.dlF());
        drawableArr[3] = a(bVar.dlB(), bVar.dlC());
        drawableArr[4] = a(bVar.dlx(), bVar.dly());
        drawableArr[5] = a(bVar.dlz(), bVar.dlA());
        if (size > 0) {
            if (bVar.dlG() != null) {
                for (Drawable drawable : bVar.dlG()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.dlH() != null) {
                drawableArr[i + 6] = a(bVar.dlH(), null);
            }
        }
        this.lMm = new f(drawableArr);
        this.lMm.HB(bVar.dls());
        this.lMl = new d(e.a(this.lMm, this.lMk));
        this.lMl.vh(bVar.dlt());
        this.lMl.mutate();
        dlp();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.f(e.a(drawable, this.lMk, this.mResources), bVar);
    }

    private void dlo() {
        this.lMn.setDrawable(this.lMj);
    }

    private void dlp() {
        if (this.lMm != null) {
            this.lMm.dld();
            this.lMm.dlf();
            dlq();
            HC(1);
            this.lMm.dlg();
            this.lMm.dle();
        }
    }

    private void dlq() {
        HD(1);
        HD(2);
        HD(3);
        HD(4);
        HD(5);
    }

    private void HC(int i) {
        if (i >= 0) {
            this.lMm.HC(i);
        }
    }

    private void HD(int i) {
        if (i >= 0) {
            this.lMm.HD(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.lMm.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                HD(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                HC(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.lMl;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        dlo();
        dlp();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.lMk, this.mResources);
        a.mutate();
        this.lMn.setDrawable(a);
        this.lMm.dld();
        dlq();
        HC(2);
        setProgress(f);
        if (z) {
            this.lMm.dlg();
        }
        this.lMm.dle();
    }

    @Override // com.facebook.drawee.d.c
    public void c(float f, boolean z) {
        if (this.lMm.getDrawable(3) != null) {
            this.lMm.dld();
            setProgress(f);
            if (z) {
                this.lMm.dlg();
            }
            this.lMm.dle();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void A(Throwable th) {
        this.lMm.dld();
        dlq();
        if (this.lMm.getDrawable(5) != null) {
            HC(5);
        } else {
            HC(1);
        }
        this.lMm.dle();
    }

    @Override // com.facebook.drawee.d.c
    public void B(Throwable th) {
        this.lMm.dld();
        dlq();
        if (this.lMm.getDrawable(4) != null) {
            HC(4);
        } else {
            HC(1);
        }
        this.lMm.dle();
    }

    @Override // com.facebook.drawee.d.c
    public void n(@Nullable Drawable drawable) {
        this.lMl.n(drawable);
    }

    private com.facebook.drawee.drawable.c HE(int i) {
        com.facebook.drawee.drawable.c Hy = this.lMm.Hy(i);
        if (Hy.getDrawable() instanceof h) {
            Hy = (h) Hy.getDrawable();
        }
        if (Hy.getDrawable() instanceof o) {
            return (o) Hy.getDrawable();
        }
        return Hy;
    }

    private void b(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.lMm.a(i, null);
            return;
        }
        HE(i).setDrawable(e.a(drawable, this.lMk, this.mResources));
    }

    private o HF(int i) {
        com.facebook.drawee.drawable.c HE = HE(i);
        return HE instanceof o ? (o) HE : e.a(HE, p.b.lLZ);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        HF(2).a(bVar);
    }

    public void a(RectF rectF) {
        this.lMn.getTransformedBounds(rectF);
    }

    public void q(@Nullable Drawable drawable) {
        b(1, drawable);
    }

    public void b(Drawable drawable, p.b bVar) {
        b(1, drawable);
        HF(1).a(bVar);
    }

    public void HG(int i) {
        q(this.mResources.getDrawable(i));
    }

    public void setFailureImage(@Nullable Drawable drawable) {
        b(5, drawable);
    }

    public void c(Drawable drawable, p.b bVar) {
        b(5, drawable);
        HF(5).a(bVar);
    }

    public void HH(int i) {
        setFailureImage(this.mResources.getDrawable(i));
    }

    public void d(Drawable drawable, p.b bVar) {
        b(4, drawable);
        HF(4).a(bVar);
    }

    public void e(Drawable drawable, p.b bVar) {
        b(3, drawable);
        HF(3).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.lMk = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.lMl, this.lMk);
        for (int i = 0; i < this.lMm.dla(); i++) {
            e.a(HE(i), this.lMk, this.mResources);
        }
    }

    @Nullable
    public RoundingParams dlr() {
        return this.lMk;
    }
}
