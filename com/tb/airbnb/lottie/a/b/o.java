package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes20.dex */
public class o {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> pBB;
    private final a<?, PointF> pBC;
    private final a<com.tb.airbnb.lottie.e.d, com.tb.airbnb.lottie.e.d> pBD;
    private final a<Float, Float> pBE;
    private final a<Integer, Integer> pBF;
    @Nullable
    private final a<?, Float> pBG;
    @Nullable
    private final a<?, Float> pBH;

    public o(com.tb.airbnb.lottie.model.a.l lVar) {
        this.pBB = lVar.eBk().eBi();
        this.pBC = lVar.eBl().eBi();
        this.pBD = lVar.eBm().eBi();
        this.pBE = lVar.eBn().eBi();
        this.pBF = lVar.eBo().eBi();
        if (lVar.eBp() != null) {
            this.pBG = lVar.eBp().eBi();
        } else {
            this.pBG = null;
        }
        if (lVar.eBq() != null) {
            this.pBH = lVar.eBq().eBi();
        } else {
            this.pBH = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.pBB);
        aVar.a(this.pBC);
        aVar.a(this.pBD);
        aVar.a(this.pBE);
        aVar.a(this.pBF);
        if (this.pBG != null) {
            aVar.a(this.pBG);
        }
        if (this.pBH != null) {
            aVar.a(this.pBH);
        }
    }

    public void a(a.InterfaceC1019a interfaceC1019a) {
        this.pBB.b(interfaceC1019a);
        this.pBC.b(interfaceC1019a);
        this.pBD.b(interfaceC1019a);
        this.pBE.b(interfaceC1019a);
        this.pBF.b(interfaceC1019a);
        if (this.pBG != null) {
            this.pBG.b(interfaceC1019a);
        }
        if (this.pBH != null) {
            this.pBH.b(interfaceC1019a);
        }
    }

    public void setProgress(float f) {
        this.pBB.setProgress(f);
        this.pBC.setProgress(f);
        this.pBD.setProgress(f);
        this.pBE.setProgress(f);
        this.pBF.setProgress(f);
        if (this.pBG != null) {
            this.pBG.setProgress(f);
        }
        if (this.pBH != null) {
            this.pBH.setProgress(f);
        }
    }

    public a<?, Integer> eBd() {
        return this.pBF;
    }

    @Nullable
    public a<?, Float> eBe() {
        return this.pBG;
    }

    @Nullable
    public a<?, Float> eBf() {
        return this.pBH;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.pBC.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.pBE.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.e.d value2 = this.pBD.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.pBB.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix h(float f) {
        PointF value = this.pBC.getValue();
        PointF value2 = this.pBB.getValue();
        com.tb.airbnb.lottie.e.d value3 = this.pBD.getValue();
        float floatValue = this.pBE.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.k.CV) {
            this.pBB.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.CW) {
            this.pBC.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.pAK) {
            this.pBD.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.Da) {
            this.pBE.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.CP) {
            this.pBF.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.Dl && this.pBG != null) {
            this.pBG.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.Dm && this.pBH != null) {
            this.pBH.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
