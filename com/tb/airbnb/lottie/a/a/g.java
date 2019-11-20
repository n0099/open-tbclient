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
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.GradientType;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class g implements d, a.InterfaceC0577a {
    private final int er;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> ksd;
    private final com.tb.airbnb.lottie.a.b.a<com.tb.airbnb.lottie.model.content.c, com.tb.airbnb.lottie.model.content.c> ksk;
    private final GradientType ksl;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> ksm;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> ksn;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final String name;
    private final LongSparseArray<LinearGradient> ek = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> el = new LongSparseArray<>();
    private final Matrix em = new Matrix();
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final RectF en = new RectF();
    private final List<k> ea = new ArrayList();

    public g(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.d dVar) {
        this.name = dVar.getName();
        this.lottieDrawable = fVar;
        this.ksl = dVar.cLE();
        this.path.setFillType(dVar.cx());
        this.er = (int) (fVar.cLa().getDuration() / 32);
        this.ksk = dVar.cLF().cLl();
        this.ksk.b(this);
        aVar.a(this.ksk);
        this.ksd = dVar.cLx().cLl();
        this.ksd.b(this);
        aVar.a(this.ksd);
        this.ksm = dVar.cLG().cLl();
        this.ksm.b(this);
        aVar.a(this.ksm);
        this.ksn = dVar.cLH().cLl();
        this.ksn.b(this);
        aVar.a(this.ksn);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0577a
    public void bt() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof k) {
                    this.ea.add((k) bVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        Shader by;
        com.tb.airbnb.lottie.d.beginSection("GradientFillContent#draw");
        this.path.reset();
        for (int i2 = 0; i2 < this.ea.size(); i2++) {
            this.path.addPath(this.ea.get(i2).bw(), matrix);
        }
        this.path.computeBounds(this.en, false);
        if (this.ksl == GradientType.Linear) {
            by = bx();
        } else {
            by = by();
        }
        this.em.set(matrix);
        by.setLocalMatrix(this.em);
        this.paint.setShader(by);
        this.paint.setAlpha((int) (((this.ksd.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        canvas.drawPath(this.path, this.paint);
        com.tb.airbnb.lottie.d.D("GradientFillContent#draw");
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.ea.size(); i++) {
            this.path.addPath(this.ea.get(i).bw(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
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
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.cv(), Shader.TileMode.CLAMP);
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
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, cv, Shader.TileMode.CLAMP);
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
