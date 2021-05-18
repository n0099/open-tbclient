package d.a.i0.a.h0.m;

import android.util.Log;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.event.SwanJSVersionUpdateEvent;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import d.a.i0.a.m2.f.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class i extends l {
    public static final boolean p = d.a.i0.a.k.f43025a;
    public final boolean o;

    public i(d.a.i0.a.v2.e1.b<Exception> bVar) {
        this(bVar, false);
    }

    @Override // d.a.i0.n.f.g
    public Map<String, String> A() {
        Map<String, String> A = super.A();
        if (this.o && d.a.i0.n.j.i.l.f47978a) {
            if (A == null) {
                A = new HashMap<>();
            }
            A.put("hb_type", "1");
            A.put("lastsynctime", String.valueOf(d.a.i0.n.j.i.l.f47980c));
            A.put("SWAN-TIMEOUT-SETTING", String.valueOf(d.a.i0.n.j.i.l.b(60) * 1000));
        }
        return A;
    }

    @Override // d.a.i0.a.h0.m.l
    public int T() {
        return 0;
    }

    @Override // d.a.i0.a.h0.m.l
    public PMSDownloadType U() {
        return PMSDownloadType.SWAN_APP_UPDATE_CORE;
    }

    @Override // d.a.i0.a.h0.m.l
    public String V() {
        return d.a.i0.a.h0.m.r.a.d();
    }

    @Override // d.a.i0.a.h0.m.l
    public String W() {
        return d.a.i0.a.h0.m.r.a.h();
    }

    @Override // d.a.i0.a.h0.m.l
    public d.a.i0.a.q2.a a0(d.a.i0.n.h.b bVar) {
        if (bVar == null) {
            d.a.i0.a.q2.a aVar = new d.a.i0.a.q2.a();
            aVar.j(14L);
            aVar.b(2908L);
            aVar.c("小程序Extension包 Extension null");
            return aVar;
        }
        d.a.i0.a.p0.g.a aVar2 = new d.a.i0.a.p0.g.a();
        aVar2.f43913b = bVar.f47838i;
        aVar2.f43912a = bVar.j;
        aVar2.f43914c = bVar.f47830a;
        aVar2.f43915d = bVar.m;
        if (d.a.i0.a.p0.b.b(0, aVar2) == null) {
            if (p) {
                Log.i("SwanAppUpdateCore", "小程序Extension包解压成功");
            }
            boolean n = d.a.i0.a.c1.a.Z().n();
            if (p) {
                Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: extension js 热应用实验开关 " + n);
            }
            if (n) {
                if (p) {
                    Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: 命中 extension js 热应用实验");
                }
                d.a.i0.a.p0.d.b f2 = d.a.i0.a.p0.b.f(0);
                if (f2 == null) {
                    return null;
                }
                long g2 = f2.f().g();
                if (g2 > 0) {
                    if (p) {
                        Log.d("SwanAppUpdateCore", "发送extension core更新事件");
                    }
                    SwanAppMessengerService.sendMessageWithDataToAllClient(121, g2);
                }
            }
            return null;
        }
        d.a.i0.a.q2.a aVar3 = new d.a.i0.a.q2.a();
        aVar3.j(14L);
        aVar3.b(2908L);
        aVar3.c("小程序Extension包更新失败");
        return aVar3;
    }

    @Override // d.a.i0.a.h0.m.l
    public d.a.i0.a.q2.a b0(d.a.i0.n.h.d dVar) {
        if (p) {
            Log.d("SwanAppUpdateCore", "onFrameworkDownloadFinish framework = " + dVar);
        }
        if (dVar == null) {
            d.a.i0.a.q2.a aVar = new d.a.i0.a.q2.a();
            aVar.j(13L);
            aVar.b(2907L);
            aVar.c("小程序Core包 Framework null");
            return aVar;
        }
        a.b c2 = d.a.i0.a.m2.f.a.c(dVar, 0);
        d.a.i0.a.e0.d.h("SwanAppUpdateCore", "SwanCore RemoteCoreUpdateStatus: " + c2);
        d.a.i0.t.d.j(dVar.f47830a);
        if (c2.c()) {
            long e2 = d.a.i0.a.m2.f.a.e(0);
            if (e2 > 0) {
                SwanJSVersionUpdateEvent.sendEvent(e2);
                SwanAppMessengerService.sendMessageWithDataToAllClient(114, e2);
                return null;
            }
            return null;
        }
        d.a.i0.a.q2.a aVar2 = new d.a.i0.a.q2.a();
        aVar2.j(13L);
        aVar2.b(2907L);
        aVar2.c("小程序Core包更新失败");
        return aVar2;
    }

    public i(d.a.i0.a.v2.e1.b<Exception> bVar, boolean z) {
        super(bVar);
        this.o = z;
    }
}
