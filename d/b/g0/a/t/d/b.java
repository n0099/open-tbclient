package d.b.g0.a.t.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.b.g0.a.j1.i;
import d.b.g0.a.k;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46601b = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, d.b.g0.a.j1.l.a> f46602a = new ConcurrentHashMap();

    @Override // d.b.g0.a.t.d.a
    public void a(String str) {
        if (this.f46602a.containsKey(str)) {
            return;
        }
        if (f46601b) {
            Log.d("Api-FirstRecorder", "markStart: " + str);
        }
        d.b.g0.a.j1.l.a aVar = new d.b.g0.a.j1.l.a();
        this.f46602a.put(str, aVar);
        aVar.g(System.currentTimeMillis());
        aVar.e(str);
    }

    @Override // d.b.g0.a.t.d.a
    public void b(String str) {
        d.b.g0.a.j1.l.a aVar = this.f46602a.get(str);
        if (aVar == null) {
            if (f46601b) {
                throw new RuntimeException(str + " markEnd before markStart");
            }
        } else if (aVar.c() > 0) {
        } else {
            aVar.f(System.currentTimeMillis());
            if (f46601b) {
                Log.d("Api-FirstRecorder", str + " first called cost " + aVar.b());
            }
            if (TextUtils.equals(str, "request")) {
                if (f46601b) {
                    Log.d("Api-FirstRecorder", "record first request api called " + aVar.toString());
                }
                HybridUbcFlow o = i.o("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("first_request_api_call_start");
                ubcFlowEvent.h(aVar.d());
                o.A(ubcFlowEvent);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("first_request_api_call_end");
                ubcFlowEvent2.h(aVar.c());
                o.A(ubcFlowEvent2);
            }
        }
    }
}
