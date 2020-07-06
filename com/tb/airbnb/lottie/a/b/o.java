package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes6.dex */
public class o {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> nGh;
    private final a<?, PointF> nGi;
    private final a<com.tb.airbnb.lottie.e.d, com.tb.airbnb.lottie.e.d> nGj;
    private final a<Float, Float> nGk;
    private final a<Integer, Integer> nGl;
    @Nullable
    private final a<?, Float> nGm;
    @Nullable
    private final a<?, Float> nGn;

    public o(com.tb.airbnb.lottie.model.a.l lVar) {
        this.nGh = lVar.dNI().dNG();
        this.nGi = lVar.dNJ().dNG();
        this.nGj = lVar.dNK().dNG();
        this.nGk = lVar.dNL().dNG();
        this.nGl = lVar.dNM().dNG();
        if (lVar.dNN() != null) {
            this.nGm = lVar.dNN().dNG();
        } else {
            this.nGm = null;
        }
        if (lVar.dNO() != null) {
            this.nGn = lVar.dNO().dNG();
        } else {
            this.nGn = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.nGh);
        aVar.a(this.nGi);
        aVar.a(this.nGj);
        aVar.a(this.nGk);
        aVar.a(this.nGl);
        if (this.nGm != null) {
            aVar.a(this.nGm);
        }
        if (this.nGn != null) {
            aVar.a(this.nGn);
        }
    }

    public void a(a.InterfaceC0865a interfaceC0865a) {
        this.nGh.b(interfaceC0865a);
        this.nGi.b(interfaceC0865a);
        this.nGj.b(interfaceC0865a);
        this.nGk.b(interfaceC0865a);
        this.nGl.b(interfaceC0865a);
        if (this.nGm != null) {
            this.nGm.b(interfaceC0865a);
        }
        if (this.nGn != null) {
            this.nGn.b(interfaceC0865a);
        }
    }

    public void setProgress(float f) {
        this.nGh.setProgress(f);
        this.nGi.setProgress(f);
        this.nGj.setProgress(f);
        this.nGk.setProgress(f);
        this.nGl.setProgress(f);
        if (this.nGm != null) {
            this.nGm.setProgress(f);
        }
        if (this.nGn != null) {
            this.nGn.setProgress(f);
        }
    }

    public a<?, Integer> dNB() {
        return this.nGl;
    }

    @Nullable
    public a<?, Float> dNC() {
        return this.nGm;
    }

    @Nullable
    public a<?, Float> dND() {
        return this.nGn;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.nGi.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.nGk.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.e.d value2 = this.nGj.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.nGh.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix i(float f) {
        PointF value = this.nGi.getValue();
        PointF value2 = this.nGh.getValue();
        com.tb.airbnb.lottie.e.d value3 = this.nGj.getValue();
        float floatValue = this.nGk.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.Bc) {
            this.nGh.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bd) {
            this.nGi.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.nFq) {
            this.nGj.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bh) {
            this.nGk.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Ba) {
            this.nGl.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bs && this.nGm != null) {
            this.nGm.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bt && this.nGn != null) {
            this.nGn.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
