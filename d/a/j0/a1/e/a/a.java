package d.a.j0.a1.e.a;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tieba.R;
import d.a.i0.r.q.a2;
import d.a.j0.a1.e.a.e.e;
/* loaded from: classes4.dex */
public class a {
    public static void a(View view, Object obj, int i2, String str) {
        if (obj instanceof d.a.j0.a1.e.a.e.c) {
            d.a.j0.a1.e.a.e.c cVar = (d.a.j0.a1.e.a.e.c) obj;
            if (cVar.f50715e) {
                StatisticItem statisticItem = new StatisticItem("c13736");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.eventStat();
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13735");
            statisticItem2.param("obj_locate", i2);
            statisticItem2.param("topic_id", cVar.f50711a);
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
        } else if ((obj instanceof d.a.i0.r.q.a) && c(view)) {
            a2 m = ((d.a.i0.r.q.a) obj).m();
            StatisticItem statisticItem4 = new StatisticItem("c13738");
            statisticItem4.param("obj_type", str);
            statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
            if (m != null) {
                statisticItem4.param("tid", m.w1());
                statisticItem4.param("fid", m.c0());
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
        } else if (obj instanceof d.a.i0.r.q.a) {
            a2 m = ((d.a.i0.r.q.a) obj).m();
            StatisticItem statisticItem2 = new StatisticItem("c13825");
            statisticItem2.param("obj_type", str);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            if (m != null) {
                statisticItem2.param("tid", m.w1());
            }
            statisticItem2.eventStat();
        }
    }

    public static boolean c(View view) {
        int id = view.getId();
        return id == R.id.thread_card_root || id == R.id.thread_info_commont_container;
    }
}
