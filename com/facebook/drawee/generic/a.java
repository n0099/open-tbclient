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
    private RoundingParams keh;
    private final d kei;
    private final f kej;
    private final Resources mResources;
    private final Drawable keg = new ColorDrawable(0);
    private final g kek = new g(this.keg);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.keh = bVar.cEU();
        int size = (bVar.cES() != null ? bVar.cES().size() : 1) + (bVar.cET() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), null);
        drawableArr[1] = a(bVar.cEG(), bVar.cEH());
        drawableArr[2] = a(this.kek, bVar.cEO(), bVar.cEQ(), bVar.cEP(), bVar.cER());
        drawableArr[3] = a(bVar.cEM(), bVar.cEN());
        drawableArr[4] = a(bVar.cEI(), bVar.cEJ());
        drawableArr[5] = a(bVar.cEK(), bVar.cEL());
        if (size > 0) {
            if (bVar.cES() != null) {
                for (Drawable drawable : bVar.cES()) {
                    drawableArr[i + 6] = a(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.cET() != null) {
                drawableArr[i + 6] = a(bVar.cET(), null);
            }
        }
        this.kej = new f(drawableArr);
        this.kej.Cg(bVar.cEE());
        this.kei = new d(e.a(this.kej, this.keh));
        this.kei.mutate();
        cEC();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable n.b bVar, @Nullable PointF pointF, @Nullable Matrix matrix, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(e.a(drawable, bVar, pointF), matrix);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable n.b bVar) {
        return e.b(e.a(drawable, this.keh, this.mResources), bVar);
    }

    private void cEB() {
        this.kek.g(this.keg);
    }

    private void cEC() {
        if (this.kej != null) {
            this.kej.cEp();
            this.kej.cEr();
            cED();
            Ch(1);
            this.kej.cEs();
            this.kej.cEq();
        }
    }

    private void cED() {
        Ci(1);
        Ci(2);
        Ci(3);
        Ci(4);
        Ci(5);
    }

    private void Ch(int i) {
        if (i >= 0) {
            this.kej.Ch(i);
        }
    }

    private void Ci(int i) {
        if (i >= 0) {
            this.kej.Ci(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.kej.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                Ci(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                Ch(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.kei;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        cEB();
        cEC();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a = e.a(drawable, this.keh, this.mResources);
        a.mutate();
        this.kek.g(a);
        this.kej.cEp();
        cED();
        Ch(2);
        setProgress(f);
        if (z) {
            this.kej.cEs();
        }
        this.kej.cEq();
    }

    @Override // com.facebook.drawee.d.c
    public void d(float f, boolean z) {
        if (this.kej.getDrawable(3) != null) {
            this.kej.cEp();
            setProgress(f);
            if (z) {
                this.kej.cEs();
            }
            this.kej.cEq();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void y(Throwable th) {
        this.kej.cEp();
        cED();
        if (this.kej.getDrawable(5) != null) {
            Ch(5);
        } else {
            Ch(1);
        }
        this.kej.cEq();
    }

    @Override // com.facebook.drawee.d.c
    public void z(Throwable th) {
        this.kej.cEp();
        cED();
        if (this.kej.getDrawable(4) != null) {
            Ch(4);
        } else {
            Ch(1);
        }
        this.kej.cEq();
    }

    @Override // com.facebook.drawee.d.c
    public void f(@Nullable Drawable drawable) {
        this.kei.f(drawable);
    }

    private com.facebook.drawee.drawable.c Cj(int i) {
        com.facebook.drawee.drawable.c Cd = this.kej.Cd(i);
        if (Cd.getDrawable() instanceof h) {
            Cd = (h) Cd.getDrawable();
        }
        if (Cd.getDrawable() instanceof m) {
            return (m) Cd.getDrawable();
        }
        return Cd;
    }

    private m Ck(int i) {
        com.facebook.drawee.drawable.c Cj = Cj(i);
        return Cj instanceof m ? (m) Cj : e.a(Cj, n.b.kdX);
    }

    public void b(n.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        Ck(2).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.keh = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.kei, this.keh);
        for (int i = 0; i < this.kej.cEm(); i++) {
            e.a(Cj(i), this.keh, this.mResources);
        }
    }
}
