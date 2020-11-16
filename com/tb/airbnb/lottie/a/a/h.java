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
    private final LongSparseArray<LinearGradient> Dg;
    private final LongSparseArray<RadialGradient> Dh;
    private final RectF Dj;
    private final int Dn;
    private final String name;
    private final com.tb.airbnb.lottie.a.b.a<com.tb.airbnb.lottie.model.content.c, com.tb.airbnb.lottie.model.content.c> pJU;
    private final GradientType pJV;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> pJW;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> pJX;

    public h(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.e eVar) {
        super(gVar, aVar, eVar.ezc().toPaintCap(), eVar.ezd().toPaintJoin(), eVar.jZ(), eVar.eyS(), eVar.ezb(), eVar.jX(), eVar.eze());
        this.Dg = new LongSparseArray<>();
        this.Dh = new LongSparseArray<>();
        this.Dj = new RectF();
        this.name = eVar.getName();
        this.pJV = eVar.eyX();
        this.Dn = (int) (gVar.getComposition().iv() / 32.0f);
        this.pJU = eVar.eyY().eyM();
        this.pJU.b(this);
        aVar.a(this.pJU);
        this.pJW = eVar.eyZ().eyM();
        this.pJW.b(this);
        aVar.a(this.pJW);
        this.pJX = eVar.eza().eyM();
        this.pJX.b(this);
        aVar.a(this.pJX);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.Dj, matrix);
        if (this.pJV == GradientType.Linear) {
            this.paint.setShader(iX());
        } else {
            this.paint.setShader(iY());
        }
        super.a(canvas, matrix, i);
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient iX() {
        int iZ = iZ();
        LinearGradient linearGradient = this.Dg.get(iZ);
        if (linearGradient == null) {
            PointF value = this.pJW.getValue();
            PointF value2 = this.pJX.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.pJU.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.Dj.left + (this.Dj.width() / 2.0f) + value.x), (int) (value.y + this.Dj.top + (this.Dj.height() / 2.0f)), (int) (this.Dj.left + (this.Dj.width() / 2.0f) + value2.x), (int) (this.Dj.top + (this.Dj.height() / 2.0f) + value2.y), value3.getColors(), value3.jO(), Shader.TileMode.CLAMP);
            this.Dg.put(iZ, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient iY() {
        int iZ = iZ();
        RadialGradient radialGradient = this.Dh.get(iZ);
        if (radialGradient == null) {
            PointF value = this.pJW.getValue();
            PointF value2 = this.pJX.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.pJU.getValue();
            int[] colors = value3.getColors();
            float[] jO = value3.jO();
            int width = (int) (this.Dj.left + (this.Dj.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.Dj.top + (this.Dj.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.Dj.left + (this.Dj.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.Dj.top + (this.Dj.height() / 2.0f)))) - height), colors, jO, Shader.TileMode.CLAMP);
            this.Dh.put(iZ, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int iZ() {
        int round = Math.round(this.pJW.getProgress() * this.Dn);
        int round2 = Math.round(this.pJX.getProgress() * this.Dn);
        int round3 = Math.round(this.pJU.getProgress() * this.Dn);
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
