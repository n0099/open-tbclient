package d.b.i0.m;

import d.b.b.e.p.k;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, b> f56795a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Integer> f56796b;

    /* renamed from: c  reason: collision with root package name */
    public c f56797c;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.f56796b = arrayList;
        this.f56797c = cVar;
    }

    public int a(String str, int i) {
        ArrayList<Integer> arrayList;
        if (this.f56795a == null || k.isEmpty(str) || (arrayList = this.f56796b) == null || !arrayList.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.f56795a.containsKey(str)) {
            b(str);
        }
        b bVar = this.f56795a.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.a(i);
    }

    public void b(String str) {
        if (this.f56795a == null || k.isEmpty(str) || this.f56797c == null) {
            return;
        }
        if (this.f56795a.containsKey(str)) {
            b bVar = this.f56795a.get(str);
            this.f56797c.b(this.f56796b, bVar);
            this.f56795a.put(str, bVar);
            return;
        }
        b bVar2 = new b();
        this.f56797c.b(this.f56796b, bVar2);
        this.f56795a.put(str, bVar2);
    }
}
