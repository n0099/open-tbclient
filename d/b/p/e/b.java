package d.b.p.e;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, d.b.p.e.a> f65010a = new HashMap();

    /* loaded from: classes2.dex */
    public interface a {
        List<d.b.p.e.a> a();
    }

    public b(a aVar) {
        for (d.b.p.e.a aVar2 : aVar.a()) {
            this.f65010a.put(aVar2.c(), aVar2);
        }
    }

    public List<d.b.p.e.a> a() {
        return new ArrayList(this.f65010a.values());
    }
}
