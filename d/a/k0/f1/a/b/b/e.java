package d.a.k0.f1.a.b.b;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, a> f54725a = new HashMap<>();

    public void a(String str, a aVar) {
        this.f54725a.put(str, aVar);
    }

    public boolean b(String str) {
        a aVar;
        HashMap<String, a> hashMap = this.f54725a;
        return (hashMap == null || (aVar = hashMap.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.b()) >= 300000) ? false : true;
    }

    public d.a.j0.s.f.b c(String str) {
        if (this.f54725a.get(str) != null) {
            return this.f54725a.get(str).a();
        }
        return null;
    }
}
