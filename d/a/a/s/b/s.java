package d.a.a.s.b;

import com.airbnb.lottie.model.content.ShapeTrimPath;
import d.a.a.s.c.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s implements c, a.b {

    /* renamed from: a  reason: collision with root package name */
    public final String f41588a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f41589b;

    /* renamed from: c  reason: collision with root package name */
    public final List<a.b> f41590c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final ShapeTrimPath.Type f41591d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.s.c.a<?, Float> f41592e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.a.s.c.a<?, Float> f41593f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.a.s.c.a<?, Float> f41594g;

    public s(d.a.a.u.k.a aVar, ShapeTrimPath shapeTrimPath) {
        this.f41588a = shapeTrimPath.c();
        this.f41589b = shapeTrimPath.g();
        this.f41591d = shapeTrimPath.f();
        this.f41592e = shapeTrimPath.e().a();
        this.f41593f = shapeTrimPath.b().a();
        this.f41594g = shapeTrimPath.d().a();
        aVar.i(this.f41592e);
        aVar.i(this.f41593f);
        aVar.i(this.f41594g);
        this.f41592e.a(this);
        this.f41593f.a(this);
        this.f41594g.a(this);
    }

    @Override // d.a.a.s.c.a.b
    public void a() {
        for (int i = 0; i < this.f41590c.size(); i++) {
            this.f41590c.get(i).a();
        }
    }

    @Override // d.a.a.s.b.c
    public void b(List<c> list, List<c> list2) {
    }

    public void c(a.b bVar) {
        this.f41590c.add(bVar);
    }

    public d.a.a.s.c.a<?, Float> d() {
        return this.f41593f;
    }

    public d.a.a.s.c.a<?, Float> f() {
        return this.f41594g;
    }

    @Override // d.a.a.s.b.c
    public String getName() {
        return this.f41588a;
    }

    public d.a.a.s.c.a<?, Float> h() {
        return this.f41592e;
    }

    public ShapeTrimPath.Type i() {
        return this.f41591d;
    }

    public boolean j() {
        return this.f41589b;
    }
}
