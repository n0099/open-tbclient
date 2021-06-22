package d.a.o0.u.b.m;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.a.m0.a.a2.e;
import d.a.m0.a.c1.d.g;
import d.a.m0.a.g1.f;
import d.a.m0.a.v2.q0;
@Singleton
@Service
/* loaded from: classes4.dex */
public class a implements g {
    @Override // d.a.m0.a.c1.d.g
    public boolean a(Context context, String str, d.a.m0.a.q2.a aVar) {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AIAPPS_START_FAIL);
        statisticItem.param("uid", d.a.o0.u.b.b.a.l().p() == null ? "" : d.a.o0.u.b.b.a.l().p());
        statisticItem.param("obj_param1", aVar.g());
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, aVar.d());
        TiebaStatic.log(statisticItem);
        if (aVar.i() == 10 && aVar.g() == 1013) {
            b(context, aVar);
            return true;
        }
        return false;
    }

    public final void b(Context context, d.a.m0.a.q2.a aVar) {
        e Q = e.Q();
        if (context == null || Q == null) {
            return;
        }
        String i2 = d.a.m0.a.m2.b.i(f.V().N(), Q.N().G());
        long g2 = aVar.g();
        String q = aVar.q();
        if (!(1020 == g2 && !TextUtils.isEmpty(q))) {
            q = d.a.m0.n.j.i.f.b().a(g2);
        }
        ForbiddenInfo forbiddenInfo = new ForbiddenInfo(Q.L(), q, context.getString(R.string.aiapps_open_failed_detail_format, q0.D(), i2, String.valueOf(aVar.a())));
        forbiddenInfo.enableSlidingFlag = -1;
        d.a.m0.a.f1.d.a.k(context, SwanAppErrorActivity.TYPE_NEED_UPDATE_SDK, Q.N().C(), forbiddenInfo);
    }
}
