package d.a.j.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, d.a.j.b.a> f48454a = new HashMap();

    /* loaded from: classes.dex */
    public interface a {
        List<d.a.j.b.a> a();
    }

    public b(a aVar) {
        for (d.a.j.b.a aVar2 : aVar.a()) {
            this.f48454a.put(aVar2.c(), aVar2);
        }
    }

    public d.a.j.b.a a(String str) {
        return this.f48454a.get(str);
    }

    public List<d.a.j.b.a> b() {
        return new ArrayList(this.f48454a.values());
    }
}
