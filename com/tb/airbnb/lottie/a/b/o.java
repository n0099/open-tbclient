package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes6.dex */
public class o {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> nso;
    private final a<?, PointF> nsp;
    private final a<com.tb.airbnb.lottie.e.d, com.tb.airbnb.lottie.e.d> nsq;
    private final a<Float, Float> nsr;
    private final a<Integer, Integer> nss;
    @Nullable
    private final a<?, Float> nst;
    @Nullable
    private final a<?, Float> nsu;

    public o(com.tb.airbnb.lottie.model.a.l lVar) {
        this.nso = lVar.dHs().dHq();
        this.nsp = lVar.dHt().dHq();
        this.nsq = lVar.dHu().dHq();
        this.nsr = lVar.dHv().dHq();
        this.nss = lVar.dHw().dHq();
        if (lVar.dHx() != null) {
            this.nst = lVar.dHx().dHq();
        } else {
            this.nst = null;
        }
        if (lVar.dHy() != null) {
            this.nsu = lVar.dHy().dHq();
        } else {
            this.nsu = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.nso);
        aVar.a(this.nsp);
        aVar.a(this.nsq);
        aVar.a(this.nsr);
        aVar.a(this.nss);
        if (this.nst != null) {
            aVar.a(this.nst);
        }
        if (this.nsu != null) {
            aVar.a(this.nsu);
        }
    }

    public void a(a.InterfaceC0739a interfaceC0739a) {
        this.nso.b(interfaceC0739a);
        this.nsp.b(interfaceC0739a);
        this.nsq.b(interfaceC0739a);
        this.nsr.b(interfaceC0739a);
        this.nss.b(interfaceC0739a);
        if (this.nst != null) {
            this.nst.b(interfaceC0739a);
        }
        if (this.nsu != null) {
            this.nsu.b(interfaceC0739a);
        }
    }

    public void setProgress(float f) {
        this.nso.setProgress(f);
        this.nsp.setProgress(f);
        this.nsq.setProgress(f);
        this.nsr.setProgress(f);
        this.nss.setProgress(f);
        if (this.nst != null) {
            this.nst.setProgress(f);
        }
        if (this.nsu != null) {
            this.nsu.setProgress(f);
        }
    }

    public a<?, Integer> dHl() {
        return this.nss;
    }

    @Nullable
    public a<?, Float> dHm() {
        return this.nst;
    }

    @Nullable
    public a<?, Float> dHn() {
        return this.nsu;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.nsp.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.nsr.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.e.d value2 = this.nsq.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.nso.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix j(float f) {
        PointF value = this.nsp.getValue();
        PointF value2 = this.nso.getValue();
        com.tb.airbnb.lottie.e.d value3 = this.nsq.getValue();
        float floatValue = this.nsr.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.eQ) {
            this.nso.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eR) {
            this.nsp.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.nrx) {
            this.nsq.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eV) {
            this.nsr.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eO) {
            this.nss.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.fj && this.nst != null) {
            this.nst.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.fk && this.nsu != null) {
            this.nsu.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
