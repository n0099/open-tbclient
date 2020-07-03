package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes6.dex */
public class o {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> nGe;
    private final a<?, PointF> nGf;
    private final a<com.tb.airbnb.lottie.e.d, com.tb.airbnb.lottie.e.d> nGg;
    private final a<Float, Float> nGh;
    private final a<Integer, Integer> nGi;
    @Nullable
    private final a<?, Float> nGj;
    @Nullable
    private final a<?, Float> nGk;

    public o(com.tb.airbnb.lottie.model.a.l lVar) {
        this.nGe = lVar.dNE().dNC();
        this.nGf = lVar.dNF().dNC();
        this.nGg = lVar.dNG().dNC();
        this.nGh = lVar.dNH().dNC();
        this.nGi = lVar.dNI().dNC();
        if (lVar.dNJ() != null) {
            this.nGj = lVar.dNJ().dNC();
        } else {
            this.nGj = null;
        }
        if (lVar.dNK() != null) {
            this.nGk = lVar.dNK().dNC();
        } else {
            this.nGk = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.nGe);
        aVar.a(this.nGf);
        aVar.a(this.nGg);
        aVar.a(this.nGh);
        aVar.a(this.nGi);
        if (this.nGj != null) {
            aVar.a(this.nGj);
        }
        if (this.nGk != null) {
            aVar.a(this.nGk);
        }
    }

    public void a(a.InterfaceC0864a interfaceC0864a) {
        this.nGe.b(interfaceC0864a);
        this.nGf.b(interfaceC0864a);
        this.nGg.b(interfaceC0864a);
        this.nGh.b(interfaceC0864a);
        this.nGi.b(interfaceC0864a);
        if (this.nGj != null) {
            this.nGj.b(interfaceC0864a);
        }
        if (this.nGk != null) {
            this.nGk.b(interfaceC0864a);
        }
    }

    public void setProgress(float f) {
        this.nGe.setProgress(f);
        this.nGf.setProgress(f);
        this.nGg.setProgress(f);
        this.nGh.setProgress(f);
        this.nGi.setProgress(f);
        if (this.nGj != null) {
            this.nGj.setProgress(f);
        }
        if (this.nGk != null) {
            this.nGk.setProgress(f);
        }
    }

    public a<?, Integer> dNx() {
        return this.nGi;
    }

    @Nullable
    public a<?, Float> dNy() {
        return this.nGj;
    }

    @Nullable
    public a<?, Float> dNz() {
        return this.nGk;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.nGf.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.nGh.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.e.d value2 = this.nGg.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.nGe.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix i(float f) {
        PointF value = this.nGf.getValue();
        PointF value2 = this.nGe.getValue();
        com.tb.airbnb.lottie.e.d value3 = this.nGg.getValue();
        float floatValue = this.nGh.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.Bc) {
            this.nGe.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bd) {
            this.nGf.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.nFn) {
            this.nGg.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bh) {
            this.nGh.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Ba) {
            this.nGi.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bs && this.nGj != null) {
            this.nGj.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bt && this.nGk != null) {
            this.nGk.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
