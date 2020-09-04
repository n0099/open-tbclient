package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes7.dex */
public class o {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> ojd;
    private final a<?, PointF> oje;
    private final a<com.tb.airbnb.lottie.e.d, com.tb.airbnb.lottie.e.d> ojf;
    private final a<Float, Float> ojg;
    private final a<Integer, Integer> ojh;
    @Nullable
    private final a<?, Float> oji;
    @Nullable
    private final a<?, Float> ojj;

    public o(com.tb.airbnb.lottie.model.a.l lVar) {
        this.ojd = lVar.edq().edo();
        this.oje = lVar.edr().edo();
        this.ojf = lVar.eds().edo();
        this.ojg = lVar.edt().edo();
        this.ojh = lVar.edu().edo();
        if (lVar.edv() != null) {
            this.oji = lVar.edv().edo();
        } else {
            this.oji = null;
        }
        if (lVar.edw() != null) {
            this.ojj = lVar.edw().edo();
        } else {
            this.ojj = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.ojd);
        aVar.a(this.oje);
        aVar.a(this.ojf);
        aVar.a(this.ojg);
        aVar.a(this.ojh);
        if (this.oji != null) {
            aVar.a(this.oji);
        }
        if (this.ojj != null) {
            aVar.a(this.ojj);
        }
    }

    public void a(a.InterfaceC0932a interfaceC0932a) {
        this.ojd.b(interfaceC0932a);
        this.oje.b(interfaceC0932a);
        this.ojf.b(interfaceC0932a);
        this.ojg.b(interfaceC0932a);
        this.ojh.b(interfaceC0932a);
        if (this.oji != null) {
            this.oji.b(interfaceC0932a);
        }
        if (this.ojj != null) {
            this.ojj.b(interfaceC0932a);
        }
    }

    public void setProgress(float f) {
        this.ojd.setProgress(f);
        this.oje.setProgress(f);
        this.ojf.setProgress(f);
        this.ojg.setProgress(f);
        this.ojh.setProgress(f);
        if (this.oji != null) {
            this.oji.setProgress(f);
        }
        if (this.ojj != null) {
            this.ojj.setProgress(f);
        }
    }

    public a<?, Integer> edj() {
        return this.ojh;
    }

    @Nullable
    public a<?, Float> edk() {
        return this.oji;
    }

    @Nullable
    public a<?, Float> edl() {
        return this.ojj;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.oje.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.ojg.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.e.d value2 = this.ojf.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.ojd.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix i(float f) {
        PointF value = this.oje.getValue();
        PointF value2 = this.ojd.getValue();
        com.tb.airbnb.lottie.e.d value3 = this.ojf.getValue();
        float floatValue = this.ojg.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.BI) {
            this.ojd.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.BJ) {
            this.oje.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.oim) {
            this.ojf.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.BN) {
            this.ojg.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.BG) {
            this.ojh.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.BY && this.oji != null) {
            this.oji.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.BZ && this.ojj != null) {
            this.ojj.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
