package d.a.k0.s2.c0.m;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public h f60909a = new h();

    /* renamed from: b  reason: collision with root package name */
    public i f60910b = new i();

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<e> f60911c = new LinkedList<>();

    public h a() {
        return this.f60909a;
    }

    public i b() {
        return this.f60910b;
    }

    public List<e> c() {
        return Collections.unmodifiableList(this.f60911c);
    }

    public void d(e eVar) {
        if (eVar != null) {
            this.f60911c.add(eVar);
        }
    }

    public void e(e eVar) {
    }
}
