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
    private final LongSparseArray<LinearGradient> fX;
    private final LongSparseArray<RadialGradient> fY;
    private final RectF gb;
    private final int gf;
    private final String name;
    private final com.tb.airbnb.lottie.a.b.a<com.tb.airbnb.lottie.model.content.c, com.tb.airbnb.lottie.model.content.c> npe;
    private final GradientType npf;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> npg;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> nph;

    public h(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.dFU().toPaintCap(), eVar.dFV().toPaintJoin(), eVar.cI(), eVar.dFK(), eVar.dFT(), eVar.cG(), eVar.dFW());
        this.fX = new LongSparseArray<>();
        this.fY = new LongSparseArray<>();
        this.gb = new RectF();
        this.name = eVar.getName();
        this.npf = eVar.dFP();
        this.gf = (int) (fVar.getComposition().bf() / 32.0f);
        this.npe = eVar.dFQ().dFE();
        this.npe.b(this);
        aVar.a(this.npe);
        this.npg = eVar.dFR().dFE();
        this.npg.b(this);
        aVar.a(this.npg);
        this.nph = eVar.dFS().dFE();
        this.nph.b(this);
        aVar.a(this.nph);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.gb, matrix);
        if (this.npf == GradientType.Linear) {
            this.paint.setShader(bG());
        } else {
            this.paint.setShader(bH());
        }
        super.a(canvas, matrix, i);
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient bG() {
        int bI = bI();
        LinearGradient linearGradient = this.fX.get(bI);
        if (linearGradient == null) {
            PointF value = this.npg.getValue();
            PointF value2 = this.nph.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.npe.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.gb.left + (this.gb.width() / 2.0f) + value.x), (int) (value.y + this.gb.top + (this.gb.height() / 2.0f)), (int) (this.gb.left + (this.gb.width() / 2.0f) + value2.x), (int) (this.gb.top + (this.gb.height() / 2.0f) + value2.y), value3.getColors(), value3.cx(), Shader.TileMode.CLAMP);
            this.fX.put(bI, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient bH() {
        int bI = bI();
        RadialGradient radialGradient = this.fY.get(bI);
        if (radialGradient == null) {
            PointF value = this.npg.getValue();
            PointF value2 = this.nph.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.npe.getValue();
            int[] colors = value3.getColors();
            float[] cx = value3.cx();
            int width = (int) (this.gb.left + (this.gb.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.gb.top + (this.gb.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.gb.left + (this.gb.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.gb.top + (this.gb.height() / 2.0f)))) - height), colors, cx, Shader.TileMode.CLAMP);
            this.fY.put(bI, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int bI() {
        int round = Math.round(this.npg.getProgress() * this.gf);
        int round2 = Math.round(this.nph.getProgress() * this.gf);
        int round3 = Math.round(this.npe.getProgress() * this.gf);
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
