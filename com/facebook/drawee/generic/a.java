package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.f;
import com.facebook.drawee.drawable.g;
import com.facebook.drawee.drawable.h;
import com.facebook.drawee.drawable.m;
import com.facebook.drawee.drawable.n;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements com.facebook.drawee.d.c {
    @Nullable
    private RoundingParams inc;
    private final d ind;
    private final f ine;
    private final Resources mResources;
    private final Drawable inb = new ColorDrawable(0);
    private final g inf = new g(this.inb);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.inc = bVar.bWc();
        int size = (bVar.bWa() != null ? bVar.bWa().size() : 1) + (bVar.bWb() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.bVO(), bVar.bVP());
        drawableArr[2] = a(this.inf, bVar.bVW(), bVar.bVY(), bVar.bVX(), bVar.bVZ());
        drawableArr[3] = a(bVar.bVU(), bVar.bVV());
        drawableArr[4] = a(bVar.bVQ(), bVar.bVR());
        drawableArr[5] = a(bVar.bVS(), bVar.bVT());
        if (size > 0) {
            if (bVar.bWa() != null) {
                for (Drawable drawable : bVar.bWa()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.bWb() != null) {
                drawableArr[i + 6] = a(bVar.bWb(), null);
            }
        }
        this.ine = new f(drawableArr);
        this.ine.yp(bVar.bVM());
        this.ind = new d(e.a(this.ine, this.inc));
        this.ind.mutate();
        bVK();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable n.b bVar, @Nullable PointF pointF, @Nullable Matrix matrix, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(e.a(drawable, bVar, pointF), matrix);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable n.b bVar) {
        return e.b(e.a(drawable, this.inc, this.mResources), bVar);
    }

    private void bVJ() {
        this.inf.h(this.inb);
    }

    private void bVK() {
        if (this.ine != null) {
            this.ine.bVy();
            this.ine.bVA();
            bVL();
            yq(1);
            this.ine.bVB();
            this.ine.bVz();
        }
    }

    private void bVL() {
        yr(1);
        yr(2);
        yr(3);
        yr(4);
        yr(5);
    }

    private void yq(int i) {
        if (i >= 0) {
            this.ine.yq(i);
        }
    }

    private void yr(int i) {
        if (i >= 0) {
            this.ine.yr(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.ine.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                yr(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                yq(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.ind;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        bVJ();
        bVK();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.inc, this.mResources);
        a.mutate();
        this.inf.h(a);
        this.ine.bVy();
        bVL();
        yq(2);
        setProgress(f);
        if (z) {
            this.ine.bVB();
        }
        this.ine.bVz();
    }

    @Override // com.facebook.drawee.d.c
    public void d(float f, boolean z) {
        if (this.ine.getDrawable(3) != null) {
            this.ine.bVy();
            setProgress(f);
            if (z) {
                this.ine.bVB();
            }
            this.ine.bVz();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void y(Throwable th) {
        this.ine.bVy();
        bVL();
        if (this.ine.getDrawable(5) != null) {
            yq(5);
        } else {
            yq(1);
        }
        this.ine.bVz();
    }

    @Override // com.facebook.drawee.d.c
    public void z(Throwable th) {
        this.ine.bVy();
        bVL();
        if (this.ine.getDrawable(4) != null) {
            yq(4);
        } else {
            yq(1);
        }
        this.ine.bVz();
    }

    @Override // com.facebook.drawee.d.c
    public void g(@Nullable Drawable drawable) {
        this.ind.g(drawable);
    }

    private com.facebook.drawee.drawable.c ys(int i) {
        com.facebook.drawee.drawable.c ym = this.ine.ym(i);
        if (ym.getDrawable() instanceof h) {
            ym = (h) ym.getDrawable();
        }
        if (ym.getDrawable() instanceof m) {
            return (m) ym.getDrawable();
        }
        return ym;
    }

    private m yt(int i) {
        com.facebook.drawee.drawable.c ys = ys(i);
        return ys instanceof m ? (m) ys : e.a(ys, n.b.imS);
    }

    public void b(n.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        yt(2).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.inc = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.ind, this.inc);
        for (int i = 0; i < this.ine.getNumberOfLayers(); i++) {
            e.a(ys(i), this.inc, this.mResources);
        }
    }
}
