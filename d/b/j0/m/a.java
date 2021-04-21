package d.b.j0.m;

import d.b.c.e.p.k;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, b> f58573a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Integer> f58574b;

    /* renamed from: c  reason: collision with root package name */
    public c f58575c;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.f58574b = arrayList;
        this.f58575c = cVar;
    }

    public int a(String str, int i) {
        ArrayList<Integer> arrayList;
        if (this.f58573a == null || k.isEmpty(str) || (arrayList = this.f58574b) == null || !arrayList.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.f58573a.containsKey(str)) {
            b(str);
        }
        b bVar = this.f58573a.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.a(i);
    }

    public void b(String str) {
        if (this.f58573a == null || k.isEmpty(str) || this.f58575c == null) {
            return;
        }
        if (this.f58573a.containsKey(str)) {
            b bVar = this.f58573a.get(str);
            this.f58575c.b(this.f58574b, bVar);
            this.f58573a.put(str, bVar);
            return;
        }
        b bVar2 = new b();
        this.f58575c.b(this.f58574b, bVar2);
        this.f58573a.put(str, bVar2);
    }
}
