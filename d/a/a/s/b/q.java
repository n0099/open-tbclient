package d.a.a.s.b;

import android.graphics.Path;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import d.a.a.s.c.a;
import java.util.List;
/* loaded from: classes.dex */
public class q implements m, a.b {

    /* renamed from: b  reason: collision with root package name */
    public final String f41582b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f41583c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.f f41584d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.s.c.a<?, Path> f41585e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f41586f;

    /* renamed from: a  reason: collision with root package name */
    public final Path f41581a = new Path();

    /* renamed from: g  reason: collision with root package name */
    public b f41587g = new b();

    public q(d.a.a.f fVar, d.a.a.u.k.a aVar, d.a.a.u.j.k kVar) {
        this.f41582b = kVar.b();
        this.f41583c = kVar.d();
        this.f41584d = fVar;
        d.a.a.s.c.a<d.a.a.u.j.h, Path> a2 = kVar.c().a();
        this.f41585e = a2;
        aVar.i(a2);
        this.f41585e.a(this);
    }

    @Override // d.a.a.s.c.a.b
    public void a() {
        c();
    }

    @Override // d.a.a.s.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i = 0; i < list.size(); i++) {
            c cVar = list.get(i);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.i() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f41587g.a(sVar);
                    sVar.c(this);
                }
            }
        }
    }

    public final void c() {
        this.f41586f = false;
        this.f41584d.invalidateSelf();
    }

    @Override // d.a.a.s.b.c
    public String getName() {
        return this.f41582b;
    }

    @Override // d.a.a.s.b.m
    public Path getPath() {
        if (this.f41586f) {
            return this.f41581a;
        }
        this.f41581a.reset();
        if (this.f41583c) {
            this.f41586f = true;
            return this.f41581a;
        }
        this.f41581a.set(this.f41585e.h());
        this.f41581a.setFillType(Path.FillType.EVEN_ODD);
        this.f41587g.b(this.f41581a);
        this.f41586f = true;
        return this.f41581a;
    }
}
