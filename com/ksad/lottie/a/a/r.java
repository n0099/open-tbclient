package com.ksad.lottie.a.a;

import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class r implements b, a.InterfaceC0351a {

    /* renamed from: a  reason: collision with root package name */
    public final String f31281a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a.InterfaceC0351a> f31282b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTrimPath.Type f31283c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31284d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31285e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31286f;

    public r(com.ksad.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.f31281a = shapeTrimPath.a();
        this.f31283c = shapeTrimPath.b();
        this.f31284d = shapeTrimPath.d().a();
        this.f31285e = shapeTrimPath.c().a();
        this.f31286f = shapeTrimPath.e().a();
        aVar.a(this.f31284d);
        aVar.a(this.f31285e);
        aVar.a(this.f31286f);
        this.f31284d.a(this);
        this.f31285e.a(this);
        this.f31286f.a(this);
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0351a
    public void a() {
        for (int i = 0; i < this.f31282b.size(); i++) {
            this.f31282b.get(i).a();
        }
    }

    public void a(a.InterfaceC0351a interfaceC0351a) {
        this.f31282b.add(interfaceC0351a);
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
    }

    public ShapeTrimPath.Type b() {
        return this.f31283c;
    }

    public com.ksad.lottie.a.b.a<?, Float> c() {
        return this.f31284d;
    }

    public com.ksad.lottie.a.b.a<?, Float> d() {
        return this.f31285e;
    }

    public com.ksad.lottie.a.b.a<?, Float> e() {
        return this.f31286f;
    }
}
