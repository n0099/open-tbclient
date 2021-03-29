package d.b.i0.r2.x.m;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public h f59974a = new h();

    /* renamed from: b  reason: collision with root package name */
    public i f59975b = new i();

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<e> f59976c = new LinkedList<>();

    public h a() {
        return this.f59974a;
    }

    public i b() {
        return this.f59975b;
    }

    public List<e> c() {
        return Collections.unmodifiableList(this.f59976c);
    }

    public void d(e eVar) {
        if (eVar != null) {
            this.f59976c.add(eVar);
        }
    }

    public void e(e eVar) {
    }
}
