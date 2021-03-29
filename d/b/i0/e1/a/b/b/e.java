package d.b.i0.e1.a.b.b;

import java.util.HashMap;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, a> f54281a = new HashMap<>();

    public void a(String str, a aVar) {
        this.f54281a.put(str, aVar);
    }

    public boolean b(String str) {
        a aVar;
        HashMap<String, a> hashMap = this.f54281a;
        return (hashMap == null || (aVar = hashMap.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.b()) >= 300000) ? false : true;
    }

    public d.b.h0.s.f.b c(String str) {
        if (this.f54281a.get(str) != null) {
            return this.f54281a.get(str).a();
        }
        return null;
    }
}
