package d.b.i0.q0.g2;

import android.content.Context;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import d.b.i0.d3.b0;
import d.b.i0.d3.c0;
import d.b.i0.q0.n2.h;
/* loaded from: classes4.dex */
public class d {
    public static void a(Context context, b0 b0Var) {
        if (b0Var == null) {
            return;
        }
        TbPageContext<BaseFragmentActivity> tbPageContext = null;
        if (context instanceof BaseActivity) {
            tbPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            tbPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        if (tbPageContext == null) {
            return;
        }
        c0 c0Var = b0Var.f54764f;
        if (c0Var != null) {
            d.b.i0.s.a.b(c0Var.f54768b, c0Var.f54769c, "1191003700000000", c0Var.f54770d);
        } else {
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{b0Var.f54762d});
        }
        h.a(tbPageContext, b0Var.f54763e);
    }

    public static void b(b0 b0Var) {
        if (b0Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", b0Var.f54765g);
        statisticItem.param("obj_type", b0Var.f54764f == null ? 1 : 2);
        statisticItem.param("obj_locate", b0Var.f54766h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("obj_name", b0Var.f54761c);
        TiebaStatic.log(statisticItem);
        d.b.i0.q0.l2.a.a(b0Var.i);
    }

    public static void c(b0 b0Var) {
        if (b0Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", b0Var.f54765g);
        statisticItem.param("obj_type", b0Var.f54764f == null ? 1 : 2);
        statisticItem.param("obj_locate", b0Var.f54766h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("obj_name", b0Var.f54761c);
        TiebaStatic.log(statisticItem);
        d.b.i0.q0.l2.a.b(b0Var.i);
    }
}
