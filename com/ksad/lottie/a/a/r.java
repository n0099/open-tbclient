package com.ksad.lottie.a.a;

import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class r implements b, a.InterfaceC0352a {

    /* renamed from: a  reason: collision with root package name */
    public final String f31810a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a.InterfaceC0352a> f31811b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTrimPath.Type f31812c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31813d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31814e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31815f;

    public r(com.ksad.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.f31810a = shapeTrimPath.a();
        this.f31812c = shapeTrimPath.b();
        this.f31813d = shapeTrimPath.d().a();
        this.f31814e = shapeTrimPath.c().a();
        this.f31815f = shapeTrimPath.e().a();
        aVar.a(this.f31813d);
        aVar.a(this.f31814e);
        aVar.a(this.f31815f);
        this.f31813d.a(this);
        this.f31814e.a(this);
        this.f31815f.a(this);
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0352a
    public void a() {
        for (int i2 = 0; i2 < this.f31811b.size(); i2++) {
            this.f31811b.get(i2).a();
        }
    }

    public void a(a.InterfaceC0352a interfaceC0352a) {
        this.f31811b.add(interfaceC0352a);
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
    }

    public ShapeTrimPath.Type b() {
        return this.f31812c;
    }

    public com.ksad.lottie.a.b.a<?, Float> c() {
        return this.f31813d;
    }

    public com.ksad.lottie.a.b.a<?, Float> d() {
        return this.f31814e;
    }

    public com.ksad.lottie.a.b.a<?, Float> e() {
        return this.f31815f;
    }
}
