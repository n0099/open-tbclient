package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes5.dex */
public class o {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> npH;
    private final a<?, PointF> npI;
    private final a<com.tb.airbnb.lottie.e.d, com.tb.airbnb.lottie.e.d> npJ;
    private final a<Float, Float> npK;
    private final a<Integer, Integer> npL;
    @Nullable
    private final a<?, Float> npM;
    @Nullable
    private final a<?, Float> npN;

    public o(com.tb.airbnb.lottie.model.a.l lVar) {
        this.npH = lVar.dFG().dFE();
        this.npI = lVar.dFH().dFE();
        this.npJ = lVar.dFI().dFE();
        this.npK = lVar.dFJ().dFE();
        this.npL = lVar.dFK().dFE();
        if (lVar.dFL() != null) {
            this.npM = lVar.dFL().dFE();
        } else {
            this.npM = null;
        }
        if (lVar.dFM() != null) {
            this.npN = lVar.dFM().dFE();
        } else {
            this.npN = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.npH);
        aVar.a(this.npI);
        aVar.a(this.npJ);
        aVar.a(this.npK);
        aVar.a(this.npL);
        if (this.npM != null) {
            aVar.a(this.npM);
        }
        if (this.npN != null) {
            aVar.a(this.npN);
        }
    }

    public void a(a.InterfaceC0730a interfaceC0730a) {
        this.npH.b(interfaceC0730a);
        this.npI.b(interfaceC0730a);
        this.npJ.b(interfaceC0730a);
        this.npK.b(interfaceC0730a);
        this.npL.b(interfaceC0730a);
        if (this.npM != null) {
            this.npM.b(interfaceC0730a);
        }
        if (this.npN != null) {
            this.npN.b(interfaceC0730a);
        }
    }

    public void setProgress(float f) {
        this.npH.setProgress(f);
        this.npI.setProgress(f);
        this.npJ.setProgress(f);
        this.npK.setProgress(f);
        this.npL.setProgress(f);
        if (this.npM != null) {
            this.npM.setProgress(f);
        }
        if (this.npN != null) {
            this.npN.setProgress(f);
        }
    }

    public a<?, Integer> dFz() {
        return this.npL;
    }

    @Nullable
    public a<?, Float> dFA() {
        return this.npM;
    }

    @Nullable
    public a<?, Float> dFB() {
        return this.npN;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.npI.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.npK.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.e.d value2 = this.npJ.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.npH.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix j(float f) {
        PointF value = this.npI.getValue();
        PointF value2 = this.npH.getValue();
        com.tb.airbnb.lottie.e.d value3 = this.npJ.getValue();
        float floatValue = this.npK.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.eO) {
            this.npH.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eP) {
            this.npI.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.noQ) {
            this.npJ.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eT) {
            this.npK.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eM) {
            this.npL.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.fg && this.npM != null) {
            this.npM.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.fh && this.npN != null) {
            this.npN.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
