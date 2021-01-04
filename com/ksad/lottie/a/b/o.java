package com.ksad.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
/* loaded from: classes5.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f8260a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final a<PointF, PointF> f8261b;
    private final a<?, PointF> c;
    private final a<com.ksad.lottie.e.d, com.ksad.lottie.e.d> d;
    private final a<Float, Float> e;
    private final a<Integer, Integer> f;
    @Nullable
    private final a<?, Float> g;
    @Nullable
    private final a<?, Float> h;

    public o(com.ksad.lottie.model.a.l lVar) {
        this.f8261b = lVar.a().a();
        this.c = lVar.b().a();
        this.d = lVar.c().a();
        this.e = lVar.d().a();
        this.f = lVar.e().a();
        if (lVar.f() != null) {
            this.g = lVar.f().a();
        } else {
            this.g = null;
        }
        if (lVar.g() != null) {
            this.h = lVar.g().a();
        } else {
            this.h = null;
        }
    }

    public a<?, Integer> a() {
        return this.f;
    }

    public void a(float f) {
        this.f8261b.a(f);
        this.c.a(f);
        this.d.a(f);
        this.e.a(f);
        this.f.a(f);
        if (this.g != null) {
            this.g.a(f);
        }
        if (this.h != null) {
            this.h.a(f);
        }
    }

    public void a(a.InterfaceC1037a interfaceC1037a) {
        this.f8261b.a(interfaceC1037a);
        this.c.a(interfaceC1037a);
        this.d.a(interfaceC1037a);
        this.e.a(interfaceC1037a);
        this.f.a(interfaceC1037a);
        if (this.g != null) {
            this.g.a(interfaceC1037a);
        }
        if (this.h != null) {
            this.h.a(interfaceC1037a);
        }
    }

    public void a(com.ksad.lottie.model.layer.a aVar) {
        aVar.a(this.f8261b);
        aVar.a(this.c);
        aVar.a(this.d);
        aVar.a(this.e);
        aVar.a(this.f);
        if (this.g != null) {
            aVar.a(this.g);
        }
        if (this.h != null) {
            aVar.a(this.h);
        }
    }

    public Matrix b(float f) {
        PointF e = this.c.e();
        PointF e2 = this.f8261b.e();
        com.ksad.lottie.e.d e3 = this.d.e();
        float floatValue = this.e.e().floatValue();
        this.f8260a.reset();
        this.f8260a.preTranslate(e.x * f, e.y * f);
        this.f8260a.preScale((float) Math.pow(e3.a(), f), (float) Math.pow(e3.b(), f));
        this.f8260a.preRotate(floatValue * f, e2.x, e2.y);
        return this.f8260a;
    }

    @Nullable
    public a<?, Float> b() {
        return this.g;
    }

    @Nullable
    public a<?, Float> c() {
        return this.h;
    }

    public Matrix d() {
        this.f8260a.reset();
        PointF e = this.c.e();
        if (e.x != 0.0f || e.y != 0.0f) {
            this.f8260a.preTranslate(e.x, e.y);
        }
        float floatValue = this.e.e().floatValue();
        if (floatValue != 0.0f) {
            this.f8260a.preRotate(floatValue);
        }
        com.ksad.lottie.e.d e2 = this.d.e();
        if (e2.a() != 1.0f || e2.b() != 1.0f) {
            this.f8260a.preScale(e2.a(), e2.b());
        }
        PointF e3 = this.f8261b.e();
        if (e3.x != 0.0f || e3.y != 0.0f) {
            this.f8260a.preTranslate(-e3.x, -e3.y);
        }
        return this.f8260a;
    }
}
