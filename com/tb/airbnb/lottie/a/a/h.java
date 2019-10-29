package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import com.tb.airbnb.lottie.model.content.GradientType;
/* loaded from: classes6.dex */
public class h extends a {
    private final LongSparseArray<LinearGradient> eK;
    private final LongSparseArray<RadialGradient> eL;
    private final RectF eN;
    private final int eR;
    private final com.tb.airbnb.lottie.a.b.a<com.tb.airbnb.lottie.model.content.c, com.tb.airbnb.lottie.model.content.c> ktb;
    private final GradientType ktc;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> ktd;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> kte;
    private final String name;

    public h(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.cLL().toPaintCap(), eVar.cLM().toPaintJoin(), eVar.cLz(), eVar.cLK(), eVar.cE(), eVar.cLN());
        this.eK = new LongSparseArray<>();
        this.eL = new LongSparseArray<>();
        this.eN = new RectF();
        this.name = eVar.getName();
        this.ktc = eVar.cLG();
        this.eR = (int) (fVar.cLc().getDuration() / 32);
        this.ktb = eVar.cLH().cLn();
        this.ktb.b(this);
        aVar.a(this.ktb);
        this.ktd = eVar.cLI().cLn();
        this.ktd.b(this);
        aVar.a(this.ktd);
        this.kte = eVar.cLJ().cLn();
        this.kte.b(this);
        aVar.a(this.kte);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.eN, matrix);
        if (this.ktc == GradientType.Linear) {
            this.paint.setShader(bx());
        } else {
            this.paint.setShader(by());
        }
        super.a(canvas, matrix, i);
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient bx() {
        int bz = bz();
        LinearGradient linearGradient = this.eK.get(bz);
        if (linearGradient == null) {
            PointF value = this.ktd.getValue();
            PointF value2 = this.kte.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.ktb.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.eN.left + (this.eN.width() / 2.0f) + value.x), (int) (value.y + this.eN.top + (this.eN.height() / 2.0f)), (int) (this.eN.left + (this.eN.width() / 2.0f) + value2.x), (int) (this.eN.top + (this.eN.height() / 2.0f) + value2.y), value3.getColors(), value3.cv(), Shader.TileMode.CLAMP);
            this.eK.put(bz, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient by() {
        int bz = bz();
        RadialGradient radialGradient = this.eL.get(bz);
        if (radialGradient == null) {
            PointF value = this.ktd.getValue();
            PointF value2 = this.kte.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.ktb.getValue();
            int[] colors = value3.getColors();
            float[] cv = value3.cv();
            int width = (int) (this.eN.left + (this.eN.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.eN.top + (this.eN.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.eN.left + (this.eN.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.eN.top + (this.eN.height() / 2.0f)))) - height), colors, cv, Shader.TileMode.CLAMP);
            this.eL.put(bz, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int bz() {
        int round = Math.round(this.ktd.getProgress() * this.eR);
        int round2 = Math.round(this.kte.getProgress() * this.eR);
        int round3 = Math.round(this.ktb.getProgress() * this.eR);
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
