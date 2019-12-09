package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes6.dex */
public class p {
    private final a<PointF, PointF> ksN;
    private final a<?, PointF> ksO;
    private final a<com.tb.airbnb.lottie.model.k, com.tb.airbnb.lottie.model.k> ksP;
    private final a<Float, Float> ksQ;
    private final a<Integer, Integer> ksR;
    @Nullable
    private final a<?, Float> ksS;
    @Nullable
    private final a<?, Float> ksT;
    private final Matrix matrix = new Matrix();

    public p(com.tb.airbnb.lottie.model.a.l lVar) {
        this.ksN = lVar.cLt().cLl();
        this.ksO = lVar.cLu().cLl();
        this.ksP = lVar.cLv().cLl();
        this.ksQ = lVar.cLw().cLl();
        this.ksR = lVar.cLx().cLl();
        if (lVar.cLy() != null) {
            this.ksS = lVar.cLy().cLl();
        } else {
            this.ksS = null;
        }
        if (lVar.cLz() != null) {
            this.ksT = lVar.cLz().cLl();
        } else {
            this.ksT = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.ksN);
        aVar.a(this.ksO);
        aVar.a(this.ksP);
        aVar.a(this.ksQ);
        aVar.a(this.ksR);
        if (this.ksS != null) {
            aVar.a(this.ksS);
        }
        if (this.ksT != null) {
            aVar.a(this.ksT);
        }
    }

    public void a(a.InterfaceC0572a interfaceC0572a) {
        this.ksN.b(interfaceC0572a);
        this.ksO.b(interfaceC0572a);
        this.ksP.b(interfaceC0572a);
        this.ksQ.b(interfaceC0572a);
        this.ksR.b(interfaceC0572a);
        if (this.ksS != null) {
            this.ksS.b(interfaceC0572a);
        }
        if (this.ksT != null) {
            this.ksT.b(interfaceC0572a);
        }
    }

    public void setProgress(float f) {
        this.ksN.setProgress(f);
        this.ksO.setProgress(f);
        this.ksP.setProgress(f);
        this.ksQ.setProgress(f);
        this.ksR.setProgress(f);
        if (this.ksS != null) {
            this.ksS.setProgress(f);
        }
        if (this.ksT != null) {
            this.ksT.setProgress(f);
        }
    }

    public a<?, Integer> cLi() {
        return this.ksR;
    }

    @Nullable
    public a<?, Float> cLj() {
        return this.ksS;
    }

    @Nullable
    public a<?, Float> cLk() {
        return this.ksT;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.ksO.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.ksQ.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.model.k value2 = this.ksP.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.ksN.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix h(float f) {
        PointF value = this.ksO.getValue();
        PointF value2 = this.ksN.getValue();
        com.tb.airbnb.lottie.model.k value3 = this.ksP.getValue();
        float floatValue = this.ksQ.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }
}
