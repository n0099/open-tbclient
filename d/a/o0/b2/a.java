package d.a.o0.b2;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
/* loaded from: classes5.dex */
public class a {
    public static void a(String str, Object obj, int i2) {
        if (obj instanceof d.a.o0.b2.d.b) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_locate", i2);
            statisticItem.param("topic_id", ((d.a.o0.b2.d.b) obj).f55884e);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.eventStat();
        }
    }
}
