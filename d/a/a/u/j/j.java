package d.a.a.u.j;

import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class j implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f41711a;

    /* renamed from: b  reason: collision with root package name */
    public final List<b> f41712b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f41713c;

    public j(String str, List<b> list, boolean z) {
        this.f41711a = str;
        this.f41712b = list;
        this.f41713c = z;
    }

    @Override // d.a.a.u.j.b
    public d.a.a.s.b.c a(d.a.a.f fVar, d.a.a.u.k.a aVar) {
        return new d.a.a.s.b.d(fVar, aVar, this);
    }

    public List<b> b() {
        return this.f41712b;
    }

    public String c() {
        return this.f41711a;
    }

    public boolean d() {
        return this.f41713c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f41711a + "' Shapes: " + Arrays.toString(this.f41712b.toArray()) + '}';
    }
}
