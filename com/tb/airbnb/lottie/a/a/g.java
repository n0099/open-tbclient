package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.GradientType;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class g implements d, j, a.InterfaceC0929a {
    private final int CW;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    @NonNull
    private final String name;
    private final com.tb.airbnb.lottie.model.layer.a osa;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> osc;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> ose;
    private final com.tb.airbnb.lottie.a.b.a<com.tb.airbnb.lottie.model.content.c, com.tb.airbnb.lottie.model.content.c> osk;
    private final GradientType osl;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> osm;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> osn;
    private final LongSparseArray<LinearGradient> CK = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> CL = new LongSparseArray<>();
    private final Matrix CN = new Matrix();
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final RectF CO = new RectF();
    private final List<l> CB = new ArrayList();

    public g(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.d dVar) {
        this.osa = aVar;
        this.name = dVar.getName();
        this.lottieDrawable = fVar;
        this.osl = dVar.ehw();
        this.path.setFillType(dVar.jP());
        this.CW = (int) (fVar.getComposition().iu() / 32.0f);
        this.osk = dVar.ehx().ehl();
        this.osk.b(this);
        aVar.a(this.osk);
        this.osc = dVar.ehr().ehl();
        this.osc.b(this);
        aVar.a(this.osc);
        this.osm = dVar.ehy().ehl();
        this.osm.b(this);
        aVar.a(this.osm);
        this.osn = dVar.ehz().ehl();
        this.osn.b(this);
        aVar.a(this.osn);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0929a
    public void iS() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof l) {
                    this.CB.add((l) bVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        Shader iX;
        com.tb.airbnb.lottie.c.beginSection("GradientFillContent#draw");
        this.path.reset();
        for (int i2 = 0; i2 < this.CB.size(); i2++) {
            this.path.addPath(this.CB.get(i2).iV(), matrix);
        }
        this.path.computeBounds(this.CO, false);
        if (this.osl == GradientType.Linear) {
            iX = iW();
        } else {
            iX = iX();
        }
        this.CN.set(matrix);
        iX.setLocalMatrix(this.CN);
        this.paint.setShader(iX);
        if (this.ose != null) {
            this.paint.setColorFilter(this.ose.getValue());
        }
        this.paint.setAlpha(com.tb.airbnb.lottie.d.e.clamp((int) (((this.osc.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.path, this.paint);
        com.tb.airbnb.lottie.c.bb("GradientFillContent#draw");
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.CB.size(); i++) {
            this.path.addPath(this.CB.get(i).iV(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
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
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.jN(), Shader.TileMode.CLAMP);
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
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, jN, Shader.TileMode.CLAMP);
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

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.Cb) {
            if (cVar == null) {
                this.ose = null;
                return;
            }
            this.ose = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.ose.b(this);
            this.osa.a(this.ose);
        }
    }
}
