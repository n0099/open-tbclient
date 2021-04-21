package d.b.j0.s2.a0.m;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public h f61995a = new h();

    /* renamed from: b  reason: collision with root package name */
    public i f61996b = new i();

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<e> f61997c = new LinkedList<>();

    public h a() {
        return this.f61995a;
    }

    public i b() {
        return this.f61996b;
    }

    public List<e> c() {
        return Collections.unmodifiableList(this.f61997c);
    }

    public void d(e eVar) {
        if (eVar != null) {
            this.f61997c.add(eVar);
        }
    }

    public void e(e eVar) {
    }
}
