package d.a.a.u.j;

import androidx.annotation.Nullable;
import d.a.a.s.b.p;
import d.a.a.u.i.l;
/* loaded from: classes.dex */
public class g implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f41792a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.a.u.i.b f41793b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.u.i.b f41794c;

    /* renamed from: d  reason: collision with root package name */
    public final l f41795d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f41796e;

    public g(String str, d.a.a.u.i.b bVar, d.a.a.u.i.b bVar2, l lVar, boolean z) {
        this.f41792a = str;
        this.f41793b = bVar;
        this.f41794c = bVar2;
        this.f41795d = lVar;
        this.f41796e = z;
    }

    @Override // d.a.a.u.j.b
    @Nullable
    public d.a.a.s.b.c a(d.a.a.f fVar, d.a.a.u.k.a aVar) {
        return new p(fVar, aVar, this);
    }

    public d.a.a.u.i.b b() {
        return this.f41793b;
    }

    public String c() {
        return this.f41792a;
    }

    public d.a.a.u.i.b d() {
        return this.f41794c;
    }

    public l e() {
        return this.f41795d;
    }

    public boolean f() {
        return this.f41796e;
    }
}
