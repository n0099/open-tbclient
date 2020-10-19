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
/* loaded from: classes16.dex */
public class g implements d, j, a.InterfaceC0947a {
    private final int Dn;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    @NonNull
    private final String name;
    private final com.tb.airbnb.lottie.a.b.a<com.tb.airbnb.lottie.model.content.c, com.tb.airbnb.lottie.model.content.c> oHA;
    private final GradientType oHB;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> oHC;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> oHD;
    private final com.tb.airbnb.lottie.model.layer.a oHq;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> oHs;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> oHu;
    private final LongSparseArray<LinearGradient> Dg = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> Dh = new LongSparseArray<>();
    private final Matrix Di = new Matrix();
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final RectF Dj = new RectF();
    private final List<l> CX = new ArrayList();

    public g(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.d dVar) {
        this.oHq = aVar;
        this.name = dVar.getName();
        this.lottieDrawable = fVar;
        this.oHB = dVar.elh();
        this.path.setFillType(dVar.jQ());
        this.Dn = (int) (fVar.getComposition().iv() / 32.0f);
        this.oHA = dVar.eli().ekW();
        this.oHA.b(this);
        aVar.a(this.oHA);
        this.oHs = dVar.elc().ekW();
        this.oHs.b(this);
        aVar.a(this.oHs);
        this.oHC = dVar.elj().ekW();
        this.oHC.b(this);
        aVar.a(this.oHC);
        this.oHD = dVar.elk().ekW();
        this.oHD.b(this);
        aVar.a(this.oHD);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0947a
    public void iT() {
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
                    this.CX.add((l) bVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        Shader iY;
        com.tb.airbnb.lottie.c.beginSection("GradientFillContent#draw");
        this.path.reset();
        for (int i2 = 0; i2 < this.CX.size(); i2++) {
            this.path.addPath(this.CX.get(i2).iW(), matrix);
        }
        this.path.computeBounds(this.Dj, false);
        if (this.oHB == GradientType.Linear) {
            iY = iX();
        } else {
            iY = iY();
        }
        this.Di.set(matrix);
        iY.setLocalMatrix(this.Di);
        this.paint.setShader(iY);
        if (this.oHu != null) {
            this.paint.setColorFilter(this.oHu.getValue());
        }
        this.paint.setAlpha(com.tb.airbnb.lottie.d.e.clamp((int) (((this.oHs.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.path, this.paint);
        com.tb.airbnb.lottie.c.bb("GradientFillContent#draw");
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.CX.size(); i++) {
            this.path.addPath(this.CX.get(i).iW(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient iX() {
        int iZ = iZ();
        LinearGradient linearGradient = this.Dg.get(iZ);
        if (linearGradient == null) {
            PointF value = this.oHC.getValue();
            PointF value2 = this.oHD.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.oHA.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.jO(), Shader.TileMode.CLAMP);
            this.Dg.put(iZ, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient iY() {
        int iZ = iZ();
        RadialGradient radialGradient = this.Dh.get(iZ);
        if (radialGradient == null) {
            PointF value = this.oHC.getValue();
            PointF value2 = this.oHD.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.oHA.getValue();
            int[] colors = value3.getColors();
            float[] jO = value3.jO();
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, jO, Shader.TileMode.CLAMP);
            this.Dh.put(iZ, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int iZ() {
        int round = Math.round(this.oHC.getProgress() * this.Dn);
        int round2 = Math.round(this.oHD.getProgress() * this.Dn);
        int round3 = Math.round(this.oHA.getProgress() * this.Dn);
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
        if (t == com.tb.airbnb.lottie.j.Cs) {
            if (cVar == null) {
                this.oHu = null;
                return;
            }
            this.oHu = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.oHu.b(this);
            this.oHq.a(this.oHu);
        }
    }
}
