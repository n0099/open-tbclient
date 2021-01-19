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
/* loaded from: classes3.dex */
public class a implements com.facebook.drawee.d.c {
    private final Resources mResources;
    @Nullable
    private RoundingParams ptt;
    private final d ptu;
    private final f ptv;
    private final Drawable ptr = new ColorDrawable(0);
    private final g ptw = new g(this.ptr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.ptt = bVar.esh();
        int size = (bVar.esw() != null ? bVar.esw().size() : 1) + (bVar.esx() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), (p.b) null);
        drawableArr[1] = a(bVar.esl(), bVar.esm());
        drawableArr[2] = a(this.ptw, bVar.est(), bVar.esu(), bVar.esv());
        drawableArr[3] = a(bVar.esr(), bVar.ess());
        drawableArr[4] = a(bVar.esn(), bVar.eso());
        drawableArr[5] = a(bVar.esp(), bVar.esq());
        if (size > 0) {
            if (bVar.esw() != null) {
                for (Drawable drawable : bVar.esw()) {
                    drawableArr[i + 6] = a(drawable, (p.b) null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.esx() != null) {
                drawableArr[i + 6] = a(bVar.esx(), (p.b) null);
            }
        }
        this.ptv = new f(drawableArr);
        this.ptv.OM(bVar.esi());
        this.ptu = new d(e.a(this.ptv, this.ptt));
        this.ptu.AX(bVar.esj());
        this.ptu.mutate();
        esf();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.d(e.a(drawable, this.ptt, this.mResources), bVar);
    }

    private void ese() {
        this.ptw.v(this.ptr);
    }

    private void esf() {
        if (this.ptv != null) {
            this.ptv.erT();
            this.ptv.erV();
            esg();
            ON(1);
            this.ptv.erW();
            this.ptv.erU();
        }
    }

    private void esg() {
        OO(1);
        OO(2);
        OO(3);
        OO(4);
        OO(5);
    }

    private void ON(int i) {
        if (i >= 0) {
            this.ptv.ON(i);
        }
    }

    private void OO(int i) {
        if (i >= 0) {
            this.ptv.OO(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.ptv.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                OO(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                ON(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.ptu;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        ese();
        esf();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a2 = e.a(drawable, this.ptt, this.mResources);
        a2.mutate();
        this.ptw.v(a2);
        this.ptv.erT();
        esg();
        ON(2);
        setProgress(f);
        if (z) {
            this.ptv.erW();
        }
        this.ptv.erU();
    }

    @Override // com.facebook.drawee.d.c
    public void d(float f, boolean z) {
        if (this.ptv.getDrawable(3) != null) {
            this.ptv.erT();
            setProgress(f);
            if (z) {
                this.ptv.erW();
            }
            this.ptv.erU();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void A(Throwable th) {
        this.ptv.erT();
        esg();
        if (this.ptv.getDrawable(5) != null) {
            ON(5);
        } else {
            ON(1);
        }
        this.ptv.erU();
    }

    @Override // com.facebook.drawee.d.c
    public void B(Throwable th) {
        this.ptv.erT();
        esg();
        if (this.ptv.getDrawable(4) != null) {
            ON(4);
        } else {
            ON(1);
        }
        this.ptv.erU();
    }

    @Override // com.facebook.drawee.d.c
    public void u(@Nullable Drawable drawable) {
        this.ptu.u(drawable);
    }

    private com.facebook.drawee.drawable.c OP(int i) {
        com.facebook.drawee.drawable.c OJ = this.ptv.OJ(i);
        if (OJ.getDrawable() instanceof h) {
            OJ = (h) OJ.getDrawable();
        }
        if (OJ.getDrawable() instanceof o) {
            return (o) OJ.getDrawable();
        }
        return OJ;
    }

    private void b(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.ptv.a(i, null);
            return;
        }
        OP(i).v(e.a(drawable, this.ptt, this.mResources));
    }

    private o OQ(int i) {
        com.facebook.drawee.drawable.c OP = OP(i);
        return OP instanceof o ? (o) OP : e.a(OP, p.b.pth);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        OQ(2).a(bVar);
    }

    public void A(@Nullable Drawable drawable) {
        b(1, drawable);
    }

    public void b(Drawable drawable, p.b bVar) {
        b(1, drawable);
        OQ(1).a(bVar);
    }

    public void OR(int i) {
        A(this.mResources.getDrawable(i));
    }

    public void a(int i, p.b bVar) {
        b(this.mResources.getDrawable(i), bVar);
    }

    public void c(Drawable drawable, p.b bVar) {
        b(5, drawable);
        OQ(5).a(bVar);
    }

    public void b(int i, p.b bVar) {
        c(this.mResources.getDrawable(i), bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.ptt = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.ptu, this.ptt);
        for (int i = 0; i < this.ptv.erQ(); i++) {
            e.a(OP(i), this.ptt, this.mResources);
        }
    }

    @Nullable
    public RoundingParams esh() {
        return this.ptt;
    }
}
