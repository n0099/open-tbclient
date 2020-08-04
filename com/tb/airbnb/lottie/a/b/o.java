package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes5.dex */
public class o {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> nOR;
    private final a<?, PointF> nOS;
    private final a<com.tb.airbnb.lottie.e.d, com.tb.airbnb.lottie.e.d> nOT;
    private final a<Float, Float> nOU;
    private final a<Integer, Integer> nOV;
    @Nullable
    private final a<?, Float> nOW;
    @Nullable
    private final a<?, Float> nOX;

    public o(com.tb.airbnb.lottie.model.a.l lVar) {
        this.nOR = lVar.dRf().dRd();
        this.nOS = lVar.dRg().dRd();
        this.nOT = lVar.dRh().dRd();
        this.nOU = lVar.dRi().dRd();
        this.nOV = lVar.dRj().dRd();
        if (lVar.dRk() != null) {
            this.nOW = lVar.dRk().dRd();
        } else {
            this.nOW = null;
        }
        if (lVar.dRl() != null) {
            this.nOX = lVar.dRl().dRd();
        } else {
            this.nOX = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.nOR);
        aVar.a(this.nOS);
        aVar.a(this.nOT);
        aVar.a(this.nOU);
        aVar.a(this.nOV);
        if (this.nOW != null) {
            aVar.a(this.nOW);
        }
        if (this.nOX != null) {
            aVar.a(this.nOX);
        }
    }

    public void a(a.InterfaceC0874a interfaceC0874a) {
        this.nOR.b(interfaceC0874a);
        this.nOS.b(interfaceC0874a);
        this.nOT.b(interfaceC0874a);
        this.nOU.b(interfaceC0874a);
        this.nOV.b(interfaceC0874a);
        if (this.nOW != null) {
            this.nOW.b(interfaceC0874a);
        }
        if (this.nOX != null) {
            this.nOX.b(interfaceC0874a);
        }
    }

    public void setProgress(float f) {
        this.nOR.setProgress(f);
        this.nOS.setProgress(f);
        this.nOT.setProgress(f);
        this.nOU.setProgress(f);
        this.nOV.setProgress(f);
        if (this.nOW != null) {
            this.nOW.setProgress(f);
        }
        if (this.nOX != null) {
            this.nOX.setProgress(f);
        }
    }

    public a<?, Integer> dQY() {
        return this.nOV;
    }

    @Nullable
    public a<?, Float> dQZ() {
        return this.nOW;
    }

    @Nullable
    public a<?, Float> dRa() {
        return this.nOX;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.nOS.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.nOU.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.e.d value2 = this.nOT.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.nOR.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix i(float f) {
        PointF value = this.nOS.getValue();
        PointF value2 = this.nOR.getValue();
        com.tb.airbnb.lottie.e.d value3 = this.nOT.getValue();
        float floatValue = this.nOU.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.Be) {
            this.nOR.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bf) {
            this.nOS.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.nOa) {
            this.nOT.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bj) {
            this.nOU.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bc) {
            this.nOV.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bu && this.nOW != null) {
            this.nOW.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bv && this.nOX != null) {
            this.nOX.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
