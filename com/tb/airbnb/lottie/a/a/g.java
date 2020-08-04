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
public class g implements d, j, a.InterfaceC0874a {
    private final int Cm;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final com.tb.airbnb.lottie.model.layer.a nOe;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> nOg;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> nOi;
    private final com.tb.airbnb.lottie.a.b.a<com.tb.airbnb.lottie.model.content.c, com.tb.airbnb.lottie.model.content.c> nOo;
    private final GradientType nOp;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> nOq;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> nOr;
    @NonNull
    private final String name;
    private final LongSparseArray<LinearGradient> Cf = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> Cg = new LongSparseArray<>();
    private final Matrix Ch = new Matrix();
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final RectF Ci = new RectF();
    private final List<l> BW = new ArrayList();

    public g(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.d dVar) {
        this.nOe = aVar;
        this.name = dVar.getName();
        this.lottieDrawable = fVar;
        this.nOp = dVar.dRo();
        this.path.setFillType(dVar.ip());
        this.Cm = (int) (fVar.getComposition().gT() / 32.0f);
        this.nOo = dVar.dRp().dRd();
        this.nOo.b(this);
        aVar.a(this.nOo);
        this.nOg = dVar.dRj().dRd();
        this.nOg.b(this);
        aVar.a(this.nOg);
        this.nOq = dVar.dRq().dRd();
        this.nOq.b(this);
        aVar.a(this.nOq);
        this.nOr = dVar.dRr().dRd();
        this.nOr.b(this);
        aVar.a(this.nOr);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0874a
    public void hq() {
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
                    this.BW.add((l) bVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        Shader hv;
        com.tb.airbnb.lottie.c.beginSection("GradientFillContent#draw");
        this.path.reset();
        for (int i2 = 0; i2 < this.BW.size(); i2++) {
            this.path.addPath(this.BW.get(i2).ht(), matrix);
        }
        this.path.computeBounds(this.Ci, false);
        if (this.nOp == GradientType.Linear) {
            hv = hu();
        } else {
            hv = hv();
        }
        this.Ch.set(matrix);
        hv.setLocalMatrix(this.Ch);
        this.paint.setShader(hv);
        if (this.nOi != null) {
            this.paint.setColorFilter(this.nOi.getValue());
        }
        this.paint.setAlpha(com.tb.airbnb.lottie.d.e.clamp((int) (((this.nOg.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.path, this.paint);
        com.tb.airbnb.lottie.c.aW("GradientFillContent#draw");
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.BW.size(); i++) {
            this.path.addPath(this.BW.get(i).ht(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient hu() {
        int hw = hw();
        LinearGradient linearGradient = this.Cf.get(hw);
        if (linearGradient == null) {
            PointF value = this.nOq.getValue();
            PointF value2 = this.nOr.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.nOo.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.im(), Shader.TileMode.CLAMP);
            this.Cf.put(hw, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient hv() {
        int hw = hw();
        RadialGradient radialGradient = this.Cg.get(hw);
        if (radialGradient == null) {
            PointF value = this.nOq.getValue();
            PointF value2 = this.nOr.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.nOo.getValue();
            int[] colors = value3.getColors();
            float[] im = value3.im();
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, im, Shader.TileMode.CLAMP);
            this.Cg.put(hw, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int hw() {
        int round = Math.round(this.nOq.getProgress() * this.Cm);
        int round2 = Math.round(this.nOr.getProgress() * this.Cm);
        int round3 = Math.round(this.nOo.getProgress() * this.Cm);
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
        if (t == com.tb.airbnb.lottie.j.Bx) {
            if (cVar == null) {
                this.nOi = null;
                return;
            }
            this.nOi = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.nOi.b(this);
            this.nOe.a(this.nOi);
        }
    }
}
