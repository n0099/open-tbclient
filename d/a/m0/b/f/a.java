package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class a {
    public static void d(List<d.a.c.j.e.n> list) {
        if (list == null) {
            return;
        }
        HashMap hashMap = new HashMap(d.a.m0.b.d.c());
        for (d.a.c.j.e.n nVar : list) {
            if (nVar instanceof d.a.m0.r.q.a) {
                d.a.m0.r.q.a aVar = (d.a.m0.r.q.a) nVar;
                for (Map.Entry entry : hashMap.entrySet()) {
                    aVar.e((BdUniqueId) entry.getKey(), (d.a.m0.b.e) entry.getValue());
                }
            }
        }
    }

    public static void e(l... lVarArr) {
        if (lVarArr == null) {
            return;
        }
        HashMap hashMap = new HashMap(d.a.m0.b.d.c());
        for (l lVar : lVarArr) {
            if (lVar != null) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    lVar.e((BdUniqueId) entry.getKey(), (d.a.m0.b.e) entry.getValue());
                }
            }
        }
    }

    public abstract ArrayList<String> a();

    public abstract d.a.m0.b.e b();

    public abstract BdUniqueId c();

    public abstract void f(d.a.m0.b.e eVar);
}
