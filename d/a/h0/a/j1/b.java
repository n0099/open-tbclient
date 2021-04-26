package d.a.h0.a.j1;

import android.text.TextUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Map<String, HybridUbcFlow>> f42916a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, d.a.h0.a.i2.u0.b<HybridUbcFlow>> f42917b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final d.a.h0.a.i2.u0.b<HybridUbcFlow> f42918c = new a();

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<HybridUbcFlow> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(HybridUbcFlow hybridUbcFlow) {
            b.this.g(hybridUbcFlow.o);
        }
    }

    public final HybridUbcFlow a(String str) {
        HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
        hybridUbcFlow.C("callback_on_submit", this.f42918c);
        d.a.h0.a.i2.u0.b<HybridUbcFlow> bVar = this.f42917b.get(str);
        if (bVar != null) {
            bVar.onCallback(hybridUbcFlow);
        }
        return hybridUbcFlow;
    }

    public HybridUbcFlow b(String str) {
        return c(str, "default");
    }

    public HybridUbcFlow c(String str, String str2) {
        synchronized (this.f42916a) {
            Map<String, HybridUbcFlow> map = this.f42916a.get(str);
            if (map == null) {
                return null;
            }
            return map.get(str2);
        }
    }

    public b d(String str, d.a.h0.a.i2.u0.b<HybridUbcFlow> bVar) {
        synchronized (this.f42917b) {
            this.f42917b.put(str, bVar);
        }
        return this;
    }

    public synchronized HybridUbcFlow e(String str) {
        return f(str, "default");
    }

    public synchronized HybridUbcFlow f(String str, String str2) {
        synchronized (this.f42916a) {
            Map<String, HybridUbcFlow> map = this.f42916a.get(str);
            if (map == null) {
                HashMap hashMap = new HashMap();
                HybridUbcFlow a2 = a(str);
                hashMap.put(str2, a2);
                this.f42916a.put(str, hashMap);
                return a2;
            }
            HybridUbcFlow hybridUbcFlow = map.get(str2);
            if (hybridUbcFlow == null) {
                hybridUbcFlow = a(str);
                map.put(str2, hybridUbcFlow);
            }
            return hybridUbcFlow;
        }
    }

    public b g(String str) {
        if (TextUtils.equals(str, "startup")) {
            e.b();
        }
        synchronized (this.f42916a) {
            this.f42916a.remove(str);
        }
        return this;
    }

    public b h(String str, String str2) {
        synchronized (this.f42916a) {
            Map<String, HybridUbcFlow> map = this.f42916a.get(str);
            if (map != null) {
                map.remove(str2);
            }
        }
        return this;
    }
}
