package d.b.i0.s2.a0.m;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public h f61574a = new h();

    /* renamed from: b  reason: collision with root package name */
    public i f61575b = new i();

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<e> f61576c = new LinkedList<>();

    public h a() {
        return this.f61574a;
    }

    public i b() {
        return this.f61575b;
    }

    public List<e> c() {
        return Collections.unmodifiableList(this.f61576c);
    }

    public void d(e eVar) {
        if (eVar != null) {
            this.f61576c.add(eVar);
        }
    }

    public void e(e eVar) {
    }
}
