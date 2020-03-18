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
    private final LongSparseArray<LinearGradient> gb;
    private final LongSparseArray<RadialGradient> gc;
    private final RectF ge;
    private final int gi;
    private final String name;
    private final com.tb.airbnb.lottie.a.b.a<com.tb.airbnb.lottie.model.content.c, com.tb.airbnb.lottie.model.content.c> nrL;
    private final GradientType nrM;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> nrN;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> nrO;

    public h(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.dHG().toPaintCap(), eVar.dHH().toPaintJoin(), eVar.cJ(), eVar.dHw(), eVar.dHF(), eVar.cH(), eVar.dHI());
        this.gb = new LongSparseArray<>();
        this.gc = new LongSparseArray<>();
        this.ge = new RectF();
        this.name = eVar.getName();
        this.nrM = eVar.dHB();
        this.gi = (int) (fVar.getComposition().bg() / 32.0f);
        this.nrL = eVar.dHC().dHq();
        this.nrL.b(this);
        aVar.a(this.nrL);
        this.nrN = eVar.dHD().dHq();
        this.nrN.b(this);
        aVar.a(this.nrN);
        this.nrO = eVar.dHE().dHq();
        this.nrO.b(this);
        aVar.a(this.nrO);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.ge, matrix);
        if (this.nrM == GradientType.Linear) {
            this.paint.setShader(bH());
        } else {
            this.paint.setShader(bI());
        }
        super.a(canvas, matrix, i);
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient bH() {
        int bJ = bJ();
        LinearGradient linearGradient = this.gb.get(bJ);
        if (linearGradient == null) {
            PointF value = this.nrN.getValue();
            PointF value2 = this.nrO.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.nrL.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.ge.left + (this.ge.width() / 2.0f) + value.x), (int) (value.y + this.ge.top + (this.ge.height() / 2.0f)), (int) (this.ge.left + (this.ge.width() / 2.0f) + value2.x), (int) (this.ge.top + (this.ge.height() / 2.0f) + value2.y), value3.getColors(), value3.cy(), Shader.TileMode.CLAMP);
            this.gb.put(bJ, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient bI() {
        int bJ = bJ();
        RadialGradient radialGradient = this.gc.get(bJ);
        if (radialGradient == null) {
            PointF value = this.nrN.getValue();
            PointF value2 = this.nrO.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.nrL.getValue();
            int[] colors = value3.getColors();
            float[] cy = value3.cy();
            int width = (int) (this.ge.left + (this.ge.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.ge.top + (this.ge.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.ge.left + (this.ge.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.ge.top + (this.ge.height() / 2.0f)))) - height), colors, cy, Shader.TileMode.CLAMP);
            this.gc.put(bJ, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int bJ() {
        int round = Math.round(this.nrN.getProgress() * this.gi);
        int round2 = Math.round(this.nrO.getProgress() * this.gi);
        int round3 = Math.round(this.nrL.getProgress() * this.gi);
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
