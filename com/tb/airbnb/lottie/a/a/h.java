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
/* loaded from: classes6.dex */
public class h extends a {
    private final LongSparseArray<LinearGradient> Cd;
    private final LongSparseArray<RadialGradient> Ce;
    private final RectF Cg;
    private final int Ck;
    private final com.tb.airbnb.lottie.a.b.a<com.tb.airbnb.lottie.model.content.c, com.tb.airbnb.lottie.model.content.c> nFB;
    private final GradientType nFC;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> nFD;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> nFE;
    private final String name;

    public h(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.dNS().toPaintCap(), eVar.dNT().toPaintJoin(), eVar.iy(), eVar.dNI(), eVar.dNR(), eVar.iw(), eVar.dNU());
        this.Cd = new LongSparseArray<>();
        this.Ce = new LongSparseArray<>();
        this.Cg = new RectF();
        this.name = eVar.getName();
        this.nFC = eVar.dNN();
        this.Ck = (int) (fVar.getComposition().gT() / 32.0f);
        this.nFB = eVar.dNO().dNC();
        this.nFB.b(this);
        aVar.a(this.nFB);
        this.nFD = eVar.dNP().dNC();
        this.nFD.b(this);
        aVar.a(this.nFD);
        this.nFE = eVar.dNQ().dNC();
        this.nFE.b(this);
        aVar.a(this.nFE);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.Cg, matrix);
        if (this.nFC == GradientType.Linear) {
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
        LinearGradient linearGradient = this.Cd.get(hw);
        if (linearGradient == null) {
            PointF value = this.nFD.getValue();
            PointF value2 = this.nFE.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.nFB.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.Cg.left + (this.Cg.width() / 2.0f) + value.x), (int) (value.y + this.Cg.top + (this.Cg.height() / 2.0f)), (int) (this.Cg.left + (this.Cg.width() / 2.0f) + value2.x), (int) (this.Cg.top + (this.Cg.height() / 2.0f) + value2.y), value3.getColors(), value3.im(), Shader.TileMode.CLAMP);
            this.Cd.put(hw, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient hv() {
        int hw = hw();
        RadialGradient radialGradient = this.Ce.get(hw);
        if (radialGradient == null) {
            PointF value = this.nFD.getValue();
            PointF value2 = this.nFE.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.nFB.getValue();
            int[] colors = value3.getColors();
            float[] im = value3.im();
            int width = (int) (this.Cg.left + (this.Cg.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.Cg.top + (this.Cg.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.Cg.left + (this.Cg.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.Cg.top + (this.Cg.height() / 2.0f)))) - height), colors, im, Shader.TileMode.CLAMP);
            this.Ce.put(hw, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int hw() {
        int round = Math.round(this.nFD.getProgress() * this.Ck);
        int round2 = Math.round(this.nFE.getProgress() * this.Ck);
        int round3 = Math.round(this.nFB.getProgress() * this.Ck);
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
