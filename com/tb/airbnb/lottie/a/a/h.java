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
    private final LongSparseArray<LinearGradient> BD;
    private final LongSparseArray<RadialGradient> BE;
    private final RectF BG;
    private final int BK;
    private final String name;
    private final com.tb.airbnb.lottie.a.b.a<com.tb.airbnb.lottie.model.content.c, com.tb.airbnb.lottie.model.content.c> niC;
    private final GradientType niD;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> niE;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> niF;

    public h(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.dIY().toPaintCap(), eVar.dIZ().toPaintJoin(), eVar.ih(), eVar.dIO(), eVar.dIX(), eVar.m51if(), eVar.dJa());
        this.BD = new LongSparseArray<>();
        this.BE = new LongSparseArray<>();
        this.BG = new RectF();
        this.name = eVar.getName();
        this.niD = eVar.dIT();
        this.BK = (int) (fVar.getComposition().gD() / 32.0f);
        this.niC = eVar.dIU().dII();
        this.niC.b(this);
        aVar.a(this.niC);
        this.niE = eVar.dIV().dII();
        this.niE.b(this);
        aVar.a(this.niE);
        this.niF = eVar.dIW().dII();
        this.niF.b(this);
        aVar.a(this.niF);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.BG, matrix);
        if (this.niD == GradientType.Linear) {
            this.paint.setShader(he());
        } else {
            this.paint.setShader(hf());
        }
        super.a(canvas, matrix, i);
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient he() {
        int hg = hg();
        LinearGradient linearGradient = this.BD.get(hg);
        if (linearGradient == null) {
            PointF value = this.niE.getValue();
            PointF value2 = this.niF.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.niC.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.BG.left + (this.BG.width() / 2.0f) + value.x), (int) (value.y + this.BG.top + (this.BG.height() / 2.0f)), (int) (this.BG.left + (this.BG.width() / 2.0f) + value2.x), (int) (this.BG.top + (this.BG.height() / 2.0f) + value2.y), value3.getColors(), value3.hV(), Shader.TileMode.CLAMP);
            this.BD.put(hg, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient hf() {
        int hg = hg();
        RadialGradient radialGradient = this.BE.get(hg);
        if (radialGradient == null) {
            PointF value = this.niE.getValue();
            PointF value2 = this.niF.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.niC.getValue();
            int[] colors = value3.getColors();
            float[] hV = value3.hV();
            int width = (int) (this.BG.left + (this.BG.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.BG.top + (this.BG.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.BG.left + (this.BG.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.BG.top + (this.BG.height() / 2.0f)))) - height), colors, hV, Shader.TileMode.CLAMP);
            this.BE.put(hg, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int hg() {
        int round = Math.round(this.niE.getProgress() * this.BK);
        int round2 = Math.round(this.niF.getProgress() * this.BK);
        int round3 = Math.round(this.niC.getProgress() * this.BK);
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
