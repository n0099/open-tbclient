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
    private RoundingParams lMp;
    private final d lMq;
    private final f lMr;
    private final Resources mResources;
    private final Drawable lMo = new ColorDrawable(0);
    private final g lMs = new g(this.lMo);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.lMp = bVar.dlt();
        int size = (bVar.dlI() != null ? bVar.dlI().size() : 1) + (bVar.dlJ() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.dlx(), bVar.dly());
        drawableArr[2] = a(this.lMs, bVar.dlF(), bVar.dlG(), bVar.dlH());
        drawableArr[3] = a(bVar.dlD(), bVar.dlE());
        drawableArr[4] = a(bVar.dlz(), bVar.dlA());
        drawableArr[5] = a(bVar.dlB(), bVar.dlC());
        if (size > 0) {
            if (bVar.dlI() != null) {
                for (Drawable drawable : bVar.dlI()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.dlJ() != null) {
                drawableArr[i + 6] = a(bVar.dlJ(), null);
            }
        }
        this.lMr = new f(drawableArr);
        this.lMr.HB(bVar.dlu());
        this.lMq = new d(e.a(this.lMr, this.lMp));
        this.lMq.vh(bVar.dlv());
        this.lMq.mutate();
        dlr();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.f(e.a(drawable, this.lMp, this.mResources), bVar);
    }

    private void dlq() {
        this.lMs.setDrawable(this.lMo);
    }

    private void dlr() {
        if (this.lMr != null) {
            this.lMr.dlf();
            this.lMr.dlh();
            dls();
            HC(1);
            this.lMr.dli();
            this.lMr.dlg();
        }
    }

    private void dls() {
        HD(1);
        HD(2);
        HD(3);
        HD(4);
        HD(5);
    }

    private void HC(int i) {
        if (i >= 0) {
            this.lMr.HC(i);
        }
    }

    private void HD(int i) {
        if (i >= 0) {
            this.lMr.HD(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.lMr.getDrawable(3);
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
        return this.lMq;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        dlq();
        dlr();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.lMp, this.mResources);
        a.mutate();
        this.lMs.setDrawable(a);
        this.lMr.dlf();
        dls();
        HC(2);
        setProgress(f);
        if (z) {
            this.lMr.dli();
        }
        this.lMr.dlg();
    }

    @Override // com.facebook.drawee.d.c
    public void c(float f, boolean z) {
        if (this.lMr.getDrawable(3) != null) {
            this.lMr.dlf();
            setProgress(f);
            if (z) {
                this.lMr.dli();
            }
            this.lMr.dlg();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void A(Throwable th) {
        this.lMr.dlf();
        dls();
        if (this.lMr.getDrawable(5) != null) {
            HC(5);
        } else {
            HC(1);
        }
        this.lMr.dlg();
    }

    @Override // com.facebook.drawee.d.c
    public void B(Throwable th) {
        this.lMr.dlf();
        dls();
        if (this.lMr.getDrawable(4) != null) {
            HC(4);
        } else {
            HC(1);
        }
        this.lMr.dlg();
    }

    @Override // com.facebook.drawee.d.c
    public void n(@Nullable Drawable drawable) {
        this.lMq.n(drawable);
    }

    private com.facebook.drawee.drawable.c HE(int i) {
        com.facebook.drawee.drawable.c Hy = this.lMr.Hy(i);
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
            this.lMr.a(i, null);
            return;
        }
        HE(i).setDrawable(e.a(drawable, this.lMp, this.mResources));
    }

    private o HF(int i) {
        com.facebook.drawee.drawable.c HE = HE(i);
        return HE instanceof o ? (o) HE : e.a(HE, p.b.lMe);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        HF(2).a(bVar);
    }

    public void a(RectF rectF) {
        this.lMs.getTransformedBounds(rectF);
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
        this.lMp = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.lMq, this.lMp);
        for (int i = 0; i < this.lMr.dlc(); i++) {
            e.a(HE(i), this.lMp, this.mResources);
        }
    }

    @Nullable
    public RoundingParams dlt() {
        return this.lMp;
    }
}
