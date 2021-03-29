package d.b.q.h;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, d.b.q.h.a> f64471a = new HashMap();

    /* loaded from: classes2.dex */
    public interface a {
        List<d.b.q.h.a> a();
    }

    public b(a aVar) {
        for (d.b.q.h.a aVar2 : aVar.a()) {
            this.f64471a.put(aVar2.e(), aVar2);
        }
    }

    public d.b.q.h.a a(String str) {
        return this.f64471a.get(str);
    }

    public List<d.b.q.h.a> b() {
        return new ArrayList(this.f64471a.values());
    }
}
