package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes6.dex */
public class o {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> nkp;
    private final a<?, PointF> nkq;
    private final a<com.tb.airbnb.lottie.e.d, com.tb.airbnb.lottie.e.d> nkr;
    private final a<Float, Float> nks;
    private final a<Integer, Integer> nkt;
    @Nullable
    private final a<?, Float> nku;
    @Nullable
    private final a<?, Float> nkv;

    public o(com.tb.airbnb.lottie.model.a.l lVar) {
        this.nkp = lVar.dIY().dIW();
        this.nkq = lVar.dIZ().dIW();
        this.nkr = lVar.dJa().dIW();
        this.nks = lVar.dJb().dIW();
        this.nkt = lVar.dJc().dIW();
        if (lVar.dJd() != null) {
            this.nku = lVar.dJd().dIW();
        } else {
            this.nku = null;
        }
        if (lVar.dJe() != null) {
            this.nkv = lVar.dJe().dIW();
        } else {
            this.nkv = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.nkp);
        aVar.a(this.nkq);
        aVar.a(this.nkr);
        aVar.a(this.nks);
        aVar.a(this.nkt);
        if (this.nku != null) {
            aVar.a(this.nku);
        }
        if (this.nkv != null) {
            aVar.a(this.nkv);
        }
    }

    public void a(a.InterfaceC0845a interfaceC0845a) {
        this.nkp.b(interfaceC0845a);
        this.nkq.b(interfaceC0845a);
        this.nkr.b(interfaceC0845a);
        this.nks.b(interfaceC0845a);
        this.nkt.b(interfaceC0845a);
        if (this.nku != null) {
            this.nku.b(interfaceC0845a);
        }
        if (this.nkv != null) {
            this.nkv.b(interfaceC0845a);
        }
    }

    public void setProgress(float f) {
        this.nkp.setProgress(f);
        this.nkq.setProgress(f);
        this.nkr.setProgress(f);
        this.nks.setProgress(f);
        this.nkt.setProgress(f);
        if (this.nku != null) {
            this.nku.setProgress(f);
        }
        if (this.nkv != null) {
            this.nkv.setProgress(f);
        }
    }

    public a<?, Integer> dIR() {
        return this.nkt;
    }

    @Nullable
    public a<?, Float> dIS() {
        return this.nku;
    }

    @Nullable
    public a<?, Float> dIT() {
        return this.nkv;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.nkq.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.nks.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.e.d value2 = this.nkr.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.nkp.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix g(float f) {
        PointF value = this.nkq.getValue();
        PointF value2 = this.nkp.getValue();
        com.tb.airbnb.lottie.e.d value3 = this.nkr.getValue();
        float floatValue = this.nks.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.Az) {
            this.nkp.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AA) {
            this.nkq.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.njy) {
            this.nkr.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AE) {
            this.nks.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Ax) {
            this.nkt.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AQ && this.nku != null) {
            this.nku.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AR && this.nkv != null) {
            this.nkv.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
