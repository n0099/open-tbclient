package d.a.a.s.b;

import android.graphics.Path;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import d.a.a.s.c.a;
import java.util.List;
/* loaded from: classes.dex */
public class q implements m, a.b {

    /* renamed from: b  reason: collision with root package name */
    public final String f41677b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f41678c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.f f41679d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.s.c.a<?, Path> f41680e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f41681f;

    /* renamed from: a  reason: collision with root package name */
    public final Path f41676a = new Path();

    /* renamed from: g  reason: collision with root package name */
    public b f41682g = new b();

    public q(d.a.a.f fVar, d.a.a.u.k.a aVar, d.a.a.u.j.k kVar) {
        this.f41677b = kVar.b();
        this.f41678c = kVar.d();
        this.f41679d = fVar;
        d.a.a.s.c.a<d.a.a.u.j.h, Path> a2 = kVar.c().a();
        this.f41680e = a2;
        aVar.i(a2);
        this.f41680e.a(this);
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
                    this.f41682g.a(sVar);
                    sVar.c(this);
                }
            }
        }
    }

    public final void c() {
        this.f41681f = false;
        this.f41679d.invalidateSelf();
    }

    @Override // d.a.a.s.b.c
    public String getName() {
        return this.f41677b;
    }

    @Override // d.a.a.s.b.m
    public Path getPath() {
        if (this.f41681f) {
            return this.f41676a;
        }
        this.f41676a.reset();
        if (this.f41678c) {
            this.f41681f = true;
            return this.f41676a;
        }
        this.f41676a.set(this.f41680e.h());
        this.f41676a.setFillType(Path.FillType.EVEN_ODD);
        this.f41682g.b(this.f41676a);
        this.f41681f = true;
        return this.f41676a;
    }
}
