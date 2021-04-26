package d.a.j0.q2;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static c f59079b;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, d.a.j0.q2.d.a> f59080a = new ConcurrentHashMap<>();

    public static c a() {
        if (f59079b == null) {
            synchronized (c.class) {
                if (f59079b == null) {
                    f59079b = new c();
                }
            }
        }
        return f59079b;
    }

    public ConcurrentHashMap<String, d.a.j0.q2.d.a> b() {
        return this.f59080a;
    }

    public d.a.j0.q2.d.a c(String str) {
        ConcurrentHashMap<String, d.a.j0.q2.d.a> concurrentHashMap = this.f59080a;
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    public void d(String str) {
        ConcurrentHashMap<String, d.a.j0.q2.d.a> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.f59080a) == null) {
            return;
        }
        Iterator<String> it = concurrentHashMap.keySet().iterator();
        while (it.hasNext()) {
            d.a.j0.q2.d.a aVar = this.f59080a.get(it.next());
            if (aVar != null && str.equals(aVar.f59082b)) {
                it.remove();
            }
        }
    }

    public void e(boolean z) {
        ConcurrentHashMap<String, d.a.j0.q2.d.a> concurrentHashMap = this.f59080a;
        if (concurrentHashMap == null) {
            return;
        }
        for (String str : concurrentHashMap.keySet()) {
            d.a.j0.q2.d.a aVar = this.f59080a.get(str);
            if (aVar != null) {
                aVar.f59085e = z;
            }
        }
    }

    public void f(boolean z, String str) {
        ConcurrentHashMap<String, d.a.j0.q2.d.a> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.f59080a) == null) {
            return;
        }
        for (String str2 : concurrentHashMap.keySet()) {
            d.a.j0.q2.d.a aVar = this.f59080a.get(str2);
            if (aVar != null && str.equals(aVar.f59082b)) {
                aVar.f59085e = z;
            }
        }
    }

    public void g(HashMap<String, d.a.j0.q2.d.a> hashMap) {
        this.f59080a.clear();
        if (hashMap == null) {
            return;
        }
        this.f59080a.putAll(hashMap);
    }

    public void h(String str, HashMap<String, d.a.j0.q2.d.a> hashMap) {
        if (this.f59080a == null) {
            this.f59080a = new ConcurrentHashMap<>();
        }
        d(str);
        this.f59080a.putAll(hashMap);
    }
}
