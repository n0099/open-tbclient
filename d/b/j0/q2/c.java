package d.b.j0.q2;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static c f60949b;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, d.b.j0.q2.d.a> f60950a = new ConcurrentHashMap<>();

    public static c a() {
        if (f60949b == null) {
            synchronized (c.class) {
                if (f60949b == null) {
                    f60949b = new c();
                }
            }
        }
        return f60949b;
    }

    public ConcurrentHashMap<String, d.b.j0.q2.d.a> b() {
        return this.f60950a;
    }

    public d.b.j0.q2.d.a c(String str) {
        ConcurrentHashMap<String, d.b.j0.q2.d.a> concurrentHashMap = this.f60950a;
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    public void d(String str) {
        ConcurrentHashMap<String, d.b.j0.q2.d.a> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.f60950a) == null) {
            return;
        }
        Iterator<String> it = concurrentHashMap.keySet().iterator();
        while (it.hasNext()) {
            d.b.j0.q2.d.a aVar = this.f60950a.get(it.next());
            if (aVar != null && str.equals(aVar.f60952b)) {
                it.remove();
            }
        }
    }

    public void e(boolean z) {
        ConcurrentHashMap<String, d.b.j0.q2.d.a> concurrentHashMap = this.f60950a;
        if (concurrentHashMap == null) {
            return;
        }
        for (String str : concurrentHashMap.keySet()) {
            d.b.j0.q2.d.a aVar = this.f60950a.get(str);
            if (aVar != null) {
                aVar.f60955e = z;
            }
        }
    }

    public void f(boolean z, String str) {
        ConcurrentHashMap<String, d.b.j0.q2.d.a> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.f60950a) == null) {
            return;
        }
        for (String str2 : concurrentHashMap.keySet()) {
            d.b.j0.q2.d.a aVar = this.f60950a.get(str2);
            if (aVar != null && str.equals(aVar.f60952b)) {
                aVar.f60955e = z;
            }
        }
    }

    public void g(HashMap<String, d.b.j0.q2.d.a> hashMap) {
        this.f60950a.clear();
        if (hashMap == null) {
            return;
        }
        this.f60950a.putAll(hashMap);
    }

    public void h(String str, HashMap<String, d.b.j0.q2.d.a> hashMap) {
        if (this.f60950a == null) {
            this.f60950a = new ConcurrentHashMap<>();
        }
        d(str);
        this.f60950a.putAll(hashMap);
    }
}
