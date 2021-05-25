package d.a.n0.t2.c0.m;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public h f61011a = new h();

    /* renamed from: b  reason: collision with root package name */
    public i f61012b = new i();

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<e> f61013c = new LinkedList<>();

    public h a() {
        return this.f61011a;
    }

    public i b() {
        return this.f61012b;
    }

    public List<e> c() {
        return Collections.unmodifiableList(this.f61013c);
    }

    public void d(e eVar) {
        if (eVar != null) {
            this.f61013c.add(eVar);
        }
    }

    public void e(e eVar) {
    }
}
