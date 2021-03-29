package d.a.a.q.a;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import d.a.a.q.b.a;
import java.util.List;
/* loaded from: classes.dex */
public class p implements l, a.InterfaceC0529a {

    /* renamed from: a  reason: collision with root package name */
    public final Path f41277a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final String f41278b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.f f41279c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.q.b.a<?, Path> f41280d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f41281e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public r f41282f;

    public p(d.a.a.f fVar, d.a.a.s.k.a aVar, d.a.a.s.j.k kVar) {
        this.f41278b = kVar.b();
        this.f41279c = fVar;
        d.a.a.q.b.a<d.a.a.s.j.h, Path> a2 = kVar.c().a();
        this.f41280d = a2;
        aVar.h(a2);
        this.f41280d.a(this);
    }

    @Override // d.a.a.q.b.a.InterfaceC0529a
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
                    this.f41282f = rVar;
                    rVar.d(this);
                }
            }
        }
    }

    public final void d() {
        this.f41281e = false;
        this.f41279c.invalidateSelf();
    }

    @Override // d.a.a.q.a.b
    public String getName() {
        return this.f41278b;
    }

    @Override // d.a.a.q.a.l
    public Path getPath() {
        if (this.f41281e) {
            return this.f41277a;
        }
        this.f41277a.reset();
        this.f41277a.set(this.f41280d.h());
        this.f41277a.setFillType(Path.FillType.EVEN_ODD);
        d.a.a.v.f.b(this.f41277a, this.f41282f);
        this.f41281e = true;
        return this.f41277a;
    }
}
