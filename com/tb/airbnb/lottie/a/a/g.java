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
    private final int eR;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> ksU;
    private final com.tb.airbnb.lottie.a.b.a<com.tb.airbnb.lottie.model.content.c, com.tb.airbnb.lottie.model.content.c> ktb;
    private final GradientType ktc;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> ktd;
    private final com.tb.airbnb.lottie.a.b.a<PointF, PointF> kte;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final String name;
    private final LongSparseArray<LinearGradient> eK = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> eL = new LongSparseArray<>();
    private final Matrix eM = new Matrix();
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final RectF eN = new RectF();
    private final List<k> eA = new ArrayList();

    public g(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.d dVar) {
        this.name = dVar.getName();
        this.lottieDrawable = fVar;
        this.ktc = dVar.cLG();
        this.path.setFillType(dVar.cx());
        this.eR = (int) (fVar.cLc().getDuration() / 32);
        this.ktb = dVar.cLH().cLn();
        this.ktb.b(this);
        aVar.a(this.ktb);
        this.ksU = dVar.cLz().cLn();
        this.ksU.b(this);
        aVar.a(this.ksU);
        this.ktd = dVar.cLI().cLn();
        this.ktd.b(this);
        aVar.a(this.ktd);
        this.kte = dVar.cLJ().cLn();
        this.kte.b(this);
        aVar.a(this.kte);
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
                    this.eA.add((k) bVar);
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
        for (int i2 = 0; i2 < this.eA.size(); i2++) {
            this.path.addPath(this.eA.get(i2).bw(), matrix);
        }
        this.path.computeBounds(this.eN, false);
        if (this.ktc == GradientType.Linear) {
            by = bx();
        } else {
            by = by();
        }
        this.eM.set(matrix);
        by.setLocalMatrix(this.eM);
        this.paint.setShader(by);
        this.paint.setAlpha((int) (((this.ksU.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        canvas.drawPath(this.path, this.paint);
        com.tb.airbnb.lottie.d.D("GradientFillContent#draw");
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.eA.size(); i++) {
            this.path.addPath(this.eA.get(i).bw(), matrix);
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
        LinearGradient linearGradient = this.eK.get(bz);
        if (linearGradient == null) {
            PointF value = this.ktd.getValue();
            PointF value2 = this.kte.getValue();
            com.tb.airbnb.lottie.model.content.c value3 = this.ktb.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.cv(), Shader.TileMode.CLAMP);
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
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, cv, Shader.TileMode.CLAMP);
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
