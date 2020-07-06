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
    private RoundingParams mNu;
    private final d mNv;
    private final f mNw;
    private final Resources mResources;
    private final Drawable mNt = new ColorDrawable(0);
    private final g mNx = new g(this.mNt);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.mNu = bVar.dBk();
        int size = (bVar.dBz() != null ? bVar.dBz().size() : 1) + (bVar.dBA() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.dBo(), bVar.dBp());
        drawableArr[2] = a(this.mNx, bVar.dBw(), bVar.dBx(), bVar.dBy());
        drawableArr[3] = a(bVar.dBu(), bVar.dBv());
        drawableArr[4] = a(bVar.dBq(), bVar.dBr());
        drawableArr[5] = a(bVar.dBs(), bVar.dBt());
        if (size > 0) {
            if (bVar.dBz() != null) {
                for (Drawable drawable : bVar.dBz()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.dBA() != null) {
                drawableArr[i + 6] = a(bVar.dBA(), null);
            }
        }
        this.mNw = new f(drawableArr);
        this.mNw.Ii(bVar.dBl());
        this.mNv = new d(e.a(this.mNw, this.mNu));
        this.mNv.wC(bVar.dBm());
        this.mNv.mutate();
        dBi();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.f(e.a(drawable, this.mNu, this.mResources), bVar);
    }

    private void dBh() {
        this.mNx.setDrawable(this.mNt);
    }

    private void dBi() {
        if (this.mNw != null) {
            this.mNw.dAX();
            this.mNw.dAZ();
            dBj();
            Ij(1);
            this.mNw.dBa();
            this.mNw.dAY();
        }
    }

    private void dBj() {
        Ik(1);
        Ik(2);
        Ik(3);
        Ik(4);
        Ik(5);
    }

    private void Ij(int i) {
        if (i >= 0) {
            this.mNw.Ij(i);
        }
    }

    private void Ik(int i) {
        if (i >= 0) {
            this.mNw.Ik(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.mNw.getDrawable(3);
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
        return this.mNv;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        dBh();
        dBi();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.mNu, this.mResources);
        a.mutate();
        this.mNx.setDrawable(a);
        this.mNw.dAX();
        dBj();
        Ij(2);
        setProgress(f);
        if (z) {
            this.mNw.dBa();
        }
        this.mNw.dAY();
    }

    @Override // com.facebook.drawee.d.c
    public void c(float f, boolean z) {
        if (this.mNw.getDrawable(3) != null) {
            this.mNw.dAX();
            setProgress(f);
            if (z) {
                this.mNw.dBa();
            }
            this.mNw.dAY();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void D(Throwable th) {
        this.mNw.dAX();
        dBj();
        if (this.mNw.getDrawable(5) != null) {
            Ij(5);
        } else {
            Ij(1);
        }
        this.mNw.dAY();
    }

    @Override // com.facebook.drawee.d.c
    public void E(Throwable th) {
        this.mNw.dAX();
        dBj();
        if (this.mNw.getDrawable(4) != null) {
            Ij(4);
        } else {
            Ij(1);
        }
        this.mNw.dAY();
    }

    @Override // com.facebook.drawee.d.c
    public void j(@Nullable Drawable drawable) {
        this.mNv.j(drawable);
    }

    private com.facebook.drawee.drawable.c Il(int i) {
        com.facebook.drawee.drawable.c If = this.mNw.If(i);
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
            this.mNw.a(i, null);
            return;
        }
        Il(i).setDrawable(e.a(drawable, this.mNu, this.mResources));
    }

    private o Im(int i) {
        com.facebook.drawee.drawable.c Il = Il(i);
        return Il instanceof o ? (o) Il : e.a(Il, p.b.mNj);
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
        this.mNu = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.mNv, this.mNu);
        for (int i = 0; i < this.mNw.dAU(); i++) {
            e.a(Il(i), this.mNu, this.mResources);
        }
    }

    @Nullable
    public RoundingParams dBk() {
        return this.mNu;
    }
}
