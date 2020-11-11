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
/* loaded from: classes15.dex */
public class a implements com.facebook.drawee.d.c {
    private final Resources mResources;
    @Nullable
    private RoundingParams oPQ;
    private final d oPR;
    private final f oPS;
    private final Drawable oPP = new ColorDrawable(0);
    private final g oPT = new g(this.oPP);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.oPQ = bVar.emc();
        int size = (bVar.getOverlays() != null ? bVar.getOverlays().size() : 1) + (bVar.emr() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), (p.b) null);
        drawableArr[1] = a(bVar.emg(), bVar.emh());
        drawableArr[2] = a(this.oPT, bVar.emo(), bVar.emp(), bVar.emq());
        drawableArr[3] = a(bVar.emm(), bVar.emn());
        drawableArr[4] = a(bVar.emi(), bVar.emj());
        drawableArr[5] = a(bVar.emk(), bVar.eml());
        if (size > 0) {
            if (bVar.getOverlays() != null) {
                for (Drawable drawable : bVar.getOverlays()) {
                    drawableArr[i + 6] = a(drawable, (p.b) null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.emr() != null) {
                drawableArr[i + 6] = a(bVar.emr(), (p.b) null);
            }
        }
        this.oPS = new f(drawableArr);
        this.oPS.OE(bVar.emd());
        this.oPR = new d(e.a(this.oPS, this.oPQ));
        this.oPR.Aj(bVar.eme());
        this.oPR.mutate();
        ema();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.f(e.a(drawable, this.oPQ, this.mResources), bVar);
    }

    private void elZ() {
        this.oPT.setDrawable(this.oPP);
    }

    private void ema() {
        if (this.oPS != null) {
            this.oPS.elP();
            this.oPS.elR();
            emb();
            OF(1);
            this.oPS.elS();
            this.oPS.elQ();
        }
    }

    private void emb() {
        OG(1);
        OG(2);
        OG(3);
        OG(4);
        OG(5);
    }

    private void OF(int i) {
        if (i >= 0) {
            this.oPS.OF(i);
        }
    }

    private void OG(int i) {
        if (i >= 0) {
            this.oPS.OG(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.oPS.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                OG(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                OF(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.oPR;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        elZ();
        ema();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a2 = e.a(drawable, this.oPQ, this.mResources);
        a2.mutate();
        this.oPT.setDrawable(a2);
        this.oPS.elP();
        emb();
        OF(2);
        setProgress(f);
        if (z) {
            this.oPS.elS();
        }
        this.oPS.elQ();
    }

    @Override // com.facebook.drawee.d.c
    public void c(float f, boolean z) {
        if (this.oPS.getDrawable(3) != null) {
            this.oPS.elP();
            setProgress(f);
            if (z) {
                this.oPS.elS();
            }
            this.oPS.elQ();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void B(Throwable th) {
        this.oPS.elP();
        emb();
        if (this.oPS.getDrawable(5) != null) {
            OF(5);
        } else {
            OF(1);
        }
        this.oPS.elQ();
    }

    @Override // com.facebook.drawee.d.c
    public void C(Throwable th) {
        this.oPS.elP();
        emb();
        if (this.oPS.getDrawable(4) != null) {
            OF(4);
        } else {
            OF(1);
        }
        this.oPS.elQ();
    }

    @Override // com.facebook.drawee.d.c
    public void o(@Nullable Drawable drawable) {
        this.oPR.o(drawable);
    }

    private com.facebook.drawee.drawable.c OH(int i) {
        com.facebook.drawee.drawable.c OB = this.oPS.OB(i);
        if (OB.getDrawable() instanceof h) {
            OB = (h) OB.getDrawable();
        }
        if (OB.getDrawable() instanceof o) {
            return (o) OB.getDrawable();
        }
        return OB;
    }

    private void b(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.oPS.a(i, null);
            return;
        }
        OH(i).setDrawable(e.a(drawable, this.oPQ, this.mResources));
    }

    private o OI(int i) {
        com.facebook.drawee.drawable.c OH = OH(i);
        return OH instanceof o ? (o) OH : e.a(OH, p.b.oPF);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        OI(2).a(bVar);
    }

    public void r(@Nullable Drawable drawable) {
        b(1, drawable);
    }

    public void b(Drawable drawable, p.b bVar) {
        b(1, drawable);
        OI(1).a(bVar);
    }

    public void OJ(int i) {
        r(this.mResources.getDrawable(i));
    }

    public void a(int i, p.b bVar) {
        b(this.mResources.getDrawable(i), bVar);
    }

    public void setFailureImage(@Nullable Drawable drawable) {
        b(5, drawable);
    }

    public void c(Drawable drawable, p.b bVar) {
        b(5, drawable);
        OI(5).a(bVar);
    }

    public void OK(int i) {
        setFailureImage(this.mResources.getDrawable(i));
    }

    public void d(Drawable drawable, p.b bVar) {
        b(4, drawable);
        OI(4).a(bVar);
    }

    public void e(Drawable drawable, p.b bVar) {
        b(3, drawable);
        OI(3).a(bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.oPQ = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.oPR, this.oPQ);
        for (int i = 0; i < this.oPS.elM(); i++) {
            e.a(OH(i), this.oPQ, this.mResources);
        }
    }

    @Nullable
    public RoundingParams emc() {
        return this.oPQ;
    }
}
