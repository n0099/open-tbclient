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
/* loaded from: classes4.dex */
public class a implements com.facebook.drawee.d.c {
    private final Resources mResources;
    @Nullable
    private RoundingParams npv;
    private final d npw;
    private final f npx;
    private final Drawable npu = new ColorDrawable(0);
    private final g npy = new g(this.npu);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.npv = bVar.dQx();
        int size = (bVar.getOverlays() != null ? bVar.getOverlays().size() : 1) + (bVar.dQM() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.dQB(), bVar.dQC());
        drawableArr[2] = a(this.npy, bVar.dQJ(), bVar.dQK(), bVar.dQL());
        drawableArr[3] = a(bVar.dQH(), bVar.dQI());
        drawableArr[4] = a(bVar.dQD(), bVar.dQE());
        drawableArr[5] = a(bVar.dQF(), bVar.dQG());
        if (size > 0) {
            if (bVar.getOverlays() != null) {
                for (Drawable drawable : bVar.getOverlays()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.dQM() != null) {
                drawableArr[i + 6] = a(bVar.dQM(), null);
            }
        }
        this.npx = new f(drawableArr);
        this.npx.Lh(bVar.dQy());
        this.npw = new d(e.a(this.npx, this.npv));
        this.npw.xY(bVar.dQz());
        this.npw.mutate();
        dQv();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.f(e.a(drawable, this.npv, this.mResources), bVar);
    }

    private void dQu() {
        this.npy.setDrawable(this.npu);
    }

    private void dQv() {
        if (this.npx != null) {
            this.npx.dQk();
            this.npx.dQm();
            dQw();
            Li(1);
            this.npx.dQn();
            this.npx.dQl();
        }
    }

    private void dQw() {
        Lj(1);
        Lj(2);
        Lj(3);
        Lj(4);
        Lj(5);
    }

    private void Li(int i) {
        if (i >= 0) {
            this.npx.Li(i);
        }
    }

    private void Lj(int i) {
        if (i >= 0) {
            this.npx.Lj(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.npx.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                Lj(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                Li(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.npw;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        dQu();
        dQv();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.npv, this.mResources);
        a.mutate();
        this.npy.setDrawable(a);
        this.npx.dQk();
        dQw();
        Li(2);
        setProgress(f);
        if (z) {
            this.npx.dQn();
        }
        this.npx.dQl();
    }

    @Override // com.facebook.drawee.d.c
    public void c(float f, boolean z) {
        if (this.npx.getDrawable(3) != null) {
            this.npx.dQk();
            setProgress(f);
            if (z) {
                this.npx.dQn();
            }
            this.npx.dQl();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void B(Throwable th) {
        this.npx.dQk();
        dQw();
        if (this.npx.getDrawable(5) != null) {
            Li(5);
        } else {
            Li(1);
        }
        this.npx.dQl();
    }

    @Override // com.facebook.drawee.d.c
    public void C(Throwable th) {
        this.npx.dQk();
        dQw();
        if (this.npx.getDrawable(4) != null) {
            Li(4);
        } else {
            Li(1);
        }
        this.npx.dQl();
    }

    @Override // com.facebook.drawee.d.c
    public void j(@Nullable Drawable drawable) {
        this.npw.j(drawable);
    }

    private com.facebook.drawee.drawable.c Lk(int i) {
        com.facebook.drawee.drawable.c Le = this.npx.Le(i);
        if (Le.getDrawable() instanceof h) {
            Le = (h) Le.getDrawable();
        }
        if (Le.getDrawable() instanceof o) {
            return (o) Le.getDrawable();
        }
        return Le;
    }

    private void b(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.npx.a(i, null);
            return;
        }
        Lk(i).setDrawable(e.a(drawable, this.npv, this.mResources));
    }

    private o Ll(int i) {
        com.facebook.drawee.drawable.c Lk = Lk(i);
        return Lk instanceof o ? (o) Lk : e.a(Lk, p.b.npk);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        Ll(2).a(bVar);
    }

    public void m(@Nullable Drawable drawable) {
        b(1, drawable);
    }

    public void b(Drawable drawable, p.b bVar) {
        b(1, drawable);
        Ll(1).a(bVar);
    }

    public void Lm(int i) {
        m(this.mResources.getDrawable(i));
    }

    public void setFailureImage(@Nullable Drawable drawable) {
        b(5, drawable);
    }

    public void c(Drawable drawable, p.b bVar) {
        b(5, drawable);
        Ll(5).a(bVar);
    }

    public void Ln(int i) {
        setFailureImage(this.mResources.getDrawable(i));
    }

    public void d(Drawable drawable, p.b bVar) {
        b(4, drawable);
        Ll(4).a(bVar);
    }

    public void e(Drawable drawable, p.b bVar) {
        b(3, drawable);
        Ll(3).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.npv = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.npw, this.npv);
        for (int i = 0; i < this.npx.dQh(); i++) {
            e.a(Lk(i), this.npv, this.mResources);
        }
    }

    @Nullable
    public RoundingParams dQx() {
        return this.npv;
    }
}
