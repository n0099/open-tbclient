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
/* loaded from: classes6.dex */
public class g implements d, j, a.InterfaceC0355a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final String f31846a;

    /* renamed from: b  reason: collision with root package name */
    public final com.ksad.lottie.model.layer.a f31847b;

    /* renamed from: c  reason: collision with root package name */
    public final LongSparseArray<LinearGradient> f31848c = new LongSparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    public final LongSparseArray<RadialGradient> f31849d = new LongSparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    public final Matrix f31850e = new Matrix();

    /* renamed from: f  reason: collision with root package name */
    public final Path f31851f = new Path();

    /* renamed from: g  reason: collision with root package name */
    public final Paint f31852g = new Paint(1);

    /* renamed from: h  reason: collision with root package name */
    public final RectF f31853h = new RectF();

    /* renamed from: i  reason: collision with root package name */
    public final List<l> f31854i = new ArrayList();
    public final GradientType j;
    public final com.ksad.lottie.a.b.a<com.ksad.lottie.model.content.c, com.ksad.lottie.model.content.c> k;
    public final com.ksad.lottie.a.b.a<Integer, Integer> l;
    public final com.ksad.lottie.a.b.a<PointF, PointF> m;
    public final com.ksad.lottie.a.b.a<PointF, PointF> n;
    @Nullable
    public com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> o;
    public final com.ksad.lottie.f p;
    public final int q;

    public g(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.d dVar) {
        this.f31847b = aVar;
        this.f31846a = dVar.a();
        this.p = fVar;
        this.j = dVar.b();
        this.f31851f.setFillType(dVar.c());
        this.q = (int) (fVar.r().c() / 32.0f);
        com.ksad.lottie.a.b.a<com.ksad.lottie.model.content.c, com.ksad.lottie.model.content.c> a2 = dVar.d().a();
        this.k = a2;
        a2.a(this);
        aVar.a(this.k);
        com.ksad.lottie.a.b.a<Integer, Integer> a3 = dVar.e().a();
        this.l = a3;
        a3.a(this);
        aVar.a(this.l);
        com.ksad.lottie.a.b.a<PointF, PointF> a4 = dVar.f().a();
        this.m = a4;
        a4.a(this);
        aVar.a(this.m);
        com.ksad.lottie.a.b.a<PointF, PointF> a5 = dVar.g().a();
        this.n = a5;
        a5.a(this);
        aVar.a(this.n);
    }

    private LinearGradient b() {
        long d2 = d();
        LinearGradient linearGradient = this.f31848c.get(d2);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF e2 = this.m.e();
        PointF e3 = this.n.e();
        com.ksad.lottie.model.content.c e4 = this.k.e();
        LinearGradient linearGradient2 = new LinearGradient(e2.x, e2.y, e3.x, e3.y, e4.b(), e4.a(), Shader.TileMode.CLAMP);
        this.f31848c.put(d2, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient c() {
        float f2;
        float f3;
        long d2 = d();
        RadialGradient radialGradient = this.f31849d.get(d2);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF e2 = this.m.e();
        PointF e3 = this.n.e();
        com.ksad.lottie.model.content.c e4 = this.k.e();
        int[] b2 = e4.b();
        float[] a2 = e4.a();
        RadialGradient radialGradient2 = new RadialGradient(e2.x, e2.y, (float) Math.hypot(e3.x - f2, e3.y - f3), b2, a2, Shader.TileMode.CLAMP);
        this.f31849d.put(d2, radialGradient2);
        return radialGradient2;
    }

    private int d() {
        int round = Math.round(this.m.f() * this.q);
        int round2 = Math.round(this.n.f() * this.q);
        int round3 = Math.round(this.k.f() * this.q);
        int i2 = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i2 = i2 * 31 * round2;
        }
        return round3 != 0 ? i2 * 31 * round3 : i2;
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0355a
    public void a() {
        this.p.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i2) {
        com.ksad.lottie.c.c("GradientFillContent#draw");
        this.f31851f.reset();
        for (int i3 = 0; i3 < this.f31854i.size(); i3++) {
            this.f31851f.addPath(this.f31854i.get(i3).d(), matrix);
        }
        this.f31851f.computeBounds(this.f31853h, false);
        Shader b2 = this.j == GradientType.Linear ? b() : c();
        this.f31850e.set(matrix);
        b2.setLocalMatrix(this.f31850e);
        this.f31852g.setShader(b2);
        com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.o;
        if (aVar != null) {
            this.f31852g.setColorFilter(aVar.e());
        }
        this.f31852g.setAlpha(com.ksad.lottie.d.e.a((int) ((((i2 / 255.0f) * this.l.e().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f31851f, this.f31852g);
        com.ksad.lottie.c.d("GradientFillContent#draw");
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.f31851f.reset();
        for (int i2 = 0; i2 < this.f31854i.size(); i2++) {
            this.f31851f.addPath(this.f31854i.get(i2).d(), matrix);
        }
        this.f31851f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            b bVar = list2.get(i2);
            if (bVar instanceof l) {
                this.f31854i.add((l) bVar);
            }
        }
    }
}
