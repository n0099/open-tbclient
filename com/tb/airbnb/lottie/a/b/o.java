package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes17.dex */
public class o {
    private final Matrix matrix = new Matrix();
    private final a<Float, Float> pKA;
    private final a<Integer, Integer> pKB;
    @Nullable
    private final a<?, Float> pKC;
    @Nullable
    private final a<?, Float> pKD;
    private final a<PointF, PointF> pKx;
    private final a<?, PointF> pKy;
    private final a<com.tb.airbnb.lottie.e.d, com.tb.airbnb.lottie.e.d> pKz;

    public o(com.tb.airbnb.lottie.model.a.l lVar) {
        this.pKx = lVar.eyO().eyM();
        this.pKy = lVar.eyP().eyM();
        this.pKz = lVar.eyQ().eyM();
        this.pKA = lVar.eyR().eyM();
        this.pKB = lVar.eyS().eyM();
        if (lVar.eyT() != null) {
            this.pKC = lVar.eyT().eyM();
        } else {
            this.pKC = null;
        }
        if (lVar.eyU() != null) {
            this.pKD = lVar.eyU().eyM();
        } else {
            this.pKD = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.pKx);
        aVar.a(this.pKy);
        aVar.a(this.pKz);
        aVar.a(this.pKA);
        aVar.a(this.pKB);
        if (this.pKC != null) {
            aVar.a(this.pKC);
        }
        if (this.pKD != null) {
            aVar.a(this.pKD);
        }
    }

    public void a(a.InterfaceC1041a interfaceC1041a) {
        this.pKx.b(interfaceC1041a);
        this.pKy.b(interfaceC1041a);
        this.pKz.b(interfaceC1041a);
        this.pKA.b(interfaceC1041a);
        this.pKB.b(interfaceC1041a);
        if (this.pKC != null) {
            this.pKC.b(interfaceC1041a);
        }
        if (this.pKD != null) {
            this.pKD.b(interfaceC1041a);
        }
    }

    public void setProgress(float f) {
        this.pKx.setProgress(f);
        this.pKy.setProgress(f);
        this.pKz.setProgress(f);
        this.pKA.setProgress(f);
        this.pKB.setProgress(f);
        if (this.pKC != null) {
            this.pKC.setProgress(f);
        }
        if (this.pKD != null) {
            this.pKD.setProgress(f);
        }
    }

    public a<?, Integer> eyH() {
        return this.pKB;
    }

    @Nullable
    public a<?, Float> eyI() {
        return this.pKC;
    }

    @Nullable
    public a<?, Float> eyJ() {
        return this.pKD;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.pKy.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.pKA.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.e.d value2 = this.pKz.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.pKx.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix i(float f) {
        PointF value = this.pKy.getValue();
        PointF value2 = this.pKx.getValue();
        com.tb.airbnb.lottie.e.d value3 = this.pKz.getValue();
        float floatValue = this.pKA.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.k.BZ) {
            this.pKx.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.Ca) {
            this.pKy.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.pJG) {
            this.pKz.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.Ce) {
            this.pKA.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.BX) {
            this.pKB.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.Cp && this.pKC != null) {
            this.pKC.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.Cq && this.pKD != null) {
            this.pKD.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
