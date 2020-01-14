package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes5.dex */
public class o {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> npM;
    private final a<?, PointF> npN;
    private final a<com.tb.airbnb.lottie.e.d, com.tb.airbnb.lottie.e.d> npO;
    private final a<Float, Float> npP;
    private final a<Integer, Integer> npQ;
    @Nullable
    private final a<?, Float> npR;
    @Nullable
    private final a<?, Float> npS;

    public o(com.tb.airbnb.lottie.model.a.l lVar) {
        this.npM = lVar.dFI().dFG();
        this.npN = lVar.dFJ().dFG();
        this.npO = lVar.dFK().dFG();
        this.npP = lVar.dFL().dFG();
        this.npQ = lVar.dFM().dFG();
        if (lVar.dFN() != null) {
            this.npR = lVar.dFN().dFG();
        } else {
            this.npR = null;
        }
        if (lVar.dFO() != null) {
            this.npS = lVar.dFO().dFG();
        } else {
            this.npS = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.npM);
        aVar.a(this.npN);
        aVar.a(this.npO);
        aVar.a(this.npP);
        aVar.a(this.npQ);
        if (this.npR != null) {
            aVar.a(this.npR);
        }
        if (this.npS != null) {
            aVar.a(this.npS);
        }
    }

    public void a(a.InterfaceC0730a interfaceC0730a) {
        this.npM.b(interfaceC0730a);
        this.npN.b(interfaceC0730a);
        this.npO.b(interfaceC0730a);
        this.npP.b(interfaceC0730a);
        this.npQ.b(interfaceC0730a);
        if (this.npR != null) {
            this.npR.b(interfaceC0730a);
        }
        if (this.npS != null) {
            this.npS.b(interfaceC0730a);
        }
    }

    public void setProgress(float f) {
        this.npM.setProgress(f);
        this.npN.setProgress(f);
        this.npO.setProgress(f);
        this.npP.setProgress(f);
        this.npQ.setProgress(f);
        if (this.npR != null) {
            this.npR.setProgress(f);
        }
        if (this.npS != null) {
            this.npS.setProgress(f);
        }
    }

    public a<?, Integer> dFB() {
        return this.npQ;
    }

    @Nullable
    public a<?, Float> dFC() {
        return this.npR;
    }

    @Nullable
    public a<?, Float> dFD() {
        return this.npS;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.npN.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.npP.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.e.d value2 = this.npO.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.npM.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix j(float f) {
        PointF value = this.npN.getValue();
        PointF value2 = this.npM.getValue();
        com.tb.airbnb.lottie.e.d value3 = this.npO.getValue();
        float floatValue = this.npP.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.eO) {
            this.npM.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eP) {
            this.npN.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.noV) {
            this.npO.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eT) {
            this.npP.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eM) {
            this.npQ.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.fg && this.npR != null) {
            this.npR.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.fh && this.npS != null) {
            this.npS.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
