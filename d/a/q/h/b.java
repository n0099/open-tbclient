package d.a.q.h;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, d.a.q.h.a> f67935a = new HashMap();

    /* loaded from: classes2.dex */
    public interface a {
        List<d.a.q.h.a> a();
    }

    public b(a aVar) {
        for (d.a.q.h.a aVar2 : aVar.a()) {
            this.f67935a.put(aVar2.e(), aVar2);
        }
    }

    public d.a.q.h.a a(String str) {
        return this.f67935a.get(str);
    }

    public List<d.a.q.h.a> b() {
        return new ArrayList(this.f67935a.values());
    }
}
