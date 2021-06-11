package d.a.n0.o;

import d.a.c.e.p.k;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, b> f61437a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Integer> f61438b;

    /* renamed from: c  reason: collision with root package name */
    public c f61439c;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.f61438b = arrayList;
        this.f61439c = cVar;
    }

    public int a(String str, int i2) {
        ArrayList<Integer> arrayList;
        if (this.f61437a == null || k.isEmpty(str) || (arrayList = this.f61438b) == null || !arrayList.contains(Integer.valueOf(i2))) {
            return 0;
        }
        if (!this.f61437a.containsKey(str)) {
            b(str);
        }
        b bVar = this.f61437a.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.a(i2);
    }

    public void b(String str) {
        if (this.f61437a == null || k.isEmpty(str) || this.f61439c == null) {
            return;
        }
        if (this.f61437a.containsKey(str)) {
            b bVar = this.f61437a.get(str);
            this.f61439c.b(this.f61438b, bVar);
            this.f61437a.put(str, bVar);
            return;
        }
        b bVar2 = new b();
        this.f61439c.b(this.f61438b, bVar2);
        this.f61437a.put(str, bVar2);
    }
}
