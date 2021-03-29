package d.a.a.s.j;

import androidx.annotation.Nullable;
import d.a.a.q.a.o;
import d.a.a.s.i.l;
/* loaded from: classes.dex */
public class g implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f41390a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.a.s.i.b f41391b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.s.i.b f41392c;

    /* renamed from: d  reason: collision with root package name */
    public final l f41393d;

    public g(String str, d.a.a.s.i.b bVar, d.a.a.s.i.b bVar2, l lVar) {
        this.f41390a = str;
        this.f41391b = bVar;
        this.f41392c = bVar2;
        this.f41393d = lVar;
    }

    @Override // d.a.a.s.j.b
    @Nullable
    public d.a.a.q.a.b a(d.a.a.f fVar, d.a.a.s.k.a aVar) {
        return new o(fVar, aVar, this);
    }

    public d.a.a.s.i.b b() {
        return this.f41391b;
    }

    public String c() {
        return this.f41390a;
    }

    public d.a.a.s.i.b d() {
        return this.f41392c;
    }

    public l e() {
        return this.f41393d;
    }
}
