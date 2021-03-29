package d.b.i0.p2;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static c f58860b;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, d.b.i0.p2.d.a> f58861a = new ConcurrentHashMap<>();

    public static c a() {
        if (f58860b == null) {
            synchronized (c.class) {
                if (f58860b == null) {
                    f58860b = new c();
                }
            }
        }
        return f58860b;
    }

    public ConcurrentHashMap<String, d.b.i0.p2.d.a> b() {
        return this.f58861a;
    }

    public d.b.i0.p2.d.a c(String str) {
        ConcurrentHashMap<String, d.b.i0.p2.d.a> concurrentHashMap = this.f58861a;
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    public void d(String str) {
        ConcurrentHashMap<String, d.b.i0.p2.d.a> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.f58861a) == null) {
            return;
        }
        Iterator<String> it = concurrentHashMap.keySet().iterator();
        while (it.hasNext()) {
            d.b.i0.p2.d.a aVar = this.f58861a.get(it.next());
            if (aVar != null && str.equals(aVar.f58863b)) {
                it.remove();
            }
        }
    }

    public void e(boolean z) {
        ConcurrentHashMap<String, d.b.i0.p2.d.a> concurrentHashMap = this.f58861a;
        if (concurrentHashMap == null) {
            return;
        }
        for (String str : concurrentHashMap.keySet()) {
            d.b.i0.p2.d.a aVar = this.f58861a.get(str);
            if (aVar != null) {
                aVar.f58866e = z;
            }
        }
    }

    public void f(boolean z, String str) {
        ConcurrentHashMap<String, d.b.i0.p2.d.a> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.f58861a) == null) {
            return;
        }
        for (String str2 : concurrentHashMap.keySet()) {
            d.b.i0.p2.d.a aVar = this.f58861a.get(str2);
            if (aVar != null && str.equals(aVar.f58863b)) {
                aVar.f58866e = z;
            }
        }
    }

    public void g(HashMap<String, d.b.i0.p2.d.a> hashMap) {
        this.f58861a.clear();
        if (hashMap == null) {
            return;
        }
        this.f58861a.putAll(hashMap);
    }

    public void h(String str, HashMap<String, d.b.i0.p2.d.a> hashMap) {
        if (this.f58861a == null) {
            this.f58861a = new ConcurrentHashMap<>();
        }
        d(str);
        this.f58861a.putAll(hashMap);
    }
}
