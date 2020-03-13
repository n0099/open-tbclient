package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes6.dex */
public class o {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> nqB;
    private final a<?, PointF> nqC;
    private final a<com.tb.airbnb.lottie.e.d, com.tb.airbnb.lottie.e.d> nqD;
    private final a<Float, Float> nqE;
    private final a<Integer, Integer> nqF;
    @Nullable
    private final a<?, Float> nqG;
    @Nullable
    private final a<?, Float> nqH;

    public o(com.tb.airbnb.lottie.model.a.l lVar) {
        this.nqB = lVar.dGS().dGQ();
        this.nqC = lVar.dGT().dGQ();
        this.nqD = lVar.dGU().dGQ();
        this.nqE = lVar.dGV().dGQ();
        this.nqF = lVar.dGW().dGQ();
        if (lVar.dGX() != null) {
            this.nqG = lVar.dGX().dGQ();
        } else {
            this.nqG = null;
        }
        if (lVar.dGY() != null) {
            this.nqH = lVar.dGY().dGQ();
        } else {
            this.nqH = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.nqB);
        aVar.a(this.nqC);
        aVar.a(this.nqD);
        aVar.a(this.nqE);
        aVar.a(this.nqF);
        if (this.nqG != null) {
            aVar.a(this.nqG);
        }
        if (this.nqH != null) {
            aVar.a(this.nqH);
        }
    }

    public void a(a.InterfaceC0738a interfaceC0738a) {
        this.nqB.b(interfaceC0738a);
        this.nqC.b(interfaceC0738a);
        this.nqD.b(interfaceC0738a);
        this.nqE.b(interfaceC0738a);
        this.nqF.b(interfaceC0738a);
        if (this.nqG != null) {
            this.nqG.b(interfaceC0738a);
        }
        if (this.nqH != null) {
            this.nqH.b(interfaceC0738a);
        }
    }

    public void setProgress(float f) {
        this.nqB.setProgress(f);
        this.nqC.setProgress(f);
        this.nqD.setProgress(f);
        this.nqE.setProgress(f);
        this.nqF.setProgress(f);
        if (this.nqG != null) {
            this.nqG.setProgress(f);
        }
        if (this.nqH != null) {
            this.nqH.setProgress(f);
        }
    }

    public a<?, Integer> dGL() {
        return this.nqF;
    }

    @Nullable
    public a<?, Float> dGM() {
        return this.nqG;
    }

    @Nullable
    public a<?, Float> dGN() {
        return this.nqH;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.nqC.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.nqE.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.e.d value2 = this.nqD.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.nqB.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix j(float f) {
        PointF value = this.nqC.getValue();
        PointF value2 = this.nqB.getValue();
        com.tb.airbnb.lottie.e.d value3 = this.nqD.getValue();
        float floatValue = this.nqE.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.eR) {
            this.nqB.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eS) {
            this.nqC.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.npK) {
            this.nqD.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eW) {
            this.nqE.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eP) {
            this.nqF.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.fk && this.nqG != null) {
            this.nqG.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.fn && this.nqH != null) {
            this.nqH.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
