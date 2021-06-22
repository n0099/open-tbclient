package d.a.o0.r2;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static c f63781b;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, d.a.o0.r2.d.a> f63782a = new ConcurrentHashMap<>();

    public static c a() {
        if (f63781b == null) {
            synchronized (c.class) {
                if (f63781b == null) {
                    f63781b = new c();
                }
            }
        }
        return f63781b;
    }

    public ConcurrentHashMap<String, d.a.o0.r2.d.a> b() {
        return this.f63782a;
    }

    public d.a.o0.r2.d.a c(String str) {
        ConcurrentHashMap<String, d.a.o0.r2.d.a> concurrentHashMap = this.f63782a;
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    public void d(String str) {
        ConcurrentHashMap<String, d.a.o0.r2.d.a> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.f63782a) == null) {
            return;
        }
        Iterator<String> it = concurrentHashMap.keySet().iterator();
        while (it.hasNext()) {
            d.a.o0.r2.d.a aVar = this.f63782a.get(it.next());
            if (aVar != null && str.equals(aVar.f63784b)) {
                it.remove();
            }
        }
    }

    public void e(boolean z) {
        ConcurrentHashMap<String, d.a.o0.r2.d.a> concurrentHashMap = this.f63782a;
        if (concurrentHashMap == null) {
            return;
        }
        for (String str : concurrentHashMap.keySet()) {
            d.a.o0.r2.d.a aVar = this.f63782a.get(str);
            if (aVar != null) {
                aVar.f63787e = z;
            }
        }
    }

    public void f(boolean z, String str) {
        ConcurrentHashMap<String, d.a.o0.r2.d.a> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.f63782a) == null) {
            return;
        }
        for (String str2 : concurrentHashMap.keySet()) {
            d.a.o0.r2.d.a aVar = this.f63782a.get(str2);
            if (aVar != null && str.equals(aVar.f63784b)) {
                aVar.f63787e = z;
            }
        }
    }

    public void g(HashMap<String, d.a.o0.r2.d.a> hashMap) {
        this.f63782a.clear();
        if (hashMap == null) {
            return;
        }
        this.f63782a.putAll(hashMap);
    }

    public void h(String str, HashMap<String, d.a.o0.r2.d.a> hashMap) {
        if (this.f63782a == null) {
            this.f63782a = new ConcurrentHashMap<>();
        }
        d(str);
        this.f63782a.putAll(hashMap);
    }
}
