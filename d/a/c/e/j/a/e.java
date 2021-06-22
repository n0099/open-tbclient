package d.a.c.e.j.a;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public f f42386a = new f();

    /* renamed from: b  reason: collision with root package name */
    public g f42387b = new g();

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d> f42388c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public d f42389d = null;

    public d a() {
        return this.f42389d;
    }

    public f b() {
        return this.f42386a;
    }

    public g c() {
        return this.f42387b;
    }

    public List<d> d() {
        return Collections.unmodifiableList(this.f42388c);
    }

    public void e(d dVar) {
        if (dVar != null) {
            this.f42388c.add(dVar);
        }
    }

    public void f(d dVar) {
        this.f42389d = dVar;
    }
}
