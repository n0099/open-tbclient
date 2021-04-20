package com.ksad.lottie.a.a;

import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class r implements b, a.InterfaceC0366a {

    /* renamed from: a  reason: collision with root package name */
    public final String f31571a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a.InterfaceC0366a> f31572b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTrimPath.Type f31573c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31574d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31575e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31576f;

    public r(com.ksad.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.f31571a = shapeTrimPath.a();
        this.f31573c = shapeTrimPath.b();
        this.f31574d = shapeTrimPath.d().a();
        this.f31575e = shapeTrimPath.c().a();
        this.f31576f = shapeTrimPath.e().a();
        aVar.a(this.f31574d);
        aVar.a(this.f31575e);
        aVar.a(this.f31576f);
        this.f31574d.a(this);
        this.f31575e.a(this);
        this.f31576f.a(this);
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0366a
    public void a() {
        for (int i = 0; i < this.f31572b.size(); i++) {
            this.f31572b.get(i).a();
        }
    }

    public void a(a.InterfaceC0366a interfaceC0366a) {
        this.f31572b.add(interfaceC0366a);
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
    }

    public ShapeTrimPath.Type b() {
        return this.f31573c;
    }

    public com.ksad.lottie.a.b.a<?, Float> c() {
        return this.f31574d;
    }

    public com.ksad.lottie.a.b.a<?, Float> d() {
        return this.f31575e;
    }

    public com.ksad.lottie.a.b.a<?, Float> e() {
        return this.f31576f;
    }
}
