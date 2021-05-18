package d.a.k0.m;

import d.a.c.e.p.k;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, b> f57289a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Integer> f57290b;

    /* renamed from: c  reason: collision with root package name */
    public c f57291c;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.f57290b = arrayList;
        this.f57291c = cVar;
    }

    public int a(String str, int i2) {
        ArrayList<Integer> arrayList;
        if (this.f57289a == null || k.isEmpty(str) || (arrayList = this.f57290b) == null || !arrayList.contains(Integer.valueOf(i2))) {
            return 0;
        }
        if (!this.f57289a.containsKey(str)) {
            b(str);
        }
        b bVar = this.f57289a.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.a(i2);
    }

    public void b(String str) {
        if (this.f57289a == null || k.isEmpty(str) || this.f57291c == null) {
            return;
        }
        if (this.f57289a.containsKey(str)) {
            b bVar = this.f57289a.get(str);
            this.f57291c.b(this.f57290b, bVar);
            this.f57289a.put(str, bVar);
            return;
        }
        b bVar2 = new b();
        this.f57291c.b(this.f57290b, bVar2);
        this.f57289a.put(str, bVar2);
    }
}
