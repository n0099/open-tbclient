package d.a.m0.a.r1;

import com.baidu.swan.apps.performance.HybridUbcFlow;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Map<String, HybridUbcFlow>> f48211a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, d.a.m0.a.v2.e1.b<HybridUbcFlow>> f48212b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final d.a.m0.a.v2.e1.b<HybridUbcFlow> f48213c = new a();

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.v2.e1.b<HybridUbcFlow> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(HybridUbcFlow hybridUbcFlow) {
            b.this.g(hybridUbcFlow.p);
        }
    }

    public final HybridUbcFlow a(String str) {
        HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
        hybridUbcFlow.E("callback_on_submit", this.f48213c);
        d.a.m0.a.v2.e1.b<HybridUbcFlow> bVar = this.f48212b.get(str);
        if (bVar != null) {
            bVar.onCallback(hybridUbcFlow);
        }
        return hybridUbcFlow;
    }

    public HybridUbcFlow b(String str) {
        return c(str, "default");
    }

    public HybridUbcFlow c(String str, String str2) {
        synchronized (this.f48211a) {
            Map<String, HybridUbcFlow> map = this.f48211a.get(str);
            if (map == null) {
                return null;
            }
            return map.get(str2);
        }
    }

    public b d(String str, d.a.m0.a.v2.e1.b<HybridUbcFlow> bVar) {
        synchronized (this.f48212b) {
            this.f48212b.put(str, bVar);
        }
        return this;
    }

    public synchronized HybridUbcFlow e(String str) {
        return f(str, "default");
    }

    public synchronized HybridUbcFlow f(String str, String str2) {
        synchronized (this.f48211a) {
            Map<String, HybridUbcFlow> map = this.f48211a.get(str);
            if (map == null) {
                HashMap hashMap = new HashMap();
                HybridUbcFlow a2 = a(str);
                hashMap.put(str2, a2);
                this.f48211a.put(str, hashMap);
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
        synchronized (this.f48211a) {
            this.f48211a.remove(str);
        }
        return this;
    }

    public b h(String str, String str2) {
        synchronized (this.f48211a) {
            Map<String, HybridUbcFlow> map = this.f48211a.get(str);
            if (map != null) {
                map.remove(str2);
            }
        }
        return this;
    }
}
