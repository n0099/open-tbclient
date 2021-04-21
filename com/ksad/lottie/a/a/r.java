package com.ksad.lottie.a.a;

import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class r implements b, a.InterfaceC0369a {

    /* renamed from: a  reason: collision with root package name */
    public final String f31666a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a.InterfaceC0369a> f31667b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTrimPath.Type f31668c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31669d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31670e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31671f;

    public r(com.ksad.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.f31666a = shapeTrimPath.a();
        this.f31668c = shapeTrimPath.b();
        this.f31669d = shapeTrimPath.d().a();
        this.f31670e = shapeTrimPath.c().a();
        this.f31671f = shapeTrimPath.e().a();
        aVar.a(this.f31669d);
        aVar.a(this.f31670e);
        aVar.a(this.f31671f);
        this.f31669d.a(this);
        this.f31670e.a(this);
        this.f31671f.a(this);
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0369a
    public void a() {
        for (int i = 0; i < this.f31667b.size(); i++) {
            this.f31667b.get(i).a();
        }
    }

    public void a(a.InterfaceC0369a interfaceC0369a) {
        this.f31667b.add(interfaceC0369a);
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
    }

    public ShapeTrimPath.Type b() {
        return this.f31668c;
    }

    public com.ksad.lottie.a.b.a<?, Float> c() {
        return this.f31669d;
    }

    public com.ksad.lottie.a.b.a<?, Float> d() {
        return this.f31670e;
    }

    public com.ksad.lottie.a.b.a<?, Float> e() {
        return this.f31671f;
    }
}
