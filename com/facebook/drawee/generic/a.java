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
    private RoundingParams jEe;
    private final d jEf;
    private final f jEg;
    private final Resources mResources;
    private final Drawable jEd = new ColorDrawable(0);
    private final g jEh = new g(this.jEd);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.jEe = bVar.cvT();
        int size = (bVar.cvR() != null ? bVar.cvR().size() : 1) + (bVar.cvS() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.cvF(), bVar.cvG());
        drawableArr[2] = a(this.jEh, bVar.cvN(), bVar.cvP(), bVar.cvO(), bVar.cvQ());
        drawableArr[3] = a(bVar.cvL(), bVar.cvM());
        drawableArr[4] = a(bVar.cvH(), bVar.cvI());
        drawableArr[5] = a(bVar.cvJ(), bVar.cvK());
        if (size > 0) {
            if (bVar.cvR() != null) {
                for (Drawable drawable : bVar.cvR()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.cvS() != null) {
                drawableArr[i + 6] = a(bVar.cvS(), null);
            }
        }
        this.jEg = new f(drawableArr);
        this.jEg.Ce(bVar.cvD());
        this.jEf = new d(e.a(this.jEg, this.jEe));
        this.jEf.mutate();
        cvB();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable n.b bVar, @Nullable PointF pointF, @Nullable Matrix matrix, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(e.a(drawable, bVar, pointF), matrix);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable n.b bVar) {
        return e.b(e.a(drawable, this.jEe, this.mResources), bVar);
    }

    private void cvA() {
        this.jEh.i(this.jEd);
    }

    private void cvB() {
        if (this.jEg != null) {
            this.jEg.cvp();
            this.jEg.cvr();
            cvC();
            Cf(1);
            this.jEg.cvs();
            this.jEg.cvq();
        }
    }

    private void cvC() {
        Cg(1);
        Cg(2);
        Cg(3);
        Cg(4);
        Cg(5);
    }

    private void Cf(int i) {
        if (i >= 0) {
            this.jEg.Cf(i);
        }
    }

    private void Cg(int i) {
        if (i >= 0) {
            this.jEg.Cg(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.jEg.getDrawable(3);
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
        return this.jEf;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        cvA();
        cvB();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.jEe, this.mResources);
        a.mutate();
        this.jEh.i(a);
        this.jEg.cvp();
        cvC();
        Cf(2);
        setProgress(f);
        if (z) {
            this.jEg.cvs();
        }
        this.jEg.cvq();
    }

    @Override // com.facebook.drawee.d.c
    public void d(float f, boolean z) {
        if (this.jEg.getDrawable(3) != null) {
            this.jEg.cvp();
            setProgress(f);
            if (z) {
                this.jEg.cvs();
            }
            this.jEg.cvq();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void z(Throwable th) {
        this.jEg.cvp();
        cvC();
        if (this.jEg.getDrawable(5) != null) {
            Cf(5);
        } else {
            Cf(1);
        }
        this.jEg.cvq();
    }

    @Override // com.facebook.drawee.d.c
    public void A(Throwable th) {
        this.jEg.cvp();
        cvC();
        if (this.jEg.getDrawable(4) != null) {
            Cf(4);
        } else {
            Cf(1);
        }
        this.jEg.cvq();
    }

    @Override // com.facebook.drawee.d.c
    public void h(@Nullable Drawable drawable) {
        this.jEf.h(drawable);
    }

    private com.facebook.drawee.drawable.c Ch(int i) {
        com.facebook.drawee.drawable.c Cb = this.jEg.Cb(i);
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
        return Ch instanceof m ? (m) Ch : e.a(Ch, n.b.jDU);
    }

    public void b(n.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        Ci(2).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.jEe = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.jEf, this.jEe);
        for (int i = 0; i < this.jEg.getNumberOfLayers(); i++) {
            e.a(Ch(i), this.jEe, this.mResources);
        }
    }
}
