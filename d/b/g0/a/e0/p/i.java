package d.b.g0.a.e0.p;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.event.SwanJSVersionUpdateEvent;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import d.b.g0.a.b2.f.a;
/* loaded from: classes2.dex */
public class i extends l {
    public static final boolean o = d.b.g0.a.k.f45443a;

    public i(d.b.g0.a.i2.u0.b<Exception> bVar) {
        super(bVar);
    }

    @Override // d.b.g0.a.e0.p.l
    public int T() {
        return 0;
    }

    @Override // d.b.g0.a.e0.p.l
    public PMSDownloadType U() {
        return PMSDownloadType.SWAN_APP_UPDATE_CORE;
    }

    @Override // d.b.g0.a.e0.p.l
    public String V() {
        return d.b.g0.a.e0.p.r.a.d();
    }

    @Override // d.b.g0.a.e0.p.l
    public String W() {
        return d.b.g0.a.e0.p.r.a.h();
    }

    @Override // d.b.g0.a.e0.p.l
    public d.b.g0.a.f2.a a0(d.b.g0.l.k.b bVar) {
        if (bVar == null) {
            d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
            aVar.j(14L);
            aVar.b(2908L);
            aVar.c("小程序Extension包 Extension null");
            return aVar;
        }
        d.b.g0.a.l0.h.a aVar2 = new d.b.g0.a.l0.h.a();
        aVar2.f45546a = bVar.j;
        aVar2.f45547b = bVar.f49309a;
        aVar2.f45548c = bVar.m;
        if (d.b.g0.a.l0.b.a(0, aVar2) == null) {
            if (o) {
                Log.i("SwanAppUpdateCore", "小程序Extension包解压成功");
            }
            boolean l = d.b.g0.a.w0.a.N().l();
            if (o) {
                Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: extension js 热应用实验开关 " + l);
            }
            if (l) {
                if (o) {
                    Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: 命中 extension js 热应用实验");
                }
                long f2 = d.b.g0.a.l0.b.d(0).e().f();
                if (f2 > 0) {
                    if (o) {
                        Log.d("SwanAppUpdateCore", "发送extension core更新事件");
                    }
                    SwanAppMessengerService.sendMessageWithDataToAllClient((int) Constants.METHOD_IM_FRIEND_GROUP_DROP, f2);
                    return null;
                }
                return null;
            }
            return null;
        }
        d.b.g0.a.f2.a aVar3 = new d.b.g0.a.f2.a();
        aVar3.j(14L);
        aVar3.b(2908L);
        aVar3.c("小程序Extension包更新失败");
        return aVar3;
    }

    @Override // d.b.g0.a.e0.p.l
    public d.b.g0.a.f2.a b0(d.b.g0.l.k.d dVar) {
        if (dVar == null) {
            d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
            aVar.j(13L);
            aVar.b(2907L);
            aVar.c("小程序Core包 Framework null");
            return aVar;
        }
        a.b c2 = d.b.g0.a.b2.f.a.c(dVar.j, dVar.f49309a, dVar.m, 0);
        d.b.g0.a.c0.c.h("SwanAppUpdateCore", "SwanCore RemoteCoreUpdateStatus: " + c2);
        d.b.g0.p.d.g(dVar.f49309a);
        if (c2.c()) {
            long d2 = d.b.g0.a.b2.f.a.d(0);
            if (d2 > 0) {
                SwanJSVersionUpdateEvent.sendEvent(d2);
                SwanAppMessengerService.sendMessageWithDataToAllClient(114, d2);
                return null;
            }
            return null;
        }
        d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
        aVar2.j(13L);
        aVar2.b(2907L);
        aVar2.c("小程序Core包更新失败");
        return aVar2;
    }
}
