package com.ksad.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
/* loaded from: classes6.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f31935a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public final a<PointF, PointF> f31936b;

    /* renamed from: c  reason: collision with root package name */
    public final a<?, PointF> f31937c;

    /* renamed from: d  reason: collision with root package name */
    public final a<com.ksad.lottie.e.d, com.ksad.lottie.e.d> f31938d;

    /* renamed from: e  reason: collision with root package name */
    public final a<Float, Float> f31939e;

    /* renamed from: f  reason: collision with root package name */
    public final a<Integer, Integer> f31940f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final a<?, Float> f31941g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final a<?, Float> f31942h;

    public o(com.ksad.lottie.model.a.l lVar) {
        this.f31936b = lVar.a().a();
        this.f31937c = lVar.b().a();
        this.f31938d = lVar.c().a();
        this.f31939e = lVar.d().a();
        this.f31940f = lVar.e().a();
        if (lVar.f() != null) {
            this.f31941g = lVar.f().a();
        } else {
            this.f31941g = null;
        }
        if (lVar.g() != null) {
            this.f31942h = lVar.g().a();
        } else {
            this.f31942h = null;
        }
    }

    public a<?, Integer> a() {
        return this.f31940f;
    }

    public void a(float f2) {
        this.f31936b.a(f2);
        this.f31937c.a(f2);
        this.f31938d.a(f2);
        this.f31939e.a(f2);
        this.f31940f.a(f2);
        a<?, Float> aVar = this.f31941g;
        if (aVar != null) {
            aVar.a(f2);
        }
        a<?, Float> aVar2 = this.f31942h;
        if (aVar2 != null) {
            aVar2.a(f2);
        }
    }

    public void a(a.InterfaceC0355a interfaceC0355a) {
        this.f31936b.a(interfaceC0355a);
        this.f31937c.a(interfaceC0355a);
        this.f31938d.a(interfaceC0355a);
        this.f31939e.a(interfaceC0355a);
        this.f31940f.a(interfaceC0355a);
        a<?, Float> aVar = this.f31941g;
        if (aVar != null) {
            aVar.a(interfaceC0355a);
        }
        a<?, Float> aVar2 = this.f31942h;
        if (aVar2 != null) {
            aVar2.a(interfaceC0355a);
        }
    }

    public void a(com.ksad.lottie.model.layer.a aVar) {
        aVar.a(this.f31936b);
        aVar.a(this.f31937c);
        aVar.a(this.f31938d);
        aVar.a(this.f31939e);
        aVar.a(this.f31940f);
        a<?, Float> aVar2 = this.f31941g;
        if (aVar2 != null) {
            aVar.a(aVar2);
        }
        a<?, Float> aVar3 = this.f31942h;
        if (aVar3 != null) {
            aVar.a(aVar3);
        }
    }

    public Matrix b(float f2) {
        PointF e2 = this.f31937c.e();
        PointF e3 = this.f31936b.e();
        com.ksad.lottie.e.d e4 = this.f31938d.e();
        float floatValue = this.f31939e.e().floatValue();
        this.f31935a.reset();
        this.f31935a.preTranslate(e2.x * f2, e2.y * f2);
        double d2 = f2;
        this.f31935a.preScale((float) Math.pow(e4.a(), d2), (float) Math.pow(e4.b(), d2));
        this.f31935a.preRotate(floatValue * f2, e3.x, e3.y);
        return this.f31935a;
    }

    @Nullable
    public a<?, Float> b() {
        return this.f31941g;
    }

    @Nullable
    public a<?, Float> c() {
        return this.f31942h;
    }

    public Matrix d() {
        this.f31935a.reset();
        PointF e2 = this.f31937c.e();
        if (e2.x != 0.0f || e2.y != 0.0f) {
            this.f31935a.preTranslate(e2.x, e2.y);
        }
        float floatValue = this.f31939e.e().floatValue();
        if (floatValue != 0.0f) {
            this.f31935a.preRotate(floatValue);
        }
        com.ksad.lottie.e.d e3 = this.f31938d.e();
        if (e3.a() != 1.0f || e3.b() != 1.0f) {
            this.f31935a.preScale(e3.a(), e3.b());
        }
        PointF e4 = this.f31936b.e();
        if (e4.x != 0.0f || e4.y != 0.0f) {
            this.f31935a.preTranslate(-e4.x, -e4.y);
        }
        return this.f31935a;
    }
}
