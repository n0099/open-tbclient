package d.a.c.e.j.a;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public f f42283a = new f();

    /* renamed from: b  reason: collision with root package name */
    public g f42284b = new g();

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d> f42285c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public d f42286d = null;

    public d a() {
        return this.f42286d;
    }

    public f b() {
        return this.f42283a;
    }

    public g c() {
        return this.f42284b;
    }

    public List<d> d() {
        return Collections.unmodifiableList(this.f42285c);
    }

    public void e(d dVar) {
        if (dVar != null) {
            this.f42285c.add(dVar);
        }
    }

    public void f(d dVar) {
        this.f42286d = dVar;
    }
}
