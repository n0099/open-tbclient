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
public class g implements d, j, a.InterfaceC0784a {
    private final int BK;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> mOA;
    private final com.tb.airbnb.lottie.model.layer.a mOn;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> mOp;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> mOr;
    private final com.tb.airbnb.lottie.a.b.a<com.tb.airbnb.lottie.model.content.c, com.tb.airbnb.lottie.model.content.c> mOx;
    private final GradientType mOy;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> mOz;
    @NonNull
    private final String name;
    private final LongSparseArray<LinearGradient> BD = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> BE = new LongSparseArray<>();
    private final Matrix BF = new Matrix();
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final RectF BG = new RectF();
    private final List<l> Bu = new ArrayList();

    public g(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.d dVar) {
        this.mOn = aVar;
        this.name = dVar.getName();
        this.lottieDrawable = fVar;
        this.mOy = dVar.dBA();
        this.path.setFillType(dVar.hX());
        this.BK = (int) (fVar.getComposition().gD() / 32.0f);
        this.mOx = dVar.dBB().dBp();
        this.mOx.b(this);
        aVar.a(this.mOx);
        this.mOp = dVar.dBv().dBp();
        this.mOp.b(this);
        aVar.a(this.mOp);
        this.mOz = dVar.dBC().dBp();
        this.mOz.b(this);
        aVar.a(this.mOz);
        this.mOA = dVar.dBD().dBp();
        this.mOA.b(this);
        aVar.a(this.mOA);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0784a
    public void ha() {
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
                    this.Bu.add((l) bVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        Shader hf;
        com.tb.airbnb.lottie.c.beginSection("GradientFillContent#draw");
        this.path.reset();
        for (int i2 = 0; i2 < this.Bu.size(); i2++) {
            this.path.addPath(this.Bu.get(i2).hd(), matrix);
        }
        this.path.computeBounds(this.BG, false);
        if (this.mOy == GradientType.Linear) {
            hf = he();
        } else {
            hf = hf();
        }
        this.BF.set(matrix);
        hf.setLocalMatrix(this.BF);
        this.paint.setShader(hf);
        if (this.mOr != null) {
            this.paint.setColorFilter(this.mOr.getValue());
        }
        this.paint.setAlpha(com.tb.airbnb.lottie.d.e.clamp((int) (((this.mOp.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.path, this.paint);
        com.tb.airbnb.lottie.c.aV("GradientFillContent#draw");
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.Bu.size(); i++) {
            this.path.addPath(this.Bu.get(i).hd(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient he() {
        int hg = hg();
        LinearGradient linearGradient = this.BD.get(hg);
        if (linearGradient == null) {
            PointF value = this.mOz.getValue();
            PointF value2 = this.mOA.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.mOx.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.hV(), Shader.TileMode.CLAMP);
            this.BD.put(hg, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient hf() {
        int hg = hg();
        RadialGradient radialGradient = this.BE.get(hg);
        if (radialGradient == null) {
            PointF value = this.mOz.getValue();
            PointF value2 = this.mOA.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.mOx.getValue();
            int[] colors = value3.getColors();
            float[] hV = value3.hV();
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, hV, Shader.TileMode.CLAMP);
            this.BE.put(hg, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int hg() {
        int round = Math.round(this.mOz.getProgress() * this.BK);
        int round2 = Math.round(this.mOA.getProgress() * this.BK);
        int round3 = Math.round(this.mOx.getProgress() * this.BK);
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
        if (t == com.tb.airbnb.lottie.j.AV) {
            if (cVar == null) {
                this.mOr = null;
                return;
            }
            this.mOr = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.mOr.b(this);
            this.mOn.a(this.mOr);
        }
    }
}
