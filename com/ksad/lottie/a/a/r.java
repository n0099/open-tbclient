package com.ksad.lottie.a.a;

import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class r implements b, a.InterfaceC1061a {

    /* renamed from: a  reason: collision with root package name */
    private final String f7955a;

    /* renamed from: b  reason: collision with root package name */
    private final List<a.InterfaceC1061a> f7956b = new ArrayList();
    private final ShapeTrimPath.Type c;
    private final com.ksad.lottie.a.b.a<?, Float> d;
    private final com.ksad.lottie.a.b.a<?, Float> e;
    private final com.ksad.lottie.a.b.a<?, Float> f;

    public r(com.ksad.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.f7955a = shapeTrimPath.a();
        this.c = shapeTrimPath.b();
        this.d = shapeTrimPath.d().a();
        this.e = shapeTrimPath.c().a();
        this.f = shapeTrimPath.e().a();
        aVar.a(this.d);
        aVar.a(this.e);
        aVar.a(this.f);
        this.d.a(this);
        this.e.a(this);
        this.f.a(this);
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC1061a
    public void a() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f7956b.size()) {
                return;
            }
            this.f7956b.get(i2).a();
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a.InterfaceC1061a interfaceC1061a) {
        this.f7956b.add(interfaceC1061a);
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type b() {
        return this.c;
    }

    public com.ksad.lottie.a.b.a<?, Float> c() {
        return this.d;
    }

    public com.ksad.lottie.a.b.a<?, Float> d() {
        return this.e;
    }

    public com.ksad.lottie.a.b.a<?, Float> e() {
        return this.f;
    }
}
