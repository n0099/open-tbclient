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
    private RoundingParams jDL;
    private final d jDM;
    private final f jDN;
    private final Resources mResources;
    private final Drawable jDK = new ColorDrawable(0);
    private final g jDO = new g(this.jDK);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.jDL = bVar.cvJ();
        int size = (bVar.cvH() != null ? bVar.cvH().size() : 1) + (bVar.cvI() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.cvv(), bVar.cvw());
        drawableArr[2] = a(this.jDO, bVar.cvD(), bVar.cvF(), bVar.cvE(), bVar.cvG());
        drawableArr[3] = a(bVar.cvB(), bVar.cvC());
        drawableArr[4] = a(bVar.cvx(), bVar.cvy());
        drawableArr[5] = a(bVar.cvz(), bVar.cvA());
        if (size > 0) {
            if (bVar.cvH() != null) {
                for (Drawable drawable : bVar.cvH()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.cvI() != null) {
                drawableArr[i + 6] = a(bVar.cvI(), null);
            }
        }
        this.jDN = new f(drawableArr);
        this.jDN.Cd(bVar.cvt());
        this.jDM = new d(e.a(this.jDN, this.jDL));
        this.jDM.mutate();
        cvr();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable n.b bVar, @Nullable PointF pointF, @Nullable Matrix matrix, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(e.a(drawable, bVar, pointF), matrix);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable n.b bVar) {
        return e.b(e.a(drawable, this.jDL, this.mResources), bVar);
    }

    private void cvq() {
        this.jDO.i(this.jDK);
    }

    private void cvr() {
        if (this.jDN != null) {
            this.jDN.cvf();
            this.jDN.cvh();
            cvs();
            Ce(1);
            this.jDN.cvi();
            this.jDN.cvg();
        }
    }

    private void cvs() {
        Cf(1);
        Cf(2);
        Cf(3);
        Cf(4);
        Cf(5);
    }

    private void Ce(int i) {
        if (i >= 0) {
            this.jDN.Ce(i);
        }
    }

    private void Cf(int i) {
        if (i >= 0) {
            this.jDN.Cf(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.jDN.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                Cf(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                Ce(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.jDM;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        cvq();
        cvr();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.jDL, this.mResources);
        a.mutate();
        this.jDO.i(a);
        this.jDN.cvf();
        cvs();
        Ce(2);
        setProgress(f);
        if (z) {
            this.jDN.cvi();
        }
        this.jDN.cvg();
    }

    @Override // com.facebook.drawee.d.c
    public void d(float f, boolean z) {
        if (this.jDN.getDrawable(3) != null) {
            this.jDN.cvf();
            setProgress(f);
            if (z) {
                this.jDN.cvi();
            }
            this.jDN.cvg();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void z(Throwable th) {
        this.jDN.cvf();
        cvs();
        if (this.jDN.getDrawable(5) != null) {
            Ce(5);
        } else {
            Ce(1);
        }
        this.jDN.cvg();
    }

    @Override // com.facebook.drawee.d.c
    public void A(Throwable th) {
        this.jDN.cvf();
        cvs();
        if (this.jDN.getDrawable(4) != null) {
            Ce(4);
        } else {
            Ce(1);
        }
        this.jDN.cvg();
    }

    @Override // com.facebook.drawee.d.c
    public void h(@Nullable Drawable drawable) {
        this.jDM.h(drawable);
    }

    private com.facebook.drawee.drawable.c Cg(int i) {
        com.facebook.drawee.drawable.c Ca = this.jDN.Ca(i);
        if (Ca.getDrawable() instanceof h) {
            Ca = (h) Ca.getDrawable();
        }
        if (Ca.getDrawable() instanceof m) {
            return (m) Ca.getDrawable();
        }
        return Ca;
    }

    private m Ch(int i) {
        com.facebook.drawee.drawable.c Cg = Cg(i);
        return Cg instanceof m ? (m) Cg : e.a(Cg, n.b.jDB);
    }

    public void b(n.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        Ch(2).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.jDL = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.jDM, this.jDL);
        for (int i = 0; i < this.jDN.getNumberOfLayers(); i++) {
            e.a(Cg(i), this.jDL, this.mResources);
        }
    }
}
