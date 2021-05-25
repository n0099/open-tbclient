package d.a.n0.r2;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static c f59965b;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, d.a.n0.r2.d.a> f59966a = new ConcurrentHashMap<>();

    public static c a() {
        if (f59965b == null) {
            synchronized (c.class) {
                if (f59965b == null) {
                    f59965b = new c();
                }
            }
        }
        return f59965b;
    }

    public ConcurrentHashMap<String, d.a.n0.r2.d.a> b() {
        return this.f59966a;
    }

    public d.a.n0.r2.d.a c(String str) {
        ConcurrentHashMap<String, d.a.n0.r2.d.a> concurrentHashMap = this.f59966a;
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    public void d(String str) {
        ConcurrentHashMap<String, d.a.n0.r2.d.a> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.f59966a) == null) {
            return;
        }
        Iterator<String> it = concurrentHashMap.keySet().iterator();
        while (it.hasNext()) {
            d.a.n0.r2.d.a aVar = this.f59966a.get(it.next());
            if (aVar != null && str.equals(aVar.f59968b)) {
                it.remove();
            }
        }
    }

    public void e(boolean z) {
        ConcurrentHashMap<String, d.a.n0.r2.d.a> concurrentHashMap = this.f59966a;
        if (concurrentHashMap == null) {
            return;
        }
        for (String str : concurrentHashMap.keySet()) {
            d.a.n0.r2.d.a aVar = this.f59966a.get(str);
            if (aVar != null) {
                aVar.f59971e = z;
            }
        }
    }

    public void f(boolean z, String str) {
        ConcurrentHashMap<String, d.a.n0.r2.d.a> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.f59966a) == null) {
            return;
        }
        for (String str2 : concurrentHashMap.keySet()) {
            d.a.n0.r2.d.a aVar = this.f59966a.get(str2);
            if (aVar != null && str.equals(aVar.f59968b)) {
                aVar.f59971e = z;
            }
        }
    }

    public void g(HashMap<String, d.a.n0.r2.d.a> hashMap) {
        this.f59966a.clear();
        if (hashMap == null) {
            return;
        }
        this.f59966a.putAll(hashMap);
    }

    public void h(String str, HashMap<String, d.a.n0.r2.d.a> hashMap) {
        if (this.f59966a == null) {
            this.f59966a = new ConcurrentHashMap<>();
        }
        d(str);
        this.f59966a.putAll(hashMap);
    }
}
