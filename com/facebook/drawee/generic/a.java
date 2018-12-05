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
    private RoundingParams ijR;
    private final d ijS;
    private final f ijT;
    private final Resources mResources;
    private final Drawable ijQ = new ColorDrawable(0);
    private final g ijU = new g(this.ijQ);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.ijR = bVar.bVm();
        int size = (bVar.bVk() != null ? bVar.bVk().size() : 1) + (bVar.bVl() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.bUY(), bVar.bUZ());
        drawableArr[2] = a(this.ijU, bVar.bVg(), bVar.bVi(), bVar.bVh(), bVar.bVj());
        drawableArr[3] = a(bVar.bVe(), bVar.bVf());
        drawableArr[4] = a(bVar.bVa(), bVar.bVb());
        drawableArr[5] = a(bVar.bVc(), bVar.bVd());
        if (size > 0) {
            if (bVar.bVk() != null) {
                for (Drawable drawable : bVar.bVk()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.bVl() != null) {
                drawableArr[i + 6] = a(bVar.bVl(), null);
            }
        }
        this.ijT = new f(drawableArr);
        this.ijT.yc(bVar.bUW());
        this.ijS = new d(e.a(this.ijT, this.ijR));
        this.ijS.mutate();
        bUU();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable n.b bVar, @Nullable PointF pointF, @Nullable Matrix matrix, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(e.a(drawable, bVar, pointF), matrix);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable n.b bVar) {
        return e.b(e.a(drawable, this.ijR, this.mResources), bVar);
    }

    private void bUT() {
        this.ijU.h(this.ijQ);
    }

    private void bUU() {
        if (this.ijT != null) {
            this.ijT.bUI();
            this.ijT.bUK();
            bUV();
            yd(1);
            this.ijT.bUL();
            this.ijT.bUJ();
        }
    }

    private void bUV() {
        ye(1);
        ye(2);
        ye(3);
        ye(4);
        ye(5);
    }

    private void yd(int i) {
        if (i >= 0) {
            this.ijT.yd(i);
        }
    }

    private void ye(int i) {
        if (i >= 0) {
            this.ijT.ye(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.ijT.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                ye(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                yd(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.ijS;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        bUT();
        bUU();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.ijR, this.mResources);
        a.mutate();
        this.ijU.h(a);
        this.ijT.bUI();
        bUV();
        yd(2);
        setProgress(f);
        if (z) {
            this.ijT.bUL();
        }
        this.ijT.bUJ();
    }

    @Override // com.facebook.drawee.d.c
    public void d(float f, boolean z) {
        if (this.ijT.getDrawable(3) != null) {
            this.ijT.bUI();
            setProgress(f);
            if (z) {
                this.ijT.bUL();
            }
            this.ijT.bUJ();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void y(Throwable th) {
        this.ijT.bUI();
        bUV();
        if (this.ijT.getDrawable(5) != null) {
            yd(5);
        } else {
            yd(1);
        }
        this.ijT.bUJ();
    }

    @Override // com.facebook.drawee.d.c
    public void z(Throwable th) {
        this.ijT.bUI();
        bUV();
        if (this.ijT.getDrawable(4) != null) {
            yd(4);
        } else {
            yd(1);
        }
        this.ijT.bUJ();
    }

    @Override // com.facebook.drawee.d.c
    public void g(@Nullable Drawable drawable) {
        this.ijS.g(drawable);
    }

    private com.facebook.drawee.drawable.c yf(int i) {
        com.facebook.drawee.drawable.c xZ = this.ijT.xZ(i);
        if (xZ.getDrawable() instanceof h) {
            xZ = (h) xZ.getDrawable();
        }
        if (xZ.getDrawable() instanceof m) {
            return (m) xZ.getDrawable();
        }
        return xZ;
    }

    private m yg(int i) {
        com.facebook.drawee.drawable.c yf = yf(i);
        return yf instanceof m ? (m) yf : e.a(yf, n.b.ijH);
    }

    public void b(n.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        yg(2).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.ijR = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.ijS, this.ijR);
        for (int i = 0; i < this.ijT.getNumberOfLayers(); i++) {
            e.a(yf(i), this.ijR, this.mResources);
        }
    }
}
