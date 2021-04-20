package d.b.g0.g.n.b;

import android.util.Log;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import d.b.g0.a.b2.f.a;
import d.b.g0.a.e0.p.l;
import d.b.g0.a.i2.u0.b;
import d.b.g0.a.k;
import d.b.g0.l.k.d;
/* loaded from: classes3.dex */
public class a extends l {
    public static final boolean o = k.f45443a;

    public a(b<Exception> bVar) {
        super(bVar);
    }

    @Override // d.b.g0.a.e0.p.l
    public int T() {
        return 1;
    }

    @Override // d.b.g0.a.e0.p.l
    public PMSDownloadType U() {
        return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
    }

    @Override // d.b.g0.a.e0.p.l
    public String V() {
        return d.b.g0.a.e0.p.r.a.f();
    }

    @Override // d.b.g0.a.e0.p.l
    public String W() {
        return d.b.g0.a.e0.p.r.a.e();
    }

    @Override // d.b.g0.a.e0.p.l
    public d.b.g0.a.f2.a a0(d.b.g0.l.k.b bVar) {
        if (bVar == null) {
            d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
            aVar.j(14L);
            aVar.b(2908L);
            aVar.c("小游戏Extension包 Extension null");
            return aVar;
        }
        d.b.g0.a.l0.h.a aVar2 = new d.b.g0.a.l0.h.a();
        aVar2.f45546a = bVar.j;
        aVar2.f45547b = bVar.f49309a;
        aVar2.f45548c = bVar.m;
        if (d.b.g0.a.l0.b.a(1, aVar2) == null) {
            if (o) {
                Log.i("SwanGameUpdateCoreCallback", "小游戏Extension包解压成功");
                return null;
            }
            return null;
        }
        d.b.g0.a.f2.a aVar3 = new d.b.g0.a.f2.a();
        aVar3.j(14L);
        aVar3.b(2908L);
        aVar3.c("小游戏Extension包更新失败");
        return aVar3;
    }

    @Override // d.b.g0.a.e0.p.l
    public d.b.g0.a.f2.a b0(d dVar) {
        if (dVar == null) {
            d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
            aVar.j(13L);
            aVar.b(2907L);
            aVar.c("小游戏GameCore包 Framework null");
            return aVar;
        }
        a.b c2 = d.b.g0.a.b2.f.a.c(dVar.j, dVar.f49309a, dVar.m, 1);
        d.b.g0.p.d.g(dVar.f49309a);
        if (c2.c()) {
            if (o) {
                Log.d("SwanGameUpdateCoreCallback", "小游戏GameCore解压成功");
            }
            long d2 = d.b.g0.a.b2.f.a.d(1);
            if (d2 > 0) {
                SwanAppMessengerService.sendMessageWithDataToAllClient(117, d2);
                return null;
            }
            return null;
        }
        d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
        aVar2.j(13L);
        aVar2.b(2907L);
        aVar2.c("小游戏GameCore包更新失败");
        return aVar2;
    }
}
