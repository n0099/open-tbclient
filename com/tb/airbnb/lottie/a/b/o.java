package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes7.dex */
public class o {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> oiL;
    private final a<?, PointF> oiM;
    private final a<com.tb.airbnb.lottie.e.d, com.tb.airbnb.lottie.e.d> oiN;
    private final a<Float, Float> oiO;
    private final a<Integer, Integer> oiP;
    @Nullable
    private final a<?, Float> oiQ;
    @Nullable
    private final a<?, Float> oiR;

    public o(com.tb.airbnb.lottie.model.a.l lVar) {
        this.oiL = lVar.edh().edf();
        this.oiM = lVar.edi().edf();
        this.oiN = lVar.edj().edf();
        this.oiO = lVar.edk().edf();
        this.oiP = lVar.edl().edf();
        if (lVar.edm() != null) {
            this.oiQ = lVar.edm().edf();
        } else {
            this.oiQ = null;
        }
        if (lVar.edn() != null) {
            this.oiR = lVar.edn().edf();
        } else {
            this.oiR = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.oiL);
        aVar.a(this.oiM);
        aVar.a(this.oiN);
        aVar.a(this.oiO);
        aVar.a(this.oiP);
        if (this.oiQ != null) {
            aVar.a(this.oiQ);
        }
        if (this.oiR != null) {
            aVar.a(this.oiR);
        }
    }

    public void a(a.InterfaceC0932a interfaceC0932a) {
        this.oiL.b(interfaceC0932a);
        this.oiM.b(interfaceC0932a);
        this.oiN.b(interfaceC0932a);
        this.oiO.b(interfaceC0932a);
        this.oiP.b(interfaceC0932a);
        if (this.oiQ != null) {
            this.oiQ.b(interfaceC0932a);
        }
        if (this.oiR != null) {
            this.oiR.b(interfaceC0932a);
        }
    }

    public void setProgress(float f) {
        this.oiL.setProgress(f);
        this.oiM.setProgress(f);
        this.oiN.setProgress(f);
        this.oiO.setProgress(f);
        this.oiP.setProgress(f);
        if (this.oiQ != null) {
            this.oiQ.setProgress(f);
        }
        if (this.oiR != null) {
            this.oiR.setProgress(f);
        }
    }

    public a<?, Integer> eda() {
        return this.oiP;
    }

    @Nullable
    public a<?, Float> edb() {
        return this.oiQ;
    }

    @Nullable
    public a<?, Float> edc() {
        return this.oiR;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.oiM.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.oiO.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.e.d value2 = this.oiN.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.oiL.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix i(float f) {
        PointF value = this.oiM.getValue();
        PointF value2 = this.oiL.getValue();
        com.tb.airbnb.lottie.e.d value3 = this.oiN.getValue();
        float floatValue = this.oiO.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.BI) {
            this.oiL.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.BJ) {
            this.oiM.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.ohU) {
            this.oiN.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.BN) {
            this.oiO.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.BG) {
            this.oiP.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.BY && this.oiQ != null) {
            this.oiQ.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.BZ && this.oiR != null) {
            this.oiR.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
