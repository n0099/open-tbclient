package com.ksad.lottie.a.a;

import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class r implements b, a.InterfaceC0355a {

    /* renamed from: a  reason: collision with root package name */
    public final String f31908a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a.InterfaceC0355a> f31909b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTrimPath.Type f31910c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31911d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31912e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31913f;

    public r(com.ksad.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.f31908a = shapeTrimPath.a();
        this.f31910c = shapeTrimPath.b();
        this.f31911d = shapeTrimPath.d().a();
        this.f31912e = shapeTrimPath.c().a();
        this.f31913f = shapeTrimPath.e().a();
        aVar.a(this.f31911d);
        aVar.a(this.f31912e);
        aVar.a(this.f31913f);
        this.f31911d.a(this);
        this.f31912e.a(this);
        this.f31913f.a(this);
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0355a
    public void a() {
        for (int i2 = 0; i2 < this.f31909b.size(); i2++) {
            this.f31909b.get(i2).a();
        }
    }

    public void a(a.InterfaceC0355a interfaceC0355a) {
        this.f31909b.add(interfaceC0355a);
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
    }

    public ShapeTrimPath.Type b() {
        return this.f31910c;
    }

    public com.ksad.lottie.a.b.a<?, Float> c() {
        return this.f31911d;
    }

    public com.ksad.lottie.a.b.a<?, Float> d() {
        return this.f31912e;
    }

    public com.ksad.lottie.a.b.a<?, Float> e() {
        return this.f31913f;
    }
}
