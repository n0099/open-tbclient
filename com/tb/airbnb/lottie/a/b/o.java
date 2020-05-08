package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes6.dex */
public class o {
    private final a<PointF, PointF> mPa;
    private final a<?, PointF> mPb;
    private final a<com.tb.airbnb.lottie.e.d, com.tb.airbnb.lottie.e.d> mPc;
    private final a<Float, Float> mPd;
    private final a<Integer, Integer> mPe;
    @Nullable
    private final a<?, Float> mPf;
    @Nullable
    private final a<?, Float> mPg;
    private final Matrix matrix = new Matrix();

    public o(com.tb.airbnb.lottie.model.a.l lVar) {
        this.mPa = lVar.dBq().dBo();
        this.mPb = lVar.dBr().dBo();
        this.mPc = lVar.dBs().dBo();
        this.mPd = lVar.dBt().dBo();
        this.mPe = lVar.dBu().dBo();
        if (lVar.dBv() != null) {
            this.mPf = lVar.dBv().dBo();
        } else {
            this.mPf = null;
        }
        if (lVar.dBw() != null) {
            this.mPg = lVar.dBw().dBo();
        } else {
            this.mPg = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.mPa);
        aVar.a(this.mPb);
        aVar.a(this.mPc);
        aVar.a(this.mPd);
        aVar.a(this.mPe);
        if (this.mPf != null) {
            aVar.a(this.mPf);
        }
        if (this.mPg != null) {
            aVar.a(this.mPg);
        }
    }

    public void a(a.InterfaceC0784a interfaceC0784a) {
        this.mPa.b(interfaceC0784a);
        this.mPb.b(interfaceC0784a);
        this.mPc.b(interfaceC0784a);
        this.mPd.b(interfaceC0784a);
        this.mPe.b(interfaceC0784a);
        if (this.mPf != null) {
            this.mPf.b(interfaceC0784a);
        }
        if (this.mPg != null) {
            this.mPg.b(interfaceC0784a);
        }
    }

    public void setProgress(float f) {
        this.mPa.setProgress(f);
        this.mPb.setProgress(f);
        this.mPc.setProgress(f);
        this.mPd.setProgress(f);
        this.mPe.setProgress(f);
        if (this.mPf != null) {
            this.mPf.setProgress(f);
        }
        if (this.mPg != null) {
            this.mPg.setProgress(f);
        }
    }

    public a<?, Integer> dBj() {
        return this.mPe;
    }

    @Nullable
    public a<?, Float> dBk() {
        return this.mPf;
    }

    @Nullable
    public a<?, Float> dBl() {
        return this.mPg;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.mPb.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.mPd.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.e.d value2 = this.mPc.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.mPa.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix g(float f) {
        PointF value = this.mPb.getValue();
        PointF value2 = this.mPa.getValue();
        com.tb.airbnb.lottie.e.d value3 = this.mPc.getValue();
        float floatValue = this.mPd.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.Az) {
            this.mPa.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AA) {
            this.mPb.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.mOj) {
            this.mPc.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AE) {
            this.mPd.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Ax) {
            this.mPe.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AQ && this.mPf != null) {
            this.mPf.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AR && this.mPg != null) {
            this.mPg.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
