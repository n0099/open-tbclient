package d.b.j.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, d.b.j.b.a> f64356a = new HashMap();

    /* loaded from: classes.dex */
    public interface a {
        List<d.b.j.b.a> a();
    }

    public b(a aVar) {
        for (d.b.j.b.a aVar2 : aVar.a()) {
            this.f64356a.put(aVar2.c(), aVar2);
        }
    }

    public d.b.j.b.a a(String str) {
        return this.f64356a.get(str);
    }

    public List<d.b.j.b.a> b() {
        return new ArrayList(this.f64356a.values());
    }
}
