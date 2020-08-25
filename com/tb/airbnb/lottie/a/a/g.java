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
/* loaded from: classes7.dex */
public class g implements d, j, a.InterfaceC0932a {
    private final int CW;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    @NonNull
    private final String name;
    private final com.tb.airbnb.lottie.model.layer.a ohY;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> oia;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> oic;
    private final com.tb.airbnb.lottie.a.b.a<com.tb.airbnb.lottie.model.content.c, com.tb.airbnb.lottie.model.content.c> oii;
    private final GradientType oij;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> oik;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> oil;
    private final LongSparseArray<LinearGradient> CK = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> CL = new LongSparseArray<>();
    private final Matrix CN = new Matrix();
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final RectF CO = new RectF();
    private final List<l> CB = new ArrayList();

    public g(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.d dVar) {
        this.ohY = aVar;
        this.name = dVar.getName();
        this.lottieDrawable = fVar;
        this.oij = dVar.edq();
        this.path.setFillType(dVar.jO());
        this.CW = (int) (fVar.getComposition().iu() / 32.0f);
        this.oii = dVar.edr().edf();
        this.oii.b(this);
        aVar.a(this.oii);
        this.oia = dVar.edl().edf();
        this.oia.b(this);
        aVar.a(this.oia);
        this.oik = dVar.eds().edf();
        this.oik.b(this);
        aVar.a(this.oik);
        this.oil = dVar.edt().edf();
        this.oil.b(this);
        aVar.a(this.oil);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0932a
    public void iR() {
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
        Shader iW;
        com.tb.airbnb.lottie.c.beginSection("GradientFillContent#draw");
        this.path.reset();
        for (int i2 = 0; i2 < this.CB.size(); i2++) {
            this.path.addPath(this.CB.get(i2).iU(), matrix);
        }
        this.path.computeBounds(this.CO, false);
        if (this.oij == GradientType.Linear) {
            iW = iV();
        } else {
            iW = iW();
        }
        this.CN.set(matrix);
        iW.setLocalMatrix(this.CN);
        this.paint.setShader(iW);
        if (this.oic != null) {
            this.paint.setColorFilter(this.oic.getValue());
        }
        this.paint.setAlpha(com.tb.airbnb.lottie.d.e.clamp((int) (((this.oia.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.path, this.paint);
        com.tb.airbnb.lottie.c.bb("GradientFillContent#draw");
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.CB.size(); i++) {
            this.path.addPath(this.CB.get(i).iU(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
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
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.jM(), Shader.TileMode.CLAMP);
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
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, jM, Shader.TileMode.CLAMP);
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

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.Cb) {
            if (cVar == null) {
                this.oic = null;
                return;
            }
            this.oic = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.oic.b(this);
            this.ohY.a(this.oic);
        }
    }
}
