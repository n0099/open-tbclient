package d.a.n0.o;

import d.a.c.e.p.k;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, b> f57748a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Integer> f57749b;

    /* renamed from: c  reason: collision with root package name */
    public c f57750c;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.f57749b = arrayList;
        this.f57750c = cVar;
    }

    public int a(String str, int i2) {
        ArrayList<Integer> arrayList;
        if (this.f57748a == null || k.isEmpty(str) || (arrayList = this.f57749b) == null || !arrayList.contains(Integer.valueOf(i2))) {
            return 0;
        }
        if (!this.f57748a.containsKey(str)) {
            b(str);
        }
        b bVar = this.f57748a.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.a(i2);
    }

    public void b(String str) {
        if (this.f57748a == null || k.isEmpty(str) || this.f57750c == null) {
            return;
        }
        if (this.f57748a.containsKey(str)) {
            b bVar = this.f57748a.get(str);
            this.f57750c.b(this.f57749b, bVar);
            this.f57748a.put(str, bVar);
            return;
        }
        b bVar2 = new b();
        this.f57750c.b(this.f57749b, bVar2);
        this.f57748a.put(str, bVar2);
    }
}
