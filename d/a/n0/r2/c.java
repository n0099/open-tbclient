package d.a.n0.r2;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static c f63656b;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, d.a.n0.r2.d.a> f63657a = new ConcurrentHashMap<>();

    public static c a() {
        if (f63656b == null) {
            synchronized (c.class) {
                if (f63656b == null) {
                    f63656b = new c();
                }
            }
        }
        return f63656b;
    }

    public ConcurrentHashMap<String, d.a.n0.r2.d.a> b() {
        return this.f63657a;
    }

    public d.a.n0.r2.d.a c(String str) {
        ConcurrentHashMap<String, d.a.n0.r2.d.a> concurrentHashMap = this.f63657a;
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    public void d(String str) {
        ConcurrentHashMap<String, d.a.n0.r2.d.a> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.f63657a) == null) {
            return;
        }
        Iterator<String> it = concurrentHashMap.keySet().iterator();
        while (it.hasNext()) {
            d.a.n0.r2.d.a aVar = this.f63657a.get(it.next());
            if (aVar != null && str.equals(aVar.f63659b)) {
                it.remove();
            }
        }
    }

    public void e(boolean z) {
        ConcurrentHashMap<String, d.a.n0.r2.d.a> concurrentHashMap = this.f63657a;
        if (concurrentHashMap == null) {
            return;
        }
        for (String str : concurrentHashMap.keySet()) {
            d.a.n0.r2.d.a aVar = this.f63657a.get(str);
            if (aVar != null) {
                aVar.f63662e = z;
            }
        }
    }

    public void f(boolean z, String str) {
        ConcurrentHashMap<String, d.a.n0.r2.d.a> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.f63657a) == null) {
            return;
        }
        for (String str2 : concurrentHashMap.keySet()) {
            d.a.n0.r2.d.a aVar = this.f63657a.get(str2);
            if (aVar != null && str.equals(aVar.f63659b)) {
                aVar.f63662e = z;
            }
        }
    }

    public void g(HashMap<String, d.a.n0.r2.d.a> hashMap) {
        this.f63657a.clear();
        if (hashMap == null) {
            return;
        }
        this.f63657a.putAll(hashMap);
    }

    public void h(String str, HashMap<String, d.a.n0.r2.d.a> hashMap) {
        if (this.f63657a == null) {
            this.f63657a = new ConcurrentHashMap<>();
        }
        d(str);
        this.f63657a.putAll(hashMap);
    }
}
