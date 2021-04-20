package com.ksad.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
/* loaded from: classes6.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f31598a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public final a<PointF, PointF> f31599b;

    /* renamed from: c  reason: collision with root package name */
    public final a<?, PointF> f31600c;

    /* renamed from: d  reason: collision with root package name */
    public final a<com.ksad.lottie.e.d, com.ksad.lottie.e.d> f31601d;

    /* renamed from: e  reason: collision with root package name */
    public final a<Float, Float> f31602e;

    /* renamed from: f  reason: collision with root package name */
    public final a<Integer, Integer> f31603f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final a<?, Float> f31604g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final a<?, Float> f31605h;

    public o(com.ksad.lottie.model.a.l lVar) {
        this.f31599b = lVar.a().a();
        this.f31600c = lVar.b().a();
        this.f31601d = lVar.c().a();
        this.f31602e = lVar.d().a();
        this.f31603f = lVar.e().a();
        if (lVar.f() != null) {
            this.f31604g = lVar.f().a();
        } else {
            this.f31604g = null;
        }
        if (lVar.g() != null) {
            this.f31605h = lVar.g().a();
        } else {
            this.f31605h = null;
        }
    }

    public a<?, Integer> a() {
        return this.f31603f;
    }

    public void a(float f2) {
        this.f31599b.a(f2);
        this.f31600c.a(f2);
        this.f31601d.a(f2);
        this.f31602e.a(f2);
        this.f31603f.a(f2);
        a<?, Float> aVar = this.f31604g;
        if (aVar != null) {
            aVar.a(f2);
        }
        a<?, Float> aVar2 = this.f31605h;
        if (aVar2 != null) {
            aVar2.a(f2);
        }
    }

    public void a(a.InterfaceC0366a interfaceC0366a) {
        this.f31599b.a(interfaceC0366a);
        this.f31600c.a(interfaceC0366a);
        this.f31601d.a(interfaceC0366a);
        this.f31602e.a(interfaceC0366a);
        this.f31603f.a(interfaceC0366a);
        a<?, Float> aVar = this.f31604g;
        if (aVar != null) {
            aVar.a(interfaceC0366a);
        }
        a<?, Float> aVar2 = this.f31605h;
        if (aVar2 != null) {
            aVar2.a(interfaceC0366a);
        }
    }

    public void a(com.ksad.lottie.model.layer.a aVar) {
        aVar.a(this.f31599b);
        aVar.a(this.f31600c);
        aVar.a(this.f31601d);
        aVar.a(this.f31602e);
        aVar.a(this.f31603f);
        a<?, Float> aVar2 = this.f31604g;
        if (aVar2 != null) {
            aVar.a(aVar2);
        }
        a<?, Float> aVar3 = this.f31605h;
        if (aVar3 != null) {
            aVar.a(aVar3);
        }
    }

    public Matrix b(float f2) {
        PointF e2 = this.f31600c.e();
        PointF e3 = this.f31599b.e();
        com.ksad.lottie.e.d e4 = this.f31601d.e();
        float floatValue = this.f31602e.e().floatValue();
        this.f31598a.reset();
        this.f31598a.preTranslate(e2.x * f2, e2.y * f2);
        double d2 = f2;
        this.f31598a.preScale((float) Math.pow(e4.a(), d2), (float) Math.pow(e4.b(), d2));
        this.f31598a.preRotate(floatValue * f2, e3.x, e3.y);
        return this.f31598a;
    }

    @Nullable
    public a<?, Float> b() {
        return this.f31604g;
    }

    @Nullable
    public a<?, Float> c() {
        return this.f31605h;
    }

    public Matrix d() {
        this.f31598a.reset();
        PointF e2 = this.f31600c.e();
        if (e2.x != 0.0f || e2.y != 0.0f) {
            this.f31598a.preTranslate(e2.x, e2.y);
        }
        float floatValue = this.f31602e.e().floatValue();
        if (floatValue != 0.0f) {
            this.f31598a.preRotate(floatValue);
        }
        com.ksad.lottie.e.d e3 = this.f31601d.e();
        if (e3.a() != 1.0f || e3.b() != 1.0f) {
            this.f31598a.preScale(e3.a(), e3.b());
        }
        PointF e4 = this.f31599b.e();
        if (e4.x != 0.0f || e4.y != 0.0f) {
            this.f31598a.preTranslate(-e4.x, -e4.y);
        }
        return this.f31598a;
    }
}
