package d.a.l0.h.p.b;

import android.util.Log;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import d.a.l0.a.h0.m.l;
import d.a.l0.a.k;
import d.a.l0.a.m2.f.a;
import d.a.l0.a.v2.e1.b;
import d.a.l0.n.h.d;
/* loaded from: classes3.dex */
public class a extends l {
    public static final boolean o = k.f46875a;

    public a(b<Exception> bVar) {
        super(bVar);
    }

    @Override // d.a.l0.a.h0.m.l
    public int T() {
        return 1;
    }

    @Override // d.a.l0.a.h0.m.l
    public PMSDownloadType U() {
        return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
    }

    @Override // d.a.l0.a.h0.m.l
    public String V() {
        return d.a.l0.a.h0.m.r.a.f();
    }

    @Override // d.a.l0.a.h0.m.l
    public String W() {
        return d.a.l0.a.h0.m.r.a.e();
    }

    @Override // d.a.l0.a.h0.m.l
    public d.a.l0.a.q2.a a0(d.a.l0.n.h.b bVar) {
        if (bVar == null) {
            d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
            aVar.j(14L);
            aVar.b(2908L);
            aVar.c("小游戏Extension包 Extension null");
            return aVar;
        }
        d.a.l0.a.p0.g.a aVar2 = new d.a.l0.a.p0.g.a();
        aVar2.f47763b = bVar.f51688i;
        aVar2.f47762a = bVar.j;
        aVar2.f47764c = bVar.f51680a;
        aVar2.f47765d = bVar.m;
        if (d.a.l0.a.p0.b.b(1, aVar2) == null) {
            if (o) {
                Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                return null;
            }
            return null;
        }
        d.a.l0.a.q2.a aVar3 = new d.a.l0.a.q2.a();
        aVar3.j(14L);
        aVar3.b(2908L);
        aVar3.c("小游戏Extension包更新失败");
        return aVar3;
    }

    @Override // d.a.l0.a.h0.m.l
    public d.a.l0.a.q2.a b0(d dVar) {
        if (o) {
            Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + dVar);
        }
        if (dVar == null) {
            d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
            aVar.j(13L);
            aVar.b(2907L);
            aVar.c("小游戏GameCore包 Framework null");
            return aVar;
        }
        a.b c2 = d.a.l0.a.m2.f.a.c(dVar, 1);
        d.a.l0.t.d.j(dVar.f51680a);
        if (c2.c()) {
            if (o) {
                Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
            }
            long e2 = d.a.l0.a.m2.f.a.e(1);
            if (e2 > 0) {
                SwanAppMessengerService.sendMessageWithDataToAllClient(117, e2);
                return null;
            }
            return null;
        }
        d.a.l0.a.q2.a aVar2 = new d.a.l0.a.q2.a();
        aVar2.j(13L);
        aVar2.b(2907L);
        aVar2.c("小游戏GameCore包更新失败");
        return aVar2;
    }
}
