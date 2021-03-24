package d.b.b.e.j.a;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public f f41785a = new f();

    /* renamed from: b  reason: collision with root package name */
    public g f41786b = new g();

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d> f41787c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public d f41788d = null;

    public d a() {
        return this.f41788d;
    }

    public f b() {
        return this.f41785a;
    }

    public g c() {
        return this.f41786b;
    }

    public List<d> d() {
        return Collections.unmodifiableList(this.f41787c);
    }

    public void e(d dVar) {
        if (dVar != null) {
            this.f41787c.add(dVar);
        }
    }

    public void f(d dVar) {
        this.f41788d = dVar;
    }
}
