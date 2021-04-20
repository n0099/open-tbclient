package d.b.i0.q2;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static c f60528b;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, d.b.i0.q2.d.a> f60529a = new ConcurrentHashMap<>();

    public static c a() {
        if (f60528b == null) {
            synchronized (c.class) {
                if (f60528b == null) {
                    f60528b = new c();
                }
            }
        }
        return f60528b;
    }

    public ConcurrentHashMap<String, d.b.i0.q2.d.a> b() {
        return this.f60529a;
    }

    public d.b.i0.q2.d.a c(String str) {
        ConcurrentHashMap<String, d.b.i0.q2.d.a> concurrentHashMap = this.f60529a;
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    public void d(String str) {
        ConcurrentHashMap<String, d.b.i0.q2.d.a> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.f60529a) == null) {
            return;
        }
        Iterator<String> it = concurrentHashMap.keySet().iterator();
        while (it.hasNext()) {
            d.b.i0.q2.d.a aVar = this.f60529a.get(it.next());
            if (aVar != null && str.equals(aVar.f60531b)) {
                it.remove();
            }
        }
    }

    public void e(boolean z) {
        ConcurrentHashMap<String, d.b.i0.q2.d.a> concurrentHashMap = this.f60529a;
        if (concurrentHashMap == null) {
            return;
        }
        for (String str : concurrentHashMap.keySet()) {
            d.b.i0.q2.d.a aVar = this.f60529a.get(str);
            if (aVar != null) {
                aVar.f60534e = z;
            }
        }
    }

    public void f(boolean z, String str) {
        ConcurrentHashMap<String, d.b.i0.q2.d.a> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.f60529a) == null) {
            return;
        }
        for (String str2 : concurrentHashMap.keySet()) {
            d.b.i0.q2.d.a aVar = this.f60529a.get(str2);
            if (aVar != null && str.equals(aVar.f60531b)) {
                aVar.f60534e = z;
            }
        }
    }

    public void g(HashMap<String, d.b.i0.q2.d.a> hashMap) {
        this.f60529a.clear();
        if (hashMap == null) {
            return;
        }
        this.f60529a.putAll(hashMap);
    }

    public void h(String str, HashMap<String, d.b.i0.q2.d.a> hashMap) {
        if (this.f60529a == null) {
            this.f60529a = new ConcurrentHashMap<>();
        }
        d(str);
        this.f60529a.putAll(hashMap);
    }
}
