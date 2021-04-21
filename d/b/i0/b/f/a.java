package d.b.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class a {
    public static void d(List<d.b.c.j.e.n> list) {
        if (list == null) {
            return;
        }
        HashMap hashMap = new HashMap(d.b.i0.b.d.c());
        for (d.b.c.j.e.n nVar : list) {
            if (nVar instanceof d.b.i0.r.q.a) {
                d.b.i0.r.q.a aVar = (d.b.i0.r.q.a) nVar;
                for (Map.Entry entry : hashMap.entrySet()) {
                    aVar.f((BdUniqueId) entry.getKey(), (d.b.i0.b.e) entry.getValue());
                }
            }
        }
    }

    public static void e(k... kVarArr) {
        if (kVarArr == null) {
            return;
        }
        HashMap hashMap = new HashMap(d.b.i0.b.d.c());
        for (k kVar : kVarArr) {
            if (kVar != null) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    kVar.f((BdUniqueId) entry.getKey(), (d.b.i0.b.e) entry.getValue());
                }
            }
        }
    }

    public abstract ArrayList<String> a();

    public abstract d.b.i0.b.e b();

    public abstract BdUniqueId c();

    public abstract void f(d.b.i0.b.e eVar);
}
