package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes20.dex */
public class o {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> pBD;
    private final a<?, PointF> pBE;
    private final a<com.tb.airbnb.lottie.e.d, com.tb.airbnb.lottie.e.d> pBF;
    private final a<Float, Float> pBG;
    private final a<Integer, Integer> pBH;
    @Nullable
    private final a<?, Float> pBI;
    @Nullable
    private final a<?, Float> pBJ;

    public o(com.tb.airbnb.lottie.model.a.l lVar) {
        this.pBD = lVar.eBl().eBj();
        this.pBE = lVar.eBm().eBj();
        this.pBF = lVar.eBn().eBj();
        this.pBG = lVar.eBo().eBj();
        this.pBH = lVar.eBp().eBj();
        if (lVar.eBq() != null) {
            this.pBI = lVar.eBq().eBj();
        } else {
            this.pBI = null;
        }
        if (lVar.eBr() != null) {
            this.pBJ = lVar.eBr().eBj();
        } else {
            this.pBJ = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.pBD);
        aVar.a(this.pBE);
        aVar.a(this.pBF);
        aVar.a(this.pBG);
        aVar.a(this.pBH);
        if (this.pBI != null) {
            aVar.a(this.pBI);
        }
        if (this.pBJ != null) {
            aVar.a(this.pBJ);
        }
    }

    public void a(a.InterfaceC1019a interfaceC1019a) {
        this.pBD.b(interfaceC1019a);
        this.pBE.b(interfaceC1019a);
        this.pBF.b(interfaceC1019a);
        this.pBG.b(interfaceC1019a);
        this.pBH.b(interfaceC1019a);
        if (this.pBI != null) {
            this.pBI.b(interfaceC1019a);
        }
        if (this.pBJ != null) {
            this.pBJ.b(interfaceC1019a);
        }
    }

    public void setProgress(float f) {
        this.pBD.setProgress(f);
        this.pBE.setProgress(f);
        this.pBF.setProgress(f);
        this.pBG.setProgress(f);
        this.pBH.setProgress(f);
        if (this.pBI != null) {
            this.pBI.setProgress(f);
        }
        if (this.pBJ != null) {
            this.pBJ.setProgress(f);
        }
    }

    public a<?, Integer> eBe() {
        return this.pBH;
    }

    @Nullable
    public a<?, Float> eBf() {
        return this.pBI;
    }

    @Nullable
    public a<?, Float> eBg() {
        return this.pBJ;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.pBE.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.pBG.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.e.d value2 = this.pBF.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.pBD.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix h(float f) {
        PointF value = this.pBE.getValue();
        PointF value2 = this.pBD.getValue();
        com.tb.airbnb.lottie.e.d value3 = this.pBF.getValue();
        float floatValue = this.pBG.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.k.CV) {
            this.pBD.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.CW) {
            this.pBE.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.pAM) {
            this.pBF.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.Da) {
            this.pBG.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.CP) {
            this.pBH.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.Dl && this.pBI != null) {
            this.pBI.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.Dm && this.pBJ != null) {
            this.pBJ.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
