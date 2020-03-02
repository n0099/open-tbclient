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
/* loaded from: classes6.dex */
public class g implements d, j, a.InterfaceC0738a {
    private final int gj;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    @NonNull
    private final String name;
    private final com.tb.airbnb.lottie.model.layer.a npD;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> npF;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> npH;
    private final com.tb.airbnb.lottie.a.b.a<com.tb.airbnb.lottie.model.content.c, com.tb.airbnb.lottie.model.content.c> npN;
    private final GradientType npO;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> npP;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> npQ;
    private final LongSparseArray<LinearGradient> gc = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> gd = new LongSparseArray<>();
    private final Matrix ge = new Matrix();
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final RectF gf = new RectF();
    private final List<l> fS = new ArrayList();

    public g(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.d dVar) {
        this.npD = aVar;
        this.name = dVar.getName();
        this.lottieDrawable = fVar;
        this.npO = dVar.dHa();
        this.path.setFillType(dVar.cA());
        this.gj = (int) (fVar.getComposition().bg() / 32.0f);
        this.npN = dVar.dHb().dGP();
        this.npN.b(this);
        aVar.a(this.npN);
        this.npF = dVar.dGV().dGP();
        this.npF.b(this);
        aVar.a(this.npF);
        this.npP = dVar.dHc().dGP();
        this.npP.b(this);
        aVar.a(this.npP);
        this.npQ = dVar.dHd().dGP();
        this.npQ.b(this);
        aVar.a(this.npQ);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0738a
    public void bD() {
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
                    this.fS.add((l) bVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        Shader bI;
        com.tb.airbnb.lottie.c.beginSection("GradientFillContent#draw");
        this.path.reset();
        for (int i2 = 0; i2 < this.fS.size(); i2++) {
            this.path.addPath(this.fS.get(i2).bG(), matrix);
        }
        this.path.computeBounds(this.gf, false);
        if (this.npO == GradientType.Linear) {
            bI = bH();
        } else {
            bI = bI();
        }
        this.ge.set(matrix);
        bI.setLocalMatrix(this.ge);
        this.paint.setShader(bI);
        if (this.npH != null) {
            this.paint.setColorFilter(this.npH.getValue());
        }
        this.paint.setAlpha(com.tb.airbnb.lottie.d.e.clamp((int) (((this.npF.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.path, this.paint);
        com.tb.airbnb.lottie.c.F("GradientFillContent#draw");
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.fS.size(); i++) {
            this.path.addPath(this.fS.get(i).bG(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient bH() {
        int bJ = bJ();
        LinearGradient linearGradient = this.gc.get(bJ);
        if (linearGradient == null) {
            PointF value = this.npP.getValue();
            PointF value2 = this.npQ.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.npN.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.cy(), Shader.TileMode.CLAMP);
            this.gc.put(bJ, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient bI() {
        int bJ = bJ();
        RadialGradient radialGradient = this.gd.get(bJ);
        if (radialGradient == null) {
            PointF value = this.npP.getValue();
            PointF value2 = this.npQ.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.npN.getValue();
            int[] colors = value3.getColors();
            float[] cy = value3.cy();
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, cy, Shader.TileMode.CLAMP);
            this.gd.put(bJ, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int bJ() {
        int round = Math.round(this.npP.getProgress() * this.gj);
        int round2 = Math.round(this.npQ.getProgress() * this.gj);
        int round3 = Math.round(this.npN.getProgress() * this.gj);
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
        if (t == com.tb.airbnb.lottie.j.fq) {
            if (cVar == null) {
                this.npH = null;
                return;
            }
            this.npH = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.npH.b(this);
            this.npD.a(this.npH);
        }
    }
}
