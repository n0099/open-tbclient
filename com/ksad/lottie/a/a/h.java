package com.ksad.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.ksad.lottie.model.content.GradientType;
/* loaded from: classes3.dex */
public class h extends a {

    /* renamed from: b  reason: collision with root package name */
    private final String f7943b;
    private final LongSparseArray<LinearGradient> c;
    private final LongSparseArray<RadialGradient> d;
    private final RectF e;
    private final GradientType f;
    private final int g;
    private final com.ksad.lottie.a.b.a<com.ksad.lottie.model.content.c, com.ksad.lottie.model.content.c> h;
    private final com.ksad.lottie.a.b.a<PointF, PointF> i;
    private final com.ksad.lottie.a.b.a<PointF, PointF> j;

    public h(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.h().toPaintCap(), eVar.i().toPaintJoin(), eVar.l(), eVar.d(), eVar.g(), eVar.j(), eVar.k());
        this.c = new LongSparseArray<>();
        this.d = new LongSparseArray<>();
        this.e = new RectF();
        this.f7943b = eVar.a();
        this.f = eVar.b();
        this.g = (int) (fVar.r().c() / 32.0f);
        this.h = eVar.c().a();
        this.h.a(this);
        aVar.a(this.h);
        this.i = eVar.e().a();
        this.i.a(this);
        aVar.a(this.i);
        this.j = eVar.f().a();
        this.j.a(this);
        aVar.a(this.j);
    }

    private LinearGradient b() {
        int d = d();
        LinearGradient linearGradient = this.c.get(d);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF e = this.i.e();
        PointF e2 = this.j.e();
        com.ksad.lottie.model.content.c e3 = this.h.e();
        LinearGradient linearGradient2 = new LinearGradient((int) (this.e.left + (this.e.width() / 2.0f) + e.x), (int) (e.y + this.e.top + (this.e.height() / 2.0f)), (int) (this.e.left + (this.e.width() / 2.0f) + e2.x), (int) (this.e.top + (this.e.height() / 2.0f) + e2.y), e3.b(), e3.a(), Shader.TileMode.CLAMP);
        this.c.put(d, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient c() {
        int d = d();
        RadialGradient radialGradient = this.d.get(d);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF e = this.i.e();
        PointF e2 = this.j.e();
        com.ksad.lottie.model.content.c e3 = this.h.e();
        int[] b2 = e3.b();
        float[] a2 = e3.a();
        int width = (int) (this.e.left + (this.e.width() / 2.0f) + e.x);
        int height = (int) (e.y + this.e.top + (this.e.height() / 2.0f));
        float f = e2.y;
        RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.e.left + (this.e.width() / 2.0f)) + e2.x)) - width, ((int) (f + (this.e.top + (this.e.height() / 2.0f)))) - height), b2, a2, Shader.TileMode.CLAMP);
        this.d.put(d, radialGradient2);
        return radialGradient2;
    }

    private int d() {
        int round = Math.round(this.i.f() * this.g);
        int round2 = Math.round(this.j.f() * this.g);
        int round3 = Math.round(this.h.f() * this.g);
        int i = round != 0 ? round * 527 : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    @Override // com.ksad.lottie.a.a.a, com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.e, matrix);
        if (this.f == GradientType.Linear) {
            this.f7931a.setShader(b());
        } else {
            this.f7931a.setShader(c());
        }
        super.a(canvas, matrix, i);
    }
}
