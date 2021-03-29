package d.b.i0.z0.e.a;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tieba.R;
import d.b.h0.r.q.a2;
import d.b.i0.z0.e.a.e.e;
/* loaded from: classes3.dex */
public class a {
    public static void a(View view, Object obj, int i, String str) {
        if (obj instanceof d.b.i0.z0.e.a.e.c) {
            d.b.i0.z0.e.a.e.c cVar = (d.b.i0.z0.e.a.e.c) obj;
            if (cVar.f62972e) {
                StatisticItem statisticItem = new StatisticItem("c13736");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.eventStat();
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13735");
            statisticItem2.param("obj_locate", i);
            statisticItem2.param("topic_id", cVar.f62968a);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem2.eventStat();
        } else if (obj instanceof e) {
            a2 a2Var = ((e) obj).j;
            StatisticItem statisticItem3 = new StatisticItem("c13738");
            statisticItem3.param("obj_type", str);
            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
            if (a2Var != null) {
                statisticItem3.param("tid", a2Var.w1());
                statisticItem3.param("fid", a2Var.c0());
            }
            statisticItem3.eventStat();
        } else if ((obj instanceof d.b.h0.r.q.a) && c(view)) {
            a2 n = ((d.b.h0.r.q.a) obj).n();
            StatisticItem statisticItem4 = new StatisticItem("c13738");
            statisticItem4.param("obj_type", str);
            statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
            if (n != null) {
                statisticItem4.param("tid", n.w1());
                statisticItem4.param("fid", n.c0());
            }
            statisticItem4.eventStat();
        }
    }

    public static void b(View view, Object obj, String str) {
        if (obj instanceof e) {
            a2 a2Var = ((e) obj).j;
            StatisticItem statisticItem = new StatisticItem("c13825");
            statisticItem.param("obj_type", str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            if (a2Var != null) {
                statisticItem.param("tid", a2Var.w1());
            }
            statisticItem.eventStat();
        } else if (obj instanceof d.b.h0.r.q.a) {
            a2 n = ((d.b.h0.r.q.a) obj).n();
            StatisticItem statisticItem2 = new StatisticItem("c13825");
            statisticItem2.param("obj_type", str);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            if (n != null) {
                statisticItem2.param("tid", n.w1());
            }
            statisticItem2.eventStat();
        }
    }

    public static boolean c(View view) {
        int id = view.getId();
        return id == R.id.thread_card_root || id == R.id.thread_info_commont_container;
    }
}
