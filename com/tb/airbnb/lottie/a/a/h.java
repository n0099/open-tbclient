package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.v4.util.LongSparseArray;
import com.tb.airbnb.lottie.model.content.GradientType;
/* loaded from: classes5.dex */
public class h extends a {
    private final LongSparseArray<LinearGradient> Cf;
    private final LongSparseArray<RadialGradient> Cg;
    private final RectF Ci;
    private final int Cm;
    private final com.tb.airbnb.lottie.a.b.a<com.tb.airbnb.lottie.model.content.c, com.tb.airbnb.lottie.model.content.c> nOm;
    private final GradientType nOn;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> nOo;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> nOp;
    private final String name;

    public h(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.dRs().toPaintCap(), eVar.dRt().toPaintJoin(), eVar.iy(), eVar.dRi(), eVar.dRr(), eVar.iw(), eVar.dRu());
        this.Cf = new LongSparseArray<>();
        this.Cg = new LongSparseArray<>();
        this.Ci = new RectF();
        this.name = eVar.getName();
        this.nOn = eVar.dRn();
        this.Cm = (int) (fVar.getComposition().gT() / 32.0f);
        this.nOm = eVar.dRo().dRc();
        this.nOm.b(this);
        aVar.a(this.nOm);
        this.nOo = eVar.dRp().dRc();
        this.nOo.b(this);
        aVar.a(this.nOo);
        this.nOp = eVar.dRq().dRc();
        this.nOp.b(this);
        aVar.a(this.nOp);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.Ci, matrix);
        if (this.nOn == GradientType.Linear) {
            this.paint.setShader(hu());
        } else {
            this.paint.setShader(hv());
        }
        super.a(canvas, matrix, i);
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient hu() {
        int hw = hw();
        LinearGradient linearGradient = this.Cf.get(hw);
        if (linearGradient == null) {
            PointF value = this.nOo.getValue();
            PointF value2 = this.nOp.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.nOm.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.Ci.left + (this.Ci.width() / 2.0f) + value.x), (int) (value.y + this.Ci.top + (this.Ci.height() / 2.0f)), (int) (this.Ci.left + (this.Ci.width() / 2.0f) + value2.x), (int) (this.Ci.top + (this.Ci.height() / 2.0f) + value2.y), value3.getColors(), value3.im(), Shader.TileMode.CLAMP);
            this.Cf.put(hw, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient hv() {
        int hw = hw();
        RadialGradient radialGradient = this.Cg.get(hw);
        if (radialGradient == null) {
            PointF value = this.nOo.getValue();
            PointF value2 = this.nOp.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.nOm.getValue();
            int[] colors = value3.getColors();
            float[] im = value3.im();
            int width = (int) (this.Ci.left + (this.Ci.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.Ci.top + (this.Ci.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.Ci.left + (this.Ci.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.Ci.top + (this.Ci.height() / 2.0f)))) - height), colors, im, Shader.TileMode.CLAMP);
            this.Cg.put(hw, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int hw() {
        int round = Math.round(this.nOo.getProgress() * this.Cm);
        int round2 = Math.round(this.nOp.getProgress() * this.Cm);
        int round3 = Math.round(this.nOm.getProgress() * this.Cm);
        int i = 17;
        if (round != 0) {
            i = round * 527;
        }
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        if (round3 != 0) {
            return i * 31 * round3;
        }
        return i;
    }
}
