package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes16.dex */
public class o {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> oId;
    private final a<?, PointF> oIe;
    private final a<com.tb.airbnb.lottie.e.d, com.tb.airbnb.lottie.e.d> oIf;
    private final a<Float, Float> oIg;
    private final a<Integer, Integer> oIh;
    @Nullable
    private final a<?, Float> oIi;
    @Nullable
    private final a<?, Float> oIj;

    public o(com.tb.airbnb.lottie.model.a.l lVar) {
        this.oId = lVar.ekY().ekW();
        this.oIe = lVar.ekZ().ekW();
        this.oIf = lVar.ela().ekW();
        this.oIg = lVar.elb().ekW();
        this.oIh = lVar.elc().ekW();
        if (lVar.eld() != null) {
            this.oIi = lVar.eld().ekW();
        } else {
            this.oIi = null;
        }
        if (lVar.ele() != null) {
            this.oIj = lVar.ele().ekW();
        } else {
            this.oIj = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.oId);
        aVar.a(this.oIe);
        aVar.a(this.oIf);
        aVar.a(this.oIg);
        aVar.a(this.oIh);
        if (this.oIi != null) {
            aVar.a(this.oIi);
        }
        if (this.oIj != null) {
            aVar.a(this.oIj);
        }
    }

    public void a(a.InterfaceC0947a interfaceC0947a) {
        this.oId.b(interfaceC0947a);
        this.oIe.b(interfaceC0947a);
        this.oIf.b(interfaceC0947a);
        this.oIg.b(interfaceC0947a);
        this.oIh.b(interfaceC0947a);
        if (this.oIi != null) {
            this.oIi.b(interfaceC0947a);
        }
        if (this.oIj != null) {
            this.oIj.b(interfaceC0947a);
        }
    }

    public void setProgress(float f) {
        this.oId.setProgress(f);
        this.oIe.setProgress(f);
        this.oIf.setProgress(f);
        this.oIg.setProgress(f);
        this.oIh.setProgress(f);
        if (this.oIi != null) {
            this.oIi.setProgress(f);
        }
        if (this.oIj != null) {
            this.oIj.setProgress(f);
        }
    }

    public a<?, Integer> ekR() {
        return this.oIh;
    }

    @Nullable
    public a<?, Float> ekS() {
        return this.oIi;
    }

    @Nullable
    public a<?, Float> ekT() {
        return this.oIj;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.oIe.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.oIg.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.e.d value2 = this.oIf.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.oId.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix i(float f) {
        PointF value = this.oIe.getValue();
        PointF value2 = this.oId.getValue();
        com.tb.airbnb.lottie.e.d value3 = this.oIf.getValue();
        float floatValue = this.oIg.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.BZ) {
            this.oId.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Ca) {
            this.oIe.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.oHm) {
            this.oIf.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Ce) {
            this.oIg.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.BX) {
            this.oIh.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Cp && this.oIi != null) {
            this.oIi.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Cq && this.oIj != null) {
            this.oIj.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
