package com.ksad.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
/* loaded from: classes6.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f31308a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public final a<PointF, PointF> f31309b;

    /* renamed from: c  reason: collision with root package name */
    public final a<?, PointF> f31310c;

    /* renamed from: d  reason: collision with root package name */
    public final a<com.ksad.lottie.e.d, com.ksad.lottie.e.d> f31311d;

    /* renamed from: e  reason: collision with root package name */
    public final a<Float, Float> f31312e;

    /* renamed from: f  reason: collision with root package name */
    public final a<Integer, Integer> f31313f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final a<?, Float> f31314g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final a<?, Float> f31315h;

    public o(com.ksad.lottie.model.a.l lVar) {
        this.f31309b = lVar.a().a();
        this.f31310c = lVar.b().a();
        this.f31311d = lVar.c().a();
        this.f31312e = lVar.d().a();
        this.f31313f = lVar.e().a();
        if (lVar.f() != null) {
            this.f31314g = lVar.f().a();
        } else {
            this.f31314g = null;
        }
        if (lVar.g() != null) {
            this.f31315h = lVar.g().a();
        } else {
            this.f31315h = null;
        }
    }

    public a<?, Integer> a() {
        return this.f31313f;
    }

    public void a(float f2) {
        this.f31309b.a(f2);
        this.f31310c.a(f2);
        this.f31311d.a(f2);
        this.f31312e.a(f2);
        this.f31313f.a(f2);
        a<?, Float> aVar = this.f31314g;
        if (aVar != null) {
            aVar.a(f2);
        }
        a<?, Float> aVar2 = this.f31315h;
        if (aVar2 != null) {
            aVar2.a(f2);
        }
    }

    public void a(a.InterfaceC0351a interfaceC0351a) {
        this.f31309b.a(interfaceC0351a);
        this.f31310c.a(interfaceC0351a);
        this.f31311d.a(interfaceC0351a);
        this.f31312e.a(interfaceC0351a);
        this.f31313f.a(interfaceC0351a);
        a<?, Float> aVar = this.f31314g;
        if (aVar != null) {
            aVar.a(interfaceC0351a);
        }
        a<?, Float> aVar2 = this.f31315h;
        if (aVar2 != null) {
            aVar2.a(interfaceC0351a);
        }
    }

    public void a(com.ksad.lottie.model.layer.a aVar) {
        aVar.a(this.f31309b);
        aVar.a(this.f31310c);
        aVar.a(this.f31311d);
        aVar.a(this.f31312e);
        aVar.a(this.f31313f);
        a<?, Float> aVar2 = this.f31314g;
        if (aVar2 != null) {
            aVar.a(aVar2);
        }
        a<?, Float> aVar3 = this.f31315h;
        if (aVar3 != null) {
            aVar.a(aVar3);
        }
    }

    public Matrix b(float f2) {
        PointF e2 = this.f31310c.e();
        PointF e3 = this.f31309b.e();
        com.ksad.lottie.e.d e4 = this.f31311d.e();
        float floatValue = this.f31312e.e().floatValue();
        this.f31308a.reset();
        this.f31308a.preTranslate(e2.x * f2, e2.y * f2);
        double d2 = f2;
        this.f31308a.preScale((float) Math.pow(e4.a(), d2), (float) Math.pow(e4.b(), d2));
        this.f31308a.preRotate(floatValue * f2, e3.x, e3.y);
        return this.f31308a;
    }

    @Nullable
    public a<?, Float> b() {
        return this.f31314g;
    }

    @Nullable
    public a<?, Float> c() {
        return this.f31315h;
    }

    public Matrix d() {
        this.f31308a.reset();
        PointF e2 = this.f31310c.e();
        if (e2.x != 0.0f || e2.y != 0.0f) {
            this.f31308a.preTranslate(e2.x, e2.y);
        }
        float floatValue = this.f31312e.e().floatValue();
        if (floatValue != 0.0f) {
            this.f31308a.preRotate(floatValue);
        }
        com.ksad.lottie.e.d e3 = this.f31311d.e();
        if (e3.a() != 1.0f || e3.b() != 1.0f) {
            this.f31308a.preScale(e3.a(), e3.b());
        }
        PointF e4 = this.f31309b.e();
        if (e4.x != 0.0f || e4.y != 0.0f) {
            this.f31308a.preTranslate(-e4.x, -e4.y);
        }
        return this.f31308a;
    }
}
