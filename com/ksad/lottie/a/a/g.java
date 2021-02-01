package com.ksad.lottie.a.a;

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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.GradientType;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class g implements d, j, a.InterfaceC1065a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final String f7941a;

    /* renamed from: b  reason: collision with root package name */
    private final com.ksad.lottie.model.layer.a f7942b;
    private final LongSparseArray<LinearGradient> c = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> d = new LongSparseArray<>();
    private final Matrix e = new Matrix();
    private final Path f = new Path();
    private final Paint g = new Paint(1);
    private final RectF h = new RectF();
    private final List<l> i = new ArrayList();
    private final GradientType j;
    private final com.ksad.lottie.a.b.a<com.ksad.lottie.model.content.c, com.ksad.lottie.model.content.c> k;
    private final com.ksad.lottie.a.b.a<Integer, Integer> l;
    private final com.ksad.lottie.a.b.a<PointF, PointF> m;
    private final com.ksad.lottie.a.b.a<PointF, PointF> n;
    @Nullable
    private com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> o;
    private final com.ksad.lottie.f p;
    private final int q;

    public g(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.d dVar) {
        this.f7942b = aVar;
        this.f7941a = dVar.a();
        this.p = fVar;
        this.j = dVar.b();
        this.f.setFillType(dVar.c());
        this.q = (int) (fVar.r().c() / 32.0f);
        this.k = dVar.d().a();
        this.k.a(this);
        aVar.a(this.k);
        this.l = dVar.e().a();
        this.l.a(this);
        aVar.a(this.l);
        this.m = dVar.f().a();
        this.m.a(this);
        aVar.a(this.m);
        this.n = dVar.g().a();
        this.n.a(this);
        aVar.a(this.n);
    }

    private LinearGradient b() {
        int d = d();
        LinearGradient linearGradient = this.c.get(d);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF e = this.m.e();
        PointF e2 = this.n.e();
        com.ksad.lottie.model.content.c e3 = this.k.e();
        LinearGradient linearGradient2 = new LinearGradient(e.x, e.y, e2.x, e2.y, e3.b(), e3.a(), Shader.TileMode.CLAMP);
        this.c.put(d, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient c() {
        int d = d();
        RadialGradient radialGradient = this.d.get(d);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF e = this.m.e();
        PointF e2 = this.n.e();
        com.ksad.lottie.model.content.c e3 = this.k.e();
        int[] b2 = e3.b();
        float[] a2 = e3.a();
        float f = e.x;
        float f2 = e.y;
        RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(e2.x - f, e2.y - f2), b2, a2, Shader.TileMode.CLAMP);
        this.d.put(d, radialGradient2);
        return radialGradient2;
    }

    private int d() {
        int round = Math.round(this.m.f() * this.q);
        int round2 = Math.round(this.n.f() * this.q);
        int round3 = Math.round(this.k.f() * this.q);
        int i = round != 0 ? round * 527 : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC1065a
    public void a() {
        this.p.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.ksad.lottie.c.c("GradientFillContent#draw");
        this.f.reset();
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            this.f.addPath(this.i.get(i2).d(), matrix);
        }
        this.f.computeBounds(this.h, false);
        Shader b2 = this.j == GradientType.Linear ? b() : c();
        this.e.set(matrix);
        b2.setLocalMatrix(this.e);
        this.g.setShader(b2);
        if (this.o != null) {
            this.g.setColorFilter(this.o.e());
        }
        this.g.setAlpha(com.ksad.lottie.d.e.a((int) (((this.l.e().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f, this.g);
        com.ksad.lottie.c.d("GradientFillContent#draw");
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.f.reset();
        for (int i = 0; i < this.i.size(); i++) {
            this.f.addPath(this.i.get(i).d(), matrix);
        }
        this.f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list2.size()) {
                return;
            }
            b bVar = list2.get(i2);
            if (bVar instanceof l) {
                this.i.add((l) bVar);
            }
            i = i2 + 1;
        }
    }
}
