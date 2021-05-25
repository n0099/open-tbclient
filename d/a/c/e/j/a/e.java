package d.a.c.e.j.a;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public f f38630a = new f();

    /* renamed from: b  reason: collision with root package name */
    public g f38631b = new g();

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d> f38632c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public d f38633d = null;

    public d a() {
        return this.f38633d;
    }

    public f b() {
        return this.f38630a;
    }

    public g c() {
        return this.f38631b;
    }

    public List<d> d() {
        return Collections.unmodifiableList(this.f38632c);
    }

    public void e(d dVar) {
        if (dVar != null) {
            this.f38632c.add(dVar);
        }
    }

    public void f(d dVar) {
        this.f38633d = dVar;
    }
}
