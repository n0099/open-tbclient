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
    @Nullable
    private RoundingParams mNr;
    private final d mNs;
    private final f mNt;
    private final Resources mResources;
    private final Drawable mNq = new ColorDrawable(0);
    private final g mNu = new g(this.mNq);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.mNr = bVar.dBg();
        int size = (bVar.dBv() != null ? bVar.dBv().size() : 1) + (bVar.dBw() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.dBk(), bVar.dBl());
        drawableArr[2] = a(this.mNu, bVar.dBs(), bVar.dBt(), bVar.dBu());
        drawableArr[3] = a(bVar.dBq(), bVar.dBr());
        drawableArr[4] = a(bVar.dBm(), bVar.dBn());
        drawableArr[5] = a(bVar.dBo(), bVar.dBp());
        if (size > 0) {
            if (bVar.dBv() != null) {
                for (Drawable drawable : bVar.dBv()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.dBw() != null) {
                drawableArr[i + 6] = a(bVar.dBw(), null);
            }
        }
        this.mNt = new f(drawableArr);
        this.mNt.Ii(bVar.dBh());
        this.mNs = new d(e.a(this.mNt, this.mNr));
        this.mNs.wC(bVar.dBi());
        this.mNs.mutate();
        dBe();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.f(e.a(drawable, this.mNr, this.mResources), bVar);
    }

    private void dBd() {
        this.mNu.setDrawable(this.mNq);
    }

    private void dBe() {
        if (this.mNt != null) {
            this.mNt.dAT();
            this.mNt.dAV();
            dBf();
            Ij(1);
            this.mNt.dAW();
            this.mNt.dAU();
        }
    }

    private void dBf() {
        Ik(1);
        Ik(2);
        Ik(3);
        Ik(4);
        Ik(5);
    }

    private void Ij(int i) {
        if (i >= 0) {
            this.mNt.Ij(i);
        }
    }

    private void Ik(int i) {
        if (i >= 0) {
            this.mNt.Ik(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.mNt.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                Ik(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                Ij(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.mNs;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        dBd();
        dBe();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.mNr, this.mResources);
        a.mutate();
        this.mNu.setDrawable(a);
        this.mNt.dAT();
        dBf();
        Ij(2);
        setProgress(f);
        if (z) {
            this.mNt.dAW();
        }
        this.mNt.dAU();
    }

    @Override // com.facebook.drawee.d.c
    public void c(float f, boolean z) {
        if (this.mNt.getDrawable(3) != null) {
            this.mNt.dAT();
            setProgress(f);
            if (z) {
                this.mNt.dAW();
            }
            this.mNt.dAU();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void D(Throwable th) {
        this.mNt.dAT();
        dBf();
        if (this.mNt.getDrawable(5) != null) {
            Ij(5);
        } else {
            Ij(1);
        }
        this.mNt.dAU();
    }

    @Override // com.facebook.drawee.d.c
    public void E(Throwable th) {
        this.mNt.dAT();
        dBf();
        if (this.mNt.getDrawable(4) != null) {
            Ij(4);
        } else {
            Ij(1);
        }
        this.mNt.dAU();
    }

    @Override // com.facebook.drawee.d.c
    public void j(@Nullable Drawable drawable) {
        this.mNs.j(drawable);
    }

    private com.facebook.drawee.drawable.c Il(int i) {
        com.facebook.drawee.drawable.c If = this.mNt.If(i);
        if (If.getDrawable() instanceof h) {
            If = (h) If.getDrawable();
        }
        if (If.getDrawable() instanceof o) {
            return (o) If.getDrawable();
        }
        return If;
    }

    private void b(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.mNt.a(i, null);
            return;
        }
        Il(i).setDrawable(e.a(drawable, this.mNr, this.mResources));
    }

    private o Im(int i) {
        com.facebook.drawee.drawable.c Il = Il(i);
        return Il instanceof o ? (o) Il : e.a(Il, p.b.mNg);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        Im(2).a(bVar);
    }

    public void m(@Nullable Drawable drawable) {
        b(1, drawable);
    }

    public void b(Drawable drawable, p.b bVar) {
        b(1, drawable);
        Im(1).a(bVar);
    }

    public void In(int i) {
        m(this.mResources.getDrawable(i));
    }

    public void setFailureImage(@Nullable Drawable drawable) {
        b(5, drawable);
    }

    public void c(Drawable drawable, p.b bVar) {
        b(5, drawable);
        Im(5).a(bVar);
    }

    public void Io(int i) {
        setFailureImage(this.mResources.getDrawable(i));
    }

    public void d(Drawable drawable, p.b bVar) {
        b(4, drawable);
        Im(4).a(bVar);
    }

    public void e(Drawable drawable, p.b bVar) {
        b(3, drawable);
        Im(3).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.mNr = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.mNs, this.mNr);
        for (int i = 0; i < this.mNt.dAQ(); i++) {
            e.a(Il(i), this.mNr, this.mResources);
        }
    }

    @Nullable
    public RoundingParams dBg() {
        return this.mNr;
    }
}
