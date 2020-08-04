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
/* loaded from: classes9.dex */
public class a implements com.facebook.drawee.d.c {
    private final Resources mResources;
    @Nullable
    private RoundingParams mVF;
    private final d mVG;
    private final f mVH;
    private final Drawable mVE = new ColorDrawable(0);
    private final g mVI = new g(this.mVE);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.mVF = bVar.dEx();
        int size = (bVar.dEM() != null ? bVar.dEM().size() : 1) + (bVar.dEN() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.dEB(), bVar.dEC());
        drawableArr[2] = a(this.mVI, bVar.dEJ(), bVar.dEK(), bVar.dEL());
        drawableArr[3] = a(bVar.dEH(), bVar.dEI());
        drawableArr[4] = a(bVar.dED(), bVar.dEE());
        drawableArr[5] = a(bVar.dEF(), bVar.dEG());
        if (size > 0) {
            if (bVar.dEM() != null) {
                for (Drawable drawable : bVar.dEM()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.dEN() != null) {
                drawableArr[i + 6] = a(bVar.dEN(), null);
            }
        }
        this.mVH = new f(drawableArr);
        this.mVH.ID(bVar.dEy());
        this.mVG = new d(e.a(this.mVH, this.mVF));
        this.mVG.xh(bVar.dEz());
        this.mVG.mutate();
        dEv();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.f(e.a(drawable, this.mVF, this.mResources), bVar);
    }

    private void dEu() {
        this.mVI.setDrawable(this.mVE);
    }

    private void dEv() {
        if (this.mVH != null) {
            this.mVH.dEk();
            this.mVH.dEm();
            dEw();
            IE(1);
            this.mVH.dEn();
            this.mVH.dEl();
        }
    }

    private void dEw() {
        IF(1);
        IF(2);
        IF(3);
        IF(4);
        IF(5);
    }

    private void IE(int i) {
        if (i >= 0) {
            this.mVH.IE(i);
        }
    }

    private void IF(int i) {
        if (i >= 0) {
            this.mVH.IF(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.mVH.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                IF(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                IE(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.mVG;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        dEu();
        dEv();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.mVF, this.mResources);
        a.mutate();
        this.mVI.setDrawable(a);
        this.mVH.dEk();
        dEw();
        IE(2);
        setProgress(f);
        if (z) {
            this.mVH.dEn();
        }
        this.mVH.dEl();
    }

    @Override // com.facebook.drawee.d.c
    public void c(float f, boolean z) {
        if (this.mVH.getDrawable(3) != null) {
            this.mVH.dEk();
            setProgress(f);
            if (z) {
                this.mVH.dEn();
            }
            this.mVH.dEl();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void C(Throwable th) {
        this.mVH.dEk();
        dEw();
        if (this.mVH.getDrawable(5) != null) {
            IE(5);
        } else {
            IE(1);
        }
        this.mVH.dEl();
    }

    @Override // com.facebook.drawee.d.c
    public void D(Throwable th) {
        this.mVH.dEk();
        dEw();
        if (this.mVH.getDrawable(4) != null) {
            IE(4);
        } else {
            IE(1);
        }
        this.mVH.dEl();
    }

    @Override // com.facebook.drawee.d.c
    public void j(@Nullable Drawable drawable) {
        this.mVG.j(drawable);
    }

    private com.facebook.drawee.drawable.c IG(int i) {
        com.facebook.drawee.drawable.c IA = this.mVH.IA(i);
        if (IA.getDrawable() instanceof h) {
            IA = (h) IA.getDrawable();
        }
        if (IA.getDrawable() instanceof o) {
            return (o) IA.getDrawable();
        }
        return IA;
    }

    private void b(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.mVH.a(i, null);
            return;
        }
        IG(i).setDrawable(e.a(drawable, this.mVF, this.mResources));
    }

    private o IH(int i) {
        com.facebook.drawee.drawable.c IG = IG(i);
        return IG instanceof o ? (o) IG : e.a(IG, p.b.mVu);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        IH(2).a(bVar);
    }

    public void m(@Nullable Drawable drawable) {
        b(1, drawable);
    }

    public void b(Drawable drawable, p.b bVar) {
        b(1, drawable);
        IH(1).a(bVar);
    }

    public void II(int i) {
        m(this.mResources.getDrawable(i));
    }

    public void setFailureImage(@Nullable Drawable drawable) {
        b(5, drawable);
    }

    public void c(Drawable drawable, p.b bVar) {
        b(5, drawable);
        IH(5).a(bVar);
    }

    public void IJ(int i) {
        setFailureImage(this.mResources.getDrawable(i));
    }

    public void d(Drawable drawable, p.b bVar) {
        b(4, drawable);
        IH(4).a(bVar);
    }

    public void e(Drawable drawable, p.b bVar) {
        b(3, drawable);
        IH(3).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.mVF = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.mVG, this.mVF);
        for (int i = 0; i < this.mVH.dEh(); i++) {
            e.a(IG(i), this.mVF, this.mResources);
        }
    }

    @Nullable
    public RoundingParams dEx() {
        return this.mVF;
    }
}
