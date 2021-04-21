package d.b.j0.a2;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
/* loaded from: classes3.dex */
public class a {
    public static void a(String str, Object obj, int i) {
        if (obj instanceof d.b.j0.a2.d.b) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_locate", i);
            statisticItem.param("topic_id", ((d.b.j0.a2.d.b) obj).f53475e);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.eventStat();
        }
    }
}
