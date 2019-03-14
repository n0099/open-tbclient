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
    private RoundingParams jDW;
    private final d jDX;
    private final f jDY;
    private final Resources mResources;
    private final Drawable jDV = new ColorDrawable(0);
    private final g jDZ = new g(this.jDV);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.jDW = bVar.cvW();
        int size = (bVar.cvU() != null ? bVar.cvU().size() : 1) + (bVar.cvV() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.cvI(), bVar.cvJ());
        drawableArr[2] = a(this.jDZ, bVar.cvQ(), bVar.cvS(), bVar.cvR(), bVar.cvT());
        drawableArr[3] = a(bVar.cvO(), bVar.cvP());
        drawableArr[4] = a(bVar.cvK(), bVar.cvL());
        drawableArr[5] = a(bVar.cvM(), bVar.cvN());
        if (size > 0) {
            if (bVar.cvU() != null) {
                for (Drawable drawable : bVar.cvU()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.cvV() != null) {
                drawableArr[i + 6] = a(bVar.cvV(), null);
            }
        }
        this.jDY = new f(drawableArr);
        this.jDY.Ce(bVar.cvG());
        this.jDX = new d(e.a(this.jDY, this.jDW));
        this.jDX.mutate();
        cvE();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable n.b bVar, @Nullable PointF pointF, @Nullable Matrix matrix, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(e.a(drawable, bVar, pointF), matrix);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable n.b bVar) {
        return e.b(e.a(drawable, this.jDW, this.mResources), bVar);
    }

    private void cvD() {
        this.jDZ.i(this.jDV);
    }

    private void cvE() {
        if (this.jDY != null) {
            this.jDY.cvs();
            this.jDY.cvu();
            cvF();
            Cf(1);
            this.jDY.cvv();
            this.jDY.cvt();
        }
    }

    private void cvF() {
        Cg(1);
        Cg(2);
        Cg(3);
        Cg(4);
        Cg(5);
    }

    private void Cf(int i) {
        if (i >= 0) {
            this.jDY.Cf(i);
        }
    }

    private void Cg(int i) {
        if (i >= 0) {
            this.jDY.Cg(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.jDY.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                Cg(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                Cf(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.jDX;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        cvD();
        cvE();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.jDW, this.mResources);
        a.mutate();
        this.jDZ.i(a);
        this.jDY.cvs();
        cvF();
        Cf(2);
        setProgress(f);
        if (z) {
            this.jDY.cvv();
        }
        this.jDY.cvt();
    }

    @Override // com.facebook.drawee.d.c
    public void d(float f, boolean z) {
        if (this.jDY.getDrawable(3) != null) {
            this.jDY.cvs();
            setProgress(f);
            if (z) {
                this.jDY.cvv();
            }
            this.jDY.cvt();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void z(Throwable th) {
        this.jDY.cvs();
        cvF();
        if (this.jDY.getDrawable(5) != null) {
            Cf(5);
        } else {
            Cf(1);
        }
        this.jDY.cvt();
    }

    @Override // com.facebook.drawee.d.c
    public void A(Throwable th) {
        this.jDY.cvs();
        cvF();
        if (this.jDY.getDrawable(4) != null) {
            Cf(4);
        } else {
            Cf(1);
        }
        this.jDY.cvt();
    }

    @Override // com.facebook.drawee.d.c
    public void h(@Nullable Drawable drawable) {
        this.jDX.h(drawable);
    }

    private com.facebook.drawee.drawable.c Ch(int i) {
        com.facebook.drawee.drawable.c Cb = this.jDY.Cb(i);
        if (Cb.getDrawable() instanceof h) {
            Cb = (h) Cb.getDrawable();
        }
        if (Cb.getDrawable() instanceof m) {
            return (m) Cb.getDrawable();
        }
        return Cb;
    }

    private m Ci(int i) {
        com.facebook.drawee.drawable.c Ch = Ch(i);
        return Ch instanceof m ? (m) Ch : e.a(Ch, n.b.jDM);
    }

    public void b(n.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        Ci(2).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.jDW = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.jDX, this.jDW);
        for (int i = 0; i < this.jDY.getNumberOfLayers(); i++) {
            e.a(Ch(i), this.jDW, this.mResources);
        }
    }
}
