package d.a.k0.q2;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static c f59824b;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, d.a.k0.q2.d.a> f59825a = new ConcurrentHashMap<>();

    public static c a() {
        if (f59824b == null) {
            synchronized (c.class) {
                if (f59824b == null) {
                    f59824b = new c();
                }
            }
        }
        return f59824b;
    }

    public ConcurrentHashMap<String, d.a.k0.q2.d.a> b() {
        return this.f59825a;
    }

    public d.a.k0.q2.d.a c(String str) {
        ConcurrentHashMap<String, d.a.k0.q2.d.a> concurrentHashMap = this.f59825a;
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    public void d(String str) {
        ConcurrentHashMap<String, d.a.k0.q2.d.a> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.f59825a) == null) {
            return;
        }
        Iterator<String> it = concurrentHashMap.keySet().iterator();
        while (it.hasNext()) {
            d.a.k0.q2.d.a aVar = this.f59825a.get(it.next());
            if (aVar != null && str.equals(aVar.f59827b)) {
                it.remove();
            }
        }
    }

    public void e(boolean z) {
        ConcurrentHashMap<String, d.a.k0.q2.d.a> concurrentHashMap = this.f59825a;
        if (concurrentHashMap == null) {
            return;
        }
        for (String str : concurrentHashMap.keySet()) {
            d.a.k0.q2.d.a aVar = this.f59825a.get(str);
            if (aVar != null) {
                aVar.f59830e = z;
            }
        }
    }

    public void f(boolean z, String str) {
        ConcurrentHashMap<String, d.a.k0.q2.d.a> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.f59825a) == null) {
            return;
        }
        for (String str2 : concurrentHashMap.keySet()) {
            d.a.k0.q2.d.a aVar = this.f59825a.get(str2);
            if (aVar != null && str.equals(aVar.f59827b)) {
                aVar.f59830e = z;
            }
        }
    }

    public void g(HashMap<String, d.a.k0.q2.d.a> hashMap) {
        this.f59825a.clear();
        if (hashMap == null) {
            return;
        }
        this.f59825a.putAll(hashMap);
    }

    public void h(String str, HashMap<String, d.a.k0.q2.d.a> hashMap) {
        if (this.f59825a == null) {
            this.f59825a = new ConcurrentHashMap<>();
        }
        d(str);
        this.f59825a.putAll(hashMap);
    }
}
