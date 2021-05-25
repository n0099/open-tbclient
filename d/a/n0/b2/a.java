package d.a.n0.b2;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
/* loaded from: classes4.dex */
public class a {
    public static void a(String str, Object obj, int i2) {
        if (obj instanceof d.a.n0.b2.d.b) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_locate", i2);
            statisticItem.param("topic_id", ((d.a.n0.b2.d.b) obj).f52070e);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.eventStat();
        }
    }
}
