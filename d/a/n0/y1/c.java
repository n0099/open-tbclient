package d.a.n0.y1;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.n1;
/* loaded from: classes4.dex */
public class c {
    public static void a(String str, Object obj, int i2) {
        if (obj instanceof n1) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("fid", ((n1) obj).C());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.eventStat();
        } else if (obj instanceof d.a.n0.y1.e.b) {
            StatisticItem statisticItem2 = new StatisticItem(str);
            a2 a2Var = ((d.a.n0.y1.e.b) obj).k;
            if (a2Var != null) {
                statisticItem2.param("tid", a2Var.y1());
            }
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem2.eventStat();
        }
    }

    public static void b(d.a.n0.y1.d.c.a aVar, d.a.m0.r.q.a aVar2) {
        if (aVar2 == null || aVar2.m() == null) {
            return;
        }
        a2 m = aVar2.m();
        StatisticItem statisticItem = new StatisticItem(aVar.e0() ? "c13823" : "c13822");
        statisticItem.param("tid", m.y1());
        statisticItem.param("fid", m.c0());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.eventStat();
    }

    public static void c(d.a.n0.y1.d.c.a aVar, d.a.m0.r.q.a aVar2) {
        if (aVar2 == null || aVar2.m() == null) {
            return;
        }
        a2 m = aVar2.m();
        StatisticItem statisticItem = new StatisticItem(aVar.e0() ? "c13824" : "c13821");
        statisticItem.param("tid", m.y1());
        statisticItem.param("fid", m.c0());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.eventStat();
    }
}
