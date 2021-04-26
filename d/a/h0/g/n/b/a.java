package d.a.h0.g.n.b;

import android.util.Log;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import d.a.h0.a.b2.f.a;
import d.a.h0.a.e0.p.l;
import d.a.h0.a.i2.u0.b;
import d.a.h0.a.k;
import d.a.h0.l.k.d;
/* loaded from: classes3.dex */
public class a extends l {
    public static final boolean o = k.f43101a;

    public a(b<Exception> bVar) {
        super(bVar);
    }

    @Override // d.a.h0.a.e0.p.l
    public int T() {
        return 1;
    }

    @Override // d.a.h0.a.e0.p.l
    public PMSDownloadType U() {
        return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
    }

    @Override // d.a.h0.a.e0.p.l
    public String V() {
        return d.a.h0.a.e0.p.r.a.f();
    }

    @Override // d.a.h0.a.e0.p.l
    public String W() {
        return d.a.h0.a.e0.p.r.a.e();
    }

    @Override // d.a.h0.a.e0.p.l
    public d.a.h0.a.f2.a a0(d.a.h0.l.k.b bVar) {
        if (bVar == null) {
            d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
            aVar.j(14L);
            aVar.b(2908L);
            aVar.c("小游戏Extension包 Extension null");
            return aVar;
        }
        d.a.h0.a.l0.h.a aVar2 = new d.a.h0.a.l0.h.a();
        aVar2.f43209a = bVar.j;
        aVar2.f43210b = bVar.f47147a;
        aVar2.f43211c = bVar.m;
        if (d.a.h0.a.l0.b.a(1, aVar2) == null) {
            if (o) {
                Log.i("SwanGameUpdateCoreCallback", "小游戏Extension包解压成功");
                return null;
            }
            return null;
        }
        d.a.h0.a.f2.a aVar3 = new d.a.h0.a.f2.a();
        aVar3.j(14L);
        aVar3.b(2908L);
        aVar3.c("小游戏Extension包更新失败");
        return aVar3;
    }

    @Override // d.a.h0.a.e0.p.l
    public d.a.h0.a.f2.a b0(d dVar) {
        if (dVar == null) {
            d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
            aVar.j(13L);
            aVar.b(2907L);
            aVar.c("小游戏GameCore包 Framework null");
            return aVar;
        }
        a.b c2 = d.a.h0.a.b2.f.a.c(dVar.j, dVar.f47147a, dVar.m, 1);
        d.a.h0.p.d.g(dVar.f47147a);
        if (c2.c()) {
            if (o) {
                Log.d("SwanGameUpdateCoreCallback", "小游戏GameCore解压成功");
            }
            long d2 = d.a.h0.a.b2.f.a.d(1);
            if (d2 > 0) {
                SwanAppMessengerService.sendMessageWithDataToAllClient(117, d2);
                return null;
            }
            return null;
        }
        d.a.h0.a.f2.a aVar2 = new d.a.h0.a.f2.a();
        aVar2.j(13L);
        aVar2.b(2907L);
        aVar2.c("小游戏GameCore包更新失败");
        return aVar2;
    }
}
