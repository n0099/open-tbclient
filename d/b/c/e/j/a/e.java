package d.b.c.e.j.a;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public f f42523a = new f();

    /* renamed from: b  reason: collision with root package name */
    public g f42524b = new g();

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d> f42525c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public d f42526d = null;

    public d a() {
        return this.f42526d;
    }

    public f b() {
        return this.f42523a;
    }

    public g c() {
        return this.f42524b;
    }

    public List<d> d() {
        return Collections.unmodifiableList(this.f42525c);
    }

    public void e(d dVar) {
        if (dVar != null) {
            this.f42525c.add(dVar);
        }
    }

    public void f(d dVar) {
        this.f42526d = dVar;
    }
}
