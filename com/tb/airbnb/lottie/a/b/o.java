package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes16.dex */
public class o {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> pzA;
    private final a<?, PointF> pzB;
    private final a<com.tb.airbnb.lottie.e.d, com.tb.airbnb.lottie.e.d> pzC;
    private final a<Float, Float> pzD;
    private final a<Integer, Integer> pzE;
    @Nullable
    private final a<?, Float> pzF;
    @Nullable
    private final a<?, Float> pzG;

    public o(com.tb.airbnb.lottie.model.a.l lVar) {
        this.pzA = lVar.euY().euW();
        this.pzB = lVar.euZ().euW();
        this.pzC = lVar.eva().euW();
        this.pzD = lVar.evb().euW();
        this.pzE = lVar.evc().euW();
        if (lVar.evd() != null) {
            this.pzF = lVar.evd().euW();
        } else {
            this.pzF = null;
        }
        if (lVar.eve() != null) {
            this.pzG = lVar.eve().euW();
        } else {
            this.pzG = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.pzA);
        aVar.a(this.pzB);
        aVar.a(this.pzC);
        aVar.a(this.pzD);
        aVar.a(this.pzE);
        if (this.pzF != null) {
            aVar.a(this.pzF);
        }
        if (this.pzG != null) {
            aVar.a(this.pzG);
        }
    }

    public void a(a.InterfaceC1019a interfaceC1019a) {
        this.pzA.b(interfaceC1019a);
        this.pzB.b(interfaceC1019a);
        this.pzC.b(interfaceC1019a);
        this.pzD.b(interfaceC1019a);
        this.pzE.b(interfaceC1019a);
        if (this.pzF != null) {
            this.pzF.b(interfaceC1019a);
        }
        if (this.pzG != null) {
            this.pzG.b(interfaceC1019a);
        }
    }

    public void setProgress(float f) {
        this.pzA.setProgress(f);
        this.pzB.setProgress(f);
        this.pzC.setProgress(f);
        this.pzD.setProgress(f);
        this.pzE.setProgress(f);
        if (this.pzF != null) {
            this.pzF.setProgress(f);
        }
        if (this.pzG != null) {
            this.pzG.setProgress(f);
        }
    }

    public a<?, Integer> euR() {
        return this.pzE;
    }

    @Nullable
    public a<?, Float> euS() {
        return this.pzF;
    }

    @Nullable
    public a<?, Float> euT() {
        return this.pzG;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.pzB.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.pzD.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.e.d value2 = this.pzC.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.pzA.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix i(float f) {
        PointF value = this.pzB.getValue();
        PointF value2 = this.pzA.getValue();
        com.tb.airbnb.lottie.e.d value3 = this.pzC.getValue();
        float floatValue = this.pzD.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.BZ) {
            this.pzA.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Ca) {
            this.pzB.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.pyJ) {
            this.pzC.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Ce) {
            this.pzD.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.BX) {
            this.pzE.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Cp && this.pzF != null) {
            this.pzF.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Cq && this.pzG != null) {
            this.pzG.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
