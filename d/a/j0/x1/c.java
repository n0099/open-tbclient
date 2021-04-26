package d.a.j0.x1;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.n1;
/* loaded from: classes3.dex */
public class c {
    public static void a(String str, Object obj, int i2) {
        if (obj instanceof n1) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("fid", ((n1) obj).C());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.eventStat();
        } else if (obj instanceof d.a.j0.x1.e.b) {
            StatisticItem statisticItem2 = new StatisticItem(str);
            a2 a2Var = ((d.a.j0.x1.e.b) obj).k;
            if (a2Var != null) {
                statisticItem2.param("tid", a2Var.w1());
            }
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem2.eventStat();
        }
    }

    public static void b(d.a.j0.x1.d.c.a aVar, d.a.i0.r.q.a aVar2) {
        if (aVar2 == null || aVar2.m() == null) {
            return;
        }
        a2 m = aVar2.m();
        StatisticItem statisticItem = new StatisticItem(aVar.e0() ? "c13823" : "c13822");
        statisticItem.param("tid", m.w1());
        statisticItem.param("fid", m.c0());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.eventStat();
    }

    public static void c(d.a.j0.x1.d.c.a aVar, d.a.i0.r.q.a aVar2) {
        if (aVar2 == null || aVar2.m() == null) {
            return;
        }
        a2 m = aVar2.m();
        StatisticItem statisticItem = new StatisticItem(aVar.e0() ? "c13824" : "c13821");
        statisticItem.param("tid", m.w1());
        statisticItem.param("fid", m.c0());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.eventStat();
    }
}
