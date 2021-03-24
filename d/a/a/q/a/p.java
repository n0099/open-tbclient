package d.a.a.q.a;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import d.a.a.q.b.a;
import java.util.List;
/* loaded from: classes.dex */
public class p implements l, a.InterfaceC0528a {

    /* renamed from: a  reason: collision with root package name */
    public final Path f41276a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final String f41277b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.f f41278c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.q.b.a<?, Path> f41279d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f41280e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public r f41281f;

    public p(d.a.a.f fVar, d.a.a.s.k.a aVar, d.a.a.s.j.k kVar) {
        this.f41277b = kVar.b();
        this.f41278c = fVar;
        d.a.a.q.b.a<d.a.a.s.j.h, Path> a2 = kVar.c().a();
        this.f41279d = a2;
        aVar.h(a2);
        this.f41279d.a(this);
    }

    @Override // d.a.a.q.b.a.InterfaceC0528a
    public void a() {
        d();
    }

    @Override // d.a.a.q.a.b
    public void b(List<b> list, List<b> list2) {
        for (int i = 0; i < list.size(); i++) {
            b bVar = list.get(i);
            if (bVar instanceof r) {
                r rVar = (r) bVar;
                if (rVar.i() == ShapeTrimPath.Type.Simultaneously) {
                    this.f41281f = rVar;
                    rVar.d(this);
                }
            }
        }
    }

    public final void d() {
        this.f41280e = false;
        this.f41278c.invalidateSelf();
    }

    @Override // d.a.a.q.a.b
    public String getName() {
        return this.f41277b;
    }

    @Override // d.a.a.q.a.l
    public Path getPath() {
        if (this.f41280e) {
            return this.f41276a;
        }
        this.f41276a.reset();
        this.f41276a.set(this.f41279d.h());
        this.f41276a.setFillType(Path.FillType.EVEN_ODD);
        d.a.a.v.f.b(this.f41276a, this.f41281f);
        this.f41280e = true;
        return this.f41276a;
    }
}
