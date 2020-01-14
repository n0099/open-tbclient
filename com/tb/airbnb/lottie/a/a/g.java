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
/* loaded from: classes5.dex */
public class g implements d, j, a.InterfaceC0730a {
    private final int gf;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    @NonNull
    private final String name;
    private final com.tb.airbnb.lottie.model.layer.a noZ;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> npb;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> npd;
    private final com.tb.airbnb.lottie.a.b.a<com.tb.airbnb.lottie.model.content.c, com.tb.airbnb.lottie.model.content.c> npj;
    private final GradientType npk;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> npl;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> npm;
    private final LongSparseArray<LinearGradient> fX = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> fY = new LongSparseArray<>();
    private final Matrix fZ = new Matrix();
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final RectF gb = new RectF();
    private final List<l> fO = new ArrayList();

    public g(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.d dVar) {
        this.noZ = aVar;
        this.name = dVar.getName();
        this.lottieDrawable = fVar;
        this.npk = dVar.dFR();
        this.path.setFillType(dVar.cz());
        this.gf = (int) (fVar.getComposition().bf() / 32.0f);
        this.npj = dVar.dFS().dFG();
        this.npj.b(this);
        aVar.a(this.npj);
        this.npb = dVar.dFM().dFG();
        this.npb.b(this);
        aVar.a(this.npb);
        this.npl = dVar.dFT().dFG();
        this.npl.b(this);
        aVar.a(this.npl);
        this.npm = dVar.dFU().dFG();
        this.npm.b(this);
        aVar.a(this.npm);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0730a
    public void bC() {
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
                    this.fO.add((l) bVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        Shader bH;
        com.tb.airbnb.lottie.c.beginSection("GradientFillContent#draw");
        this.path.reset();
        for (int i2 = 0; i2 < this.fO.size(); i2++) {
            this.path.addPath(this.fO.get(i2).bF(), matrix);
        }
        this.path.computeBounds(this.gb, false);
        if (this.npk == GradientType.Linear) {
            bH = bG();
        } else {
            bH = bH();
        }
        this.fZ.set(matrix);
        bH.setLocalMatrix(this.fZ);
        this.paint.setShader(bH);
        if (this.npd != null) {
            this.paint.setColorFilter(this.npd.getValue());
        }
        this.paint.setAlpha(com.tb.airbnb.lottie.d.e.clamp((int) (((this.npb.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.path, this.paint);
        com.tb.airbnb.lottie.c.F("GradientFillContent#draw");
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.fO.size(); i++) {
            this.path.addPath(this.fO.get(i).bF(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient bG() {
        int bI = bI();
        LinearGradient linearGradient = this.fX.get(bI);
        if (linearGradient == null) {
            PointF value = this.npl.getValue();
            PointF value2 = this.npm.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.npj.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.cx(), Shader.TileMode.CLAMP);
            this.fX.put(bI, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient bH() {
        int bI = bI();
        RadialGradient radialGradient = this.fY.get(bI);
        if (radialGradient == null) {
            PointF value = this.npl.getValue();
            PointF value2 = this.npm.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.npj.getValue();
            int[] colors = value3.getColors();
            float[] cx = value3.cx();
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, cx, Shader.TileMode.CLAMP);
            this.fY.put(bI, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int bI() {
        int round = Math.round(this.npl.getProgress() * this.gf);
        int round2 = Math.round(this.npm.getProgress() * this.gf);
        int round3 = Math.round(this.npj.getProgress() * this.gf);
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
        if (t == com.tb.airbnb.lottie.j.fj) {
            if (cVar == null) {
                this.npd = null;
                return;
            }
            this.npd = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.npd.b(this);
            this.noZ.a(this.npd);
        }
    }
}
