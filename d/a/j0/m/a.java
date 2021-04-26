package d.a.j0.m;

import d.a.c.e.p.k;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, b> f56582a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Integer> f56583b;

    /* renamed from: c  reason: collision with root package name */
    public c f56584c;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.f56583b = arrayList;
        this.f56584c = cVar;
    }

    public int a(String str, int i2) {
        ArrayList<Integer> arrayList;
        if (this.f56582a == null || k.isEmpty(str) || (arrayList = this.f56583b) == null || !arrayList.contains(Integer.valueOf(i2))) {
            return 0;
        }
        if (!this.f56582a.containsKey(str)) {
            b(str);
        }
        b bVar = this.f56582a.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.a(i2);
    }

    public void b(String str) {
        if (this.f56582a == null || k.isEmpty(str) || this.f56584c == null) {
            return;
        }
        if (this.f56582a.containsKey(str)) {
            b bVar = this.f56582a.get(str);
            this.f56584c.b(this.f56583b, bVar);
            this.f56582a.put(str, bVar);
            return;
        }
        b bVar2 = new b();
        this.f56584c.b(this.f56583b, bVar2);
        this.f56582a.put(str, bVar2);
    }
}
