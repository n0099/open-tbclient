package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes2.dex */
public class p {
    private final a<PointF, PointF> mNC;
    private final a<?, PointF> mND;
    private final a<com.tb.airbnb.lottie.model.k, com.tb.airbnb.lottie.model.k> mNE;
    private final a<Float, Float> mNF;
    private final a<Integer, Integer> mNG;
    @Nullable
    private final a<?, Float> mNH;
    @Nullable
    private final a<?, Float> mNI;
    private final Matrix matrix = new Matrix();

    public p(com.tb.airbnb.lottie.model.a.l lVar) {
        this.mNC = lVar.dBB().dBq();
        this.mND = lVar.dBC().dBq();
        this.mNE = lVar.dBD().dBq();
        this.mNF = lVar.dBE().dBq();
        this.mNG = lVar.dBF().dBq();
        if (lVar.dBG() != null) {
            this.mNH = lVar.dBG().dBq();
        } else {
            this.mNH = null;
        }
        if (lVar.dBH() != null) {
            this.mNI = lVar.dBH().dBq();
        } else {
            this.mNI = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.mNC);
        aVar.a(this.mND);
        aVar.a(this.mNE);
        aVar.a(this.mNF);
        aVar.a(this.mNG);
        if (this.mNH != null) {
            aVar.a(this.mNH);
        }
        if (this.mNI != null) {
            aVar.a(this.mNI);
        }
    }

    public void a(a.InterfaceC0687a interfaceC0687a) {
        this.mNC.b(interfaceC0687a);
        this.mND.b(interfaceC0687a);
        this.mNE.b(interfaceC0687a);
        this.mNF.b(interfaceC0687a);
        this.mNG.b(interfaceC0687a);
        if (this.mNH != null) {
            this.mNH.b(interfaceC0687a);
        }
        if (this.mNI != null) {
            this.mNI.b(interfaceC0687a);
        }
    }

    public void setProgress(float f) {
        this.mNC.setProgress(f);
        this.mND.setProgress(f);
        this.mNE.setProgress(f);
        this.mNF.setProgress(f);
        this.mNG.setProgress(f);
        if (this.mNH != null) {
            this.mNH.setProgress(f);
        }
        if (this.mNI != null) {
            this.mNI.setProgress(f);
        }
    }

    public a<?, Integer> dBn() {
        return this.mNG;
    }

    @Nullable
    public a<?, Float> dBo() {
        return this.mNH;
    }

    @Nullable
    public a<?, Float> dBp() {
        return this.mNI;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.mND.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.mNF.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.model.k value2 = this.mNE.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.mNC.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix j(float f) {
        PointF value = this.mND.getValue();
        PointF value2 = this.mNC.getValue();
        com.tb.airbnb.lottie.model.k value3 = this.mNE.getValue();
        float floatValue = this.mNF.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }
}
