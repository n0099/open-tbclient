package com.ksad.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
/* loaded from: classes6.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f31693a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public final a<PointF, PointF> f31694b;

    /* renamed from: c  reason: collision with root package name */
    public final a<?, PointF> f31695c;

    /* renamed from: d  reason: collision with root package name */
    public final a<com.ksad.lottie.e.d, com.ksad.lottie.e.d> f31696d;

    /* renamed from: e  reason: collision with root package name */
    public final a<Float, Float> f31697e;

    /* renamed from: f  reason: collision with root package name */
    public final a<Integer, Integer> f31698f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final a<?, Float> f31699g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final a<?, Float> f31700h;

    public o(com.ksad.lottie.model.a.l lVar) {
        this.f31694b = lVar.a().a();
        this.f31695c = lVar.b().a();
        this.f31696d = lVar.c().a();
        this.f31697e = lVar.d().a();
        this.f31698f = lVar.e().a();
        if (lVar.f() != null) {
            this.f31699g = lVar.f().a();
        } else {
            this.f31699g = null;
        }
        if (lVar.g() != null) {
            this.f31700h = lVar.g().a();
        } else {
            this.f31700h = null;
        }
    }

    public a<?, Integer> a() {
        return this.f31698f;
    }

    public void a(float f2) {
        this.f31694b.a(f2);
        this.f31695c.a(f2);
        this.f31696d.a(f2);
        this.f31697e.a(f2);
        this.f31698f.a(f2);
        a<?, Float> aVar = this.f31699g;
        if (aVar != null) {
            aVar.a(f2);
        }
        a<?, Float> aVar2 = this.f31700h;
        if (aVar2 != null) {
            aVar2.a(f2);
        }
    }

    public void a(a.InterfaceC0369a interfaceC0369a) {
        this.f31694b.a(interfaceC0369a);
        this.f31695c.a(interfaceC0369a);
        this.f31696d.a(interfaceC0369a);
        this.f31697e.a(interfaceC0369a);
        this.f31698f.a(interfaceC0369a);
        a<?, Float> aVar = this.f31699g;
        if (aVar != null) {
            aVar.a(interfaceC0369a);
        }
        a<?, Float> aVar2 = this.f31700h;
        if (aVar2 != null) {
            aVar2.a(interfaceC0369a);
        }
    }

    public void a(com.ksad.lottie.model.layer.a aVar) {
        aVar.a(this.f31694b);
        aVar.a(this.f31695c);
        aVar.a(this.f31696d);
        aVar.a(this.f31697e);
        aVar.a(this.f31698f);
        a<?, Float> aVar2 = this.f31699g;
        if (aVar2 != null) {
            aVar.a(aVar2);
        }
        a<?, Float> aVar3 = this.f31700h;
        if (aVar3 != null) {
            aVar.a(aVar3);
        }
    }

    public Matrix b(float f2) {
        PointF e2 = this.f31695c.e();
        PointF e3 = this.f31694b.e();
        com.ksad.lottie.e.d e4 = this.f31696d.e();
        float floatValue = this.f31697e.e().floatValue();
        this.f31693a.reset();
        this.f31693a.preTranslate(e2.x * f2, e2.y * f2);
        double d2 = f2;
        this.f31693a.preScale((float) Math.pow(e4.a(), d2), (float) Math.pow(e4.b(), d2));
        this.f31693a.preRotate(floatValue * f2, e3.x, e3.y);
        return this.f31693a;
    }

    @Nullable
    public a<?, Float> b() {
        return this.f31699g;
    }

    @Nullable
    public a<?, Float> c() {
        return this.f31700h;
    }

    public Matrix d() {
        this.f31693a.reset();
        PointF e2 = this.f31695c.e();
        if (e2.x != 0.0f || e2.y != 0.0f) {
            this.f31693a.preTranslate(e2.x, e2.y);
        }
        float floatValue = this.f31697e.e().floatValue();
        if (floatValue != 0.0f) {
            this.f31693a.preRotate(floatValue);
        }
        com.ksad.lottie.e.d e3 = this.f31696d.e();
        if (e3.a() != 1.0f || e3.b() != 1.0f) {
            this.f31693a.preScale(e3.a(), e3.b());
        }
        PointF e4 = this.f31694b.e();
        if (e4.x != 0.0f || e4.y != 0.0f) {
            this.f31693a.preTranslate(-e4.x, -e4.y);
        }
        return this.f31693a;
    }
}
