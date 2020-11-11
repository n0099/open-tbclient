package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes16.dex */
public class o {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> pIU;
    private final a<?, PointF> pIV;
    private final a<com.tb.airbnb.lottie.e.d, com.tb.airbnb.lottie.e.d> pIW;
    private final a<Float, Float> pIX;
    private final a<Integer, Integer> pIY;
    @Nullable
    private final a<?, Float> pIZ;
    @Nullable
    private final a<?, Float> pJa;

    public o(com.tb.airbnb.lottie.model.a.l lVar) {
        this.pIU = lVar.eyN().eyL();
        this.pIV = lVar.eyO().eyL();
        this.pIW = lVar.eyP().eyL();
        this.pIX = lVar.eyQ().eyL();
        this.pIY = lVar.eyR().eyL();
        if (lVar.eyS() != null) {
            this.pIZ = lVar.eyS().eyL();
        } else {
            this.pIZ = null;
        }
        if (lVar.eyT() != null) {
            this.pJa = lVar.eyT().eyL();
        } else {
            this.pJa = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.pIU);
        aVar.a(this.pIV);
        aVar.a(this.pIW);
        aVar.a(this.pIX);
        aVar.a(this.pIY);
        if (this.pIZ != null) {
            aVar.a(this.pIZ);
        }
        if (this.pJa != null) {
            aVar.a(this.pJa);
        }
    }

    public void a(a.InterfaceC1038a interfaceC1038a) {
        this.pIU.b(interfaceC1038a);
        this.pIV.b(interfaceC1038a);
        this.pIW.b(interfaceC1038a);
        this.pIX.b(interfaceC1038a);
        this.pIY.b(interfaceC1038a);
        if (this.pIZ != null) {
            this.pIZ.b(interfaceC1038a);
        }
        if (this.pJa != null) {
            this.pJa.b(interfaceC1038a);
        }
    }

    public void setProgress(float f) {
        this.pIU.setProgress(f);
        this.pIV.setProgress(f);
        this.pIW.setProgress(f);
        this.pIX.setProgress(f);
        this.pIY.setProgress(f);
        if (this.pIZ != null) {
            this.pIZ.setProgress(f);
        }
        if (this.pJa != null) {
            this.pJa.setProgress(f);
        }
    }

    public a<?, Integer> eyG() {
        return this.pIY;
    }

    @Nullable
    public a<?, Float> eyH() {
        return this.pIZ;
    }

    @Nullable
    public a<?, Float> eyI() {
        return this.pJa;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.pIV.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.pIX.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.e.d value2 = this.pIW.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.pIU.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix i(float f) {
        PointF value = this.pIV.getValue();
        PointF value2 = this.pIU.getValue();
        com.tb.airbnb.lottie.e.d value3 = this.pIW.getValue();
        float floatValue = this.pIX.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.k.BZ) {
            this.pIU.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.Ca) {
            this.pIV.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.pId) {
            this.pIW.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.Ce) {
            this.pIX.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.BX) {
            this.pIY.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.Cp && this.pIZ != null) {
            this.pIZ.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.Cq && this.pJa != null) {
            this.pJa.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
