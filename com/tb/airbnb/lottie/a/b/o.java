package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes17.dex */
public class o {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> osN;
    private final a<?, PointF> osO;
    private final a<com.tb.airbnb.lottie.e.d, com.tb.airbnb.lottie.e.d> osP;
    private final a<Float, Float> osQ;
    private final a<Integer, Integer> osR;
    @Nullable
    private final a<?, Float> osS;
    @Nullable
    private final a<?, Float> osT;

    public o(com.tb.airbnb.lottie.model.a.l lVar) {
        this.osN = lVar.ehn().ehl();
        this.osO = lVar.eho().ehl();
        this.osP = lVar.ehp().ehl();
        this.osQ = lVar.ehq().ehl();
        this.osR = lVar.ehr().ehl();
        if (lVar.ehs() != null) {
            this.osS = lVar.ehs().ehl();
        } else {
            this.osS = null;
        }
        if (lVar.eht() != null) {
            this.osT = lVar.eht().ehl();
        } else {
            this.osT = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.osN);
        aVar.a(this.osO);
        aVar.a(this.osP);
        aVar.a(this.osQ);
        aVar.a(this.osR);
        if (this.osS != null) {
            aVar.a(this.osS);
        }
        if (this.osT != null) {
            aVar.a(this.osT);
        }
    }

    public void a(a.InterfaceC0929a interfaceC0929a) {
        this.osN.b(interfaceC0929a);
        this.osO.b(interfaceC0929a);
        this.osP.b(interfaceC0929a);
        this.osQ.b(interfaceC0929a);
        this.osR.b(interfaceC0929a);
        if (this.osS != null) {
            this.osS.b(interfaceC0929a);
        }
        if (this.osT != null) {
            this.osT.b(interfaceC0929a);
        }
    }

    public void setProgress(float f) {
        this.osN.setProgress(f);
        this.osO.setProgress(f);
        this.osP.setProgress(f);
        this.osQ.setProgress(f);
        this.osR.setProgress(f);
        if (this.osS != null) {
            this.osS.setProgress(f);
        }
        if (this.osT != null) {
            this.osT.setProgress(f);
        }
    }

    public a<?, Integer> ehg() {
        return this.osR;
    }

    @Nullable
    public a<?, Float> ehh() {
        return this.osS;
    }

    @Nullable
    public a<?, Float> ehi() {
        return this.osT;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.osO.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.osQ.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.e.d value2 = this.osP.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.osN.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix i(float f) {
        PointF value = this.osO.getValue();
        PointF value2 = this.osN.getValue();
        com.tb.airbnb.lottie.e.d value3 = this.osP.getValue();
        float floatValue = this.osQ.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.BI) {
            this.osN.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.BJ) {
            this.osO.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.orW) {
            this.osP.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.BN) {
            this.osQ.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.BG) {
            this.osR.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.BY && this.osS != null) {
            this.osS.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.BZ && this.osT != null) {
            this.osT.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
