package d.a.q.e;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, d.a.q.e.a> f64228a = new HashMap();

    /* loaded from: classes2.dex */
    public interface a {
        List<d.a.q.e.a> a();
    }

    public b(a aVar) {
        for (d.a.q.e.a aVar2 : aVar.a()) {
            this.f64228a.put(aVar2.c(), aVar2);
        }
    }

    public List<d.a.q.e.a> a() {
        return new ArrayList(this.f64228a.values());
    }
}
