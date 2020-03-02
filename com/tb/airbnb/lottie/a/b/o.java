package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes6.dex */
public class o {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> nqq;
    private final a<?, PointF> nqr;
    private final a<com.tb.airbnb.lottie.e.d, com.tb.airbnb.lottie.e.d> nqs;
    private final a<Float, Float> nqt;
    private final a<Integer, Integer> nqu;
    @Nullable
    private final a<?, Float> nqv;
    @Nullable
    private final a<?, Float> nqw;

    public o(com.tb.airbnb.lottie.model.a.l lVar) {
        this.nqq = lVar.dGR().dGP();
        this.nqr = lVar.dGS().dGP();
        this.nqs = lVar.dGT().dGP();
        this.nqt = lVar.dGU().dGP();
        this.nqu = lVar.dGV().dGP();
        if (lVar.dGW() != null) {
            this.nqv = lVar.dGW().dGP();
        } else {
            this.nqv = null;
        }
        if (lVar.dGX() != null) {
            this.nqw = lVar.dGX().dGP();
        } else {
            this.nqw = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.nqq);
        aVar.a(this.nqr);
        aVar.a(this.nqs);
        aVar.a(this.nqt);
        aVar.a(this.nqu);
        if (this.nqv != null) {
            aVar.a(this.nqv);
        }
        if (this.nqw != null) {
            aVar.a(this.nqw);
        }
    }

    public void a(a.InterfaceC0738a interfaceC0738a) {
        this.nqq.b(interfaceC0738a);
        this.nqr.b(interfaceC0738a);
        this.nqs.b(interfaceC0738a);
        this.nqt.b(interfaceC0738a);
        this.nqu.b(interfaceC0738a);
        if (this.nqv != null) {
            this.nqv.b(interfaceC0738a);
        }
        if (this.nqw != null) {
            this.nqw.b(interfaceC0738a);
        }
    }

    public void setProgress(float f) {
        this.nqq.setProgress(f);
        this.nqr.setProgress(f);
        this.nqs.setProgress(f);
        this.nqt.setProgress(f);
        this.nqu.setProgress(f);
        if (this.nqv != null) {
            this.nqv.setProgress(f);
        }
        if (this.nqw != null) {
            this.nqw.setProgress(f);
        }
    }

    public a<?, Integer> dGK() {
        return this.nqu;
    }

    @Nullable
    public a<?, Float> dGL() {
        return this.nqv;
    }

    @Nullable
    public a<?, Float> dGM() {
        return this.nqw;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.nqr.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.nqt.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.e.d value2 = this.nqs.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.nqq.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix j(float f) {
        PointF value = this.nqr.getValue();
        PointF value2 = this.nqq.getValue();
        com.tb.airbnb.lottie.e.d value3 = this.nqs.getValue();
        float floatValue = this.nqt.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.eR) {
            this.nqq.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eS) {
            this.nqr.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.npz) {
            this.nqs.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eW) {
            this.nqt.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eP) {
            this.nqu.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.fk && this.nqv != null) {
            this.nqv.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.fn && this.nqw != null) {
            this.nqw.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
