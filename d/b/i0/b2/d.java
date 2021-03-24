package d.b.i0.b2;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes4.dex */
public class d {
    public static void a(String str) {
        int i = TbadkCoreApplication.getCurrentMemberType() > 0 ? 1 : 0;
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_type", i);
        TiebaStatic.log(statisticItem);
    }
}
