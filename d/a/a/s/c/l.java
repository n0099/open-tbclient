package d.a.a.s.c;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes.dex */
public class l extends a<d.a.a.u.j.h, Path> {
    public final d.a.a.u.j.h i;
    public final Path j;

    public l(List<d.a.a.y.a<d.a.a.u.j.h>> list) {
        super(list);
        this.i = new d.a.a.u.j.h();
        this.j = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.s.c.a
    /* renamed from: o */
    public Path i(d.a.a.y.a<d.a.a.u.j.h> aVar, float f2) {
        this.i.c(aVar.f41896b, aVar.f41897c, f2);
        d.a.a.x.g.i(this.i, this.j);
        return this.j;
    }
}
