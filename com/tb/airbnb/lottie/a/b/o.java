package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes6.dex */
public class o {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> nqo;
    private final a<?, PointF> nqp;
    private final a<com.tb.airbnb.lottie.e.d, com.tb.airbnb.lottie.e.d> nqq;
    private final a<Float, Float> nqr;
    private final a<Integer, Integer> nqs;
    @Nullable
    private final a<?, Float> nqt;
    @Nullable
    private final a<?, Float> nqu;

    public o(com.tb.airbnb.lottie.model.a.l lVar) {
        this.nqo = lVar.dGP().dGN();
        this.nqp = lVar.dGQ().dGN();
        this.nqq = lVar.dGR().dGN();
        this.nqr = lVar.dGS().dGN();
        this.nqs = lVar.dGT().dGN();
        if (lVar.dGU() != null) {
            this.nqt = lVar.dGU().dGN();
        } else {
            this.nqt = null;
        }
        if (lVar.dGV() != null) {
            this.nqu = lVar.dGV().dGN();
        } else {
            this.nqu = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.nqo);
        aVar.a(this.nqp);
        aVar.a(this.nqq);
        aVar.a(this.nqr);
        aVar.a(this.nqs);
        if (this.nqt != null) {
            aVar.a(this.nqt);
        }
        if (this.nqu != null) {
            aVar.a(this.nqu);
        }
    }

    public void a(a.InterfaceC0738a interfaceC0738a) {
        this.nqo.b(interfaceC0738a);
        this.nqp.b(interfaceC0738a);
        this.nqq.b(interfaceC0738a);
        this.nqr.b(interfaceC0738a);
        this.nqs.b(interfaceC0738a);
        if (this.nqt != null) {
            this.nqt.b(interfaceC0738a);
        }
        if (this.nqu != null) {
            this.nqu.b(interfaceC0738a);
        }
    }

    public void setProgress(float f) {
        this.nqo.setProgress(f);
        this.nqp.setProgress(f);
        this.nqq.setProgress(f);
        this.nqr.setProgress(f);
        this.nqs.setProgress(f);
        if (this.nqt != null) {
            this.nqt.setProgress(f);
        }
        if (this.nqu != null) {
            this.nqu.setProgress(f);
        }
    }

    public a<?, Integer> dGI() {
        return this.nqs;
    }

    @Nullable
    public a<?, Float> dGJ() {
        return this.nqt;
    }

    @Nullable
    public a<?, Float> dGK() {
        return this.nqu;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.nqp.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.nqr.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.e.d value2 = this.nqq.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.nqo.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix j(float f) {
        PointF value = this.nqp.getValue();
        PointF value2 = this.nqo.getValue();
        com.tb.airbnb.lottie.e.d value3 = this.nqq.getValue();
        float floatValue = this.nqr.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.eR) {
            this.nqo.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eS) {
            this.nqp.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.npx) {
            this.nqq.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eW) {
            this.nqr.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eP) {
            this.nqs.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.fk && this.nqt != null) {
            this.nqt.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.fn && this.nqu != null) {
            this.nqu.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
