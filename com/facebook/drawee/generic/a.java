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
    private RoundingParams iok;
    private final d iol;
    private final f iom;
    private final Resources mResources;
    private final Drawable ioj = new ColorDrawable(0);
    private final g ion = new g(this.ioj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.iok = bVar.bWK();
        int size = (bVar.bWI() != null ? bVar.bWI().size() : 1) + (bVar.bWJ() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.bWw(), bVar.bWx());
        drawableArr[2] = a(this.ion, bVar.bWE(), bVar.bWG(), bVar.bWF(), bVar.bWH());
        drawableArr[3] = a(bVar.bWC(), bVar.bWD());
        drawableArr[4] = a(bVar.bWy(), bVar.bWz());
        drawableArr[5] = a(bVar.bWA(), bVar.bWB());
        if (size > 0) {
            if (bVar.bWI() != null) {
                for (Drawable drawable : bVar.bWI()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.bWJ() != null) {
                drawableArr[i + 6] = a(bVar.bWJ(), null);
            }
        }
        this.iom = new f(drawableArr);
        this.iom.yr(bVar.bWu());
        this.iol = new d(e.a(this.iom, this.iok));
        this.iol.mutate();
        bWs();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable n.b bVar, @Nullable PointF pointF, @Nullable Matrix matrix, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(e.a(drawable, bVar, pointF), matrix);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable n.b bVar) {
        return e.b(e.a(drawable, this.iok, this.mResources), bVar);
    }

    private void bWr() {
        this.ion.h(this.ioj);
    }

    private void bWs() {
        if (this.iom != null) {
            this.iom.bWg();
            this.iom.bWi();
            bWt();
            ys(1);
            this.iom.bWj();
            this.iom.bWh();
        }
    }

    private void bWt() {
        yt(1);
        yt(2);
        yt(3);
        yt(4);
        yt(5);
    }

    private void ys(int i) {
        if (i >= 0) {
            this.iom.ys(i);
        }
    }

    private void yt(int i) {
        if (i >= 0) {
            this.iom.yt(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.iom.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                yt(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                ys(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.iol;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        bWr();
        bWs();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.iok, this.mResources);
        a.mutate();
        this.ion.h(a);
        this.iom.bWg();
        bWt();
        ys(2);
        setProgress(f);
        if (z) {
            this.iom.bWj();
        }
        this.iom.bWh();
    }

    @Override // com.facebook.drawee.d.c
    public void d(float f, boolean z) {
        if (this.iom.getDrawable(3) != null) {
            this.iom.bWg();
            setProgress(f);
            if (z) {
                this.iom.bWj();
            }
            this.iom.bWh();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void y(Throwable th) {
        this.iom.bWg();
        bWt();
        if (this.iom.getDrawable(5) != null) {
            ys(5);
        } else {
            ys(1);
        }
        this.iom.bWh();
    }

    @Override // com.facebook.drawee.d.c
    public void z(Throwable th) {
        this.iom.bWg();
        bWt();
        if (this.iom.getDrawable(4) != null) {
            ys(4);
        } else {
            ys(1);
        }
        this.iom.bWh();
    }

    @Override // com.facebook.drawee.d.c
    public void g(@Nullable Drawable drawable) {
        this.iol.g(drawable);
    }

    private com.facebook.drawee.drawable.c yu(int i) {
        com.facebook.drawee.drawable.c yo = this.iom.yo(i);
        if (yo.getDrawable() instanceof h) {
            yo = (h) yo.getDrawable();
        }
        if (yo.getDrawable() instanceof m) {
            return (m) yo.getDrawable();
        }
        return yo;
    }

    private m yv(int i) {
        com.facebook.drawee.drawable.c yu = yu(i);
        return yu instanceof m ? (m) yu : e.a(yu, n.b.ioa);
    }

    public void b(n.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        yv(2).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.iok = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.iol, this.iok);
        for (int i = 0; i < this.iom.getNumberOfLayers(); i++) {
            e.a(yu(i), this.iok, this.mResources);
        }
    }
}
