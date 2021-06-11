package d.a.n0.t2.c0.m;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public h f64703a = new h();

    /* renamed from: b  reason: collision with root package name */
    public i f64704b = new i();

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<e> f64705c = new LinkedList<>();

    public h a() {
        return this.f64703a;
    }

    public i b() {
        return this.f64704b;
    }

    public List<e> c() {
        return Collections.unmodifiableList(this.f64705c);
    }

    public void d(e eVar) {
        if (eVar != null) {
            this.f64705c.add(eVar);
        }
    }

    public void e(e eVar) {
    }
}
