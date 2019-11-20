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
    private final LongSparseArray<LinearGradient> ek;
    private final LongSparseArray<RadialGradient> el;
    private final RectF en;
    private final int er;
    private final com.tb.airbnb.lottie.a.b.a<com.tb.airbnb.lottie.model.content.c, com.tb.airbnb.lottie.model.content.c> ksk;
    private final GradientType ksl;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> ksm;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> ksn;
    private final String name;

    public h(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.cLJ().toPaintCap(), eVar.cLK().toPaintJoin(), eVar.cLx(), eVar.cLI(), eVar.cE(), eVar.cLL());
        this.ek = new LongSparseArray<>();
        this.el = new LongSparseArray<>();
        this.en = new RectF();
        this.name = eVar.getName();
        this.ksl = eVar.cLE();
        this.er = (int) (fVar.cLa().getDuration() / 32);
        this.ksk = eVar.cLF().cLl();
        this.ksk.b(this);
        aVar.a(this.ksk);
        this.ksm = eVar.cLG().cLl();
        this.ksm.b(this);
        aVar.a(this.ksm);
        this.ksn = eVar.cLH().cLl();
        this.ksn.b(this);
        aVar.a(this.ksn);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.en, matrix);
        if (this.ksl == GradientType.Linear) {
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
        LinearGradient linearGradient = this.ek.get(bz);
        if (linearGradient == null) {
            PointF value = this.ksm.getValue();
            PointF value2 = this.ksn.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.ksk.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.en.left + (this.en.width() / 2.0f) + value.x), (int) (value.y + this.en.top + (this.en.height() / 2.0f)), (int) (this.en.left + (this.en.width() / 2.0f) + value2.x), (int) (this.en.top + (this.en.height() / 2.0f) + value2.y), value3.getColors(), value3.cv(), Shader.TileMode.CLAMP);
            this.ek.put(bz, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient by() {
        int bz = bz();
        RadialGradient radialGradient = this.el.get(bz);
        if (radialGradient == null) {
            PointF value = this.ksm.getValue();
            PointF value2 = this.ksn.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.ksk.getValue();
            int[] colors = value3.getColors();
            float[] cv = value3.cv();
            int width = (int) (this.en.left + (this.en.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.en.top + (this.en.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.en.left + (this.en.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.en.top + (this.en.height() / 2.0f)))) - height), colors, cv, Shader.TileMode.CLAMP);
            this.el.put(bz, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int bz() {
        int round = Math.round(this.ksm.getProgress() * this.er);
        int round2 = Math.round(this.ksn.getProgress() * this.er);
        int round3 = Math.round(this.ksk.getProgress() * this.er);
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
