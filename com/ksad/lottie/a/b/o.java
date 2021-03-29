package com.ksad.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
/* loaded from: classes6.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f31309a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public final a<PointF, PointF> f31310b;

    /* renamed from: c  reason: collision with root package name */
    public final a<?, PointF> f31311c;

    /* renamed from: d  reason: collision with root package name */
    public final a<com.ksad.lottie.e.d, com.ksad.lottie.e.d> f31312d;

    /* renamed from: e  reason: collision with root package name */
    public final a<Float, Float> f31313e;

    /* renamed from: f  reason: collision with root package name */
    public final a<Integer, Integer> f31314f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final a<?, Float> f31315g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final a<?, Float> f31316h;

    public o(com.ksad.lottie.model.a.l lVar) {
        this.f31310b = lVar.a().a();
        this.f31311c = lVar.b().a();
        this.f31312d = lVar.c().a();
        this.f31313e = lVar.d().a();
        this.f31314f = lVar.e().a();
        if (lVar.f() != null) {
            this.f31315g = lVar.f().a();
        } else {
            this.f31315g = null;
        }
        if (lVar.g() != null) {
            this.f31316h = lVar.g().a();
        } else {
            this.f31316h = null;
        }
    }

    public a<?, Integer> a() {
        return this.f31314f;
    }

    public void a(float f2) {
        this.f31310b.a(f2);
        this.f31311c.a(f2);
        this.f31312d.a(f2);
        this.f31313e.a(f2);
        this.f31314f.a(f2);
        a<?, Float> aVar = this.f31315g;
        if (aVar != null) {
            aVar.a(f2);
        }
        a<?, Float> aVar2 = this.f31316h;
        if (aVar2 != null) {
            aVar2.a(f2);
        }
    }

    public void a(a.InterfaceC0352a interfaceC0352a) {
        this.f31310b.a(interfaceC0352a);
        this.f31311c.a(interfaceC0352a);
        this.f31312d.a(interfaceC0352a);
        this.f31313e.a(interfaceC0352a);
        this.f31314f.a(interfaceC0352a);
        a<?, Float> aVar = this.f31315g;
        if (aVar != null) {
            aVar.a(interfaceC0352a);
        }
        a<?, Float> aVar2 = this.f31316h;
        if (aVar2 != null) {
            aVar2.a(interfaceC0352a);
        }
    }

    public void a(com.ksad.lottie.model.layer.a aVar) {
        aVar.a(this.f31310b);
        aVar.a(this.f31311c);
        aVar.a(this.f31312d);
        aVar.a(this.f31313e);
        aVar.a(this.f31314f);
        a<?, Float> aVar2 = this.f31315g;
        if (aVar2 != null) {
            aVar.a(aVar2);
        }
        a<?, Float> aVar3 = this.f31316h;
        if (aVar3 != null) {
            aVar.a(aVar3);
        }
    }

    public Matrix b(float f2) {
        PointF e2 = this.f31311c.e();
        PointF e3 = this.f31310b.e();
        com.ksad.lottie.e.d e4 = this.f31312d.e();
        float floatValue = this.f31313e.e().floatValue();
        this.f31309a.reset();
        this.f31309a.preTranslate(e2.x * f2, e2.y * f2);
        double d2 = f2;
        this.f31309a.preScale((float) Math.pow(e4.a(), d2), (float) Math.pow(e4.b(), d2));
        this.f31309a.preRotate(floatValue * f2, e3.x, e3.y);
        return this.f31309a;
    }

    @Nullable
    public a<?, Float> b() {
        return this.f31315g;
    }

    @Nullable
    public a<?, Float> c() {
        return this.f31316h;
    }

    public Matrix d() {
        this.f31309a.reset();
        PointF e2 = this.f31311c.e();
        if (e2.x != 0.0f || e2.y != 0.0f) {
            this.f31309a.preTranslate(e2.x, e2.y);
        }
        float floatValue = this.f31313e.e().floatValue();
        if (floatValue != 0.0f) {
            this.f31309a.preRotate(floatValue);
        }
        com.ksad.lottie.e.d e3 = this.f31312d.e();
        if (e3.a() != 1.0f || e3.b() != 1.0f) {
            this.f31309a.preScale(e3.a(), e3.b());
        }
        PointF e4 = this.f31310b.e();
        if (e4.x != 0.0f || e4.y != 0.0f) {
            this.f31309a.preTranslate(-e4.x, -e4.y);
        }
        return this.f31309a;
    }
}
