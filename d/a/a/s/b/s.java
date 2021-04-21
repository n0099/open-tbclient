package d.a.a.s.b;

import com.airbnb.lottie.model.content.ShapeTrimPath;
import d.a.a.s.c.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s implements c, a.b {

    /* renamed from: a  reason: collision with root package name */
    public final String f41683a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f41684b;

    /* renamed from: c  reason: collision with root package name */
    public final List<a.b> f41685c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final ShapeTrimPath.Type f41686d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.s.c.a<?, Float> f41687e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.a.s.c.a<?, Float> f41688f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.a.s.c.a<?, Float> f41689g;

    public s(d.a.a.u.k.a aVar, ShapeTrimPath shapeTrimPath) {
        this.f41683a = shapeTrimPath.c();
        this.f41684b = shapeTrimPath.g();
        this.f41686d = shapeTrimPath.f();
        this.f41687e = shapeTrimPath.e().a();
        this.f41688f = shapeTrimPath.b().a();
        this.f41689g = shapeTrimPath.d().a();
        aVar.i(this.f41687e);
        aVar.i(this.f41688f);
        aVar.i(this.f41689g);
        this.f41687e.a(this);
        this.f41688f.a(this);
        this.f41689g.a(this);
    }

    @Override // d.a.a.s.c.a.b
    public void a() {
        for (int i = 0; i < this.f41685c.size(); i++) {
            this.f41685c.get(i).a();
        }
    }

    @Override // d.a.a.s.b.c
    public void b(List<c> list, List<c> list2) {
    }

    public void c(a.b bVar) {
        this.f41685c.add(bVar);
    }

    public d.a.a.s.c.a<?, Float> d() {
        return this.f41688f;
    }

    public d.a.a.s.c.a<?, Float> f() {
        return this.f41689g;
    }

    @Override // d.a.a.s.b.c
    public String getName() {
        return this.f41683a;
    }

    public d.a.a.s.c.a<?, Float> h() {
        return this.f41687e;
    }

    public ShapeTrimPath.Type i() {
        return this.f41686d;
    }

    public boolean j() {
        return this.f41684b;
    }
}
