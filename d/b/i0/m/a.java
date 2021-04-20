package d.b.i0.m;

import d.b.c.e.p.k;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, b> f58152a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Integer> f58153b;

    /* renamed from: c  reason: collision with root package name */
    public c f58154c;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.f58153b = arrayList;
        this.f58154c = cVar;
    }

    public int a(String str, int i) {
        ArrayList<Integer> arrayList;
        if (this.f58152a == null || k.isEmpty(str) || (arrayList = this.f58153b) == null || !arrayList.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.f58152a.containsKey(str)) {
            b(str);
        }
        b bVar = this.f58152a.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.a(i);
    }

    public void b(String str) {
        if (this.f58152a == null || k.isEmpty(str) || this.f58154c == null) {
            return;
        }
        if (this.f58152a.containsKey(str)) {
            b bVar = this.f58152a.get(str);
            this.f58154c.b(this.f58153b, bVar);
            this.f58152a.put(str, bVar);
            return;
        }
        b bVar2 = new b();
        this.f58154c.b(this.f58153b, bVar2);
        this.f58152a.put(str, bVar2);
    }
}
