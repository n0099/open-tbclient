package d.a.j0.s2.b0.m;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public h f60180a = new h();

    /* renamed from: b  reason: collision with root package name */
    public i f60181b = new i();

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<e> f60182c = new LinkedList<>();

    public h a() {
        return this.f60180a;
    }

    public i b() {
        return this.f60181b;
    }

    public List<e> c() {
        return Collections.unmodifiableList(this.f60182c);
    }

    public void d(e eVar) {
        if (eVar != null) {
            this.f60182c.add(eVar);
        }
    }

    public void e(e eVar) {
    }
}
