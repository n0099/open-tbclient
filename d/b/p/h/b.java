package d.b.p.h;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, d.b.p.h.a> f65165a = new HashMap();

    /* loaded from: classes2.dex */
    public interface a {
        List<d.b.p.h.a> a();
    }

    public b(a aVar) {
        for (d.b.p.h.a aVar2 : aVar.a()) {
            this.f65165a.put(aVar2.e(), aVar2);
        }
    }

    public d.b.p.h.a a(String str) {
        return this.f65165a.get(str);
    }

    public List<d.b.p.h.a> b() {
        return new ArrayList(this.f65165a.values());
    }
}
