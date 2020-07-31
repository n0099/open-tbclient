package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes5.dex */
public class o {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> nOP;
    private final a<?, PointF> nOQ;
    private final a<com.tb.airbnb.lottie.e.d, com.tb.airbnb.lottie.e.d> nOR;
    private final a<Float, Float> nOS;
    private final a<Integer, Integer> nOT;
    @Nullable
    private final a<?, Float> nOU;
    @Nullable
    private final a<?, Float> nOV;

    public o(com.tb.airbnb.lottie.model.a.l lVar) {
        this.nOP = lVar.dRe().dRc();
        this.nOQ = lVar.dRf().dRc();
        this.nOR = lVar.dRg().dRc();
        this.nOS = lVar.dRh().dRc();
        this.nOT = lVar.dRi().dRc();
        if (lVar.dRj() != null) {
            this.nOU = lVar.dRj().dRc();
        } else {
            this.nOU = null;
        }
        if (lVar.dRk() != null) {
            this.nOV = lVar.dRk().dRc();
        } else {
            this.nOV = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.nOP);
        aVar.a(this.nOQ);
        aVar.a(this.nOR);
        aVar.a(this.nOS);
        aVar.a(this.nOT);
        if (this.nOU != null) {
            aVar.a(this.nOU);
        }
        if (this.nOV != null) {
            aVar.a(this.nOV);
        }
    }

    public void a(a.InterfaceC0874a interfaceC0874a) {
        this.nOP.b(interfaceC0874a);
        this.nOQ.b(interfaceC0874a);
        this.nOR.b(interfaceC0874a);
        this.nOS.b(interfaceC0874a);
        this.nOT.b(interfaceC0874a);
        if (this.nOU != null) {
            this.nOU.b(interfaceC0874a);
        }
        if (this.nOV != null) {
            this.nOV.b(interfaceC0874a);
        }
    }

    public void setProgress(float f) {
        this.nOP.setProgress(f);
        this.nOQ.setProgress(f);
        this.nOR.setProgress(f);
        this.nOS.setProgress(f);
        this.nOT.setProgress(f);
        if (this.nOU != null) {
            this.nOU.setProgress(f);
        }
        if (this.nOV != null) {
            this.nOV.setProgress(f);
        }
    }

    public a<?, Integer> dQX() {
        return this.nOT;
    }

    @Nullable
    public a<?, Float> dQY() {
        return this.nOU;
    }

    @Nullable
    public a<?, Float> dQZ() {
        return this.nOV;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.nOQ.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.nOS.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.e.d value2 = this.nOR.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.nOP.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix i(float f) {
        PointF value = this.nOQ.getValue();
        PointF value2 = this.nOP.getValue();
        com.tb.airbnb.lottie.e.d value3 = this.nOR.getValue();
        float floatValue = this.nOS.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.Be) {
            this.nOP.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bf) {
            this.nOQ.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.nNY) {
            this.nOR.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bj) {
            this.nOS.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bc) {
            this.nOT.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bu && this.nOU != null) {
            this.nOU.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bv && this.nOV != null) {
            this.nOV.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
