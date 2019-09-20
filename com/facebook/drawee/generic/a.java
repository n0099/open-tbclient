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
    private RoundingParams kgQ;
    private final d kgR;
    private final f kgS;
    private final Resources mResources;
    private final Drawable kgP = new ColorDrawable(0);
    private final g kgT = new g(this.kgP);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.kgQ = bVar.cHY();
        int size = (bVar.cHW() != null ? bVar.cHW().size() : 1) + (bVar.cHX() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.cHK(), bVar.cHL());
        drawableArr[2] = a(this.kgT, bVar.cHS(), bVar.cHU(), bVar.cHT(), bVar.cHV());
        drawableArr[3] = a(bVar.cHQ(), bVar.cHR());
        drawableArr[4] = a(bVar.cHM(), bVar.cHN());
        drawableArr[5] = a(bVar.cHO(), bVar.cHP());
        if (size > 0) {
            if (bVar.cHW() != null) {
                for (Drawable drawable : bVar.cHW()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.cHX() != null) {
                drawableArr[i + 6] = a(bVar.cHX(), null);
            }
        }
        this.kgS = new f(drawableArr);
        this.kgS.DL(bVar.cHI());
        this.kgR = new d(e.a(this.kgS, this.kgQ));
        this.kgR.mutate();
        cHG();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable n.b bVar, @Nullable PointF pointF, @Nullable Matrix matrix, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(e.a(drawable, bVar, pointF), matrix);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable n.b bVar) {
        return e.b(e.a(drawable, this.kgQ, this.mResources), bVar);
    }

    private void cHF() {
        this.kgT.h(this.kgP);
    }

    private void cHG() {
        if (this.kgS != null) {
            this.kgS.cHt();
            this.kgS.cHv();
            cHH();
            DM(1);
            this.kgS.cHw();
            this.kgS.cHu();
        }
    }

    private void cHH() {
        DN(1);
        DN(2);
        DN(3);
        DN(4);
        DN(5);
    }

    private void DM(int i) {
        if (i >= 0) {
            this.kgS.DM(i);
        }
    }

    private void DN(int i) {
        if (i >= 0) {
            this.kgS.DN(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.kgS.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                DN(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                DM(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.kgR;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        cHF();
        cHG();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.kgQ, this.mResources);
        a.mutate();
        this.kgT.h(a);
        this.kgS.cHt();
        cHH();
        DM(2);
        setProgress(f);
        if (z) {
            this.kgS.cHw();
        }
        this.kgS.cHu();
    }

    @Override // com.facebook.drawee.d.c
    public void d(float f, boolean z) {
        if (this.kgS.getDrawable(3) != null) {
            this.kgS.cHt();
            setProgress(f);
            if (z) {
                this.kgS.cHw();
            }
            this.kgS.cHu();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void y(Throwable th) {
        this.kgS.cHt();
        cHH();
        if (this.kgS.getDrawable(5) != null) {
            DM(5);
        } else {
            DM(1);
        }
        this.kgS.cHu();
    }

    @Override // com.facebook.drawee.d.c
    public void z(Throwable th) {
        this.kgS.cHt();
        cHH();
        if (this.kgS.getDrawable(4) != null) {
            DM(4);
        } else {
            DM(1);
        }
        this.kgS.cHu();
    }

    @Override // com.facebook.drawee.d.c
    public void g(@Nullable Drawable drawable) {
        this.kgR.g(drawable);
    }

    private com.facebook.drawee.drawable.c DO(int i) {
        com.facebook.drawee.drawable.c DI = this.kgS.DI(i);
        if (DI.getDrawable() instanceof h) {
            DI = (h) DI.getDrawable();
        }
        if (DI.getDrawable() instanceof m) {
            return (m) DI.getDrawable();
        }
        return DI;
    }

    private m DP(int i) {
        com.facebook.drawee.drawable.c DO = DO(i);
        return DO instanceof m ? (m) DO : e.a(DO, n.b.kgG);
    }

    public void b(n.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        DP(2).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.kgQ = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.kgR, this.kgQ);
        for (int i = 0; i < this.kgS.cHq(); i++) {
            e.a(DO(i), this.kgQ, this.mResources);
        }
    }
}
