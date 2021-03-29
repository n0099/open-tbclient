package com.ksad.lottie.a.a;

import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class r implements b, a.InterfaceC0352a {

    /* renamed from: a  reason: collision with root package name */
    public final String f31282a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a.InterfaceC0352a> f31283b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTrimPath.Type f31284c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31285d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31286e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31287f;

    public r(com.ksad.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.f31282a = shapeTrimPath.a();
        this.f31284c = shapeTrimPath.b();
        this.f31285d = shapeTrimPath.d().a();
        this.f31286e = shapeTrimPath.c().a();
        this.f31287f = shapeTrimPath.e().a();
        aVar.a(this.f31285d);
        aVar.a(this.f31286e);
        aVar.a(this.f31287f);
        this.f31285d.a(this);
        this.f31286e.a(this);
        this.f31287f.a(this);
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0352a
    public void a() {
        for (int i = 0; i < this.f31283b.size(); i++) {
            this.f31283b.get(i).a();
        }
    }

    public void a(a.InterfaceC0352a interfaceC0352a) {
        this.f31283b.add(interfaceC0352a);
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
    }

    public ShapeTrimPath.Type b() {
        return this.f31284c;
    }

    public com.ksad.lottie.a.b.a<?, Float> c() {
        return this.f31285d;
    }

    public com.ksad.lottie.a.b.a<?, Float> d() {
        return this.f31286e;
    }

    public com.ksad.lottie.a.b.a<?, Float> e() {
        return this.f31287f;
    }
}
