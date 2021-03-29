package d.a.a.q.a;

import com.airbnb.lottie.model.content.ShapeTrimPath;
import d.a.a.q.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r implements b, a.InterfaceC0529a {

    /* renamed from: a  reason: collision with root package name */
    public final String f41283a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a.InterfaceC0529a> f41284b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTrimPath.Type f41285c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.q.b.a<?, Float> f41286d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.q.b.a<?, Float> f41287e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.a.q.b.a<?, Float> f41288f;

    public r(d.a.a.s.k.a aVar, ShapeTrimPath shapeTrimPath) {
        this.f41283a = shapeTrimPath.c();
        this.f41285c = shapeTrimPath.f();
        this.f41286d = shapeTrimPath.e().a();
        this.f41287e = shapeTrimPath.b().a();
        this.f41288f = shapeTrimPath.d().a();
        aVar.h(this.f41286d);
        aVar.h(this.f41287e);
        aVar.h(this.f41288f);
        this.f41286d.a(this);
        this.f41287e.a(this);
        this.f41288f.a(this);
    }

    @Override // d.a.a.q.b.a.InterfaceC0529a
    public void a() {
        for (int i = 0; i < this.f41284b.size(); i++) {
            this.f41284b.get(i).a();
        }
    }

    @Override // d.a.a.q.a.b
    public void b(List<b> list, List<b> list2) {
    }

    public void d(a.InterfaceC0529a interfaceC0529a) {
        this.f41284b.add(interfaceC0529a);
    }

    public d.a.a.q.b.a<?, Float> e() {
        return this.f41287e;
    }

    public d.a.a.q.b.a<?, Float> f() {
        return this.f41288f;
    }

    @Override // d.a.a.q.a.b
    public String getName() {
        return this.f41283a;
    }

    public d.a.a.q.b.a<?, Float> h() {
        return this.f41286d;
    }

    public ShapeTrimPath.Type i() {
        return this.f41285c;
    }
}
