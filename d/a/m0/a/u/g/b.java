package d.a.m0.a.u.g;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.m0.a.k;
import d.a.m0.a.r1.h;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f49014b = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, d.a.m0.a.r1.k.a> f49015a = new ConcurrentHashMap();

    @Override // d.a.m0.a.u.g.a
    public void a(String str) {
        if (this.f49015a.containsKey(str)) {
            return;
        }
        if (f49014b) {
            Log.d("Api-FirstRecorder", "markStart: " + str);
        }
        d.a.m0.a.r1.k.a aVar = new d.a.m0.a.r1.k.a();
        this.f49015a.put(str, aVar);
        aVar.i(System.currentTimeMillis());
        aVar.f(str);
    }

    @Override // d.a.m0.a.u.g.a
    public void b(String str) {
        d.a.m0.a.r1.k.a aVar = this.f49015a.get(str);
        if (aVar == null) {
            if (f49014b) {
                throw new RuntimeException(str + " markEnd before markStart");
            }
        } else if (aVar.d() > 0) {
        } else {
            aVar.h(System.currentTimeMillis());
            if (f49014b) {
                Log.d("Api-FirstRecorder", str + " first called cost " + aVar.c());
            }
            if (TextUtils.equals(str, "request")) {
                if (f49014b) {
                    Log.d("Api-FirstRecorder", "record first request api called " + aVar.toString());
                }
                HybridUbcFlow p = h.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("first_request_api_call_start");
                ubcFlowEvent.h(aVar.e());
                p.C(ubcFlowEvent);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("first_request_api_call_end");
                ubcFlowEvent2.h(aVar.d());
                p.C(ubcFlowEvent2);
            }
        }
    }
}
