package d.a.o0.t2.c0.m;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public h f64828a = new h();

    /* renamed from: b  reason: collision with root package name */
    public i f64829b = new i();

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<e> f64830c = new LinkedList<>();

    public h a() {
        return this.f64828a;
    }

    public i b() {
        return this.f64829b;
    }

    public List<e> c() {
        return Collections.unmodifiableList(this.f64830c);
    }

    public void d(e eVar) {
        if (eVar != null) {
            this.f64830c.add(eVar);
        }
    }

    public void e(e eVar) {
    }
}
