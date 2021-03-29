package d.a.a.s.j;

import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class j implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f41402a;

    /* renamed from: b  reason: collision with root package name */
    public final List<b> f41403b;

    public j(String str, List<b> list) {
        this.f41402a = str;
        this.f41403b = list;
    }

    @Override // d.a.a.s.j.b
    public d.a.a.q.a.b a(d.a.a.f fVar, d.a.a.s.k.a aVar) {
        return new d.a.a.q.a.c(fVar, aVar, this);
    }

    public List<b> b() {
        return this.f41403b;
    }

    public String c() {
        return this.f41402a;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f41402a + "' Shapes: " + Arrays.toString(this.f41403b.toArray()) + '}';
    }
}
