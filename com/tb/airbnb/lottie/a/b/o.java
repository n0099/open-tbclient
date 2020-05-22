package com.tb.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
/* loaded from: classes6.dex */
public class o {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> njf;
    private final a<?, PointF> njg;
    private final a<com.tb.airbnb.lottie.e.d, com.tb.airbnb.lottie.e.d> njh;
    private final a<Float, Float> nji;
    private final a<Integer, Integer> njj;
    @Nullable
    private final a<?, Float> njk;
    @Nullable
    private final a<?, Float> njl;

    public o(com.tb.airbnb.lottie.model.a.l lVar) {
        this.njf = lVar.dIK().dII();
        this.njg = lVar.dIL().dII();
        this.njh = lVar.dIM().dII();
        this.nji = lVar.dIN().dII();
        this.njj = lVar.dIO().dII();
        if (lVar.dIP() != null) {
            this.njk = lVar.dIP().dII();
        } else {
            this.njk = null;
        }
        if (lVar.dIQ() != null) {
            this.njl = lVar.dIQ().dII();
        } else {
            this.njl = null;
        }
    }

    public void a(com.tb.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.njf);
        aVar.a(this.njg);
        aVar.a(this.njh);
        aVar.a(this.nji);
        aVar.a(this.njj);
        if (this.njk != null) {
            aVar.a(this.njk);
        }
        if (this.njl != null) {
            aVar.a(this.njl);
        }
    }

    public void a(a.InterfaceC0844a interfaceC0844a) {
        this.njf.b(interfaceC0844a);
        this.njg.b(interfaceC0844a);
        this.njh.b(interfaceC0844a);
        this.nji.b(interfaceC0844a);
        this.njj.b(interfaceC0844a);
        if (this.njk != null) {
            this.njk.b(interfaceC0844a);
        }
        if (this.njl != null) {
            this.njl.b(interfaceC0844a);
        }
    }

    public void setProgress(float f) {
        this.njf.setProgress(f);
        this.njg.setProgress(f);
        this.njh.setProgress(f);
        this.nji.setProgress(f);
        this.njj.setProgress(f);
        if (this.njk != null) {
            this.njk.setProgress(f);
        }
        if (this.njl != null) {
            this.njl.setProgress(f);
        }
    }

    public a<?, Integer> dID() {
        return this.njj;
    }

    @Nullable
    public a<?, Float> dIE() {
        return this.njk;
    }

    @Nullable
    public a<?, Float> dIF() {
        return this.njl;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.njg.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.nji.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.tb.airbnb.lottie.e.d value2 = this.njh.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.njf.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix g(float f) {
        PointF value = this.njg.getValue();
        PointF value2 = this.njf.getValue();
        com.tb.airbnb.lottie.e.d value3 = this.njh.getValue();
        float floatValue = this.nji.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.Az) {
            this.njf.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AA) {
            this.njg.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.nio) {
            this.njh.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AE) {
            this.nji.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Ax) {
            this.njj.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AQ && this.njk != null) {
            this.njk.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AR && this.njl != null) {
            this.njl.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
