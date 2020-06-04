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
/* loaded from: classes13.dex */
public class a implements com.facebook.drawee.d.c {
    private final Resources mResources;
    @Nullable
    private RoundingParams mrt;
    private final d mru;
    private final f mrv;
    private final Drawable mrs = new ColorDrawable(0);
    private final g mrw = new g(this.mrs);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.mrt = bVar.dwD();
        int size = (bVar.dwS() != null ? bVar.dwS().size() : 1) + (bVar.dwT() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.dwH(), bVar.dwI());
        drawableArr[2] = a(this.mrw, bVar.dwP(), bVar.dwQ(), bVar.dwR());
        drawableArr[3] = a(bVar.dwN(), bVar.dwO());
        drawableArr[4] = a(bVar.dwJ(), bVar.dwK());
        drawableArr[5] = a(bVar.dwL(), bVar.dwM());
        if (size > 0) {
            if (bVar.dwS() != null) {
                for (Drawable drawable : bVar.dwS()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.dwT() != null) {
                drawableArr[i + 6] = a(bVar.dwT(), null);
            }
        }
        this.mrv = new f(drawableArr);
        this.mrv.Hb(bVar.dwE());
        this.mru = new d(e.a(this.mrv, this.mrt));
        this.mru.wg(bVar.dwF());
        this.mru.mutate();
        dwB();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.f(e.a(drawable, this.mrt, this.mResources), bVar);
    }

    private void dwA() {
        this.mrw.setDrawable(this.mrs);
    }

    private void dwB() {
        if (this.mrv != null) {
            this.mrv.dwq();
            this.mrv.dws();
            dwC();
            Hc(1);
            this.mrv.dwt();
            this.mrv.dwr();
        }
    }

    private void dwC() {
        Hd(1);
        Hd(2);
        Hd(3);
        Hd(4);
        Hd(5);
    }

    private void Hc(int i) {
        if (i >= 0) {
            this.mrv.Hc(i);
        }
    }

    private void Hd(int i) {
        if (i >= 0) {
            this.mrv.Hd(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.mrv.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                Hd(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                Hc(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.mru;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        dwA();
        dwB();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.mrt, this.mResources);
        a.mutate();
        this.mrw.setDrawable(a);
        this.mrv.dwq();
        dwC();
        Hc(2);
        setProgress(f);
        if (z) {
            this.mrv.dwt();
        }
        this.mrv.dwr();
    }

    @Override // com.facebook.drawee.d.c
    public void c(float f, boolean z) {
        if (this.mrv.getDrawable(3) != null) {
            this.mrv.dwq();
            setProgress(f);
            if (z) {
                this.mrv.dwt();
            }
            this.mrv.dwr();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void D(Throwable th) {
        this.mrv.dwq();
        dwC();
        if (this.mrv.getDrawable(5) != null) {
            Hc(5);
        } else {
            Hc(1);
        }
        this.mrv.dwr();
    }

    @Override // com.facebook.drawee.d.c
    public void E(Throwable th) {
        this.mrv.dwq();
        dwC();
        if (this.mrv.getDrawable(4) != null) {
            Hc(4);
        } else {
            Hc(1);
        }
        this.mrv.dwr();
    }

    @Override // com.facebook.drawee.d.c
    public void j(@Nullable Drawable drawable) {
        this.mru.j(drawable);
    }

    private com.facebook.drawee.drawable.c He(int i) {
        com.facebook.drawee.drawable.c GY = this.mrv.GY(i);
        if (GY.getDrawable() instanceof h) {
            GY = (h) GY.getDrawable();
        }
        if (GY.getDrawable() instanceof o) {
            return (o) GY.getDrawable();
        }
        return GY;
    }

    private void b(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.mrv.a(i, null);
            return;
        }
        He(i).setDrawable(e.a(drawable, this.mrt, this.mResources));
    }

    private o Hf(int i) {
        com.facebook.drawee.drawable.c He = He(i);
        return He instanceof o ? (o) He : e.a(He, p.b.mri);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        Hf(2).a(bVar);
    }

    public void m(@Nullable Drawable drawable) {
        b(1, drawable);
    }

    public void b(Drawable drawable, p.b bVar) {
        b(1, drawable);
        Hf(1).a(bVar);
    }

    public void Hg(int i) {
        m(this.mResources.getDrawable(i));
    }

    public void setFailureImage(@Nullable Drawable drawable) {
        b(5, drawable);
    }

    public void c(Drawable drawable, p.b bVar) {
        b(5, drawable);
        Hf(5).a(bVar);
    }

    public void Hh(int i) {
        setFailureImage(this.mResources.getDrawable(i));
    }

    public void d(Drawable drawable, p.b bVar) {
        b(4, drawable);
        Hf(4).a(bVar);
    }

    public void e(Drawable drawable, p.b bVar) {
        b(3, drawable);
        Hf(3).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.mrt = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.mru, this.mrt);
        for (int i = 0; i < this.mrv.dwn(); i++) {
            e.a(He(i), this.mrt, this.mResources);
        }
    }

    @Nullable
    public RoundingParams dwD() {
        return this.mrt;
    }
}
