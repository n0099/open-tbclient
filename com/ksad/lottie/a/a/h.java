package com.ksad.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.ksad.lottie.model.content.GradientType;
/* loaded from: classes6.dex */
public class h extends a {

    /* renamed from: b  reason: collision with root package name */
    public final String f31617b;

    /* renamed from: c  reason: collision with root package name */
    public final LongSparseArray<LinearGradient> f31618c;

    /* renamed from: d  reason: collision with root package name */
    public final LongSparseArray<RadialGradient> f31619d;

    /* renamed from: e  reason: collision with root package name */
    public final RectF f31620e;

    /* renamed from: f  reason: collision with root package name */
    public final GradientType f31621f;

    /* renamed from: g  reason: collision with root package name */
    public final int f31622g;

    /* renamed from: h  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<com.ksad.lottie.model.content.c, com.ksad.lottie.model.content.c> f31623h;
    public final com.ksad.lottie.a.b.a<PointF, PointF> i;
    public final com.ksad.lottie.a.b.a<PointF, PointF> j;

    public h(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.h().toPaintCap(), eVar.i().toPaintJoin(), eVar.l(), eVar.d(), eVar.g(), eVar.j(), eVar.k());
        this.f31618c = new LongSparseArray<>();
        this.f31619d = new LongSparseArray<>();
        this.f31620e = new RectF();
        this.f31617b = eVar.a();
        this.f31621f = eVar.b();
        this.f31622g = (int) (fVar.r().c() / 32.0f);
        com.ksad.lottie.a.b.a<com.ksad.lottie.model.content.c, com.ksad.lottie.model.content.c> a2 = eVar.c().a();
        this.f31623h = a2;
        a2.a(this);
        aVar.a(this.f31623h);
        com.ksad.lottie.a.b.a<PointF, PointF> a3 = eVar.e().a();
        this.i = a3;
        a3.a(this);
        aVar.a(this.i);
        com.ksad.lottie.a.b.a<PointF, PointF> a4 = eVar.f().a();
        this.j = a4;
        a4.a(this);
        aVar.a(this.j);
    }

    private LinearGradient b() {
        long d2 = d();
        LinearGradient linearGradient = this.f31618c.get(d2);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF e2 = this.i.e();
        PointF e3 = this.j.e();
        com.ksad.lottie.model.content.c e4 = this.f31623h.e();
        int[] b2 = e4.b();
        float[] a2 = e4.a();
        RectF rectF = this.f31620e;
        int width = (int) (rectF.left + (rectF.width() / 2.0f) + e2.x);
        RectF rectF2 = this.f31620e;
        int height = (int) (rectF2.top + (rectF2.height() / 2.0f) + e2.y);
        RectF rectF3 = this.f31620e;
        int width2 = (int) (rectF3.left + (rectF3.width() / 2.0f) + e3.x);
        RectF rectF4 = this.f31620e;
        LinearGradient linearGradient2 = new LinearGradient(width, height, width2, (int) (rectF4.top + (rectF4.height() / 2.0f) + e3.y), b2, a2, Shader.TileMode.CLAMP);
        this.f31618c.put(d2, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient c() {
        long d2 = d();
        RadialGradient radialGradient = this.f31619d.get(d2);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF e2 = this.i.e();
        PointF e3 = this.j.e();
        com.ksad.lottie.model.content.c e4 = this.f31623h.e();
        int[] b2 = e4.b();
        float[] a2 = e4.a();
        RectF rectF = this.f31620e;
        int width = (int) (rectF.left + (rectF.width() / 2.0f) + e2.x);
        RectF rectF2 = this.f31620e;
        int height = (int) (rectF2.top + (rectF2.height() / 2.0f) + e2.y);
        RectF rectF3 = this.f31620e;
        int width2 = (int) (rectF3.left + (rectF3.width() / 2.0f) + e3.x);
        RectF rectF4 = this.f31620e;
        RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(width2 - width, ((int) ((rectF4.top + (rectF4.height() / 2.0f)) + e3.y)) - height), b2, a2, Shader.TileMode.CLAMP);
        this.f31619d.put(d2, radialGradient2);
        return radialGradient2;
    }

    private int d() {
        int round = Math.round(this.i.f() * this.f31622g);
        int round2 = Math.round(this.j.f() * this.f31622g);
        int round3 = Math.round(this.f31623h.f() * this.f31622g);
        int i = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    @Override // com.ksad.lottie.a.a.a, com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        Paint paint;
        Shader c2;
        a(this.f31620e, matrix);
        if (this.f31621f == GradientType.Linear) {
            paint = this.f31575a;
            c2 = b();
        } else {
            paint = this.f31575a;
            c2 = c();
        }
        paint.setShader(c2);
        super.a(canvas, matrix, i);
    }
}
