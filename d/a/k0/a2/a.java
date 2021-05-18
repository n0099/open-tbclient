package d.a.k0.a2;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
/* loaded from: classes4.dex */
public class a {
    public static void a(String str, Object obj, int i2) {
        if (obj instanceof d.a.k0.a2.d.b) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_locate", i2);
            statisticItem.param("topic_id", ((d.a.k0.a2.d.b) obj).f51903e);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.eventStat();
        }
    }
}
