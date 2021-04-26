package d.a.c.e.j.a;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public f f39721a = new f();

    /* renamed from: b  reason: collision with root package name */
    public g f39722b = new g();

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d> f39723c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public d f39724d = null;

    public d a() {
        return this.f39724d;
    }

    public f b() {
        return this.f39721a;
    }

    public g c() {
        return this.f39722b;
    }

    public List<d> d() {
        return Collections.unmodifiableList(this.f39723c);
    }

    public void e(d dVar) {
        if (dVar != null) {
            this.f39723c.add(dVar);
        }
    }

    public void f(d dVar) {
        this.f39724d = dVar;
    }
}
