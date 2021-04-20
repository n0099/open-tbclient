package d.a.a.u.j;

import androidx.annotation.Nullable;
import d.a.a.s.b.p;
import d.a.a.u.i.l;
/* loaded from: classes.dex */
public class g implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f41697a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.a.u.i.b f41698b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.u.i.b f41699c;

    /* renamed from: d  reason: collision with root package name */
    public final l f41700d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f41701e;

    public g(String str, d.a.a.u.i.b bVar, d.a.a.u.i.b bVar2, l lVar, boolean z) {
        this.f41697a = str;
        this.f41698b = bVar;
        this.f41699c = bVar2;
        this.f41700d = lVar;
        this.f41701e = z;
    }

    @Override // d.a.a.u.j.b
    @Nullable
    public d.a.a.s.b.c a(d.a.a.f fVar, d.a.a.u.k.a aVar) {
        return new p(fVar, aVar, this);
    }

    public d.a.a.u.i.b b() {
        return this.f41698b;
    }

    public String c() {
        return this.f41697a;
    }

    public d.a.a.u.i.b d() {
        return this.f41699c;
    }

    public l e() {
        return this.f41700d;
    }

    public boolean f() {
        return this.f41701e;
    }
}
