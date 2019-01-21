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
    private RoundingParams iol;
    private final d iom;
    private final f ion;
    private final Resources mResources;
    private final Drawable iok = new ColorDrawable(0);
    private final g ioo = new g(this.iok);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.iol = bVar.bWK();
        int size = (bVar.bWI() != null ? bVar.bWI().size() : 1) + (bVar.bWJ() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.bWw(), bVar.bWx());
        drawableArr[2] = a(this.ioo, bVar.bWE(), bVar.bWG(), bVar.bWF(), bVar.bWH());
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
        this.ion = new f(drawableArr);
        this.ion.yr(bVar.bWu());
        this.iom = new d(e.a(this.ion, this.iol));
        this.iom.mutate();
        bWs();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable n.b bVar, @Nullable PointF pointF, @Nullable Matrix matrix, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(e.a(drawable, bVar, pointF), matrix);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable n.b bVar) {
        return e.b(e.a(drawable, this.iol, this.mResources), bVar);
    }

    private void bWr() {
        this.ioo.h(this.iok);
    }

    private void bWs() {
        if (this.ion != null) {
            this.ion.bWg();
            this.ion.bWi();
            bWt();
            ys(1);
            this.ion.bWj();
            this.ion.bWh();
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
            this.ion.ys(i);
        }
    }

    private void yt(int i) {
        if (i >= 0) {
            this.ion.yt(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.ion.getDrawable(3);
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
        return this.iom;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        bWr();
        bWs();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.iol, this.mResources);
        a.mutate();
        this.ioo.h(a);
        this.ion.bWg();
        bWt();
        ys(2);
        setProgress(f);
        if (z) {
            this.ion.bWj();
        }
        this.ion.bWh();
    }

    @Override // com.facebook.drawee.d.c
    public void d(float f, boolean z) {
        if (this.ion.getDrawable(3) != null) {
            this.ion.bWg();
            setProgress(f);
            if (z) {
                this.ion.bWj();
            }
            this.ion.bWh();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void y(Throwable th) {
        this.ion.bWg();
        bWt();
        if (this.ion.getDrawable(5) != null) {
            ys(5);
        } else {
            ys(1);
        }
        this.ion.bWh();
    }

    @Override // com.facebook.drawee.d.c
    public void z(Throwable th) {
        this.ion.bWg();
        bWt();
        if (this.ion.getDrawable(4) != null) {
            ys(4);
        } else {
            ys(1);
        }
        this.ion.bWh();
    }

    @Override // com.facebook.drawee.d.c
    public void g(@Nullable Drawable drawable) {
        this.iom.g(drawable);
    }

    private com.facebook.drawee.drawable.c yu(int i) {
        com.facebook.drawee.drawable.c yo = this.ion.yo(i);
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
        return yu instanceof m ? (m) yu : e.a(yu, n.b.iob);
    }

    public void b(n.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        yv(2).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.iol = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.iom, this.iol);
        for (int i = 0; i < this.ion.getNumberOfLayers(); i++) {
            e.a(yu(i), this.iol, this.mResources);
        }
    }
}
