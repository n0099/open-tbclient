package d.a.a.q.b;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes.dex */
public class l extends a<d.a.a.s.j.h, Path> {

    /* renamed from: g  reason: collision with root package name */
    public final d.a.a.s.j.h f41302g;

    /* renamed from: h  reason: collision with root package name */
    public final Path f41303h;

    public l(List<d.a.a.w.a<d.a.a.s.j.h>> list) {
        super(list);
        this.f41302g = new d.a.a.s.j.h();
        this.f41303h = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.q.b.a
    /* renamed from: n */
    public Path i(d.a.a.w.a<d.a.a.s.j.h> aVar, float f2) {
        this.f41302g.c(aVar.f41451b, aVar.f41452c, f2);
        d.a.a.v.e.h(this.f41302g, this.f41303h);
        return this.f41303h;
    }
}
