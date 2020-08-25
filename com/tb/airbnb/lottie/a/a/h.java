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
/* loaded from: classes7.dex */
public class h extends a {
    private final LongSparseArray<LinearGradient> CK;
    private final LongSparseArray<RadialGradient> CL;
    private final RectF CO;
    private final int CW;
    private final String name;
    private final com.tb.airbnb.lottie.a.b.a<com.tb.airbnb.lottie.model.content.c, com.tb.airbnb.lottie.model.content.c> oii;
    private final GradientType oij;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> oik;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> oil;

    public h(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.edv().toPaintCap(), eVar.edw().toPaintJoin(), eVar.jX(), eVar.edl(), eVar.edu(), eVar.jV(), eVar.edx());
        this.CK = new LongSparseArray<>();
        this.CL = new LongSparseArray<>();
        this.CO = new RectF();
        this.name = eVar.getName();
        this.oij = eVar.edq();
        this.CW = (int) (fVar.getComposition().iu() / 32.0f);
        this.oii = eVar.edr().edf();
        this.oii.b(this);
        aVar.a(this.oii);
        this.oik = eVar.eds().edf();
        this.oik.b(this);
        aVar.a(this.oik);
        this.oil = eVar.edt().edf();
        this.oil.b(this);
        aVar.a(this.oil);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.CO, matrix);
        if (this.oij == GradientType.Linear) {
            this.paint.setShader(iV());
        } else {
            this.paint.setShader(iW());
        }
        super.a(canvas, matrix, i);
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient iV() {
        int iX = iX();
        LinearGradient linearGradient = this.CK.get(iX);
        if (linearGradient == null) {
            PointF value = this.oik.getValue();
            PointF value2 = this.oil.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.oii.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.CO.left + (this.CO.width() / 2.0f) + value.x), (int) (value.y + this.CO.top + (this.CO.height() / 2.0f)), (int) (this.CO.left + (this.CO.width() / 2.0f) + value2.x), (int) (this.CO.top + (this.CO.height() / 2.0f) + value2.y), value3.getColors(), value3.jM(), Shader.TileMode.CLAMP);
            this.CK.put(iX, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient iW() {
        int iX = iX();
        RadialGradient radialGradient = this.CL.get(iX);
        if (radialGradient == null) {
            PointF value = this.oik.getValue();
            PointF value2 = this.oil.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.oii.getValue();
            int[] colors = value3.getColors();
            float[] jM = value3.jM();
            int width = (int) (this.CO.left + (this.CO.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.CO.top + (this.CO.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.CO.left + (this.CO.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.CO.top + (this.CO.height() / 2.0f)))) - height), colors, jM, Shader.TileMode.CLAMP);
            this.CL.put(iX, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int iX() {
        int round = Math.round(this.oik.getProgress() * this.CW);
        int round2 = Math.round(this.oil.getProgress() * this.CW);
        int round3 = Math.round(this.oii.getProgress() * this.CW);
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
