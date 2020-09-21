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
/* loaded from: classes17.dex */
public class h extends a {
    private final LongSparseArray<LinearGradient> CK;
    private final LongSparseArray<RadialGradient> CL;
    private final RectF CO;
    private final int CW;
    private final String name;
    private final com.tb.airbnb.lottie.a.b.a<com.tb.airbnb.lottie.model.content.c, com.tb.airbnb.lottie.model.content.c> osk;
    private final GradientType osl;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> osm;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> osn;

    public h(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.ehB().toPaintCap(), eVar.ehC().toPaintJoin(), eVar.jY(), eVar.ehr(), eVar.ehA(), eVar.jW(), eVar.ehD());
        this.CK = new LongSparseArray<>();
        this.CL = new LongSparseArray<>();
        this.CO = new RectF();
        this.name = eVar.getName();
        this.osl = eVar.ehw();
        this.CW = (int) (fVar.getComposition().iu() / 32.0f);
        this.osk = eVar.ehx().ehl();
        this.osk.b(this);
        aVar.a(this.osk);
        this.osm = eVar.ehy().ehl();
        this.osm.b(this);
        aVar.a(this.osm);
        this.osn = eVar.ehz().ehl();
        this.osn.b(this);
        aVar.a(this.osn);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.CO, matrix);
        if (this.osl == GradientType.Linear) {
            this.paint.setShader(iW());
        } else {
            this.paint.setShader(iX());
        }
        super.a(canvas, matrix, i);
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient iW() {
        int iY = iY();
        LinearGradient linearGradient = this.CK.get(iY);
        if (linearGradient == null) {
            PointF value = this.osm.getValue();
            PointF value2 = this.osn.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.osk.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.CO.left + (this.CO.width() / 2.0f) + value.x), (int) (value.y + this.CO.top + (this.CO.height() / 2.0f)), (int) (this.CO.left + (this.CO.width() / 2.0f) + value2.x), (int) (this.CO.top + (this.CO.height() / 2.0f) + value2.y), value3.getColors(), value3.jN(), Shader.TileMode.CLAMP);
            this.CK.put(iY, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient iX() {
        int iY = iY();
        RadialGradient radialGradient = this.CL.get(iY);
        if (radialGradient == null) {
            PointF value = this.osm.getValue();
            PointF value2 = this.osn.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.osk.getValue();
            int[] colors = value3.getColors();
            float[] jN = value3.jN();
            int width = (int) (this.CO.left + (this.CO.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.CO.top + (this.CO.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.CO.left + (this.CO.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.CO.top + (this.CO.height() / 2.0f)))) - height), colors, jN, Shader.TileMode.CLAMP);
            this.CL.put(iY, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int iY() {
        int round = Math.round(this.osm.getProgress() * this.CW);
        int round2 = Math.round(this.osn.getProgress() * this.CW);
        int round3 = Math.round(this.osk.getProgress() * this.CW);
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
