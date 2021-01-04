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
    private RoundingParams pxM;
    private final d pxN;
    private final f pxO;
    private final Drawable pxL = new ColorDrawable(0);
    private final g pxP = new g(this.pxL);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i = 0;
        this.mResources = bVar.getResources();
        this.pxM = bVar.evT();
        int size = (bVar.getOverlays() != null ? bVar.getOverlays().size() : 1) + (bVar.ewi() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = a(bVar.getBackground(), (p.b) null);
        drawableArr[1] = a(bVar.evX(), bVar.evY());
        drawableArr[2] = a(this.pxP, bVar.ewf(), bVar.ewg(), bVar.ewh());
        drawableArr[3] = a(bVar.ewd(), bVar.ewe());
        drawableArr[4] = a(bVar.evZ(), bVar.ewa());
        drawableArr[5] = a(bVar.ewb(), bVar.ewc());
        if (size > 0) {
            if (bVar.getOverlays() != null) {
                for (Drawable drawable : bVar.getOverlays()) {
                    drawableArr[i + 6] = a(drawable, (p.b) null);
                    i++;
                }
            } else {
                i = 1;
            }
            if (bVar.ewi() != null) {
                drawableArr[i + 6] = a(bVar.ewi(), (p.b) null);
            }
        }
        this.pxO = new f(drawableArr);
        this.pxO.Qo(bVar.evU());
        this.pxN = new d(e.a(this.pxO, this.pxM));
        this.pxN.Bb(bVar.evV());
        this.pxN.mutate();
        evR();
    }

    @Nullable
    private Drawable a(Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.a(drawable, bVar, pointF);
    }

    @Nullable
    private Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return e.d(e.a(drawable, this.pxM, this.mResources), bVar);
    }

    private void evQ() {
        this.pxP.v(this.pxL);
    }

    private void evR() {
        if (this.pxO != null) {
            this.pxO.evF();
            this.pxO.evH();
            evS();
            Qp(1);
            this.pxO.evI();
            this.pxO.evG();
        }
    }

    private void evS() {
        Qq(1);
        Qq(2);
        Qq(3);
        Qq(4);
        Qq(5);
    }

    private void Qp(int i) {
        if (i >= 0) {
            this.pxO.Qp(i);
        }
    }

    private void Qq(int i) {
        if (i >= 0) {
            this.pxO.Qq(i);
        }
    }

    private void setProgress(float f) {
        Drawable drawable = this.pxO.getDrawable(3);
        if (drawable != null) {
            if (f >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                Qq(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                Qp(3);
            }
            drawable.setLevel(Math.round(10000.0f * f));
        }
    }

    @Override // com.facebook.drawee.d.b
    public Drawable getTopLevelDrawable() {
        return this.pxN;
    }

    @Override // com.facebook.drawee.d.c
    public void reset() {
        evQ();
        evR();
    }

    @Override // com.facebook.drawee.d.c
    public void a(Drawable drawable, float f, boolean z) {
        Drawable a2 = e.a(drawable, this.pxM, this.mResources);
        a2.mutate();
        this.pxP.v(a2);
        this.pxO.evF();
        evS();
        Qp(2);
        setProgress(f);
        if (z) {
            this.pxO.evI();
        }
        this.pxO.evG();
    }

    @Override // com.facebook.drawee.d.c
    public void d(float f, boolean z) {
        if (this.pxO.getDrawable(3) != null) {
            this.pxO.evF();
            setProgress(f);
            if (z) {
                this.pxO.evI();
            }
            this.pxO.evG();
        }
    }

    @Override // com.facebook.drawee.d.c
    public void A(Throwable th) {
        this.pxO.evF();
        evS();
        if (this.pxO.getDrawable(5) != null) {
            Qp(5);
        } else {
            Qp(1);
        }
        this.pxO.evG();
    }

    @Override // com.facebook.drawee.d.c
    public void B(Throwable th) {
        this.pxO.evF();
        evS();
        if (this.pxO.getDrawable(4) != null) {
            Qp(4);
        } else {
            Qp(1);
        }
        this.pxO.evG();
    }

    @Override // com.facebook.drawee.d.c
    public void u(@Nullable Drawable drawable) {
        this.pxN.u(drawable);
    }

    private com.facebook.drawee.drawable.c Qr(int i) {
        com.facebook.drawee.drawable.c Ql = this.pxO.Ql(i);
        if (Ql.getDrawable() instanceof h) {
            Ql = (h) Ql.getDrawable();
        }
        if (Ql.getDrawable() instanceof o) {
            return (o) Ql.getDrawable();
        }
        return Ql;
    }

    private void b(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.pxO.a(i, null);
            return;
        }
        Qr(i).v(e.a(drawable, this.pxM, this.mResources));
    }

    private o Qs(int i) {
        com.facebook.drawee.drawable.c Qr = Qr(i);
        return Qr instanceof o ? (o) Qr : e.a(Qr, p.b.pxB);
    }

    public void b(p.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        Qs(2).a(bVar);
    }

    public void A(@Nullable Drawable drawable) {
        b(1, drawable);
    }

    public void b(Drawable drawable, p.b bVar) {
        b(1, drawable);
        Qs(1).a(bVar);
    }

    public void Qt(int i) {
        A(this.mResources.getDrawable(i));
    }

    public void a(int i, p.b bVar) {
        b(this.mResources.getDrawable(i), bVar);
    }

    public void c(Drawable drawable, p.b bVar) {
        b(5, drawable);
        Qs(5).a(bVar);
    }

    public void b(int i, p.b bVar) {
        c(this.mResources.getDrawable(i), bVar);
    }

    public void a(@Nullable RoundingParams roundingParams) {
        this.pxM = roundingParams;
        e.a((com.facebook.drawee.drawable.c) this.pxN, this.pxM);
        for (int i = 0; i < this.pxO.evC(); i++) {
            e.a(Qr(i), this.pxM, this.mResources);
        }
    }

    @Nullable
    public RoundingParams evT() {
        return this.pxM;
    }
}
