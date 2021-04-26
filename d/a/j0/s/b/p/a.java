package d.a.j0.s.b.p;

import android.content.Context;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.a.h0.a.w0.c.g;
@Singleton
@Service
/* loaded from: classes4.dex */
public class a implements g {
    @Override // d.a.h0.a.w0.c.g
    public boolean a(Context context, String str, d.a.h0.a.f2.a aVar) {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AIAPPS_START_FAIL);
        statisticItem.param("uid", d.a.j0.s.b.b.a.l().p() == null ? "" : d.a.j0.s.b.b.a.l().p());
        statisticItem.param("obj_param1", aVar.g());
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, aVar.d());
        TiebaStatic.log(statisticItem);
        if (aVar.i() == 10 && aVar.g() == 1013) {
            b();
            return true;
        }
        return false;
    }

    public final void b() {
        BaseActivityDialog.c newBuilder = SwanAppErrorDialog.newBuilder();
        newBuilder.A(R.string.swan_app_update_title);
        newBuilder.t(R.string.swan_app_update_msg);
        newBuilder.y(R.string.swan_app_update_btn, null);
        newBuilder.C();
    }
}
