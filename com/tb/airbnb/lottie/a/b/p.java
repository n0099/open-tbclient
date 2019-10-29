package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes6.dex */
public class p {
    private final a<PointF, PointF> ktE;
    private final a<?, PointF> ktF;
    private final a<com.tb.airbnb.lottie.model.k, com.tb.airbnb.lottie.model.k> ktG;
    private final a<Float, Float> ktH;
    private final a<Integer, Integer> ktI;
    @Nullable
    private final a<?, Float> ktJ;
    @Nullable
    private final a<?, Float> ktK;
    private final Matrix matrix = new Matrix();

    public p(com.tb.airbnb.lottie.model.a.l lVar) {
        this.ktE = lVar.cLv().cLn();
        this.ktF = lVar.cLw().cLn();
        this.ktG = lVar.cLx().cLn();
        this.ktH = lVar.cLy().cLn();
        this.ktI = lVar.cLz().cLn();
        if (lVar.cLA() != null) {
            this.ktJ = lVar.cLA().cLn();
        } else {
            this.ktJ = null;
        }
        if (lVar.cLB() != null) {
            this.ktK = lVar.cLB().cLn();
        } else {
            this.ktK = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.ktE);
        aVar.a(this.ktF);
        aVar.a(this.ktG);
        aVar.a(this.ktH);
        aVar.a(this.ktI);
        if (this.ktJ != null) {
            aVar.a(this.ktJ);
        }
        if (this.ktK != null) {
            aVar.a(this.ktK);
        }
    }

    public void a(a.InterfaceC0577a interfaceC0577a) {
        this.ktE.b(interfaceC0577a);
        this.ktF.b(interfaceC0577a);
        this.ktG.b(interfaceC0577a);
        this.ktH.b(interfaceC0577a);
        this.ktI.b(interfaceC0577a);
        if (this.ktJ != null) {
            this.ktJ.b(interfaceC0577a);
        }
        if (this.ktK != null) {
            this.ktK.b(interfaceC0577a);
        }
    }

    public void setProgress(float f) {
        this.ktE.setProgress(f);
        this.ktF.setProgress(f);
        this.ktG.setProgress(f);
        this.ktH.setProgress(f);
        this.ktI.setProgress(f);
        if (this.ktJ != null) {
            this.ktJ.setProgress(f);
        }
        if (this.ktK != null) {
            this.ktK.setProgress(f);
        }
    }

    public a<?, Integer> cLk() {
        return this.ktI;
    }

    @Nullable
    public a<?, Float> cLl() {
        return this.ktJ;
    }

    @Nullable
    public a<?, Float> cLm() {
        return this.ktK;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.ktF.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.ktH.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.model.k value2 = this.ktG.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.ktE.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix h(float f) {
        PointF value = this.ktF.getValue();
        PointF value2 = this.ktE.getValue();
        com.tb.airbnb.lottie.model.k value3 = this.ktG.getValue();
        float floatValue = this.ktH.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }
}
