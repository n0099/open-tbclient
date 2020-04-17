package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes6.dex */
public class o {
    private final a<PointF, PointF> mOX;
    private final a<?, PointF> mOY;
    private final a<com.tb.airbnb.lottie.e.d, com.tb.airbnb.lottie.e.d> mOZ;
    private final a<Float, Float> mPa;
    private final a<Integer, Integer> mPb;
    @Nullable
    private final a<?, Float> mPc;
    @Nullable
    private final a<?, Float> mPd;
    private final Matrix matrix = new Matrix();

    public o(com.tb.airbnb.lottie.model.a.l lVar) {
        this.mOX = lVar.dBu().dBs();
        this.mOY = lVar.dBv().dBs();
        this.mOZ = lVar.dBw().dBs();
        this.mPa = lVar.dBx().dBs();
        this.mPb = lVar.dBy().dBs();
        if (lVar.dBz() != null) {
            this.mPc = lVar.dBz().dBs();
        } else {
            this.mPc = null;
        }
        if (lVar.dBA() != null) {
            this.mPd = lVar.dBA().dBs();
        } else {
            this.mPd = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.mOX);
        aVar.a(this.mOY);
        aVar.a(this.mOZ);
        aVar.a(this.mPa);
        aVar.a(this.mPb);
        if (this.mPc != null) {
            aVar.a(this.mPc);
        }
        if (this.mPd != null) {
            aVar.a(this.mPd);
        }
    }

    public void a(a.InterfaceC0763a interfaceC0763a) {
        this.mOX.b(interfaceC0763a);
        this.mOY.b(interfaceC0763a);
        this.mOZ.b(interfaceC0763a);
        this.mPa.b(interfaceC0763a);
        this.mPb.b(interfaceC0763a);
        if (this.mPc != null) {
            this.mPc.b(interfaceC0763a);
        }
        if (this.mPd != null) {
            this.mPd.b(interfaceC0763a);
        }
    }

    public void setProgress(float f) {
        this.mOX.setProgress(f);
        this.mOY.setProgress(f);
        this.mOZ.setProgress(f);
        this.mPa.setProgress(f);
        this.mPb.setProgress(f);
        if (this.mPc != null) {
            this.mPc.setProgress(f);
        }
        if (this.mPd != null) {
            this.mPd.setProgress(f);
        }
    }

    public a<?, Integer> dBn() {
        return this.mPb;
    }

    @Nullable
    public a<?, Float> dBo() {
        return this.mPc;
    }

    @Nullable
    public a<?, Float> dBp() {
        return this.mPd;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.mOY.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.mPa.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.e.d value2 = this.mOZ.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.mOX.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix g(float f) {
        PointF value = this.mOY.getValue();
        PointF value2 = this.mOX.getValue();
        com.tb.airbnb.lottie.e.d value3 = this.mOZ.getValue();
        float floatValue = this.mPa.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.Az) {
            this.mOX.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AA) {
            this.mOY.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.mOg) {
            this.mOZ.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AE) {
            this.mPa.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Ax) {
            this.mPb.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AQ && this.mPc != null) {
            this.mPc.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AR && this.mPd != null) {
            this.mPd.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
