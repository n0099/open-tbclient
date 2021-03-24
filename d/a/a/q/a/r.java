package d.a.a.q.a;

import com.airbnb.lottie.model.content.ShapeTrimPath;
import d.a.a.q.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r implements b, a.InterfaceC0528a {

    /* renamed from: a  reason: collision with root package name */
    public final String f41282a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a.InterfaceC0528a> f41283b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTrimPath.Type f41284c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.q.b.a<?, Float> f41285d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.q.b.a<?, Float> f41286e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.a.q.b.a<?, Float> f41287f;

    public r(d.a.a.s.k.a aVar, ShapeTrimPath shapeTrimPath) {
        this.f41282a = shapeTrimPath.c();
        this.f41284c = shapeTrimPath.f();
        this.f41285d = shapeTrimPath.e().a();
        this.f41286e = shapeTrimPath.b().a();
        this.f41287f = shapeTrimPath.d().a();
        aVar.h(this.f41285d);
        aVar.h(this.f41286e);
        aVar.h(this.f41287f);
        this.f41285d.a(this);
        this.f41286e.a(this);
        this.f41287f.a(this);
    }

    @Override // d.a.a.q.b.a.InterfaceC0528a
    public void a() {
        for (int i = 0; i < this.f41283b.size(); i++) {
            this.f41283b.get(i).a();
        }
    }

    @Override // d.a.a.q.a.b
    public void b(List<b> list, List<b> list2) {
    }

    public void d(a.InterfaceC0528a interfaceC0528a) {
        this.f41283b.add(interfaceC0528a);
    }

    public d.a.a.q.b.a<?, Float> e() {
        return this.f41286e;
    }

    public d.a.a.q.b.a<?, Float> f() {
        return this.f41287f;
    }

    @Override // d.a.a.q.a.b
    public String getName() {
        return this.f41282a;
    }

    public d.a.a.q.b.a<?, Float> h() {
        return this.f41285d;
    }

    public ShapeTrimPath.Type i() {
        return this.f41284c;
    }
}
